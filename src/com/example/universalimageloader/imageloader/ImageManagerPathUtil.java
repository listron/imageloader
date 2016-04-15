package com.example.universalimageloader.imageloader;

import java.io.File;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;

public class ImageManagerPathUtil
{
	public static String getDiskCacheDir(Context context, String uniqueName)
	{

		final String cachePath = isExternalStorageEnable() ? context.getExternalCacheDir().getPath() : context.getCacheDir().getPath();

		if (TextUtils.isEmpty(cachePath))
		{
			return null;
		}

		return TextUtils.isEmpty(uniqueName) ? cachePath : cachePath + File.separator + uniqueName;
	}

	public static boolean isExternalStorageEnable()
	{
		return isExternalStorageMounted() || !isExternalStorageRemovable();
	}

	public static boolean isExternalStorageMounted()
	{
		String state = Environment.getExternalStorageState();
		if (state != null && state.equals(Environment.MEDIA_MOUNTED))
		{
			return true;
		}
		return false;
	}

	/**
	 * Check if external storage is built-in or removable.
	 *
	 * @return True if external storage is removable (like an SD card), false
	 *         otherwise.
	 */
	@SuppressLint("NewApi")
	public static boolean isExternalStorageRemovable()
	{
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD)
		{
			return Environment.isExternalStorageRemovable();
		}
		return true;
	}

}
