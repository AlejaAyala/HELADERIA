<h1>Heladerías Gestión - Proyecto Java</h1>

<h2>Descripción del Proyecto</h2>

Este proyecto es un software en Java diseñado para gestionar una cadena de heladerías. Permite llevar control sobre sucursales, productos (helados, malteadas, toppings) y pedidos por mesa, utilizando programación orientada a objetos y operaciones CRUD (Crear, Leer, Editar, Eliminar).
El software está pensado para ejecutarse en consola, con menús interactivos que permiten al usuario administrar todo el negocio de manera sencilla y clara.

<h3>Funcionalidades</h3>
1. Gestión de Sucursales
Crear, ver, editar y eliminar sucursales.
Cada sucursal almacena sus productos y pedidos por mesa.
Control por ID de sucursal para búsquedas y modificaciones.

2. Gestión de Productos
Helados: Se pueden registrar con id, precio base y sabores. Permite agregar toppings. Calcula el precio total con los toppings añadidos.
Malteadas: Se registran con id, precio base y sabor. Permite agregar toppings. Incluye recargo por leche especial.
Toppings: Se registran con id, nombre y precio. CRUD completo para administrar los toppings disponibles. Se pueden ver todos los productos de cada sucursal con sus precios y características.

3. Gestión de Pedidos por Mesa
Crear mesas y asociar pedidos.
Agregar helados y malteadas a cada pedido.
Calcular total del pedido, incluyendo propina.
Visualizar detalles del pedido de cada mesa.

<h3>Clases Principales</h3>

<p> Helado.java → Representa helados, sabores, toppings y cálculo de precio. </p>
<p> Malteada.java → Representa malteadas, sabor, recargo y toppings.</p>
<p> Topping.java → Representa toppings disponibles con precio. </p>
<p> Mesa.java → Representa una mesa de la heladería y su pedido asociado. </p>
<p> Pedido.java → Controla productos agregados a la mesa, cálculo de total y propina. </p>
<p> Sede.java → Representa sucursales de heladería, sus productos y CRUD completo. </p>
<p> Main.java → Menú principal interactivo que integra la gestión de sucursales, productos y pedidos. </p>

<h3>Navegar usando el menú interactivo:</h3>

Gestionar sucursales
Gestionar productos por sucursal
Gestionar pedidos por mesa

<h3>Ejemplo de uso</h3>

Crear sucursal “Helados Dulces” con ID 1. Agregar productos a la sucursal: Helado de vainilla, Malteada de chocolate, Toppings de chispas. Crear una mesa 1 y agregar productos al pedido.
Consultar el pedido y ver el total con propina incluida.

<h3>Autor</h3>
Beisy Alejandra Ayala Chitiva
Correo: baayala@ucundinamarca.edu.co - beisyayala850@gmail.com
