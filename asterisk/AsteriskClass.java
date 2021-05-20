/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moysapplication.asterisk;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.stage.Window;
import jfx.messagebox.MessageBox;
import moysapplication.HomePageController;
import moysapplication.data.NPMoysConnect;
import moysapplication.model.Llamada;
import moysapplication.model.User;
import org.asteriskjava.manager.AuthenticationFailedException;
import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.ManagerConnectionFactory;
import org.asteriskjava.manager.ManagerEventListener;
import org.asteriskjava.manager.TimeoutException;
import org.asteriskjava.manager.action.StatusAction;
import org.asteriskjava.manager.event.LinkEvent;
import org.asteriskjava.manager.event.ManagerEvent;
import org.asteriskjava.manager.event.UnlinkEvent;

/**
 *
 * @author Andrés Gilli <agilli@santafe.gov.ar>
 */
public class AsteriskClass implements ManagerEventListener {
    
    private final ManagerConnection managerConnection;
    private final HomePageController hpc;
    private final Window pantalla;
    private final User LoggedUser;
    private boolean continuar;
    private boolean activo;
    private String id1, id2, id1_fin, id2_fin;
    // array de id para probar el sistema
    ArrayList<String> listaId;
    int indice;
    
    public AsteriskClass(Window win, HomePageController homePage, User loggedUser){   
        ManagerConnectionFactory factory;
        factory = new ManagerConnectionFactory("10.4.10.199", "user", "ssddgg123");
        this.managerConnection = factory.createManagerConnection();
        continuar = true;
        pantalla = win;
        hpc = homePage;
        LoggedUser = loggedUser;
        activo = true;
        id1 = "";
        id2 = "";
        id1_fin = "";
        id2_fin = "";
        // array de id para probar el sistema
        listaId = new ArrayList<>();
        listaId.add("1406721820.65296");
        listaId.add("1406721305.65157");
        listaId.add("1406726159.67197");
        listaId.add("1406726215.67201");
        listaId.add("1406726547.67318");
        listaId.add("1406727545.67589");
        listaId.add("1406727813.67669");
        listaId.add("1406728147.67759");
        listaId.add("1406728322.67793");
        listaId.add("1406728544.67849");
        indice = 0;
    }
    
    /**
     *
     * @param event
     */
    @Override
    public void onManagerEvent(ManagerEvent event) {
        // just print received events
        String evento = event.toString();
        if(activo){
            if (event instanceof LinkEvent) {
                if(evento.contains(LoggedUser.getAgent())){
                    System.out.println(LoggedUser.getAgent());
                    LinkEvent link = (LinkEvent) event;
                    if(! (id1.equals(link.getUniqueId1()) && id2.equals(link.getUniqueId2()))){  
                        activo = false;
                        id1 = link.getUniqueId1();
                        id2 = link.getUniqueId2();
                        System.out.println("Llamada en curso");
                        Platform.runLater(new Runnable() {   
                            @Override public void run() {
                                Llamada entrante;
                                try {
                                    entrante = new NPMoysConnect().getLlamada(listaId.get(indice++));
                                    // String mensaje = "Llamada en curso de "+entrante.getIdEmisor()+" - Opción "+entrante.getOpcionElegida();
                                    String mensaje = "Llamada en curso de "+entrante.getIdEmisor()+" - Opción: ";
                                    mensaje += entrante.getOpcionElegida();
                                    int answer = MessageBox.show(pantalla,
                                                mensaje,
                                                "Mensaje",
                                                MessageBox.ICON_INFORMATION| MessageBox.OK | MessageBox.CANCEL);
                                    if (answer == MessageBox.OK) {
                                        System.out.println("Ok");
                                        if(entrante.getIdTipoEmisor() == 0){
                                            // escuela
                                            try {
                                                hpc.setCodJuris(entrante.getIdEmisor());
                                                ActionEvent ae = new ActionEvent();
                                                hpc.processBuscar(ae);
                                                hpc.resetEscuelaSelectIndex();
                                                hpc.processLoadEscuela(0);
                                                hpc.tabPaneGeneral.getSelectionModel().select(0);
                                            } catch (SQLException | IOException ex) {
                                                Logger.getLogger(AsteriskClass.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                        if(entrante.getIdTipoEmisor() == 1){
                                            // alumno
                                            hpc.setAlumnoNroDoc(entrante.getIdEmisor());
                                            ActionEvent ae = new ActionEvent();
                                            try {
                                                hpc.processBuscarAlumno(ae);
                                                hpc.processLoadAlumno(0);
                                                hpc.tabPaneGeneral.getSelectionModel().select(1);
                                            } catch (IOException ex) {
                                                Logger.getLogger(AsteriskClass.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                        if(entrante.getIdTipoEmisor() == 2){
                                            // agente
                                            hpc.setAgenteNroDoc(entrante.getIdEmisor());
                                            ActionEvent ae = new ActionEvent();
                                            try {
                                                hpc.processBuscarAgente(ae);
                                                hpc.processLoadAgente(0);
                                                hpc.tabPaneGeneral.getSelectionModel().select(2);
                                            } catch (IOException ex) {
                                                Logger.getLogger(AsteriskClass.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    } else if (answer == MessageBox.CANCEL) {
                                        System.out.println("Cancel");
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(AsteriskClass.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                            }    
                        });
                    }
                }
            }
        } else {            
            if (event instanceof UnlinkEvent) {
                if(evento.contains(LoggedUser.getAgent())){
                    UnlinkEvent ulink = (UnlinkEvent) event;
                    if(! (id1_fin.equals(ulink.getUniqueId1()) && id2_fin.equals(ulink.getUniqueId2()))){
                        System.out.println("Finalizó la llamada");
                        id1_fin = ulink.getUniqueId1();
                        id2_fin = ulink.getUniqueId2();
                        activo = true;
                    }
                }
            }
        }
    }
    
    public void run () throws IOException, AuthenticationFailedException, TimeoutException {
        managerConnection.addEventListener(this);
        try {
            // connect to Asterisk and log in
            managerConnection.login();
            // request channel state
            managerConnection.sendAction(new StatusAction());
            // wait 10 seconds for events to come in
            while(continuar) { }
            // and finally log off and disconnect
            managerConnection.logoff();
        } catch (IllegalStateException | IOException | AuthenticationFailedException | TimeoutException ex) {
            Logger.getLogger(AsteriskClass.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: "+ex.getMessage());
        }  
    }
    
    public void Finalizar() {this.continuar = false;}
    public void Comenzar() {this.continuar = true;}
    public String getIdLlamada(){return this.id1;}
    
}
