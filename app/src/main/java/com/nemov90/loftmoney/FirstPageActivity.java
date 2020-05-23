package com.nemov90.loftmoney;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class FirstPageActivity extends AppCompatActivity {
    private EditText weightEdit;
    private EditText heightEdit;
    private EditText ageEdit;
    private TextView BMRtext;
    private Button doneButton;
    private String weight;
    private String height;
    private String age;
    private String BMR;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_page);

        weightEdit = findViewById(R.id.weight);
        heightEdit = findViewById(R.id.height);
        ageEdit = findViewById(R.id.age);
        doneButton = findViewById(R.id.done);
        BMRtext = findViewById(R.id.BMR);

        weightEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                weight = s.toString();
                changeButtonColor();
            }
        });
        heightEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                height = s.toString();
                changeButtonColor();
            }
        });
        ageEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                age = s.toString();
                changeButtonColor();
            }
        });

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                double w = Double.parseDouble(weight);
                double h = Double.parseDouble(height);
                double a = Double.parseDouble(age);
                //double d = Double.parseDouble(BMR);
                double d = 88.362 + (13.397 * w) + (4.799 * h) - (5.677 * a);
                BMRtext.setText(Double.toString(d));
            }
        });
    }

    private void changeButtonColor(){
        if(!TextUtils.isEmpty(weight) && !TextUtils.isEmpty(height) && !TextUtils.isEmpty(age)){
            doneButton.setBackgroundColor(ContextCompat.getColor(this, R.color.doneActive));
        } else {
            doneButton.setBackgroundColor(ContextCompat.getColor(this, R.color.doneNotActive));
        }
    }

}
