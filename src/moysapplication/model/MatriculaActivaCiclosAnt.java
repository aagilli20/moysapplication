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
public class MatriculaActivaCiclosAnt {
    private ArrayList<String> MACACicloLectivo;
    private ArrayList<String> MACACarrera;
    private ArrayList<String> MACAAnioEstudio;
    private ArrayList<String> MACASeccion;
    private ArrayList<String> MACAAlumno;
    private ArrayList<String> MACADocumento;
    private ArrayList<String> MACASexo;
    private int cantAlumActivos5y6CiclosAnt;
    
    public MatriculaActivaCiclosAnt(){
        this.MACACicloLectivo = new ArrayList<>();
        this.MACACarrera = new ArrayList<>();
        this.MACAAnioEstudio = new ArrayList<>();
        this.MACASeccion = new ArrayList<>();
        this.MACAAlumno = new ArrayList<>();
        this.MACADocumento = new ArrayList<>();
        this.MACASexo = new ArrayList<>();
        this.cantAlumActivos5y6CiclosAnt = 0;
    }
    
    public int getSize(){
        return this.MACACicloLectivo.size();
    }
    
    public String getMACACicloLectivo(int index){
        return this.MACACicloLectivo.get(index);
    }
    
    public String getMACACarrera(int index){
        return this.MACACarrera.get(index);
    }
    
    public String getMACAAnioEstudio(int index){
        return this.MACAAnioEstudio.get(index);
    }
    
    public String getMACASeccion(int index){
        return this.MACASeccion.get(index);
    }
    
    public String getMACAAlumno(int index){
        return this.MACAAlumno.get(index);
    }
    
    public String getMACADocumento(int index){
        return this.MACADocumento.get(index);
    }
    
    public String getMACASexo(int index){
        return this.MACASexo.get(index);
    }
    
    public int getMACATitulos(){
        return this.cantAlumActivos5y6CiclosAnt;
    }
    
    public void loadMACA(int nro_organismo) throws IOException{
        readExcel data = new readExcel();
        int idSQL = 51398;
        String param = "&PIdOrganismo="+nro_organismo+"&PNombreArchivo=ActivosCiclosAnt";
        ArrayList<ArrayList<String>> resultados = data.getArrayList(idSQL, param);
        int finY = resultados.size();
        for(int i=1;i<finY;i++){
            MACACicloLectivo.add(resultados.get(i).get(0));
            MACACarrera.add(resultados.get(i).get(1));
            MACAAnioEstudio.add(resultados.get(i).get(2));
            MACASeccion.add(resultados.get(i).get(3));
            MACAAlumno.add(resultados.get(i).get(4));
            MACADocumento.add(resultados.get(i).get(5));
            MACASexo.add(resultados.get(i).get(6));
            if(resultados.get(i).get(2).equals("QUINTO")) cantAlumActivos5y6CiclosAnt++;
            if(resultados.get(i).get(2).equals("SEXTO")) cantAlumActivos5y6CiclosAnt++;
        }
    }
}
