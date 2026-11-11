package concessionaria.view;

import javax.swing.JOptionPane;
import concessionaria.model.Carro;
import concessionaria.controller.*;
/* tela de cadastro Insert */
public class telaCadastro extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(telaCadastro.class.getName());
    public telaCadastro() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        preco = new javax.swing.JTextField();
        Veiculo = new javax.swing.JLabel();
        marca = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 1), new java.awt.Dimension(0, 1), new java.awt.Dimension(32767, 1));
        Veiculo1 = new javax.swing.JLabel();
        Veiculo2 = new javax.swing.JLabel();
        Veiculo3 = new javax.swing.JLabel();
        Veiculo4 = new javax.swing.JLabel();
        botaoEnviar = new javax.swing.JButton();
        Ano = new javax.swing.JTextField();
        Quantidade = new javax.swing.JTextField();
        Veiculo5 = new javax.swing.JLabel();
        botaoVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        preco.addActionListener(this::precoActionPerformed);

        Veiculo.setText("    Cadastro de veiculos");

        marca.addActionListener(this::marcaActionPerformed);

        Veiculo2.setText("Marca/modelo");

        Veiculo3.setText("      Ano:");

        Veiculo4.setText("   valor de venda");

        botaoEnviar.setText("Enviar");
        botaoEnviar.addActionListener(this::botaoEnviarActionPerformed);

        Ano.addActionListener(this::AnoActionPerformed);

        Quantidade.addActionListener(this::QuantidadeActionPerformed);

        Veiculo5.setText("    Quantidade");

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(this::botaoVoltarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Veiculo)
                            .addComponent(Veiculo2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(Veiculo4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(preco, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Ano, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(Veiculo3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(Veiculo5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botaoVoltar)
                                    .addComponent(botaoEnviar))))
                        .addGap(92, 92, 92)))
                .addComponent(Veiculo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(48, 48, 48))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 197, Short.MAX_VALUE)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 198, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Veiculo1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(Veiculo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Veiculo2)
                .addGap(18, 18, 18)
                .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Veiculo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Veiculo4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Veiculo5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoEnviar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoVoltar)
                .addGap(0, 22, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 196, Short.MAX_VALUE)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 197, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void precoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precoActionPerformed

    private void marcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marcaActionPerformed

    private void botaoEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEnviarActionPerformed
        if (marca.getText().isEmpty()|| Ano.getText().isEmpty()|| preco.getText().isEmpty()||Quantidade.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,
            "Aviso!!!",
            "Preencha todos os dados!!!",
            JOptionPane.INFORMATION_MESSAGE);
    }else{     
        String marcaTemp = marca.getText();
        int anoTemp = Integer.parseInt(Ano.getText());
        double campoPreco = Double.parseDouble(preco.getText());
        int quanTemp = Integer.parseInt(Quantidade.getText()); 
       
        Carro novoCarro = new Carro(marcaTemp,anoTemp,campoPreco,quanTemp);
        Operations op = new Operations();
        op.inserir(novoCarro);
                }
    }//GEN-LAST:event_botaoEnviarActionPerformed

    private void AnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnoActionPerformed

    private void QuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuantidadeActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        dispose();
        inicio telaInicio = new inicio();
        telaInicio.setVisible(true);
    }//GEN-LAST:event_botaoVoltarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new telaCadastro().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Ano;
    private javax.swing.JTextField Quantidade;
    private javax.swing.JLabel Veiculo;
    private javax.swing.JLabel Veiculo1;
    private javax.swing.JLabel Veiculo2;
    private javax.swing.JLabel Veiculo3;
    private javax.swing.JLabel Veiculo4;
    private javax.swing.JLabel Veiculo5;
    private javax.swing.JButton botaoEnviar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JTextField marca;
    private javax.swing.JTextField preco;
    // End of variables declaration//GEN-END:variables
}
