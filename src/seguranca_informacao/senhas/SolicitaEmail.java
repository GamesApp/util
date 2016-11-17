package seguranca_informacao.senhas;

import seguranca_informacao.senhas.RecuperarSenha;

/**
 *
 * @author gabrieli
 */
public class SolicitaEmail {
    
    public static void main (String args[]){
        try{
            RecuperarSenha email = new RecuperarSenha();
            email.EnviarEmail("gustavohein123@gmail.com", "123456");
            
        }catch(Exception ex){
            
        }
    }
}
