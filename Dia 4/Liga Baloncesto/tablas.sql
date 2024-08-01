create database bp45j8cowui6a1h1ho5z;

use bp45j8cowui6a1h1ho5z;

CREATE TABLE partidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    equipo_local VARCHAR(255) NOT NULL,
    equipo_visitante VARCHAR(255) NOT NULL,
    cestas_local INT DEFAULT 0,
    cestas_visitante INT DEFAULT 0,
    finalizado BOOLEAN DEFAULT FALSE,
    fecha DATE NOT NULL,
    tipo_partido ENUM('LIGA', 'PLAYOFF') NOT NULL,
    numero_jornada INT NULL,
    ronda VARCHAR(50) NULL
);
