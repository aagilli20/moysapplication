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
public class TableComedor {
    
        private StringProperty Concepto;
        public void setConcepto(String value) { ConceptoProperty().set(value); }
        public String getConcepto() { return ConceptoProperty().get(); }
        public StringProperty ConceptoProperty() { 
             if (Concepto == null) Concepto = new SimpleStringProperty(this, "Concepto");
            return Concepto; 
        }
        
        private StringProperty Desayuno;
        public void setDesayuno(String value) { DesayunoProperty().set(value); }
        public String getDesayuno() { return DesayunoProperty().get(); }
        public StringProperty DesayunoProperty() { 
             if (Desayuno == null) Desayuno = new SimpleStringProperty(this, "Desayuno");
            return Desayuno; 
        }
        
        private StringProperty Almuerzo;
        public void setAlmuerzo(String value) { AlmuerzoProperty().set(value); }
        public String getAlmuerzo() { return AlmuerzoProperty().get(); }
        public StringProperty AlmuerzoProperty() { 
             if (Almuerzo == null) Almuerzo = new SimpleStringProperty(this, "Almuerzo");
            return Almuerzo; 
        }
        
        private StringProperty Merienda;
        public void setMerienda(String value) { MeriendaProperty().set(value); }
        public String getMerienda() { return MeriendaProperty().get(); }
        public StringProperty MeriendaProperty() { 
             if (Merienda == null) Merienda = new SimpleStringProperty(this, "Merienda");
            return Merienda; 
        }
        
        private StringProperty Cena;
        public void setCena(String value) { CenaProperty().set(value); }
        public String getCena() { return CenaProperty().get(); }
        public StringProperty CenaProperty() { 
             if (Cena == null) Cena = new SimpleStringProperty(this, "Cena");
            return Cena; 
        }
        
        public TableComedor(String concepto, String desayuno, String almuerzo, String merienda, String cena) {
            this.Concepto = new SimpleStringProperty(concepto);
            this.Desayuno = new SimpleStringProperty(desayuno);
            this.Almuerzo = new SimpleStringProperty(almuerzo);
            this.Merienda = new SimpleStringProperty(merienda);
            this.Cena = new SimpleStringProperty(cena);
        }
    
}
