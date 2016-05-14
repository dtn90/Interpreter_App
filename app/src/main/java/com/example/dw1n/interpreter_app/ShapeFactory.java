package com.example.dw1n.interpreter_app;

import android.content.Context;

/**
 * Created by dw1n on 5/13/2016.
 */
public abstract class ShapeFactory {
    abstract Shape getRectangle(Context context, int x1_coord,
                                int y1_coord, int x2_coord, int y2_coord);
    abstract Shape getCircle(Context context, int x_coord, int y_coord, int radius);
}
