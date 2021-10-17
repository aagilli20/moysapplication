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
public class MedioBoleto {
    private ArrayList<String> MBAlumno;
    private ArrayList<String> MBDocumento;
    private ArrayList<String> MBMensaje;
    private ArrayList<String> MBEstado;
    private ArrayList<String> MBObservacion;
    
    public MedioBoleto(){
        this.MBAlumno = new ArrayList<>();
        this.MBDocumento = new ArrayList<>();
        this.MBMensaje = new ArrayList<>();
        this.MBEstado = new ArrayList<>();
        this.MBObservacion = new ArrayList<>();
    }
    
    public int getSize(){
        return this.MBAlumno.size();
    }
    
    public String getMBAlumno(int index){
        return this.MBAlumno.get(index);
    }
    
    public String getMBDocumento(int index){
        return this.MBDocumento.get(index);
    }
    
    public String getMBMensaje(int index){
        return this.MBMensaje.get(index);
    }
    
    public String getMBEstado(int index){
        return this.MBEstado.get(index);
    }
    
    public String getMBObservacion(int index){
        return this.MBObservacion.get(index);
    }
    
    public void loadMedioBoleto(String codJuris) throws IOException{
        readExcel data = new readExcel();
        int idSQL = 50187;
        String param = "&PNivel=&PDependencia=&PSnep="+codJuris+"&PEstado=&PNombreArchivo=MedBolPend";
        ArrayList<ArrayList<String>> resultados = data.getArrayList(idSQL, param);
        int finY = resultados.size();
        for(int i=1;i<finY;i++){
            MBAlumno.add(resultados.get(i).get(5));
            MBDocumento.add(resultados.get(i).get(6));
            MBMensaje.add(resultados.get(i).get(8));
            MBEstado.add(resultados.get(i).get(9));
            MBObservacion.add(resultados.get(i).get(10));
        }
    }
}
