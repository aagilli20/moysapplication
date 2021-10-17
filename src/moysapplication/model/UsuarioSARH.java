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
public class UsuarioSARH {
    private ArrayList<String> Usuario;
    private ArrayList<String> NombreApellido;
    private ArrayList<String> Documento;
    private ArrayList<String> FechaAlta;
    private ArrayList<String> FechaBaja;
    private String UsuarioVPN;
    
    public UsuarioSARH(){
        this.Usuario = new ArrayList<>();
        this.NombreApellido = new ArrayList<>();
        this.Documento = new ArrayList<>();
        this.FechaAlta = new ArrayList<>();
        this.FechaBaja = new ArrayList<>();
        this.UsuarioVPN = "";
    }
    
    public int getSize(){
        return this.Usuario.size();
    }
    
    public String getUsuario(int index){
        return this.Usuario.get(index);
    }
    
    public String getNombreApellido(int index){
        return this.NombreApellido.get(index);
    }
    
    public String getDocumento(int index){
        return this.Documento.get(index);
    }
    
    public String getFechaAlta(int index){
        return this.FechaAlta.get(index);
    }
    
    public String getFechaBaja(int index){
        return this.FechaBaja.get(index);
    }
    
    public String getUsuarioVPN(){
        return this.UsuarioVPN;
    }
    
    public void loadUsuarioSARH(int numero_organismo, String codJuris) throws IOException{
        readExcel data = new readExcel();
        // usuarios de SARH
        int idSQL = 50349;
        String param = "&PidNroOrganismo="+numero_organismo+"&PNombreArchivo=USUARIOS_SARH";
        ArrayList<ArrayList<String>> resultados = data.getArrayList(idSQL, param);
        int finY = resultados.size();
        for(int i=1;i<finY;i++){
            Usuario.add(resultados.get(i).get(0));
            String nom_ape = resultados.get(i).get(1)+", "+resultados.get(i).get(2);
            NombreApellido.add(nom_ape);
            Documento.add(resultados.get(i).get(4));
            FechaAlta.add(resultados.get(i).get(5));
            if(resultados.get(i).get(6).isEmpty()){
                FechaBaja.add("");
            } else {
                FechaBaja.add(resultados.get(i).get(6));
            }
        }
        // usuario VPN
        idSQL = 50348;
        param = "&PidRegionZona=-1&PidNroPresup=&PidCodJuris="+codJuris+"&PNombreArchivo=USUARIOS_VPN";
        resultados.clear();
        resultados = data.getArrayList(idSQL, param);
        finY = resultados.size();
        for(int i=1;i<finY;i++){
            if(! (resultados.get(i).get(10).isEmpty())){
                UsuarioVPN = resultados.get(i).get(10);
            }    
        }
    }
}
