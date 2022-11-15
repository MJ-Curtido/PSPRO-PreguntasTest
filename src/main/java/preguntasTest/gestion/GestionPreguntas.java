package preguntasTest.gestion;

import java.util.ArrayList;
import java.util.Collections;
import preguntasTest.clases.Opcion;
import preguntasTest.clases.Pregunta;

public class GestionPreguntas {
    private ArrayList<Pregunta> listaPreguntas;

    public GestionPreguntas() {
        
    }
    
    public Integer numPreguntas() {
        return listaPreguntas.size();
    }
    
    public Pregunta obtenerPregunta(Integer ind) {
        return listaPreguntas.get(ind);
    }
    
    public ArrayList<Pregunta> obtenerPreguntas() {
        Collections.shuffle(this.listaPreguntas);
        
        return (ArrayList<Pregunta>) this.listaPreguntas.clone();
    }
    
    public ArrayList<Opcion> obtenerRespuestas(Pregunta pregunta) {
        ArrayList<Opcion> listaRespuestas = new ArrayList<Opcion>();    

        Collections.shuffle(listaRespuestas);
        
        return listaRespuestas;
    }
}