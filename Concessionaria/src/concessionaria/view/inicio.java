package concessionaria.view;
import concessionaria.controller.Autenticador;
import concessionaria.model.*;
import javax.swing.JOptionPane;

/*Essa classe é o gerenciador de telas 
É por aqui que o fluxo vai ser organizado*/
public class inicio extends javax.swing.JFrame {
    Solicitacao sol = new Solicitacao();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(inicio.class.getName());
     Autenticador aute = new Autenticador();
     telaCadastro tela2 = new telaCadastro();
    public inicio() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BotaoModificar = new javax.swing.JButton();
        BotaoCadastrar = new javax.swing.JButton();
        BotaoChecar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        BotaoSolicitar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Bem vindo ");

        jLabel2.setText("O que deseja fazer? ");

        jLabel3.setText("Auto prime Mecânicas & vendas");

        BotaoModificar.setText("Modificar Solicitação");
        BotaoModificar.addActionListener(this::BotaoModificarActionPerformed);

        BotaoCadastrar.setText("Cadastrar");
        BotaoCadastrar.addActionListener(this::BotaoCadastrarActionPerformed);

        BotaoChecar.setText("Verificar status");
        BotaoChecar.addActionListener(this::BotaoChecarActionPerformed);

        BotaoSolicitar1.setText("Solicitar serviço");
        BotaoSolicitar1.addActionListener(this::BotaoSolicitar1ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotaoCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoModificar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(BotaoSolicitar1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotaoChecar)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoChecar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotaoSolicitar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void BotaoModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoModificarActionPerformed
       JOptionPane.showMessageDialog(null,
            "Bem-vindo ao setor administrativo!",
            "Acesso ADM",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_BotaoModificarActionPerformed

    private void BotaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCadastrarActionPerformed
    //esse botão aciona o metodo de validação de usuario
    aute.IDForm(); // questionario
    
    //logica
    if (aute.isAutorização() == true){
        dispose();
        tela2.setVisible(true);// cadastro
    }else{
          
            aute.Check();
            dispose();
    }
    }//GEN-LAST:event_BotaoCadastrarActionPerformed

    private void BotaoChecarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoChecarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoChecarActionPerformed

    private void BotaoSolicitar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSolicitar1ActionPerformed
        dispose();
        sol.setVisible(true);
        
    }//GEN-LAST:event_BotaoSolicitar1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new inicio().setVisible(true));
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoCadastrar;
    private javax.swing.JButton BotaoChecar;
    private javax.swing.JButton BotaoModificar;
    private javax.swing.JButton BotaoSolicitar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
