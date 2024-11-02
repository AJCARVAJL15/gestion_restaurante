-- Crear tipo de dato ENUM para tipo de sede, estado, cargo y rol
-- En MySQL se definen directamente en las columnas

-- Tabla de Sedes
CREATE TABLE Sedes (
    id_sede INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    ubicacion VARCHAR(255) NOT NULL,
    tipo ENUM('Propia', 'Franquicia') NOT NULL,
    estado ENUM('Operativa', 'En mantenimiento', 'Cerrada') DEFAULT 'Operativa',
    fecha_apertura DATE NOT NULL,
    telefono_contacto VARCHAR(20)
);

-- Tabla de Empleados
CREATE TABLE Empleados (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    cargo ENUM('Cajero', 'Administrador', 'Cocinero', 'Mesero', 'Gerente') NOT NULL,
    fecha_contratacion DATE NOT NULL,
    salario DECIMAL(10, 2) NOT NULL,
    id_sede INT,
    FOREIGN KEY (id_sede) REFERENCES Sedes(id_sede) ON DELETE SET NULL
);

-- Tabla de Usuarios (para el acceso al sistema)
CREATE TABLE Usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    id_empleado INT,
    nombre_usuario VARCHAR(50) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    rol ENUM('Cajero', 'Administrador', 'Gerente') NOT NULL,
    estado ENUM('Activo', 'Inactivo') DEFAULT 'Activo',
    FOREIGN KEY (id_empleado) REFERENCES Empleados(id_empleado) ON DELETE CASCADE
);

-- Tabla de Productos
CREATE TABLE Productos (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10, 2) NOT NULL,
    categoria VARCHAR(50),
    estado ENUM('Disponible', 'No disponible') DEFAULT 'Disponible'
);

-- Tabla de Ventas
CREATE TABLE Ventas (
    id_venta INT AUTO_INCREMENT PRIMARY KEY,
    id_sede INT NOT NULL,
    id_cajero INT NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10, 2) NOT NULL,
    metodo_pago ENUM('Efectivo', 'Tarjeta', 'Transferencia') NOT NULL,
    FOREIGN KEY (id_sede) REFERENCES Sedes(id_sede) ON DELETE CASCADE,
    FOREIGN KEY (id_cajero) REFERENCES Empleados(id_empleado) ON DELETE SET NULL
);

-- Tabla de Detalle de Ventas
CREATE TABLE DetalleVenta (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_venta INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    subtotal DECIMAL(10, 2) AS (cantidad * precio_unitario) STORED,
    FOREIGN KEY (id_venta) REFERENCES Ventas(id_venta) ON DELETE CASCADE,
    FOREIGN KEY (id_producto) REFERENCES Productos(id_producto) ON DELETE CASCADE
);

-- Tabla de Cierres de Caja
CREATE TABLE CierresCaja (
    id_cierre INT AUTO_INCREMENT PRIMARY KEY,
    id_cajero INT NOT NULL,
    id_sede INT NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_efectivo DECIMAL(10, 2),
    total_tarjeta DECIMAL(10, 2),
    total_transferencia DECIMAL(10, 2),
    total DECIMAL(10, 2) AS (COALESCE(total_efectivo, 0) + COALESCE(total_tarjeta, 0) + COALESCE(total_transferencia, 0)) STORED,
    FOREIGN KEY (id_cajero) REFERENCES Empleados(id_empleado) ON DELETE SET NULL,
    FOREIGN KEY (id_sede) REFERENCES Sedes(id_sede) ON DELETE SET NULL
);

-- Tabla de Reportes (almacena metadatos de reportes generados)
CREATE TABLE Reportes (
    id_reporte INT AUTO_INCREMENT PRIMARY KEY,
    tipo_reporte ENUM('Ventas', 'Inventario', 'Cierres de Caja', 'Contabilidad') NOT NULL,
    id_sede INT,
    fecha_generacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ruta_archivo VARCHAR(255),
    FOREIGN KEY (id_sede) REFERENCES Sedes(id_sede) ON DELETE SET NULL
);
