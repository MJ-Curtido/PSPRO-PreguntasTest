/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package preguntasTest.vista;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author manu1
 */
public class PanelFinalTest {
    private MockVentanaPreguntas miVentanaPreguntas;
            
    public PanelFinalTest() {
        miVentanaPreguntas = new MockVentanaPreguntas();
    }
    
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testObtenerPorcentaje1() {
        PanelFinal miPanel = new PanelFinal(miVentanaPreguntas, miVentanaPreguntas.obtenerUsuario(), 7, 20);
        
        assertEquals(35.0, miPanel.obtenerPorcentaje(), 0.1);
    }
    
    @Test
    public void testObtenerPorcentaje2() {
        PanelFinal miPanel = new PanelFinal(miVentanaPreguntas, miVentanaPreguntas.obtenerUsuario(), 10, 20);
        
        assertEquals(50.0, miPanel.obtenerPorcentaje(), 0.1);
    }
    
    @Test
    public void testObtenerPorcentaje3() {
        PanelFinal miPanel = new PanelFinal(miVentanaPreguntas, miVentanaPreguntas.obtenerUsuario(), 5, 20);
        
        assertEquals(25.0, miPanel.obtenerPorcentaje(), 0.1);
    }
}
