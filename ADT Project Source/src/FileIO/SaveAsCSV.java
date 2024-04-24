package FileIO;

import java.io.*;
import java.util.Scanner;

/**
 * This class aids in reading and writing to file.
 * @author Vishal Perumal
 */
public class SaveAsCSV {
    private SaveAsCSV(){

    }

    public static boolean fileExists(String p_path){
        File l_file = new File(p_path);
        return l_file.exists();
    }

    public static boolean removeFile(String p_path){
        File l_file = new File(p_path);
        if(l_file.exists())
            return l_file.delete();

        return false;
    }

    public static boolean writeCSVFileAStar(String p_path, int n, String r, int lccVertCount, int lccAvgDeg,int maxDeg,int lMaxDFS,int lMaxBFS,int lMaxDijkstra, int lMaxAStar){
        try {
            if (p_path.isEmpty()) {
                System.out.println("Attempting to write to an empty file-path");
                return false;
            }

            FileWriter l_fileWriter = new FileWriter(p_path, false);
            String[] header = {"Algorithms","n","r","LCC Vertices", "LCC Average Degree", "Max Degree","LMax"};
            l_fileWriter.append(String.join(",", header));
            l_fileWriter.append("\n");
            l_fileWriter.append(String.join(",", "DFS Heuristic",String.valueOf(n),r,String.valueOf(lccVertCount), String.valueOf(lccAvgDeg), String.valueOf(maxDeg), String.valueOf(lMaxDFS)));
            l_fileWriter.append("\n");
            l_fileWriter.append(String.join(",", "Dijkstra Heuristic",String.valueOf(n),r,String.valueOf(lccVertCount), String.valueOf(lccAvgDeg), String.valueOf(maxDeg), String.valueOf(lMaxDijkstra)));
            l_fileWriter.append("\n");
            l_fileWriter.append(String.join(",", "A* Heuristic",String.valueOf(n),r,String.valueOf(lccVertCount), String.valueOf(lccAvgDeg), String.valueOf(maxDeg), String.valueOf(lMaxAStar)));
            l_fileWriter.append("\n");
            l_fileWriter.append(String.join(",", "BFS Heuristic",String.valueOf(n),r,String.valueOf(lccVertCount), String.valueOf(lccAvgDeg), String.valueOf(maxDeg), String.valueOf(lMaxBFS)));

            l_fileWriter.close();
            return true;
        } catch (IOException l_ex) {
            System.out.println((l_ex.getMessage()));
            return false;
        }
    }

    public static boolean writeCSVFile(String p_path, int n, String r,int lccVertCount, int lccAvgDeg,int maxDeg,int lMaxDFS,int lMaxBFS, int lMaxDijkstra){
        try {
            if (p_path.isEmpty()) {
                System.out.println("Attempting to write to an empty file-path");
                return false;
            }

            FileWriter l_fileWriter = new FileWriter(p_path, false);
            String[] header = {"Algorithms","n","r","LCC Vertices", "LCC Average Degree", "Max Degree","LMax"};
            l_fileWriter.append(String.join(",", header));
            l_fileWriter.append("\n");
            l_fileWriter.append(String.join(",", "DFS Heuristic",String.valueOf(n),r,String.valueOf(lccVertCount), String.valueOf(lccAvgDeg), String.valueOf(maxDeg), String.valueOf(lMaxDFS)));
            l_fileWriter.append("\n");
            l_fileWriter.append(String.join(",", "Dijkstra Heuristic",String.valueOf(n),r,String.valueOf(lccVertCount), String.valueOf(lccAvgDeg), String.valueOf(maxDeg), String.valueOf(lMaxDijkstra)));
            l_fileWriter.append("\n");
            l_fileWriter.append(String.join(",", "BFS Heuristic",String.valueOf(n),r,String.valueOf(lccVertCount), String.valueOf(lccAvgDeg), String.valueOf(maxDeg), String.valueOf(lMaxBFS)));

            l_fileWriter.close();
            return true;
        } catch (IOException l_ex) {
            System.out.println((l_ex.getMessage()));
            return false;
        }
    }

    public static String readCSVFile(String p_path){
        try {
            File l_file = new File(p_path);
            Scanner l_scanner = new Scanner(l_file);
            String l_data = "";
            while(l_scanner.hasNextLine()){
                l_data += l_scanner.nextLine();
            }
            l_scanner.close();
            return l_data;
        }
        catch (FileNotFoundException l_ex){
            System.out.println((l_ex.getMessage()));
        }
        return "";
    }
}
