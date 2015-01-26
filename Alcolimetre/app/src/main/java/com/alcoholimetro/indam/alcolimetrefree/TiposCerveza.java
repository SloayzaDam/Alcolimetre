package com.alcoholimetro.indam.alcolimetrefree;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class TiposCerveza extends ActionBarActivity {

    private double cantidadLiquido,tasaPermitida, cantidadSangre, cantidadAlcohol;
    private String bebida, liquido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipos_cerveza);
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
        getMenuInflater().inflate(R.menu.menu_tipos_cerveza, menu);
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
            bebida = liquido+" de cerveza " ;
        else
            bebida = bebida.concat(liquido+" de cerveza ");
        switch (v.getId()) {
            case R.id.btsmiguel:
                cantidadLiquido = (cantidadLiquido * 5.4)/100;
                bebida = bebida.concat("San Miguel\n");
                break;
            case R.id.btheineken:
                cantidadLiquido = (cantidadLiquido * 5)/100;
                bebida = bebida.concat("Heineken\n");
                break;
            case R.id.btamstel:
                cantidadLiquido = (cantidadLiquido * 5)/100;
                bebida = bebida.concat("Amstel\n");
                break;
            case R.id.btcruzcampo:
                cantidadLiquido = (cantidadLiquido * 5)/100;
                bebida = bebida.concat("Cruzcampo\n");
                break;
            case R.id.btalhambra:
                cantidadLiquido = (cantidadLiquido * 6.4)/100;
                bebida = bebida.concat("Alhambra\n");
                break;
            case R.id.btbudweiser:
                cantidadLiquido = (cantidadLiquido * 4.8)/100;
                bebida = bebida.concat("Budweiser\n");
                break;
            case R.id.btpaulaner:
                cantidadLiquido = (cantidadLiquido * 5.5)/100;
                bebida = bebida.concat("Paulaner\n");
                break;
            case R.id.btegalicia:
                cantidadLiquido = (cantidadLiquido * 5.2)/100;
                bebida = bebida.concat("Estrella Galicia\n");
                break;
            case R.id.btpilsener:
                cantidadLiquido = (cantidadLiquido * 4.2)/100;
                bebida = bebida.concat("Pilsener\n");
                break;
            case R.id.btvoldam:
                cantidadLiquido = (cantidadLiquido * 7.2)/100;
                bebida = bebida.concat("Voll Damm\n");
                break;
            case R.id.btguinnes:
                cantidadLiquido = (cantidadLiquido * 4.2)/100;
                bebida = bebida.concat("Guinness\n");
                break;
            case R.id.btmurphys:
                cantidadLiquido = (cantidadLiquido * 5)/100;
                bebida = bebida.concat("Murphy's\n");
                break;
            case R.id.btcoronita:
                cantidadLiquido = (cantidadLiquido * 4.6)/100;
                bebida = bebida.concat("Coronita\n");
                break;
            case R.id.btmahou:
                cantidadLiquido = (cantidadLiquido * 5.5)/100;
                bebida = bebida.concat("Mahou\n");
                break;
            case R.id.btjudas:
                cantidadLiquido = (cantidadLiquido * 8.5)/100;
                bebida = bebida.concat("Judas\n");
                break;
            case R.id.btcarlsberg:
                cantidadLiquido = (cantidadLiquido * 4)/100;
                bebida = bebida.concat("Carlsberg\n");
                break;
            case R.id.btdesperados:
                cantidadLiquido = (cantidadLiquido * 5.9)/100;
                bebida = bebida.concat("Desperados\n");
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
