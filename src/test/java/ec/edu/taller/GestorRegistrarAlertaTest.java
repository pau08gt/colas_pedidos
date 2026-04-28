package ec.edu.taller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorRegistrarAlertaTest {

    @Test
    void registrarAlertaValidaDebeAsignarRiesgoYRetornarTrue() {
        GestorAlertasPrioridad gestor = new GestorAlertasPrioridad();
        AlertaSeguridad alerta = new AlertaSeguridad("admin", "12345", 0, true);

        assertTrue(gestor.registrarAlerta(alerta));
        assertEquals("ALTO", alerta.getRiesgo());
        assertEquals(1, gestor.contarAlertasPendientes());
    }

    @Test
    void registrarNullDebeRetornarFalse() {
        GestorAlertasPrioridad gestor = new GestorAlertasPrioridad();

        assertFalse(gestor.registrarAlerta(null));
    }

    @Test
    void registrarUsuarioVacioDebeRetornarFalse() {
        GestorAlertasPrioridad gestor = new GestorAlertasPrioridad();

        assertFalse(gestor.registrarAlerta(new AlertaSeguridad("   ", "Clave123!", 1, false)));
    }

    @Test
    void registrarContrasenaVaciaDebeRetornarFalse() {
        GestorAlertasPrioridad gestor = new GestorAlertasPrioridad();

        assertFalse(gestor.registrarAlerta(new AlertaSeguridad("ana", "   ", 1, false)));
    }

    @Test
    void registrarCriticoDebeBloquearAlerta() {
        GestorAlertasPrioridad gestor = new GestorAlertasPrioridad();
        AlertaSeguridad alerta = new AlertaSeguridad("root", "Clave123!", 5, true);

        assertTrue(gestor.registrarAlerta(alerta));
        assertEquals("CRITICO", alerta.getRiesgo());
        assertTrue(alerta.isBloqueado());
    }
}
