/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moysapplication.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import jfx.messagebox.MessageBox;
import moysapplication.model.ConsultaEnCurso;
import moysapplication.model.ConsultaFinalizada;
import moysapplication.model.User;
import moysapplication.model.Escuela;
import moysapplication.model.Llamada;
import moysapplication.model.Tema;

/**
 *
 * @author Andrés Gilli <agilli@santafe.gov.ar>
 */
public class NPMoysConnect {
   
    // conexion mysql
    private final mySqlConnect auxConnect;
    
    public NPMoysConnect() {
        // auxConnect = new mySqlConnect("jdbc:mysql://localhost:3306/", "base_sgnp", "root", "");
        auxConnect = new mySqlConnect("jdbc:mysql://srvjabber.educ.sfnet:3306/", "normas_moys", "normas_moys", "moys4798");
    }
    
    private Connection getConnect(){
        this.auxConnect.beginConnect();        
        return this.auxConnect.getConnect();
    }
    
    private void Close(){
        this.auxConnect.Close();
    }
    
    /*
     * Acceso a datos
     */
    
    public Boolean uniqueUser(String UserId) throws SQLException{
         // abre la conexion con la base de datos
        Connection connect = this.getConnect();
        int coincidencias;
        try (Statement stmt = connect.createStatement()) {
            String auxUser = "'" + UserId + "'";
            String sql = "SELECT Count(*) FROM Usuario WHERE Nick="+auxUser+"";
            try (ResultSet rs = stmt.executeQuery(sql)) {
                rs.next();
                coincidencias = rs.getInt(1);
            }
        }
        this.Close();
        if(coincidencias == 1){
            System.out.println("Usuario encontrado!");
            return true;
        } else {
            System.out.println("El usuario no existe o se encuentra duplicado!");
            return false;
        }
     }
    
     public User getUser(String UserId) throws SQLException{
        User user;
        if(uniqueUser(UserId)){
            // abre la conexion con la base de datos
            Connection connect = this.getConnect();
            try (Statement stmt = connect.createStatement()) {
                String auxUser = "'" + UserId + "'";
                // consulto los datos para validar contraseña
                String sql = "SELECT U.Nick,U.Password,U.IdTipoUsuario,A.Agente FROM Usuario U, AgenteAsterisk A WHERE U.Nick="+auxUser+""+" AND A.Nick="+auxUser+"";                // String sql = "SELECT Nick,Password,IdTipoUsuario FROM Usuario WHERE Nick="+auxUser+"";
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    rs.next();
                    user = new User(UserId,  rs.getInt(3), rs.getString(2), rs.getString(4));
                    System.out.println(rs.getString(3));
                }
            }
            this.Close();
        } else {
            user = new User("",  -1, "", "");
        } 
        return user;
     }
     
     public Escuela buscarEscuela(int NroOrg) throws SQLException{
        Escuela esc;
        // abre la conexion con la base de datos
        Connection connect = this.getConnect();
        try (Statement stmt = connect.createStatement()) {
            // consulto los datos para validar contraseña
            String sql = "SELECT * FROM organismo WHERE nro_organismo='"+NroOrg+"';";
            try (ResultSet rs = stmt.executeQuery(sql)) {
                boolean existeProximo = rs.next();
                if(existeProximo){
                    esc = new Escuela(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
                } else {
                    esc = new Escuela();
                }
            } 
        }
        this.Close();
        return esc;
     }
     
     public ArrayList<Escuela> buscarEscuela(String cod_juris, String nombre, String region, String localidad, String cue, int anexo) throws SQLException{
        ArrayList<Escuela> listEsc = new ArrayList<>();
        // abre la conexion con la base de datos
        Connection connect = this.getConnect();
        try (Statement stmt = connect.createStatement()) {
            // consulto los datos para validar contraseña
            boolean primero = true;
            String sql = "SELECT * FROM organismo WHERE ";
            if(! cod_juris.equals("")) {
                sql += "cod_juris LIKE '%"+cod_juris+"%'";
                primero = false;
            }
            if(! nombre.equals("")) {
                if(primero) {
                    sql += "nombre LIKE '%"+nombre+"%'";
                    primero = false;
                }
                else sql += " AND nombre LIKE '%"+nombre+"%'";
            }
            if(! region.equals("")) {
                if(primero) {
                    sql += "region LIKE '"+region+"'";
                    primero = false;
                }
                else sql += " AND region LIKE '"+region+"'";
            }
            if(! localidad.equals("")) {
                if(primero) {
                    sql += "localidad LIKE '%"+localidad+"%'";
                    primero = false;
                }
                else sql += " AND localidad LIKE '%"+localidad+"%'";
            }
            if(! cue.equals("")) {
                if(primero) {
                    sql += "CUE LIKE '"+cue+"'";
                    primero = false;
                }
                else sql += " AND CUE LIKE '"+cue+"'";
            }
            if(anexo != -1) {
                if(primero) sql += "anexo='"+anexo+"'";
                else sql += " AND anexo='"+anexo+"'";
            }
            sql += " ORDER BY cod_juris;";
            System.out.println(sql);
            try (ResultSet rs = stmt.executeQuery(sql)) {
                while(rs.next()){
                    listEsc.add(new Escuela(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7)));                   
                } 
                if(listEsc.isEmpty()) listEsc.add(new Escuela());
            } 
        }
        this.Close();
        return listEsc;
     }
     
     // **********************************
     // ***********  Llamadas  ************
     // **********************************
     
     public Tema getTemas() throws SQLException{
        Tema dbTema = new Tema();
        // abre la conexion con la base de datos
        Connection connect = this.getConnect();
        try (Statement stmt = connect.createStatement()) {
            // consulto los datos de la tabla TemaMoysApp
                String sql = "SELECT * FROM TemaMoysApp";
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    while(rs.next()){
                        dbTema.setTema(rs.getInt(1), rs.getString(2));
                        System.out.println();
                    }
                }
            }
            this.Close();
         
        return dbTema;
     }
    
     public ConsultaEnCurso getConsultaEnCurso(String id_consultor) throws SQLException{
        ConsultaEnCurso dbConsulta = new ConsultaEnCurso();
        // abre la conexion con la base de datos
        Connection connect = this.getConnect();
        try (Statement stmt = connect.createStatement()) {
            // consulto los datos de la tabla TemaMoysApp
                String sql = "SELECT L.id_llamado,T.tema,L.observacion,L.fecha_alta,L.nick_alta FROM Llamado L, TemaMoysApp T"
                        + " WHERE id_consultor='"+id_consultor+"' AND estado='1' AND T.id_tema=L.id_tema;";
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    while(rs.next()){
                        dbConsulta.setConsulta(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                    }
                }
            }
            this.Close();
            if(dbConsulta.getSize() == 0) dbConsulta.setConsulta("No hay consultas en curso", "", "", "", "");
        return dbConsulta;
     }
     
     public ConsultaFinalizada getConsultaFinalizada(String id_consultor) throws SQLException{
        ConsultaFinalizada dbConsulta = new ConsultaFinalizada();
        // abre la conexion con la base de datos
        Connection connect = this.getConnect();
        try (Statement stmt = connect.createStatement()) {
            // consulto los datos de la tabla TemaMoysApp
                String sql = "SELECT L.id_llamado,T.tema,L.observacion,L.fecha_baja,L.nick_alta,L.nick_baja FROM Llamado L, TemaMoysApp T"
                        + " WHERE L.id_consultor='"+id_consultor+"' AND L.estado='0' AND T.id_tema=L.id_tema ORDER BY id_llamado DESC LIMIT 0,5;";
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    while(rs.next()){
                        dbConsulta.setConsulta(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                    }
                }
            }
            this.Close();
            if(dbConsulta.getSize() == 0) dbConsulta.setConsulta("No hay consultas finalizadas", "", "", "", "", "");
        return dbConsulta;
     }
     
     public boolean setNuevaConsulta(String id_consultor, String id_llamada_asterisk,int id_tema, String observacion, String estado, String nick) throws SQLException{
        boolean result = true;
        // abre la conexion con la base de datos
        Connection connect = this.getConnect();
        try (Statement stmt = connect.createStatement()) {
            int dia = java.util.GregorianCalendar.getInstance().get(Calendar.DAY_OF_MONTH);
            int mes = java.util.GregorianCalendar.getInstance().get(Calendar.MONTH);
            int anio = java.util.GregorianCalendar.getInstance().get(Calendar.YEAR);
            String hoy = dia+"/"+mes+"/"+anio;
            String sql = "";
            int nulo = java.sql.Types.NULL;
            if("Finalizado".equals(estado)){
                sql = "INSERT INTO Llamado (id_llamado,id_llamado_asterisk,estado,observacion,fecha_alta,fecha_baja,id_consultor,nick_alta,nick_baja,id_tema) "
                         + "VALUES ('"+nulo+"','"+nulo+"','0','"+observacion+"','"+hoy+"','"+hoy+"','"+id_consultor+"','"+nick+"','"+nick+"','"+id_tema+"');";
            } else {
                sql = "INSERT INTO Llamado (id_llamado,id_llamado_asterisk,estado,observacion,fecha_alta,fecha_baja,id_consultor,nick_alta,nick_baja,id_tema) "
                         + "VALUES ('"+nulo+"','"+nulo+"','1','"+observacion+"','"+hoy+"','"+nulo+"','"+id_consultor+"','"+nick+"','"+nulo+"','"+id_tema+"');";                        
            }
            try {
                // la consulta fue guardada en forma existosa
                stmt.executeUpdate(sql);
                String mensaje = "La consulta fue registrada con éxito!";
                MessageBox.show(null,mensaje,"Mensaje",MessageBox.ICON_INFORMATION| MessageBox.OK );
            } catch (SQLException e) {
                String mensaje = "Se produjo un error al intentar guardar su consulta, intentelo nuevamente..."+e.getMessage();
                MessageBox.show(null,mensaje,"Mensaje",MessageBox.ICON_WARNING| MessageBox.OK );  
                result = false;
            }     
        }
        this.Close();
        return result;
     }
     
     public boolean finalizarConsulta(int id_consulta, String observacion, String nick) throws SQLException{
         boolean result = true;
         Connection connect = this.getConnect();
         try (Statement stmt = connect.createStatement()) {
            int dia = java.util.GregorianCalendar.getInstance().get(Calendar.DAY_OF_MONTH);
            int mes = java.util.GregorianCalendar.getInstance().get(Calendar.MONTH);
            int anio = java.util.GregorianCalendar.getInstance().get(Calendar.YEAR);
            String hoy = dia+"/"+mes+"/"+anio;
            String sql = "";
            int nulo = java.sql.Types.NULL;
            sql = "UPDATE Llamado SET estado='0',observacion='"+observacion+"',fecha_baja='"+hoy+"',"
                    + "nick_baja='"+nick+"' WHERE id_llamado='"+id_consulta+"';";
            try {
                // la consulta fue guardada en forma existosa
                stmt.executeUpdate(sql);
                result = true;
            } catch (SQLException e) {
                String mensaje = "Se produjo un error al intentar finalizar la consulta, intentelo nuevamente..."+e.getMessage();
                MessageBox.show(null,mensaje,"Mensaje",MessageBox.ICON_WARNING| MessageBox.OK );
                result = false;
            }     
        }
        this.Close();
         
        return result;
     }
     
     public Llamada getLlamada(String idLlamada) throws SQLException{
        Llamada entrante;
        // abre la conexion con la base de datos
        Connection connect = this.getConnect();
        try (Statement stmt = connect.createStatement()) {
            String auxId = "'" + idLlamada + "'";
            // consulto los datos para validar contraseña
            String sql = "SELECT LA.IdOpcion,LA.IdEmisor,LA.IdTipoEmisor,OA.Opcion FROM LlamadoAsterisk LA, OpcionAsterisk OA WHERE LA.IdLlamado="+auxId+" AND LA.IdOpcion=OA.IdOpcion";
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    rs.next();
                    entrante = new Llamada(rs.getString(4), rs.getString(2), rs.getInt(3));
                }
            }
            this.Close();
        return entrante;
     }
     
     // **********************************
     // **  Fin TAB Llamdas  *************
     // **********************************
     
     /*
     * Actualizar base
     */
    
    public Boolean updateDB(ArrayList<ArrayList<String>> organismos) throws SQLException{
         // abre la conexion con la base de datos
        Boolean error = false;
        String histError = "";
        Connection connect = this.getConnect();
        int finY = organismos.size();
        for(int i=1;i<finY;i++){
            try (Statement stmt = connect.createStatement()) {
                int nro_org = Integer.parseInt(organismos.get(i).get(0));
                String cue = organismos.get(i).get(1);
                String anexo_2 = organismos.get(i).get(2);
                String codJur = organismos.get(i).get(3);
                String nombre = organismos.get(i).get(4);
                if(nombre.contains("'")) nombre = nombre.replace("'", " ");
                String region = organismos.get(i).get(5);
                String localidad = organismos.get(i).get(6);
                if(! (("".equals(anexo_2)) || ("".equals(cue)))){
                    int anexo = Integer.parseInt(anexo_2);
                    String sql = "INSERT INTO organismo (nro_organismo,nombre,CUE,anexo,cod_juris,region,localidad) ";
                    sql += "VALUES('"+nro_org+"','"+nombre+"','"+cue+"','"+anexo+"','"+codJur+"','"+region+"','"+localidad;
                    sql += "');";
                    try {
                        stmt.executeUpdate(sql);
                    } catch (SQLException e) {
                        error = true;
                        histError += e.getMessage();
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        this.Close();
        if(error){
            System.out.println("Error: "+histError);
            return false;
        } else {
            System.out.println("Actualización Completa!");
            return true;
        }
     }
    
    /*
     * Truncar tabla
     */
    
    public Boolean truncateDB() throws SQLException{
         // abre la conexion con la base de datos
        Connection connect = this.getConnect();
        boolean ok = true;
        String error = "";
        try (Statement stmt = connect.createStatement()) {
            String sql = "TRUNCATE TABLE organismo";
            try {
                stmt.executeUpdate(sql);
            } catch (SQLException e) {
                ok = false;
                error = e.getMessage();
                System.out.println(e.getMessage());
            }
        }
        this.Close();
        if(! ok){
            System.out.println("Error: "+error);
            return false;
        } else {
            System.out.println("Truncado existoso!");
            return true;
        }
     }
     
}
