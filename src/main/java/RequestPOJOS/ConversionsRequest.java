package RequestPOJOS;

import FileReader.FileReader;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class ConversionsRequest {

    @JsonProperty(value = "conversionRatios", required = true)
    private List<ConversionRatio> conversionRatios;

    @JsonProperty(value = "UnitsToConvert", required = true)
    private List<UnitToConvert> unitsToConvert;

    @JsonCreator
    private ConversionsRequest(
            @JsonProperty(value = "conversionRatios", required = true) List<ConversionRatio> conversionRatios,
            @JsonProperty(value = "UnitsToConvert", required = true) List<UnitToConvert> unitsToConvert) {
        this.conversionRatios = conversionRatios;
        this.unitsToConvert = unitsToConvert;
    }

    public static ConversionsRequest fromFile(String fileName) throws IOException {
        String strJson = new FileReader(fileName).read();
        return new ObjectMapper().readValue(strJson, ConversionsRequest.class);
    }

    public List<ConversionRatio> conversionRatios() {
        return conversionRatios;
    }

    public List<UnitToConvert> unitsToConvert() {
        return unitsToConvert;
    }
}
