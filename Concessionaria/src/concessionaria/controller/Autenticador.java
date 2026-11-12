package concessionaria.controller;
import concessionaria.model.cliente;
import javax.swing.JOptionPane;

//Logica de autenticação
public class Autenticador {
     private boolean autorização;
     private int tentativas = 0;
     Operations op = new Operations();
    public void IDForm(){         
            JOptionPane.showMessageDialog(null,
            "Obrigado por escolher nossos serviços!",
            "Bem-vindo a concessionária auto prime!",
            JOptionPane.INFORMATION_MESSAGE);
            
             String userNome = JOptionPane.showInputDialog(null,
            "Informe seu nome:",
            "Olá",
            JOptionPane.QUESTION_MESSAGE);
               
            String userContato = JOptionPane.showInputDialog(null,
            "informe seu meio de contato:",
            "Olá",
            JOptionPane.QUESTION_MESSAGE);
            
            if (userNome == null || userContato == null){ // verifica se o Usuario digitou algo
            JOptionPane.showMessageDialog(null,
                "Aviso",
                "Preencha os dados para prosseguir!",
            JOptionPane.INFORMATION_MESSAGE);
            autorização = false;
            tentativas += 1;
            }else {
                 cliente novoCliente = new cliente(userNome, userContato);//objeto 1

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
