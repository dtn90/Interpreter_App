package com.example.dw1n.interpreter_app;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    String currentText = "";
    int lineNum = 0;
    RelativeLayout shapeLayout;
    TextView log;
    EditText input;
    private Context context;
    Interpreter interpreter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;

        setContentView(R.layout.activity_main);
        interpreter = new Interpreter(context);
        log = (TextView) findViewById(R.id.view_log);
        log.setMovementMethod(new ScrollingMovementMethod());
        shapeLayout = (RelativeLayout) findViewById(R.id.shape_layout);

        // Clear button, removes all shapes from the layout and resets the ouput box
        // Needs to be implemented to reset all the variables

        Button clear_button = (Button) findViewById(R.id.button_clear);
        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lineNum = 0;
                currentText = "";
                log.setText(currentText);
                shapeLayout.removeAllViews();

            }
        });

        // Compile button

        Button compile_button = (Button) findViewById(R.id.button_compile);
        compile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lineNum++;
                // Parse input
                // If input is not within language output error message
                // create and add shape to relative layout
                input = (EditText) findViewById(R.id.view_input);
                interpreter.interpret(input.getText().toString());

//                currentText += Integer.toString(lineNum) + ": " + input.getText() + "\n";

                log.setText(input.getText());
            }
        });


        // This button is to check whether the creation of shapes work. Each shape takes in
        // coordinates as a parameter and the getShapeFactory takes in a style paramter 1-3

        Button filler = (Button) findViewById((R.id.filler));
        filler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShapeFactory BWShapeFactory1 = AbstractShapeFactory.getShapeFactory(1);
                Shape BWRectangle = BWShapeFactory1.getRectangle(context, 100, 100, 200, 200);
                ShapeFactory BGShapeFactory1 = AbstractShapeFactory.getShapeFactory(2);
                Shape BGRectangle = BGShapeFactory1.getRectangle(context, 300, 100, 400, 200);
                ShapeFactory shapeFactory1 = AbstractShapeFactory.getShapeFactory(3);
                Shape RORectangle = shapeFactory1.getRectangle(context, 500, 100, 600, 200);

                ShapeFactory BWShapeFactory2 = AbstractShapeFactory.getShapeFactory(1);
                Shape BWCircle = BWShapeFactory2.getCircle(context, 150, 300, 50);
                ShapeFactory BGShapeFactory2 = AbstractShapeFactory.getShapeFactory(2);
                Shape BGCircle = BGShapeFactory2.getCircle(context, 350, 300, 50);
                ShapeFactory ROShapeFactory2 = AbstractShapeFactory.getShapeFactory(3);
                Shape ROCircle = ROShapeFactory2.getCircle(context, 550, 300, 50);

                shapeLayout.addView(BWRectangle);
                shapeLayout.addView(BGRectangle);
                shapeLayout.addView(RORectangle);

                shapeLayout.addView(BWCircle);
                shapeLayout.addView(BGCircle);
                shapeLayout.addView(ROCircle);
            }
        });
    }
}

