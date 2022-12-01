
package preguntasTest.test;

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import preguntasTest.vista.VentanaPreguntas;

public class Test {

    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        EventQueue.invokeAndWait(new Runnable() {
            public void run() {
                try {
                    VentanaPreguntas frame = new VentanaPreguntas();
                    frame.setVisible(true);
                }
                catch(Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}
