# 				AEROGLOBAL

## Proyecto de Java vinculado a base de datos



![Diagrama Vuelos Globales](https://github.com/mvelascoe/ProyectoAgenciaVuelos/blob/main/img/Vuelos_globales.png)



**Desarrollado por:**

- Maritza Velasco
- Sara Lozano



- | Este proyecto tiene como objetivo apoyar a la agencia de viajes "Vuelos Globales". |
  | ------------------------------------------------------------ |
  | Vuelos Globales es una aerolínea con operaciones internacionales que gestiona una flota diversa de aviones, personal de tripulación variado, colaboraciones con múltiples aerolíneas y una extensa red de aeropuertos y destinos. La empresa requiere una base de datos sólida y eficiente que pueda manejar todos los aspectos de su operación, desde la reserva de vuelos hasta el mantenimiento de aeronaves y la gestión de la tripulación. |
  | Este caso cuenta con 45 casos de uso divididos entre 4 actores principales quienes son los: **usuarios del desarrollo.<br />Administrador del sistema <br />Agente de ventas<br /> Agente de mantenimiento <br />Cliente** |





 Se implementó un modelo estándar de desarrollo de software, enfocado en operaciones CRUD para aproximadamente 20 entidades. Cada entidad sigue los principios de arquitectura hexagonal, junto con divisiones verticales y un módulo dedicado para la gestión del flujo principal.

![Arquitectura Hexagonal](https://github.com/mvelascoe/ProyectoAgenciaVuelos/blob/main/img/ArquitecturaHexagonal.JPG)


Dentro de la arquitectura hexagonal, se diseñó un módulo específico para la gestión de la conexión con la base de datos, denominado MySQLRepository. Además, se incluyó un diagrama ERD de la base de datos, acompañado de su respectivo script SQL.

Cada entidad implementa operaciones CRUD y sigue los principios SOLID en su estructura,ademas en algunas entidades implementamos la inyección de otros Service para hacer la validación entre los datos que son Foreign Key.
