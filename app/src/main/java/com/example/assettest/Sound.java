package com.example.assettest;

public class Sound {
    private String mAssetPath;
    private String mName;

    public Sound(String assetPath) {
        mAssetPath = assetPath;
        String [] components = assetPath.split("/");
        String fileName = components[components.length -1];
        mName = fileName.replace(".wav","");
    }

    public String getAssetPath() {
        return mAssetPath;
    }

    public void setAssetPath(String assetPath) {
        mAssetPath = assetPath;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
