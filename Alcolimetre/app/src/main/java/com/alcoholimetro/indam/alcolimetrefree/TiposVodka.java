package com.alcoholimetro.indam.alcolimetrefree;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class TiposVodka extends ActionBarActivity {

    private double cantidadLiquido,tasaPermitida, cantidadSangre, cantidadAlcohol;
    private String bebida, liquido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipos_vodka);
        //quitar Action Bar. para api 11 es solo ActionBar actionBar
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        
        Bundle datos = this.getIntent().getExtras();
        tasaPermitida = datos.getDouble("tasaPermitida");
        cantidadSangre = datos.getDouble("cantidadSangre");
        cantidadAlcohol = datos.getDouble("cantidadAlcohol");
        cantidadLiquido = datos.getDouble("cantidadLiquido");
        bebida = datos.getString("bebida");
        liquido = datos.getString("liquido");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tipos_vodka, menu);
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

    public void setCantidadLiquido(View v) {
        Intent enviarDatos = new Intent(getApplicationContext(),ResumenBebidas.class);
        if (bebida == null || cantidadAlcohol == 0)
            bebida = liquido+" de vodka " ;
        else
            bebida = bebida.concat(liquido+" de vodka ");
        switch (v.getId()) {
            case R.id.btskyy:
                cantidadLiquido = (cantidadLiquido * 40)/100;
                bebida = bebida.concat("Skyy\n");
                break;
            case R.id.btabsolut:
                cantidadLiquido = (cantidadLiquido * 40)/100;
                bebida = bebida.concat("Absolut\n");
                break;
            case R.id.btsmirnoff:
                cantidadLiquido = (cantidadLiquido * 40)/100;
                bebida = bebida.concat("Smirnoff\n");
                break;
            case R.id.btcrystalh:
                cantidadLiquido = (cantidadLiquido * 40)/100;
                bebida = bebida.concat("Crystal Head\n");
                break;
            case R.id.btbeluga:
                cantidadLiquido = (cantidadLiquido * 40)/100;
                bebida = bebida.concat("Beluga\n");
                break;
            case R.id.btrusskaya:
                cantidadLiquido = (cantidadLiquido * 40)/100;
                bebida = bebida.concat("Russkaya\n");
                break;
            case R.id.bteristoff:
                cantidadLiquido = (cantidadLiquido * 37.5)/100;
                bebida = bebida.concat("Eristoff\n");
                break;
            case R.id.btgreyg:
                cantidadLiquido = (cantidadLiquido * 40)/100;
                bebida = bebida.concat("Grey Goose\n");
                break;
        }
        cantidadAlcohol = cantidadAlcohol + cantidadLiquido;
        enviarDatos.putExtra("tasaPermitida", tasaPermitida);
        enviarDatos.putExtra("cantidadSangre", cantidadSangre);
        enviarDatos.putExtra("cantidadAlcohol", cantidadAlcohol);
        enviarDatos.putExtra("bebida", bebida);
        startActivity(enviarDatos);
        finish();
    }
}
