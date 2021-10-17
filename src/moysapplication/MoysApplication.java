/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moysapplication;

import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;
import moysapplication.model.User;
import moysapplication.security.Authenticator;


/**
 *
 * @author Andrés Gilli <agilli@santafe.gov.ar>
 */
public class MoysApplication extends Application {
    
    private Stage stage;
    private User loggedUser;
    private String errorMessage;
    private final double MINIMUM_WINDOW_WIDTH;
    private final double MINIMUM_WINDOW_HEIGHT;

    public MoysApplication() {
        this.MINIMUM_WINDOW_WIDTH = 800.0;
        this.MINIMUM_WINDOW_HEIGHT = 600.0;
        this.errorMessage = "";
    }
    
    public String getErrorMessage(){
        return this.errorMessage;
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        try{
            stage = primaryStage;
            stage.setTitle("Aplicación MOYS");
            stage.getIcons().add(new Image("file:.\\img\\telefono-icon.png"));
            stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
            gotoLogin();
            primaryStage.show();
        }catch (Exception ex) {
            Logger.getLogger(MoysApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void gotoLogin() {
        try {
            AccessControlController login = (AccessControlController) replaceSceneContent("AccessControl.fxml");
            login.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(MoysApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
     * Ir a la pantalla principal
     */
    private void gotoHomePage() {
        try {
            HomePageController homePage = (HomePageController) replaceSceneContent("HomePage.fxml");
            homePage.setApp(this);
            // abre la pantalla maximizada
            /*
            stage.setX(0.0);
            stage.setY(0.0);
            stage.setHeight(Toolkit.getDefaultToolkit().getScreenSize().height);
            stage.setWidth(Toolkit.getDefaultToolkit().getScreenSize().width);
            */
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            stage.setX(bounds.getMinX());
            stage.setY(bounds.getMinY());
            stage.setWidth(bounds.getWidth());
            stage.setHeight(bounds.getHeight());
            // pantalla completa
            // stage.setFullScreen(true);
        } catch (Exception ex) {
            Logger.getLogger(MoysApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
     * Ir a la pantalla para actualizar la base de datos de organismos
     */
    private void gotoUpdateDbOrg() {
        try {
            UpdateDbOrgController updateDB = (UpdateDbOrgController) replaceSceneContent("UpdateDbOrg.fxml");
            updateDB.setApp(this);
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            stage.setX(bounds.getMinX());
            stage.setY(bounds.getMinY());
            stage.setWidth(bounds.getWidth());
            stage.setHeight(bounds.getHeight());
        } catch (Exception ex) {
            Logger.getLogger(MoysApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = MoysApplication.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(MoysApplication.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        } 
        Scene scene = new Scene(page, MINIMUM_WINDOW_WIDTH, MINIMUM_WINDOW_HEIGHT);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }
     
    public User getLoggedUser() {
        return loggedUser;
    }
    
    /**
     *
     * @param userId
     * @param password
     * @return
     * @throws java.sql.SQLException
     * @throws java.security.NoSuchAlgorithmException
     */
    public boolean userLogging(String userId, String password) throws SQLException, NoSuchAlgorithmException{
        User auxUser = Authenticator.validate(userId, password);
        if (auxUser.getUserType() != 0){
            if (auxUser.getUserType() > 0) {
                loggedUser = auxUser;
                this.errorMessage = "Acceso confirmado!";
                System.out.println("Ingreso confirmado!");
                if(loggedUser.getUser().equals("root")) gotoUpdateDbOrg();
                else gotoHomePage();
                return true;
            } else {
                if(auxUser.getUserType() == -1) this.errorMessage = "El usuario no se encuentra registrado o bien está duplicado, contáctese con un administrador";
                else this.errorMessage = "Contraseña inválida, inténtelo nuevamente";
                return false;
            }
        } else {
            this.errorMessage = "El usuario no se encuentra habilitado, comuniquese con el Administrador del Sistema para solucionar el inconveniente";
            System.out.println("Usuario no habilitado");
            return false;
        }
        
    }
    
     void userLogout(){
        loggedUser = null;
        gotoLogin();
    }
    
     public Window getWindow(){return this.stage.getScene().getWindow();}
    
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IllegalStateException {
        // launch(args);
        Application.launch(MoysApplication.class, (java.lang.String[])null);        
    }
}