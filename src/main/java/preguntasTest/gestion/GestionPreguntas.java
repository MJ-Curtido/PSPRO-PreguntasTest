package preguntasTest.gestion;

import java.util.ArrayList;
import preguntasTest.bbdd.ConexionBD;
import preguntasTest.clases.Opcion;
import preguntasTest.clases.Pregunta;
import preguntasTest.clases.Usuario;

public class GestionPreguntas {
    public GestionPreguntas() {
        
    }
    
    public Integer numPreguntas() {
        return null;
    }
    
    public Pregunta obtenerPregunta(Integer ind) {
        return null;
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
}