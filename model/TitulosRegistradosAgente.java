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
public class TitulosRegistradosAgente {
    private ArrayList<String> Establecimiento;
    private ArrayList<String> Plan;
    private ArrayList<String> Titulo;
    private ArrayList<String> Registro;
    private ArrayList<String> Diploma;
    
    public TitulosRegistradosAgente(){
        this.Establecimiento = new ArrayList<>();
        this.Plan = new ArrayList<>();
        this.Titulo = new ArrayList<>();
        this.Registro = new ArrayList<>();
        this.Diploma = new ArrayList<>();
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
    
    public String getRegistro(int index){
        return this.Registro.get(index);
    }
    
    public String getDiploma(int index){
        return this.Diploma.get(index);
    }
    
    public void loadTitulosRegistradosAgente(String nro_documento, String sexo) throws IOException{
        readExcel data = new readExcel();
        // cargamos los codigos jurisdiccionales
        int idSQL = 623;
        String param = "&PNRODOCUMENTO="+nro_documento+"&PIDALUMNO=&PNombreArchivo=TitulosRegistrados";
        ArrayList<ArrayList<String>> resultados = data.getArrayList(idSQL, param);
        int finY = resultados.size();
        for(int i=1;i<finY;i++){
            if(resultados.get(i).get(1).equals(sexo)){
                this.Establecimiento.add(resultados.get(i).get(3));
                this.Plan.add(resultados.get(i).get(4));
                this.Titulo.add(resultados.get(i).get(5));
                this.Registro.add(resultados.get(i).get(6));
                this.Diploma.add(resultados.get(i).get(8));
            }
        }
        if(this.getSize() == 0) {
            this.Establecimiento.add("El Agente no cuenta con Títulos Registrados en la Provincia");
            this.Plan.add("");
            this.Titulo.add("");
            this.Registro.add("");
            this.Diploma.add("");
        }
    }
    
}
