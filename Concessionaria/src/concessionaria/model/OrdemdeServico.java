package concessionaria.model;
public class OrdemdeServico extends Veiculo{
    private int id_servico;
    private String metodo;

    public OrdemdeServico() {
    }

    public OrdemdeServico( String metodo) {
        this.metodo = metodo;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }
    
    
   
}
