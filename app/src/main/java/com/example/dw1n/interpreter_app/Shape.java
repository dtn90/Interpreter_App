package com.example.dw1n.interpreter_app;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by dw1n on 5/13/2016.
 */
abstract class Shape extends View {

    public abstract void onDraw(Canvas canvas);

    public Shape (Context context) {
        super(context);
    }

    void removeShape() {
        setVisibility(View.GONE);}

}
