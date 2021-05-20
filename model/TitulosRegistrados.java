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
public class TitulosRegistrados {
    
    private ArrayList<String> Establecimiento;
    private ArrayList<String> Plan;
    private ArrayList<String> Titulo;
    private ArrayList<String> ValidezNacional;
    private ArrayList<String> TipoSolicitud;
    private ArrayList<String> EstadoSolicitud;
    private ArrayList<String> FechaSolicitud;
    private ArrayList<String> FechaSolicitudReal;
    
    
    public TitulosRegistrados(){
        this.Establecimiento = new ArrayList<>();
        this.Plan = new ArrayList<>();
        this.Titulo = new ArrayList<>();
        this.TipoSolicitud  = new ArrayList<>();
        this.ValidezNacional = new ArrayList<>();
        this.EstadoSolicitud  = new ArrayList<>();
        this.FechaSolicitud = new ArrayList<>();
        this.FechaSolicitudReal = new ArrayList<>();
        
    }
    
    public int getSize(){
        return this.Establecimiento.size();
    }
    
    public String getEstablecimiento(int index){
        return this.Establecimiento.get(index);
    }
    
    public String getPlan(int index){
        return this.Plan.get(index);
    }
    
    public String getTitulo(int index){
        return this.Titulo.get(index);
    }
    
    public String getValidezNacional(int index){
        return this.ValidezNacional.get(index);
    }
    
    public String getTipoSolicitud(int index){
        return this.TipoSolicitud.get(index);
    }
    
    public String getEstadoSolicitud(int index){
        return this.EstadoSolicitud.get(index);
    }
    
    public String getCicloLectio(int index){
        return this.FechaSolicitud.get(index);
    }
    
    public String getFechaSolicitud(int index){
        return this.FechaSolicitud.get(index);
    }
    
    public String getFechaSolicitudReal(int index){
        return this.FechaSolicitudReal.get(index);
    }
    
    
    public void loadTitulosRegistrados(String nro_documento, String sexo) throws IOException{
        readExcel data = new readExcel();
        // cargamos los codigos jurisdiccionales
        int idSQL = 624;
        String param = "&PNRODOCUMENTO="+nro_documento+"&PIDALUMNO=&PNombreArchivo=TitulosReg";
        ArrayList<ArrayList<String>> resultados = data.getArrayList(idSQL, param);
        int finY = resultados.size();
        for(int i=1;i<finY;i++){
            if(resultados.get(i).get(1).equals(sexo)){
                this.Establecimiento.add(resultados.get(i).get(3));
                this.Plan.add(resultados.get(i).get(4));
                this.Titulo.add(resultados.get(i).get(5));
                this.ValidezNacional.add(resultados.get(i).get(6));
                this.TipoSolicitud.add(resultados.get(i).get(7));
                this.EstadoSolicitud.add(resultados.get(i).get(8));
                this.FechaSolicitud.add(resultados.get(i).get(9));
                this.FechaSolicitudReal.add(resultados.get(i).get(10));
            }
        }
        if(this.getSize() == 0) {
            this.Establecimiento.add("El Alumno no cuenta con Títulos Legalizados desde Sigae");
            this.Plan.add("");
            this.Titulo.add("");
            this.ValidezNacional.add("");
            this.TipoSolicitud.add("");
            this.EstadoSolicitud.add("");
            this.FechaSolicitud.add("");
            this.FechaSolicitudReal.add("");
        }
    }
    
}
