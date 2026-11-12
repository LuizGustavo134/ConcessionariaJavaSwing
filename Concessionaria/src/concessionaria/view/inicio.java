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
        botaoFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Bem vindo ");

        jLabel2.setText("O que deseja fazer? ");

        jLabel3.setText("Auto prime Mecânicas & vendas");

        BotaoModificar.setText("Alterar serviço");
        BotaoModificar.addActionListener(this::BotaoModificarActionPerformed);

        BotaoCadastrar.setText("Pedir serviço");
        BotaoCadastrar.addActionListener(this::BotaoCadastrarActionPerformed);

        BotaoChecar.setText("Verificar status");
        BotaoChecar.addActionListener(this::BotaoChecarActionPerformed);

        botaoFechar.setText("Fechar programa");
        botaoFechar.addActionListener(this::botaoFecharActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BotaoCadastrar)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(BotaoModificar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(BotaoChecar))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botaoFechar)
                                .addGap(119, 119, 119))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel1)))))
                .addContainerGap(30, Short.MAX_VALUE))
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
                .addGap(64, 64, 64)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void BotaoModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoModificarActionPerformed
     
    }//GEN-LAST:event_BotaoModificarActionPerformed

    private void BotaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCadastrarActionPerformed
        aute.IDForm();
        //logica
    if (aute.isAutorização() == true){
        dispose();
        tela2.setVisible(true);// cadastro
    }else if (aute.getTentativas() >= 3){
        aute.Check();   
        dispose();
        System.exit(0);
    }
    }//GEN-LAST:event_BotaoCadastrarActionPerformed

    private void BotaoChecarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoChecarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoChecarActionPerformed

    private void botaoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharActionPerformed
       dispose();
       System.exit(0);
    }//GEN-LAST:event_botaoFecharActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new inicio().setVisible(true));
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoCadastrar;
    private javax.swing.JButton BotaoChecar;
    private javax.swing.JButton BotaoModificar;
    private javax.swing.JButton botaoFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
