package ca.campbell.simplecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

    public void addNums(View v) {
        if(validateInput()){
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());
            result.setText(Double.toString(num1 + num2));
        }
    }  //addNums()

    public void substractNums(View v) {
        if(validateInput()){
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());
            result.setText(Double.toString(num1 - num2));
        }
    }

    public void multiplyNums(View v) {
        if(validateInput()){
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());
            result.setText(Double.toString(num1 * num2));
        }
    }

    public void divideNums(View v) {
        if(validateInput()){
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());
            if(num2 != 0) {
                result.setText(Double.toString(num1 / num2));
            } else {
                result.setText("Infinite");
            }
        }
    }

    public void clearFields(View v) {
        etNum1.setText("");
        etNum2.setText("");
        result.setText(R.string.result);
    }

    private boolean validateInput(){
        String strNum1 = etNum1.getText().toString();
        String strNum2 = etNum2.getText().toString();

        if (strNum1.equals("") || strNum2.equals("")){
            result.setText("Please type something");
            return false;
        }

        try{
            Double.parseDouble(strNum1);
            Double.parseDouble(strNum2);
        } catch (NumberFormatException e){
            result.setText("The input must be number");
            return false;
        }
        return true;
    }
}