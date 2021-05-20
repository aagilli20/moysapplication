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
public class Supervisor {
    
    private ArrayList<String> TipoCircuito;
    private ArrayList<String> SitRevista;
    private ArrayList<String> Documento;
    private ArrayList<String> NombreApellido;
    
    public Supervisor(){
        this.TipoCircuito = new ArrayList<>();
        this.SitRevista = new ArrayList<>();
        this.Documento = new ArrayList<>();
        this.NombreApellido = new ArrayList<>();
    }
    
    public int getSize(){
        return this.Documento.size();
    }
    
    public String getTipoCircuito(int index){
        return this.TipoCircuito.get(index);
    }
    
    public String getSitRevista(int index){
        return this.SitRevista.get(index);
    }
    
    public String getDocumento(int index){
        return this.Documento.get(index);
    }
    
    public String getNombreApellido(int index){
        return this.NombreApellido.get(index);
    }
    
    public void loadSupervisor(int NroOrganismo) throws IOException{
        readExcel data = new readExcel();
        int idSQL = 50134;
        String param = "&PIdOrganismo="+NroOrganismo+"&PNombreArchivo=Supervisores";
        ArrayList<ArrayList<String>> resultados = data.getArrayList(idSQL, param);
        int finY = resultados.size();
        for(int i=1;i<finY;i++){
            TipoCircuito.add(resultados.get(i).get(0));
            Documento.add(resultados.get(i).get(1));
            NombreApellido.add(resultados.get(i).get(2));
            SitRevista.add(resultados.get(i).get(3));
        }
    }
    
}
