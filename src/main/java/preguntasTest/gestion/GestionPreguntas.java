package preguntasTest.gestion;

import java.util.ArrayList;
import preguntasTest.bbdd.ConexionBD;
import preguntasTest.clases.Opcion;
import preguntasTest.clases.Pregunta;
import preguntasTest.clases.Usuario;

public class GestionPreguntas {
    private static GestionPreguntas gestion = null;
    
    public GestionPreguntas() {
    }
    
    public static GestionPreguntas getInstance() {
        if (gestion == null) {
            gestion = new GestionPreguntas();
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
}