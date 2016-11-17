
package seguranca_informacao.senhas;

import java.text.Normalizer;

public class Criptografia {
    
    public static void main(String[] args) {
        
        CifraDeVigenere cvcifrar = new CifraDeVigenere("olabrasil", "bolo");
        System.out.println("cifrado: "+ cvcifrar.cifrar());
        String msgdecifrar=cvcifrar.cifrar();
        
        CifraDeVigenere cvdecifrar = new CifraDeVigenere(msgdecifrar, "bolo");
        System.out.println("decifrado: "+ cvdecifrar.decifrar());
        
 }

    
    public static class GerarAlfabeto {
        //Cria um array de characteres com 96 posições
        public char[] gerarAlfabeto() {
        char[] abc = new char[96];

        for (int i = 32; i <= 127; i++) {
            abc[i - 32] = (char) i;
        }
        return abc;
        }
    }
    
    public static class GenerarMatriz {
 
    public char[][] generarMatriz() {
        int contador;
        GerarAlfabeto g = new GerarAlfabeto();
        char abcTemp[] = g.gerarAlfabeto();
        char abc[] = new char[abcTemp.length * 2];

       for (int c = 0; c < 96; c++) {
           abc[c] = abcTemp[c];
           abc[c + 96] = abcTemp[c];
        }

       char[][] matriz = new char[96][96];

       for (int i = 0; i < 96; i++) {
           contador = 0;

           for (int j = 0; j < 96; j++) {
               matriz[i][j] = abc[contador + i];
               contador++;
            }
       }
        return matriz;
    } 
}
    
    public static class CifraDeVigenere{
   
    char[] mensagem;
    char[] chave;
    char[] resultado;
    char matriz[][];
    char[] texto;

    //construtor
    public CifraDeVigenere(String msg, String chave) {
        msg = RetiraAcento(msg);
        this.mensagem = msg.toCharArray(); //converte a msg para um array
        char[] chaveTemp = chave.toCharArray();
        this.chave = new char[msg.length()];
        int cont = 0;

       for (int i = 0; i < msg.length(); i++) {
           this.chave[i] = chaveTemp[cont];
           cont++;
            if (cont == chaveTemp.length) {
                cont = 0;
             }
        }

       GenerarMatriz gm = new GenerarMatriz();
        this.matriz = gm.generarMatriz();
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
        this.resultado = cifrado;

        for (int i = 0; i < cifrado.length; i++) {
         retorno += cifrado[i];
        }

       /* for(int k = 0;k<96;k++){  MOSTRA MATRIZ
            System.out.println(this.matriz[k]);
        }*/

        return retorno;
    }

    public String decifrar() {
        
        char[] decifrado = new char[mensagem.length];
        String retorno = "";
        int x = 0, y = 0;

        for (int cont = 0; cont < mensagem.length; cont++) {
            x = (int) this.mensagem[cont] - 32;
            y = (int) this.chave[cont] - 32;

        char[] coluna = new char[96];

        for (int i = 0; i < 96; i++) {
            coluna[i] = this.matriz[i][y];
         }

    int a = 0;
    boolean teste = false;
     do {
     if (coluna[a] == mensagem[cont]) {
     break;
     }
     a++;
     } while (teste == false);

    decifrado[cont] = this.matriz[a][0];

    }

    for (int i = 0; i < decifrado.length; i++) {
     retorno += decifrado[i];
     }

    this.resultado = decifrado;
    return retorno;
    
    }
    
    }
    
    
}
