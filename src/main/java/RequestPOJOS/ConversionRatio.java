package RequestPOJOS;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ConversionRatio {
    @JsonProperty(value = "src", required = true)
    private String src;

    @JsonProperty(value = "dest", required = true)
    private String dest;

    @JsonProperty(value = "ratio", required = true)
    private double ratio;

    @JsonCreator
    public ConversionRatio(@JsonProperty(value = "src", required = true) String src,
                             @JsonProperty(value = "dest", required = true) String dest,
                             @JsonProperty(value = "ratio", required = true) double ratio) {
        this.src = src;
        this.dest = dest;
        this.ratio = ratio;
    }

    public String src() {
        return src;
    }

    public String dest() {
        return dest;
    }

    public double ratio() {
        return ratio;
    }
}
