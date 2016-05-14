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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        log = (TextView) findViewById(R.id.view_log);
        log.setMovementMethod(new ScrollingMovementMethod());
        shapeLayout = (RelativeLayout) findViewById(R.id.shape_layout);

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

        Button compile_button = (Button) findViewById(R.id.button_compile);
        compile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lineNum++;
                input = (EditText) findViewById(R.id.view_input);
                currentText += Integer.toString(lineNum) + ": " + input.getText() + "\n";
                log.setText(currentText);
            }
        });

        Button filler = (Button) findViewById((R.id.filler));
        filler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShapeFactory BWShapeFactory = AbstractShapeFactory.getShapeFactory(1);
                Shape BWRectangle = BWShapeFactory.getRectangle(context, 100, 100, 200, 200);
                ShapeFactory BGShapeFactory = AbstractShapeFactory.getShapeFactory(2);
                Shape BGRectangle = BGShapeFactory.getRectangle(context, 300, 100, 400, 200);
                ShapeFactory shapeFactory = AbstractShapeFactory.getShapeFactory(3);
                Shape RORectangle = shapeFactory.getRectangle(context, 500, 100, 600, 200);

                shapeLayout.addView(BWRectangle);
                shapeLayout.addView(BGRectangle);
                shapeLayout.addView(RORectangle);
            }
        });
    }
}

