package concessionaria.model;
/* classe que representa, ela vai completar vai ser um um conjuto para 
o DB com a classe serviço*/
public class cliente {
    private String nome;
    private String Contato;

    public cliente() {}

    public cliente(String nome, String Contato) {
        this.nome = nome;
        this.Contato = Contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return Contato;
    }

    public void setContato(String Contato) {
        this.Contato = Contato;
    }

    @Override
    public String toString() {
        return "cliente{\n"
                +"nome: \n" 
                +nome 
                +", Contato: \n"
                +Contato 
                +"\n }";
    }
    
}
