package com.alcoholimetro.indam.alcolimetrefree;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;


public class Resultado extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        Bundle datosFinales = this.getIntent().getExtras();
        TextView tasa_actual= (TextView) findViewById(R.id.tvTasaActual);
        ImageView imagen = (ImageView) findViewById(R.id.coche);
        TextView multa = (TextView) findViewById(R.id.tvMulta);
        final Button btsalir = (Button) findViewById(R.id.salir);
        double tasaPermitida = datosFinales.getDouble("tasaPermitida");
        final double tasaActual = datosFinales.getDouble("tasaActual");
        String tuTasa = decimalFormat.format(tasaActual);
        // mostrar una imagen u otra en función de la tasa
        if (tasaActual < tasaPermitida) {
            tasa_actual.setText(tuTasa + "  g/l");
            tasa_actual.setTextColor(getResources().getColor(R.color.green));
            imagen.setImageResource(R.drawable.cocheokey);
            multa.setText("FELICIDADES\nSe encuentra en condiciones de conducir");
            multa.setTextColor(getResources().getColor(R.color.green));
        }
        else {
            tasa_actual.setText(tuTasa + "  g/l");
            tasa_actual.setTextColor(getResources().getColor(R.color.red));
            imagen.setImageResource(R.drawable.coche_prohibido);
            multa.setText("NO SE ENCUENTRA EN CONDICIONES DE CONDUCIR\n\n" + multa(tasaPermitida, tasaActual));
            multa.setTextColor(getResources().getColor(R.color.red));
        }

        btsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Salir.setSalir (true);
                finish();
            }
        });
    }

    public String multa (double tasaPermitida, double tasaActual) {
        String multa;
        if (tasaActual >= tasaPermitida && tasaActual <= 2* tasaPermitida) {
            multa = "Si coge el coche se arriesga a una multa de\n500 €\ny a la pérdida de 4 puntos en el carnet";
        }
        else {
            multa = "Si coge el coche se arriesga a una multa de\n1000 €\ny a la pérdida de 6 puntos en el carnet";
        }
        return multa;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_resultado, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
