package ca.campbell.simplecalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ca.campbell.simplecalc.util.Calculator;

//  DONE: add buttons & methods for subtract, multiply, divide

//  DONE: the hint for the result widget is hard coded, put it in the strings file

public class MainActivity extends AppCompatActivity {
    EditText etNum1, etNum2;
    TextView tvResult;
    double num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewsByIds();
    }

    private void findViewsByIds() {
        // get a handle on the text fields
        etNum1 = (EditText) findViewById(R.id.num1);
        etNum2 = (EditText) findViewById(R.id.num2);
        tvResult = (TextView) findViewById(R.id.result);
    }

    // DONE: input validation: set text to show error
    //  DONE: extra input validation: no divide by zero
    public void calculate(View view) {

        if (isEditTextEmpty()) {
            tvResult.setText(getString(R.string.errorEditTextEmpty));
            return;
        }
        takeInput();

        switch (view.getId()) {
            case R.id.add:
                tvResult.setText(String.valueOf(Calculator.add(num1, num2)));
                break;
            case R.id.sub:
                tvResult.setText(String.valueOf(Calculator.subtract(num1, num2)));
                break;
            case R.id.mul:
                tvResult.setText(String.valueOf(Calculator.multiply(num1, num2)));
                break;
            case R.id.div:
                try {
                    tvResult.setText(String.valueOf(Calculator.divide(num1, num2)));
                } catch (ArithmeticException ae) {
                    tvResult.setText(getString(R.string.errorDivideByZero));
                }
                break;
        }

    }

    private void takeInput() {
        num1 = Double.parseDouble(String.valueOf(etNum1.getText()));
        num2 = Double.parseDouble(String.valueOf(etNum2.getText()));
    }

    private boolean isEditTextEmpty() {
        return String.valueOf(etNum1.getText()).isEmpty() || String.valueOf(etNum2.getText()).isEmpty();
    }

    //  DONE: add a clear button that will clear the result & input fields
    public void clear(View view) {
        etNum1.setText("");
        etNum2.setText("");
        tvResult.setText(getString(R.string.answer_hint));
    }
}