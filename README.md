# kata-api

Este proyecto de automatización ha sido desarrollado utilizando **Serenity** y **Gradle** como marco de pruebas.

Su objetivo es ejecutar pruebas de **API**, cubriendo tanto los **Happy Paths** como los **Unhappy Paths**, garantizando así la estabilidad y confiabilidad del sistema.
***

## 👥 Detalles de los testers que han apoyado en el desarrollo de este proyecto.


* **Name:** Santiago Abril Vargas 🧑‍💻
    * **Usuario:** zantiabril@gmail.com
    * **Country:** Colombia
    * **City:** Bogotá DC.
    * **LinkedIn:** [www.linkedin.com/in/santiago-abril-vargas](www.linkedin.com/in/santiago-abril-vargas)

***

## 🛠️ Lenguajes & Frameworks

Este proyecto utiliza los siguientes lenguajes y frameworks:

* **[Serenity](https://serenity-bdd.github.io/docs/guide/user_guide_intro)** Framework para la automatización de pruebas que facilita la escritura de pruebas claras y mantenibles.
* **[Gradle](https://docs.gradle.org/current/userguide/userguide.html)** Herramienta de automatización para la compilación y gestión de dependencias del proyecto.
* **[Java 11](https://www.oracle.com/co/java/technologies/javase/jdk11-archive-downloads.html)** Lenguaje de programación utilizado para el desarrollo y ejecución de las pruebas.


***

## 📋 Pre-requisitos

1. **🔧 Instalar complementos para mejorar la eficiencia en el desarrollo:**

   Se recomienda instalar los siguientes complementos (plugins) para optimizar tu flujo de trabajo y facilitar la automatización de pruebas.

    * **🖼️ Atom Material Icons**
    * **🌈 Rainbow Brackets**
    * **🛠️ GitToolBox**
    * **🤖 GitHubCopilot**
    * **🧩 SonarLint**<br/><br/>

2. **🧪 Instalar herramientas relacionadas con las pruebas:**

   Estos complementos facilitarán la ejecución y mantenimiento de las pruebas dentro de tu proyecto.

    * **🧑‍💻 JUnit**
    * **🥒 Cucumber for Java**
    * **✅ CheckStyle**
    * **🧹 Lombok**<br/><br/>

3. **🗂️ Instalar herramientas para la gestión del proyecto y el entorno de ejecución:**

   Asegúrate de tener los complementos adecuados para gestionar el entorno de ejecución y el flujo de trabajo del proyecto.

    * **📦 Gradle**
    * **📈 Serenity BDD Plugin**

***

### 🧪 Casos de prueba contemplados

Pruebas diseñadas para validar los escenarios exitosos, conocidos como **Happy Paths**, asegurando que el flujo principal funcione correctamente. 😃

**🌟 FEATURE**: Código de estado HTTP 200
- * Successful get all carts
- * Successful add a new cart
- * Successful update a cart
- * Successful delete a cart

**🌟 FEATURE**: Código de estado HTTP 400
- * Failed get all carts
- * Failed add a new cart
- * Failed update a cart
- * Failed delete a cart

***

## 📊 Generación de informes

Después de ejecutar las pruebas, se generarán informes detallados con los pasos y resultados obtenidos. Estos reportes estarán disponibles en las siguientes rutas:
* 📂 Resumen en HTML: target/site/serenity/index.html
* 📂 Resumen en HTML: target/site/serenity/serenity-summary.html
* 📂 Resultados en formato CSV: target/site/serenity/results.csv

***
ദ്ദി（• ˕ •マ.ᐟ