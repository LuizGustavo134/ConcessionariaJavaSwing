package concessionaria.model;
public class Carro {
   private int id;
   private String marca;
   private int ano;
   private double preco;
   private int quantidade;

    public Carro() {
    }

    public Carro(String marca, int ano, double preco, int quantidade) {
        this.marca = marca;
        this.ano = ano;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Carro{" + "id=" + id + ", marca=" + marca + ", ano=" + ano + ", preco=" + preco + ", quantidade=" + quantidade + '}';
    }
   

}