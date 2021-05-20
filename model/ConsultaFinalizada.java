/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moysapplication.model;

import java.util.ArrayList;

/**
 *
 * @author Andrés Gilli <agilli@santafe.gov.ar>
 */
public class ConsultaFinalizada {
    private ArrayList<String> idConsulta;
    private ArrayList<String> Tema;
    private ArrayList<String> Observaciones;
    private ArrayList<String> FeBaja;
    private ArrayList<String> Operador;
    private ArrayList<String> FinalizadoPor;
    
    public ConsultaFinalizada(){
        idConsulta = new ArrayList<>();
        Tema = new ArrayList<>();
        Observaciones = new ArrayList<>();
        FeBaja = new ArrayList<>();
        Operador = new ArrayList<>();
        FinalizadoPor = new ArrayList<>();
    }
    
    public void setConsulta(String id_consulta, String tema, String observaciones, String fecha_baja, String operador, String finalizado_por){
        this.idConsulta.add(id_consulta);
        this.Tema.add(tema);
        this.Observaciones.add(observaciones);
        this.FeBaja.add(fecha_baja);
        this.Operador.add(operador);
        this.FinalizadoPor.add(finalizado_por);
    }
    
    public String getIdConsulta(int index){
        return this.idConsulta.get(index);
    }
    
    public String getTema(int index){
        return this.Tema.get(index);
    }
    
    public String getObservaciones(int index){
        return this.Observaciones.get(index);
    }
    
    public String getFeBaja(int index){
        return this.FeBaja.get(index);
    }
    
    public String getOperador(int index){
        return this.Operador.get(index);
    }
    
    public String getFinalizadoPor(int index){
        return this.FinalizadoPor.get(index);
    }
    
    public int getSize(){
        return this.idConsulta.size();
    }
}
