package com.example.dw1n.interpreter_app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by dw1n on 5/14/2016.
 */
public class BlueGreenCircle extends Shape {
    private Paint paint;
    int blue = Color.argb(255, 0, 0, 255);
    int green = Color.argb(255, 0, 255, 0);
    int cx, cy, r = 0;

    public BlueGreenCircle(Context context, int x_coord, int y_cood, int radius) {
        super(context);
        cx = x_coord;
        cy = y_cood;
        r = radius;
    }
    @Override
    public void onDraw(Canvas canvas) {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(blue);
        canvas.drawCircle(cx, cy, r, paint);

        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(green);
        canvas.drawCircle(cx, cy, r-10, paint);
    }
}
