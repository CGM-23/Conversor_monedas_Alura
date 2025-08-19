#  Conversor de Monedas en Java

Este es un proyecto simple de **consola en Java** que permite convertir entre diferentes monedas usando la API de [ExchangeRate-API](https://www.exchangerate-api.com/).  
El programa obtiene tasas de cambio en tiempo real y ofrece un menú interactivo para realizar conversiones rápidas.

---
## 📑 Índice

1. [Características](#-características)  
2. [Estructura del proyecto](#-estructura-del-proyecto)  
3. [Requisitos](#-requisitos)  
4. [Ejecución](#-ejecución)  
5. [Ejemplo de uso](#-ejemplo-de-uso)  

---

##  Características

- Conversión entre:
  - **USD ⇆ Sol Peruano (PEN)**
  - **USD ⇆ Real Brasileño (BRL)**
  - **USD ⇆ Peso Colombiano (COP)**
  - **USD ⇆ Peso Argentino (ARS)**
- Menú interactivo en consola.
- Manejo de errores por entrada inválida.
- Datos obtenidos desde una API en tiempo real.

---

## 🛠️ Requisitos

- **Java 11 o superior** (se utiliza `HttpClient`).
- Dependencia de **Gson** para procesar JSON.

Si usas **Maven**, agrega la siguiente dependencia en tu `pom.xml`:

```xml
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.10.1</version>
</dependency>
