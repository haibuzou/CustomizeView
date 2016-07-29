package haibuzou.customizeview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


public class FirstView extends View {

    private float clickX;
    private float clickY;
    private Paint circlePaint;
    private Paint arcPaint;
    private Paint arcPaintButt;
    private int w;
    private int h;
    private int radius;
    private RectF arcRect;
    private RectF arcRectButt;

    public FirstView(Context context) {
        this(context,null);
    }

    public FirstView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public FirstView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        circlePaint = new Paint();
        circlePaint.setColor(Color.RED);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setAntiAlias(true);
        circlePaint.setStrokeWidth(5);
        circlePaint.setStrokeJoin(Paint.Join.MITER);
        /**
         * native方法 0-255
         */
        circlePaint.setAlpha(225);
        radius = 100;

        arcPaint = new Paint();
        arcPaint.setColor(Color.BLUE);
        arcPaint.setAntiAlias(true);
        arcPaint.setStrokeWidth(20);
        arcPaint.setStyle(Paint.Style.STROKE);
        arcPaint.setStrokeCap(Paint.Cap.ROUND);

        arcPaintButt = new Paint();
        arcPaintButt.setColor(Color.BLACK);
        arcPaintButt.setAntiAlias(true);
        arcPaintButt.setStrokeWidth(20);
        arcPaintButt.setStyle(Paint.Style.STROKE);
        arcPaintButt.setStrokeCap(Paint.Cap.BUTT);
        arcPaintButt.setAlpha(50);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(radius+5,radius+5,radius,circlePaint);
        canvas.drawArc(arcRect,0,180,false,arcPaint);
        canvas.drawArc(arcRectButt,0,180,true,arcPaintButt);
        super.onDraw(canvas);
    }


    //默认不支持wrap_content  如果设置成wrap_content 计算大小的结果与 match_parent一样
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int width = widthMode==MeasureSpec.AT_MOST?radius*2+50:getDefaultSize(getSuggestedMinimumWidth(),widthMeasureSpec);
        int height = heightMode==MeasureSpec.AT_MOST?radius*500:getDefaultSize(getSuggestedMinimumHeight(),heightMeasureSpec);

        setMeasuredDimension(width,height);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.w = w;
        this.h = h;
        arcRect = new RectF(20,3*radius,2*radius+20,5*radius);
        arcRectButt = new RectF(20,6*radius,2*radius+20,8*radius);
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            clickX = event.getX();
            clickY = event.getY();
        }
        return super.onTouchEvent(event);
    }

}
