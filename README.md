Sistema Educativo 

Descripción General

*****************************************************************************************************************************************************************************************************************************************************************************
Este proyecto es un sistema integral de gestión educativa desarrollado con un backend en Java Spring Boot y un frontend en ReactJS. Permite la administración de usuarios, roles y permisos, así como la gestión de estudiantes, cursos, carreras, grados, horarios y otros aspectos clave de un entorno educativo. El sistema está diseñado para facilitar la administración de un centro educativo, mejorando la eficiencia y la experiencia del usuario.

Tecnologías Utilizadas

Backend

Java 17

Spring Boot (con dependencias como Spring Data MongoDB, Spring Web, etc.)

MongoDB como base de datos

Maven como herramienta de gestión de dependencias

Frontend

ReactJS

Axios para las peticiones HTTP

Bootstrap para el diseño responsivo y componentes UI

React Router para la navegación

Estructura del Proyecto

Backend

La estructura del proyecto en el backend sigue la arquitectura MVC, organizada en los siguientes paquetes:

/src
|-- /controller        // Controladores REST
|-- /service           // Lógica de negocio
|-- /model             // Modelos de datos
|-- /repository        // Repositorios de acceso a datos
|-- /configuration     // Configuraciones del proyecto

Archivos clave del backend:

UsuarioController.java: Controlador para la gestión de usuarios.

CentroEducativoController.java: Controlador para gestionar la información del centro educativo.

RolController.java: Controlador para la gestión de roles y permisos.

UsuarioService.java: Lógica de negocio para operaciones de usuario.

CentroEducativoService.java: Lógica de negocio para el centro educativo.

application.properties: Configuración de la conexión con MongoDB y otros ajustes de Spring.

Frontend

La estructura del frontend se organiza de la siguiente manera:

/src
|-- /components        // Componentes compartidos (Navbar, Sidebar, etc.)
|-- /pages             // Páginas de la aplicación
|-- /context           // Contextos de React para la gestión de estado global
|-- /routes            // Configuración de rutas protegidas y públicas
|-- /api               // Configuración de Axios para llamadas HTTP

Archivos clave del frontend:

Navbar.js: Componente de navegación principal con enlaces dinámicos según permisos del usuario.

AppRoutes.js: Configuración de rutas protegidas y públicas.

AuthContext.js: Contexto de autenticación para manejar sesiones de usuario y permisos.

Usuarios.js: Página para la gestión de usuarios.

Carreras.js, Grados.js, Horarios.js: Páginas para la gestión de diferentes aspectos del sistema educativo.

Instalación y Configuración

Requisitos previos

Java 17

Node.js (v14 o superior)

Maven

MongoDB

Instrucciones para el Backend

Clonar el repositorio.

Importar el proyecto en un IDE como IntelliJ IDEA o Eclipse.

Configurar application.properties con la URL de tu base de datos MongoDB local o en la nube.

Ejecutar el proyecto con mvn spring-boot:run o desde el IDE.

Configuración de application.properties:

spring.data.mongodb.uri=mongodb://localhost:27017/sistema_educativo
server.port=8080

Instrucciones para el Frontend

Clonar el repositorio del frontend.

Instalar las dependencias con npm install.

Configurar el archivo axiosConfig.js con la URL base del backend.

Ejecutar el proyecto con npm start.

Configuración de axiosConfig.js:

import axios from 'axios';

const instance = axios.create({
  baseURL: 'http://localhost:8080/api',
});

export default instance;

*/Características del Sistema/*

-  Módulo de Autenticación y Autorización

Autenticación de usuarios con control de permisos.

Implementación de roles: administrador, catedrático, estudiante y personal administrativo.

-  Gestor de Usuarios y Roles

Creación, edición y eliminación de usuarios.

Asignación de roles a usuarios y definición de permisos personalizados.

-  Gestor de Centro Educativo

Registro y edición de la información del centro educativo, incluyendo ubicación y directivos.

-  Módulo de Estudiantes

Registro y edición de estudiantes.

Asignación de estudiantes a carreras, grados y cursos.

-  Gestor de Cursos, Salones y Horarios

Creación y gestión de cursos, salones y horarios para optimizar la organización.

-  Pagos e Inscripciones

Módulo de pagos con distintos métodos de pago.

Registro de inscripciones y matrículas.
