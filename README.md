# Sistema de Autenticación y Control de Coordenadas (BOMB-93)

Este proyecto es una aplicación de consola desarrollada en Java. Implementa un sistema de seguridad basado en la validación de usuarios mediante Autómatas Finitos Deterministas (DFA), lectura de archivos `.csv` y procesamiento de coordenadas de arsenal.

---

## 🚀 Instrucciones de Acceso (Login)

Al iniciar la ejecución del programa (clase `App.java`), el sistema por consola solicitará credenciales de autenticación. El sistema cuenta con un máximo de **3 intentos** antes de bloquearse y cerrar la aplicación por seguridad.

Para ingresar exitosamente, debes utilizar **obligatoriamente** uno de los siguientes usuarios definidos en el autómata de validación:

### Usuarios Válidos permitidos:
* **Estudiante (Cliente):** `Donoso`
* **Profesor (Administrador):** `pat_mic`

### Contraseña de Acceso:
* **Clave única para ambos usuarios:** `1234`


## ⚙️ Funcionamiento Posterior al Ingreso

Una vez que el usuario es validado correctamente:
1. El sistema mostrará la cédula y el nombre del usuario con acceso concedido.
2. Se iniciará la lectura automática del archivo `.csv` con las coordenadas geoposicionales.
3. Se mostrará una animación de carga (Loading de 0% a 100%) antes de revelar el contenido de cada línea.
4. El motor del autómata principal evaluará el "Tipo de Arsenal" de las coordenadas específicas para determinar si la bomba explota.

## 🛠️ Tecnologías y Estructura
* **Lenguaje:** Java puro (sin librerías externas complejas).
* **Entrada de datos:** Clase `Scanner`.
* **Motor Lógico:** Matrices de transición de estados finitos.
