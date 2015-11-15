package br.com.locadoraandroid.Adapter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.zip.Inflater;

import br.com.locadoraandroid.Model.Veiculo;
import br.com.locadoraandroid.R;
import br.com.locadoraandroid.util.Util;
import br.com.locadoraandroid.util.ViewHolder;

/**
 * Created by Felipe Oliver on 21/10/2015.
 */
public class VeiculoAdapter extends BaseAdapter{
    LayoutInflater inflater;
    Veiculo veiculos[];

    public VeiculoAdapter(Activity context, Veiculo[] veiculo)
    {
        this.veiculos = veiculo;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return veiculos.length;
    }

    @Override
     public Object getItem(int position) {
        return veiculos[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ItemSuporte itemHolder;
        if(view == null){
            view = inflater.inflate(R.layout.linha_veiculo,null);

            itemHolder = new ItemSuporte();
            itemHolder.imgVeiculo = (ImageView) view.findViewById(R.id.imgVeiculo);
            itemHolder.nome = (TextView) view.findViewById(R.id.nome);
            //itemHolder.cor  = (TextView) view.findViewById(R.id.cor);
            itemHolder.placa = (TextView) view.findViewById(R.id.placa);
            //itemHolder.valor = (TextView) view.findViewById(R.id.valor);

            view.setTag(itemHolder);
        }
        else{
            itemHolder = (ItemSuporte) view.getTag();
        }

        Veiculo item = veiculos[position];
        itemHolder.imgVeiculo.setImageResource(item.getImagem());
        Locale locale = new Locale("pt", "BR");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        itemHolder.nome.setText(item.getNome());
//        itemHolder.cor.setText(item.getCor());
//        itemHolder.valor.setText(formatter.format(item.getValor_km()));
        itemHolder.placa.setText(item.getPlaca());
        return view;
    }

    private class ItemSuporte{
        ImageView imgVeiculo;
        TextView nome;
        TextView cor;
        TextView placa;
        TextView valor;
    }
}
