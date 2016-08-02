package haibuzou.customizeview.view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class LayerView extends View {
    private Paint firstPaint;
    private Paint secondPaint;

    public LayerView(Context context) {
        this(context,null);
    }

    public LayerView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LayerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        firstPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        secondPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        secondPaint.setColor(Color.BLUE);
        firstPaint.setColor(Color.RED);
    }


    @Override
    protected void onDraw(Canvas canvas) {
    }
}
