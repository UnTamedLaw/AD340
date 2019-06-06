package com.lawk.async;

public class Camera {
    private String cameraName;
    private String imageURL;
    private String type;

    public Camera(String cameraName, String imageURL, String type) {
        this.cameraName = cameraName;
        this.imageURL = imageURL;
        this.type = type;
    }

    public String getCameraName() {
        return cameraName;
    }
    public String getImageURL() {
        return imageURL;
    }


    public String getType() {
        return type;
    }
}
