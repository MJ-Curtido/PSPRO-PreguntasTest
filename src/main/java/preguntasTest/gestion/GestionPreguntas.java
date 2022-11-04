package preguntasTest.gestion;

import preguntasTest.dao.DAOPreguntas;
import java.util.ArrayList;
import java.util.Collections;
import preguntasTest.clases.Opcion;
import preguntasTest.clases.Pregunta;

public class GestionPreguntas {
    private ArrayList<Pregunta> listaPreguntas;

    public GestionPreguntas() {
            listaPreguntas = DAOPreguntas.getInstance().getPreguntas();
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
        
        /*
        listaRespuestas.add(pregunta.getOp1());
        listaRespuestas.add(pregunta.getOp2());
        listaRespuestas.add(pregunta.getOp3());
        listaRespuestas.add(pregunta.getOp4());
        */        

        Collections.shuffle(listaRespuestas);
        
        return listaRespuestas;
    }
}