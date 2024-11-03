# Integrador: Blockbuster

## Enunciado
Diseñar una aplicación web cliente de comercialización de dichos productos, es decir, elabora un catálogo de productos y arma un carrito de compras.

## Desarrollo
1. Crea una base de datos y piensa en las tablas que creas necesarias y los campos que tendrán, por ejemplo: product, cart, order-service, category, customer, etc.
2.Genera un proyecto Spring Boot con las dependencias que requieras (web, mysql, jpa...), crear las clases necesarias para tus entidades decorando con anotaciones y usando hibernate para la autogeneración.
3. Armar los controladores y servicios para realizar los mapeos con JPA.
4. Realizar pruebas con POSTMAN de todos lo verbos HTTP expuestos en cada uno de los endpoints generados.
5. Diseña un frontend con html, css y js (podés sumar algún framework), mostrar en el index un catálogo con los productos con la opción de un botón para agregar al carrito.
6. En el carrito debe aparecer el respectivo listado con el total a pagar para generar la orden de compra (opcional armar la orden).

## Comentarios
Le dí mil vueltas al integrador y hasta el momento no pude resolver el problema de conexión entre los elementos para la total y completa funcionalidad del proyecto. Hay algo en la lógica de programación que no estoy viendo cómo resolver, pero quería al menos poder presentar algo por muy incompleto y roto que esté. Debido a esto último es que también no pude terminar de resolver un diseño correcto de HTML/CSS para los bloques de código que están directamente relacionados a Thymeleaf. También, además, me quedé con las ganas de poder completar el sistema de compra con un registro de órdenes como se sugería originalmente en el enunciado.
