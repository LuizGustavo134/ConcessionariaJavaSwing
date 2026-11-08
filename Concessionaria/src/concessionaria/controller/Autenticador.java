package concessionaria.controller;

import concessionaria.model.Maneger;
import javax.swing.JOptionPane;

//Logica de autenticação
public class Autenticador {
     private boolean autorização;
     private String nomeTemp;
     private String senhaTemp;
     private int tentativas = 0;
    public void IDForm(){
        Maneger mane = new Maneger();
            JOptionPane.showMessageDialog(null,
            "Bem-vindo ao setor administrativo!",
            "Acesso ADM",
            JOptionPane.INFORMATION_MESSAGE);
            
             String nomeTemp = JOptionPane.showInputDialog(null,
            "Digite seu ID:",
            "Identificação",
            JOptionPane.QUESTION_MESSAGE);

            String senhaTemp = JOptionPane.showInputDialog(null,
            "Digite sua senha:",
            "Autenticação",
            JOptionPane.QUESTION_MESSAGE);
            if (nomeTemp.equalsIgnoreCase(mane.getNome())&& senhaTemp.equalsIgnoreCase(mane.getSenha())){
            autorização = true;
            nomeTemp = " ";
            senhaTemp = " ";
            }else {
            autorização = false;
            nomeTemp = " ";
            senhaTemp = " ";
            tentativas += 1;
            
            }
    }
            public void Check(){
            if (tentativas == 3){
                    JOptionPane.showMessageDialog(null,
                    "Limite de tentativas atingido: "+ tentativas,
                    "Alerta",
                    JOptionPane.INFORMATION_MESSAGE);}
          
            }
    public boolean isAutorização() {
        return autorização;
    }

    public int getTentativas() {
        return tentativas;
    }
    
}
