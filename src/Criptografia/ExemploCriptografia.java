
package Criptografia;

import java.text.Normalizer;

public class ExemploCriptografia {
    
    public static void main(String[] args) {
       CodCifraDeVigenere criptografar = new CodCifraDeVigenere("#_Efhj");
            System.out.println(criptografar.cifrar());
 }
    
    public String GeraCriptografia(String senha, int cod){
        String retorno="";
        
        if (cod==1) {
            //criptografar
            CodCifraDeVigenere criptografar = new CodCifraDeVigenere(senha);
            retorno = criptografar.cifrar();
            System.out.println("senha criptografada: "+ retorno);
            
        } else if(cod==2){
            //descriptografar
            CodCifraDeVigenere descriptografar = new CodCifraDeVigenere(senha);
            retorno = descriptografar.decifrar();
            System.out.println("senha descriptografada: "+ retorno);
        }
        
        return retorno;
    }

    
    
}
