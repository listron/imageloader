package com.example.universalimageloader.imageloader;

import android.content.Context;
import android.graphics.Bitmap;

import com.example.universalimageloader.core.DisplayImageOptions;
import com.example.universalimageloader.core.ImageLoaderConfiguration;
import com.example.universalimageloader.core.assist.ImageScaleType;
import com.example.universalimageloader.core.assist.QueueProcessingType;
 
public class ImageManagerOptionsBuilder
{

	public static ImageLoaderConfiguration getImageLoaderConfigurationOptions(Context context)
	{

//		String imagePath = ImageManagerPathUtil.getDiskCacheDir(context, "image");
//		File cacheDir = StorageUtils.getOwnCacheDirectory(context, imagePath);// 获取到缓存的目录地址

		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
											.threadPriority(Thread.NORM_PRIORITY - 2)
											.denyCacheImageMultipleSizesInMemory()
											 .diskCacheSize(250 * 1024 * 1024)     
 											.tasksProcessingOrder(QueueProcessingType.LIFO)
											.build();
 		return config;

	}

	public static DisplayImageOptions getImageOptions()
	{
		DisplayImageOptions options = new DisplayImageOptions.Builder()
		// 设置下载的图片是否缓存在内存中
				.cacheInMemory(true)
				// 设置下载的图片是否缓存在SD卡中
				.cacheOnDisk(true)
				// 保留Exif信息
				.considerExifParams(true)
				// 设置图片以如何的编码方式显示
//				.imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
				// 设置图片的解码类型
				.bitmapConfig(Bitmap.Config.RGB_565)
				    .imageScaleType(ImageScaleType.EXACTLY)

				// .decodingOptions(android.graphics.BitmapFactory.Options
				// decodingOptions)//设置图片的解码配置
  				// 设置图片下载前的延迟
//				.delayBeforeLoading(100)// int
 				// 设置图片加入缓存前，对bitmap进行设置
				// .preProcessor(BitmapProcessor preProcessor)
// 				.resetViewBeforeLoading(true)// 设置图片在下载前是否重置，复位
				// .displayer(new RoundedBitmapDisplayer(20))//是否设置为圆角，弧度为多少
//				.displayer(new FadeInBitmapDisplayer(100))// 淡入
				.build();
		return options;
	}

}
