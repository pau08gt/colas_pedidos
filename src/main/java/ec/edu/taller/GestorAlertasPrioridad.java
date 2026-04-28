package ec.edu.taller;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GestorAlertasPrioridad {

    private PriorityQueue<AlertaSeguridad> colaPrioridad;

    public GestorAlertasPrioridad() {
        this.colaPrioridad = new PriorityQueue<>();
    }

    public boolean esContrasenaSegura(String contrasena) {
        // TODO: implementar validación de contraseña segura
        return false;
    }

    public String calcularRiesgo(AlertaSeguridad alerta) {
        // TODO: implementar cálculo de riesgo
        return "BAJO";
    }

    public boolean registrarAlerta(AlertaSeguridad alerta) {
        // TODO: implementar validaciones, cálculo de riesgo y registro
        return false;
    }

    public boolean existeUsuario(String usuario) {
        // TODO: verificar si existe usuario en cola
        return false;
    }

    public AlertaSeguridad consultarAlertaPrioritaria() {
        // TODO: consultar alerta prioritaria sin eliminar
        return null;
    }

    public AlertaSeguridad atenderAlertaPrioritaria() {
        // TODO: eliminar y retornar alerta prioritaria
        return null;
    }

    public int contarAlertasPendientes() {
        // TODO: retornar cantidad de alertas pendientes
        return 0;
    }

    public List<AlertaSeguridad> listarAlertasOrdenadas() {
        // TODO: retornar lista ordenada sin modificar cola original
        return new ArrayList<>();
    }
}
