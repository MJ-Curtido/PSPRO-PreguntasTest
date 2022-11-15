/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package preguntasTest.bbdd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import preguntasTest.clases.Pregunta;

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
    
    public static List<Pregunta> getPreguntas() { 
        enlace();
        
        List<Pregunta> listaPreguntas = null;
        
        try {
            String sql = "SELECT * FROM vehiculo;";
            stmt = conn.prepareStatement(sql);
            
            System.out.println(stmt.toString());
            
            rs = stmt.executeQuery();
            
            listaPreguntas = new ArrayList<Pregunta>();
            /*
            while (rs.next()) {
                listaPreguntas.add(new Pregunta(rs.getString("MARCA"),
                        rs.getString("MODELO"),
                        rs.getString("MATRICULA")));
            }
            */
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }
        
        cerrarSesion();
        
        return listaPreguntas;
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