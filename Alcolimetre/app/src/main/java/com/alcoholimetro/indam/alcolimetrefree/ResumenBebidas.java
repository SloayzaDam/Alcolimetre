package com.alcoholimetro.indam.alcolimetrefree;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ResumenBebidas extends ActionBarActivity {

    private double tasaPermitida;
    private double cantidadSangre;
    private double cantidadAlcohol = 0;
    private double tasaActual;
    private Intent enviarDatos;
    private String bebida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //quitar Action Bar. para api 11 es solo ActionBar actionBar
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Bundle datos;
        datos = this.getIntent().getExtras();
       /* if(savedInstanceState != null) {
            tasaPermitida = savedInstanceState.getDouble("tasaPermitida");
            cantidadSangre = savedInstanceState.getDouble("cantidadSangre");
            cantidadAlcohol = savedInstanceState.getDouble("cantidadAlcohol");
            cantidadAlcohol += datos.getDouble("cantidadLiquido");
        }
        else {
            tasaPermitida = datos.getDouble("tasaPermitida");
            cantidadSangre = datos.getDouble("cantidadSangre");
        }*/
        setContentView(R.layout.activity_resumen_bebidas);

        TextView tvResumen = (TextView) findViewById(R.id.tvResumen);
        Button addBebida = (Button) findViewById(R.id.btAdd);
        Button resultado = (Button) findViewById(R.id.btResultado);
        tasaPermitida = datos.getDouble("tasaPermitida");
        cantidadSangre = datos.getDouble("cantidadSangre");
        cantidadAlcohol = datos.getDouble("cantidadAlcohol");
        bebida = datos.getString("bebida");
        tvResumen.setText(bebida);


        addBebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarDatos = new Intent(getApplicationContext(),SeleccionBebida.class);
                enviarDatos.putExtra("tasaPermitida", tasaPermitida);
                enviarDatos.putExtra("cantidadSangre", cantidadSangre);
                enviarDatos.putExtra("cantidadAlcohol", cantidadAlcohol);
                enviarDatos.putExtra("bebida", bebida);
                startActivity(enviarDatos);
            }
        });

        resultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Botón resultado
                tasaActual = cantidadAlcohol / cantidadSangre;
                enviarDatos = new Intent(getApplicationContext(), Resultado.class);
                enviarDatos.putExtra("tasaPermitida", tasaPermitida);
                enviarDatos.putExtra("tasaActual", tasaActual);
                startActivity(enviarDatos);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        boolean salir = Salir.getSalir();
        if(salir) {
            finish();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_resumen_bebidas, menu);
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

   /* @Override
    protected  void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putDouble("tasaPermitida", tasaPermitida);
        savedInstanceState.putDouble("cantidadSangre", cantidadSangre);
        savedInstanceState.putDouble("cantidadAlcohol", cantidadAlcohol);
        super.onSaveInstanceState(savedInstanceState);
    }*/


}
