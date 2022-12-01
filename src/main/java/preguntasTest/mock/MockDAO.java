/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package preguntasTest.mock;

import java.util.ArrayList;
import preguntasTest.clases.Usuario;
import preguntasTest.gestion.Gestion;

/**
 *
 * @author Dam
 */
public class MockDAO extends Gestion{
    private ArrayList<Usuario> falsaBD;
    
    public MockDAO() {
        this.falsaBD = new ArrayList<Usuario>();
        falsaBD.add(new Usuario("Renault", "Zoe", "2345FDF"));
        falsaBD.add(new Usuario("Renault", "Fluence", "0000FTL"));
        falsaBD.add(new Usuario("Tesla", "3", "2422FHT"));
        falsaBD.add(new Usuario("Tesla", "X", "1221FDF"));
    }

    @Override
    public ArrayList<Usuario> obtenerUsuarios() {
        return falsaBD;
    }
    
    
}