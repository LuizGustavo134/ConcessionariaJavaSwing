package concessionaria.model;
/* classe que representa, ela vai completar vai ser um um conjuto para 
o DB com a classe serviço*/
public class cliente {
    private int id;
    private String nome;
    private String Contato;

    public cliente() {}

    public cliente(String nome, String Contato) { //contrutor para tela solicitação
        this.nome = nome;
        this.Contato = Contato;
    }
    
    
    public cliente(int id, String nome, String Contato) {
        this.id = id;
        this.nome = nome;
        this.Contato = Contato;
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

    public String getContato() {
        return Contato;
    }

    public void setContato(String Contato) {
        this.Contato = Contato;
    }

   
    
}
