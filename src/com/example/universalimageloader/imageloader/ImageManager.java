package com.example.universalimageloader.imageloader;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.example.universalimageloader.core.DisplayImageOptions;
import com.example.universalimageloader.core.ImageLoader;
import com.example.universalimageloader.core.ImageLoaderConfiguration;
import com.example.universalimageloader.core.listener.ImageLoadingListener;

public class ImageManager 
{
	private static ImageManager imageloader;
	private DisplayImageOptions options;

	private ImageManager()
	{
		options =ImageManagerOptionsBuilder.getImageOptions();
 	}
	
	public static ImageManager getInstance()
	{
		if(imageloader == null)
		{
 			imageloader = new ImageManager();
 		}
		
		return imageloader;
	}
	
	
	/***
	 * 初始化加载UIApplication 调用
	 * @param configuration
	 */
    public void init(ImageLoaderConfiguration configuration)
    {
    	ImageLoader.getInstance().init(configuration);
     }
	
	/***
	 * imageview显示图片
	 * 用于和imageView绑定
	 * ImageLoadingListener 用户回调返回图片及其状态
	 * @param uri
	 * @param imageView
	 * @param listener
	 */
	public void displayImage(String url, ImageView imageView, ImageLoadingListener listener)
	{
		ImageLoader.getInstance().displayImage( url, imageView,options,listener);
 	}
	
  	
	/***
	 * imageview显示图片
	 * 用于和imageView绑定
	 * @param uri
	 * @param imageView
	 * @param listener
	 */
	public void displayImage(String url,ImageView imageView)
	{
		ImageLoader.getInstance().displayImage( url, imageView,options);
  	}
	
	/***
	 * 加载图片Listener 方式返回
	 * @param url
	 * @param listener
	 */
	public void loadImage(String url ,ImageLoadingListener listener)
	{
		ImageLoader.getInstance().loadImage(url, options,listener);
 	}
	
	/***
	 * 加载图片
	 * @param url
	 */
	public Bitmap loadImageSync(String url)
	{
  		return ImageLoader.getInstance().loadImageSync(url);
 	}
	
	public boolean hasImage(String url)
	{
		return ImageLoader.getInstance().loadImageSync(url) !=null? true :false;
 	}
	
 	/***
	 * 下载图片 异步
	 * @param url
	 */
	public void downLoadImage(String url)
	{
		ImageLoader.getInstance()
		.loadImage(url, options,null);
 	}
	
    /***
     * 暂停
     */
	public void pause()
	{
 		ImageLoader.getInstance().pause();
	}
	
	/***
	 * 恢复
	 */
	public void resume()
	{
		ImageLoader.getInstance().resume();
	}
	
	/***
	 * 停止
	 */
	public void stop()
	{
		ImageLoader.getInstance().stop();
 	}
	
    
 	
}
