/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package preguntasTest.bbdd;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import preguntasTest.clases.Opcion;
import preguntasTest.clases.Pregunta;
import preguntasTest.clases.Usuario;

/**
 *
 * @author manu1
 */
public class ConexionBD {
    static Connection conn = null;
    static ResultSet rs = null;
    static PreparedStatement stmt = null;
    static String bd = "apptests";
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/" + bd;
    
    private static void enlace() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            System.out.println("Conexión exitosa");
        } catch (SQLException ex) {
            System.out.println("Excepción en la conexión");
        } catch (ClassNotFoundException ex) {
            System.out.println("No se encuentra la clase");
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public static DefaultTableModel buildTableModel(String query) {
        Vector<Vector<Object>> data = null;
        Vector<String> columnNames = null;
        try {
            enlace();
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            
            ResultSetMetaData metaData = rs.getMetaData();
            
            // names of columns
            columnNames = new Vector<String>();
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                columnNames.add(metaData.getColumnName(column));
            }

            // data of the table
            data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(rs.getObject(columnIndex));
                }
                data.add(vector);
            }
            
            cerrarSesion();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new DefaultTableModel(data, columnNames);
    }
    
    public static void resultSetToTableModel(String query, JTable table) {

        try {
            enlace();
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            //Create new table model
            DefaultTableModel tableModel = new DefaultTableModel();

            //Retrieve meta data from ResultSet
            ResultSetMetaData metaData = rs.getMetaData();

            //Get number of columns from meta data
            int columnCount = metaData.getColumnCount();

            //Get all column names from meta data and add columns to table model
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++){
                tableModel.addColumn(metaData.getColumnLabel(columnIndex));
            }

            //Create array of Objects with size of column count from meta data
            Object[] row = new Object[columnCount];

            //Scroll through result set
            while (rs.next()){
                //Get object from column with specific index of result set to array of objects
                for (int i = 0; i < columnCount; i++){
                    row[i] = rs.getObject(i+1);
                }
                //Now add row to table model with that array of objects as an argument
                tableModel.addRow(row);
            }

            //Now add that table model to your table and you are done 😄
            table.setModel(tableModel);

            cerrarSesion();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void fillTable(JTable table, String Query)
    {
        try
        {
            enlace();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(Query);

            //To remove previously added rows
            while(table.getRowCount() > 0) 
            {
                ((DefaultTableModel) table.getModel()).removeRow(0);
            }
            int columns = rs.getMetaData().getColumnCount();
            while(rs.next())
            {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++)
                {
                    row[i - 1] = rs.getObject(i);
                }
                ((DefaultTableModel) table.getModel()).insertRow(rs.getRow()-1,row);
            }

            cerrarSesion();
        }
        catch(SQLException ex)
        {
            System.out.println("Error SQL: " + ex.getMessage());
        }
    }
    
    public static void insertarUsuario(Usuario usuario) { 
        enlace();
        
        try {
            String sql = "INSERT INTO usuario (ID, NOMBRE, APE1, APE2) VALUES (?, ?, ?, ?);";
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, usuario.getId());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getApellido1());
            stmt.setString(4, usuario.getApellido2());
            
            System.out.println(stmt.toString());
            
            stmt.execute();
        } catch (SQLIntegrityConstraintViolationException ex){
            System.out.println("Error SQL: " + ex.toString());
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }
        
        cerrarSesion();       
    }
    
    public static void insertarOpcion(Opcion opcion) { 
        enlace();
        
        try {
            String sql = "INSERT INTO opcion (ID, TEXTO, CORRECTA, ID_PREGUNTA) VALUES (?, ?, ?, ?);";
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, opcion.getId());
            stmt.setString(2, opcion.getRespuesta());
            stmt.setBoolean(3, opcion.getCorrecta());
            stmt.setInt(4, opcion.getIdPregunta());
            
            System.out.println(stmt.toString());
            
            stmt.execute();
        } catch (SQLIntegrityConstraintViolationException ex){
            System.out.println("Error SQL: " + ex.toString());
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }
        
        cerrarSesion();       
    }
    
    public static void insertarPregunta(Pregunta pregunta) { 
        enlace();
        
        try {
            String sql = "INSERT INTO pregunta (ID, TEXTO, ID_USUARIO) VALUES (?, ?, ?);";
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, pregunta.getId());
            stmt.setString(2, pregunta.getPregunta());
            stmt.setInt(3, pregunta.getIdUsuario());
            
            System.out.println(stmt.toString());
            
            stmt.execute();
        } catch (SQLIntegrityConstraintViolationException ex){
            System.out.println("Error SQL: " + ex.toString());
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }
        
        cerrarSesion();       
    }
    
    public static void eliminarUsuario(Usuario usuario) { 
        enlace();
        
        try {
            String sql = "DELETE FROM usuario WHERE ID = ?;";
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, usuario.getId());
            
            System.out.println(stmt.toString());
            
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Error SQL por?: " + ex.toString());
        }
        
        cerrarSesion();
    }
    
    public static void eliminarPregunta(Pregunta pregunta) { 
        enlace();
        
        try {
            String sql = "DELETE FROM pregunta WHERE ID = ?;";
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, pregunta.getId());
            
            System.out.println(stmt.toString());
            
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Error SQL por?: " + ex.toString());
        }
        
        cerrarSesion();
    }
    
    public static void eliminarRespuesta(Opcion opcion) { 
        enlace();
        
        try {
            String sql = "DELETE FROM opcion WHERE ID = ?;";
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, opcion.getId());
            
            System.out.println(stmt.toString());
            
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Error SQL por?: " + ex.toString());
        }
        
        cerrarSesion();
    }
    
    public static ArrayList<Usuario> getUsuarios() { 
        enlace();
        
        ArrayList<Usuario> listaUsuarios = null;
        
        try {
            String sql = "SELECT * FROM usuario;";
            stmt = conn.prepareStatement(sql);
            
            System.out.println(stmt.toString());
            
            rs = stmt.executeQuery();
            
            listaUsuarios = new ArrayList<Usuario>();
            
            while (rs.next()) {
                listaUsuarios.add(new Usuario(rs.getInt("ID"),
                        rs.getString("NOMBRE"),
                        rs.getString("APE1"),
                        rs.getString("APE2")));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }
        
        cerrarSesion();
        
        return listaUsuarios;
    }
    
    public static ArrayList<Pregunta> getPreguntas(Usuario usuario) { 
        enlace();
        
        ArrayList<Pregunta> listaPreguntas = null;
        
        try {
            String sql = "SELECT * FROM pregunta WHERE id_usuario = ?;";
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, usuario.getId());
            
            System.out.println(stmt.toString());
            
            rs = stmt.executeQuery();
            
            listaPreguntas = new ArrayList<Pregunta>();
            
            while (rs.next()) {
                listaPreguntas.add(new Pregunta(rs.getInt("ID"),
                        rs.getString("TEXTO"),
                        rs.getInt("ID_USUARIO")));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }
        
        cerrarSesion();
        
        return listaPreguntas;
    }
    
    public static ArrayList<Opcion> getOpciones(Pregunta pregunta) { 
        enlace();
        
        ArrayList<Opcion> listaOpciones = null;
        
        try {
            String sql = "SELECT * FROM opcion WHERE id_pregunta = ?;";
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, pregunta.getId());
            
            System.out.println(stmt.toString());
            
            rs = stmt.executeQuery();
            
            listaOpciones = new ArrayList<Opcion>();
            
            while (rs.next()) {
                listaOpciones.add(new Opcion(rs.getInt("ID"),
                        rs.getInt("ID_PREGUNTA"),
                        rs.getBoolean("CORRECTA"),
                        rs.getString("TEXTO")));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }
        
        cerrarSesion();
        
        return listaOpciones;
    }
    
    public static Integer obtenerIDUsuMax() {
        enlace();
        
        Integer idMax = -1;
        
        try {
            
            String sql = "SELECT MAX(ID) AS IDUSU FROM usuario;";
            stmt = conn.prepareStatement(sql);
            
            System.out.println(stmt.toString());
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                idMax = rs.getInt("IDUSU");
            } 
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        }
        
        cerrarSesion();
        
        return idMax;
    }
    
    public static Integer obtenerIDPregMax() {
        enlace();
        
        Integer idMax = -1;
        
        try {
            
            String sql = "SELECT MAX(ID) AS IDUSU FROM pregunta;";
            stmt = conn.prepareStatement(sql);
            
            System.out.println(stmt.toString());
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                idMax = rs.getInt("IDUSU");
            } 
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        }
        
        cerrarSesion();
        
        return idMax;
    }
    
    public static Integer obtenerIDOpMax() {
        enlace();
        
        Integer idMax = -1;
        
        try {
            
            String sql = "SELECT MAX(ID) AS IDUSU FROM opcion;";
            stmt = conn.prepareStatement(sql);
            
            System.out.println(stmt.toString());
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                idMax = rs.getInt("IDUSU");
            } 
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        }
        
        cerrarSesion();
        
        return idMax;
    }
    
    public static void editarUsuario(Usuario usuario, String nombre, String ape1, String ape2) { 
        enlace();
        
        try {
            String sql = "UPDATE usuario SET NOMBRE = ?, APE1 = ?, APE2 = ? WHERE ID = ?;";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, nombre);
            stmt.setString(2, ape1);
            stmt.setString(3, ape2);
            stmt.setInt(4, usuario.getId());
            
            System.out.println(stmt.toString());
            
            stmt.execute();
        } catch (SQLIntegrityConstraintViolationException ex){
            System.out.println("Error SQL: " + ex.toString());
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }
        
        cerrarSesion();
    }
    
    public static void editarRespuesta(Opcion opcion, String texto, Boolean correcta) { 
        enlace();
        
        try {
            String sql = "UPDATE opcion SET TEXTO = ?, CORRECTA = ? WHERE ID = ?;";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, texto);
            stmt.setBoolean(2, correcta);
            stmt.setInt(3, opcion.getId());
            
            System.out.println(stmt.toString());
            
            stmt.execute();
        } catch (SQLIntegrityConstraintViolationException ex){
            System.out.println("Error SQL: " + ex.toString());
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }
        
        cerrarSesion();
    }
    
    public static void editarPregunta(Pregunta pregunta, String texto) { 
        enlace();
        
        try {
            String sql = "UPDATE pregunta SET TEXTO = ? WHERE ID = ?;";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, texto);
            stmt.setInt(2, pregunta.getId());
            
            System.out.println(stmt.toString());
            
            stmt.execute();
        } catch (SQLIntegrityConstraintViolationException ex){
            System.out.println("Error SQL: " + ex.toString());
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }
        
        cerrarSesion();
    }
    
    private static void cerrarSesion() {
        try {
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("Conexión cerrada \n");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}