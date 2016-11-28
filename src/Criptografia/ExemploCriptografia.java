
package Criptografia;

import java.text.Normalizer;

public class ExemploCriptografia {
    
    public static void main(String[] args) {
        
        CodCifraDeVigenere cvcifrar = new CodCifraDeVigenere("é_quarterão-2016");
        System.out.println("cifrado: "+ cvcifrar.cifrar());
        String msgdecifrar=cvcifrar.cifrar();
        
        CodCifraDeVigenere cvdecifrar = new CodCifraDeVigenere(msgdecifrar);
        System.out.println("decifrado: "+ cvdecifrar.decifrar());
        
 }

    
    
}
