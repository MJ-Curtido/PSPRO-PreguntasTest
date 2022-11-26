/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package preguntasTest.bbdd;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public static Usuario obtenerUsuario(Integer id) {
        enlace();
        
        Usuario usuario = null;
        
        try {
            
            String sql = "SELECT * FROM usuario WHERE id = ?;";
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            System.out.println(stmt.toString());
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                usuario = new Usuario(rs.getInt("ID"),
                        rs.getString("NOMBRE"),
                        rs.getString("APE1"),
                        rs.getString("APE2"));
            } 
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        }
        
        cerrarSesion();
        
        return usuario;
    }
    
    public static void editarUsuario(Usuario usuario, Integer id, String nombre, String ape1, String ape2) { 
        enlace();
        
        try {
            String sql = "UPDATE usuario SET ID = ?, NOMBRE = ?, APE1 = ?, APE2 = ? WHERE ID = ?;";
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, id);
            stmt.setString(2, nombre);
            stmt.setString(3, ape1);
            stmt.setString(4, ape2);
            stmt.setInt(5, usuario.getId());
            
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