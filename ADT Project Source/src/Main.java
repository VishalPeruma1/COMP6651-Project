import Data.Graph;
import FileIO.GraphReader;
import FileIO.GraphSaver;
import GraphGeneration.Generator;
import LCC.LCCStats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--------------------------------");
            System.out.println("Menu");
            System.out.println("1. Find Optimal R");
            System.out.println("2. Generate Custom Graph");
            System.out.println("3. Run Simulation");
            System.out.println("4. Run All Simulations");
            System.out.println("5. Quit");
            System.out.println("Your choice: ");
            int input = Integer.parseInt(sc.nextLine());
            switch (input) {
                default : return;
                case 1  : findOptimal(sc);break;
                case 2  : generateCustomGraph(sc);break;
                case 3  : simulate(sc); break;
                case 4  : simulateAll(); break;
            }
        }
    }

    private static void findOptimal(Scanner sc){
        System.out.println("Enter N");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println("Enter MinComp Mult");
        float minComp = Float.parseFloat(sc.nextLine()) * n;
        System.out.println("Enter MaxComp Mult");
        float maxComp = Float.parseFloat(sc.nextLine()) * n;
        new CustomGeneration(n).findOptimal(0,1, minComp,maxComp);
    }

    private static void generateCustomGraph(Scanner sc){
        System.out.println("Enter N");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println("Enter R");
        float r = Float.parseFloat(sc.nextLine());
        var g = Generator.generateGraph(n, r);
        System.out.println("Enter filename");
        GraphSaver.saveGraph(g, sc.nextLine());
    }

    private static void simulate(Scanner sc){
        System.out.println("Enter file name to use");
        System.out.println("Built-in Available: ");
        System.out.println("\tDSJC500-5.mtx");
        System.out.println("\tinf-euroroad.edges");
        System.out.println("\tinf-power.mtx");
        System.out.println("\tcustom_300.edges");
        System.out.println("\tcustom_400.edges");
        System.out.println("\tcustom_500.edges");

        var filename = sc.nextLine();
        System.out.println("Simulating for " + filename);
        simulateForGraph(filename);
    }

    private static void simulateAll(){
        var files = new ArrayList<>(Arrays.asList("DSJC500-5.mtx","inf-euroroad.edges","inf-power.mtx",
                "custom_300.edges","custom_400.edges", "custom_500.edges"));

        System.out.println("Go grab some tea, this will take a while :p");
        var completed = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(files.size());
        for(var file : files){
            executorService.submit(new SimulationRunner(file, completed));
        }
        try{

            boolean lol=false;
            while (completed.get() < files.size()){
                Thread.sleep(1000);
                if(lol)
                    System.out.println("Status - Completed : " + completed + " / " + files.size());
                else
                    System.out.println("Status | Completed : " + completed + " / " + files.size());

                lol = !lol;
            }
            executorService.shutdown();
            System.out.println("All done! woohoo!!");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void simulateForGraph(String filename){
        var g = GraphReader.readGraph(filename);
        var stats = new LCCStats(g);
        stats.simulate();
    }
}