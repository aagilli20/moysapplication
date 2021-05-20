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
public class TableDireSuper {
        
        private StringProperty Cargo;
        public void setCargo(String value) { CargoProperty().set(value); }
        public String getCargo() { return CargoProperty().get(); }
        public StringProperty CargoProperty() { 
             if (Cargo == null) Cargo = new SimpleStringProperty(this, "Cargo");
             return Cargo; 
        }
        
        private StringProperty SitRevista;
        public void setSitRevista(String value) { SitRevistaProperty().set(value); }
        public String getSitRevista() { return SitRevistaProperty().get(); }
        public StringProperty SitRevistaProperty() { 
             if (SitRevista == null) SitRevista = new SimpleStringProperty(this, "SitRevista");
             return SitRevista; 
        }
        
        private StringProperty Documento;
        public void setDocumento(String value) { DocumentoProperty().set(value); }
        public String getDocumento() { return DocumentoProperty().get(); }
        public StringProperty DocumentoProperty() { 
             if (Documento == null) Documento = new SimpleStringProperty(this, "Documento");
             return Documento; 
        }
        
        private StringProperty NombreApellido;
        public void setNombreApellido(String value) { NombreApellidoProperty().set(value); }
        public String getNombreApellido() { return NombreApellidoProperty().get(); }
        public StringProperty NombreApellidoProperty() { 
             if (NombreApellido == null) NombreApellido = new SimpleStringProperty(this, "NombreApellido");
             return NombreApellido; 
        }
        
        public TableDireSuper(String cargo, String sit_revista, String documento, String apellido_nombre) {
            this.Cargo = new SimpleStringProperty(cargo);
            this.SitRevista = new SimpleStringProperty(sit_revista);
            this.Documento = new SimpleStringProperty(documento);
            this.NombreApellido = new SimpleStringProperty(apellido_nombre);
        }
        
        
    }
