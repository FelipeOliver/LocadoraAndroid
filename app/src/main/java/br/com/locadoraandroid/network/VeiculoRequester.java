package br.com.locadoraandroid.network;

import android.app.DownloadManager;
import android.content.Context;
import android.net.ConnectivityManager;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.locadoraandroid.Model.Veiculo;
import br.com.locadoraandroid.R;

/**
 * Created by Felipe Oliver on 25/10/2015.
 */
public class VeiculoRequester {

    OkHttpClient client = new OkHttpClient();

    public ArrayList<Veiculo> get(String url, String estado) throws IOException{
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

        RequestBody body = new FormEncodingBuilder()
                .add("estado", estado)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();

        String result = response.body().string();

        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        try {
            System.out.println(result);
            JSONArray root = new JSONArray(result);
            JSONObject item = null;
            for (int i = 0; i < root.length(); i++ ) {
                item = (JSONObject)root.get(i);

                String nome = item.getString("nome");
                int imagem = R.drawable.y_blindado_jetta;
                double valor = item.getDouble("valor");
                String placa = item.getString("placa");
                String cor = item.getString("cor");

                veiculos.add(new Veiculo(nome, placa, cor, imagem, valor));
            }
        } catch(JSONException e){
            e.printStackTrace();
        }
        finally {
            if(veiculos.size() == 0)
                veiculos.add(new Veiculo("Veículo não encontrado", "XXX-9999", "BRANCO", R.drawable.y_blindado_jetta, 0.0));
        }
        return veiculos;
    }

    public boolean isConnected(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context
                        .getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null
                && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
