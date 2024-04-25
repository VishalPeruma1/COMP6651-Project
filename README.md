
# COMP6651-Project
This is a JAVA implementation for the COMP 6551 project for winter term 2024

## Build Requirements
- **JDK 21**
    The project uses features of Java that are only only availble from JDK 20, onwards. while it should be perfectly fine using JDK 20, JDK 21 is preferred. **Any version below 20 will fail compilation**.
- **Editor of choice** (**Jetbrains Intelli-J** preferred as it is what we used for development)

## How to run
- On running the application you will be presented with a menu
- Select the choice of function you would like to run by entering the number associated with each item.
- Follow and input the on-screen requirements for each function.
## Function Descriptions
#### Find R (Option 1)
This function lets you find an optimal **R** using Binary Search for a given value of **N**
#### Generate Custom Graph (Option 2)
This function generates a graph for a given **N** and **R**, Once the graph is generated, a filename will be requested which will be used create the edges file for the generated graph
#### Run Simulation (Option 3)

This function runs the simulation for a single graph file, the filename is requested the simulation is started. The simulation will store the results as CSV at **{Project Dir}/resources/output** with the name **output_{Input Graph File Name}_{DD-MM-YY-HH-mm-ss}.csv**.
#### Run Simulation All (Option 4)
This runs simulation for the following files
1. DSJC500-5.mtx
2. INF-EUROROAD.edges
3. INF-POWER.mtx
4. Custom_300.edges
5. Custom_400.edges
6. Custom_500.edges
 
**Note**: This function will take a while to complete, so grabbing a cup of tea is suggested while running this function :)

#### Quit (Option 5)
quits the application.

## Graph Directory
All the graphs for the simulation are present in **{Project Dir}/resources/graphs**
Following graphs are present by default
1. DSJC500-5.mtx
2. INF-EUROROAD.edges
3. INF-POWER.mtx
4. Custom_300.edges
5. Custom_400.edges
6. Custom_500.edges

## Output
The output of the simulation can be found at 
**{Project Dir}/resources/output** 
with the name **output_{Input Graph File Name}_{DD-MM-YY-HH-mm-ss}.csv**.
This can be then open in the spreadsheet of your choice.  An example output result table is shown below.

|Algorithms.       |n  |r          |LCC Vertices |LCC Average Degree|Max Degree|LMax|
|------------------|---|-----------|-------------|------------------|----------|----|
|DFS Heuristic.    |300|0.02641821 |143          |11                |16        |35  |
|Dijkstra Heuristic|300|0.02641821 |143          |11                |16        |102 |
|A* Heuristic      |300|0.02641821 |143          |11                |16        |27  |
|BFS Heuristic.    |300 |0.02641821|143          |11                |16        |27  |