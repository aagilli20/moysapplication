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
public class Comedor {
    
    private String EstBeneficiado;
    private String EstAsistente;
    private ArrayList<String> Concepto;
    private ArrayList<String> Desayuno;
    private ArrayList<String> Almuerzo;
    private ArrayList<String> Merienda;
    private ArrayList<String> Cena;
    
    public Comedor(){
        this.EstAsistente = "";
        this.EstBeneficiado = "";
        this.Concepto = new ArrayList<>();
        this.Desayuno = new ArrayList<>();
        this.Almuerzo = new ArrayList<>();
        this.Merienda = new ArrayList<>();
        this.Cena = new ArrayList<>();
    }
    
    public int getSize(){
        return this.Concepto.size();
    }
    
    public String getConcepto(int index){
        return this.Concepto.get(index);
    }
    
    public String getDesayuno(int index){
        return this.Desayuno.get(index);
    }
    
    public String getAlmuerzo(int index){
        return this.Almuerzo.get(index);
    }
    
    public String getMerienda(int index){
        return this.Merienda.get(index);
    }
    
    public String getCena(int index){
        return this.Cena.get(index);
    }
    
    public String getEstAsistente(){
        return this.EstAsistente;
    }
    
    public String getEstBeneficiado(){
        return this.EstBeneficiado;
    }
    
    public void loadComedor(int nro_organismo, String codJuris) throws IOException{
        readExcel data = new readExcel();
        int idSQL = 718;
        String param = "&p_id_dependencia=&p_nro_presupuestario=&p_snep="+codJuris+"&p_id_tipo_perido=1&p_regional=&PNombreArchivo=RelacionComedor";
        ArrayList<ArrayList<String>> resultados = data.getArrayList(idSQL, param);
        if(resultados.get(1).get(0).equals("-")){
            // la escuela no tiene comedor
            Concepto.add("El establecimiento no cuenta con el servicio de Comedor");
            Desayuno.add("");
            Almuerzo.add("");
            Merienda.add("");
            Cena.add("");
        } else {
            // tiene comedor
            // relaciones de comedor
            String codPresupuestario = resultados.get(1).get(1);
            this.EstBeneficiado = resultados.get(1).get(4);
            this.EstAsistente = resultados.get(1).get(5)+" [ Liquida: "+resultados.get(1).get(6)+" ]";
            // ultimas solicitudes
            idSQL = 50028;
            param = "&Panio=&Pmes=&Pid_periodo=&Pnro_presupuestario="+codPresupuestario+"&p_regional=&PNombreArchivo=SolicitudComedor";
            resultados.clear();
            resultados = data.getArrayList(idSQL, param);
            // resultados = new ArrayList<ArrayList<String>>();
            int finY = resultados.size();
            if(finY > 8) finY = 9;
            for(int i=1;i<finY;i++){
                if(resultados.get(i).get(2).equals("Receso")){
                    Concepto.add("Sol. Receso Mes "+resultados.get(i).get(1)+" Año "+resultados.get(i).get(0));
                } else {
                    Concepto.add("Solicitud Mes "+resultados.get(i).get(1)+" Año "+resultados.get(i).get(0));
                }
                Desayuno.add(resultados.get(i).get(10));
                Almuerzo.add(resultados.get(i).get(11));
                Merienda.add(resultados.get(i).get(12));
                Cena.add(resultados.get(i).get(13));
            }
            // ultima liquidación
            idSQL = 51451;
            param = "&PIdorganismo="+nro_organismo+"&PNombreArchivo=LiquidacionComedor";
            resultados.clear();
            resultados = data.getArrayList(idSQL, param);
            finY = resultados.size();
            for(int i=1;i<finY;i++){
                if(resultados.get(i).get(0).contains("Propio")){
                    Concepto.add("Última liquidación - Servicio Propio");
                } else {
                    Concepto.add("Última liquidación - Est. que beneficia");
                }
                Desayuno.add(resultados.get(i).get(1));
                Almuerzo.add(resultados.get(i).get(1));
                Merienda.add(resultados.get(i).get(3));
                Cena.add(resultados.get(i).get(4));
            }
        }
    }
}
