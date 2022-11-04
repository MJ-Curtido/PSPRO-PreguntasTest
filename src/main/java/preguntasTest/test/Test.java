
package preguntasTest.test;

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import preguntasTest.vista.VentanaPreguntasTest;

public class Test {

    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        EventQueue.invokeAndWait(new Runnable() {
            public void run() {
                try {
                    VentanaPreguntasTest frame = new VentanaPreguntasTest();
                    frame.setVisible(true);
                }
                catch(Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}
