package br.com.locadoraandroid.util;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by asbonato on 9/7/15.
 */
public class ViewHolder {
    private ImageView imgVeiculo;
    private TextView nome, cor, valor, placa;

    public ViewHolder(ImageView imgVeiculo, TextView nome, TextView cor, TextView valor, TextView placa) {
        this.imgVeiculo= imgVeiculo;
        this.nome = nome;
        this.cor = cor;
        this.valor = valor;
        this.placa = placa;
    }

    public ImageView getImgVeiculo() {
        return imgVeiculo;
    }

    public void setImgVeiculo(ImageView imgVeiculo) {
        this.imgVeiculo = imgVeiculo;
    }

    public TextView getNome() {
        return nome;
    }

    public void setNome(TextView nome) {
        this.nome = nome;
    }

    public void setCor(TextView cor) {
        this.cor = cor;
    }

    public TextView getValor(){
        return this.valor;
    }

    public void setValor(TextView valor)
    {
        this.valor = valor;
    }

    public void setPlaca(TextView placa)
    {
        this.placa = placa;
    }

    public TextView getPlaca()
    {
        return this.placa;
    }
    public TextView getCor() {
        return cor;
    }


}
