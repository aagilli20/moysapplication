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
public class Agente {
    
    private ArrayList<String> IdAgente;
    private ArrayList<String> Documento;
    private ArrayList<String> ApellidoNombre;
    private ArrayList<String> Sexo;
    
    public Agente(){
        this.IdAgente = new ArrayList<>();
        this.Documento = new ArrayList<>();
        this.ApellidoNombre = new ArrayList<>();
        this.Sexo = new ArrayList<>();
    }
    
    /*
    * Acceso a datos
    */
    
    public int getSize(){return this.IdAgente.size();}
    
    public String getIdAgente(int indice){
        return this.IdAgente.get(indice);
    }
    
    public String getDocumento(int indice){
        return this.Documento.get(indice);
    }
    
    public String getApellidoNombre(int indice){
        return this.ApellidoNombre.get(indice);
    }
    
    public String getSexo(int indice){
        return this.Sexo.get(indice);
    }
    
    /*
    * Cargar a datos
    */
    
    public void loadAgente(String nro_documento) throws IOException{
        readExcel data = new readExcel();
        int idSQL = 52001;
        String param = "&PDocumento="+nro_documento+"&PNombreArchivo=Agente";
        ArrayList<ArrayList<String>> resultados = data.getArrayList(idSQL, param);
        int finY = resultados.size();
        for(int i=1;i<finY;i++){
            IdAgente.add(resultados.get(i).get(0));
            Documento.add(resultados.get(i).get(1));
            ApellidoNombre.add(resultados.get(i).get(2));
            Sexo.add(resultados.get(i).get(3));
        }
    }
    
}
