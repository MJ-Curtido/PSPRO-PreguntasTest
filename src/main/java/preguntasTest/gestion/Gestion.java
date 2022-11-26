package preguntasTest.gestion;

import java.util.ArrayList;
import java.util.List;
import preguntasTest.bbdd.ConexionBD;
import preguntasTest.clases.Opcion;
import preguntasTest.clases.Pregunta;
import preguntasTest.clases.Usuario;

public class Gestion {
    private static Gestion gestion = null;
    
    public Gestion() {
    }
    
    public static Gestion getInstance() {
        if (gestion == null) {
            gestion = new Gestion();
        }

        return gestion;
    }
    
    public ArrayList<Pregunta> obtenerPreguntas(Usuario usuario) {
        return ConexionBD.getPreguntas(usuario);
    }
    
    public ArrayList<Opcion> obtenerRespuestas(Pregunta pregunta) {
        return ConexionBD.getOpciones(pregunta);
    }
    
    public ArrayList<Usuario> obtenerUsuarios() {
        return ConexionBD.getUsuarios();
    }
    
    public Boolean anyadirUsuario(Usuario usuario) {
        Boolean anyadido = false;
        
        if (ConexionBD.obtenerUsuario(usuario.getId()) == null) {
            ConexionBD.insertarUsuario(usuario);
            anyadido = true;
        }
        
        return anyadido;
    }

    public boolean editarVehiculo(Usuario usuarioAEditar, Integer id, String nombre, String ape1, String ape2) {
        Boolean editado = false;
        
        if (ConexionBD.obtenerUsuario(id) == null || usuarioAEditar.getId().equals(id)) {
            ConexionBD.editarUsuario(usuarioAEditar, id, nombre, ape1, ape2);
            
            editado = true;
        }
        
        return editado;
    }
    
    public void eliminarUsuarios(List<Usuario> lstUsuarios) {
        for (int i = 0; i < lstUsuarios.size(); i++) {
            ConexionBD.eliminarUsuario(lstUsuarios.get(i));
        }
    }
}