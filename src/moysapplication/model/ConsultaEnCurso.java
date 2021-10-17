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
public class ConsultaEnCurso {
    private ArrayList<String> idConsulta;
    private ArrayList<String> Tema;
    private ArrayList<String> Observaciones;
    private ArrayList<String> FeAlta;
    private ArrayList<String> Operador;
    
    public ConsultaEnCurso(){
        idConsulta = new ArrayList<>();
        Tema = new ArrayList<>();
        Observaciones = new ArrayList<>();
        FeAlta = new ArrayList<>();
        Operador = new ArrayList<>();
    }
    
    public void setConsulta(String id_consulta, String tema, String observaciones, String fecha_alta, String operador){
        this.idConsulta.add(id_consulta);
        this.Tema.add(tema);
        this.Observaciones.add(observaciones);
        this.FeAlta.add(fecha_alta);
        this.Operador.add(operador);
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
    
    public String getFeAlta(int index){
        return this.FeAlta.get(index);
    }
    
    public String getOperador(int index){
        return this.Operador.get(index);
    }
    
    public int getSize(){
        return this.idConsulta.size();
    }
}
