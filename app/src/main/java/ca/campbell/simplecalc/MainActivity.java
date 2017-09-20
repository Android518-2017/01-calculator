package ca.campbell.simplecalc;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity {
    EditText etNum1, etNum2;
    TextView result;
    double num1, num2;
    private static final String TAG = "MainActivity";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get a handle on the text fields
        etNum1 = (EditText) findViewById(R.id.num1);
        etNum2 = (EditText) findViewById(R.id.num2);
        result = (TextView) findViewById(R.id.result);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }  //onCreate()

    public void clearFieldsBtn(View v){
        etNum1.setText("");
        etNum2.setText("");
        result.setText(R.string.hint);

    }


    public void multiplyNums(View v) {
        if (etNum1.getText().toString().equals("") || etNum2.getText().toString().equals("")){
            result.setText(R.string.invalid_number);
        } else if(etNum1.getText().toString().matches("[0-9]+[.]?[0-9]*") && //Checks for valid numbers
                etNum1.getText().toString().matches("[0-9]+[.]?[0-9]*")) {
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());
            result.setText(Double.toString(num1 * num2));
        } else {
            result.setText(R.string.invalid_number);
        }


    }
    
    public void divideNums(View v) {
        
        if (etNum1.getText().toString().equals("") || etNum2.getText().toString().equals("")){
            result.setText(R.string.invalid_number);
        } else if(etNum1.getText().toString().matches("[0-9]+[.]?[0-9]*") && //Checks for valid numbers
                etNum1.getText().toString().matches("[0-9]+[.]?[0-9]*")) {
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());

            if(num2 == 0){
                result.setText(R.string.divide_by_0);
            } else {
                result.setText(Double.toString(num1 / num2));
            }
        } else {
            result.setText(R.string.invalid_number);
        }


    }

    public void subtractNums(View v) {
        if (etNum1.getText().toString().equals("") || etNum2.getText().toString().equals("")){
            result.setText(R.string.invalid_number);
        } else if(etNum1.getText().toString().matches("[0-9]+[.]?[0-9]*") && //Checks for valid numbers
                etNum1.getText().toString().matches("[0-9]+[.]?[0-9]*")) {
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());
            result.setText(Double.toString(num1 - num2));
        } else {
            result.setText(R.string.invalid_number);
        }
        

    }
    public void addNums(View v) {
         
        if (etNum1.getText().toString().equals("") || etNum2.getText().toString().equals("")){
            result.setText(R.string.invalid_number);
        } else if(etNum1.getText().toString().matches("[0-9]+[.]?[0-9]*") && //Checks for valid numbers
                etNum1.getText().toString().matches("[0-9]+[.]?[0-9]*")) {
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());
            result.setText(Double.toString(num1 + num2));
        } else {
            result.setText(R.string.invalid_number);
        }

//        result.setText(Double.toString(num1 + num2));
    }  //addNums()

    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}