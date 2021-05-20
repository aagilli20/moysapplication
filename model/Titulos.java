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
public class Titulos {
    
    private String DirectorAutorizado;
    private String CodigoAutorizacion;
    private String PIN;
    
    public Titulos(){
        this.DirectorAutorizado = "";
        this.CodigoAutorizacion = "";
        this.PIN = "";
    }
    
    public void loadTitulos(String codJuris) throws IOException{
        readExcel data = new readExcel();
        int idSQL = 50757;
        String param = "&PDocumento=&PSNEP="+codJuris+"&PEstadoFiltro=&PCodigo=&PNombreArchivo=PINES";
        ArrayList<ArrayList<String>> resultados = data.getArrayList(idSQL, param);
        int finY = resultados.size();
        for(int i=1;i<finY;i++){
            if(resultados.get(i).get(9).equals("Autorizada")){
                this.DirectorAutorizado = resultados.get(i).get(8);
                this.CodigoAutorizacion = resultados.get(i).get(3);
                this.PIN = resultados.get(i).get(4);
            }
        }
    }
    
    public String getDirectorAutorizado(){return this.DirectorAutorizado;}
    public String getCodigoAutorizacion(){return this.CodigoAutorizacion;}
    public String getPIN(){return this.PIN;}
    
}
