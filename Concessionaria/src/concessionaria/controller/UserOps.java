package concessionaria.controller;
import concessionaria.model.*;
import concessionaria.view.telaCadastro;
import javax.swing.JOptionPane;


public class UserOps {
            public void Registrar(cliente novoCliente,Veiculo novoVeiculo,OrdemdeServico novoServico){
                Operations op = new Operations();
                int idCliente = op.inserirCliente(novoCliente);
                int idVeiculo = op.inserirVeiculo(novoVeiculo);
                if (idCliente == -1 || idVeiculo == -1) {
                    return;
                }
                novoServico.setCliente_id(idCliente);
                novoServico.setVeiculo_id(idVeiculo);

op.inserirServico(novoServico);
                JOptionPane.showMessageDialog(null,
            "Operação bem sucedida",
            "Dados enviados com sucesso",
            JOptionPane.INFORMATION_MESSAGE);
            
            }
}
