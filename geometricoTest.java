import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class geometricoTest {

    @Test
    public void testCalcularCono() {
        String input = "3\n4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        geometrico.calcularCono(scanner);

    }

    @Test
    public void testCalcularConoConNumerosNegativos() {
        String input = "-3\n-4\n3\n4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        geometrico.calcularCono(scanner);
    }
}
