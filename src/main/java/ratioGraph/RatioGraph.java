package ratioGraph;

import RequestPOJOS.ConversionRatio;
import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class RatioGraph {

    private static final int UNDIFINED_RATIO = -1;
    private Map<Vertex, List<Pair<Vertex,Double>>> adjVertices ;

    public RatioGraph(List<ConversionRatio> conversionRatios)  {
        this.adjVertices = new HashMap<>();
        int numOfRatios = conversionRatios.size();
        Set<String> vertexes = new HashSet<>();

        for (ConversionRatio curr :conversionRatios) {
            this.addVertex(curr.src());
            this.addVertex(curr.dest());
            this.addEdge(curr.src(),curr.dest(), curr.ratio());
            this.addEdge(curr.dest(),curr.src(), 1 / curr.ratio());
        }
    }

    public void addVertex(String label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }



    public void addEdge(String label1, String label2, double value) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).add(new Pair<>(v2,value));
    }

    public void removeVertex(String label) {
        Vertex v = new Vertex(label);
        adjVertices.values()
                .stream()
                .map(e -> e.remove(v))
                .collect(Collectors.toList());
        adjVertices.remove(new Vertex(label));
    }

    private List<Pair<Vertex, Double>> getAdjVertices(String label) {
        return adjVertices.get(new Vertex(label));
    }

    public double breadthFirstTraversal(String src,String dest) {
        Set<String> visited = new LinkedHashSet<String>();
        Queue<Pair<String,Double>> queue = new LinkedList<>();
        Pair<String,Double> srcVertexPair = new Pair(src,1.0);
        queue.add(srcVertexPair);
        visited.add(src);
        while (!queue.isEmpty()) {
            Pair<String,Double> vertex = queue.poll();
            for (Pair<Vertex,Double> v : this.getAdjVertices(vertex.getKey())) {
                if (!visited.contains(v.getKey().label)) {
                    visited.add(v.getKey().label);
                    Double aggregateValue = vertex.getValue() * v.getValue();
                    Pair<String,Double> vertexPair = new Pair(v.getKey().label,aggregateValue);
                    queue.add(vertexPair);
                    if (v.getKey().label.equals(dest)) {
                        return aggregateValue;
                    }
                }
            }
        }
        return UNDIFINED_RATIO;
    }
}
