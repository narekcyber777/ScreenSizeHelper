package com.example.screensizehelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.screensizehelper.utils.MetricsHelper;
import com.example.screensizehelper.utils.MyResourceUtils;
import com.example.screensizehelper.utils.ui.MovableFloatingActionButton;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements Spinner.OnItemSelectedListener {
//ui
    @BindView(R.id.spinner)
   Spinner spinner;
    @BindView(R.id.main_input)
 EditText main_input;
    @BindView(R.id.ldpi)
  TextView ldpi;
    @BindView(R.id.hdpi)
    TextView hdpi;
    @BindView(R.id.mdpi)
    TextView mdpi;
    @BindView(R.id.xhdpi)
 TextView xhdpi;
    @BindView(R.id.xxhdpi)
    TextView xxhdpi;
    @BindView(R.id.xxxhdpi)
   TextView xxxhdpi;

    @BindView(R.id.fab)
  MovableFloatingActionButton mf;


    public ArrayAdapter<MyResourceUtils.VALUE>  values;
    



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        
        init();
 

    }

    private void init() {
       spinner.setAdapter(createSpinner());
       spinner.setOnItemSelectedListener(this);
       ;
    }

    private ArrayAdapter createSpinner() {

        values= new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, MyResourceUtils.VALUE.values());
        return  values;
    }


    @OnClick(R.id.fab)
     public  void submit(){
    appendValues();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

               appendValues();
    }



    private void appendValues() {
        if(main_input.getText()==null ||
                main_input.getText().toString().isEmpty()) return;
        float v=Float.parseFloat(main_input.getText().toString().trim());
        if(v<0) return;
        MetricsHelper metricsHelper=MetricsHelper.getInstance(this);
        metricsHelper.convert(v, (MyResourceUtils.VALUE) spinner.getSelectedItem()).forEach((k,val)->{
            switch (k){
                case LDPI:
                    appendIn(ldpi,val);
                    break;
                case MDPI:
                    appendIn(mdpi,val);
                    break;
                case HDPI:
                    appendIn(hdpi,val);
                    break;
                case XHDPI:
                    appendIn(xhdpi,val);
                    break;
                case XXHDPI:
                    appendIn(xxhdpi,val);
                    break;
                case XXXHDPI:
                    appendIn(xxxhdpi,val);
                    break;
            }
        });

    }

    private void appendIn(TextView dpi, Integer val) {
        StringBuilder stb=new StringBuilder();
        stb.append(val).append("\b").append(dpi.getHint().toString());
        dpi.setText(stb.toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}