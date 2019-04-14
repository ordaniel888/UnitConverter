package FileReader;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {

    private static final String ABSOLUTE_PATH =  "C:\\git\\UnitConverter\\src\\main\\resources\\ratioFiles\\";
    private final String filePath;

    public FileReader(String fileName) {
        this.filePath = ABSOLUTE_PATH + fileName;
    }

    public String read() throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(filePath));
        return new String(encoded, Charset.defaultCharset());
    }
}
