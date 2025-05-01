import java.util.*;

public class CampusNavigationSystem {

    public static void main(String[] args) {
        // Create a new graph for the campus layout
        Graph graph = new Graph();

        // Add locations (nodes)
        graph.addLocation("SE Department");
        graph.addLocation("Rumi Block");
        graph.addLocation("Basketball Court");
        graph.addLocation("Admin Block");
        graph.addLocation("Globe Chowk");
        graph.addLocation("Library");
        graph.addLocation("Israr Block");

        // Add paths (edges) with distances
        graph.addPath("SE Department", "Rumi Block", 120);
        graph.addPath("Rumi Block", "Basketball Court", 77);
        graph.addPath("Basketball Court", "Admin Block", 26);
        graph.addPath("Basketball Court", "Globe Chowk", 100);
        graph.addPath("Globe Chowk", "Library", 170);
        graph.addPath("SE Department", "Israr Block", 130);
        graph.addPath("Israr Block", "Globe Chowk", 150);

        // Display the campus layout with a greeting
        System.out.println("Welcome to HITEC University Navigation System!");
        System.out.println("-------------------------------------------------");

        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Show menu options
        boolean exit = false;
        while (!exit) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. View all locations and stops");
            System.out.println("2. Find the shortest path between two locations");
            System.out.println("3. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Display all locations and paths
                    System.out.println("\nCampus Locations and Paths:");
                    graph.displayGraph();
                    break;

                case 2:
                    // Get user input for source and destination to find the shortest path
                    System.out.print("\nEnter your current location: ");
                    String startLocation = scanner.nextLine();

                    System.out.print("Enter your destination: ");
                    String endLocation = scanner.nextLine();

                    // Check if the locations exist in the graph
                    if (!graph.adjacencyList.containsKey(startLocation) || !graph.adjacencyList.containsKey(endLocation)) {
                        System.out.println("One or both locations are not valid.");
                        break;
                    }

                    // Display the shortest path and distance from the source to the destination
                    System.out.println("\nCalculating the shortest path from " + startLocation + " to " + endLocation + "...");
                    List<String> shortestPath = graph.getShortestPath(startLocation, endLocation);
                    int totalDistance = 0;

                    // Calculate the total distance of the shortest path
                    for (int i = 0; i < shortestPath.size() - 1; i++) {
                        String from = shortestPath.get(i);
                        String to = shortestPath.get(i + 1);
                        for (Graph.Edge edge : graph.adjacencyList.get(from)) {
                            if (edge.destination.equals(to)) {
                                totalDistance += edge.distance;
                                break;
                            }
                        }
                    }

                    // Output the result
                    System.out.println("Shortest Path: " + String.join(" -> ", shortestPath));
                    System.out.println("Total Distance: " + totalDistance + " meters");
                    break;

                case 3:
                    // Exit the program with a message
                    System.out.println("\nThank you for using the HITEC University Navigation System!");
                    System.out.println("Safe travels! Goodbye.");
                    exit = true;
                    break;

                default:
                    System.out.println("\nInvalid option! Please choose a valid option.");
            }
        }

        // Close the scanner to prevent memory leaks
        scanner.close();
    }
}
