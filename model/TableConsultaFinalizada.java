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
public class TableConsultaFinalizada {
    private StringProperty IdConsulta;
        public void setIdConsulta(String value) { IdConsultaProperty().set(value); }
        public String getIdConsulta() { return IdConsultaProperty().get(); }
        public StringProperty IdConsultaProperty() { 
             if (IdConsulta == null) IdConsulta = new SimpleStringProperty(this, "IdConsulta");
            return IdConsulta; 
        }
        
        private StringProperty Tema;
        public void setTema(String value) { TemaProperty().set(value); }
        public String getTema() { return TemaProperty().get(); }
        public StringProperty TemaProperty() { 
             if (Tema == null) Tema = new SimpleStringProperty(this, "Tema");
            return Tema; 
        }
        
        private StringProperty Observacion;
        public void setObservacion(String value) { ObservacionProperty().set(value); }
        public String getObservacion() { return ObservacionProperty().get(); }
        public StringProperty ObservacionProperty() { 
             if (Observacion == null) Observacion = new SimpleStringProperty(this, "Observacion");
            return Observacion; 
        }
        
        private StringProperty FeBaja;
        public void setFeBaja(String value) { FeBajaProperty().set(value); }
        public String getFeBaja() { return FeBajaProperty().get(); }
        public StringProperty FeBajaProperty() { 
             if (FeBaja == null) FeBaja = new SimpleStringProperty(this, "FeBaja");
            return FeBaja; 
        }
        
        private StringProperty Operador;
        public void setOperador(String value) { OperadorProperty().set(value); }
        public String getOperador() { return OperadorProperty().get(); }
        public StringProperty OperadorProperty() { 
             if (Operador == null) Operador = new SimpleStringProperty(this, "Operador");
            return Operador; 
        }
        
        private StringProperty FinalizadoPor;
        public void setFinalizadoPor(String value) { FinalizadoPorProperty().set(value); }
        public String getFinalizadoPor() { return FinalizadoPorProperty().get(); }
        public StringProperty FinalizadoPorProperty() { 
             if (FinalizadoPor == null) FinalizadoPor = new SimpleStringProperty(this, "FinalizadoPor");
            return FinalizadoPor; 
        }
        
        public TableConsultaFinalizada(String id_consulta, String tema, String observacion, String fe_baja, String operador, String finalizado_por) {
            this.IdConsulta = new SimpleStringProperty(id_consulta);
            this.Tema = new SimpleStringProperty(tema);
            this.Observacion = new SimpleStringProperty(observacion);
            this.FeBaja = new SimpleStringProperty(fe_baja);
            this.Operador = new SimpleStringProperty(operador);
            this.FinalizadoPor = new SimpleStringProperty(finalizado_por);
        }
}
