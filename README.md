# Taller Evaluación: Cola con Prioridad usando Comparable

## Tema

Estructuras de datos: `PriorityQueue` e interfaz `Comparable`

## Contexto de ciberseguridad

Una empresa registra alertas de seguridad relacionadas con accesos sospechosos, contraseñas débiles y eventos críticos del sistema.

No todas las alertas tienen la misma urgencia. Por ejemplo:

- Un acceso fallido con contraseña segura puede ser de bajo riesgo.
- Varios accesos fallidos pueden representar un riesgo alto.
- Un acceso bloqueado o con muchos intentos fallidos debe atenderse como crítico.
- Una contraseña débil en una cuenta sensible puede representar un riesgo medio o alto.

El equipo de seguridad necesita una aplicación que use una **cola con prioridad** para atender primero las alertas más graves.

En este ejercicio, la prioridad debe definirse implementando la interfaz:

```java
Comparable<AlertaSeguridad>
```

Es decir, la clase `AlertaSeguridad` debe saber compararse con otra alerta.

---

## Objetivo

Desarrollar un sistema en Java que:

- Registre alertas de seguridad.
- Valide contraseñas seguras.
- Calcule nivel de riesgo.
- Use `PriorityQueue`.
- Ordene las alertas mediante `Comparable`.
- Permita consultar y atender la alerta más urgente.
- Incluya una interfaz gráfica Swing.

---

## Prioridades

El orden de atención debe ser:

1. `CRITICO`
2. `ALTO`
3. `MEDIO`
4. `BAJO`

Si dos alertas tienen el mismo riesgo:

1. Se atiende primero la alerta con más intentos fallidos.
2. Si siguen empatadas, se atiende primero la alerta de usuario sensible.

---

## Clase `AlertaSeguridad`

Debe implementar:

```java
public class AlertaSeguridad implements Comparable<AlertaSeguridad>
```

Atributos obligatorios:

```java
private String usuario;
private String contrasena;
private int intentosFallidos;
private String riesgo;
private boolean usuarioSensible;
private boolean bloqueado;
```

Debe incluir:

- Constructor.
- Getters y setters.
- `toString()`.
- Implementación de `compareTo`.

---

## Clase `GestorAlertasPrioridad`

Debe utilizar internamente:

```java
PriorityQueue<AlertaSeguridad>
```

---

## Métodos obligatorios

### 1. `esContrasenaSegura(String contrasena)`

Una contraseña segura debe cumplir:

- Mínimo 8 caracteres.
- Al menos una mayúscula.
- Al menos una minúscula.
- Al menos un número.
- Al menos un carácter especial.

---

### 2. `calcularRiesgo(AlertaSeguridad alerta)`

Reglas:

- Si la alerta es `null`, retornar `"BAJO"`.
- Si está bloqueada, retornar `"CRITICO"`.
- Si tiene 5 o más intentos fallidos, retornar `"CRITICO"`.
- Si tiene 3 o 4 intentos fallidos y el usuario es sensible, retornar `"CRITICO"`.
- Si tiene 3 o 4 intentos fallidos, retornar `"ALTO"`.
- Si tiene contraseña débil y usuario sensible, retornar `"ALTO"`.
- Si tiene contraseña débil, retornar `"MEDIO"`.
- En cualquier otro caso, retornar `"BAJO"`.

---

### 3. `registrarAlerta(AlertaSeguridad alerta)`

Reglas:

- No acepta alertas `null`.
- No acepta usuario nulo o vacío.
- No acepta contraseña nula o vacía.
- No acepta usuarios duplicados.
- Debe calcular y asignar el riesgo antes de registrar.
- Si el riesgo es `"CRITICO"`, debe marcar la alerta como bloqueada.
- Retorna `true` si registra correctamente.
- Retorna `false` si no registra.

---

### 4. `existeUsuario(String usuario)`

Verifica si un usuario ya tiene una alerta registrada.

---

### 5. `consultarAlertaPrioritaria()`

Consulta la alerta más urgente sin eliminarla.

---

### 6. `atenderAlertaPrioritaria()`

Elimina y retorna la alerta más urgente.

---

### 7. `contarAlertasPendientes()`

Retorna la cantidad de alertas pendientes.

---

### 8. `listarAlertasOrdenadas()`

Retorna una lista ordenada por prioridad, sin vaciar la cola original.

---

## Interfaz gráfica Swing

El estudiante debe crear:

```java
ec.edu.taller.InterfazAlertasPrioridad
```

Debe usar obligatoriamente:

- `JLabel`
- `JTextField`
- `JComboBox`
- `JTextArea`
- `JList`
- `JButton`

La interfaz debe permitir:

- Registrar alertas.
- Consultar alerta prioritaria.
- Atender alerta prioritaria.
- Listar alertas pendientes.

---

## Puntuacion
Codigo 6 Puntos de acuerdo a las pruebas
Ventana 4 Puntos debe realizar arrastrando elementos.


## Archivos que NO deben modificarse

```text
.github/workflows/classroom.yml
src/test/java/
pom.xml
```

Modificar estos archivos puede implicar calificación 0.
