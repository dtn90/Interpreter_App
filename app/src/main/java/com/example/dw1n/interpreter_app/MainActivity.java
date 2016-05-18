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
    Interpreter interpreter = new Interpreter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
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
                interpreter.clear();

            }
        });

        // Compile button

        Button compile_button = (Button) findViewById(R.id.button_compile);
        compile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lineNum++;
                input = (EditText) findViewById(R.id.view_input);
                if (input.getText().toString().indexOf("#") >= 0)
                {
                    currentText += Integer.toString(lineNum) + ": " + input.getText() + "\n";
                }
                else
                {
                    try {
                        interpreter.interpret(input.getText().toString());
                        currentText += Integer.toString(lineNum) + ": " + input.getText() + "\n";
                    } catch(TokenStreamRuntimeException e) {
                        currentText += Integer.toString(lineNum) + ": " + "Syntax Error! " + "\n";
                    } catch(CharStreamRuntimeException e) {
                        currentText += Integer.toString(lineNum) + ": " + "Syntax Error! " + "\n";
                    } catch(TokenizerRuntimeException e) {
                        currentText += Integer.toString(lineNum) + ": " + "Syntax Error! " + e + "\n";
                    } catch(RuntimeException e) {
                        currentText += Integer.toString(lineNum) + ": " + "Runtime Error! " + "\n";
                    }
                }


                log.setText(currentText);
            }
        });


        // This button is to check whether the creation of shapes work. Each shape takes in
        // coordinates as a parameter and the getShapeFactory takes in a style paramter 1-3

        Button filler = (Button) findViewById((R.id.filler));
        filler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentText += "*************************** \n" +
                        "  Testing Shape Creation \n" +
                        "*************************** \n";

                currentText += "rect 100 100 200 200 1 ; \n";
                currentText += "rect 300 100 400 200 2 ; \n";
                currentText += "rect 500 100 600 200 3 ; \n";

                currentText += "circle 150 300 50 1 ; \n";
                currentText += "circle 350 300 50 2 ; \n";
                currentText += "circle 550 300 50 3 ; \n";

                interpreter.interpret("rect 100 100 200 200 1 ;");
                interpreter.interpret("rect 300 100 400 200 2 ;");
                interpreter.interpret("rect 500 100 600 200 3 ;");

                interpreter.interpret("circle 150 300 50 1 ;");
                interpreter.interpret("circle 350 300 50 2 ;");
                interpreter.interpret("circle 550 300 50 3 ;");

                currentText += "*************************** \n" +
                        "Testing Variable Arithmetic \n" +
                        "*************************** \n";

                currentText += "int a = 5 ; \n";
                interpreter.interpret("int a = 5 ;");
                currentText += "Stored value: a = " +
                        Integer.toString(interpreter.getValue("a")) +"\n";

                currentText += "int b = 100 ; \n";
                interpreter.interpret("int b = 100 ;");
                currentText += "Stored value: b = " +
                        Integer.toString(interpreter.getValue("b")) +"\n";

                currentText += "int c =  a * b; \n";
                interpreter.interpret("int c = a * b ;");
                currentText += "Stored value: c = " +
                        Integer.toString(interpreter.getValue("c")) +"\n";

                currentText += "int d = ( a * b ) + b ; \n";
                interpreter.interpret("int d = ( a * b ) + b ;");
                currentText += "Stored value: d = " +
                        Integer.toString(interpreter.getValue("d")) +"\n";

                currentText += "a = ( d / b ) - ( a - 2 ) ; \n";
                interpreter.interpret("a = ( d / b ) - ( a - 2 ) ;");
                currentText += "Stored value: a = " +
                        Integer.toString(interpreter.getValue("a")) +"\n";

                log.setText(currentText);
            }
        });
    }
}

