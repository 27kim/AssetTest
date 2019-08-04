package com.example.assettest;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox {
    private static final String TAG = "BeatBox";
    private static final String SOUNDS_FOLDER = "sample_sounds";
    private List<Sound> mSounds = new ArrayList<>();

    private AssetManager mAssetManager;
    public BeatBox(Context context) {
        mAssetManager = context.getAssets();
        loadSounds();
    }

    private void loadSounds() {
        String [] soundNames;
        try{
            soundNames = mAssetManager.list(SOUNDS_FOLDER);
            Log.i(TAG,"found " + soundNames.length + " sounds.");
        }catch (IOException ioe){
            Log.e(TAG, "Could not list assets", ioe);
            return;
        }

        for(String fileName: soundNames){
            String assetPath = SOUNDS_FOLDER + "/" + fileName;
            Sound sound = new Sound(assetPath);
            mSounds.add(sound);
        }
    }

    public List<Sound> getSounds() {
        return mSounds;
    }
}
