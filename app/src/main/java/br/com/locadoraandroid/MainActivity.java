package br.com.locadoraandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadoraandroid.Model.Veiculo;
import br.com.locadoraandroid.network.VeiculoRequester;

public class MainActivity extends Activity {
    public final static String ESTADO = "br.com.ESTADO";
    public final static String VEICULOS = "br.com.VEICULOS";
    public String estado = "";
    public Spinner estados;
    private VeiculoRequester requester;
    private Intent intent;
    ArrayList<Veiculo> veiculos;
    //ProgressBar mProgress;
    String servidor = "enigmatic-beyond-6292.herokuapp.com";//"169.254.136.1:8080";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requester = new VeiculoRequester();
        estados = (Spinner) findViewById(R.id.cb_estado);
        estados.setOnItemSelectedListener(new EstadoSelecionado());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    private class EstadoSelecionado implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            estado = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    public void retornoVeiculosPorEstado(View view){
        String e = estado.equals("Escolha um Estado")?"SP":estado;
        if(e == null)
        {
            e = "Felipe";
        }
        estado = e;
        if(requester.isConnected(this)) {
            intent = new Intent(this, listaVeiculosDisponiveis.class);
            intent.putExtra(ESTADO,e);
            //mProgress.setVisibility(View.VISIBLE);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        veiculos = requester.get("http://" + servidor + "/selecao.json", estado);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                intent.putExtra(VEICULOS, veiculos);

                                //mProgress.setVisibility(View.INVISIBLE);
                                startActivity(intent);
                            }
                        });

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } else {
            Toast toast = Toast.makeText(this, "Rede indisponível!", Toast.LENGTH_LONG);
            toast.show();
        }

        //startActivity(intent);
    }
}
