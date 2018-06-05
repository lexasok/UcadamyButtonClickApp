package net.ozero.buttonclickapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TEXT_VIEW_KEY = "textView key";
    private static final String TAG = "MainActivity";
    private EditText editText;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: started (in)");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        //scrolling
        textView.setMovementMethod(new ScrollingMovementMethod());

        //Getting instance


        //button initializing
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append(editText.getText().toString() + "\n");
                editText.setText("");
            }
        });
        Log.d(TAG, "onCreate: finished (out)");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textView.setText(savedInstanceState.getString(TEXT_VIEW_KEY));
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TEXT_VIEW_KEY, textView.getText().toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
