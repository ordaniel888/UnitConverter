package RequestPOJOS;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UnitToConvert {

    @JsonProperty(value = "src", required = true)
    private String src;

    @JsonProperty(value = "dest", required = true)
    private String dest;

    @JsonProperty(value = "amount", required = true)
    private double amount;

    @JsonCreator
    public UnitToConvert(@JsonProperty(value = "src", required = true) String src,
                         @JsonProperty(value = "dest", required = true) String dest,
                         @JsonProperty(value = "amount", required = true) double amount) {
        this.src = src;
        this.dest = dest;
        this.amount = amount;
    }

    public String src() {
        return src;
    }

    public String dest() {
        return dest;
    }

    public double amount() {
        return amount;
    }
}
