package mainExecutor;
import RequestPOJOS.ConversionRequest;
import RequestPOJOS.ConversionsRequest;
import ratioGraph.RatioGraph;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ConversionsRequest request = ConversionsRequest.fromFile("5.json");
        RatioGraph ratioGraph = new RatioGraph(request.getConversionRatios());

        for (ConversionRequest curr : request.getConversionRequests()) {
            double ratio = ratioGraph.breadthFirstTraversal(curr.getSrc(),curr.getDest());
            System.out.println(curr.getSrc() + " -> " + curr.getDest() + " : " + ratio*curr.getAmount());
        }
    }
}
