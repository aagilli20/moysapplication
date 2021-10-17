/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moysapplication.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Andrés Gilli <agilli@santafe.gov.ar>
 */
public class TableTickets {
    
    private StringProperty IdTicket;
        public void setIdTicket(String value) { IdTicketProperty().set(value); }
        public String getIdTicket() { return IdTicketProperty().get(); }
        public StringProperty IdTicketProperty() { 
             if (IdTicket == null) IdTicket = new SimpleStringProperty(this, "IdTicket");
            return IdTicket; 
        }
        
        private StringProperty Tema;
        public void setTema(String value) { TemaProperty().set(value); }
        public String getTema() { return TemaProperty().get(); }
        public StringProperty TemaProperty() { 
             if (Tema == null) Tema = new SimpleStringProperty(this, "Tema");
            return Tema; 
        }
        
        private StringProperty Subtema;
        public void setSubtema(String value) { SubtemaProperty().set(value); }
        public String getSubtema() { return SubtemaProperty().get(); }
        public StringProperty SubtemaProperty() { 
             if (Subtema == null) Subtema = new SimpleStringProperty(this, "Subtema");
            return Subtema; 
        }
        
        private StringProperty Consulta;
        public void setConsulta(String value) { ConsultaProperty().set(value); }
        public String getConsulta() { return ConsultaProperty().get(); }
        public StringProperty ConsultaProperty() { 
             if (Consulta == null) Consulta = new SimpleStringProperty(this, "Consulta");
            return Consulta; 
        }
        
        private StringProperty FechaCreacion;
        public void setFechaCreacion(String value) { FechaCreacionProperty().set(value); }
        public String getFechaCreacion() { return FechaCreacionProperty().get(); }
        public StringProperty FechaCreacionProperty() { 
             if (FechaCreacion == null) FechaCreacion = new SimpleStringProperty(this, "FechaCreacion");
            return FechaCreacion; 
        }
        
        private StringProperty FechaActualizacion;
        public void setFechaActualizacion(String value) { FechaActualizacionProperty().set(value); }
        public String getFechaActualizacion() { return FechaActualizacionProperty().get(); }
        public StringProperty FechaActualizacionProperty() { 
             if (FechaActualizacion == null) FechaActualizacion = new SimpleStringProperty(this, "FechaActualizacion");
            return FechaActualizacion; 
        }
        
        public TableTickets(String id_ticket, String tema, String subtema, String consulta, String fecha_creacion, String fecha_actualizacion) {
            this.IdTicket = new SimpleStringProperty(id_ticket);
            this.Tema = new SimpleStringProperty(tema);
            this.Subtema = new SimpleStringProperty(subtema);
            this.Consulta = new SimpleStringProperty(consulta);
            this.FechaCreacion = new SimpleStringProperty(fecha_creacion);
            this.FechaActualizacion = new SimpleStringProperty(fecha_actualizacion);
        }
        
}
