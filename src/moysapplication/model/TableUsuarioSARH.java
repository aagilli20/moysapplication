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
public class TableUsuarioSARH {
    
    private StringProperty Usuario;
        public void setUsuario(String value) { UsuarioProperty().set(value); }
        public String getUsuario() { return UsuarioProperty().get(); }
        public StringProperty UsuarioProperty() { 
             if (Usuario == null) Usuario = new SimpleStringProperty(this, "Usuario");
            return Usuario; 
        }
        
        private StringProperty NombreApellido;
        public void setNombreApellido(String value) { NombreApellidoProperty().set(value); }
        public String getNombreApellido() { return NombreApellidoProperty().get(); }
        public StringProperty NombreApellidoProperty() { 
             if (NombreApellido == null) NombreApellido = new SimpleStringProperty(this, "NombreApellido");
            return NombreApellido; 
        }
        
        private StringProperty Documento;
        public void set(String value) { DocumentoProperty().set(value); }
        public String getDocumento() { return DocumentoProperty().get(); }
        public StringProperty DocumentoProperty() { 
             if (Documento == null) Documento = new SimpleStringProperty(this, "Documento");
            return Documento; 
        }
        
        private StringProperty FechaAlta;
        public void setFechaAlta(String value) { FechaAltaProperty().set(value); }
        public String getFechaAlta() { return FechaAltaProperty().get(); }
        public StringProperty FechaAltaProperty() { 
             if (FechaAlta == null) FechaAlta = new SimpleStringProperty(this, "FechaAlta");
            return FechaAlta; 
        }
        
        private StringProperty FechaBaja;
        public void setFechaBaja(String value) { FechaBajaProperty().set(value); }
        public String getFechaBaja() { return FechaBajaProperty().get(); }
        public StringProperty FechaBajaProperty() { 
             if (FechaBaja == null) FechaBaja = new SimpleStringProperty(this, "FechaBaja");
            return FechaBaja; 
        }
        
        public TableUsuarioSARH(String usuario, String nombre_apellido, String documento, String fecha_alta, String fecha_baja) {
            this.Usuario = new SimpleStringProperty(usuario);
            this.NombreApellido = new SimpleStringProperty(nombre_apellido);
            this.Documento = new SimpleStringProperty(documento);
            this.FechaAlta = new SimpleStringProperty(fecha_alta);
            this.FechaBaja = new SimpleStringProperty(fecha_baja);
        }
}
