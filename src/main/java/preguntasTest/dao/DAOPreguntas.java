package preguntasTest.dao;

import java.util.ArrayList;
import preguntasTest.clases.Pregunta;

public class DAOPreguntas {
    private static DAOPreguntas daoPreguntas = null;

    private DAOPreguntas() {

    }

    public static DAOPreguntas getInstance() {
            if (daoPreguntas == null) {
                    daoPreguntas = new DAOPreguntas();
            }

            return daoPreguntas;
    }

    public ArrayList<Pregunta> getPreguntas() {
            ArrayList<Pregunta> lista = new ArrayList<Pregunta>();
            
            return lista;
    }
}