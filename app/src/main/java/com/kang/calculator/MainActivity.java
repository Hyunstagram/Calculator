package com.kang.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView num;
    private TextView sum;
    private SpannableStringBuilder builder;
    private Integer flag;
    CalculateHelper calculateHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num = (TextView)findViewById(R.id.textView_num);
        sum = (TextView)findViewById(R.id.textView_sum);
        builder = new SpannableStringBuilder();
        calculateHelper = new CalculateHelper();
        flag = 0;
    }

    public void onClick(View v) {
        if(num.getText().charAt(0) == '0')
            num.setText("");

        if(v.getId() == R.id.button_1) {
            if(flag == 1) {
                num.setText("");
            }
            num.append("1");
            flag = 0;
        }
        else if(v.getId() == R.id.button_2) {
            if(flag == 1) {
                num.setText("");
            }
            num.append("2");
            flag = 0;
        }
        else if(v.getId() == R.id.button_3) {
            if(flag == 1) {
                num.setText("");
            }
            num.append("3");
            flag = 0;
        }
        else if(v.getId() == R.id.button_4) {
            if(flag == 1) {
                num.setText("");
            }
            num.append("4");
            flag = 0;
        }
        else if(v.getId() == R.id.button_5) {
            if(flag == 1) {
                num.setText("");
            }
            num.append("5");
            flag = 0;
        }
        else if(v.getId() == R.id.button_6) {
            if(flag == 1) {
                num.setText("");
            }
            num.append("6");
            flag = 0;
        }
        else if(v.getId() == R.id.button_7) {
            if(flag == 1) {
                num.setText("");
            }
            num.append("7");
            flag = 0;
        }
        else if(v.getId() == R.id.button_8) {
            if(flag == 1) {
                num.setText("");
            }
            num.append("8");
            flag = 0;
        }
        else if(v.getId() == R.id.button_9) {
            if(flag == 1) {
                num.setText("");
            }
            num.append("9");
            flag = 0;
        }
        else if(v.getId() == R.id.button_0) {
            if(flag == 1) {
                num.setText("");
            }
            num.append("0");
            flag = 0;
        }
        else if(v.getId() == R.id.button_division) {
            builder.append(num.getText());
            if(builder.charAt(builder.length()-1) != '/' && builder.charAt(builder.length()-1) != '*' && builder.charAt(builder.length()-1) != '+' && builder.charAt(builder.length()-1) != '-' && builder.charAt(builder.length()-1) != '='){
                builder.append(" / ");
                sum.setText(builder);
                flag = 1;
            }
        } else if(v.getId() == R.id.button_multiply) {
            builder.append(num.getText());
            if(builder.charAt(builder.length()-1) != '/' && builder.charAt(builder.length()-1) != '*' && builder.charAt(builder.length()-1) != '+' && builder.charAt(builder.length()-1) != '-' && builder.charAt(builder.length()-1) != '='){
                builder.append(" * ");
                sum.setText(builder);
                flag = 1;
            }
        } else if(v.getId() == R.id.button_plus) {
            builder.append(num.getText());
            if(builder.charAt(builder.length()-1) != '/' && builder.charAt(builder.length()-1) != '*' && builder.charAt(builder.length()-1) != '+' && builder.charAt(builder.length()-1) != '-' && builder.charAt(builder.length()-1) != '='){
                builder.append(" + ");
                sum.setText(builder);
                flag = 1;
            }
        } else if(v.getId() == R.id.button_subtract) {
            builder.append(num.getText());
            if(builder.charAt(builder.length()-1) != '/' && builder.charAt(builder.length()-1) != '*' && builder.charAt(builder.length()-1) != '+' && builder.charAt(builder.length()-1) != '-' && builder.charAt(builder.length()-1) != '='){
                builder.append(" - ");
                sum.setText(builder);
                flag = 1;
            }
        } else if(v.getId() == R.id.button_delete) {
            sum.setText("");
            num.setText("0");
            builder.clear();
        } else if(v.getId() == R.id.button_equal) {
            builder.append(num.getText());
            if(builder.charAt(builder.length()-1) != '/' && builder.charAt(builder.length()-1) != '*' && builder.charAt(builder.length()-1) != '+' && builder.charAt(builder.length()-1) != '-' && builder.charAt(builder.length()-1) != '=') {
                sum.setText(builder);
                sum.append(" =");

                int result = calculateHelper.process(builder);
                num.setText(String.valueOf(result));

                builder.clear();
                flag = 1;
            }
        }
    }
}