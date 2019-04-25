package mainExecutor;
import RequestPOJOS.UnitToConvert;
import RequestPOJOS.ConversionsRequest;
import ratioGraph.RatioGraph;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ConversionsRequest request = ConversionsRequest.fromFile("5.json");
        RatioGraph ratioGraph = new RatioGraph(request.conversionRatios());

        for (UnitToConvert curr : request.unitsToConvert()) {
            double ratio = ratioGraph.breadthFirstTraversal(curr.src(),curr.dest());
            System.out.println(curr.src() + " -> " + curr.dest() + " : " + ratio*curr.amount());
        }
    }
}
