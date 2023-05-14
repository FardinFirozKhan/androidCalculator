package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView setting,result;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnSum,btnSub,btnmul,btndiv,btnClr,btnEqual;
    String first="";
    int oldValue=0,total=0,countSum=0,countSub=0,countmul=0,countdiv=0,count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        first=setting.getText().toString();
    }
    public void init(){
        setting=findViewById(R.id.setting);
        result=findViewById(R.id.result);
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btnClr=findViewById(R.id.btnClr);
        btnSum=findViewById(R.id.btnSum);
        btnSub=findViewById(R.id.btnSub);
        btndiv=findViewById(R.id.btndiv);
        btnmul=findViewById(R.id.btnmul);
        btnEqual=findViewById(R.id.btnEqual);

    }
    public void getNumber(View view){
        if(count==1){
            setting.setText("0");
            first="0";
            result.setText(first);
            count=0;
        }
        Button currentBtn= (Button) view;
        String newValue=currentBtn.getText().toString();
        if(first.equals("0")){
            first=newValue;
            setting.setText(first);
        }
        else{
            first=first+newValue;
            setting.setText(first);
        }
    }
    public void clear(View view){
        setting.setText("0");
        first="0";
        result.setText(first);
    }
    public void runOperator(View view){
        Button currentBtn= (Button) view;
        String newValue=currentBtn.getText().toString();
        int secondValue=Integer.parseInt(setting.getText().toString());
        if(currentBtn.getText().toString().equals("+")){

            total=oldValue+secondValue;
            oldValue=secondValue;
            first="0";
            setting.setText(first);
            if(countSum==0){
                countSum=1;
            }else{
                countSum=0;
            }
        }
        else if(currentBtn.getText().toString().equals("-")){
            if(oldValue==0){
                oldValue=secondValue;
                first="0";
                setting.setText(first);
            }
            else{
                total=oldValue-secondValue;
                oldValue=secondValue;
                first="0";
                setting.setText(first);
            }
            if(countSub==0){
                countSub=1;
            }else{
                countSub=0;
            }
        }
        else if(currentBtn.getText().toString().equals("*")){
            if(oldValue==0){
                oldValue=secondValue;
                first="0";
                setting.setText(first);
            }
            else{
                total=oldValue*secondValue;
                oldValue=secondValue;
                first="0";
                setting.setText(first);
            }
            if(countmul==0){
                countmul=1;
            }else{
                countmul=0;
            }
        }
        else if(currentBtn.getText().toString().equals("/")){
            if(oldValue==0){
                oldValue=secondValue;
                first="0";
                setting.setText(first);
            }
            else{
                total=oldValue/secondValue;
                oldValue=secondValue;
                first="0";
                setting.setText(first);
            }
            if(countdiv==0){
                countdiv=1;
            }else{
                countdiv=0;
            }
        }
        if(currentBtn.getText().toString().equals("=")){

            if(countSum==1){
                total=oldValue+secondValue;
                countSum=0;
            }
            else if(countSub==1){
                total=oldValue-secondValue;
                countSub=0;
            }
            else if(countmul==1){
                total=oldValue*secondValue;
                countmul=0;
            }
            else if(countdiv==1){
                total=oldValue/secondValue;
                countdiv=0;
            }
            String myresult=Integer.toString(total);
            result.setText(myresult);
            oldValue=0;
            secondValue=0;
            count=1;
        }
    }
}