package com.example.dw1n.interpreter_app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by dw1n on 5/13/2016.
 */
public class BlackWhiteCircle extends Shape {
    private Paint paint;
    int white = Color.argb(255, 255, 255, 255);
    int black = Color.argb(255, 0, 0, 0);
    int cx, cy, r = 0;

    public BlackWhiteCircle(Context context, int x_coord, int y_cood, int radius) {
        super(context);
        cx = x_coord;
        cy = y_cood;
        r = radius;
    }
    @Override
    public void onDraw(Canvas canvas) {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(black);
        canvas.drawCircle(cx, cy, r, paint);

        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(white);
        canvas.drawCircle(cx, cy, r-10, paint);
    }
}
