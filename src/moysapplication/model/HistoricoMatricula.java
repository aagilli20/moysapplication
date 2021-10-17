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
public class HistoricoMatricula {
    private ArrayList<String> HMCicloLectivo;
    private ArrayList<String> HMSeccion;
    private ArrayList<String> HMAlumno;
    private ArrayList<String> HMMatricula;
    
    public HistoricoMatricula(){
        this.HMCicloLectivo = new ArrayList<>();
        this.HMSeccion = new ArrayList<>();
        this.HMAlumno = new ArrayList<>();
        this.HMMatricula = new ArrayList<>();
    }
    
    public int getSize(){
        return this.HMCicloLectivo.size();
    }
    
    public String getHMCicloLectivo(int index){
        return this.HMCicloLectivo.get(index);
    }
    
    public String getHMSeccion(int index){
        return this.HMSeccion.get(index);
    }
    
    public String getHMAlumno(int index){
        return this.HMAlumno.get(index);
    }
    
    public String getHMMatricula(int index){
        return this.HMMatricula.get(index);
    }
    
    public void loadHistoricoMatricula(int nro_organismo) throws IOException{
        readExcel data = new readExcel();
        int idSQL = 154;
        String param = "&PEscuela="+nro_organismo+"&PNombreArchivo=HistMatricula";
        ArrayList<ArrayList<String>> resultados = data.getArrayList(idSQL, param);
        int finY = resultados.size();
        for(int i=1;i<finY;i++){
            HMCicloLectivo.add(resultados.get(i).get(0));
            HMSeccion.add(resultados.get(i).get(1));
            HMAlumno.add(resultados.get(i).get(2));
            HMMatricula.add(resultados.get(i).get(3));
        }
    }
}
