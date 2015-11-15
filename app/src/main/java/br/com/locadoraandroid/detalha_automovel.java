package br.com.locadoraandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import br.com.locadoraandroid.Model.Veiculo;

public class detalha_automovel extends Activity {
    public final static String PLACA = "br.com.PLACA";
    public final static String COR      = "br.com.COR";
    public final static String NOME     = "br.com.NOME";
    public final static String VALOR    = "br.com.VALOR";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalha_automovel);

        Intent intent = getIntent();

        Veiculo veiculo = new Veiculo(intent.getStringExtra(listaVeiculosDisponiveis.NOME),
                                      intent.getStringExtra(listaVeiculosDisponiveis.PLACA),
                                      intent.getStringExtra(listaVeiculosDisponiveis.COR),
                                      1,
                                      100);//Double.parseDouble(intent.getStringExtra(listaVeiculosDisponiveis.VALOR)));// Double.parseDouble(intent.getStringExtra(listaVeiculosDisponiveis.VALOR)));

        TextView modelo = (TextView) findViewById(R.id.txt_modelo);
        modelo.setText(veiculo.getNome());

        TextView placa = (TextView) findViewById(R.id.txt_placa);
        placa.setText(veiculo.getPlaca());

        TextView valor = (TextView) findViewById(R.id.txt_valor);
        valor.setText("" + veiculo.getValor_km());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalha_automovel, menu);
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
