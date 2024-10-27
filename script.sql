-- Tabla de Empleados
CREATE TABLE Empleados (
    id_empleado SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    cargo cargo_empleado NOT NULL,
    fecha_contratacion DATE NOT NULL,
    salario DECIMAL(10, 2) NOT NULL,
    id_sede INT,
    FOREIGN KEY (id_sede) REFERENCES Sedes(id_sede) ON DELETE SET NULL
);

-- Tabla de Usuarios
CREATE TABLE Usuarios (
    id_usuario SERIAL PRIMARY KEY,
    id_empleado INT,
    nombre_usuario VARCHAR(50) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    rol cargo_empleado NOT NULL,  -- Utilizando el mismo ENUM para roles
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
    total DECIMAL(10, 2) GENERATED ALWAYS AS (total_efectivo + total_tarjeta + total_transferencia) STORED,
    FOREIGN KEY (id_cajero) REFERENCES Empleados(id_empleado) ON DELETE SET NULL,
    FOREIGN KEY (id_sede) REFERENCES Sedes(id_sede) ON DELETE SET NULL
);

-- Tabla de Reportes
CREATE TABLE Reportes (
    id_reporte SERIAL PRIMARY KEY,
    tipo_reporte tipo_reporte NOT NULL,
    id_sede INT,
    fecha_generacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ruta_archivo VARCHAR(255),
    FOREIGN KEY (id_sede) REFERENCES Sedes(id_sede) ON DELETE SET NULL
);
