package ec.edu.taller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlertaComparableTest {

    @Test
    void valorPrioridadDebeAsignarOrdenCorrecto() {
        AlertaSeguridad critica = new AlertaSeguridad("root", "Segura1!", 5, true);
        critica.setRiesgo("CRITICO");

        AlertaSeguridad alta = new AlertaSeguridad("admin", "Segura1!", 3, false);
        alta.setRiesgo("ALTO");

        AlertaSeguridad media = new AlertaSeguridad("user", "debil", 1, false);
        media.setRiesgo("MEDIO");

        AlertaSeguridad baja = new AlertaSeguridad("guest", "Segura1!", 0, false);
        baja.setRiesgo("BAJO");

        assertEquals(1, critica.valorPrioridad());
        assertEquals(2, alta.valorPrioridad());
        assertEquals(3, media.valorPrioridad());
        assertEquals(4, baja.valorPrioridad());
    }

    @Test
    void compareToDebePriorizarRiesgoMasAlto() {
        AlertaSeguridad critica = new AlertaSeguridad("root", "Segura1!", 5, true);
        critica.setRiesgo("CRITICO");

        AlertaSeguridad baja = new AlertaSeguridad("guest", "Segura1!", 0, false);
        baja.setRiesgo("BAJO");

        assertTrue(critica.compareTo(baja) < 0);
        assertTrue(baja.compareTo(critica) > 0);
    }

    @Test
    void compareToConMismoRiesgoDebePriorizarMasIntentos() {
        AlertaSeguridad a = new AlertaSeguridad("ana", "Segura1!", 3, false);
        a.setRiesgo("ALTO");

        AlertaSeguridad b = new AlertaSeguridad("luis", "Segura1!", 4, false);
        b.setRiesgo("ALTO");

        assertTrue(b.compareTo(a) < 0);
    }

    @Test
    void compareToConMismoRiesgoEIntentosDebePriorizarUsuarioSensible() {
        AlertaSeguridad sensible = new AlertaSeguridad("admin", "Segura1!", 3, true);
        sensible.setRiesgo("ALTO");

        AlertaSeguridad normal = new AlertaSeguridad("user", "Segura1!", 3, false);
        normal.setRiesgo("ALTO");

        assertTrue(sensible.compareTo(normal) < 0);
    }
}
