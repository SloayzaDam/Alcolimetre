package com.alcoholimetro.indam.alcolimetrefree;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class TiposLicores extends ActionBarActivity {

    private double cantidadLiquido,tasaPermitida, cantidadSangre, cantidadAlcohol;
    private String bebida, liquido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipos_licores);
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
        getMenuInflater().inflate(R.menu.menu_tipos_licores, menu);
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
        switch (v.getId()) {
            case R.id.btaguardiente:
                cantidadLiquido = (cantidadLiquido * 30)/100;
                liquido = liquido.concat(" de aguardiente\n");
                break;
            case R.id.btcointreau:
                cantidadLiquido = (cantidadLiquido * 40)/100;
                liquido = liquido.concat(" de Cointreau\n");
                break;
            case R.id.btbaileys:
                cantidadLiquido = (cantidadLiquido * 17)/100;
                liquido = liquido.concat(" de Baileys\n");
                break;
            case R.id.btpatxaran:
                cantidadLiquido = (cantidadLiquido * 28)/100;
                liquido = liquido.concat(" de Patxaran\n");
                break;
            case R.id.btorujohierb:
                cantidadLiquido = (cantidadLiquido * 30)/100;
                liquido = liquido.concat(" de Orujo de Hierbas\n");
                break;
            case R.id.btruavieja:
                cantidadLiquido = (cantidadLiquido * 17)/100;
                liquido = liquido.concat(" de Ruavieja\n");
                break;
            case R.id.btjagermeister:
                cantidadLiquido = (cantidadLiquido * 23)/100;
                liquido = liquido.concat(" de Jagermeister\n");
                break;
            case R.id.btconiac:
                cantidadLiquido = (cantidadLiquido * 40)/100;
                liquido = liquido.concat(" de Coñac\n");
                break;
        }
        if (bebida == null || cantidadAlcohol == 0)
            bebida = liquido;
        else
            bebida = bebida.concat(liquido);
        cantidadAlcohol = cantidadAlcohol + cantidadLiquido;
        enviarDatos.putExtra("tasaPermitida", tasaPermitida);
        enviarDatos.putExtra("cantidadSangre", cantidadSangre);
        enviarDatos.putExtra("cantidadAlcohol", cantidadAlcohol);
        enviarDatos.putExtra("bebida", bebida);
        startActivity(enviarDatos);
        finish();
    }
}
