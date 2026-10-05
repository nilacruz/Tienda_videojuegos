
DROP DATABASE IF EXISTS tiendajuegos;
CREATE DATABASE tiendajuegos CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE tiendajuegos;

-- ---------- Tablas base ----------

CREATE TABLE Usuario (
    Id_Usuario INT NOT NULL AUTO_INCREMENT,
    Nombre     VARCHAR(100) NOT NULL,
    Correo     VARCHAR(100) NOT NULL UNIQUE,
    Telefono   VARCHAR(15),
    Password   VARCHAR(300) NOT NULL,
    PRIMARY KEY (Id_Usuario)
) ENGINE=InnoDB;

CREATE TABLE Desarrollador (
    Id_Desarrollador INT NOT NULL AUTO_INCREMENT,
    Nombre           VARCHAR(150) NOT NULL,
    SitioWeb         VARCHAR(255),
    PRIMARY KEY (Id_Desarrollador)
) ENGINE=InnoDB;

CREATE TABLE Categoria (
    Id_categoria INT NOT NULL AUTO_INCREMENT,
    Nombre       VARCHAR(100) NOT NULL,
    PRIMARY KEY (Id_categoria)
) ENGINE=InnoDB;

CREATE TABLE Metodo_de_Pago (
    Id_MPago INT NOT NULL AUTO_INCREMENT,
    Nombre   VARCHAR(50) NOT NULL,
    Activo   TINYINT(1) NOT NULL DEFAULT 1,
    PRIMARY KEY (Id_MPago)
) ENGINE=InnoDB;

-- ---------- Producto ----------

CREATE TABLE Producto (
    Id_producto      INT NOT NULL AUTO_INCREMENT,
    Id_Desarrollador INT NOT NULL,
    Nombre           VARCHAR(150) NOT NULL,
    Descripcion      TEXT,
    Precio           DECIMAL(10,2) NOT NULL,
    Img              VARCHAR(255),
    Especificaciones JSON,
    `AñoEmision`     YEAR,
    PRIMARY KEY (Id_producto),
    CONSTRAINT fk_producto_desarrollador
        FOREIGN KEY (Id_Desarrollador) REFERENCES Desarrollador (Id_Desarrollador)
        ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB;

CREATE TABLE Producto_Categoria (
    Id_producto  INT NOT NULL,
    Id_categoria INT NOT NULL,
    PRIMARY KEY (Id_producto, Id_categoria),
    CONSTRAINT fk_pc_producto
        FOREIGN KEY (Id_producto) REFERENCES Producto (Id_producto)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_pc_categoria
        FOREIGN KEY (Id_categoria) REFERENCES Categoria (Id_categoria)
        ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB;

-- ---------- Relaciones Usuario - Producto ----------

CREATE TABLE Deseados (
    Id_usuario     INT NOT NULL,
    Id_producto    INT NOT NULL,
    Fecha_Agregado DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (Id_usuario, Id_producto),
    CONSTRAINT fk_deseados_usuario
        FOREIGN KEY (Id_usuario) REFERENCES Usuario (Id_Usuario)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_deseados_producto
        FOREIGN KEY (Id_producto) REFERENCES Producto (Id_producto)
        ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE Biblioteca (
    Id_usuario    INT NOT NULL,
    Id_producto   INT NOT NULL,
    Fecha_compra  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    Precio_pagado DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (Id_usuario, Id_producto),
    CONSTRAINT fk_biblioteca_usuario
        FOREIGN KEY (Id_usuario) REFERENCES Usuario (Id_Usuario)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_biblioteca_producto
        FOREIGN KEY (Id_producto) REFERENCES Producto (Id_producto)
        ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE Carrito (
    Id_usuario  INT NOT NULL,
    Id_producto INT NOT NULL,
    Cantidad    INT NOT NULL DEFAULT 1,
    PRIMARY KEY (Id_usuario, Id_producto),
    CONSTRAINT fk_carrito_usuario
        FOREIGN KEY (Id_usuario) REFERENCES Usuario (Id_Usuario)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_carrito_producto
        FOREIGN KEY (Id_producto) REFERENCES Producto (Id_producto)
        ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE Resenas (
    Id_resena      INT NOT NULL AUTO_INCREMENT,
    Id_usuario     INT NOT NULL,
    Id_producto    INT NOT NULL,
    Recomendacion  TINYINT(1) NOT NULL,
    Comentario     TEXT,
    Horas_jugadas  DECIMAL(8,2),
    Fecha          DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (Id_resena),
    CONSTRAINT fk_resenas_usuario
        FOREIGN KEY (Id_usuario) REFERENCES Usuario (Id_Usuario)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_resenas_producto
        FOREIGN KEY (Id_producto) REFERENCES Producto (Id_producto)
        ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB;

-- ---------- Amigos ----------

CREATE TABLE Amigos (
    Id_usuario      INT NOT NULL,
    Id_amigo        INT NOT NULL,
    fecha_conexion  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (Id_usuario, Id_amigo),
    CONSTRAINT fk_amigos_usuario
        FOREIGN KEY (Id_usuario) REFERENCES Usuario (Id_Usuario)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_amigos_amigo
        FOREIGN KEY (Id_amigo) REFERENCES Usuario (Id_Usuario)
        ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB;

-- ---------- Órdenes y pagos ----------

CREATE TABLE Orden (
    Id_Orden   INT NOT NULL AUTO_INCREMENT,
    Id_Usuario INT NOT NULL,
    Fecha      DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    total      DECIMAL(10,2) NOT NULL DEFAULT 0,
    PRIMARY KEY (Id_Orden),
    CONSTRAINT fk_orden_usuario
        FOREIGN KEY (Id_Usuario) REFERENCES Usuario (Id_Usuario)
        ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB;

CREATE TABLE Detalle_de_Orden (
    Id_Detalle  INT NOT NULL AUTO_INCREMENT,
    Id_Orden    INT NOT NULL,
    Id_Producto INT NOT NULL,
    Cantidad    INT NOT NULL DEFAULT 1,
    Precio      DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (Id_Detalle),
    CONSTRAINT fk_detalle_orden
        FOREIGN KEY (Id_Orden) REFERENCES Orden (Id_Orden)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_detalle_producto
        FOREIGN KEY (Id_Producto) REFERENCES Producto (Id_producto)
        ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB;

CREATE TABLE Transaccion (
    Id_transaccion     INT NOT NULL AUTO_INCREMENT,
    Id_Orden           INT NOT NULL,
    Id_Metodo          INT NOT NULL,
    Monto              DECIMAL(10,2) NOT NULL,
    Fecha_Transaccion  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    Estado             VARCHAR(20) NOT NULL DEFAULT 'Pendiente',
    PRIMARY KEY (Id_transaccion),
    CONSTRAINT fk_transaccion_orden
        FOREIGN KEY (Id_Orden) REFERENCES Orden (Id_Orden)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_transaccion_metodo
        FOREIGN KEY (Id_Metodo) REFERENCES Metodo_de_Pago (Id_MPago)
        ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB;