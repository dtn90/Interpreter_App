package com.example.dw1n.interpreter_app;

import android.content.Context;

/**
 * Created by dw1n on 5/13/2016.
 */
public class BlackWhiteShapeFactory extends ShapeFactory{
    @Override
    public Shape getCircle(Context context, int x_coord, int y_coord, int radius) {
        return new BlackWhiteCircle(context, x_coord, y_coord, radius);
    }

    @Override
    public Shape getRectangle(Context context, int x1_coord,
                              int y1_coord, int x2_coord, int y2_coord) {
        return new BlackWhiteRectangle(context, x1_coord, y1_coord, x2_coord, y2_coord);
    }
}
