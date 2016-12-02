/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Criptografia;

import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author gabrieli
 */
public class Alfanumerico {
       
    public Alfanumerico(){
    }
    
    public String codifica(String str) {
        return new Base64().encodeToString(str.getBytes());
    }

    public String decodifica(String str) {
        return new String(new Base64().decode(str));
    }
}


