/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moysapplication;

import javafx.scene.input.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import jfx.messagebox.MessageBox;
import moysapplication.asterisk.AsteriskClass;
import moysapplication.data.NPMoysConnect;
import moysapplication.model.Agente;
import moysapplication.model.Alumno;
import moysapplication.model.BecasOtorgadas;
import moysapplication.model.CargosAgente;
import moysapplication.model.Comedor;
import moysapplication.model.Conectividad;
import moysapplication.model.ConsultaEnCurso;
import moysapplication.model.ConsultaFinalizada;
import moysapplication.model.DatosAgente;
import moysapplication.model.DatosEstablecimiento;
import moysapplication.model.Director;
import moysapplication.model.Escuela;
import moysapplication.model.FinalizarConsultaPopup;
import moysapplication.model.HistoricoMatricula;
import moysapplication.model.HorasCatAgente;
import moysapplication.model.MatriculaActivaCiclosAnt;
import moysapplication.model.MatriculaActualPorCarrera;
import moysapplication.model.MedioBoleto;
import moysapplication.model.REDFIE;
import moysapplication.model.Supervisor;
import moysapplication.model.TableActivaCiclosAnt;
import moysapplication.model.TableActualPorCarrera;
import moysapplication.model.TableCargosAgente;
import moysapplication.model.TableComedor;
import moysapplication.model.TableConectividad;
import moysapplication.model.TableConsultaEnCurso;
import moysapplication.model.TableConsultaFinalizada;
import moysapplication.model.TableTickets;
import moysapplication.model.Tickets;
import moysapplication.model.TableDireSuper;
import moysapplication.model.TableHistoricoMatricula;
import moysapplication.model.TableHorasCatAgente;
import moysapplication.model.TableMedioBoleto;
import moysapplication.model.TableREDFIE;
import moysapplication.model.TableTitulosRechazados;
import moysapplication.model.TableTitulosRegistrados;
import moysapplication.model.TableTitulosRegistradosAgente;
import moysapplication.model.TableTrayectoria;
import moysapplication.model.TableUsuarioSARH;
import moysapplication.model.Tema;
import moysapplication.model.Titulos;
import moysapplication.model.TitulosRechazados;
import moysapplication.model.TitulosRegistrados;
import moysapplication.model.TitulosRegistradosAgente;
import moysapplication.model.Trayectoria;
import moysapplication.model.UsuarioSARH;
import org.asteriskjava.manager.AuthenticationFailedException;
import org.asteriskjava.manager.TimeoutException;

/**
 * FXML Controller class
 *
 * @author Andrés Gilli <agilli@santafe.gov.ar>
 */
public class HomePageController implements Initializable {

    @FXML
    public TabPane tabPaneGeneral;
    @FXML
    public ImageView imgTelOnOff;
    public Image telOnline;
    public Image telOffline;
    public Boolean PhoneState;
    // **********************************
    // **  TAB Establecimientos  ********
    // **********************************
    @FXML
    TextField textNroOrg;
    @FXML
    TextField textCodJuris;
    @FXML
    TextField textNombre;
    @FXML
    TextField textCUE;
    @FXML
    TextField textAnexo;
    @FXML
    TextField textLocalidad;
    @FXML
    ComboBox selectRegional;
    @FXML
    ListView listResultados;
    ArrayList<Escuela> listadoEscuelas;
    int nroOrganismoCargado;
    int selectIndex;
    ArrayList<String> OpenTabs;
    @FXML
    Label labelTipoOrganismo;
    @FXML
    Label labelGestion;
    @FXML
    Label labelDomicilio;
    @FXML
    Label labelTelefono;
    @FXML
    Label labelCentrex;
    @FXML
    Label labelEmail;
    @FXML
    Label labelDepartamento;
    @FXML
    Label labelNodo;
    @FXML
    Label labelTieneSigae;
    @FXML
    Label labelActivo;
    @FXML
    Label labelFechaActuVista;
    @FXML
    Label labelCargoEstCurricular;
    @FXML
    Label labelCargosFrenteAula;
    @FXML
    Label labelPlazas;
    @FXML
    Label labelUsuarioVPN;
    // tabla director y supervisores
    @FXML
    TableView<TableDireSuper> tableDirectorSupervisor;
    @FXML
    TableColumn<TableDireSuper, String> columnCargo;
    @FXML
    TableColumn<TableDireSuper, String> columnSitRevista;
    @FXML
    TableColumn<TableDireSuper, String> columnDocumento;
    @FXML
    TableColumn<TableDireSuper, String> columnNombreApellido;
    // fin tabla director y supervisores
    // tabla tickets
    @FXML
    TableView<TableTickets> tableTickets;
    @FXML
    TableColumn<TableTickets, String> columnIdTicket;
    @FXML
    TableColumn<TableTickets, String> columnTema;
    @FXML
    TableColumn<TableTickets, String> columnSubtema;
    @FXML
    TableColumn<TableTickets, String> columnConsulta;
    @FXML
    TableColumn<TableTickets, String> columnFechaCreacion;
    @FXML
    TableColumn<TableTickets, String> columnFechaActualizacion;
    // fin tabla tickets
    // tabla usuarios de SARH
    @FXML
    TableView<TableUsuarioSARH> tableUserSARH;
    @FXML
    TableColumn<TableUsuarioSARH, String> columnUsuario;
    @FXML
    TableColumn<TableUsuarioSARH, String> columnNombreApellidoSARH;
    @FXML
    TableColumn<TableUsuarioSARH, String> columnDocumentoSARH;
    @FXML
    TableColumn<TableUsuarioSARH, String> columnFechaAlta;
    @FXML
    TableColumn<TableUsuarioSARH, String> columnFechaBaja;
    // fin tabla usuarios de SARH
    // datos de becas
    @FXML
    Label labelSolicitadas1;
    @FXML
    Label labelSolicitadas2;
    @FXML
    Label labelOtorgadas;
    @FXML
    Label labelSolicitadasValor1;
    @FXML
    Label labelSolicitadasValor2;
    @FXML
    Label labelOtorgadasValor;
    // fin datos de becas
    // datos de Medio Boleto
    @FXML
    Label labelMBSolPendientes;
    @FXML
    Label labelMBSolOtorgadas;
    // tabla comedor
    @FXML
    TableView<TableMedioBoleto> tableMB;
    @FXML
    TableColumn<TableMedioBoleto, String> columnMBAlumno;
    @FXML
    TableColumn<TableMedioBoleto, String> columnMBDocumento;
    @FXML
    TableColumn<TableMedioBoleto, String> columnMBEstado;
    @FXML
    TableColumn<TableMedioBoleto, String> columnMBMensaje;
    @FXML
    TableColumn<TableMedioBoleto, String> columnMBObservacion;
    // fin tabla medio boleto
    // fin datos de Medio Boleto
    // datos de Comedor
    @FXML
    Label labelEstBeneficiado;
    @FXML
    Label labelEstAsistente;
    // tabla comedor
    @FXML
    TableView<TableComedor> tableComedor;
    @FXML
    TableColumn<TableComedor, String> columnConcepto;
    @FXML
    TableColumn<TableComedor, String> columnDesayuno;
    @FXML
    TableColumn<TableComedor, String> columnAlmuerzo;
    @FXML
    TableColumn<TableComedor, String> columnMerienda;
    @FXML
    TableColumn<TableComedor, String> columnCena;
    // fin tabla comedor
    // datos de Comedor
    // datos de matrícula
    // tabla activos en ciclos lectivos anteriores
    @FXML
    TableView<TableActivaCiclosAnt> tableMACA;
    @FXML
    TableColumn<TableActivaCiclosAnt, String> columnMACACicloLectivo;
    @FXML
    TableColumn<TableActivaCiclosAnt, String> columnMACACarrera;
    @FXML
    TableColumn<TableActivaCiclosAnt, String> columnMACAAnioEstudio;
    @FXML
    TableColumn<TableActivaCiclosAnt, String> columnMACASeccion;
    @FXML
    TableColumn<TableActivaCiclosAnt, String> columnMACAAlumno;
    @FXML
    TableColumn<TableActivaCiclosAnt, String> columnMACADocumento;
    @FXML
    TableColumn<TableActivaCiclosAnt, String> columnMACASexo;
    // fin tabla activos en ciclos lectivos anteriores
    // tabla historico de matricula
    @FXML
    TableView<TableHistoricoMatricula> tableHM;
    @FXML
    TableColumn<TableHistoricoMatricula, String> columnHMCicloLectivo;
    @FXML
    TableColumn<TableHistoricoMatricula, String> columnHMSeccion;
    @FXML
    TableColumn<TableHistoricoMatricula, String> columnHMAlumno;
    @FXML
    TableColumn<TableHistoricoMatricula, String> columnHMMatricula;
    // fin tabla historico de matricula
    // tabla actual por carrera
    @FXML
    TableView<TableActualPorCarrera> tableMAPC;
    @FXML
    TableColumn<TableActualPorCarrera, String> columnMAPCCicloLectivo;
    @FXML
    TableColumn<TableActualPorCarrera, String> columnMAPCNivel;
    @FXML
    TableColumn<TableActualPorCarrera, String> columnMAPCCarrera;
    @FXML
    TableColumn<TableActualPorCarrera, String> columnMAPCSeccion;
    @FXML
    TableColumn<TableActualPorCarrera, String> columnMAPCAlumno;
    @FXML
    TableColumn<TableActualPorCarrera, String> columnMAPCMatricula;
    // fin tabla actual por carrera
    // fin datos de matrícula
    // datos de títulos
    @FXML
    Label labelDirectorAutorizado;
    @FXML
    Label labelCodigoAutorizacion;
    @FXML
    Label labelPIN;
    @FXML
    Label labelCantActivos5y6CiclosAnt;
    @FXML
    Label labelTituloCantTitulosImp1;
    @FXML
    Label labelTituloCantTitulosImp2;
    @FXML
    Label labelCantTitulosImp1;
    @FXML
    Label labelCantTitulosImp2;
    // fin datos de títulos
    // datos de conectividad
    @FXML
    Label labelPCResolucion;
    @FXML
    Label labelPCFechaAprobacion;
    @FXML
    Label labelPCObservacion;
    @FXML
    Label labelTieneInternet;
    @FXML
    Label labelFechaAltaInternet;
    @FXML
    Label labelTipoEnlace;
    @FXML
    Label labelAnchoBanda;
    @FXML
    Label labelAbonoInternet;
    @FXML
    Label labelTelefonoInternet;
    @FXML
    Label labelFuncSitAdversas;
    @FXML
    Label labelProveedor;
    @FXML
    Label labelObsInternet;
    // tabla gastos de funcionamiento
    @FXML
    TableView<TableConectividad> tableConectividad;
    @FXML
    TableColumn<TableConectividad, String> columnGastosAnio;
    @FXML
    TableColumn<TableConectividad, String> columnGastosMes;
    @FXML
    TableColumn<TableConectividad, String> columnGastosDetalle;
    @FXML
    TableColumn<TableConectividad, String> columnGastosImporte;
    // fin tabla gastos de funcionamiento
    // fin datos de conectividad
    // tabla redfie
    // tabla gastos de funcionamiento
    @FXML
    TableView<TableREDFIE> tableREDFIE;
    @FXML
    TableColumn<TableREDFIE, String> columnDescripcion;
    @FXML
    TableColumn<TableREDFIE, String> columnObservacion;
    // fin tabla redfie
    // tab pane general de la pestaña escuela
    @FXML
    TabPane tabPaneEscuela;
    String tabActual;
    // **********************************
    // **  Fin TAB Establecimientos  ****
    // **********************************
    // **********************************
    // **  TAB Agentes  *****************
    // **********************************
    @FXML
    ListView listAgentes;
    Agente listadoAgentes;
    String IdAgenteCargado;
    String IdAgenteNMOYS;
    @FXML
    TextField textNroDocumentoAgente;
    // datos personales
    @FXML
    Label labelAgenteDocumento;
    @FXML
    Label labelAgenteApeNom;
    @FXML
    Label labelAgenteSexo;
    @FXML
    Label labelAgenteFeNac;
    @FXML
    Label labelAgenteProvincia;
    @FXML
    Label labelAgenteLocalidad;
    @FXML
    Label labelAgenteDomicilio;
    @FXML
    Label labelAgenteCodPostal;
    @FXML
    Label labelAgenteTelefono;
    @FXML
    Label labelAgenteCelular;
    @FXML
    Label labelAgenteEmail;
    @FXML
    Label labelAgenteContactoAlt;
    @FXML
    Label labelAgenteFeActu;
    // fin datos personales
    // tabla títulos registrados
    @FXML
    TableView<TableTitulosRegistradosAgente> tableTitulosRegistradosAgente;
    @FXML
    TableColumn<TableTitulosRegistradosAgente, String> columnEstablecimientoAgente;
    @FXML
    TableColumn<TableTitulosRegistradosAgente, String> columnPlanAgente;
    @FXML
    TableColumn<TableTitulosRegistradosAgente, String> columnTituloAgente;
    @FXML
    TableColumn<TableTitulosRegistradosAgente, String> columnRegistroAgente;
    @FXML
    TableColumn<TableTitulosRegistradosAgente, String> columnDiplomaAgente;
    // fin tabla títulos registrados
    // tabla cargos
    @FXML
    TableView<TableCargosAgente> tableCargosAgente;
    @FXML
    TableColumn<TableCargosAgente, String> columnEstablecimientoCargo;
    @FXML
    TableColumn<TableCargosAgente, String> columnTareaCargo;
    @FXML
    TableColumn<TableCargosAgente, String> columnIdCargo;
    @FXML
    TableColumn<TableCargosAgente, String> columnSitRevistaCargo;
    @FXML
    TableColumn<TableCargosAgente, String> columnFeTomaPosecionCargo;
    @FXML
    TableColumn<TableCargosAgente, String> columnFeCeseCargo;
    // fin tabla cargos
    // tabla horas catedra
    @FXML
    TableView<TableHorasCatAgente> tableHorasCatAgente;
    @FXML
    TableColumn<TableHorasCatAgente, String> columnEstablecimientoHoras;
    @FXML
    TableColumn<TableHorasCatAgente, String> columnTerminalidadHoras;
    @FXML
    TableColumn<TableHorasCatAgente, String> columnCurDivTurHoras;
    @FXML
    TableColumn<TableHorasCatAgente, String> columnMateriaHoras;
    @FXML
    TableColumn<TableHorasCatAgente, String> columnHoras;
    @FXML
    TableColumn<TableHorasCatAgente, String> columnIdCargoHoras;
    @FXML
    TableColumn<TableHorasCatAgente, String> columnSitRevistaHoras;
    @FXML
    TableColumn<TableHorasCatAgente, String> columnFeTomaPosecionHoras;
    @FXML
    TableColumn<TableHorasCatAgente, String> columnFeCeseHoras;
    // fin tabla horas catedra
    // **********************************
    // **  Fin TAB Agentes  *************
    // **********************************
    // **********************************
    // **  TAB Alumnos  *****************
    // **********************************
    @FXML
    ListView listAlumnos;
    Alumno listadoAlumnos;
    String IdAlumnoCargado;
    String SexoAlumnoCargado;
    String DocumentoAlumnoCargado;
    String IdAlumnoNMOYS;
    @FXML
    TextField textNroDocumentoAlumno;
    // datos personales
    @FXML
    Label labelAlumnoDocumento;
    @FXML
    Label labelAlumnoApeNom;
    @FXML
    Label labelAlumnoSexo;
    @FXML
    Label labelAlumnoFeNac;
    @FXML
    Label labelAlumnoNacionalidad;
    @FXML
    Label labelAlumnoDepartamento;
    @FXML
    Label labelAlumnoLocalidad;
    @FXML
    Label labelAlumnoCodPostal;
    @FXML
    Label labelAlumnoDomicilio;
    @FXML
    Label labelAlumnoTelefono;
    @FXML
    Label labelAlumnoEmail;
    // fin datos personales
    // tabla trayectoria
    @FXML
    TableView<TableTrayectoria> tableTrayectoria;
    @FXML
    TableColumn<TableTrayectoria, String> columnCodJurisdiccional;
    @FXML
    TableColumn<TableTrayectoria, String> columnNroOrganismoCarrera;
    @FXML
    TableColumn<TableTrayectoria, String> columnNroOrganismoSeccion;
    @FXML
    TableColumn<TableTrayectoria, String> columnIdCarrera;
    @FXML
    TableColumn<TableTrayectoria, String> columnIdSeccion;
    @FXML
    TableColumn<TableTrayectoria, String> columnIdSeccionPrevia;
    @FXML
    TableColumn<TableTrayectoria, String> columnCicloLectivo;
    @FXML
    TableColumn<TableTrayectoria, String> columnSeccion;
    @FXML
    TableColumn<TableTrayectoria, String> columnFecInscripCarrera;
    @FXML
    TableColumn<TableTrayectoria, String> columnFecInscripSeccion;
    @FXML
    TableColumn<TableTrayectoria, String> columnFecBajaSeccion;
    @FXML
    TableColumn<TableTrayectoria, String> columnMovEntrada;
    @FXML
    TableColumn<TableTrayectoria, String> columnMovUltimo;
    @FXML
    TableColumn<TableTrayectoria, String> columnFecBajaCarrera;
    @FXML
    TableColumn<TableTrayectoria, String> columnFecSalida;
    // fin tabla trayectoria
    // tabla títulos registrados
    @FXML
    TableView<TableTitulosRegistrados> tableTitulosRegistrados;
    @FXML
    TableColumn<TableTitulosRegistrados, String> columnEstablecimiento;
    @FXML
    TableColumn<TableTitulosRegistrados, String> columnPlan;
    @FXML
    TableColumn<TableTitulosRegistrados, String> columnTitulo;
    @FXML
    TableColumn<TableTitulosRegistrados, String> columnValidezNacional;
    @FXML
    TableColumn<TableTitulosRegistrados, String> columnTipoSolicitud;
    @FXML
    TableColumn<TableTitulosRegistrados, String> columnEstadoSolicitud;
    @FXML
    TableColumn<TableTitulosRegistrados, String> columnFechaSolicitud;
    @FXML
    TableColumn<TableTitulosRegistrados, String> columnFechaSolicitudReal;
    // fin tabla títulos registrados
    // tabla títulos rechazados
    @FXML
    TableView<TableTitulosRechazados> tableTitulosRechazados;
    @FXML
    TableColumn<TableTitulosRechazados, String> columnEstablecimientoRechazado;
    @FXML
    TableColumn<TableTitulosRechazados, String> columnPlanRechazado;
    @FXML
    TableColumn<TableTitulosRechazados, String> columnTituloImprimirRechazado;
    @FXML
    TableColumn<TableTitulosRechazados, String> columnValidezNacionalRechazado;
    @FXML
    TableColumn<TableTitulosRechazados, String> columnEstadoSolicitudRechazado;
    @FXML
    TableColumn<TableTitulosRechazados, String> columnFechaSolicitudRechazado;
    @FXML
    TableColumn<TableTitulosRechazados, String> columnFechaSolicitudRealRechazado;
    @FXML
    TableColumn<TableTitulosRechazados, String> columnFechaRechazo;
    @FXML
    TableColumn<TableTitulosRechazados, String> columnMotivoRechazo;
    // fin títulos rechazados
    // **********************************
    // **  Fin TAB Alumnos  *************
    // **********************************
    // **********************************
    // **  TAB Llamados  ****************
    // **********************************
    int index_consulta_seleccionada;
    String id_consulta_seleccionada;
    String tipo_consultor;
    Tema listadoTemas;
    @FXML
    TextField textIdConsultor;
    @FXML
    ComboBox selectEstadoLlamado;
    @FXML
    ComboBox selectTemaLlamado;
    @FXML
    TextField textObservacionLlamado;
    // tabla de consultas en curso
    @FXML
    TableView<TableConsultaEnCurso> tableConsultaEnCurso;
    @FXML
    TableColumn<TableConsultaEnCurso, String> columnIdConsultaCurso;
    @FXML
    TableColumn<TableConsultaEnCurso, String> columnTemaEnCurso;
    @FXML
    TableColumn<TableConsultaEnCurso, String> columnObservacionEnCurso;
    @FXML
    TableColumn<TableConsultaEnCurso, String> columnFeAltaEnCurso;
    @FXML
    TableColumn<TableConsultaEnCurso, String> columnOperadorEnCurso;
    // fin tabla de consultas en curso
    // tabla de consultas finalizadas
    @FXML
    TableView<TableConsultaFinalizada> tableConsultaFinalizado;
    @FXML
    TableColumn<TableConsultaFinalizada, String> columnIdConsultaFinalizado;
    @FXML
    TableColumn<TableConsultaFinalizada, String> columnTemaFinalizado;
    @FXML
    TableColumn<TableConsultaFinalizada, String> columnObservacionFinalizado;
    @FXML
    TableColumn<TableConsultaFinalizada, String> columnFeBajaFinalizado;
    @FXML
    TableColumn<TableConsultaFinalizada, String> columnOperadorFinalizado;
    @FXML
    TableColumn<TableConsultaFinalizada, String> columnFinalizadoPorFinalizado;
    // fin tabla de consultas finalizados
    // **********************************
    // **  Fin TAB Llamados  ************
    // **********************************
    // **********************************
    // **  Escucha de llamados  *********
    // **********************************
    Thread eventos;
    AsteriskClass asterisk;
    // **********************************
    // **  Fin Escucha de llamados ******
    // **********************************
    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    // fin declaración de variables globales
    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    private MoysApplication application;
    private Window pantalla;
    private HomePageController hpc;

    public void setApp(MoysApplication application) {
        this.application = application;
        this.pantalla = application.getWindow();
    }

    public void processLogout(ActionEvent event) {
        if (application == null) {
            // Podemos estar corriendo un FXML aislado, posiblemente en Scene Builder
            // NO-OP.
            return;
        }
        if(this.PhoneState) this.asterisk.Finalizar();
        application.userLogout();
    }

    // **********************************
    // **  TAB Establecimientos  ********
    // **********************************
    public void cleanForm(ActionEvent event) {
        textNroOrg.setText("");
        textCodJuris.setText("");
        textNombre.setText("");
        textCUE.setText("");
        textAnexo.setText("");
        textLocalidad.setText("");
        selectRegional.getSelectionModel().selectLast();
    }

    public void processBuscar(ActionEvent event) throws SQLException {
        ObservableList<String> items;
        listadoEscuelas.clear();
        if (textNroOrg.getText().equals("") && textCodJuris.getText().equals("") && textNombre.getText().equals("") && textCUE.getText().equals("") && textLocalidad.getText().equals("") && selectRegional.getSelectionModel().getSelectedItem().toString().equals("")) {
            String fila = "Debe seleccionar al menos un criterio de búsqueda";
            items = FXCollections.observableArrayList(fila);
            listResultados.setItems(items);
        } else {
            // realizar la búsqueda
            NPMoysConnect conn = new NPMoysConnect();
            if (!this.textNroOrg.getText().equals("")) {
                // buscar por número de organismo
                int nroOrg;
                try {
                    nroOrg = Integer.parseInt(this.textNroOrg.getText());
                    listadoEscuelas.add(conn.buscarEscuela(nroOrg));
                    if (listadoEscuelas.get(0).getNroOrg() == -1) {
                        String fila = "No existe ninguna escuela con ese número de organismo";
                        items = FXCollections.observableArrayList(fila);
                        listResultados.setItems(items);
                    } else {
                        String fila = listadoEscuelas.get(0).getNroOrg() + " - " + listadoEscuelas.get(0).getCodJuris() + " - " + listadoEscuelas.get(0).getNombre() + " - " + listadoEscuelas.get(0).getRegion() + " - " + listadoEscuelas.get(0).getLocalidad() + " - " + listadoEscuelas.get(0).getCUE() + " - " + listadoEscuelas.get(0).getAnexo();
                        items = FXCollections.observableArrayList(fila);
                        listResultados.setItems(items);
                    }
                } catch (NumberFormatException e) {
                    String fila = "El número de organismo debe ser un número Entero";
                    items = FXCollections.observableArrayList(fila);
                    listResultados.setItems(items);
                }

            } else {
                int anexo;
                try {
                    if (this.textAnexo.getText().equals("")) {
                        anexo = -1;
                    } else {
                        anexo = Integer.parseInt(this.textAnexo.getText());
                    }
                    String regional = this.selectRegional.getSelectionModel().getSelectedItem().toString();
                    listadoEscuelas = conn.buscarEscuela(this.textCodJuris.getText(), this.textNombre.getText(), regional, this.textLocalidad.getText(), this.textCUE.getText(), anexo);
                    if (listadoEscuelas.get(0).getNroOrg() == -1) {
                        String fila = "No existe ninguna escuela con ese número de organismo";
                        items = FXCollections.observableArrayList(fila);
                        listResultados.setItems(items);
                    } else {
                        items = FXCollections.observableArrayList();
                        for (int i = 0; i < listadoEscuelas.size(); i++) {
                            String fila = listadoEscuelas.get(i).getNroOrg() + " - " + listadoEscuelas.get(i).getCodJuris() + " - " + listadoEscuelas.get(i).getNombre() + " - " + listadoEscuelas.get(i).getRegion() + " - " + listadoEscuelas.get(i).getLocalidad() + " - " + listadoEscuelas.get(i).getCUE() + " - " + listadoEscuelas.get(i).getAnexo();
                            items.add(fila);
                        }
                        listResultados.setItems(items);
                    }
                } catch (NumberFormatException e) {
                    String fila = "El número de anexo debe ser un número Entero";
                    items = FXCollections.observableArrayList(fila);
                    listResultados.setItems(items);
                }

            }
            // cargamos el detector de cambios en el listView elegido
            listResultados.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    // Your action here
                    int indice = listResultados.getSelectionModel().getSelectedIndex();
                    try {
                        selectIndex = indice;
                        processLoadEscuela(indice);
                    } catch (IOException ex) {
                        Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
                        String mensaje = "Se produjo un error al intentar conectarse con las bases de datos del ME, intentelo nuevamente...";
                        MessageBox.show(null, mensaje, "Mensaje", MessageBox.ICON_ERROR | MessageBox.OK);

                    }
                }
            });
        }
    }

    public void processLoadPaneEscuela(int indiceSeleccionado) throws IOException {
        if (listadoEscuelas.size() > 0) {
            if ((indiceSeleccionado != -1) && (listadoEscuelas.get(indiceSeleccionado).getNroOrg() != -1)) {
                this.OpenTabs.add(tabActual);
                switch (this.tabActual) {
                    case "Tickets en Curso":
                        // cargamos el tableTickets
                        this.tableTickets.setItems(getTickets(this.listadoEscuelas.get(indiceSeleccionado).getCodJuris()));
                        // activamos el copy con un clic
                        tableTickets.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
                            // this method will be called whenever user selected row
                            @Override
                            public void changed(ObservableValue observale, Object oldValue, Object newValue) {
                                if (newValue != null) {
                                    TableTickets selectedTicket = (TableTickets) newValue;
                                    // make sure you override toString in UserClass
                                    Clipboard clipboard = Clipboard.getSystemClipboard();
                                    ClipboardContent content = new ClipboardContent();
                                    String output = selectedTicket.getIdTicket() + " | " + selectedTicket.getConsulta();
                                    content.putString(output);
                                    clipboard.setContent(content);
                                }
                            }
                        });
                        // fin cargamos el tableTickets
                        System.out.println("0");
                        break;
                    case "Matrícula":
                        System.out.println("1");
                        break;
                    case "Títulos":
                        // datos de títulos
                        this.loadTitulos(this.listadoEscuelas.get(indiceSeleccionado).getCodJuris());
                        // fin datos de títulos
                        System.out.println("2");
                        break;
                    case "SARH":
                        // cargamos el tableUsuarioSARH
                        this.tableUserSARH.setItems(getUsuarioSARH(this.nroOrganismoCargado, this.listadoEscuelas.get(indiceSeleccionado).getCodJuris()));
                        // activamos el copy con un clic
                        tableUserSARH.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
                            // this method will be called whenever user selected row
                            @Override
                            public void changed(ObservableValue observale, Object oldValue, Object newValue) {
                                if (newValue != null) {
                                    TableUsuarioSARH selectedUser = (TableUsuarioSARH) newValue;
                                    // make sure you override toString in UserClass
                                    Clipboard clipboard = Clipboard.getSystemClipboard();
                                    ClipboardContent content = new ClipboardContent();
                                    String output = selectedUser.getUsuario() + " | " + selectedUser.getDocumento();
                                    content.putString(output);
                                    clipboard.setContent(content);
                                }
                            }
                        });
                        // fin cargamos el tableSARH
                        System.out.println("3");
                        break;
                    case "Comedores":
                        // cargamos el tableComedor
                        this.tableComedor.setItems(getComedor(this.nroOrganismoCargado, this.listadoEscuelas.get(indiceSeleccionado).getCodJuris()));
                        System.out.println("4");
                        break;
                    case "Inconsistencias REDFIE":
                        // datos de REDFIE
                        this.tableREDFIE.setItems(getREDFIE(this.nroOrganismoCargado));
                        // fin datos de REDFIE
                        System.out.println("5");
                        break;
                    case "Medio Boleto":
                        // cargamos el tableMB
                        this.tableMB.setItems(getMedioBoleto(this.listadoEscuelas.get(indiceSeleccionado).getCodJuris()));
                        // activamos el copy con un clic
                        tableMB.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
                            // this method will be called whenever user selected row
                            @Override
                            public void changed(ObservableValue observale, Object oldValue, Object newValue) {
                                if (newValue != null) {
                                    TableMedioBoleto selectedMB = (TableMedioBoleto) newValue;
                                    // make sure you override toString in UserClass
                                    Clipboard clipboard = Clipboard.getSystemClipboard();
                                    ClipboardContent content = new ClipboardContent();
                                    String output = selectedMB.getMBAlumno() + " | " + selectedMB.getMBDocumento() + " | " + selectedMB.getMBMensaje();
                                    content.putString(output);
                                    clipboard.setContent(content);
                                }
                            }
                        });
                        // fin cargamos el table medio boleto
                        System.out.println("6");
                        break;
                    case "Conectividad":
                        // datos de conectividad
                        this.tableConectividad.setItems(getConectividad(this.nroOrganismoCargado));
                        // fin datos de conectividad
                        System.out.println("7");
                        break;
                    default:
                        System.out.println("Opción por default");
                        break;
                }
            }
        }
    }

    public void processLoadEscuela(int indiceSeleccionado) throws IOException {
        if (listadoEscuelas.size() > 0) {
            if ((indiceSeleccionado != -1) && (listadoEscuelas.get(indiceSeleccionado).getNroOrg() != -1)) {
                if (this.nroOrganismoCargado != listadoEscuelas.get(indiceSeleccionado).getNroOrg()) {
                    this.nroOrganismoCargado = listadoEscuelas.get(indiceSeleccionado).getNroOrg();
                    System.out.println("Nro. de Org. Seleccionado: " + this.nroOrganismoCargado);
                    // cargamos el tableDireSuper
                    this.tableDirectorSupervisor.setItems(getDireSuper(this.nroOrganismoCargado));
                    // datos del establecimiento
                    this.loadDatosEst(this.nroOrganismoCargado);
                    // cargamos la cantidad de becas otorgadas
                    this.labelOtorgadasValor.setText(getBecasOtorgadas(this.nroOrganismoCargado) + "");
                    // limpiamos el listado de tabs abiertos
                    this.OpenTabs = new ArrayList<>();
                    // datos del tabPane Establecimiento
                    this.processLoadPaneEscuela(indiceSeleccionado);
                    // reseteamos los tabs de matrícula
                    this.tableMAPC.setItems(null);
                    this.tableHM.setItems(null);
                    this.tableMACA.setItems(null);
                    // reseteamos el label activos de 5 y 6 en tab titulos
                    this.labelCantActivos5y6CiclosAnt.setText("");
                }
            }
        }
    }

    public ObservableList<TableDireSuper> getDireSuper(int nroOrganismo) throws IOException {
        Supervisor listSuper = new Supervisor();
        Director listDire = new Director();
        listSuper.loadSupervisor(nroOrganismo);
        listDire.loadDirector(nroOrganismo);
        ObservableList<TableDireSuper> listDireSuper = FXCollections.observableArrayList();
        for (int i = 0; i < listDire.getSize(); i++) {
            listDireSuper.add(new TableDireSuper("Director", listDire.getSitRevista(i), listDire.getDocumento(i), listDire.getNombreApellido(i)));
        }
        for (int i = 0; i < listSuper.getSize(); i++) {
            listDireSuper.add(new TableDireSuper("Supervisor - " + listSuper.getTipoCircuito(i), listSuper.getSitRevista(i), listSuper.getDocumento(i), listSuper.getNombreApellido(i)));
        }
        return listDireSuper;
    }

    public void loadDatosEst(int nroOrganismo) throws IOException {
        DatosEstablecimiento data = new DatosEstablecimiento();
        data.loadDatosEstablecimiento(nroOrganismo);
        this.labelTipoOrganismo.setText(data.getTipoOrganismo());
        this.labelGestion.setText(data.getGestion());
        this.labelTelefono.setText(data.getTelefono());
        this.labelCentrex.setText(data.getCentrex());
        this.labelDomicilio.setText(data.getDomicilio());
        this.labelDepartamento.setText(data.getDepartamento());
        this.labelNodo.setText(data.getNodo());
        this.labelEmail.setText(data.getEmail());
        this.labelTieneSigae.setText(data.getTieneSigae());
        this.labelActivo.setText(data.getActivo());
        this.labelFechaActuVista.setText(data.getFechaActuVista());
        this.labelCargoEstCurricular.setText(data.getCargoEstCurricular());
        this.labelCargosFrenteAula.setText(data.getCargosFrenteAula());
        this.labelPlazas.setText(data.getPlazas());
        this.labelSolicitadasValor1.setText(data.getBecasSolicitadasAnt());
        this.labelSolicitadasValor2.setText(data.getBecasSolicitadas());
        this.labelMBSolPendientes.setText(data.getMBPendientes());
        this.labelMBSolOtorgadas.setText(data.getMBOtorgadas());
        this.labelTituloCantTitulosImp1.setText(data.getLabelTitulos1());
        this.labelTituloCantTitulosImp2.setText(data.getLabelTitulos2());
        this.labelCantTitulosImp1.setText(data.getcantTitulos1());
        this.labelCantTitulosImp2.setText(data.getcantTitulos2());
        this.labelPCResolucion.setText(data.getPCResolucion());
        this.labelPCFechaAprobacion.setText(data.getPCFechaAprobacion());
        this.labelPCObservacion.setText(data.getPCObservacion());
        this.labelTieneInternet.setText(data.getTieneInternet());

    }

    public void onClickInternetObs() {
        String mensaje = this.labelObsInternet.getText();
        MessageBox.show(null, mensaje, "Observación", MessageBox.ICON_INFORMATION | MessageBox.OK);
    }

    public void onClickPCObs() {
        String mensaje = this.labelPCObservacion.getText();
        MessageBox.show(null, mensaje, "Observación", MessageBox.ICON_INFORMATION | MessageBox.OK);
    }

    public ObservableList<TableTickets> getTickets(String codJuris) throws IOException {
        Tickets listTicket = new Tickets();
        listTicket.loadTickets(codJuris);
        ObservableList<TableTickets> listTableTicket = FXCollections.observableArrayList();
        if (listTicket.getSize() == 0) {
            listTableTicket.add(new TableTickets("No tiene tickets en curso en la MOYS", "", "", "", "", ""));
        }
        for (int i = 0; i < listTicket.getSize(); i++) {
            listTableTicket.add(new TableTickets(listTicket.getIdTicket(i), listTicket.getTema(i), listTicket.getSubtema(i), listTicket.getConsulta(i), listTicket.getFechaCreacion(i), listTicket.getFechaCreacion(i)));
        }
        return listTableTicket;
    }

    public ObservableList<TableMedioBoleto> getMedioBoleto(String codJuris) throws IOException {
        MedioBoleto listMB = new MedioBoleto();
        listMB.loadMedioBoleto(codJuris);
        ObservableList<TableMedioBoleto> listTableMB = FXCollections.observableArrayList();
        for (int i = 0; i < listMB.getSize(); i++) {
            if (listMB.getMBAlumno(i).equals("-")) {
                listTableMB.add(new TableMedioBoleto("No tiene solicitudes pendientes o rechazadas", "", "", "", ""));
            } else {
                listTableMB.add(new TableMedioBoleto(listMB.getMBAlumno(i), listMB.getMBDocumento(i), listMB.getMBEstado(i), listMB.getMBMensaje(i), listMB.getMBObservacion(i)));
            }
        }
        return listTableMB;
    }

    public ObservableList<TableUsuarioSARH> getUsuarioSARH(int nro_organismo, String codJuris) throws IOException {
        UsuarioSARH listUsersSARH = new UsuarioSARH();
        listUsersSARH.loadUsuarioSARH(nro_organismo, codJuris);
        ObservableList<TableUsuarioSARH> listTableUsuarioSARH = FXCollections.observableArrayList();
        for (int i = 0; i < listUsersSARH.getSize(); i++) {
            if (listUsersSARH.getUsuario(i).equals("-")) {
                listTableUsuarioSARH.add(new TableUsuarioSARH("Sin usuarios de SARH", "", "", "", ""));
            } else {
                listTableUsuarioSARH.add(new TableUsuarioSARH(listUsersSARH.getUsuario(i), listUsersSARH.getNombreApellido(i), listUsersSARH.getDocumento(i), listUsersSARH.getFechaAlta(i), listUsersSARH.getFechaBaja(i)));
            }
        }
        if (listUsersSARH.getUsuarioVPN().equals("-")) {
            this.labelUsuarioVPN.setText("Sin usuario VPN");
        } else {
            this.labelUsuarioVPN.setText(listUsersSARH.getUsuarioVPN());
        }
        return listTableUsuarioSARH;
    }

    public ObservableList<TableComedor> getComedor(int nro_organismo, String codJuris) throws IOException {
        Comedor listComedor = new Comedor();
        listComedor.loadComedor(nro_organismo, codJuris);
        ObservableList<TableComedor> listTableComedor = FXCollections.observableArrayList();
        for (int i = 0; i < listComedor.getSize(); i++) {
            listTableComedor.add(new TableComedor(listComedor.getConcepto(i), listComedor.getDesayuno(i), listComedor.getAlmuerzo(i), listComedor.getMerienda(i), listComedor.getCena(i)));
        }
        this.labelEstAsistente.setText(listComedor.getEstAsistente());
        this.labelEstBeneficiado.setText(listComedor.getEstBeneficiado());
        return listTableComedor;
    }

    public int getBecasOtorgadas(int nro_organismo) throws IOException {
        BecasOtorgadas becas = new BecasOtorgadas();
        becas.loadBecasOtorgadas(nro_organismo);
        return becas.getBecasOtorgadas();
    }

    public ObservableList<TableActivaCiclosAnt> getAlumnosActCiclosAnt(int nro_organismo) throws IOException {
        MatriculaActivaCiclosAnt listMACA = new MatriculaActivaCiclosAnt();
        listMACA.loadMACA(nro_organismo);
        ObservableList<TableActivaCiclosAnt> listTableMACA = FXCollections.observableArrayList();
        for (int i = 0; i < listMACA.getSize(); i++) {
            if (listMACA.getMACAAlumno(i).equals("-")) {
                listTableMACA.add(new TableActivaCiclosAnt("No tiene alumnos activos en ciclos anteriores", "", "", "", "", "", ""));
            } else {
                listTableMACA.add(new TableActivaCiclosAnt(listMACA.getMACACicloLectivo(i), listMACA.getMACACarrera(i), listMACA.getMACAAnioEstudio(i), listMACA.getMACASeccion(i), listMACA.getMACAAlumno(i), listMACA.getMACADocumento(i), listMACA.getMACASexo(i)));
            }
        }
        // antes de salir cargamos la cantidad de alumnos activos en quinto y sexto en el tab títulos
        this.labelCantActivos5y6CiclosAnt.setText(listMACA.getMACATitulos() + "");
        return listTableMACA;
    }

    public void processLoadHistoricoMarticula(ActionEvent event) throws IOException {
        // se carga la tabla historico matricula
        this.tableHM.setItems(getHistoricoMatricula(this.nroOrganismoCargado));
    }

    public void processLoadMatriculaActualPorCarrera(ActionEvent event) throws IOException {
        // se carga la tabla matricula actual por carrera
        this.tableMAPC.setItems(getMatriculaActualPorCarrera(this.nroOrganismoCargado));
    }

    public void processLoadAlumnosActCiclosAnt(ActionEvent event) throws IOException {
        this.tableMACA.setItems(getAlumnosActCiclosAnt(this.nroOrganismoCargado));
        // activamos el copiado
        this.tableMACA.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            // this method will be called whenever user selected row
            @Override
            public void changed(ObservableValue observale, Object oldValue, Object newValue) {
                if (newValue != null) {
                    TableActivaCiclosAnt selectedMACA = (TableActivaCiclosAnt) newValue;
                    // make sure you override toString in UserClass
                    Clipboard clipboard = Clipboard.getSystemClipboard();
                    ClipboardContent content = new ClipboardContent();
                    String output = selectedMACA.getMACACicloLectivo() + " | " + selectedMACA.getMACACarrera() + " | ";
                    output += " | " + selectedMACA.getMACAAnioEstudio() + " | " + selectedMACA.getMACASeccion();
                    output += " | " + selectedMACA.getMACAAlumno() + " | " + selectedMACA.getMACADocumento() + " | " + selectedMACA.getMACASexo();
                    content.putString(output);
                    clipboard.setContent(content);
                }
            }
        });
    }

    public ObservableList<TableHistoricoMatricula> getHistoricoMatricula(int nro_organismo) throws IOException {
        HistoricoMatricula listHM = new HistoricoMatricula();
        listHM.loadHistoricoMatricula(nro_organismo);
        ObservableList<TableHistoricoMatricula> listTableHM = FXCollections.observableArrayList();
        for (int i = 0; i < listHM.getSize(); i++) {
            if (listHM.getHMCicloLectivo(i).equals("-")) {
                listTableHM.add(new TableHistoricoMatricula("No se registra ningún histórico", "", "", ""));
            } else {
                listTableHM.add(new TableHistoricoMatricula(listHM.getHMCicloLectivo(i), listHM.getHMSeccion(i), listHM.getHMAlumno(i), listHM.getHMMatricula(i)));
            }
        }
        return listTableHM;
    }

    public ObservableList<TableActualPorCarrera> getMatriculaActualPorCarrera(int nro_organismo) throws IOException {
        MatriculaActualPorCarrera listMAPC = new MatriculaActualPorCarrera();
        listMAPC.loadMACA(nro_organismo);
        ObservableList<TableActualPorCarrera> listTableMAPC = FXCollections.observableArrayList();
        for (int i = 0; i < listMAPC.getSize(); i++) {
            if (listMAPC.getMAPCCicloLectivo(i).equals("-")) {
                listTableMAPC.add(new TableActualPorCarrera("No se registra ningún histórico", "", "", "", "", ""));
            } else {
                listTableMAPC.add(new TableActualPorCarrera(listMAPC.getMAPCCicloLectivo(i), listMAPC.getMAPCNivel(i), listMAPC.getMAPCCarrera(i), listMAPC.getMAPCSeccion(i), listMAPC.getMAPCAlumno(i), listMAPC.getMAPCMatricula(i)));
            }
        }
        return listTableMAPC;
    }

    public void loadTitulos(String codJuris) throws IOException {
        Titulos data = new Titulos();
        data.loadTitulos(codJuris);
        this.labelDirectorAutorizado.setText(data.getDirectorAutorizado());
        this.labelCodigoAutorizacion.setText(data.getCodigoAutorizacion());
        this.labelPIN.setText(data.getPIN());
    }

    public ObservableList<TableConectividad> getConectividad(int nro_organismo) throws IOException {
        Conectividad listConect = new Conectividad();
        listConect.loadConectividad(nro_organismo);
        ObservableList<TableConectividad> listTableConect = FXCollections.observableArrayList();
        if (listConect.getSize() == 0) {
            listTableConect.add(new TableConectividad("No registra liquidaciones por internet", "", "", ""));
        }
        for (int i = 0; i < listConect.getSize(); i++) {
            listTableConect.add(new TableConectividad(listConect.getGastosAnio(i), listConect.getGastosMes(i), listConect.getGastosDetalle(i), listConect.getGastosImporte(i)));
        }
        // antes de retornar seteamos los labels
        this.labelFechaAltaInternet.setText(listConect.getFechaAlta());
        this.labelTipoEnlace.setText(listConect.getTipoEnlace());
        this.labelAnchoBanda.setText(listConect.getAnchoBanda());
        this.labelAbonoInternet.setText(listConect.getAbono());
        this.labelTelefonoInternet.setText(listConect.getTelefonoInternet());
        this.labelFuncSitAdversas.setText(listConect.getFuncSitAdversas());
        this.labelProveedor.setText(listConect.getProveedor());
        this.labelObsInternet.setText(listConect.getObservaciones());
        // retornamos
        return listTableConect;
    }

    public ObservableList<TableREDFIE> getREDFIE(int nro_organismo) throws IOException {
        REDFIE listREDFIE = new REDFIE();
        listREDFIE.loadREDFIE(nro_organismo);
        ObservableList<TableREDFIE> listTableREDFIE = FXCollections.observableArrayList();
        for (int i = 0; i < listREDFIE.getSize(); i++) {
            listTableREDFIE.add(new TableREDFIE(listREDFIE.getDescripcion(i), listREDFIE.getObservacion(i)));
        }
        return listTableREDFIE;
    }

    // **********************************
    // **  Fin TAB Establecimientos  ****
    // **********************************
    // **********************************
    // **  TAB Agentes  *****************
    // **********************************
    public void processBuscarAgente(ActionEvent event) throws IOException {
        ObservableList<String> items;
        listadoAgentes = new Agente();
        if (textNroDocumentoAgente.getText().equals("")) {
            String fila = "Debe ingresar un DNI antes de buscar";
            items = FXCollections.observableArrayList(fila);
            listAgentes.setItems(items);
        } else {
            // realizar la búsqueda
            listadoAgentes.loadAgente(textNroDocumentoAgente.getText());
            if (listadoAgentes.getIdAgente(0).equals("-")) {
                String fila = "No existe ningún agente con ese número de Documento";
                items = FXCollections.observableArrayList(fila);
                listAgentes.setItems(items);
            } else {
                items = FXCollections.observableArrayList();
                for (int i = 0; i < listadoAgentes.getSize(); i++) {
                    String fila = listadoAgentes.getIdAgente(i) + " - " + listadoAgentes.getDocumento(i) + " - " + listadoAgentes.getApellidoNombre(i) + " - " + listadoAgentes.getSexo(i);
                    items.add(fila);
                }
                listAgentes.setItems(items);
            }

            // cargamos el detector de cambios en el listView elegido
            listAgentes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    // Your action here
                    int indice = listAgentes.getSelectionModel().getSelectedIndex();
                    try {
                        processLoadAgente(indice);
                    } catch (IOException ex) {
                        Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
                        String mensaje = "Se produjo un error al intentar conectarse con las bases de datos del ME, intentelo nuevamente...";
                        MessageBox.show(null, mensaje, "Mensaje", MessageBox.ICON_ERROR | MessageBox.OK);
                    }
                }
            });
        }
    }

    public void processLoadAgente(int indiceSeleccionado) throws IOException {
        if (listadoAgentes.getSize() > 0) {
            if (indiceSeleccionado != -1) {
                if (!this.IdAgenteCargado.equals(listadoAgentes.getIdAgente(indiceSeleccionado))) {
                    this.IdAgenteCargado = listadoAgentes.getIdAgente(indiceSeleccionado);
                    this.IdAgenteNMOYS = this.listadoAgentes.getDocumento(indiceSeleccionado) + ";";
                    this.IdAgenteNMOYS += this.listadoAgentes.getSexo(indiceSeleccionado);
                    System.out.println("ID Agente seleccionado: " + this.IdAgenteCargado);
                    String sexo_cargado = listadoAgentes.getSexo(indiceSeleccionado);
                    String nro_doc_cargado = listadoAgentes.getDocumento(indiceSeleccionado);
                    String aux_nro_doc = "";
                    for (int i = 0; i < nro_doc_cargado.length(); i++) {
                        char caracter = nro_doc_cargado.charAt(i);
                        if (Character.isDigit(caracter)) {
                            aux_nro_doc += caracter;
                        }
                    }
                    nro_doc_cargado = aux_nro_doc;
                    String tipo_doc = "";
                    if (listadoAgentes.getDocumento(indiceSeleccionado).contains("I")) {
                        tipo_doc = "3";
                    }
                    if (listadoAgentes.getDocumento(indiceSeleccionado).contains("C")) {
                        tipo_doc = "2";
                    }
                    if (listadoAgentes.getDocumento(indiceSeleccionado).contains("E")) {
                        tipo_doc = "1";
                    }
                    this.IdAgenteNMOYS = nro_doc_cargado + ";" + this.listadoAgentes.getSexo(indiceSeleccionado);
                    // cargamos los datos del agente
                    this.loadDatosPersonalesAgente(nro_doc_cargado, sexo_cargado, indiceSeleccionado);
                    // titulos registrados
                    this.tableTitulosRegistradosAgente.setItems(this.getTitulosRegistradosAgente(nro_doc_cargado, sexo_cargado));
                    // cargos agente
                    this.tableCargosAgente.setItems(this.getCargosAgente(nro_doc_cargado, tipo_doc));
                    // horas catedra agente
                    this.tableHorasCatAgente.setItems(this.getHorasCatAgente(nro_doc_cargado, tipo_doc));
                }
            }
        }
    }

    public void loadDatosPersonalesAgente(String nro_documento, String sexo, int indiceSeleccionado) throws IOException {
        DatosAgente datos = new DatosAgente();
        datos.loadDatosAgente(nro_documento, sexo);
        labelAgenteDocumento.setText(listadoAgentes.getDocumento(indiceSeleccionado));
        labelAgenteApeNom.setText(listadoAgentes.getApellidoNombre(indiceSeleccionado));
        labelAgenteSexo.setText(listadoAgentes.getSexo(indiceSeleccionado));
        labelAgenteFeNac.setText(datos.getFeNac());
        labelAgenteProvincia.setText(datos.getProvincia());
        labelAgenteLocalidad.setText(datos.getLocalidad());
        labelAgenteDomicilio.setText(datos.getDomicilio());
        labelAgenteCodPostal.setText(datos.getCodPostal());
        labelAgenteTelefono.setText(datos.getTelefono());
        labelAgenteCelular.setText(datos.getCelular());
        labelAgenteEmail.setText(datos.getEMail());
        labelAgenteContactoAlt.setText(datos.getContactoAlt());
        labelAgenteFeActu.setText(datos.getFeActu());
    }

    public ObservableList<TableTitulosRegistradosAgente> getTitulosRegistradosAgente(String nro_documento, String sexo) throws IOException {
        TitulosRegistradosAgente listTitulosRegistrados = new TitulosRegistradosAgente();
        listTitulosRegistrados.loadTitulosRegistradosAgente(nro_documento, sexo);
        ObservableList<TableTitulosRegistradosAgente> listTableTitulosRegistrados = FXCollections.observableArrayList();
        for (int i = 0; i < listTitulosRegistrados.getSize(); i++) {
            ArrayList<String> parametros = new ArrayList<>();
            parametros.add(listTitulosRegistrados.getEstablecimiento(i));
            parametros.add(listTitulosRegistrados.getPlan(i));
            parametros.add(listTitulosRegistrados.getTitulo(i));
            parametros.add(listTitulosRegistrados.getRegistro(i));
            parametros.add(listTitulosRegistrados.getDiploma(i));
            listTableTitulosRegistrados.add(new TableTitulosRegistradosAgente(parametros));
        }
        // antes de salir cargamos la cantidad de alumnos activos en quinto y sexto en el tab títulos
        return listTableTitulosRegistrados;
    }

    public ObservableList<TableCargosAgente> getCargosAgente(String nro_documento, String tipo_doc) throws IOException {
        CargosAgente listCargosAgente = new CargosAgente();
        listCargosAgente.loadCargosAgente(nro_documento, tipo_doc);
        ObservableList<TableCargosAgente> listTableCargosAgente = FXCollections.observableArrayList();
        for (int i = 0; i < listCargosAgente.getSize(); i++) {
            ArrayList<String> parametros = new ArrayList<>();
            parametros.add(listCargosAgente.getEstablecimiento(i));
            parametros.add(listCargosAgente.getTarea(i));
            parametros.add(listCargosAgente.getIdCargo(i));
            parametros.add(listCargosAgente.getSitRevista(i));
            parametros.add(listCargosAgente.getFeTomaPosecion(i));
            parametros.add(listCargosAgente.getFeCese(i));
            listTableCargosAgente.add(new TableCargosAgente(parametros));
        }
        // antes de salir cargamos la cantidad de alumnos activos en quinto y sexto en el tab títulos
        return listTableCargosAgente;
    }

    public ObservableList<TableHorasCatAgente> getHorasCatAgente(String nro_documento, String tipo_doc) throws IOException {
        HorasCatAgente listHorasCatAgente = new HorasCatAgente();
        listHorasCatAgente.loadHorasCatAgente(nro_documento, tipo_doc);
        ObservableList<TableHorasCatAgente> listTableHorasCatAgente = FXCollections.observableArrayList();
        for (int i = 0; i < listHorasCatAgente.getSize(); i++) {
            ArrayList<String> parametros = new ArrayList<>();
            parametros.add(listHorasCatAgente.getEstablecimiento(i));
            parametros.add(listHorasCatAgente.getTerminalidad(i));
            parametros.add(listHorasCatAgente.getCurDivTur(i));
            parametros.add(listHorasCatAgente.getMateria(i));
            parametros.add(listHorasCatAgente.getHoras(i));
            parametros.add(listHorasCatAgente.getIdCargo(i));
            parametros.add(listHorasCatAgente.getSitRevista(i));
            parametros.add(listHorasCatAgente.getFeTomaPosecion(i));
            parametros.add(listHorasCatAgente.getFeCese(i));
            listTableHorasCatAgente.add(new TableHorasCatAgente(parametros));
        }
        // antes de salir cargamos la cantidad de alumnos activos en quinto y sexto en el tab títulos
        return listTableHorasCatAgente;
    }

    // **********************************
    // **  Fin TAB Agentes  *************
    // **********************************
    // **********************************
    // **  TAB Alumno  ********
    // **********************************
    public void processBuscarAlumno(ActionEvent event) throws IOException {
        ObservableList<String> items;
        listadoAlumnos = new Alumno();
        if (textNroDocumentoAlumno.getText().equals("")) {
            String fila = "Debe ingresar un DNI antes de buscar";
            items = FXCollections.observableArrayList(fila);
            listAlumnos.setItems(items);
        } else {
            // realizar la búsqueda
            listadoAlumnos.loadAlumno(textNroDocumentoAlumno.getText());
            if (listadoAlumnos.getIdAlumno(0).equals("-")) {
                String fila = "No existe ningún alumno con ese número de Documento";
                items = FXCollections.observableArrayList(fila);
                listAlumnos.setItems(items);
            } else {
                items = FXCollections.observableArrayList();
                this.DocumentoAlumnoCargado = textNroDocumentoAlumno.getText();
                for (int i = 0; i < listadoAlumnos.getSize(); i++) {
                    String fila = listadoAlumnos.getIdAlumno(i) + " - " + listadoAlumnos.getDocumento(i) + " - " + listadoAlumnos.getApellidoNombre(i) + " - " + listadoAlumnos.getSexo(i);
                    items.add(fila);
                }
                listAlumnos.setItems(items);
            }

            // cargamos el detector de cambios en el listView elegido
            listAlumnos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    // Your action here
                    int indice = listAlumnos.getSelectionModel().getSelectedIndex();
                    try {
                        processLoadAlumno(indice);
                    } catch (IOException ex) {
                        Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
                        String mensaje = "Se produjo un error al intentar conectarse con las bases de datos del ME, intentelo nuevamente...";
                        MessageBox.show(null, mensaje, "Mensaje", MessageBox.ICON_ERROR | MessageBox.OK);
                    }
                }
            });
        }
    }

    public void processLoadAlumno(int indiceSeleccionado) throws IOException {
        if (listadoAlumnos.getSize() > 0) {
            if (indiceSeleccionado != -1) {
                if (!this.IdAlumnoCargado.equals(listadoAlumnos.getIdAlumno(indiceSeleccionado))) {
                    this.IdAlumnoCargado = listadoAlumnos.getIdAlumno(indiceSeleccionado);
                    this.SexoAlumnoCargado = listadoAlumnos.getSexo(indiceSeleccionado);
                    this.IdAlumnoNMOYS = this.DocumentoAlumnoCargado + ";" + this.SexoAlumnoCargado;
                    System.out.println("ID Alumno seleccionado: " + this.IdAlumnoCargado);
                    // cargamos los datos del alumno
                    // datos personales
                    this.loadDatosPersonalesAlumno(indiceSeleccionado);
                    // trayectoria
                    this.tableTrayectoria.setItems(this.getTrayectoria(this.DocumentoAlumnoCargado, this.SexoAlumnoCargado));
                    // titulos registrados
                    this.tableTitulosRegistrados.setItems(this.getTitulosRegistrados(this.DocumentoAlumnoCargado, this.SexoAlumnoCargado));
                    // titulos rechazados
                    this.tableTitulosRechazados.setItems(this.getTitulosRechazados(this.DocumentoAlumnoCargado, this.SexoAlumnoCargado));
                    this.tableTitulosRechazados.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
                        // this method will be called whenever user selected row
                        @Override
                        public void changed(ObservableValue observale, Object oldValue, Object newValue) {
                            if (newValue != null) {
                                TableTitulosRechazados TTR = (TableTitulosRechazados) newValue;
                                String message = TTR.getMotivoRechazo();
                                MessageBox.show(null, message, "Mensaje", MessageBox.ICON_INFORMATION | MessageBox.OK);
                            }
                        }
                    });
                }
            }
        }
    }

    public void loadDatosPersonalesAlumno(int indiceSeleccionado) {
        labelAlumnoDocumento.setText(listadoAlumnos.getDocumento(indiceSeleccionado));
        labelAlumnoApeNom.setText(listadoAlumnos.getApellidoNombre(indiceSeleccionado));
        labelAlumnoSexo.setText(listadoAlumnos.getSexo(indiceSeleccionado));
        labelAlumnoFeNac.setText(listadoAlumnos.getFechaNacimiento(indiceSeleccionado));
        labelAlumnoNacionalidad.setText(listadoAlumnos.getNacionalidad(indiceSeleccionado));
        labelAlumnoDepartamento.setText(listadoAlumnos.getDepartamento(indiceSeleccionado));
        labelAlumnoLocalidad.setText(listadoAlumnos.getLocalidad(indiceSeleccionado));
        labelAlumnoCodPostal.setText(listadoAlumnos.getCodigoPostal(indiceSeleccionado));
        labelAlumnoDomicilio.setText(listadoAlumnos.getDomicilio(indiceSeleccionado));
        labelAlumnoTelefono.setText(listadoAlumnos.getTelefono(indiceSeleccionado));
        labelAlumnoEmail.setText(listadoAlumnos.getEMail(indiceSeleccionado));
    }

    public ObservableList<TableTrayectoria> getTrayectoria(String nro_documento, String sexo) throws IOException {
        Trayectoria listTrayectoria = new Trayectoria();
        listTrayectoria.loadTrayectoria(nro_documento, sexo);
        ObservableList<TableTrayectoria> listTableTrayectoria = FXCollections.observableArrayList();
        for (int i = 0; i < listTrayectoria.getSize(); i++) {
            if (listTrayectoria.getNroOrganismoCarrera(i).equals("-")) {
                ArrayList<String> parametros = new ArrayList<>();
                for (int j = 0; j < 15; j++) {
                    parametros.add("");
                }
                parametros.set(0, "No se registra trayectoria para éste alumno");
                listTableTrayectoria.add(new TableTrayectoria(parametros));
            } else {
                ArrayList<String> parametros = new ArrayList<>();
                parametros.add(listTrayectoria.getCodJurisdiccional(i));
                parametros.add(listTrayectoria.getNroOrganismoCarrera(i));
                parametros.add(listTrayectoria.getNroOrganismoSeccion(i));
                parametros.add(listTrayectoria.getIdCarrera(i));
                parametros.add(listTrayectoria.getIdSeccion(i));
                parametros.add(listTrayectoria.getIdSeccionPrevia(i));
                parametros.add(listTrayectoria.getCicloLectio(i));
                parametros.add(listTrayectoria.getSeccion(i));
                parametros.add(listTrayectoria.getFecInscripCarrera(i));
                parametros.add(listTrayectoria.getFecInscripSeccion(i));
                parametros.add(listTrayectoria.getFecBajaSeccion(i));
                parametros.add(listTrayectoria.getMovEntrada(i));
                parametros.add(listTrayectoria.getMovUltimo(i));
                parametros.add(listTrayectoria.getFecBajaCarrera(i));
                parametros.add(listTrayectoria.getFecSalida(i));
                listTableTrayectoria.add(new TableTrayectoria(parametros));
            }
        }
        // antes de salir cargamos la cantidad de alumnos activos en quinto y sexto en el tab títulos
        return listTableTrayectoria;
    }

    public ObservableList<TableTitulosRegistrados> getTitulosRegistrados(String nro_documento, String sexo) throws IOException {
        TitulosRegistrados listTitulosRegistrados = new TitulosRegistrados();
        listTitulosRegistrados.loadTitulosRegistrados(nro_documento, sexo);
        ObservableList<TableTitulosRegistrados> listTableTitulosRegistrados = FXCollections.observableArrayList();
        for (int i = 0; i < listTitulosRegistrados.getSize(); i++) {
            ArrayList<String> parametros = new ArrayList<>();
            parametros.add(listTitulosRegistrados.getEstablecimiento(i));
            parametros.add(listTitulosRegistrados.getPlan(i));
            parametros.add(listTitulosRegistrados.getTitulo(i));
            parametros.add(listTitulosRegistrados.getValidezNacional(i));
            parametros.add(listTitulosRegistrados.getTipoSolicitud(i));
            parametros.add(listTitulosRegistrados.getEstadoSolicitud(i));
            parametros.add(listTitulosRegistrados.getFechaSolicitud(i));
            parametros.add(listTitulosRegistrados.getFechaSolicitudReal(i));
            listTableTitulosRegistrados.add(new TableTitulosRegistrados(parametros));
        }
        // antes de salir cargamos la cantidad de alumnos activos en quinto y sexto en el tab títulos
        return listTableTitulosRegistrados;
    }

    public ObservableList<TableTitulosRechazados> getTitulosRechazados(String nro_documento, String sexo) throws IOException {
        TitulosRechazados listTitulosRechazados = new TitulosRechazados();
        listTitulosRechazados.loadTitulosRechazados(nro_documento, sexo);
        ObservableList<TableTitulosRechazados> listTableTitulosRechazados = FXCollections.observableArrayList();
        for (int i = 0; i < listTitulosRechazados.getSize(); i++) {
            ArrayList<String> parametros = new ArrayList<>();
            parametros.add(listTitulosRechazados.getEstablecimiento(i));
            parametros.add(listTitulosRechazados.getPlan(i));
            parametros.add(listTitulosRechazados.getTituloImprimir(i));
            parametros.add(listTitulosRechazados.getValidezNacional(i));
            parametros.add(listTitulosRechazados.getEstadoSolicitud(i));
            parametros.add(listTitulosRechazados.getFechaSolicitud(i));
            parametros.add(listTitulosRechazados.getFechaSolicitudReal(i));
            parametros.add(listTitulosRechazados.getFechaRechazo(i));
            parametros.add(listTitulosRechazados.getMotivoRechazo(i));
            listTableTitulosRechazados.add(new TableTitulosRechazados(parametros));
        }
        // antes de salir cargamos la cantidad de alumnos activos en quinto y sexto en el tab títulos
        return listTableTitulosRechazados;
    }

    // **********************************
    // **  Fin TAB Alumnos  *************
    // **********************************
    // **********************************
    // **  TAB Llamadas  ****************
    // **********************************
    public void processLlamadaDeEscuela(ActionEvent event) {
        tipo_consultor = "Escuela";
        this.textIdConsultor.setText("" + this.nroOrganismoCargado);
        this.tableConsultaEnCurso.setItems(this.getConsultasEnCurso("" + this.nroOrganismoCargado));
        this.tableConsultaEnCurso.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            // this method will be called whenever user selected row
            @Override
            public void changed(ObservableValue observale, Object oldValue, Object newValue) {
                if (newValue != null) {
                    TableConsultaEnCurso selectedConsul = (TableConsultaEnCurso) newValue;
                    int indice = tableConsultaEnCurso.getSelectionModel().getSelectedIndex();
                    if ((index_consulta_seleccionada != indice) || (!id_consulta_seleccionada.equals(selectedConsul.getIdConsulta()))) {
                        if (!selectedConsul.getIdConsulta().equals("No hay consultas en curso")) {
                            index_consulta_seleccionada = indice;
                            id_consulta_seleccionada = selectedConsul.getIdConsulta();
                            System.out.println(id_consulta_seleccionada);
                            Stage win = new Stage();
                            VBox textContainer = new VBox(10);
                            textContainer.setStyle("-fx-background-color: cornsilk; -fx-padding: 10;");
                            win.setScene(new Scene(textContainer, 400, 1000));
                            FinalizarConsultaPopup popup = new FinalizarConsultaPopup(win.getScene().getWindow(), selectedConsul, application.getLoggedUser().getUser());
                            Boolean ok = popup.getResult();
                            if (ok) {
                                // actualizar los listados
                                ActionEvent ae = new ActionEvent();
                                if (tipo_consultor.equals("Escuela")) {
                                    processLlamadaDeEscuela(ae);
                                } else {
                                    if (tipo_consultor.equals("Agente")) {
                                        processLlamadaDeAgente(ae);
                                    } else {
                                        processLlamadaDeAlumno(ae);
                                    }
                                }
                            }

                        }
                    }
                }
            }
        });
        this.tableConsultaFinalizado.setItems(this.getConsultaFinalizada("" + this.nroOrganismoCargado));
    }

    public void processLlamadaDeAgente(ActionEvent event) {
        tipo_consultor = "Agente";
        this.textIdConsultor.setText(this.IdAgenteNMOYS);
        this.tableConsultaEnCurso.setItems(this.getConsultasEnCurso(this.IdAgenteNMOYS));
        this.tableConsultaEnCurso.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            // this method will be called whenever user selected row
            @Override
            public void changed(ObservableValue observale, Object oldValue, Object newValue) {
                if (newValue != null) {
                    TableConsultaEnCurso selectedConsul = (TableConsultaEnCurso) newValue;
                    int indice = tableConsultaEnCurso.getSelectionModel().getSelectedIndex();
                    if ((index_consulta_seleccionada != indice) || (!id_consulta_seleccionada.equals(selectedConsul.getIdConsulta()))) {
                        if (!selectedConsul.getIdConsulta().equals("No hay consultas en curso")) {
                            index_consulta_seleccionada = indice;
                            id_consulta_seleccionada = selectedConsul.getIdConsulta();
                            System.out.println(id_consulta_seleccionada);
                            Stage win = new Stage();
                            VBox textContainer = new VBox(10);
                            textContainer.setStyle("-fx-background-color: cornsilk; -fx-padding: 10;");
                            win.setScene(new Scene(textContainer, 400, 1000));
                            FinalizarConsultaPopup popup = new FinalizarConsultaPopup(win.getScene().getWindow(), selectedConsul, application.getLoggedUser().getUser());
                            Boolean ok = popup.getResult();
                            if (ok) {
                                // actualizar los listados
                                ActionEvent ae = new ActionEvent();
                                if (tipo_consultor.equals("Escuela")) {
                                    processLlamadaDeEscuela(ae);
                                } else {
                                    if (tipo_consultor.equals("Agente")) {
                                        processLlamadaDeAgente(ae);
                                    } else {
                                        processLlamadaDeAlumno(ae);
                                    }
                                }
                            }

                        }
                    }
                }
            }
        });
        this.tableConsultaFinalizado.setItems(this.getConsultaFinalizada(this.IdAgenteNMOYS));
    }

    public void processLlamadaDeAlumno(ActionEvent event) {
        tipo_consultor = "Alumno";
        this.textIdConsultor.setText(this.IdAlumnoNMOYS);
        this.tableConsultaEnCurso.setItems(this.getConsultasEnCurso(this.IdAlumnoNMOYS));
        this.tableConsultaEnCurso.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            // this method will be called whenever user selected row
            @Override
            public void changed(ObservableValue observale, Object oldValue, Object newValue) {
                if (newValue != null) {
                    TableConsultaEnCurso selectedConsul = (TableConsultaEnCurso) newValue;
                    int indice = tableConsultaEnCurso.getSelectionModel().getSelectedIndex();
                    if ((index_consulta_seleccionada != indice) || (!id_consulta_seleccionada.equals(selectedConsul.getIdConsulta()))) {
                        if (!selectedConsul.getIdConsulta().equals("No hay consultas en curso")) {
                            index_consulta_seleccionada = indice;
                            id_consulta_seleccionada = selectedConsul.getIdConsulta();
                            System.out.println(id_consulta_seleccionada);
                            Stage win = new Stage();
                            VBox textContainer = new VBox(10);
                            textContainer.setStyle("-fx-background-color: cornsilk; -fx-padding: 10;");
                            win.setScene(new Scene(textContainer, 400, 1000));
                            FinalizarConsultaPopup popup = new FinalizarConsultaPopup(win.getScene().getWindow(), selectedConsul, application.getLoggedUser().getUser());
                            Boolean ok = popup.getResult();
                            if (ok) {
                                // actualizar los listados
                                ActionEvent ae = new ActionEvent();
                                if (tipo_consultor.equals("Escuela")) {
                                    processLlamadaDeAgente(ae);
                                } else {
                                    if (tipo_consultor.equals("Agente")) {
                                        processLlamadaDeAgente(ae);
                                    } else {
                                        processLlamadaDeAlumno(ae);
                                    }
                                }
                            }

                        }
                    }
                }
            }
        });
        this.tableConsultaFinalizado.setItems(this.getConsultaFinalizada(this.IdAlumnoNMOYS));
    }

    public void processGuardarConsulta(ActionEvent event) throws SQLException {
        if (this.textIdConsultor.getText().equals("")) {
            // debe seleccionar un tema
            String mensaje = "Debe seleccionar el origen de la llamada antes de guardar";
            MessageBox.show(null, mensaje, "Mensaje", MessageBox.ICON_WARNING | MessageBox.OK);
        } else {
            String tema = this.selectTemaLlamado.getSelectionModel().getSelectedItem().toString();
            if (tema.equals("Seleccione el Tema")) {
                // debe seleccionar un tema
                String mensaje = "Debe seleccionar un Tema antes de guardar";
                MessageBox.show(null, mensaje, "Mensaje", MessageBox.ICON_WARNING | MessageBox.OK);
            } else {
                // guardar consulta en la base
                NPMoysConnect conn = new NPMoysConnect();
                int idTema = this.listadoTemas.searchTema(tema);
                boolean ok = conn.setNuevaConsulta(this.textIdConsultor.getText(), this.asterisk.getIdLlamada(), listadoTemas.getIdTema(idTema), this.textObservacionLlamado.getText(), this.selectEstadoLlamado.getSelectionModel().getSelectedItem().toString(), application.getLoggedUser().getUser());
                if (ok) {
                    this.textObservacionLlamado.setText("");
                    tableConsultaEnCurso.setItems(getConsultasEnCurso(textIdConsultor.getText()));
                    tableConsultaFinalizado.setItems(getConsultaFinalizada(textIdConsultor.getText()));
                }
            }
        }
    }

    public ObservableList<TableConsultaEnCurso> getConsultasEnCurso(String id_consultor) {
        ConsultaEnCurso consulta;
        NPMoysConnect conn = new NPMoysConnect();
        ObservableList<TableConsultaEnCurso> listConsulta = FXCollections.observableArrayList();
        try {
            consulta = conn.getConsultaEnCurso(id_consultor);
            for (int i = 0; i < consulta.getSize(); i++) {
                listConsulta.add(new TableConsultaEnCurso(consulta.getTema(i), consulta.getObservaciones(i), consulta.getFeAlta(i), consulta.getOperador(i), consulta.getIdConsulta(i)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
            listConsulta.add(new TableConsultaEnCurso("Error al conectar con NPMoys", "", "", "", ""));
        }
        return listConsulta;
    }

    public ObservableList<TableConsultaFinalizada> getConsultaFinalizada(String id_consultor) {
        ConsultaFinalizada consulta;
        NPMoysConnect conn = new NPMoysConnect();
        ObservableList<TableConsultaFinalizada> listConsulta = FXCollections.observableArrayList();
        try {
            consulta = conn.getConsultaFinalizada(id_consultor);
            for (int i = 0; i < consulta.getSize(); i++) {
                listConsulta.add(new TableConsultaFinalizada(consulta.getIdConsulta(i), consulta.getTema(i), consulta.getObservaciones(i), consulta.getFeBaja(i), consulta.getOperador(i), consulta.getFinalizadoPor(i)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
            listConsulta.add(new TableConsultaFinalizada("Error al conectar con NPMoys", ex.getMessage(), "", "", "", ""));
        }
        return listConsulta;
    }

    // **********************************
    // **  Fin TAB Llamdas  *************
    // **********************************
    // handler buscar escuela
    private EventHandler<KeyEvent> handleEsc() {
        return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    System.out.println("Presiono Enter!");
                    ActionEvent ae = new ActionEvent();
                    try {
                        processBuscar(ae);
                    } catch (SQLException ex) {
                        Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
                        String mensaje = "Se produjo un error al intentar conectar con la base de datos NMOYS, intentelo nuevamente...";
                        MessageBox.show(null, mensaje, "Mensaje", MessageBox.ICON_ERROR | MessageBox.OK);
                    }
                }
            }
        };
    }

    // cargar temas
    private Tema loadTemas() throws SQLException {
        NPMoysConnect conn = new NPMoysConnect();
        Tema dbTema = conn.getTemas();
        return dbTema;
    }

    // setear codigo jurisdiccional desde el Thread
    public void setCodJuris(String codigoJurisdiccional) {
        this.textCodJuris.setText(codigoJurisdiccional);
    }

    // setear selecIndex de Escuelas
    public void resetEscuelaSelectIndex() {
        this.selectIndex = 0;
    }

    // setear numero de documento del alumno desde el Thread
    public void setAlumnoNroDoc(String NroDocumento) {
        this.textNroDocumentoAlumno.setText(NroDocumento);
    }

    // setear numero de documento del agente desde el Thread
    public void setAgenteNroDoc(String NroDocumento) {
        this.textNroDocumentoAgente.setText(NroDocumento);
    }
    
    // habilitar o deshabilitar la escucha de llamados entrantes
    public void proccesChangePhoneState(){
        if(this.PhoneState){
            this.imgTelOnOff.setImage(this.telOffline);
            this.PhoneState = false;
            asterisk.Finalizar();
            eventos = null;
        } else {
            this.imgTelOnOff.setImage(this.telOnline);
            this.PhoneState = true;
            eventos = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        asterisk = new AsteriskClass(pantalla, hpc, application.getLoggedUser());
                        asterisk.run();
                    } catch (IOException | AuthenticationFailedException | TimeoutException ex) {
                        Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            eventos.start();
        }
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.telOffline = new Image("file:.\\img\\button_offline.png");
        this.telOnline = new Image("file:.\\img\\button_online.png");
        this.imgTelOnOff.setImage(telOffline);
        this.PhoneState = false;
        // **********************************
        // **  TAB Establecimientos  ********
        // **********************************
        // inicializamos el combo
        ObservableList<String> options;
        options = FXCollections.observableArrayList(
                "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "");
        selectRegional.setItems(options);
        selectRegional.getSelectionModel().selectLast();
        // fin inicialización del combo
        // inicializamos la lista de resultados
        listResultados.setItems(null);
        // fin lista de resultados
        textNroOrg.setText("");
        textNroOrg.addEventHandler(KeyEvent.KEY_PRESSED, this.handleEsc());
        textCodJuris.setText("");
        textCodJuris.addEventHandler(KeyEvent.KEY_PRESSED, this.handleEsc());
        textNombre.setText("");
        textNombre.addEventHandler(KeyEvent.KEY_PRESSED, this.handleEsc());
        textCUE.setText("");
        textCUE.addEventHandler(KeyEvent.KEY_PRESSED, this.handleEsc());
        textAnexo.setText("");
        textAnexo.addEventHandler(KeyEvent.KEY_PRESSED, this.handleEsc());
        textLocalidad.setText("");
        textLocalidad.addEventHandler(KeyEvent.KEY_PRESSED, this.handleEsc());
        this.nroOrganismoCargado = -1;
        this.selectIndex = -1;
        this.OpenTabs = new ArrayList<>();
        listadoEscuelas = new ArrayList<>();
        this.labelTipoOrganismo.setText("");
        this.labelGestion.setText("");
        this.labelTelefono.setText("");
        this.labelCentrex.setText("");
        this.labelDomicilio.setText("");
        this.labelDepartamento.setText("");
        this.labelNodo.setText("");
        this.labelEmail.setText("");
        this.labelTieneSigae.setText("");
        this.labelActivo.setText("");
        this.labelFechaActuVista.setText("");
        this.labelCargoEstCurricular.setText("");
        this.labelCargosFrenteAula.setText("");
        this.labelPlazas.setText("");
        // inicialización tabla director y supervisores
        this.tableDirectorSupervisor.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.columnCargo.setCellValueFactory(new PropertyValueFactory<TableDireSuper, String>("Cargo"));
        this.columnDocumento.setCellValueFactory(new PropertyValueFactory<TableDireSuper, String>("Documento"));
        this.columnNombreApellido.setCellValueFactory(new PropertyValueFactory<TableDireSuper, String>("NombreApellido"));
        this.columnSitRevista.setCellValueFactory(new PropertyValueFactory<TableDireSuper, String>("SitRevista"));
        this.tableDirectorSupervisor.setItems(null);
        // fin inicialización tabla director y supervisores
        // inicialización tabla tickets
        this.tableTickets.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.columnIdTicket.setCellValueFactory(new PropertyValueFactory<TableTickets, String>("IdTicket"));
        this.columnTema.setCellValueFactory(new PropertyValueFactory<TableTickets, String>("Tema"));
        this.columnSubtema.setCellValueFactory(new PropertyValueFactory<TableTickets, String>("Subtema"));
        this.columnConsulta.setCellValueFactory(new PropertyValueFactory<TableTickets, String>("Consulta"));
        this.columnFechaCreacion.setCellValueFactory(new PropertyValueFactory<TableTickets, String>("FechaCreacion"));
        this.columnFechaActualizacion.setCellValueFactory(new PropertyValueFactory<TableTickets, String>("FechaActualizacion"));
        this.tableTickets.setItems(null);
        // fin inicialización tabla tickets
        // inicialización datos de SARH
        this.labelUsuarioVPN.setText("");
        // inicialización tabla tickets
        this.tableUserSARH.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.columnUsuario.setCellValueFactory(new PropertyValueFactory<TableUsuarioSARH, String>("Usuario"));
        this.columnNombreApellidoSARH.setCellValueFactory(new PropertyValueFactory<TableUsuarioSARH, String>("NombreApellido"));
        this.columnDocumentoSARH.setCellValueFactory(new PropertyValueFactory<TableUsuarioSARH, String>("Documento"));
        this.columnFechaAlta.setCellValueFactory(new PropertyValueFactory<TableUsuarioSARH, String>("FechaAlta"));
        this.columnFechaBaja.setCellValueFactory(new PropertyValueFactory<TableUsuarioSARH, String>("FechaBaja"));
        this.tableUserSARH.setItems(null);
        // fin inicialización datos de SARH
        // inicialización becas
        int anio = java.util.GregorianCalendar.getInstance().get(Calendar.YEAR);
        this.labelSolicitadas1.setText("Solicitadas " + (anio - 2) + ":");
        this.labelSolicitadas2.setText("Solicitadas " + (anio - 1) + ":");
        this.labelOtorgadas.setText("Otorgadas " + (anio) + ":");
        this.labelSolicitadasValor1.setText("");
        this.labelSolicitadasValor2.setText("");
        this.labelOtorgadasValor.setText("");
        // fin inicialización becas
        // inicialización datos de Medio Boleto
        this.labelMBSolPendientes.setText("");
        this.labelMBSolOtorgadas.setText("");
        // inicialización tabla medio boleto
        this.tableMB.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.columnMBAlumno.setCellValueFactory(new PropertyValueFactory<TableMedioBoleto, String>("MBAlumno"));
        this.columnMBDocumento.setCellValueFactory(new PropertyValueFactory<TableMedioBoleto, String>("MBDocumento"));
        this.columnMBEstado.setCellValueFactory(new PropertyValueFactory<TableMedioBoleto, String>("MBEstado"));
        this.columnMBMensaje.setCellValueFactory(new PropertyValueFactory<TableMedioBoleto, String>("MBMensaje"));
        this.columnMBObservacion.setCellValueFactory(new PropertyValueFactory<TableMedioBoleto, String>("MBObservacion"));
        this.tableMB.setItems(null);
        // fin inicialización tabla medio boleto
        // fin inicialización datos de Medio Boleto
        // inicialización datos de Comedor
        this.labelEstAsistente.setText("");
        this.labelEstBeneficiado.setText("");
        // inicialización tabla comedor
        this.tableComedor.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.columnConcepto.setCellValueFactory(new PropertyValueFactory<TableComedor, String>("Concepto"));
        this.columnDesayuno.setCellValueFactory(new PropertyValueFactory<TableComedor, String>("Desayuno"));
        this.columnAlmuerzo.setCellValueFactory(new PropertyValueFactory<TableComedor, String>("Almuerzo"));
        this.columnMerienda.setCellValueFactory(new PropertyValueFactory<TableComedor, String>("Merienda"));
        this.columnCena.setCellValueFactory(new PropertyValueFactory<TableComedor, String>("Cena"));
        this.tableComedor.setItems(null);
        // fin inicialización tabla comedor
        // fin inicialización datos de comedor
        // inicialización datos de matrícula
        // inicialización tabla activos en ciclos anteriores
        this.tableMACA.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.columnMACACicloLectivo.setCellValueFactory(new PropertyValueFactory<TableActivaCiclosAnt, String>("MACACicloLectivo"));
        this.columnMACACarrera.setCellValueFactory(new PropertyValueFactory<TableActivaCiclosAnt, String>("MACACarrera"));
        this.columnMACAAnioEstudio.setCellValueFactory(new PropertyValueFactory<TableActivaCiclosAnt, String>("MACAAnioEstudio"));
        this.columnMACASeccion.setCellValueFactory(new PropertyValueFactory<TableActivaCiclosAnt, String>("MACASeccion"));
        this.columnMACAAlumno.setCellValueFactory(new PropertyValueFactory<TableActivaCiclosAnt, String>("MACAAlumno"));
        this.columnMACADocumento.setCellValueFactory(new PropertyValueFactory<TableActivaCiclosAnt, String>("MACADocumento"));
        this.columnMACASexo.setCellValueFactory(new PropertyValueFactory<TableActivaCiclosAnt, String>("MACASexo"));
        this.tableMACA.setItems(null);
        // fin inicialización tabla activos en ciclos anteriores

        // inicialización tabla historico de matricula
        this.tableHM.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.columnHMCicloLectivo.setCellValueFactory(new PropertyValueFactory<TableHistoricoMatricula, String>("HMCicloLectivo"));
        this.columnHMSeccion.setCellValueFactory(new PropertyValueFactory<TableHistoricoMatricula, String>("HMSeccion"));
        this.columnHMAlumno.setCellValueFactory(new PropertyValueFactory<TableHistoricoMatricula, String>("HMAlumno"));
        this.columnHMMatricula.setCellValueFactory(new PropertyValueFactory<TableHistoricoMatricula, String>("HMMatricula"));
        this.tableHM.setItems(null);
        // fin inicialización tabla historico de matricula
        // inicializacion tabla matricula actual por carrera
        this.tableMAPC.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.columnMAPCCicloLectivo.setCellValueFactory(new PropertyValueFactory<TableActualPorCarrera, String>("MAPCCicloLectivo"));
        this.columnMAPCNivel.setCellValueFactory(new PropertyValueFactory<TableActualPorCarrera, String>("MAPCNivel"));
        this.columnMAPCCarrera.setCellValueFactory(new PropertyValueFactory<TableActualPorCarrera, String>("MAPCCarrera"));
        this.columnMAPCSeccion.setCellValueFactory(new PropertyValueFactory<TableActualPorCarrera, String>("MAPCSeccion"));
        this.columnMAPCAlumno.setCellValueFactory(new PropertyValueFactory<TableActualPorCarrera, String>("MAPCAlumno"));
        this.columnMAPCMatricula.setCellValueFactory(new PropertyValueFactory<TableActualPorCarrera, String>("MAPCMatricula"));
        this.tableMAPC.setItems(null);
        // fin inicializacion tabla matricula actual por carrera
        // fin inicialización datos de matrícula
        // inicialización datos de títulos
        this.labelDirectorAutorizado.setText("");
        this.labelCodigoAutorizacion.setText("");
        this.labelPIN.setText("");
        this.labelCantActivos5y6CiclosAnt.setText("");
        this.labelTituloCantTitulosImp1.setText("Cantidad de Títulos Impresos en");
        this.labelTituloCantTitulosImp2.setText("Cantidad de Títulos Impresos en");
        this.labelCantTitulosImp1.setText("");
        this.labelCantTitulosImp2.setText("");
        // fin inicialización datos de títulos
        // inicialización datos de conectividad
        this.labelPCResolucion.setText("");
        this.labelPCFechaAprobacion.setText("");
        this.labelPCObservacion.setText("");
        this.labelTieneInternet.setText("");
        this.labelFechaAltaInternet.setText("");
        this.labelTipoEnlace.setText("");
        this.labelAnchoBanda.setText("");
        this.labelAbonoInternet.setText("");
        this.labelTelefonoInternet.setText("");
        this.labelFuncSitAdversas.setText("");
        this.labelProveedor.setText("");
        this.labelObsInternet.setText("");
        // inicialización tabla gastos de funcionamiento
        this.tableConectividad.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.columnGastosAnio.setCellValueFactory(new PropertyValueFactory<TableConectividad, String>("Anio"));
        this.columnGastosMes.setCellValueFactory(new PropertyValueFactory<TableConectividad, String>("Mes"));
        this.columnGastosDetalle.setCellValueFactory(new PropertyValueFactory<TableConectividad, String>("Detalle"));
        this.columnGastosImporte.setCellValueFactory(new PropertyValueFactory<TableConectividad, String>("Importe"));
        this.tableConectividad.setItems(null);
        // fin inicialización tabla gastos de funcionamiento
        // fin inicialización datos de conectividad
        // inicializacion REDFIE
        this.tableREDFIE.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.columnDescripcion.setCellValueFactory(new PropertyValueFactory<TableREDFIE, String>("Descripcion"));
        this.columnObservacion.setCellValueFactory(new PropertyValueFactory<TableREDFIE, String>("Observacion"));
        this.tableREDFIE.setItems(null);
        // fin inicialización REDFIE
        // tab pane general de la pestaña escuela
        // agregamos un listener para ver que pestaña selecciono
        // final FXMLLoader fXMLLoader = new FXMLLoader();
        this.tabActual = "Tickets en Curso";
        tabPaneEscuela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            @Override
            public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
                tabActual = newValue.getText();
                try {
                    if (!OpenTabs.contains(newValue.getText())) {
                        OpenTabs.add(newValue.getText());
                        processLoadPaneEscuela(selectIndex);
                        System.out.println(newValue.getText());
                        // System.out.println(selectIndex);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
                    String mensaje = "Se produjo un error al intentar conectarse con las bases de datos del ME, intentelo nuevamente...";
                    MessageBox.show(null, mensaje, "Mensaje", MessageBox.ICON_ERROR | MessageBox.OK);
                }
            }
        });
        // **********************************
        // **  Fin TAB Establecimientos  ****
        // **********************************
        // **********************************
        // **  TAB Agentes  *****************
        // **********************************
        // inicializamos el list view
        listAgentes.setItems(null);
        // fin lista de resultados
        textNroDocumentoAgente.setText("");
        textNroDocumentoAgente.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    System.out.println("Presiono Enter!");
                    ActionEvent ae = new ActionEvent();
                    try {
                        processBuscarAgente(ae);
                    } catch (IOException ex) {
                        Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
                        String mensaje = "Se produjo un error al intentar conectarse con las bases de datos del ME, intentelo nuevamente...";
                        MessageBox.show(null, mensaje, "Mensaje", MessageBox.ICON_ERROR | MessageBox.OK);
                    }
                }
            }
        ;
        });
        IdAgenteCargado = "";
        IdAgenteNMOYS = "";
        // inicialización datos personales
        labelAgenteDocumento.setText("");
        labelAgenteApeNom.setText("");
        labelAgenteSexo.setText("");
        labelAgenteFeNac.setText("");
        labelAgenteProvincia.setText("");
        labelAgenteLocalidad.setText("");
        labelAgenteDomicilio.setText("");
        labelAgenteCodPostal.setText("");
        labelAgenteTelefono.setText("");
        labelAgenteCelular.setText("");
        labelAgenteEmail.setText("");
        labelAgenteContactoAlt.setText("");
        labelAgenteFeActu.setText("");
        // fin inicialización datos personales
        // inicialización tabla titulos registrados
        this.tableTitulosRegistradosAgente.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.columnEstablecimientoAgente.setCellValueFactory(new PropertyValueFactory<TableTitulosRegistradosAgente, String>("Establecimiento"));
        this.columnPlanAgente.setCellValueFactory(new PropertyValueFactory<TableTitulosRegistradosAgente, String>("Plan"));
        this.columnTituloAgente.setCellValueFactory(new PropertyValueFactory<TableTitulosRegistradosAgente, String>("Titulo"));
        this.columnRegistroAgente.setCellValueFactory(new PropertyValueFactory<TableTitulosRegistradosAgente, String>("Registro"));
        this.columnDiplomaAgente.setCellValueFactory(new PropertyValueFactory<TableTitulosRegistradosAgente, String>("Diploma"));
        this.tableTitulosRegistradosAgente.setItems(null);
        // inicialización tabla titulos registrados
        // inicialización tabla cargos
        this.tableCargosAgente.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.columnEstablecimientoCargo.setCellValueFactory(new PropertyValueFactory<TableCargosAgente, String>("Establecimiento"));
        this.columnTareaCargo.setCellValueFactory(new PropertyValueFactory<TableCargosAgente, String>("Tarea"));
        this.columnIdCargo.setCellValueFactory(new PropertyValueFactory<TableCargosAgente, String>("IdCargo"));
        this.columnSitRevistaCargo.setCellValueFactory(new PropertyValueFactory<TableCargosAgente, String>("SitRevista"));
        this.columnFeTomaPosecionCargo.setCellValueFactory(new PropertyValueFactory<TableCargosAgente, String>("FeTomaPosecion"));
        this.columnFeCeseCargo.setCellValueFactory(new PropertyValueFactory<TableCargosAgente, String>("FeCese"));
        this.tableCargosAgente.setItems(null);
        // inicialización tabla cargos
        // inicialización tabla horas catedra
        this.tableHorasCatAgente.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.columnEstablecimientoHoras.setCellValueFactory(new PropertyValueFactory<TableHorasCatAgente, String>("Establecimiento"));
        this.columnTerminalidadHoras.setCellValueFactory(new PropertyValueFactory<TableHorasCatAgente, String>("Terminalidad"));
        this.columnCurDivTurHoras.setCellValueFactory(new PropertyValueFactory<TableHorasCatAgente, String>("CurDivTur"));
        this.columnMateriaHoras.setCellValueFactory(new PropertyValueFactory<TableHorasCatAgente, String>("Materia"));
        this.columnHoras.setCellValueFactory(new PropertyValueFactory<TableHorasCatAgente, String>("Horas"));
        this.columnIdCargoHoras.setCellValueFactory(new PropertyValueFactory<TableHorasCatAgente, String>("IdCargo"));
        this.columnSitRevistaHoras.setCellValueFactory(new PropertyValueFactory<TableHorasCatAgente, String>("SitRevista"));
        this.columnFeTomaPosecionHoras.setCellValueFactory(new PropertyValueFactory<TableHorasCatAgente, String>("FeTomaPosecion"));
        this.columnFeCeseHoras.setCellValueFactory(new PropertyValueFactory<TableHorasCatAgente, String>("FeCese"));
        this.tableHorasCatAgente.setItems(null);
        // inicialización tabla horas catedra
        // **********************************
        // **  Fin TAB Agentes  *************
        // **********************************
        // **********************************
        // **  TAB Alumnos  *****************
        // **********************************
        // inicializamos el list view
        listAlumnos.setItems(null);
        // fin lista de resultados
        textNroDocumentoAlumno.setText("");
        textNroDocumentoAlumno.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    System.out.println("Presiono Enter!");
                    ActionEvent ae = new ActionEvent();
                    try {
                        processBuscarAlumno(ae);
                    } catch (IOException ex) {
                        Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
                        String mensaje = "Se produjo un error al intentar conectarse con las bases de datos del ME, intentelo nuevamente...";
                        MessageBox.show(null, mensaje, "Mensaje", MessageBox.ICON_ERROR | MessageBox.OK);
                    }
                }
            }
        ;
        });
        IdAlumnoCargado = "";
        SexoAlumnoCargado = "";
        DocumentoAlumnoCargado = "";
        IdAlumnoNMOYS = "";
        // inicialización datos personales
        labelAlumnoDocumento.setText("");
        labelAlumnoApeNom.setText("");
        labelAlumnoSexo.setText("");
        labelAlumnoFeNac.setText("");
        labelAlumnoNacionalidad.setText("");
        labelAlumnoDepartamento.setText("");
        labelAlumnoLocalidad.setText("");
        labelAlumnoCodPostal.setText("");
        labelAlumnoDomicilio.setText("");
        labelAlumnoTelefono.setText("");
        labelAlumnoEmail.setText("");
        // fin inicialización datos personales
        // inicialización tabla trayectoria
        this.tableTrayectoria.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.columnCodJurisdiccional.setCellValueFactory(new PropertyValueFactory<TableTrayectoria, String>("CodJurisdiccional"));
        this.columnNroOrganismoCarrera.setCellValueFactory(new PropertyValueFactory<TableTrayectoria, String>("NroOrganismoCarrera"));
        this.columnNroOrganismoSeccion.setCellValueFactory(new PropertyValueFactory<TableTrayectoria, String>("NroOrganismoSeccion"));
        this.columnIdCarrera.setCellValueFactory(new PropertyValueFactory<TableTrayectoria, String>("IdCarrera"));
        this.columnIdSeccion.setCellValueFactory(new PropertyValueFactory<TableTrayectoria, String>("IdSeccion"));
        this.columnIdSeccionPrevia.setCellValueFactory(new PropertyValueFactory<TableTrayectoria, String>("IdSeccionPrevia"));
        this.columnCicloLectivo.setCellValueFactory(new PropertyValueFactory<TableTrayectoria, String>("CicloLectivo"));
        this.columnSeccion.setCellValueFactory(new PropertyValueFactory<TableTrayectoria, String>("Seccion"));
        this.columnFecInscripCarrera.setCellValueFactory(new PropertyValueFactory<TableTrayectoria, String>("FecInscripCarrera"));
        this.columnFecInscripSeccion.setCellValueFactory(new PropertyValueFactory<TableTrayectoria, String>("FecInscripSeccion"));
        this.columnFecBajaSeccion.setCellValueFactory(new PropertyValueFactory<TableTrayectoria, String>("FecBajaSeccion"));
        this.columnMovEntrada.setCellValueFactory(new PropertyValueFactory<TableTrayectoria, String>("MovEntrada"));
        this.columnMovUltimo.setCellValueFactory(new PropertyValueFactory<TableTrayectoria, String>("MovUltimo"));
        this.columnFecBajaCarrera.setCellValueFactory(new PropertyValueFactory<TableTrayectoria, String>("FecBajaCarrera"));
        this.columnFecSalida.setCellValueFactory(new PropertyValueFactory<TableTrayectoria, String>("FecSalida"));
        this.tableTrayectoria.setItems(null);
        // inicialización tabla trayectoria
        // inicialización tabla titulos registrados
        this.tableTitulosRegistrados.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.columnEstablecimiento.setCellValueFactory(new PropertyValueFactory<TableTitulosRegistrados, String>("Establecimiento"));
        this.columnPlan.setCellValueFactory(new PropertyValueFactory<TableTitulosRegistrados, String>("Plan"));
        this.columnTitulo.setCellValueFactory(new PropertyValueFactory<TableTitulosRegistrados, String>("Titulo"));
        this.columnValidezNacional.setCellValueFactory(new PropertyValueFactory<TableTitulosRegistrados, String>("ValidezNacional"));
        this.columnTipoSolicitud.setCellValueFactory(new PropertyValueFactory<TableTitulosRegistrados, String>("TipoSolicitud"));
        this.columnEstadoSolicitud.setCellValueFactory(new PropertyValueFactory<TableTitulosRegistrados, String>("EstadoSolicitud"));
        this.columnFechaSolicitud.setCellValueFactory(new PropertyValueFactory<TableTitulosRegistrados, String>("FechaSolicitud"));
        this.columnFechaSolicitudReal.setCellValueFactory(new PropertyValueFactory<TableTitulosRegistrados, String>("FechaSolicitudReal"));
        this.tableTitulosRegistrados.setItems(null);
        // inicialización tabla titulos registrados
        // inicialización tabla titulos rechazados
        this.tableTitulosRechazados.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.columnEstablecimientoRechazado.setCellValueFactory(new PropertyValueFactory<TableTitulosRechazados, String>("Establecimiento"));
        this.columnPlanRechazado.setCellValueFactory(new PropertyValueFactory<TableTitulosRechazados, String>("Plan"));
        this.columnTituloImprimirRechazado.setCellValueFactory(new PropertyValueFactory<TableTitulosRechazados, String>("TituloImprimir"));
        this.columnValidezNacionalRechazado.setCellValueFactory(new PropertyValueFactory<TableTitulosRechazados, String>("ValidezNacional"));
        this.columnEstadoSolicitudRechazado.setCellValueFactory(new PropertyValueFactory<TableTitulosRechazados, String>("EstadoSolicitud"));
        this.columnFechaSolicitudRechazado.setCellValueFactory(new PropertyValueFactory<TableTitulosRechazados, String>("FechaSolicitud"));
        this.columnFechaSolicitudRealRechazado.setCellValueFactory(new PropertyValueFactory<TableTitulosRechazados, String>("FechaSolicitudReal"));
        this.columnFechaRechazo.setCellValueFactory(new PropertyValueFactory<TableTitulosRechazados, String>("FechaRechazo"));
        this.columnMotivoRechazo.setCellValueFactory(new PropertyValueFactory<TableTitulosRechazados, String>("MotivoRechazo"));
        this.tableTitulosRechazados.setItems(null);
        // inicialización tabla titulos rechazados
        // **********************************
        // **  Fin TAB Alumnos  *************
        // **********************************
        // **********************************
        // **  TAB Llamados  ****************
        // **********************************
        tipo_consultor = "";
        index_consulta_seleccionada = -1;
        id_consulta_seleccionada = "";
        textIdConsultor.setText("");
        textIdConsultor.disableProperty().set(true);
        // inicializamos el combo estado
        ObservableList<String> options2;
        options2 = FXCollections.observableArrayList(
                "En curso", "Finalizado");
        selectEstadoLlamado.setItems(options2);
        selectEstadoLlamado.getSelectionModel().selectLast();
        // fin inicialización del combo
        // cargamos la lista de temas        
        try {
            listadoTemas = loadTemas();
        } catch (SQLException ex) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
            String mensaje = "Se produjo un error al intentar conectar con la base de datos NMOYS, intentelo nuevamente...";
            MessageBox.show(null, mensaje, "Mensaje", MessageBox.ICON_ERROR | MessageBox.OK);
        }
        // inicializamos el combo temas
        ObservableList<String> options3;
        options3 = FXCollections.observableArrayList();
        for (int i = 0; i < listadoTemas.getSize(); i++) {
            options3.add(listadoTemas.getTema(i));
        }
        options3.add("Seleccione el Tema");
        selectTemaLlamado.setItems(options3);
        selectTemaLlamado.getSelectionModel().selectLast();
        // fin inicialización del combo
        textObservacionLlamado.setText("");
        // tabla de consultas en curso
        this.tableConsultaEnCurso.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.columnIdConsultaCurso.setCellValueFactory(new PropertyValueFactory<TableConsultaEnCurso, String>("IdConsulta"));
        this.columnTemaEnCurso.setCellValueFactory(new PropertyValueFactory<TableConsultaEnCurso, String>("Tema"));
        this.columnObservacionEnCurso.setCellValueFactory(new PropertyValueFactory<TableConsultaEnCurso, String>("Observacion"));
        this.columnFeAltaEnCurso.setCellValueFactory(new PropertyValueFactory<TableConsultaEnCurso, String>("FeAlta"));
        this.columnOperadorEnCurso.setCellValueFactory(new PropertyValueFactory<TableConsultaEnCurso, String>("Operador"));
        this.tableConsultaEnCurso.setItems(null);
        // fin tabla de consultas en curso
        // tabla de consultas finalizadas
        this.tableConsultaFinalizado.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);;
        this.columnIdConsultaFinalizado.setCellValueFactory(new PropertyValueFactory<TableConsultaFinalizada, String>("IdConsulta"));
        this.columnTemaFinalizado.setCellValueFactory(new PropertyValueFactory<TableConsultaFinalizada, String>("Tema"));
        this.columnObservacionFinalizado.setCellValueFactory(new PropertyValueFactory<TableConsultaFinalizada, String>("Observacion"));
        this.columnFeBajaFinalizado.setCellValueFactory(new PropertyValueFactory<TableConsultaFinalizada, String>("FeBaja"));
        this.columnOperadorFinalizado.setCellValueFactory(new PropertyValueFactory<TableConsultaFinalizada, String>("Operador"));
        this.columnFinalizadoPorFinalizado.setCellValueFactory(new PropertyValueFactory<TableConsultaFinalizada, String>("FinalizadoPor"));
        this.tableConsultaFinalizado.setItems(null);
        // fin tabla de consultas finalizados
        // **********************************
        // **  Fin TAB Llamados  ************
        // **********************************
        // final boolean continuar = true;
        // apunta a home page controller
        // lo hago para poder mostrar mensajes desde el Thread
        hpc = this;
    }
}
