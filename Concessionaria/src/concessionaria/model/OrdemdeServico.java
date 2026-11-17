package concessionaria.model;
public class OrdemdeServico{
    private int codigo_deServico;
    private String servico;
    private String pagamento;
    private int cliente_id;
    private int veiculo_id;
    
    public OrdemdeServico() {
    }

    public OrdemdeServico(String servico, String pagamento) {
        this.servico = servico;
        this.pagamento = pagamento;
    }
    
    

    public OrdemdeServico(int codigo_deServico, String servico, String pagamento, int cliente_id, int veiculo_id) {
        this.codigo_deServico = codigo_deServico;
        this.servico = servico;
        this.pagamento = pagamento;
        this.cliente_id = cliente_id;
        this.veiculo_id = veiculo_id;
    }
    
    
    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getVeiculo_id() {
        return veiculo_id;
    }

    public void setVeiculo_id(int veiculo_id) {
        this.veiculo_id = veiculo_id;
    }

  

    public int getCodigo_deServico() {
        return codigo_deServico;
    }

    public void setCodigo_deServico(int codigo_deServico) {
        this.codigo_deServico = codigo_deServico;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public String toString() {
        return "OrdemdeServico{" + "codigo_deServico=" + codigo_deServico + ", servico=" + servico + ", pagamento=" + pagamento + '}';
    }

    
    
    
   
}
