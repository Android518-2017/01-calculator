package ca.campbell.simplecalc;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

        //TODO change the colour of the text

        //TODO change the colour of the buttons

        //TODO As you make your changes, be sure to push to your fork.

public class MainActivity extends AppCompatActivity {
    EditText etNum1, etNum2;
    TextView result;
    double num1, num2;

    private static final String TAG = "MainActivity";

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
        boolean valid1 = validateEntry(etNum1.getText().toString(),etNum1);
        boolean valid2 = validateEntry(etNum2.getText().toString(),etNum2);

        if(valid1 && valid2) {
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());
        }

        result.setText(Double.toString(num1 + num2));
    }  //addNums()

    public void subNums(View v) {
        boolean valid1 = validateEntry(etNum1.getText().toString(),etNum1);
        boolean valid2 = validateEntry(etNum2.getText().toString(),etNum2);

        if(valid1 && valid2) {
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());
        }

        result.setText(Double.toString(num1 - num2));
    }

    public void multNums(View v) {
        boolean valid1 = validateEntry(etNum1.getText().toString(),etNum1);
        boolean valid2 = validateEntry(etNum2.getText().toString(),etNum2);

        if(valid1 && valid2) {
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());
        }

        result.setText(Double.toString(num1 * num2));
    }

    public void divNums(View v) {
        boolean valid1 = validateEntry(etNum1.getText().toString(),etNum1);
        boolean valid2 = validateEntry(etNum2.getText().toString(),etNum2);

        if(valid1 && valid2) {
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());
        }

        if(num2 == 0){
            result.setText(R.string.zero_divide);
        }
        else {
            result.setText(Double.toString(num1 / num2));
        }
    }

    public void clearAll(View v){
        etNum1.setText("");
        etNum2.setText("");
        result.setText("");
    }

    private boolean validateEntry(String entry, EditText etNum){
        if(entry.equals("")){
            etNum.setText(R.string.invalid_entry);
            return false;
        }
        else{
            try {
                Double.parseDouble(etNum.getText().toString());
            }catch (NumberFormatException e){
                Log.w(TAG, "Parsing error: " + e.toString());
                etNum.setText(R.string.invalid_entry);
                return false;
            }
        }
        return true;
    }

}