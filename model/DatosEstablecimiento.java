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
public class DatosEstablecimiento {
    private String TipoOrganismo;
    private String Gestion;
    private String Domicilio;
    private String Telefono;
    private String Centrex;
    private String Email;
    private String Departamento;
    private String Nodo;
    private String TieneSigae;
    private String Activo;
    private String FechaActuVista;
    private String CargoEstCurricular;
    private String CargosFrenteAula;
    private String Plazas;
    private String BecasSolicitadasAnt;
    private String BecasSolicitadas;
    private String MBPendientes;
    private String MBOtorgadas;
    private String LabelTitulos1;
    private String LabelTitulos2;
    private String CantTitulos1;
    private String CantTitulos2;    
    private String PCResolucion;
    private String PCFechaAprobacion;
    private String PCObservacion;
    private String TieneInternet;
    
    public DatosEstablecimiento(){
        this.TipoOrganismo = "";
        this.Gestion = "";
        this.Domicilio = "";
        this.Telefono = "";
        this.Centrex = "";
        this.Email = "";
        this.Departamento = "";
        this.Nodo = "";
        this.TieneSigae = "";
        this.Activo = "";
        this.FechaActuVista = "";
        this.CargoEstCurricular = "";
        this.CargosFrenteAula = "";
        this.Plazas = "";
        this.BecasSolicitadasAnt = "";
        this.BecasSolicitadas = "";
        this.MBOtorgadas = "";
        this.MBPendientes = "";
        this.CantTitulos1 = "";
        this.CantTitulos2 = "";
        this.PCResolucion = "";
        this.PCFechaAprobacion = "";
        this.PCObservacion = "";
        this.TieneInternet = "";
    }
    
    public void loadDatosEstablecimiento(int NroOrganismo) throws IOException{
        readExcel data = new readExcel();
        int idSQL = 50523;
        String param = "&PSnep=&PNroOrg="+NroOrganismo+"&PLocalidad=&PDepartamento=&PRegion=&PNodo=&PTipo=&PGestion=&PNombreArchivo=SEGUIMIENTO";
        ArrayList<ArrayList<String>> resultados = data.getArrayList(idSQL, param);
        this.Gestion = resultados.get(1).get(2);
        this.Domicilio = resultados.get(1).get(7);
        this.Telefono = resultados.get(1).get(8);
        this.Email = resultados.get(1).get(9);
        this.Departamento = resultados.get(1).get(11);
        this.Nodo = resultados.get(1).get(13);
        this.TieneSigae = resultados.get(1).get(14);
        this.Activo = resultados.get(1).get(56);
        this.FechaActuVista = resultados.get(1).get(57);
        this.CargoEstCurricular = resultados.get(1).get(16);
        this.CargosFrenteAula = resultados.get(1).get(22);
        this.Plazas = resultados.get(1).get(23);
        if(resultados.get(1).get(45).equals("")) this.BecasSolicitadasAnt = "0";
        else this.BecasSolicitadasAnt = resultados.get(1).get(45);
        if(resultados.get(1).get(46).equals("")) this.BecasSolicitadas = "0";
        else this.BecasSolicitadas = resultados.get(1).get(46);
        this.MBPendientes = resultados.get(1).get(47);
        this.MBOtorgadas = resultados.get(1).get(48);
        this.LabelTitulos1 = resultados.get(0).get(49);
        this.LabelTitulos2 = resultados.get(0).get(50);
        this.CantTitulos1 = resultados.get(1).get(49);
        this.CantTitulos2 = resultados.get(1).get(50);
        this.PCResolucion = resultados.get(1).get(19);
        this.PCFechaAprobacion = resultados.get(1).get(20);
        this.PCObservacion = resultados.get(1).get(21);
        this.TieneInternet = resultados.get(1).get(18);
        // leemos centrex y tipo de organismo
        idSQL = 51987;
        param = "&PNorganismo="+NroOrganismo+"&PNombreArchivo=Establecimiento";
        resultados.clear();
        resultados = data.getArrayList(idSQL, param);
        this.TipoOrganismo = resultados.get(1).get(3);
        if((resultados.get(1).get(14).equals("")) || (resultados.get(1).get(14).isEmpty())){
            this.Centrex = resultados.get(1).get(12);
        } else {
            this.Centrex = resultados.get(1).get(14);
        }
        if(!((resultados.get(1).get(11).equals("")) || (resultados.get(1).get(11).isEmpty()))){
            this.Telefono = resultados.get(1).get(11);
        }
    }
    
    public String getGestion(){ return this.Gestion;}
    public String getDomicilio(){ return this.Domicilio;}
    public String getTelefono(){ return this.Telefono;}
    public String getEmail(){ return this.Email;}
    public String getDepartamento(){ return this.Departamento;}
    public String getNodo(){ return this.Nodo;}
    public String getTieneSigae(){ return this.TieneSigae;}
    public String getActivo(){ return this.Activo;}
    public String getFechaActuVista(){ return this.FechaActuVista;}
    public String getCargoEstCurricular(){ return this.CargoEstCurricular;}
    public String getCargosFrenteAula(){ return this.CargosFrenteAula;}
    public String getPlazas(){ return this.Plazas;}
    public String getTipoOrganismo(){ return this.TipoOrganismo;}
    public String getCentrex(){ return this.Centrex;}
    public String getBecasSolicitadasAnt(){ return this.BecasSolicitadasAnt;}
    public String getBecasSolicitadas(){ return this.BecasSolicitadas;}
    public String getMBOtorgadas(){ return this.MBOtorgadas;}
    public String getMBPendientes(){ return this.MBPendientes;}
    public String getLabelTitulos1(){ return this.LabelTitulos1;}
    public String getLabelTitulos2(){ return this.LabelTitulos2;}
    public String getcantTitulos1(){ return this.CantTitulos1;}
    public String getcantTitulos2(){ return this.CantTitulos2;}
    public String getPCResolucion(){ return this.PCResolucion;}
    public String getPCFechaAprobacion(){ return this.PCFechaAprobacion;}
    public String getPCObservacion(){ return this.PCObservacion;}
    public String getTieneInternet(){ return this.TieneInternet;}
}
