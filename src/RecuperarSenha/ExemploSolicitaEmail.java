package RecuperarSenha;

import RecuperarSenha.RecuperarSenha;

/**
 *
 * @author gabrieli
 */
public class ExemploSolicitaEmail {
    
    public static void main (String args[]){
        try{
            RecuperarSenha email = new RecuperarSenha();
            email.EnviarEmail("gabrielihendges@gmail.com", "123456");
            
        }catch(Exception ex){
            
        }
    }
}
