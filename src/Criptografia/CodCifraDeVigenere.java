
package Criptografia;

import java.text.Normalizer;

/**
 *
 * @author gabrieli
 */
public class CodCifraDeVigenere {
    
    char[] mensagem;
    char[] chave;
    char [][] matriz;
    String chaveFixa="ifsul";

    //construtor
    public CodCifraDeVigenere(String senha) {
        senha = RetiraAcento(senha);
        this.mensagem = senha.toCharArray(); //converte a msg para um array
        char[] chaveArray = chaveFixa.toCharArray(); //converte a chave para um array
        this.chave = new char[senha.length()];
        int cont = 0;

       for (int i = 0; i < senha.length(); i++) {
           this.chave[i] = chaveArray[cont];
           cont++;
            if (cont == chaveArray.length) {
                cont = 0;
             }
            
        }
        System.out.println("Antes de gerar a matriz");

       GerarMatriz gerar = new GerarMatriz();
       this.matriz = gerar.gerarMatriz();
     }

     public String RetiraAcento(String str) {
        
         str = Normalizer.normalize(str, Normalizer.Form.NFD);
         str = str.replaceAll("[^\\p{ASCII}]", "");
         return str; 
     }

    public String cifrar() {

        char[] cifrado = new char[mensagem.length];
        String retorno = "";
        int x, y;

        for (int cont = 0; cont < mensagem.length; cont++) {
            x = (int) this.mensagem[cont] - 32;
            y = (int) this.chave[cont] - 32;
            cifrado[cont] = this.matriz[x][y];
         }

        for (int i = 0; i < cifrado.length; i++) {
         retorno += cifrado[i];
        }

       /*for(int k = 0;k<96;k++){ // MOSTRA MATRIZ
            System.out.println(this.matriz[k]);
        }*/
        
        String senhaAlfa= new Alfanumerico().codifica(retorno);
        System.out.println("Vigenere: "+retorno);
        return senhaAlfa;
    }

    public String decifrar() {
        
        char[] decifrado = new char[mensagem.length];
        String retorno = "";
        int x = 0, y = 0;

        for (int nav = 0; nav < mensagem.length; nav++) {
            x = (int) this.mensagem[nav] - 32;
            y = (int) this.chave[nav] - 32;

            char[] coluna = new char[96];

            for (int i = 0; i < 96; i++) {
                coluna[i] = this.matriz[i][y];
             }

            int a = 0;
            boolean teste = false;
            
            while (teste == false){
                if (coluna[a] == mensagem[nav]) {
                break;
                }
                a++;
            } 
            decifrado[nav] = this.matriz[a][0];
        }

        for (int i = 0; i < decifrado.length; i++) {
         retorno += decifrado[i];
         }

        String senhaAlfa= new Alfanumerico().decodifica(retorno);
        return senhaAlfa;

    }
}
