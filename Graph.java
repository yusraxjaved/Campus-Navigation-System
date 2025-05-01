import java.util.*;

public class Graph {

    // Use a Map to represent the adjacency list
    Map<String, List<Edge>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Add a location (node)
    public void addLocation(String location) {
        adjacencyList.putIfAbsent(location, new ArrayList<>());
    }

    // Add a path (edge) with distance
    public void addPath(String from, String to, int distance) {
        adjacencyList.get(from).add(new Edge(to, distance));
        adjacencyList.get(to).add(new Edge(from, distance)); // For undirected graph
    }

    // Display all locations and their connections
    public void displayGraph() {
        for (String location : adjacencyList.keySet()) {
            System.out.print(location + " -> ");
            for (Edge edge : adjacencyList.get(location)) {
                System.out.print(edge.destination + " (" + edge.distance + "m), ");
            }
            System.out.println();
        }
    }

    // Getter for adjacencyList to allow external access
    public Map<String, List<Edge>> getAdjacencyList() {
        return adjacencyList;
    }

    // Get the shortest path using Dijkstra's algorithm
    public List<String> getShortestPath(String start, String destination) {
        // Use a priority queue to find the shortest path using Dijkstra's algorithm
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        Set<String> visited = new HashSet<>();

        // Initialize all distances to infinity and previous nodes to null
        for (String location : adjacencyList.keySet()) {
            distances.put(location, Integer.MAX_VALUE);
            previous.put(location, null);
        }

        // Distance to the start location is 0
        distances.put(start, 0);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (visited.contains(current.name)) continue;

            visited.add(current.name);

            for (Edge edge : adjacencyList.get(current.name)) {
                int newDist = current.distance + edge.distance;

                // Update the distance if a shorter path is found
                if (newDist < distances.get(edge.destination)) {
                    distances.put(edge.destination, newDist);
                    previous.put(edge.destination, current.name);
                    pq.add(new Node(edge.destination, newDist));
                }
            }
        }

        // Reconstruct the shortest path
        List<String> path = new ArrayList<>();
        String current = destination;
        while (current != null) {
            path.add(current);
            current = previous.get(current);
        }
        Collections.reverse(path); // Reverse the list to get the correct order

        return path;
    }

    // Inner class to represent edges (paths)
    static class Edge {
        String destination;
        int distance;

        public Edge(String destination, int distance) {
            this.destination = destination;
            this.distance = distance;
        }
    }

    // Inner class to store a node (location) and its distance
    static class Node {
        String name;
        int distance;

        public Node(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }
    }
}
