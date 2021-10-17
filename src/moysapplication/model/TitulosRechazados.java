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
public class TitulosRechazados {
   
    private ArrayList<String> Establecimiento;
    private ArrayList<String> Plan;
    private ArrayList<String> TituloImprimir;
    private ArrayList<String> ValidezNacional;
    private ArrayList<String> EstadoSolicitud;
    private ArrayList<String> FechaSolicitud;
    private ArrayList<String> FechaSolicitudReal;
    private ArrayList<String> FechaRechazo;
    private ArrayList<String> MotivoRechazo;
    
    
    public TitulosRechazados(){
        this.Establecimiento = new ArrayList<>();
        this.Plan = new ArrayList<>();
        this.TituloImprimir = new ArrayList<>();
        this.EstadoSolicitud  = new ArrayList<>();
        this.ValidezNacional = new ArrayList<>();
        this.FechaSolicitud  = new ArrayList<>();
        this.FechaSolicitudReal = new ArrayList<>();
        this.FechaRechazo = new ArrayList<>();
        this.MotivoRechazo = new ArrayList<>();
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
    
    public String getTituloImprimir(int index){
        return this.TituloImprimir.get(index);
    }
    
    public String getValidezNacional(int index){
        return this.ValidezNacional.get(index);
    }
    
    public String getEstadoSolicitud(int index){
        return this.EstadoSolicitud.get(index);
    }
    
    public String getFechaSolicitud(int index){
        return this.FechaSolicitud.get(index);
    }
    
    public String getFechaSolicitudReal(int index){
        return this.FechaSolicitudReal.get(index);
    }
    
    public String getCicloLectio(int index){
        return this.FechaSolicitudReal.get(index);
    }
    
    public String getFechaRechazo(int index){
        return this.FechaRechazo.get(index);
    }
    
    public String getMotivoRechazo(int index){
        return this.MotivoRechazo.get(index);
    }
    
    
    public void loadTitulosRechazados(String nro_documento, String sexo) throws IOException{
        readExcel data = new readExcel();
        // cargamos los codigos jurisdiccionales
        int idSQL = 625;
        String param = "&PNRODOCUMENTO="+nro_documento+"&PIDALUMNO=&PNombreArchivo=TitulosRechazados";
        ArrayList<ArrayList<String>> resultados = data.getArrayList(idSQL, param);
        int finY = resultados.size();
        for(int i=1;i<finY;i++){
            if(resultados.get(i).get(1).equals(sexo)){
                this.Establecimiento.add(resultados.get(i).get(3));
                this.Plan.add(resultados.get(i).get(4));
                this.TituloImprimir.add(resultados.get(i).get(5));
                this.ValidezNacional.add(resultados.get(i).get(6));
                this.EstadoSolicitud.add(resultados.get(i).get(7));
                this.FechaSolicitud.add(resultados.get(i).get(8));
                this.FechaSolicitudReal.add(resultados.get(i).get(9));
                this.FechaRechazo.add(resultados.get(i).get(10));
                this.MotivoRechazo.add(resultados.get(i).get(11));
            }
        }
        if(this.getSize() == 0) {
            this.Establecimiento.add("El Alumno no cuenta con Títulos Rechazados desde Sigae");
            this.Plan.add("");
            this.TituloImprimir.add("");
            this.ValidezNacional.add("");
            this.EstadoSolicitud.add("");
            this.FechaSolicitud.add("");
            this.FechaSolicitudReal.add("");
            this.FechaRechazo.add("");
            this.MotivoRechazo.add("");
        }
    }
    
}
