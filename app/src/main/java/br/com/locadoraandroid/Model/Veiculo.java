package br.com.locadoraandroid.Model;
import java.io.Serializable;


/**
 * Created by Felipe Oliver on 21/10/2015.
 */
public class Veiculo implements Comparable<Veiculo>, Serializable{
    private String nome;
    private String placa;
    private String cor;
    private int    imagem;
    private double valor_km;

    public Veiculo(String nome, String placa, String cor, int imagem, double valor_km)
    {
        this.nome = nome;
        this.placa = placa;
        this.cor = cor;
        this.imagem = imagem;
        this.valor_km = valor_km;
    }

    @Override
    public int compareTo(Veiculo veiculo) {
        if(veiculo.getNome().equals(nome)
                && veiculo.getCor().equals(cor)
                && veiculo.getImagem() == imagem
                && veiculo.getPlaca().equals(placa))
        {
            return 0;
        }
        return this.getNome().compareTo(veiculo.getNome());
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getValor_km() {
        return valor_km;
    }

    public void setValor_km(double valor_km) {
        this.valor_km = valor_km;
    }

    public String toString()
    {
        return "br.com.locadoraandroid.Veiculo{"+
                "nome=" + nome + '\'' +
                "placa=" + placa + '\'' +
                "cor=" + cor + '\'' +
                "imagem=" + imagem + '\'' +
                "valor" + valor_km + '\'' +
                "}";
    }

}
