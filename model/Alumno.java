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
public class Alumno {
    
    private ArrayList<String> IdAlumno;
    private ArrayList<String> Documento;
    private ArrayList<String> ApellidoNombre;
    private ArrayList<String> Sexo;
    private ArrayList<String> FechaNacimiento;
    private ArrayList<String> Nacionalidad;
    private ArrayList<String> Departamento;
    private ArrayList<String> Localidad;
    private ArrayList<String> CodigoPostal;
    private ArrayList<String> Domicilio;
    private ArrayList<String> Telefono;
    private ArrayList<String> EMail;
    
    public Alumno(){
        this.IdAlumno = new ArrayList<>();
        this.Documento = new ArrayList<>();
        this.ApellidoNombre = new ArrayList<>();
        this.Sexo = new ArrayList<>();
        this.FechaNacimiento = new ArrayList<>();
        this.Nacionalidad = new ArrayList<>();
        this.Departamento = new ArrayList<>();
        this.Localidad = new ArrayList<>();
        this.CodigoPostal = new ArrayList<>();
        this.Domicilio = new ArrayList<>();
        this.Telefono = new ArrayList<>();
        this.EMail = new ArrayList<>();
    }
    
    /*
    * Acceso a datos
    */
    
    public int getSize(){return this.IdAlumno.size();}
    
    public String getIdAlumno(int indice){
        return this.IdAlumno.get(indice);
    }
    
    public String getDocumento(int indice){
        return this.Documento.get(indice);
    }
    
    public String getApellidoNombre(int indice){
        return this.ApellidoNombre.get(indice);
    }
    
    public String getSexo(int indice){
        return this.Sexo.get(indice);
    }
    
    public String getFechaNacimiento(int indice){
        return this.FechaNacimiento.get(indice);
    }
    
    public String getNacionalidad(int indice){
        return this.Nacionalidad.get(indice);
    }
    
    public String getDepartamento(int indice){
        return this.Departamento.get(indice);
    }
    
    public String getLocalidad(int indice){
        return this.Localidad.get(indice);
    }
    
    public String getCodigoPostal(int indice){
        return this.CodigoPostal.get(indice);
    }
    
    public String getDomicilio(int indice){
        return this.Domicilio.get(indice);
    }
    
    public String getTelefono(int indice){
        return this.Telefono.get(indice);
    }
    
    public String getEMail(int indice){
        return this.EMail.get(indice);
    }
    
    /*
    * Cargar a datos
    */
    
    public void loadAlumno(String nro_documento) throws IOException{
        readExcel data = new readExcel();
        int idSQL = 52002;
        String param = "&PDocumento="+nro_documento+"&PNombreArchivo=Alumno";
        ArrayList<ArrayList<String>> resultados = data.getArrayList(idSQL, param);
        int finY = resultados.size();
        for(int i=1;i<finY;i++){
            IdAlumno.add(resultados.get(i).get(0));
            Documento.add(resultados.get(i).get(1));
            ApellidoNombre.add(resultados.get(i).get(2));
            Sexo.add(resultados.get(i).get(3));
            FechaNacimiento.add(resultados.get(i).get(4));
            Nacionalidad.add(resultados.get(i).get(5));
            Departamento.add(resultados.get(i).get(6));
            Localidad.add(resultados.get(i).get(7));
            CodigoPostal.add(resultados.get(i).get(8));
            Domicilio.add(resultados.get(i).get(9));
            Telefono.add(resultados.get(i).get(10));
            EMail.add(resultados.get(i).get(11));
        }
    }
    
}
