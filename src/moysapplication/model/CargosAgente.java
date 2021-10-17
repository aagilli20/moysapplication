/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moysapplication.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import moysapplication.data.readExcel;

/**
 *
 * @author Andrés Gilli <agilli@santafe.gov.ar>
 */
public class CargosAgente {
    private ArrayList<String> Establecimiento;
    private ArrayList<String> Tarea;
    private ArrayList<String> IdCargo;
    private ArrayList<String> SitRevista;
    private ArrayList<String> FeTomaPosecion;
    private ArrayList<String> FeCese;
    
    public CargosAgente(){
        this.Establecimiento = new ArrayList<>();
        this.Tarea = new ArrayList<>();
        this.IdCargo = new ArrayList<>();
        this.SitRevista = new ArrayList<>();
        this.FeTomaPosecion = new ArrayList<>();
        this.FeCese = new ArrayList<>();
    }
    
    public int getSize(){
        return this.Establecimiento.size();
    }
    
    public String getEstablecimiento(int index){
        return this.Establecimiento.get(index);
    }
    
    public String getTarea(int index){
        return this.Tarea.get(index);
    }
    
    public String getIdCargo(int index){
        return this.IdCargo.get(index);
    }
    
    public String getSitRevista(int index){
        return this.SitRevista.get(index);
    }
    
    public String getFeTomaPosecion(int index){
        return this.FeTomaPosecion.get(index);
    }
    
    public String getFeCese(int index){
        return this.FeCese.get(index);
    }
    
    public void loadCargosAgente(String nro_documento, String tipo_doc) throws IOException{
        readExcel data = new readExcel();
        // cargamos los codigos jurisdiccionales
        int idSQL = 51663;
        int anio = java.util.GregorianCalendar.getInstance().get(Calendar.YEAR);
        int mes = java.util.GregorianCalendar.getInstance().get(Calendar.MONTH);
        int dia = java.util.GregorianCalendar.getInstance().get(Calendar.DAY_OF_MONTH);
        String param = "&PFecha="+dia+"/"+mes+"/"+anio+"&PNumDocAgente="+nro_documento+"&PTipoDocAgente="+tipo_doc+"&PNombreArchivo=Cargos";
        ArrayList<ArrayList<String>> resultados = data.getArrayList(idSQL, param);
        int finY = resultados.size();
        for(int i=1;i<finY;i++){
            this.Establecimiento.add(resultados.get(i).get(0));
            this.Tarea.add(resultados.get(i).get(1));
            this.IdCargo.add(resultados.get(i).get(2));
            this.SitRevista.add(resultados.get(i).get(3));
            this.FeTomaPosecion.add(resultados.get(i).get(4));
            this.FeCese.add(resultados.get(i).get(5));
        }
    }
}
