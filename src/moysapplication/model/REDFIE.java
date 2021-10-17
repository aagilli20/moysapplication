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
public class REDFIE {
    private ArrayList<String> Descripcion;
    private ArrayList<String> Observacion;
   
    
    public REDFIE(){
        this.Descripcion = new ArrayList<>();
        this.Observacion = new ArrayList<>();
    }
    
    public int getSize(){
        return this.Descripcion.size();
    }
    
    public String getDescripcion(int index){
        return this.Descripcion.get(index);
    }
    
    public String getObservacion(int index){
        return this.Observacion.get(index);
    }
    
       
    public void loadREDFIE(int nro_organismo) throws IOException{
        readExcel data = new readExcel();
        int idSQL = 616;
        String param = "&PCodError=-1&PNroOrgan="+nro_organismo+"&PNombreArchivo=InconsistenciaRedfie";
        ArrayList<ArrayList<String>> resultados = data.getArrayList(idSQL, param);
        int finY = resultados.size();
        for(int i=1;i<finY;i++){
            Descripcion.add(resultados.get(i).get(0));
            Observacion.add(resultados.get(i).get(1));
        }
        if(Descripcion.size() == 1){
            if(Descripcion.get(0).equals("-")) Descripcion.set(0, "La escuela no registra inconsistencias");
        }
    }
}
