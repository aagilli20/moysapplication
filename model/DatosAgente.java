/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moysapplication.model;

import java.io.IOException;
import java.util.ArrayList;
import moysapplication.data.readExcel;

/**
 *
 * @author Andrés Gilli <agilli@santafe.gov.ar>
 */
public class DatosAgente {
    private String FeNac;
    private String Provincia;
    private String Localidad;
    private String Domicilio;
    private String CodPostal;
    private String Telefono;
    private String Celular;
    private String EMail;
    private String ContactoAlt;
    private String FeActu;
    
    public DatosAgente(){
        this.FeNac = "";
        this.Provincia = "";
        this.Localidad = "";
        this.Domicilio = "";
        this.CodPostal = "";
        this.Telefono = "";
        this.Celular = "";
        this.EMail = "";
        this.ContactoAlt = "";
        this.FeActu = "";
    }
    
    /*
    * Acceso a datos
    */
    
    
    public String getFeNac(){
        return this.FeNac;
    }
    
    public String getProvincia(){
        return this.Provincia;
    }
    
    public String getLocalidad(){
        return this.Localidad;
    }
    
    public String getDomicilio(){
        return this.Domicilio;
    }
    
    public String getCodPostal(){
        return this.CodPostal;
    }
    
    public String getTelefono(){
        return this.Telefono;
    }
   
    public String getCelular(){
        return this.Celular;
    }
    
    public String getEMail(){
        return this.EMail;
    }
    
    public String getContactoAlt(){
        return this.ContactoAlt;
    }
     
    public String getFeActu(){
        return this.FeActu;
    }
    
    /*
    * Cargar a datos
    */
    
    public void loadDatosAgente(String nro_documento, String sexo) throws IOException{
        readExcel data = new readExcel();
        int idSQL = 51821;
        String param = "&PNRODOCUMENTO="+nro_documento+"&PNombreArchivo=Legajo";
        ArrayList<ArrayList<String>> resultados = data.getArrayList(idSQL, param);
        int finY = resultados.size();
        for(int i=1;i<finY;i++){
            if(resultados.get(i).get(1).equals(sexo)){
                this.FeNac = resultados.get(i).get(3);
                this.Provincia = resultados.get(i).get(7);
                this.Localidad = resultados.get(i).get(5);
                this.Domicilio = resultados.get(i).get(4);
                this.CodPostal = resultados.get(i).get(6);
                this.Telefono = resultados.get(i).get(8);
                this.Celular = resultados.get(i).get(9);
                this.EMail = resultados.get(i).get(10);
                this.ContactoAlt = resultados.get(i).get(11);
                this.FeActu = resultados.get(i).get(12);
            }
        }
        if(this.FeNac.equals("")) this.FeNac = "No se encontraron los datos del agente";
    }
}
