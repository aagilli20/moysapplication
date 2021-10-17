/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moysapplication.model;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Andrés Gilli <agilli@santafe.gov.ar>
 */
public class TableTrayectoria {
    
    private StringProperty CodJurisdiccional;
    public void setCodJurisdiccional(String value) { CodJurisdiccionalProperty().set(value); }
    public String getCodJurisdiccional() { return CodJurisdiccionalProperty().get(); }
    public StringProperty CodJurisdiccionalProperty() { 
         if (CodJurisdiccional == null) CodJurisdiccional = new SimpleStringProperty(this, "CodJurisdiccional");
        return CodJurisdiccional; 
    }
    
    private StringProperty NroOrganismoCarrera;
    public void setNroOrganismoCarrera(String value) { NroOrganismoCarreraProperty().set(value); }
    public String getNroOrganismoCarrera() { return NroOrganismoCarreraProperty().get(); }
    public StringProperty NroOrganismoCarreraProperty() { 
         if (NroOrganismoCarrera == null) NroOrganismoCarrera = new SimpleStringProperty(this, "NroOrganismoCarrera");
        return NroOrganismoCarrera; 
    }

    private StringProperty NroOrganismoSeccion;
    public void setNroOrganismoSeccion(String value) { NroOrganismoSeccionProperty().set(value); }
    public String getNroOrganismoSeccion() { return NroOrganismoSeccionProperty().get(); }
    public StringProperty NroOrganismoSeccionProperty() { 
         if (NroOrganismoSeccion == null) NroOrganismoSeccion = new SimpleStringProperty(this, "NroOrganismoSeccion");
        return NroOrganismoSeccion; 
    }

    private StringProperty IdCarrera;
    public void set(String value) { IdCarreraProperty().set(value); }
    public String getIdCarrera() { return IdCarreraProperty().get(); }
    public StringProperty IdCarreraProperty() { 
         if (IdCarrera == null) IdCarrera = new SimpleStringProperty(this, "IdCarrera");
        return IdCarrera; 
    }

    private StringProperty IdSeccion;
    public void setIdSeccion(String value) { IdSeccionProperty().set(value); }
    public String getIdSeccion() { return IdSeccionProperty().get(); }
    public StringProperty IdSeccionProperty() { 
         if (IdSeccion == null) IdSeccion = new SimpleStringProperty(this, "IdSeccion");
        return IdSeccion; 
    }

    private StringProperty IdSeccionPrevia;
    public void setIdSeccionPrevia(String value) { IdSeccionPreviaProperty().set(value); }
    public String getIdSeccionPrevia() { return IdSeccionPreviaProperty().get(); }
    public StringProperty IdSeccionPreviaProperty() { 
         if (IdSeccionPrevia == null) IdSeccionPrevia = new SimpleStringProperty(this, "IdSeccionPrevia");
        return IdSeccionPrevia; 
    }
    
    private StringProperty CicloLectivo;
    public void setCicloLectivo(String value) { CicloLectivoProperty().set(value); }
    public String getCicloLectivo() { return CicloLectivoProperty().get(); }
    public StringProperty CicloLectivoProperty() { 
         if (CicloLectivo == null) CicloLectivo = new SimpleStringProperty(this, "CicloLectivo");
        return CicloLectivo; 
    }
    
    private StringProperty Seccion;
    public void setSeccion(String value) { SeccionProperty().set(value); }
    public String getSeccion() { return SeccionProperty().get(); }
    public StringProperty SeccionProperty() { 
         if (Seccion == null) Seccion = new SimpleStringProperty(this, "Seccion");
        return Seccion; 
    }
    
    private StringProperty FecInscripCarrera;
    public void setFecInscripCarrera(String value) { FecInscripCarreraProperty().set(value); }
    public String getFecInscripCarrera() { return FecInscripCarreraProperty().get(); }
    public StringProperty FecInscripCarreraProperty() { 
         if (FecInscripCarrera == null) FecInscripCarrera = new SimpleStringProperty(this, "FecInscripCarrera");
        return FecInscripCarrera; 
    }
    
    private StringProperty FecInscripSeccion;
    public void setFecInscripSeccion(String value) { FecInscripSeccionProperty().set(value); }
    public String getFecInscripSeccion() { return FecInscripSeccionProperty().get(); }
    public StringProperty FecInscripSeccionProperty() { 
         if (FecInscripSeccion == null) FecInscripSeccion = new SimpleStringProperty(this, "FecInscripSeccion");
        return FecInscripSeccion; 
    }
    
    private StringProperty FecBajaSeccion;
    public void setFecBajaSeccion(String value) { FecBajaSeccionProperty().set(value); }
    public String getFecBajaSeccion() { return FecBajaSeccionProperty().get(); }
    public StringProperty FecBajaSeccionProperty() { 
         if (FecBajaSeccion == null) FecBajaSeccion = new SimpleStringProperty(this, "FecBajaSeccion");
        return FecBajaSeccion; 
    }
    
    private StringProperty MovEntrada;
    public void setMovEntrada(String value) { MovEntradaProperty().set(value); }
    public String getMovEntrada() { return MovEntradaProperty().get(); }
    public StringProperty MovEntradaProperty() { 
         if (MovEntrada == null) MovEntrada = new SimpleStringProperty(this, "MovEntrada");
        return MovEntrada; 
    }
    
    private StringProperty MovUltimo;
    public void setMovUltimo(String value) { MovEntradaProperty().set(value); }
    public String getMovUltimo() { return MovUltimoProperty().get(); }
    public StringProperty MovUltimoProperty() { 
         if (MovUltimo == null) MovUltimo = new SimpleStringProperty(this, "MovUltimo");
        return MovUltimo; 
    }
    
    private StringProperty FecBajaCarrera;
    public void setFecBajaCarrera(String value) { FecBajaCarreraProperty().set(value); }
    public String getFecBajaCarrera() { return FecBajaCarreraProperty().get(); }
    public StringProperty FecBajaCarreraProperty() { 
         if (FecBajaCarrera == null) FecBajaCarrera = new SimpleStringProperty(this, "FecBajaCarrera");
        return FecBajaCarrera; 
    }
    
    private StringProperty FecSalida;
    public void setFecSalida(String value) { FecSalidaProperty().set(value); }
    public String getFecSalida() { return FecSalidaProperty().get(); }
    public StringProperty FecSalidaProperty() { 
         if (FecSalida == null) FecSalida = new SimpleStringProperty(this, "FecSalida");
        return FecSalida; 
    }
    
    public TableTrayectoria(ArrayList<String> parametros) {
        this.CodJurisdiccional = new SimpleStringProperty(parametros.get(0));
        this.NroOrganismoCarrera = new SimpleStringProperty(parametros.get(1));
        this.NroOrganismoSeccion = new SimpleStringProperty(parametros.get(2));
        this.IdCarrera = new SimpleStringProperty(parametros.get(3));
        this.IdSeccion = new SimpleStringProperty(parametros.get(4));
        this.IdSeccionPrevia = new SimpleStringProperty(parametros.get(5));
        this.CicloLectivo = new SimpleStringProperty(parametros.get(6));
        this.Seccion = new SimpleStringProperty(parametros.get(7));
        this.FecInscripCarrera = new SimpleStringProperty(parametros.get(8));
        this.FecInscripSeccion = new SimpleStringProperty(parametros.get(9));
        this.FecBajaSeccion = new SimpleStringProperty(parametros.get(10));
        this.MovEntrada = new SimpleStringProperty(parametros.get(11));
        this.MovUltimo = new SimpleStringProperty(parametros.get(12));
        this.FecBajaCarrera = new SimpleStringProperty(parametros.get(13));
        this.FecSalida = new SimpleStringProperty(parametros.get(14));
    }
}
