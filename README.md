# COCHES API REST

Tenemos una base de datos donde debemos guardar los siguientes objetos:

- Coches
    - Un coche está asociado con una marca
    - Un coche está relacionado con varios precios
    - Un coche puede tener de 0 a N extras
    - Tiene las propiedades:
        - Nombre modelo
        - Color
        - Cilindrada
        - Potencia

- Marcas
    - Una marca está asociada a múltiples coches
    - Tiene las propiedades:
        - Nombre marca

- Precios
    - Múltiples precios están asociados a un coche
    - Cada precio tiene una fecha inicio y fecha fin. En este intervalo de tiempo es donde el precio es efectivo.
    - Tiene las propiedades:
        - Fecha inicio
        - Fecha fin
        - Precio

- Extras
    - Tiene las propiedades
        - Nombre

Se pide:

1. Construir una API Rest Spring Boot securizada con los endpoints básicos CRUD para los cuatro objetos anteriores.

    a. Se puede utilizar una base de datos en memoria.

    b. No es necesario desarrollar tests para todas las funcionalidades, pero al menos debería haber 1-2 ejemplos de test. Valorar el tipo de test más relevante a implemetar.

    c. Total libertad a la hora de utilizar librerías para ayudar al desarrollo de la aplicación: versionado de base de datos, mapeo, etc.

    d. Deberá quedar registro tanto de la fecha de creación como de la fecha de última modificación de cualquier entrada en base de datos.

    e. Las consultas a base de datos estarán optimizadas para realizar el mínimo número de consultas necesarias.

    f. La aplicación deberá estar securizada mediante Keycloak (puede ejecutarse con Docker).

    g. La aplicación debe estar preparada para ejecutarse con Docker.

    h. Junto con el código se deberá entragar una colección de postman con ejemplos de llamada a los distintos endpoints.

2. Será necesario crear un endpoint para el registro de usuarios.

3. El endpoint que devuelve todos los coches debe aceptar un parámetro "filtro" con las condiciones con las que hacer la búsqueda. Puede haber de 0 a N condiciones del tipo (no es necesario implementar el uso de paréntesis):

        color eq ROJO AND potencia gt 100

4. La respuesta de los endpoints de consulta de coches debe mostrar los extras como texto separado por comas: A/C, ELEVALUNAS, CLIMATIZADOR

5. El endpoint de consulta de **marcas** debe mostrar todos los coches relacionados. Por el contrario **precios** y **extras** no deben mostrar sus elementos relacionados.