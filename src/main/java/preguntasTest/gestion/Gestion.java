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
    
    public void anyadirUsuario(Usuario usuario) {
        ConexionBD.insertarUsuario(usuario);
    }

    public void editarUsuario(Usuario usuarioAEditar, String nombre, String ape1, String ape2) {
        ConexionBD.editarUsuario(usuarioAEditar, nombre, ape1, ape2);
    }
    
    public void eliminarUsuarios(List<Usuario> lstUsuarios) {
        for (int i = 0; i < lstUsuarios.size(); i++) {
            ConexionBD.eliminarUsuario(lstUsuarios.get(i));
        }
    }
    
    public Integer obtenerIDUsuMax() {
        return ConexionBD.obtenerIDUsuMax();
    }
    
    public void editarRespuesta(Opcion opcion, String texto, Boolean correcta) {
        ConexionBD.editarRespuesta(opcion, texto, correcta);
    }

    public void editarPregunta(Pregunta preguntaAEditar, String texto) {
        ConexionBD.editarPregunta(preguntaAEditar, texto);
    }

    public void insertarOpcion(Opcion opcion) {
        ConexionBD.insertarOpcion(opcion);
    }
}