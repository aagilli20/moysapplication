/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moysapplication.model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import moysapplication.data.NPMoysConnect;

/**
 *
 * @author Andrés Gilli <agilli@santafe.gov.ar>
 */
public class FinalizarConsultaPopup {
    private Boolean result;

    public FinalizarConsultaPopup(Window owner, final TableConsultaEnCurso consulta, final String usuario) {
      final Stage dialog = new Stage();

      dialog.setTitle("Finalizar consulta");
      dialog.initOwner(owner);
      dialog.initStyle(StageStyle.UTILITY);
      dialog.initModality(Modality.WINDOW_MODAL);
      dialog.setX(owner.getX() + owner.getWidth());
      dialog.setY(owner.getY());

      final TextField textField = new TextField();
      final Button submitButton = new Button("Guardar");
      submitButton.setDefaultButton(true);
      submitButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent t) {
            try {
                // finalizar consulta y guardar el dialog
                NPMoysConnect conn = new NPMoysConnect();
                conn.finalizarConsulta(Integer.parseInt(consulta.getIdConsulta()), textField.getText(), usuario);
                result = true;
                dialog.close();
            } catch (SQLException ex) {
                Logger.getLogger(FinalizarConsultaPopup.class.getName()).log(Level.SEVERE, null, ex);
                result = false;
            }
        }
      });
      final Button cancelButton = new Button("Cancelar");
      cancelButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent t) {
          result = true;
          dialog.close();
        }
      });
      
      textField.setMinHeight(TextField.USE_PREF_SIZE);
      textField.setText(consulta.getObservacion() + " | ");

      final VBox layout = new VBox(10);
      final HBox layout2 = new HBox(10);
      layout.setAlignment(Pos.CENTER);
      layout2.setAlignment(Pos.CENTER);
      layout.setStyle("-fx-padding: 10;");
      layout2.setStyle("-fx-padding: 10;");
      layout2.getChildren().setAll(cancelButton, submitButton);
      layout.getChildren().setAll(
        textField, 
        layout2
      );

      dialog.setHeight(180);
      dialog.setWidth(300);
      dialog.setScene(new Scene(layout));
      dialog.showAndWait();

      
    }

    public Boolean getResult() {
      return result;
    }
}
