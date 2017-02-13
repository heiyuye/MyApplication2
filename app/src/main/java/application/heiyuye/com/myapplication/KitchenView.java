package application.heiyuye.com.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by liucr on 2016/10/22.
 */

public class KitchenView extends View {

    private Bitmap kitchenBg;

    public KitchenView(Context context) {
        this(context, null);
    }

    public KitchenView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public KitchenView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        kitchenBg = readBitMap(getContext(), R.mipmap.kitchen_main_bg_none);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        Picture picture = new Picture();
        canvas.drawPicture(picture);
        kitchenBg = readBitMap(getContext(), R.mipmap.kitchen_main_bg_none);
        canvas.drawBitmap(kitchenBg, new Rect(0, 0, 1300, 1820), new Rect(0, 0, 1300, 1820), new Paint());

        kitchenBg = readBitMap(getContext(), R.mipmap.kitchen_main_microwave_oven);
        canvas.drawBitmap(kitchenBg, new Rect(0, 0, 1300, 1820), new Rect(0, 0, 1300, 1820), new Paint());

        if (!kitchenBg.isRecycled()) {
            kitchenBg.recycle();
            kitchenBg = null;
        }
    }

    public static Bitmap readBitMap(Context context, int resId) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
//        opt.inPreferredConfig = Bitmap.Config.;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        //获取资源图片
        InputStream is = context.getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is, null, opt);
    }

}
