-- Crear tipos de dato ENUM para tipo de sede, estado, cargo y rol
CREATE TYPE tipo_sede AS ENUM ('Propia', 'Franquicia');
CREATE TYPE estado_sede AS ENUM ('Operativa', 'En mantenimiento', 'Cerrada');
CREATE TYPE cargo_empleado AS ENUM ('Cajero', 'Administrador', 'Cocinero', 'Mesero', 'Gerente');
CREATE TYPE rol_usuario AS ENUM ('Cajero', 'Administrador', 'Gerente');
CREATE TYPE estado_usuario AS ENUM ('Activo', 'Inactivo');
CREATE TYPE estado_producto AS ENUM ('Disponible', 'No disponible');
CREATE TYPE metodo_pago AS ENUM ('Efectivo', 'Tarjeta', 'Transferencia');
CREATE TYPE tipo_reporte AS ENUM ('Ventas', 'Inventario', 'Cierres de Caja', 'Contabilidad');


-- Tabla de Sedes
CREATE TABLE Sedes (
                       id_sede SERIAL PRIMARY KEY,
                       nombre VARCHAR(100) NOT NULL,
                       ubicacion VARCHAR(255) NOT NULL,
                       tipo VARCHAR(20) NOT NULL,
                       estado VARCHAR(20) NOT NULL,
                       fecha_apertura DATE NOT NULL,
                       telefono_contacto VARCHAR(20)
);

-- Tabla de Empleados
CREATE TABLE Empleados (
                           id_empleado SERIAL PRIMARY KEY,
                           nombre VARCHAR(100) NOT NULL,
                           apellido VARCHAR(100) NOT NULL,
                           cargo VARCHAR(20) NOT NULL,
                           fecha_contratacion DATE NOT NULL,
                           salario DECIMAL(10, 2) NOT NULL,
                           id_sede INT,
                           FOREIGN KEY (id_sede) REFERENCES Sedes(id_sede) ON DELETE SET NULL
);

-- Tabla de Usuarios (para el acceso al sistema)
CREATE TABLE Usuarios (
                          id_usuario SERIAL PRIMARY KEY,
                          id_empleado INT,
                          nombre_usuario VARCHAR(50) UNIQUE NOT NULL,
                          contrasena VARCHAR(255) NOT NULL,
                          rol rol_usuario NOT NULL,
                          estado estado_usuario DEFAULT 'Activo',
                          FOREIGN KEY (id_empleado) REFERENCES Empleados(id_empleado) ON DELETE CASCADE
);

-- Tabla de Productos
CREATE TABLE Productos (
                           id_producto SERIAL PRIMARY KEY,
                           nombre VARCHAR(100) NOT NULL,
                           descripcion TEXT,
                           precio DECIMAL(10, 2) NOT NULL,
                           categoria VARCHAR(50),
                           estado estado_producto DEFAULT 'Disponible'
);

-- Tabla de Ventas
CREATE TABLE Ventas (
                        id_venta SERIAL PRIMARY KEY,
                        id_sede INT NOT NULL,
                        id_cajero INT NOT NULL,
                        fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        total DECIMAL(10, 2) NOT NULL,
                        metodo_pago metodo_pago NOT NULL,
                        FOREIGN KEY (id_sede) REFERENCES Sedes(id_sede) ON DELETE CASCADE,
                        FOREIGN KEY (id_cajero) REFERENCES Empleados(id_empleado) ON DELETE SET NULL
);

-- Tabla de Detalle de Ventas
CREATE TABLE DetalleVenta (
                              id_detalle SERIAL PRIMARY KEY,
                              id_venta INT NOT NULL,
                              id_producto INT NOT NULL,
                              cantidad INT NOT NULL,
                              precio_unitario DECIMAL(10, 2) NOT NULL,
                              subtotal DECIMAL(10, 2) GENERATED ALWAYS AS (cantidad * precio_unitario) STORED,
                              FOREIGN KEY (id_venta) REFERENCES Ventas(id_venta) ON DELETE CASCADE,
                              FOREIGN KEY (id_producto) REFERENCES Productos(id_producto) ON DELETE CASCADE
);

-- Tabla de Cierres de Caja
CREATE TABLE CierresCaja (
                             id_cierre SERIAL PRIMARY KEY,
                             id_cajero INT NOT NULL,
                             id_sede INT NOT NULL,
                             fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             total_efectivo DECIMAL(10, 2),
                             total_tarjeta DECIMAL(10, 2),
                             total_transferencia DECIMAL(10, 2),
                             total DECIMAL(10, 2) GENERATED ALWAYS AS (COALESCE(total_efectivo, 0) + COALESCE(total_tarjeta, 0) + COALESCE(total_transferencia, 0)) STORED,
                             FOREIGN KEY (id_cajero) REFERENCES Empleados(id_empleado) ON DELETE SET NULL,
                             FOREIGN KEY (id_sede) REFERENCES Sedes(id_sede) ON DELETE SET NULL
);

-- Tabla de Reportes (almacena metadatos de reportes generados)
CREATE TABLE Reportes (
                          id_reporte SERIAL PRIMARY KEY,
                          tipo_reporte tipo_reporte NOT NULL,
                          id_sede INT,
                          fecha_generacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          ruta_archivo VARCHAR(255),
                          FOREIGN KEY (id_sede) REFERENCES Sedes(id_sede) ON DELETE SET NULL
);

