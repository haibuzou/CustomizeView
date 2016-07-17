package haibuzou.customizeview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


public class FirstView extends View {

    private float clickX;
    private float clickY;
    private Paint paint;
    private int w;
    private int h;

    public FirstView(Context context) {
        this(context,null);
    }

    public FirstView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public FirstView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(w/2,h/2,50,paint);
        super.onDraw(canvas);
    }


    //默认不支持wrap_content  如果设置成wrap_content 计算大小的结果与 match_parent一样
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.w = w;
        this.h = h;
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
