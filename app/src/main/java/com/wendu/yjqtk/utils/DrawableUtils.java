package com.wendu.yjqtk.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;

import com.wendu.yjqtk.R;

public class DrawableUtils {

	/**
	 * 创建一个图片
	 * @param contentColor 内部填充颜色
	 * @param strokeColor  描边颜色
	 * @param radius       圆角
	 */
	public static GradientDrawable createDrawable(int contentColor, int strokeColor, int radius) {
		GradientDrawable drawable = new GradientDrawable(); // 生成Shape
		drawable.setGradientType(GradientDrawable.RECTANGLE); // 设置矩形
		drawable.setColor(contentColor);// 内容区域的颜色
		drawable.setStroke(1, strokeColor); // 四周描边,描边后四角真正为圆角，不会出现黑色阴影。如果父窗体是可以滑动的，需要把父View设置setScrollCache(false)
		drawable.setCornerRadius(radius); // 设置四角都为圆角
		return drawable;
	}

	/**
	 * 创建一个图片选择器
	 * @param normalState  普通状态的图片
	 * @param pressedState 按压状态的图片
	 */
	public static StateListDrawable createSelector(Drawable normalState, Drawable pressedState) {
		StateListDrawable bg = new StateListDrawable();
		bg.addState(new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled}, pressedState);
		bg.addState(new int[]{android.R.attr.state_enabled}, normalState);
		bg.addState(new int[]{}, normalState);
		return bg;
	}

	/**
	 *
	 * @param contentColor1
	 * @param strokeColor1
	 * @param radius1
	 * @param contentColor2
	 * @param strokeColor2
     * @param radius2
     * @return
     */
	public static StateListDrawable createSelector(int contentColor1, int strokeColor1, int radius1,int contentColor2, int strokeColor2, int radius2){
		Drawable normalState = createDrawable(UIUtils.getColor(contentColor1),UIUtils.getColor(strokeColor1),radius1);
		Drawable pressedState = createDrawable(UIUtils.getColor(contentColor2),UIUtils.getColor(strokeColor2),radius2);
		StateListDrawable bg = new StateListDrawable();
		bg.addState(new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled}, pressedState);
		bg.addState(new int[]{android.R.attr.state_enabled}, normalState);
		bg.addState(new int[]{}, normalState);
		return bg;
	}

	public static StateListDrawable createSeletorCGB(int radius ){
		return createSelector(R.color.base_green,R.color.base_green,radius,R.color.base_green_deep,R.color.base_green_deep,radius);
	}
	public static StateListDrawable createSeletorTB(int radius ){
		return createSelector(R.color.transparent,R.color.transparent,radius,R.color.transparent_grey,R.color.transparent_grey,radius);
	}

	/** 获取图片的大小 */
	public static int getDrawableSize(Drawable drawable) {
		if (drawable == null) {
			return 0;
		}
		Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
			return bitmap.getByteCount();
		} else {
			return bitmap.getRowBytes() * bitmap.getHeight();
		}
	}
}
