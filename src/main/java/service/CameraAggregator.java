package service;

import model.Camera;

import java.io.IOException;
import java.util.List;

public interface CameraAggregator {

    List<String> aggregateCamerasData(String url) throws IOException;

}
