package concessionaria.controller;
import javax.swing.JOptionPane;

//Logica de autenticação
public class Autenticador {
     private boolean autorização;
     private String nomeTemp;
     private String senhaTemp;
     private int tentativas = 0;
     Operations op = new Operations();
    public void IDForm(){         
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
            "Identificação",
            JOptionPane.QUESTION_MESSAGE);
            
            autorização = op.verificarAcesso(nomeTemp, senhaTemp);
            if (autorização == true){ 
            nomeTemp = " ";
            senhaTemp = " ";
            }else {
                 JOptionPane.showMessageDialog(null,
                "Aviso",
                "Dados incorretos!",
            JOptionPane.INFORMATION_MESSAGE);
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
