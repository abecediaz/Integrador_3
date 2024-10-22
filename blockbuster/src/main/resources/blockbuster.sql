CREATE DATABASE blockbuster;
USE blockbuster;

/*CARRITOS*/
CREATE TABLE carritos (
    id_carritos BIGINT AUTO_INCREMENT PRIMARY KEY
);

/*CLIENTES*/
CREATE TABLE clientes (
    id_clientes BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(255) UNIQUE,
    contrasenia VARCHAR(255) NOT NULL,
    id_carritos BIGINT,
    FOREIGN KEY (id_carritos) REFERENCES carritos(id_carritos) ON DELETE CASCADE
);

/*PELICULAS*/
CREATE TABLE peliculas (
    id_peliculas BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo_peliculas VARCHAR(255) NOT NULL,
    descripcion_peliculas TEXT,
    genero_peliculas VARCHAR(100),
    precio_peliculas DECIMAL(10, 2) NOT NULL,
    portada_peliculas VARCHAR(255) NOT NULL
);

/*ITEMS_CARRITOS*/
CREATE TABLE items_carritos (
    id_items_carritos BIGINT AUTO_INCREMENT PRIMARY KEY,
    cantidad_items_carritos INT NOT NULL,
    id_carritos BIGINT,
    id_peliculas BIGINT,
    FOREIGN KEY (id_carritos) REFERENCES carritos(id_carritos) ON DELETE CASCADE,
    FOREIGN KEY (id_peliculas) REFERENCES peliculas(id_peliculas) ON DELETE CASCADE
);

/*ORDENES*/
CREATE TABLE ordenes (
    id_ordenes BIGINT AUTO_INCREMENT PRIMARY KEY,
    monto_total DECIMAL(10, 2) NOT NULL,
    id_clientes BIGINT,
    FOREIGN KEY (id_clientes) REFERENCES clientes(id_clientes) ON DELETE CASCADE
);

/*ITEMS_ORDENES*/
CREATE TABLE items_ordenes (
    id_items_ordenes BIGINT AUTO_INCREMENT PRIMARY KEY,
    cantidad_items_ordenes INT NOT NULL,
    precio_items_ordenes DECIMAL(10, 2) NOT NULL,
    id_ordenes BIGINT,
    id_peliculas BIGINT,
    FOREIGN KEY (id_ordenes) REFERENCES ordenes(id_ordenes) ON DELETE CASCADE,
    FOREIGN KEY (id_peliculas) REFERENCES peliculas(id_peliculas) ON DELETE CASCADE
);

INSERT INTO peliculas (titulo_peliculas, descripcion_peliculas, genero_peliculas, precio_peliculas, portada_peliculas)
VALUES
	("Back to the Future", "Ciencia Ficción", "Un adolescente viaja al pasado en un DeLorean.", 9.99, "back_to_the_future.jpg"),
	("The Terminator", "Acción", "Un cyborg viaja desde el futuro para asesinar a una mujer clave.", 8.99, "the_terminator.jpg"),
	("Jurassic Park", "Aventura", "Dinosaurs are brought back to life in a theme park.", 10.99, "jurassic_park.jpg"),
	("The Matrix", "Ciencia Ficción", "Un hacker descubre la realidad simulada.", 12.99, "the_matrix.jpg"),
	("Pulp Fiction", "Crimen", "Historias entrelazadas de crimen en Los Ángeles.", 11.99, "pulp_fiction.jpg"),
	("Die Hard", "Acción", "Un oficial de policía lucha contra terroristas en un rascacielos.", 9.49, "die_hard.jpg"),
	("Forrest Gump", "Drama", "La vida extraordinaria de un hombre con un corazón puro.", 10.49, "forrest_gump.jpg"),
	("The Lion King", "Animación", "El viaje de un joven león para convertirse en rey.", 8.49, "the_lion_king.jpg"),
	("Terminator 2: Judgment Day", "Acción", "El cyborg regresa para proteger a un joven.", 13.99, "terminator_2.jpg"),
	("Fight Club", "Drama", "Un hombre forma un club de lucha clandestino.", 11.49, "fight_club.jpg");