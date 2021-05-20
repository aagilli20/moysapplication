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
public class Trayectoria {
    
    private ArrayList<String> CodJurisdiccional;
    private ArrayList<String> NroOrganismoCarrera;
    private ArrayList<String> NroOrganismoSeccion;
    private ArrayList<String> IdCarrera;
    private ArrayList<String> IdSeccion;
    private ArrayList<String> IdSeccionPrevia;
    private ArrayList<String> CicloLectivo;
    private ArrayList<String> Seccion;
    private ArrayList<String> FecInscripCarrera;
    private ArrayList<String> FecInscripSeccion;
    private ArrayList<String> FecBajaSeccion;
    private ArrayList<String> MovEntrada;
    private ArrayList<String> MovUltimo;
    private ArrayList<String> FecBajaCarrera;
    private ArrayList<String> FecSalida;
    
    
    public Trayectoria(){
        this.CodJurisdiccional = new ArrayList<>();
        this.NroOrganismoCarrera = new ArrayList<>();
        this.NroOrganismoSeccion = new ArrayList<>();
        this.IdSeccion  = new ArrayList<>();
        this.IdCarrera = new ArrayList<>();
        this.IdSeccionPrevia  = new ArrayList<>();
        this.CicloLectivo = new ArrayList<>();
        this.Seccion = new ArrayList<>();
        this.FecInscripCarrera = new ArrayList<>();
        this.FecInscripSeccion = new ArrayList<>();
        this.FecBajaSeccion = new ArrayList<>();
        this.MovEntrada = new ArrayList<>();
        this.MovUltimo = new ArrayList<>();
        this.FecBajaCarrera = new ArrayList<>();
        this.FecSalida = new ArrayList<>();
    }
    
    public int getSize(){
        return this.CodJurisdiccional.size();
    }
    
    public String getCodJurisdiccional(int index){
        return this.CodJurisdiccional.get(index);
    }
    
    public String getNroOrganismoCarrera(int index){
        return this.NroOrganismoCarrera.get(index);
    }
    
    public String getNroOrganismoSeccion(int index){
        return this.NroOrganismoSeccion.get(index);
    }
    
    public String getIdCarrera(int index){
        return this.IdCarrera.get(index);
    }
    
    public String getIdSeccion(int index){
        return this.IdSeccion.get(index);
    }
    
    public String getIdSeccionPrevia(int index){
        return this.IdSeccionPrevia.get(index);
    }
    
    public String getCicloLectio(int index){
        return this.CicloLectivo.get(index);
    }
    
    public String getSeccion(int index){
        return this.Seccion.get(index);
    }
    
    public String getFecInscripCarrera(int index){
        return this.FecInscripCarrera.get(index);
    }
    
    public String getFecInscripSeccion(int index){
        return this.FecInscripSeccion.get(index);
    }
    
    public String getFecBajaSeccion(int index){
        return this.FecBajaSeccion.get(index);
    }
    
    public String getMovEntrada(int index){
        return this.MovEntrada.get(index);
    }
    
    public String getMovUltimo(int index){
        return this.MovUltimo.get(index);
    }
    
    public String getFecBajaCarrera(int index){
        return this.FecBajaCarrera.get(index);
    }
    
    public String getFecSalida(int index){
        return this.FecSalida.get(index);
    }
    
    public void loadTrayectoria(String nro_documento, String sexo) throws IOException{
        readExcel data = new readExcel();
        // cargamos los codigos jurisdiccionales
        int idSQL = 51796;
        String param = "&PNroDoc="+nro_documento+"&PSexo="+sexo+"&PNombreArchivo=TrayectoriaAlumnoJuris";
        ArrayList<ArrayList<String>> resultados = data.getArrayList(idSQL, param);
        int finY = resultados.size();
        for(int i=1;i<finY;i++){
            CodJurisdiccional.add(resultados.get(i).get(2));
        }
        // cargamos el resto de la informacion
        idSQL = 51376;
        param = "&PNroDoc="+nro_documento+"&PMostrar=0&PSexo="+sexo+"&PNombreArchivo=TrayectoriaAlumno";
        resultados.clear();
        resultados = data.getArrayList(idSQL, param);
        finY = resultados.size();
        for(int i=1;i<finY;i++){
            this.NroOrganismoCarrera.add(resultados.get(i).get(0));
            this.NroOrganismoSeccion.add(resultados.get(i).get(1));
            this.IdCarrera.add(resultados.get(i).get(2));
            this.IdSeccion.add(resultados.get(i).get(3));
            this.IdSeccionPrevia.add(resultados.get(i).get(4));
            this.CicloLectivo.add(resultados.get(i).get(5));
            this.Seccion.add(resultados.get(i).get(6));
            this.FecInscripCarrera.add(resultados.get(i).get(7));
            this.FecInscripSeccion.add(resultados.get(i).get(8));
            this.FecBajaSeccion.add(resultados.get(i).get(9));
            this.MovEntrada.add(resultados.get(i).get(10));
            this.MovUltimo.add(resultados.get(i).get(11));
            this.FecBajaCarrera.add(resultados.get(i).get(12));
            this.FecSalida.add(resultados.get(i).get(13));
        }
    }
}
