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


    public void addNums(View v) {

        if(isValidInput()){
            result.setText(Double.toString(num1 + num2));
        }

    }  //addNums()

    public void subtractNums(View v){
        if(isValidInput()){
            result.setText(Double.toString(num1 - num2));
        }
    }

    private boolean isValidInput(){
        if(etNum1.getText().toString().equals("") || etNum2.getText().toString().equals("")){
            result.setText("Please enter two numeric values please");
            return false;
        }

        try {
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());
            return true;
        }catch(NumberFormatException ex){
            result.setText("Please make sure your input are valid numeric values");
        }

        return false;
    }

}