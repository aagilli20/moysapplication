/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moysapplication.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import moysapplication.data.NPMoysConnect;
import moysapplication.model.User;


/**
 *
 * @author Andrés Gilli <agilli@santafe.gov.ar>
 */
public class Authenticator {
    
    /*
     * retorna -1 si hay error en el usuario
     * retorna -2 si hay error en la contraseña
     */
    
    public static User validate(String user, String password) throws NoSuchAlgorithmException, SQLException{
        NPMoysConnect dbNPMoys = new NPMoysConnect();
        User dbUser = dbNPMoys.getUser(user);
        // si userType es -1 ya sabemos que hay error de usuario, por lo tanto retorna
        if(dbUser.getUserType() != -1){
            // si falla esta condicion hay error de contraseña
            // entonces setamos userType a -2
            if(! dbUser.getUserPassword().equals(toSHA1(password))){
                // contraseña invalida
                dbUser.setUserType(-2);
                System.out.println("Contraseña invalida");
                return dbUser;
            }
        }
        return dbUser;
    }
    
    
     /***
    * Codifica el string @cadena a su equivalente en SHA1
    */
    
    private static String toSHA1(String word) throws NoSuchAlgorithmException{
        String hash;
        // seteo del tipo de codificacion
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        // conversion de cadena a bytes
        byte [] bytePass = word.getBytes();
        // codificacion de la cadena
        messageDigest.update(bytePass);
        // completa la codificacion
        byte [] digest = messageDigest.digest();
        // convierte la cadena a string usando valores hexadecimales
        hash = toHexa(digest);
        return hash;
    }

     /***
    * Convierte un arreglo de bytes a String usando valores hexadecimales
    * @param digest arreglo de bytes a convertir
    * @return String creado a partir de <code>digest</code>
    */
    
    private static String toHexa(byte[] digest){
        String hash = "";
	for(byte aux : digest) {
            int b = aux & 0xff;
	    if (Integer.toHexString(b).length() == 1) hash += "0";
	    hash += Integer.toHexString(b);
	}
	return hash;
    }
}