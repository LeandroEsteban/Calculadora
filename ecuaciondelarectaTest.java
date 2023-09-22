import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ecuaciondelarectaTest {

    @Test
    public void testCalcularPendiente() {
        double x1 = 2.0;
        double y1 = 3.0;
        double x2 = 4.0;
        double y2 = 7.0;

        double resultadoEsperado = 2.0;

        double resultadoObtenido = ecuaciondelarecta.calcularPendiente(x1, y1, x2, y2);

        assertEquals(resultadoEsperado, resultadoObtenido);
    }
    @Test
    public void testCalcularPendienteX1X2Cero() {
        double x1 = 0.0;
        double y1 = 3.0;
        double x2 = 0.0;
        double y2 = 7.0;

        double resultadoEsperado = Double.POSITIVE_INFINITY;

        double resultadoObtenido = ecuaciondelarecta.calcularPendiente(x1, y1, x2, y2);

        assertEquals(resultadoEsperado, resultadoObtenido);
    }
}


