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

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
}
