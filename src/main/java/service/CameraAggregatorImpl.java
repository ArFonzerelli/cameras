package service;

import helper.JsonHelper;
import model.Camera;
import model.ResultValue;
import model.SourceData;
import model.TokenData;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CameraAggregatorImpl implements CameraAggregator {

    private JsonHelper jsonHelper;

    public CameraAggregatorImpl(JsonHelper jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

    @Override
    public List<String> aggregateCamerasData(String Url) throws IOException {
        Camera[] cameras = jsonHelper.deserializeCameras(Url);

        return Arrays.stream(cameras).parallel().map(camera -> {
            try {
                SourceData sourceData = jsonHelper.deserializeSourceData(camera.getSourceDataUrl());
                TokenData tokenData = jsonHelper.deserializeTokenData(camera.getTokenDataUrl());

                return jsonHelper.serializeToResultString
                        (new ResultValue(camera.getId(), sourceData.getUrlType(), sourceData.getVideoUrl(), tokenData.getValue(), tokenData.getTtl()));

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }).filter(Objects::nonNull).collect(Collectors.toList());

    }

}
