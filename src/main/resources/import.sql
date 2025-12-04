/* Población de la tabla productos */
INSERT INTO productos (id_producto, nombre, marca, modelo, tipo, precio_venta, cantidad_stock, precio_viejo) VALUES (1, 'Elden Ring', 'Bandai Namco', 'Standard Edition', 'videojuego', 300, 1000, 250);
INSERT INTO productos (id_producto, nombre, marca, modelo, tipo, precio_venta, cantidad_stock, precio_viejo) VALUES (2, 'The Legend of Zelda: Breath of the Wild', 'Nintendo', 'Standard Edition', 'videojuego', 300, 500, 275);
INSERT INTO productos (id_producto, nombre, marca, modelo, tipo, precio_venta, cantidad_stock, precio_viejo) VALUES (3, 'God of War', 'Sony', 'Deluxe Edition', 'videojuego', 300, 800, 290);
INSERT INTO productos (id_producto, nombre, marca, modelo, tipo, precio_venta, cantidad_stock, precio_viejo) VALUES (4, 'Red Dead Redemption 2', 'Rockstar Games', 'Ultimate Edition', 'videojuego', 300, 1000, 280);
INSERT INTO productos (id_producto, nombre, marca, modelo, tipo, precio_venta, cantidad_stock, precio_viejo) VALUES (5, 'The Witcher 3: Wild Hunt', 'CD Projekt Red', 'Game of the Year Edition', 'videojuego', 300, 1200, 260);
INSERT INTO productos (id_producto, nombre, marca, modelo, tipo, precio_venta, cantidad_stock, precio_viejo) VALUES (6, 'Horizon Zero Dawn', 'Guerrilla Games', 'Complete Edition', 'videojuego', 300, 900, 240);
INSERT INTO productos (id_producto, nombre, marca, modelo, tipo, precio_venta, cantidad_stock, precio_viejo) VALUES (7, 'Cyberpunk 2077', 'CD Projekt Red', 'Collector\s Edition', 'videojuego', 300, 600, 295);
INSERT INTO productos (id_producto, nombre, marca, modelo, tipo, precio_venta, cantidad_stock, precio_viejo) VALUES (8, 'Super Mario Odyssey', 'Nintendo', 'Standard Edition', 'videojuego', 300, 700, 270);
INSERT INTO productos (id_producto, nombre, marca, modelo, tipo, precio_venta, cantidad_stock, precio_viejo) VALUES (9, 'Assassin\'s Creed Valhalla', 'Ubisoft', 'Gold Edition', 'videojuego', 300, 1100, 265);
INSERT INTO productos (id_producto, nombre, marca, modelo, tipo, precio_venta, cantidad_stock, precio_viejo) VALUES (10, 'FIFA 23', 'EA Sports', 'Standard Edition', 'videojuego', 300, 1500, 310);
INSERT INTO productos (id_producto, nombre, marca, modelo, tipo, precio_venta, cantidad_stock, precio_viejo) VALUES (11, 'Call of Duty: Modern Warfare II', 'Activision', 'Standard Edition', 'videojuego', 300, 2000, 320);
INSERT INTO productos (id_producto, nombre, marca, modelo, tipo, precio_venta, cantidad_stock, precio_viejo) VALUES (12, 'Ghost of Tsushima', 'Sony', 'Director\'s Cut', 'videojuego', 300, 850, 295);
INSERT INTO productos (id_producto, nombre, marca, modelo, tipo, precio_venta, cantidad_stock, precio_viejo) VALUES (13, 'Fortnite', 'Epic Games', 'Battle Royale Edition', 'videojuego', 300, 3000, 200);

/* Población de la tabla Usuarios */
INSERT INTO usuarios (id, nombre, correo, contraseña, funcion) VALUES(15, 'Fabio', 'fabio@gmail.com','tupapi3', 'admin');
INSERT INTO usuarios (id, nombre, correo, contraseña, funcion) VALUES(16, 'brandon', 'brandon@gmail.com','vengador3', 'marketing');

/* Población de la tabla de campañas */
INSERT INTO campañas (id, nombre_campaña, descripcion, meta_ventas, fec_inicio, fec_fin, segmento_geografico, fecha_creacion, dist) VALUES (100, 'HALLOWEEN', '2X1', '50', '2024-10-04', '2024-12-05', 'Lima', '2024-10-09', 'La Molina');
INSERT INTO campañas (id, nombre_campaña, descripcion, meta_ventas, fec_inicio, fec_fin, segmento_geografico, fecha_creacion, dist) VALUES (101, 'VERANO CALUROSO', 'Descuentos en bebidas', '100', '2024-12-01', '2025-02-28', 'Lima', '2024-11-01', 'Miraflores');
INSERT INTO campañas (id, nombre_campaña, descripcion, meta_ventas, fec_inicio, fec_fin, segmento_geografico, fecha_creacion, dist) VALUES (102, 'INVIERNO FRÍO', 'Ropa de abrigo al 30%', '200', '2024-06-01', '2024-08-31', 'Cusco', '2024-05-15', 'San Isidro');
INSERT INTO campañas (id, nombre_campaña, descripcion, meta_ventas, fec_inicio, fec_fin, segmento_geografico, fecha_creacion, dist) VALUES (103, 'BLACK FRIDAY', 'Ofertas en electrónica', '300', '2024-11-22', '2024-11-24', 'Todo el país', '2024-10-30', 'Lima Centro');
INSERT INTO campañas (id, nombre_campaña, descripcion, meta_ventas, fec_inicio, fec_fin, segmento_geografico, fecha_creacion, dist) VALUES (104, 'NAVIDAD MÁGICA', 'Descuentos en juguetes', '150', '2024-12-15', '2024-12-25', 'Lima y Arequipa', '2024-12-01', 'La Molina');
INSERT INTO campañas (id, nombre_campaña, descripcion, meta_ventas, fec_inicio, fec_fin, segmento_geografico, fecha_creacion, dist) VALUES (105, 'AÑO NUEVO', 'Ofertas en decoración de fiesta', '80', '2024-12-26', '2025-01-01', 'Todo el país', '2024-12-10', 'Surco');
INSERT INTO campañas (id, nombre_campaña, descripcion, meta_ventas, fec_inicio, fec_fin, segmento_geografico, fecha_creacion, dist) VALUES (106, 'SEMANA SANTA', 'Ofertas de viajes', '70', '2025-03-25', '2025-04-01', 'Ica', '2025-03-01', 'Barranco');
INSERT INTO campañas (id, nombre_campaña, descripcion, meta_ventas, fec_inicio, fec_fin, segmento_geografico, fecha_creacion, dist) VALUES (107, 'DÍA DEL GAMER', 'Descuento en videojuegos', '120', '2024-08-01', '2024-08-31', 'Todo el país', '2024-07-15', 'La Molina');


/* Población de la tabla clientes */
INSERT INTO clientes(id, nombre, apellido, email, contra)	VALUES(99, 'Elliot', 'Saavedra', 'springboot@gmail.com', '123');


