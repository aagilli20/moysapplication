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
public class Conectividad {
    private ArrayList<String> GastosAnio;
    private ArrayList<String> GastosMes;
    private ArrayList<String> GastosDetalle;
    private ArrayList<String> GastosImporte;
    private String FechaAlta;
    private String TipoEnlace;
    private String AnchoBanda;
    private String Abono;
    private String TelefonoInternet;
    private String FuncSitAdversas;
    private String Proveedor;
    private String Observaciones;
    
    public Conectividad(){
        this.GastosAnio = new ArrayList<>();
        this.GastosMes = new ArrayList<>();
        this.GastosDetalle = new ArrayList<>();
        this.GastosImporte = new ArrayList<>();
        this.FechaAlta = "";
        this.TipoEnlace = "";
        this.AnchoBanda = "";
        this.Abono = "";
        this.TelefonoInternet = "";
        this.FuncSitAdversas = "";
        this.Proveedor = "";
        this.Observaciones = "";
    }
    
    public int getSize(){
        return this.GastosAnio.size();
    }
    
    public String getGastosAnio(int index){
        return this.GastosAnio.get(index);
    }
    
    public String getGastosMes(int index){
        return this.GastosMes.get(index);
    }
    
    public String getGastosDetalle(int index){
        return this.GastosDetalle.get(index);
    }
    
    public String getGastosImporte(int index){
        return this.GastosImporte.get(index);
    }
    
    public String getFechaAlta(){
        return this.FechaAlta;
    }
    
    public String getTipoEnlace(){ return this.TipoEnlace;}
    public String getAnchoBanda(){ return this.AnchoBanda;}
    public String getAbono(){ return this.Abono;}
    public String getTelefonoInternet(){ return this.TelefonoInternet;}
    public String getFuncSitAdversas(){ return this.FuncSitAdversas;}
    public String getProveedor(){ return this.Proveedor;}
    public String getObservaciones(){ return this.Observaciones;}
    
    public void loadConectividad(int numero_organismo) throws IOException{
        readExcel data = new readExcel();
        // información general
        int idSQL = 50656;
        String param = "&PEscuela="+numero_organismo+"&PNombreArchivo=Proveedor";
        ArrayList<ArrayList<String>> resultados = data.getArrayList(idSQL, param);
        FechaAlta = resultados.get(1).get(1);
        TipoEnlace = resultados.get(1).get(2);
        AnchoBanda = resultados.get(1).get(3);
        Abono = resultados.get(1).get(4);
        TelefonoInternet = resultados.get(1).get(5);
        FuncSitAdversas = resultados.get(1).get(7);
        Observaciones = resultados.get(1).get(6);
        Proveedor = resultados.get(1).get(0);
        // gastos de funcionamiento
        idSQL = 540;
        param = "&PIdOrganismo="+numero_organismo+"&PAnio=&PMes=&PNombreArchivo=Gasto";
        resultados.clear();
        resultados = data.getArrayList(idSQL, param);
        int finY = resultados.size();
        int anio = java.util.GregorianCalendar.getInstance().get(Calendar.YEAR);
        String anio1 = Integer.toString(anio);
        String anio2 = Integer.toString(anio - 1);
        for(int i=1;i<finY;i++){
            if(resultados.get(i).get(0).equals(anio1) || resultados.get(i).get(0).equals(anio2)) {
                if(resultados.get(i).get(2).equals("65")){
                    GastosAnio.add(resultados.get(i).get(0));
                    GastosMes.add(resultados.get(i).get(1));
                    GastosDetalle.add(resultados.get(i).get(3));
                    GastosImporte.add(resultados.get(i).get(4));
                }
            }
        }
    }
}
