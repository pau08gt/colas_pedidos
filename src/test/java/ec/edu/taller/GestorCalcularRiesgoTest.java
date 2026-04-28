package ec.edu.taller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorCalcularRiesgoTest {

    @Test
    void alertaBloqueadaDebeSerCritica() {
        GestorAlertasPrioridad gestor = new GestorAlertasPrioridad();
        AlertaSeguridad alerta = new AlertaSeguridad("ana", "Clave123!", 1, false);
        alerta.setBloqueado(true);

        assertEquals("CRITICO", gestor.calcularRiesgo(alerta));
    }

    @Test
    void cincoIntentosDebeSerCritico() {
        GestorAlertasPrioridad gestor = new GestorAlertasPrioridad();
        assertEquals("CRITICO", gestor.calcularRiesgo(new AlertaSeguridad("ana", "Clave123!", 5, false)));
    }

    @Test
    void tresIntentosUsuarioSensibleDebeSerCritico() {
        GestorAlertasPrioridad gestor = new GestorAlertasPrioridad();
        assertEquals("CRITICO", gestor.calcularRiesgo(new AlertaSeguridad("admin", "Clave123!", 3, true)));
    }

    @Test
    void tresOCuatroIntentosUsuarioNormalDebeSerAlto() {
        GestorAlertasPrioridad gestor = new GestorAlertasPrioridad();
        assertEquals("ALTO", gestor.calcularRiesgo(new AlertaSeguridad("ana", "Clave123!", 3, false)));
        assertEquals("ALTO", gestor.calcularRiesgo(new AlertaSeguridad("luis", "Clave123!", 4, false)));
    }

    @Test
    void contrasenaDebilUsuarioSensibleDebeSerAlto() {
        GestorAlertasPrioridad gestor = new GestorAlertasPrioridad();
        assertEquals("ALTO", gestor.calcularRiesgo(new AlertaSeguridad("admin", "12345", 0, true)));
    }

    @Test
    void contrasenaDebilUsuarioNormalDebeSerMedio() {
        GestorAlertasPrioridad gestor = new GestorAlertasPrioridad();
        assertEquals("MEDIO", gestor.calcularRiesgo(new AlertaSeguridad("user", "12345", 0, false)));
    }

    @Test
    void casoSeguroDebeSerBajo() {
        GestorAlertasPrioridad gestor = new GestorAlertasPrioridad();
        assertEquals("BAJO", gestor.calcularRiesgo(new AlertaSeguridad("user", "Clave123!", 0, false)));
    }
}
