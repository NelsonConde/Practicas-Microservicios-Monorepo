# Prácticas de Microservicios

Este repositorio reúne las actividades de la asignatura **Desarrollo de Aplicaciones Basadas en Microservicios**. Los ejercicios se irán agregando a medida que avancemos en clase.

## Fase 1 — Primeros microservicios con Spring Boot

[Guía de la actividad](https://jorgehernandez18.github.io/guia-springboot-microservicios/)

En esta primera fase trabajamos con dos microservicios:

- **Catálogo:** administra los productos.
- **Pedidos:** registra pedidos y consulta a Catálogo para comprobar que el producto existe y tiene stock suficiente.

Cada uno está en su propia carpeta (`catalogo/` y `pedidos/`), dentro del mismo repositorio.

### Preguntas de la actividad

**1. ¿Qué le pasa a Pedidos cuando Catálogo no está? ¿Se cae también?**

No. Pedidos sigue funcionando, pero no puede crear pedidos que necesiten consultar a Catálogo. Otras operaciones, como ver los pedidos ya registrados, pueden seguir disponibles.

**2. ¿Qué pasaría si Catálogo no estuviera caído, sino muy lento?**

Pedidos también se volvería lento al crear un pedido, porque tiene que esperar la respuesta de Catálogo. Si tarda demasiado, la solicitud podría fallar. Para manejarlo mejor, se pueden configurar tiempos de espera y controlar esos errores.

**3. Pedidos no descuenta el stock de Catálogo. ¿Quién debería hacerlo y qué pasa si falla después de guardar el pedido?**

Catálogo debería descontar el stock, porque es el servicio que administra los productos. Si el pedido se guarda, pero el descuento falla, el inventario queda desactualizado. Por eso, ambas operaciones deben coordinarse: el pedido podría quedar pendiente hasta confirmar el descuento o cancelarse si no se puede completar.