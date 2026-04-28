package ec.edu.taller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorExisteUsuarioTest {

    @Test
    void existeUsuarioDebeRetornarTrueSiExiste() {
        GestorAlertasPrioridad gestor = new GestorAlertasPrioridad();
        gestor.registrarAlerta(new AlertaSeguridad("ana", "Clave123!", 1, false));

        assertTrue(gestor.existeUsuario("ana"));
    }

    @Test
    void existeUsuarioDebeRetornarFalseSiNoExisteONullOVacio() {
        GestorAlertasPrioridad gestor = new GestorAlertasPrioridad();

        assertFalse(gestor.existeUsuario("ana"));
        assertFalse(gestor.existeUsuario(null));
        assertFalse(gestor.existeUsuario(""));
        assertFalse(gestor.existeUsuario("   "));
    }

    @Test
    void registrarUsuarioDuplicadoDebeRetornarFalse() {
        GestorAlertasPrioridad gestor = new GestorAlertasPrioridad();

        assertTrue(gestor.registrarAlerta(new AlertaSeguridad("ana", "Clave123!", 1, false)));
        assertFalse(gestor.registrarAlerta(new AlertaSeguridad("ana", "Otra123!", 5, true)));
        assertEquals(1, gestor.contarAlertasPendientes());
    }
}
