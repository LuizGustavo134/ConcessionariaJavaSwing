package concessionaria.model;
public class Servico {
private int idServico;
private String tipoServico;
private String pagamento;
private String horario;

    public Servico() {
    }

    public Servico(int idServico, String tipoServico, String pagamento, String horario) {
        this.idServico = idServico;
        this.tipoServico = tipoServico;
        this.pagamento = pagamento;
        this.horario = horario;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Servico{" + "idServico=" + idServico + ", tipoServico=" + tipoServico + ", pagamento=" + pagamento + ", horario=" + horario + '}';
    }


}
