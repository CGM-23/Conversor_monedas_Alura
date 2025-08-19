# Conversor de Monedas en Java

Este proyecto es un **conversor de monedas por consola** desarrollado en **Java**, que obtiene tasas de cambio en tiempo real desde la API de [ExchangeRate-API](https://www.exchangerate-api.com/).  
El programa muestra un menú interactivo para convertir entre diferentes monedas de Latinoamérica y el dólar estadounidense.

---

## Índice

1. [Descripción](#descripción)  
2. [Tecnología usada](#tecnología-usada)  
3. [Ejemplo de uso](#ejemplo-de-uso)  

---

## Descripción

- Conversión entre:
  - **USD ⇆ Sol Peruano (PEN)**
  - **USD ⇆ Real Brasileño (BRL)**
  - **USD ⇆ Peso Colombiano (COP)**
  - **USD ⇆ Peso Argentino (ARS)**
- Menú interactivo en consola.
- Validación de entradas inválidas.
- Conexión a una API en tiempo real con tasas actualizadas.

---

## Tecnología usada

- **Java 11 o superior** (uso de `HttpClient`).
- **[Gson](https://github.com/google/gson)** para procesar JSON.
- **ExchangeRate-API** como proveedor de tasas de cambio.

Si usas **Maven**, agrega la dependencia de Gson en tu `pom.xml`:

```xml
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.10.1</version>
</dependency>
```

## Ejemplo de uso
1. Ejecuta el programa desde la terminal.  
2. Aparecerá el menú principal con las opciones de conversión disponibles.  
3. Ingresa el número de la opción que desees (ejemplo: `1` para convertir de USD a PEN).  
4. Escribe el monto que quieres convertir.  
5. El programa mostrará el resultado de la conversión.  
6. Se te preguntará si deseas hacer otra conversión (`s` para sí, `n` para no).  
7. Para salir del programa, selecciona la opción `9` en el menú.  
<img width="663" height="574" alt="image" src="https://github.com/user-attachments/assets/c74e9776-6257-4fce-ba54-6b966ce0a6b4" />

