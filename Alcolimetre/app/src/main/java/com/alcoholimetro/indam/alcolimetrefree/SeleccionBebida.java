package com.alcoholimetro.indam.alcolimetrefree;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class SeleccionBebida extends ActionBarActivity {

    private ImageButton bttubo, btsidra, btbalon, btchupito, btjarrita, btcania;
    private Button btMini, btTercio, btQuinto, btPinta, btMediaPinta;
    private TextView etCantidad;
    private double cantidadLiquido;
    private double tasaPermitida, cantidadSangre, cantidadAlcohol;
    private String vaso, bebida;
    private int numero = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_bebida);
        //quitar Action Bar. para api 11 es solo ActionBar actionBar
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        bttubo = (ImageButton) findViewById(R.id.vasoTubo);
        btsidra = (ImageButton) findViewById(R.id.vasoSidra);
        btbalon = (ImageButton) findViewById(R.id.copaBalon);
        btchupito = (ImageButton) findViewById(R.id.vasoChupito);
        btjarrita = (ImageButton) findViewById(R.id.jarrita);
        btcania = (ImageButton) findViewById(R.id.cania);
        btMini = (Button) findViewById(R.id.btMini);
        btTercio = (Button) findViewById(R.id.btTercio);
        btQuinto = (Button) findViewById(R.id.btQuinto);
        btPinta = (Button) findViewById(R.id.btPinta);
        btMediaPinta = (Button) findViewById(R.id.btMediaPinta);
        etCantidad = (EditText) findViewById(R.id.etCantidad);
        Button btIncremento = (Button) findViewById(R.id.btIncremento);
        Button btDecremento = (Button) findViewById(R.id.btDecremento);
        Bundle datos = this.getIntent().getExtras();
        tasaPermitida = datos.getDouble("tasaPermitida");
        cantidadSangre = datos.getDouble("cantidadSangre");
        cantidadAlcohol = datos.getDouble("cantidadAlcohol");
        bebida = datos.getString("bebida");

        // btcubata predefinido por defecto
        bttubo.setActivated(true);
        cantidadLiquido = 110 * 0.8;
        vaso = "vaso de tubo";

        etCantidad.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (s != null)
                        numero = Integer.parseInt(s.toString());
                }
                catch (Exception exception) {
                    etCantidad.setText("1");
                    numero = 1;
                }


            }
        });

        btIncremento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero++;
                etCantidad.setText(String.valueOf(numero));
            }
        });

        btDecremento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numero != 1) {
                    numero--;
                    etCantidad.setText(String.valueOf(numero));
                }
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_seleccion_bebida, menu);
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

    public void determinarCantidad (View v) {

        switch (v.getId()) {
            case R.id.vasoTubo:
                bttubo.setActivated(true);
                btsidra.setActivated(false);
                btchupito.setActivated(false);
                btbalon.setActivated(false);
                btjarrita.setActivated(false);
                btcania.setActivated(false);
                btMini.setTextColor(getResources().getColor(R.color.black));
                btTercio.setTextColor(getResources().getColor(R.color.black));
                btQuinto.setTextColor(getResources().getColor(R.color.black));
                btPinta.setTextColor(getResources().getColor(R.color.black));
                btMediaPinta.setTextColor(getResources().getColor(R.color.black));
                cantidadLiquido = 110 * 0.8;
                vaso = "vaso de tubo";
                break;
            case R.id.vasoSidra:
                bttubo.setActivated(false);
                btsidra.setActivated(true);
                btchupito.setActivated(false);
                btbalon.setActivated(false);
                btjarrita.setActivated(false);
                btcania.setActivated(false);
                btMini.setTextColor(getResources().getColor(R.color.black));
                btTercio.setTextColor(getResources().getColor(R.color.black));
                btQuinto.setTextColor(getResources().getColor(R.color.black));
                btPinta.setTextColor(getResources().getColor(R.color.black));
                btMediaPinta.setTextColor(getResources().getColor(R.color.black));
                cantidadLiquido = 150 * 0.8 ;
                vaso = "vaso de sidra";
                break;
            case R.id.vasoChupito:
                bttubo.setActivated(false);
                btsidra.setActivated(false);
                btchupito.setActivated(true);
                btbalon.setActivated(false);
                btjarrita.setActivated(false);
                btcania.setActivated(false);
                btMini.setTextColor(getResources().getColor(R.color.black));
                btTercio.setTextColor(getResources().getColor(R.color.black));
                btQuinto.setTextColor(getResources().getColor(R.color.black));
                btPinta.setTextColor(getResources().getColor(R.color.black));
                btMediaPinta.setTextColor(getResources().getColor(R.color.black));
                cantidadLiquido = 50 * 0.8;
                vaso = "chupito";
                break;
            case R.id.copaBalon:
                bttubo.setActivated(false);
                btsidra.setActivated(false);
                btchupito.setActivated(false);
                btbalon.setActivated(true);
                btjarrita.setActivated(false);
                btcania.setActivated(false);
                btMini.setTextColor(getResources().getColor(R.color.black));
                btTercio.setTextColor(getResources().getColor(R.color.black));
                btQuinto.setTextColor(getResources().getColor(R.color.black));
                btPinta.setTextColor(getResources().getColor(R.color.black));
                btMediaPinta.setTextColor(getResources().getColor(R.color.black));
                vaso = "copa de balón";
                break;
            case R.id.jarrita:
                bttubo.setActivated(false);
                btsidra.setActivated(false);
                btchupito.setActivated(false);
                btbalon.setActivated(false);
                btjarrita.setActivated(true);
                btcania.setActivated(false);
                btMini.setTextColor(getResources().getColor(R.color.black));
                btTercio.setTextColor(getResources().getColor(R.color.black));
                btQuinto.setTextColor(getResources().getColor(R.color.black));
                btPinta.setTextColor(getResources().getColor(R.color.black));
                btMediaPinta.setTextColor(getResources().getColor(R.color.black));
                vaso = "jarrita";
                break;
            case R.id.cania:
                bttubo.setActivated(false);
                btsidra.setActivated(false);
                btchupito.setActivated(false);
                btbalon.setActivated(false);
                btjarrita.setActivated(false);
                btcania.setActivated(true);
                btMini.setTextColor(getResources().getColor(R.color.black));
                btTercio.setTextColor(getResources().getColor(R.color.black));
                btQuinto.setTextColor(getResources().getColor(R.color.black));
                btPinta.setTextColor(getResources().getColor(R.color.black));
                btMediaPinta.setTextColor(getResources().getColor(R.color.black));
                cantidadLiquido = 180 * 0.8;
                vaso = "caña";
                break;
            case R.id.btMini:
                bttubo.setActivated(false);
                btsidra.setActivated(false);
                btchupito.setActivated(false);
                btbalon.setActivated(false);
                btjarrita.setActivated(false);
                btcania.setActivated(false);
                btMini.setTextColor(getResources().getColor(R.color.red));
                btTercio.setTextColor(getResources().getColor(R.color.black));
                btQuinto.setTextColor(getResources().getColor(R.color.black));
                btPinta.setTextColor(getResources().getColor(R.color.black));
                btMediaPinta.setTextColor(getResources().getColor(R.color.black));
                cantidadLiquido = 1000 * 0.8;
                vaso = "mini";
                break;
            case R.id.btTercio:
                bttubo.setActivated(false);
                btsidra.setActivated(false);
                btchupito.setActivated(false);
                btbalon.setActivated(false);
                btjarrita.setActivated(false);
                btcania.setActivated(false);
                btMini.setTextColor(getResources().getColor(R.color.black));
                btTercio.setTextColor(getResources().getColor(R.color.red));
                btQuinto.setTextColor(getResources().getColor(R.color.black));
                btPinta.setTextColor(getResources().getColor(R.color.black));
                btMediaPinta.setTextColor(getResources().getColor(R.color.black));
                cantidadLiquido = 333 * 0.8;
                vaso = "tercio";
                break;
            case R.id.btQuinto:
                bttubo.setActivated(false);
                btsidra.setActivated(false);
                btchupito.setActivated(false);
                btbalon.setActivated(false);
                btjarrita.setActivated(false);
                btcania.setActivated(false);
                btMini.setTextColor(getResources().getColor(R.color.black));
                btTercio.setTextColor(getResources().getColor(R.color.black));
                btQuinto.setTextColor(getResources().getColor(R.color.red));
                btPinta.setTextColor(getResources().getColor(R.color.black));
                btMediaPinta.setTextColor(getResources().getColor(R.color.black));
                cantidadLiquido = 200 * 0.8;
                vaso = "quinto";
                break;
            case R.id.btPinta:
                bttubo.setActivated(false);
                btsidra.setActivated(false);
                btchupito.setActivated(false);
                btbalon.setActivated(false);
                btjarrita.setActivated(false);
                btcania.setActivated(false);
                btMini.setTextColor(getResources().getColor(R.color.black));
                btTercio.setTextColor(getResources().getColor(R.color.black));
                btQuinto.setTextColor(getResources().getColor(R.color.black));
                btPinta.setTextColor(getResources().getColor(R.color.red));
                btMediaPinta.setTextColor(getResources().getColor(R.color.black));
                cantidadLiquido = 600 * 0.8;
                vaso = "pinta";
                break;
            case R.id.btMediaPinta:
                bttubo.setActivated(false);
                btsidra.setActivated(false);
                btchupito.setActivated(false);
                btbalon.setActivated(false);
                btjarrita.setActivated(false);
                btcania.setActivated(false);
                btMini.setTextColor(getResources().getColor(R.color.black));
                btTercio.setTextColor(getResources().getColor(R.color.black));
                btQuinto.setTextColor(getResources().getColor(R.color.black));
                btPinta.setTextColor(getResources().getColor(R.color.black));
                btMediaPinta.setTextColor(getResources().getColor(R.color.red));
                cantidadLiquido = 300 * 0.8 ;
                vaso = "media pinta";
                break;
        }
    }

    public void tipoBebida (View v) {

        Intent enviarDatos;
        String liquido = "- "+numero+" x "+vaso;
        cantidadLiquido = cantidadLiquido * numero;

        switch (v.getId()) {
            case R.id.btWhisky:
                enviarDatos = new Intent(getApplicationContext(),TiposWhisky.class);
                enviarDatos.putExtra("tasaPermitida", tasaPermitida);
                enviarDatos.putExtra("cantidadSangre", cantidadSangre);
                enviarDatos.putExtra("cantidadAlcohol", cantidadAlcohol);
                enviarDatos.putExtra("cantidadLiquido", cantidadLiquido);
                enviarDatos.putExtra("bebida", bebida);
                enviarDatos.putExtra("liquido", liquido);
                startActivity(enviarDatos);
                break;
            case R.id.btVodka:
                enviarDatos = new Intent(getApplicationContext(),TiposVodka.class);
                enviarDatos.putExtra("tasaPermitida", tasaPermitida);
                enviarDatos.putExtra("cantidadSangre", cantidadSangre);
                enviarDatos.putExtra("cantidadAlcohol", cantidadAlcohol);
                enviarDatos.putExtra("cantidadLiquido", cantidadLiquido);
                enviarDatos.putExtra("bebida", bebida);
                enviarDatos.putExtra("liquido", liquido);
                startActivity(enviarDatos);
                break;
            case R.id.btRon:
                enviarDatos = new Intent(getApplicationContext(),TiposRon.class);
                enviarDatos.putExtra("tasaPermitida", tasaPermitida);
                enviarDatos.putExtra("cantidadSangre", cantidadSangre);
                enviarDatos.putExtra("cantidadAlcohol", cantidadAlcohol);
                enviarDatos.putExtra("cantidadLiquido", cantidadLiquido);
                enviarDatos.putExtra("bebida", bebida);
                enviarDatos.putExtra("liquido", liquido);
                startActivity(enviarDatos);
                break;
            case R.id.btCerveza:
                enviarDatos = new Intent(getApplicationContext(),TiposCerveza.class);
                enviarDatos.putExtra("tasaPermitida", tasaPermitida);
                enviarDatos.putExtra("cantidadSangre", cantidadSangre);
                enviarDatos.putExtra("cantidadAlcohol", cantidadAlcohol);
                enviarDatos.putExtra("cantidadLiquido", cantidadLiquido);
                enviarDatos.putExtra("bebida", bebida);
                enviarDatos.putExtra("liquido", liquido);
                startActivity(enviarDatos);
                break;
            case R.id.btLicores:
                enviarDatos = new Intent(getApplicationContext(),TiposLicores.class);
                enviarDatos.putExtra("tasaPermitida", tasaPermitida);
                enviarDatos.putExtra("cantidadSangre", cantidadSangre);
                enviarDatos.putExtra("cantidadAlcohol", cantidadAlcohol);
                enviarDatos.putExtra("cantidadLiquido", cantidadLiquido);
                enviarDatos.putExtra("bebida", bebida);
                enviarDatos.putExtra("liquido", liquido);
                startActivity(enviarDatos);
                break;
        }
        finish();
    }

}
