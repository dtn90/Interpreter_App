package com.example.dw1n.interpreter_app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by dw1n on 5/14/2016.
 */
public class RedOrangeRectangle extends Shape {
    private Paint paint;

    int x1, x2, y1, y2 = 0;
    int red = Color.argb(255, 255, 0, 0);
    int orange = Color.argb(255, 255, 165, 0);
    Rect rectangle = new Rect();

    public RedOrangeRectangle(Context context, int x1_coord, int y1_coord, int x2_coord, int y2_coord){
        super(context);
        x1 = x1_coord;
        x2 = x2_coord;
        y1 = y1_coord;
        y2 = y2_coord;
    }

    @Override
    public void onDraw(Canvas canvas) {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(red);
        rectangle.set(x1, y1, x2, y2);
        canvas.drawRect(rectangle, paint);

        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(orange);
        rectangle.set(x1 + 10, y1 + 10, x2 - 10, y2 - 10);
        canvas.drawRect(rectangle, paint);
    }
}