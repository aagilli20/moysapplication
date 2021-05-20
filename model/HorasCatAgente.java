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
public class HorasCatAgente {
    private ArrayList<String> Establecimiento;
    private ArrayList<String> Terminalidad;
    private ArrayList<String> CurDivTur;
    private ArrayList<String> Materia;
    private ArrayList<String> Horas;
    private ArrayList<String> IdCargo;
    private ArrayList<String> SitRevista;
    private ArrayList<String> FeTomaPosecion;
    private ArrayList<String> FeCese;
    
    public HorasCatAgente(){
        this.Establecimiento = new ArrayList<>();
        this.Terminalidad = new ArrayList<>();
        this.CurDivTur = new ArrayList<>();
        this.Materia = new ArrayList<>();
        this.Horas = new ArrayList<>();
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
    
    public String getTerminalidad(int index){
        return this.Terminalidad.get(index);
    }
    
    public String getCurDivTur(int index){
        return this.CurDivTur.get(index);
    }
    
    public String getMateria(int index){
        return this.Materia.get(index);
    }
    
    public String getHoras(int index){
        return this.Horas.get(index);
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
    
    public void loadHorasCatAgente(String nro_documento, String tipo_doc) throws IOException{
        readExcel data = new readExcel();
        // cargamos los codigos jurisdiccionales
        int idSQL = 51665;
        int anio = java.util.GregorianCalendar.getInstance().get(Calendar.YEAR);
        int mes = java.util.GregorianCalendar.getInstance().get(Calendar.MONTH);
        int dia = java.util.GregorianCalendar.getInstance().get(Calendar.DAY_OF_MONTH);
        String param = "&PFecha="+dia+"/"+mes+"/"+anio+"&PNumDocAgente="+nro_documento+"&PTipoDocAgente="+tipo_doc+"&PNombreArchivo=Horas";
        ArrayList<ArrayList<String>> resultados = data.getArrayList(idSQL, param);
        int finY = resultados.size();
        for(int i=1;i<finY;i++){
            this.Establecimiento.add(resultados.get(i).get(0));
            this.Terminalidad.add(resultados.get(i).get(1));
            String auxi = resultados.get(i).get(2)+ " - " +resultados.get(i).get(3)+ " - " +resultados.get(i).get(4);
            this.CurDivTur.add(auxi);
            this.Materia.add(resultados.get(i).get(5));
            this.Horas.add(resultados.get(i).get(6));
            this.IdCargo.add(resultados.get(i).get(7));
            this.SitRevista.add(resultados.get(i).get(8));
            this.FeTomaPosecion.add(resultados.get(i).get(9));
            this.FeCese.add(resultados.get(i).get(10));
        }
    }
}
