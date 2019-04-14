package RequestPOJOS;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ConversionRequest {

    @JsonProperty(value = "src", required = true)
    private String src;

    @JsonProperty(value = "dest", required = true)
    private String dest;

    @JsonProperty(value = "amount", required = true)
    private double amount;

    @JsonCreator
    public ConversionRequest(@JsonProperty(value = "src", required = true) String src,
                             @JsonProperty(value = "dest", required = true) String dest,
                             @JsonProperty(value = "amount", required = true) double amount) {
        this.src = src;
        this.dest = dest;
        this.amount = amount;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
