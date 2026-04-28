package ec.edu.taller;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class GestorListarAlertasTest {

    @Test
    void listarDebeRetornarOrdenadoSinModificarCola() {
        GestorAlertasPrioridad gestor = new GestorAlertasPrioridad();

        gestor.registrarAlerta(new AlertaSeguridad("ana", "Clave123!", 0, false));
        gestor.registrarAlerta(new AlertaSeguridad("root", "Clave123!", 5, true));
        gestor.registrarAlerta(new AlertaSeguridad("admin", "12345", 0, true));

        List<AlertaSeguridad> lista = gestor.listarAlertasOrdenadas();

        assertEquals(3, lista.size());
        assertEquals("root", lista.get(0).getUsuario());
        assertEquals("admin", lista.get(1).getUsuario());
        assertEquals("ana", lista.get(2).getUsuario());

        assertEquals(3, gestor.contarAlertasPendientes());
        assertEquals("root", gestor.consultarAlertaPrioritaria().getUsuario());
    }
}
