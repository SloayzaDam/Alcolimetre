package com.alcoholimetro.indam.alcolimetrefree;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;


public class DatosUsuario extends ActionBarActivity {

    private RadioButton rmale;
    private Intent nueva;
    private EditText etPeso;
    private SeekBar sbPeso;
    public double ProgressText = 50;
    public int ProgressValue;
    public double tasaPermitida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_usuario);
        //quitar Action Bar. para api 11 es solo ActionBar actionBar
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        List<Countries> items = new ArrayList<>(3);
        items.add(new Countries(getString(R.string.espania),R.drawable.espania, 0.5));
        items.add(new Countries(getString(R.string.francia),R.drawable.francia, 0.5));
        items.add(new Countries(getString(R.string.alemania),R.drawable.alemania, 0.5));

        Spinner spinner = (Spinner) findViewById(R.id.spBanderas);
        spinner.setAdapter(new CountriesSpinnerAdapter(this,items));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                // Aquí se indica la acción de selección
                tasaPermitida = ((Countries) adapterView.getItemAtPosition(position)).getTasa();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        rmale = (RadioButton) findViewById(R.id.rmale);
        Button btStart = (Button) findViewById(R.id.start);
        etPeso = (EditText) findViewById(R.id.et1);
        sbPeso = (SeekBar) findViewById(R.id.sb1);
        sbPeso.setMax(150);

        etPeso.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (s != null) {
                        ProgressText = Double.parseDouble(s.toString());
                        ProgressValue = (int) ProgressText;
                        sbPeso.setProgress(ProgressValue);
                    }
                } catch (Exception exception) {
                    sbPeso.setProgress(0);
                    etPeso.setText("0");
                    exception.printStackTrace();
                }


            }
        });

        sbPeso.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                   etPeso.setText(String.valueOf(progress));
                   ProgressText = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nueva = new Intent(getApplicationContext(),ResumenBebidas.class);
                nueva.putExtra("tasaPermitida", tasaPermitida );
                if(rmale.isChecked())
                    nueva.putExtra("cantidadSangre",ProgressText * 0.7 );
                else
                    nueva.putExtra("cantidadSangre",ProgressText * 0.6 );

                startActivity(nueva);
                finish();
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        boolean salir = Salir.getSalir();
        if(salir) {
            Salir.setSalir(false);
            finish();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_datos_usuario, menu);
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
