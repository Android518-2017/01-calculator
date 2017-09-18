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

        if(etNum1.getText().toString() == "" || etNum2.getText().toString() == ""){
            result.setText("Please Enter 2 numbers to add");
        }
        try {
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());
            result.setText(Double.toString(num1 + num2));
        }catch(NumberFormatException e){
            result.setText("Please Enter 2 valid numbers to add");
        }

    }  //addNums()

    public void subtractNums(View v) {

        if(etNum1.getText().toString() == "" || etNum2.getText().toString() == ""){
            result.setText("Please Enter 2 numbers to add");
        }
        try {
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());
            result.setText(Double.toString(num1 - num2));
        }catch(NumberFormatException e){
            result.setText("Please Enter 2 valid numbers to add");
        }
    } //subtractNum()

    public void multiplyNums(View v) {

        if(etNum1.getText().toString() == "" || etNum2.getText().toString() == ""){
            result.setText("Please Enter 2 numbers to add");
        }
        try {
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());
            result.setText(Double.toString(num1 * num2));
        }catch(NumberFormatException e){
            result.setText("Please Enter 2 valid numbers to add");
        }
    } //multiplyNum()


    public void divideNums(View v) {

        if(etNum1.getText().toString() == "" || etNum2.getText().toString() == ""){
            result.setText("Please Enter 2 numbers to add");
        }
        try {
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());
            if(num2 == 0){
                result.setText("Cannot divide by 0");
            }else{
                result.setText(Double.toString(num1 / num2));
            }
        }catch(NumberFormatException e){
            result.setText("Please Enter 2 valid numbers to add");
        }
    } //divideNum()


    public void clearAllText(View v){
        etNum1.setText("");
        etNum2.setText("");
        result.setText("");
    }
}