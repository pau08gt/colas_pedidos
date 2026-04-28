package ec.edu.taller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorConsultarAtenderTest {

    @Test
    void consultarDebeRetornarPrioritariaSinEliminar() {
        GestorAlertasPrioridad gestor = new GestorAlertasPrioridad();

        gestor.registrarAlerta(new AlertaSeguridad("ana", "Clave123!", 0, false));
        gestor.registrarAlerta(new AlertaSeguridad("admin", "Clave123!", 3, true));
        gestor.registrarAlerta(new AlertaSeguridad("luis", "Clave123!", 4, false));

        AlertaSeguridad prioritaria = gestor.consultarAlertaPrioritaria();

        assertNotNull(prioritaria);
        assertEquals("admin", prioritaria.getUsuario());
        assertEquals("CRITICO", prioritaria.getRiesgo());
        assertEquals(3, gestor.contarAlertasPendientes());
    }

    @Test
    void atenderDebeEliminarEnOrdenPrioridad() {
        GestorAlertasPrioridad gestor = new GestorAlertasPrioridad();

        gestor.registrarAlerta(new AlertaSeguridad("ana", "Clave123!", 0, false));
        gestor.registrarAlerta(new AlertaSeguridad("admin", "Clave123!", 3, true));
        gestor.registrarAlerta(new AlertaSeguridad("luis", "Clave123!", 4, false));

        assertEquals("admin", gestor.atenderAlertaPrioritaria().getUsuario());
        assertEquals("luis", gestor.atenderAlertaPrioritaria().getUsuario());
        assertEquals("ana", gestor.atenderAlertaPrioritaria().getUsuario());
        assertNull(gestor.atenderAlertaPrioritaria());
    }
}
