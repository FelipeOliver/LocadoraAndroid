package br.com.locadoraandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.locadoraandroid.Adapter.VeiculoAdapter;
import br.com.locadoraandroid.Model.Veiculo;

public class listaVeiculosDisponiveis extends Activity {
    public final static String VEICULOS = "br.com.VEICULOS";
    public final static String PLACA    = "br.com.PLACA";
    public final static String COR      = "br.com.COR";
    public final static String NOME     = "br.com.NOME";
    public final static String VALOR    = "br.com.VALOR";
    Veiculo veiculos[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_veiculos_disponiveis);

        Intent intent = getIntent();
        String estado = intent.getStringExtra(MainActivity.ESTADO);
        //Só para testes

        veiculos = ((ArrayList<Veiculo>)intent.getSerializableExtra(MainActivity.VEICULOS)).toArray(new Veiculo[0]);

        ListView l_vi = (ListView) findViewById(R.id.lista_veiculo);
        VeiculoAdapter adapter = new VeiculoAdapter(this, veiculos);
        l_vi.setAdapter(adapter);
        final Intent intent2 = new Intent(this, detalha_automovel.class);
        l_vi.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // manda para a tela de detalhe
                //Intent intent = new Intent(this, detalha_automovel.class);
                intent2.putExtra(PLACA, veiculos[position].getPlaca());
                intent2.putExtra(COR, veiculos[position].getCor());
                intent2.putExtra(NOME, veiculos[position].getNome());
                intent2.putExtra(VALOR, veiculos[position].getValor_km());
                startActivity(intent2);

            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_veiculos_disponiveis, menu);
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
}
