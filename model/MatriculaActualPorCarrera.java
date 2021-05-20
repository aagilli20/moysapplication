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
public class MatriculaActualPorCarrera {
    
    private ArrayList<String> MAPCCicloLectivo;
    private ArrayList<String> MAPCNivel;
    private ArrayList<String> MAPCCarrera;
    private ArrayList<String> MAPCSeccion;
    private ArrayList<String> MAPCAlumno;
    private ArrayList<String> MAPCMatricula;
    
    public MatriculaActualPorCarrera(){
        this.MAPCCicloLectivo = new ArrayList<>();
        this.MAPCNivel = new ArrayList<>();
        this.MAPCCarrera = new ArrayList<>();
        this.MAPCSeccion = new ArrayList<>();
        this.MAPCAlumno = new ArrayList<>();
        this.MAPCMatricula = new ArrayList<>();
    }
    
    public int getSize(){
        return this.MAPCCicloLectivo.size();
    }
    
    public String getMAPCCicloLectivo(int index){
        return this.MAPCCicloLectivo.get(index);
    }
    
    public String getMAPCNivel(int index){
        return this.MAPCNivel.get(index);
    }
    
    public String getMAPCCarrera(int index){
        return this.MAPCCarrera.get(index);
    }
    
    public String getMAPCSeccion(int index){
        return this.MAPCSeccion.get(index);
    }
    
    public String getMAPCAlumno(int index){
        return this.MAPCAlumno.get(index);
    }
    
    public String getMAPCMatricula(int index){
        return this.MAPCMatricula.get(index);
    }
    
    public void loadMACA(int nro_organismo) throws IOException{
        readExcel data = new readExcel();
        int idSQL = 438;
        String param = "&PIdOrganismo="+nro_organismo+"&PNombreArchivo=ActualPorCarrera";
        ArrayList<ArrayList<String>> resultados = data.getArrayList(idSQL, param);
        int finY = resultados.size();
        finY -= 1;
        for(int i=1;i<finY;i++){
            MAPCCicloLectivo.add(resultados.get(i).get(0));
            if(resultados.get(i).get(2).isEmpty()) MAPCNivel.add("TOTAL");
            else MAPCNivel.add(resultados.get(i).get(2));
            MAPCCarrera.add(resultados.get(i).get(3));
            MAPCSeccion.add(resultados.get(i).get(4));
            MAPCAlumno.add(resultados.get(i).get(5));
            MAPCMatricula.add(resultados.get(i).get(6));
        }
    }
}
