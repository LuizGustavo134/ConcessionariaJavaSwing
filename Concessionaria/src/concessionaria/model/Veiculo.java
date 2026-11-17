package concessionaria.model;
public class Veiculo {
   private int id;
   private String marca;
   private int ano;
   

    public Veiculo() {
    }

    public Veiculo(String marca, int ano) {  //contrutor para tela solicitação
        this.marca = marca;
        this.ano = ano;
    }
    
    public Veiculo(String marca, int ano, double preco, int quantidade) {
        this.marca = marca;
        this.ano = ano;
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
  

    @Override
    public String toString() {
        return "Carro{" + "id=" + id + ", marca=" + marca + ", ano=" + ano + " }";
    }
   

}