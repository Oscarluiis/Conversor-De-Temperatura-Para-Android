package com.example.bgera.temperatura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spinner1, spinner2;

    private EditText cant;
    private TextView cantconvert;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cant = (EditText)findViewById(R.id.cant);
        cantconvert = (TextView)findViewById(R.id.cantconvert);
         Button convertir =(Button)findViewById(R.id.convertir);



        spinner2 = (Spinner)findViewById(R.id.spinner2);
        String []opciones2={"CELCIUS","FARENHEIT","KELVIN","RANKINE"};
        ArrayAdapter<String> adapters = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones2);
        spinner2.setAdapter(adapters);

        spinner1 = (Spinner)findViewById(R.id.spinner1);
        String []opciones={"CELCIUS","FARENHEIT","KELVIN","RANKINE"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(adapter);

    }

    public void convertir(View v) {
        double val =0;
        val = Double.parseDouble(cant.getText().toString());
        String selec=spinner1.getSelectedItem().toString();
        String select=spinner2.getSelectedItem().toString();
        if (selec.equals("CELCIUS")&& select.equals("FARENHEIT")){
            cantconvert.setText(""+((val*9/5)+32));
        }
        if (selec.equals("FARENHEIT")&& select.equals("CELCIUS")){
            cantconvert.setText(""+((val-32))*5/9);
        }
        if (selec.equals("FARENHEIT")&& select.equals("KELVIN")){
            cantconvert.setText(""+((val-32))/1.8000+273.15);
        }
        if (selec.equals("KELVIN")&& select.equals("FARENHEIT")){
            cantconvert.setText(""+(1.8*(val-273)+32));
        }
        if (selec.equals("RANKINE")&& select.equals("FARENHEIT")){
            cantconvert.setText(""+((val-459.67)));
        }
        if (selec.equals("FARENHEIT")&& select.equals("RANKINE")){
            cantconvert.setText(""+((val-32)+491.67));
        }
        if (selec.equals("CELCIUS")&& select.equals("KELVIN")){
            cantconvert.setText(""+((val+273.15)));
        }
        if (selec.equals("KELVIN")&& select.equals("CELCIUS")){
            cantconvert.setText(""+((val-273.15)));
        }
        if (selec.equals("RANKINE")&& select.equals("CELCIUS")){
            cantconvert.setText(""+((val-491.67)/1.8000));
        }
        if (selec.equals("CELCIUS")&& select.equals("RANKINE")){
            cantconvert.setText(""+((val*1.8000)+491.67));
        }
        if (selec.equals("KELVIN")&& select.equals("RANKINE")) {
            cantconvert.setText("" + ((val - 273.15) * 1.8000) + 491.67);

        }
        if (selec.equals("KELVIN")&& select.equals("RANKINE")){
            cantconvert.setText(""+((val-491.67)/1.8000)+273.15);
        }


    }
    public void limpiar(View v){
        String selec=spinner1.getSelectedItem().toString();
        String select=spinner2.getSelectedItem().toString();
        cant.setText(""+0);
        cantconvert.setText(""+0);

    }



}

