package ec.edu.taller;

public class AlertaSeguridad implements Comparable<AlertaSeguridad> {

    private String usuario;
    private String contrasena;
    private int intentosFallidos;
    private String riesgo;
    private boolean usuarioSensible;
    private boolean bloqueado;

    public AlertaSeguridad(String usuario, String contrasena, int intentosFallidos, boolean usuarioSensible) {
        usuario = usuario;
        contrasena = contrasena;
        intentosFallidos = intentosFallidos;
        usuarioSensible = usuarioSensible;
        riesgo = "";
        bloqueado = false;
    }

    @Override
    public int compareTo(AlertaSeguridad otra) {
        // TODO: implementar comparación por riesgo, intentos fallidos y usuario sensible
        return 0;
    }

    public int valorPrioridad() {
        // TODO: retornar 1 para CRITICO, 2 para ALTO, 3 para MEDIO y 4 para BAJO
        return 4;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getIntentosFallidos() {
        return intentosFallidos;
    }

    public void setIntentosFallidos(int intentosFallidos) {
        this.intentosFallidos = intentosFallidos;
    }

    public String getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }

    public boolean isUsuarioSensible() {
        return usuarioSensible;
    }

    public void setUsuarioSensible(boolean usuarioSensible) {
        this.usuarioSensible = usuarioSensible;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    @Override
    public String toString() {
        return usuario + " | intentos: " + intentosFallidos +
                " | riesgo: " + riesgo +
                " | sensible: " + usuarioSensible +
                " | bloqueado: " + bloqueado;
    }
}
