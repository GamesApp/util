package seguranca_informacao.senhas;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author gabrieli
 */
public class RecuperarSenha {

    public RecuperarSenha() { }
    
    public void EnviarEmail(String user, String senha){
      
        try {
             Email email = new SimpleEmail();
                email.setHostName("smtp.googlemail.com");
                //email.setSmtpPort(465);
                email.setAuthentication("contatogamesapp@gmail.com", "gamesifsul");
                email.setSSLOnConnect(true);
                email.setFrom("user@gmail.com");
                email.setSubject("Recuperação de senha GamesApp ");
                String msg = "Prezado(a) aluno(a), \nDetectamos um pedido para recuperação de senha no aplicativo GamesApp! \nSua senha é: "+ senha;
                email.setMsg(msg);
                email.addTo(user);
                email.send();
            
        } catch (EmailException ex) {
            Logger.getLogger(RecuperarSenha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
