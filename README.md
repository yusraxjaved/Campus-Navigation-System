

# 🧭 Campus Navigation System

A simple Java-based console application that helps users navigate a university campus by finding the shortest path between locations. This project models the campus as a graph and uses Dijkstra's Algorithm to compute optimal paths between nodes (locations).

 Features

- Add and display campus locations and paths  
- Find the shortest route between two points  
- Visual display of total distance and path  
- Console-based user interface  
- Built using core Java and data structures (no external libraries)

 Concepts Used

- Graph Representation (Adjacency List)  
- Dijkstra’s Algorithm for shortest path  
- Object-Oriented Programming (OOP)  
- Java Collections (Map, List, Set, PriorityQueue)

 Structure

- `CampusNavigationSystem.java` – Main program with user interface and menu system  
- `Graph.java` – Graph implementation with Dijkstra’s algorithm and helper classes

 How to Run

1. Clone the repository  
2. Compile the Java files:
   ```bash
   javac CampusNavigationSystem.java Graph.java
   ```
3. Run the main program:
   ```bash
   java CampusNavigationSystem
   ```

 Sample Locations

- SE Department  
- Rumi Block  
- Basketball Court  
- Admin Block  
- Globe Chowk  
- Library  
- Israr Block  

Preview
![WhatsApp Image 2025-05-01 at 12 22 07_98160348](https://github.com/user-attachments/assets/07dd889d-1f1c-4d00-a442-dfb4a7673029)

 Future Improvements

- GUI interface using JavaFX or Swing  
- Live map rendering  
- Location search with auto-complete  
- Save/load map data from file
