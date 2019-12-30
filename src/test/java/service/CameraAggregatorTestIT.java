package service;

import helper.JsonHelper;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CameraAggregatorTestIT {

    private CameraAggregator cameraAggregator = new CameraAggregatorImpl(new JsonHelper());

    private static final String URL = "http://www.mocky.io/v2/5c51b9dd3400003252129fb5";

    private static final String EXPECTED_STRING = "[{\"id\":1,\"urlType\":\"LIVE\",\"videoUrl\":\"rtsp://127.0.0.1/1\",\"value\":\"fa4b588e-249b-11e9-ab14-d663bd873d93\",\"ttl\":\"120\"}, {\"id\":20,\"urlType\":\"ARCHIVE\",\"videoUrl\":\"rtsp://127.0.0.1/2\",\"value\":\"fa4b5b22-249b-11e9-ab14-d663bd873d93\",\"ttl\":\"60\"}, {\"id\":3,\"urlType\":\"ARCHIVE\",\"videoUrl\":\"rtsp://127.0.0.1/3\",\"value\":\"fa4b5d52-249b-11e9-ab14-d663bd873d93\",\"ttl\":\"120\"}, {\"id\":2,\"urlType\":\"LIVE\",\"videoUrl\":\"rtsp://127.0.0.1/20\",\"value\":\"fa4b5f64-249b-11e9-ab14-d663bd873d93\",\"ttl\":\"180\"}]";

    @Test
    public void aggregateCamerasDataTest() throws IOException {
        long before = System.currentTimeMillis();
        List<String> result = cameraAggregator.aggregateCamerasData(URL);
        long spentSeconds = (System.currentTimeMillis() - before) / 1000;
        assertEquals(EXPECTED_STRING, result.toString());
        assertTrue(spentSeconds <= 2);
    }
}
