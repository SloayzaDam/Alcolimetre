package com.alcoholimetro.indam.alcolimetrefree;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class TiposRon extends ActionBarActivity {

    private double cantidadLiquido,tasaPermitida, cantidadSangre, cantidadAlcohol;
    private String bebida, liquido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipos_ron);
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
        getMenuInflater().inflate(R.menu.menu_tipos_ron, menu);
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
            bebida = liquido+" de ron " ;
        else
            bebida = bebida.concat(liquido+" de ron ");
        switch (v.getId()) {
            case R.id.btsantat:
                cantidadLiquido = (cantidadLiquido * 40)/100;
                bebida = bebida.concat("Santa Teresa\n");
                break;
            case R.id.btcacique:
                cantidadLiquido = (cantidadLiquido * 40)/100;
                bebida = bebida.concat("Cacique\n");
                break;
            case R.id.bthavanac:
                cantidadLiquido = (cantidadLiquido * 40)/100;
                bebida = bebida.concat("Havana Club\n");
                break;
            case R.id.btbarcelo:
                cantidadLiquido = (cantidadLiquido * 37.5)/100;
                bebida = bebida.concat("Barcelo\n");
                break;
            case R.id.btmatusalem:
                cantidadLiquido = (cantidadLiquido * 40)/100;
                bebida = bebida.concat("Matusalem\n");
                break;
            case R.id.btbacardi:
                cantidadLiquido = (cantidadLiquido * 40)/100;
                bebida = bebida.concat("Bacardi\n");
                break;
            case R.id.btbrugal:
                cantidadLiquido = (cantidadLiquido * 38)/100;
                bebida = bebida.concat("Brugal\n");
                break;
            case R.id.btnegrita:
                cantidadLiquido = (cantidadLiquido * 37.5)/100;
                bebida = bebida.concat("Negrita\n");
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
