package helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Camera;
import model.ResultValue;
import model.SourceData;
import model.TokenData;

import java.io.IOException;
import java.net.URL;

public class JsonHelper {

    private ObjectMapper objectMapper = new ObjectMapper();

    public Camera[] deserializeCameras(String url) throws IOException {
        return objectMapper.readValue(new URL(url), Camera[].class);
    }

    public SourceData deserializeSourceData(String url) throws IOException {
        return objectMapper.readValue(new URL(url), SourceData.class);
    }

    public TokenData deserializeTokenData(String url) throws IOException {
        return objectMapper.readValue(new URL(url), TokenData.class);
    }

    public String serializeToResultString(ResultValue resultValue) throws JsonProcessingException {
        return objectMapper.writeValueAsString(resultValue);
    }

}
