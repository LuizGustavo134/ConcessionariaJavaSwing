package concessionaria.model;
public class Carro {
   private int id;
   private String nome; 
   private String marca;
   private double preco;
   private int ano;

    public Carro(int id, String nome, String marca, double preco, int ano) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
   
}
