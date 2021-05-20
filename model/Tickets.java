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
public class Tickets {
    private ArrayList<String> IdTicket;
    private ArrayList<String> Tema;
    private ArrayList<String> Subtema;
    private ArrayList<String> Consulta;
    private ArrayList<String> FechaCreacion;
    private ArrayList<String> FechaActualizacion;
    
    public Tickets(){
        this.IdTicket = new ArrayList<>();
        this.Tema = new ArrayList<>();
        this.Subtema = new ArrayList<>();
        this.Consulta = new ArrayList<>();
        this.FechaCreacion = new ArrayList<>();
        this.FechaActualizacion = new ArrayList<>();
    }
    
    public int getSize(){
        return this.IdTicket.size();
    }
    
    public String getIdTicket(int index){
        return this.IdTicket.get(index);
    }
    
    public String getTema(int index){
        return this.Tema.get(index);
    }
    
    public String getSubtema(int index){
        return this.Subtema.get(index);
    }
    
    public String getConsulta(int index){
        return this.Consulta.get(index);
    }
    
    public String getFechaCreacion(int index){
        return this.FechaCreacion.get(index);
    }
    
    public String getFechaActualizacion(int index){
        return this.FechaActualizacion.get(index);
    }
    
    public void loadTickets(String codJuris) throws IOException{
        readExcel data = new readExcel();
        int idSQL = 508;
        String param = "&PEstado=2&PNroTicket=&PSNEP="+codJuris+"&PIdTema=-1&PIdSubtema=-1&PNombreArchivo=Tickets";
        ArrayList<ArrayList<String>> resultados = data.getArrayList(idSQL, param);
        int finY = resultados.size();
        for(int i=1;i<finY;i++){
            if(resultados.get(i).get(8).equals("Mesa orientación y servicios Santa Fe")){
                IdTicket.add(resultados.get(i).get(0));
                Tema.add(resultados.get(i).get(9));
                Subtema.add(resultados.get(i).get(10));
                if(resultados.get(i).get(7).isEmpty()){
                    Consulta.add("");
                } else {
                    Consulta.add(resultados.get(i).get(7));
                }
                FechaCreacion.add(resultados.get(i).get(5));
                FechaActualizacion.add(resultados.get(i).get(6));
            }
        }
    }
}
