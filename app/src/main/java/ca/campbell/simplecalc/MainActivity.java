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

        if(isValidInput()){
            result.setText(Double.toString(num1 + num2));
        }

    }  //addNums()

    public void subtractNums(View v){
        if(isValidInput()){
            result.setText(Double.toString(num1 - num2));
        }
    }

    public void divideNums(View v){
        if(isValidInput() && isZero()){
            result.setText(Double.toString(num1 / num2));
        }
    }

    public void multiplyNums(View v){
        if(isValidInput()){
            result.setText(Double.toString(num1 * num2));
        }
    }

    public boolean isZero(){
        if(num2==0){
            result.setText("Cannot divide with 0");
            return false;
        }
        else{
            return true;
        }
    }

    public void clearFields(View v){
        etNum1.setText("");
        etNum2.setText("");
    }

    private boolean isValidInput(){
        if(etNum1.getText().toString().isEmpty() || etNum2.getText().toString().isEmpty()){
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