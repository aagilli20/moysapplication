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
public class TableTitulosRechazados {
    
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

    private StringProperty TituloImprimir;
    public void setTituloImprimir(String value) { TituloImprimirProperty().set(value); }
    public String getTituloImprimir() { return TituloImprimirProperty().get(); }
    public StringProperty TituloImprimirProperty() { 
         if (TituloImprimir == null) TituloImprimir = new SimpleStringProperty(this, "TituloImprimir");
        return TituloImprimir; 
    }

    private StringProperty ValidezNacional;
    public void set(String value) { ValidezNacionalProperty().set(value); }
    public String getValidezNacional() { return ValidezNacionalProperty().get(); }
    public StringProperty ValidezNacionalProperty() { 
         if (ValidezNacional == null) ValidezNacional = new SimpleStringProperty(this, "ValidezNacional");
        return ValidezNacional; 
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
    
    private StringProperty FechaRechazo;
    public void setFechaRechazo(String value) { FechaRechazoProperty().set(value); }
    public String getFechaRechazo() { return FechaRechazoProperty().get(); }
    public StringProperty FechaRechazoProperty() { 
         if (FechaRechazo == null) FechaRechazo = new SimpleStringProperty(this, "FechaRechazo");
        return FechaRechazo; 
    }
    
    private StringProperty MotivoRechazo;
    public void setMotivoRechazo(String value) { MotivoRechazoProperty().set(value); }
    public String getMotivoRechazo() { return MotivoRechazoProperty().get(); }
    public StringProperty MotivoRechazoProperty() { 
         if (MotivoRechazo == null) MotivoRechazo = new SimpleStringProperty(this, "MotivoRechazo");
        return MotivoRechazo; 
    }
    
    
    public TableTitulosRechazados(ArrayList<String> parametros) {
        this.Establecimiento = new SimpleStringProperty(parametros.get(0));
        this.Plan = new SimpleStringProperty(parametros.get(1));
        this.TituloImprimir = new SimpleStringProperty(parametros.get(2));
        this.ValidezNacional = new SimpleStringProperty(parametros.get(3));
        this.EstadoSolicitud = new SimpleStringProperty(parametros.get(4));
        this.FechaSolicitud = new SimpleStringProperty(parametros.get(5));
        this.FechaSolicitudReal = new SimpleStringProperty(parametros.get(6));
        this.FechaRechazo = new SimpleStringProperty(parametros.get(7));
        this.MotivoRechazo = new SimpleStringProperty(parametros.get(8));
    }
    
}
