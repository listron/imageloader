package com.example.imageloadertest;

import android.app.Application;

import com.example.universalimageloader.core.ImageLoaderConfiguration;
import com.example.universalimageloader.imageloader.ImageManager;
import com.example.universalimageloader.imageloader.ImageManagerOptionsBuilder;

public class imageTestApplication extends Application {

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		ImageLoaderConfiguration config = ImageManagerOptionsBuilder.getImageLoaderConfigurationOptions(this.getApplicationContext());
		ImageManager.getInstance().init(config);
	}

}
