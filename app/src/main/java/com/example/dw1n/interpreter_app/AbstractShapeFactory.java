package com.example.dw1n.interpreter_app;

/**
 * Created by dw1n on 5/13/2016.
 */
public class AbstractShapeFactory {
    public static ShapeFactory getShapeFactory(int style) {
        if (style == 1) {
            return new BlackWhiteShapeFactory();
        }
//        else if (style == 2) {
//            return new BlueGreenShapeFactory();
//        }
//        else if (style == 3) {
//            return new RedOrangeShapeFactory();
//        }

        return null;
    }

}
