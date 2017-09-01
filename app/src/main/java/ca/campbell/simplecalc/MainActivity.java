package ca.campbell.simplecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

//  TODO: add buttons & methods for subtract, multiply, divide
//  TODO: extra input validation: no divide by zero

//  TODO: add a clear button that will clear the result & input fields

//  TODO: the hint for the result widget is hard coded, put it in the strings file

public class MainActivity extends AppCompatActivity {
    EditText etNum1, etNum2;
    TextView result;
    double num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get a handle on the text fields
        etNum1 = (EditText) findViewById(R.id.num1);
        etNum2 = (EditText) findViewById(R.id.num2);
        result = (TextView) findViewById(R.id.result);
    }  //onCreate()

    // TODO: input validation: set text to show error
    public void addNums(View v) {

        if(isNumber(etNum1.getText().toString()) && isNumber(etNum2.getText().toString())) {
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());

            result.setText(Double.toString(num1 + num2));
        }
        else
            result.setText("Please enter valid numbers");
    }  //addNums()

    public void subtractNums(View v)
    {
        if(isNumber(etNum1.getText().toString()) && isNumber(etNum2.getText().toString())) {
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());

            result.setText(Double.toString(num1 + num2));
        }
        result.setText(Double.toString(num1 - num2));
    }

    public void multiplyNums(View v)
    {
        if(isNumber(etNum1.getText().toString()) && isNumber(etNum2.getText().toString())) {
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());

            result.setText(Double.toString(num1 + num2));
        }
        result.setText(Double.toString(num1 * num2));
    }

    public void divideNums(View v)
    {

        if(isNumber(etNum1.getText().toString()) && isNumber(etNum2.getText().toString())) {
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());

            result.setText(Double.toString(num1 + num2));
        }
        if(num2 == 0)
            result.setText("Can't divide by 0.");
        else
            result.setText(Double.toString(num1 / num2));
    }

    public void clearNums(View v)
    {
        etNum1.setText("");
        etNum2.setText("");

        result.setText("");
    }

    public boolean isNumber(String text)
    {
        if(text.matches("-?[0-9]+"))
            return true;
        return false;
    }

}