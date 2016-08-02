package haibuzou.customizeview.view;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.view.View;

import haibuzou.customizeview.R;

public class ColorFilterView extends View {

    private Paint mPaint;
    private Paint porterColorPaint;
    private int w;
    private int h;
    private int radius = 100;
    private Bitmap bitmap;
    private Bitmap jugg;

    public ColorFilterView(Context context) {
        this(context,null);
    }

    public ColorFilterView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ColorFilterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setARGB(255,255,128,103);
        mPaint.setAntiAlias(true);
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                1.438F, -0.122F, -0.016F, 0, -0.03F,
                -0.062F, 1.378F, -0.016F, 0, 0.05F,
                -0.062F, -0.122F, 1.483F, 0, -0.02F,
                0, 0, 0, 1, 0,
        }
        );
        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.sanji);
        jugg = BitmapFactory.decodeResource(context.getResources(),R.drawable.jugg);
        //光照颜色过滤
        LightingColorFilter lightingColorFilter = new LightingColorFilter(0xFFFF00FF, 0x00000000);
//        mPaint.setColorFilter(lightingColorFilter);


        porterColorPaint = new Paint();
        porterColorPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DARKEN));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(radius+5,radius+5,radius,mPaint);
        canvas.drawBitmap(bitmap,0,2*radius+10,mPaint);
        canvas.drawBitmap(jugg,0,2*radius+10+bitmap.getHeight()+10,porterColorPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec),
                MeasureSpec.getSize(heightMeasureSpec)
        );
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.w = w;
        this.h = h;
    }
}
