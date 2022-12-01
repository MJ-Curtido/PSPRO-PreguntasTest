/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package preguntasTest.gestion;

import java.util.ArrayList;
import preguntasTest.clases.Usuario;

/**
 *
 * @author Dam
 */
public class MockDAO extends Gestion{
    private ArrayList<Usuario> falsaBD;
    
    public MockDAO() {
        this.falsaBD = new ArrayList<Usuario>();
        falsaBD.add(new Usuario("Pablo Miguel", "del Castillo", "Barba"));
        falsaBD.add(new Usuario("Marta", "Mariscal", "Velázquez"));
        falsaBD.add(new Usuario("Manuel Jesús", "Curtido", "Rosado"));
        falsaBD.add(new Usuario("Jonny", "Melabo", "Srry"));
    }

    @Override
    public ArrayList<Usuario> obtenerUsuarios() {
        return falsaBD;
    }
}