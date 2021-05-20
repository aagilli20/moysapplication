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
public class TableTitulosRegistrados {
    
    private StringProperty Establecimiento;
    public void setEstablecimiento(String value) { EstablecimientoProperty().set(value); }
    public String getEstablecimiento() { return EstablecimientoProperty().get(); }
    public StringProperty EstablecimientoProperty() { 
         if (Establecimiento == null) Establecimiento = new SimpleStringProperty(this, "Establecimiento");
        return Establecimiento; 
    }
    
    private StringProperty Plan;
    public void setPlan(String value) { PlanProperty().set(value); }
    public String getPlan() { return PlanProperty().get(); }
    public StringProperty PlanProperty() { 
         if (Plan == null) Plan = new SimpleStringProperty(this, "Plan");
        return Plan; 
    }

    private StringProperty Titulo;
    public void setTitulo(String value) { TituloProperty().set(value); }
    public String getTitulo() { return TituloProperty().get(); }
    public StringProperty TituloProperty() { 
         if (Titulo == null) Titulo = new SimpleStringProperty(this, "Titulo");
        return Titulo; 
    }

    private StringProperty ValidezNacional;
    public void set(String value) { ValidezNacionalProperty().set(value); }
    public String getValidezNacional() { return ValidezNacionalProperty().get(); }
    public StringProperty ValidezNacionalProperty() { 
         if (ValidezNacional == null) ValidezNacional = new SimpleStringProperty(this, "ValidezNacional");
        return ValidezNacional; 
    }

    private StringProperty TipoSolicitud;
    public void setTipoSolicitud(String value) { TipoSolicitudProperty().set(value); }
    public String getTipoSolicitud() { return TipoSolicitudProperty().get(); }
    public StringProperty TipoSolicitudProperty() { 
         if (TipoSolicitud == null) TipoSolicitud = new SimpleStringProperty(this, "TipoSolicitud");
        return TipoSolicitud; 
    }

    private StringProperty EstadoSolicitud;
    public void setEstadoSolicitud(String value) { EstadoSolicitudProperty().set(value); }
    public String getEstadoSolicitud() { return EstadoSolicitudProperty().get(); }
    public StringProperty EstadoSolicitudProperty() { 
         if (EstadoSolicitud == null) EstadoSolicitud = new SimpleStringProperty(this, "EstadoSolicitud");
        return EstadoSolicitud; 
    }
    
    private StringProperty FechaSolicitud;
    public void setFechaSolicitud(String value) { FechaSolicitudProperty().set(value); }
    public String getFechaSolicitud() { return FechaSolicitudProperty().get(); }
    public StringProperty FechaSolicitudProperty() { 
         if (FechaSolicitud == null) FechaSolicitud = new SimpleStringProperty(this, "FechaSolicitud");
        return FechaSolicitud; 
    }
    
    private StringProperty FechaSolicitudReal;
    public void setFechaSolicitudReal(String value) { FechaSolicitudRealProperty().set(value); }
    public String getFechaSolicitudReal() { return FechaSolicitudRealProperty().get(); }
    public StringProperty FechaSolicitudRealProperty() { 
         if (FechaSolicitudReal == null) FechaSolicitudReal = new SimpleStringProperty(this, "FechaSolicitudReal");
        return FechaSolicitudReal; 
    }
    
    public TableTitulosRegistrados(ArrayList<String> parametros) {
        this.Establecimiento = new SimpleStringProperty(parametros.get(0));
        this.Plan = new SimpleStringProperty(parametros.get(1));
        this.Titulo = new SimpleStringProperty(parametros.get(2));
        this.ValidezNacional = new SimpleStringProperty(parametros.get(3));
        this.TipoSolicitud = new SimpleStringProperty(parametros.get(4));
        this.EstadoSolicitud = new SimpleStringProperty(parametros.get(5));
        this.FechaSolicitud = new SimpleStringProperty(parametros.get(6));
        this.FechaSolicitudReal = new SimpleStringProperty(parametros.get(7));
    }
    
}
