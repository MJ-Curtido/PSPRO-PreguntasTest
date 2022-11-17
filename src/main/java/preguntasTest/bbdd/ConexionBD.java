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
    
    /*
    public static void insertarVehiculo(Vehiculo vehiculo) { 
        enlace();
        
        try {
            String sql = "INSERT INTO vehiculo (MARCA, MODELO, MATRICULA) VALUES (?, ?, ?);";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, vehiculo.getMarca());
            stmt.setString(2, vehiculo.getModelo());
            stmt.setString(3, vehiculo.getMatricula());
            
            System.out.println(stmt.toString());
            
            stmt.execute();
        } catch (SQLIntegrityConstraintViolationException ex){
            System.out.println("Error SQL: " + ex.toString());
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }
        
        cerrarSesion();       
    }
    */
    /*
    public static void eliminarVehiculo(Vehiculo vehiculo) { 
        enlace();
        
        try {
            String sql = "DELETE FROM vehiculo WHERE MATRICULA = ?;";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, vehiculo.getMatricula());
            
            System.out.println(stmt.toString());
            
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Error SQL por?: " + ex.toString());
        }
        
        cerrarSesion();
    }
    */
    
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
                listaUsuarios.add(new Usuario(rs.getString("NOMBRE"),
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
                listaPreguntas.add(new Pregunta(rs.getString("TEXTO"),
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
                listaOpciones.add(new Opcion(rs.getInt("ID_PREGUNTA"),
                        rs.getBoolean("CORRECTA"),
                        rs.getString("TEXTO")));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }
        
        cerrarSesion();
        
        return listaOpciones;
    }
    
    /*
    public static Vehiculo obtenerVehiculo(String matricula) {
        enlace();
        
        Vehiculo vehiculo = null;
        
        try {
            
            String sql = "SELECT * FROM vehiculo WHERE matricula = ?;";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, matricula);
            
            System.out.println(stmt.toString());
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                vehiculo = new Vehiculo(rs.getString("Marca"), rs.getString("Modelo"), rs.getString("Matricula"));
            } 
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        }
        
        cerrarSesion();
        
        return vehiculo;
    }
    */
    /*
    public static void editarVehiculo(Vehiculo vehiculo, String marca, String modelo, String matricula) { 
        enlace();
        
        try {
            String sql = "UPDATE vehiculo SET MARCA = ?, MODELO = ?, MATRICULA = ? WHERE MATRICULA = ?;";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, marca);
            stmt.setString(2, modelo);
            stmt.setString(3, matricula);
            stmt.setString(4, vehiculo.getMatricula());
            
            System.out.println(stmt.toString());
            
            stmt.execute();
        } catch (SQLIntegrityConstraintViolationException ex){
            System.out.println("Error SQL: " + ex.toString());
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }
        
        cerrarSesion();
    }
    */
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