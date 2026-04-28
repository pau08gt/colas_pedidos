package ec.edu.taller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorContrasenaSeguraTest {

    @Test
    void contrasenaSeguraDebeRetornarTrue() {
        GestorAlertasPrioridad gestor = new GestorAlertasPrioridad();
        assertTrue(gestor.esContrasenaSegura("Clave123!"));
    }

    @Test
    void contrasenaInseguraDebeRetornarFalse() {
        GestorAlertasPrioridad gestor = new GestorAlertasPrioridad();
        assertFalse(gestor.esContrasenaSegura("clave123"));
        assertFalse(gestor.esContrasenaSegura("CLAVE123!"));
        assertFalse(gestor.esContrasenaSegura("Clave!!!"));
        assertFalse(gestor.esContrasenaSegura("Clave123"));
        assertFalse(gestor.esContrasenaSegura(null));
    }
}
