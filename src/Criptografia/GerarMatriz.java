/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Criptografia;

/**
 *
 * @author gabrieli
 */
public class GerarMatriz {
    
    public char[][] gerarMatriz() {
        int contador;
        GerarAlfabeto g = new GerarAlfabeto();
        char abcTemp[] = g.gerarAlfabeto();
        char abc[] = new char[abcTemp.length * 2];

        System.out.println(" na matriz");
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
       //System.out.println("retorno da matriz: "+matriz);
        return matriz;
    } 
    
}
