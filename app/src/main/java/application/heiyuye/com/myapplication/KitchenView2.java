package application.heiyuye.com.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liucr on 2016/10/22.
 */

public class KitchenView2 extends FrameLayout {

    private List<ImageView> imageViewList;

    public KitchenView2(Context context) {
        super(context);
        init();
    }

    public KitchenView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public KitchenView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {

        imageViewList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(imageView);
            imageViewList.add(imageView);
        }
        int i = 0;

        imageViewList.get(i++).setImageBitmap(readBitMap(R.mipmap.kitchen_main_bg_none));
        imageViewList.get(i++).setImageBitmap(readBitMap(R.mipmap.kitchen_main_microwave_oven));
        imageViewList.get(i++).setImageBitmap(readBitMap(R.mipmap.kitchen_main_oven));
        imageViewList.get(i++).setImageBitmap(readBitMap(R.mipmap.kitchen_main_rangehood));
        imageViewList.get(i++).setImageBitmap(readBitMap(R.mipmap.kitchen_main_steam_machine));
        imageViewList.get(i++).setImageBitmap(readBitMap(R.mipmap.kitchen_main_steamer));
        imageViewList.get(i++).setImageBitmap(readBitMap(R.mipmap.kitchen_main_sterilizer));
        imageViewList.get(i++).setImageBitmap(readBitMap(R.mipmap.kitchen_main_stove));


        imageViewList.get(i++).setImageBitmap(readBitMap(R.mipmap.kitchen_main_microwave_oven_flash));
        imageViewList.get(i++).setImageBitmap(readBitMap(R.mipmap.kitchen_main_oven_flash));
        imageViewList.get(i++).setImageBitmap(readBitMap(R.mipmap.kitchen_main_rangehood_flash));
        imageViewList.get(i++).setImageBitmap(readBitMap(R.mipmap.kitchen_main_steam_machine_flash));
        imageViewList.get(i++).setImageBitmap(readBitMap(R.mipmap.kitchen_main_steamer_flash));
        imageViewList.get(i++).setImageBitmap(readBitMap(R.mipmap.kitchen_main_sterilizer_flash));
        imageViewList.get(i++).setImageBitmap(readBitMap(R.mipmap.kitchen_main_stove_flash));


    }

    public Bitmap readBitMap(int resId) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
//        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;

        Rect rect = new Rect();
        rect.contains(0,0,100,100);

        //获取资源图片
        InputStream is = getContext().getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is, rect, opt);
    }

}
