// /src/routes/AppRoutes.js
import { Routes, Route, Navigate } from 'react-router-dom';
import Home from '../pages/Home';
import LoginPage from '../pages/LoginPage';
import ProtectedRoute from './ProtectedRoute';
import AdminDashboard from '../pages/AdminDashboard';
import Usuarios from '../pages/Usuarios';
import Roles from '../pages/Roles';
import CentroEducativo from '../pages/CentroEducativo';
import Personal from '../pages/Personal';
import Estudiantes from '../pages/Estudiantes';
import Cursos from '../pages/Cursos';
import Salones from '../pages/Salones';
import Horarios from '../pages/Horarios';
import Jornadas from '../pages/Jornadas';
import Carreras from '../pages/Carreras';
import Grados from '../pages/Grados';
import InscripcionesAdmin from '../pages/InscripcionesAdmin';
import PagosAdmin from '../pages/PagosAdmin';
import Reportes from '../pages/Reportes';

const AppRoutes = () => (
  <Routes>
    <Route path="/" element={<Home />} />
    <Route path="/login" element={<LoginPage />} />

    {/* Rutas protegidas con permisos definidos */}
    <Route
      path="/admin"
      element={
        <ProtectedRoute permission="VER_PANEL_ADMIN">
          <AdminDashboard />
        </ProtectedRoute>
      }
    />
    <Route
      path="/admin/usuarios"
      element={
        <ProtectedRoute permission="VER_USUARIOS">
          <Usuarios />
        </ProtectedRoute>
      }
    />
    <Route
      path="/admin/roles"
      element={
        <ProtectedRoute permission="GESTIONAR_ROLES">
          <Roles />
        </ProtectedRoute>
      }
    />
    <Route
      path="/admin/centro-educativo"
      element={
        <ProtectedRoute permission="GESTIONAR_CENTRO_EDUCATIVO">
          <CentroEducativo />
        </ProtectedRoute>
      }
    />
    <Route
      path="/admin/personal"
      element={
        <ProtectedRoute permission="GESTIONAR_PERSONAL">
          <Personal />
        </ProtectedRoute>
      }
    />
    <Route
      path="/admin/estudiantes"
      element={
        <ProtectedRoute permission="GESTIONAR_ESTUDIANTES">
          <Estudiantes />
        </ProtectedRoute>
      }
    />
    <Route
      path="/admin/cursos"
      element={
        <ProtectedRoute permission="GESTIONAR_CURSOS">
          <Cursos />
        </ProtectedRoute>
      }
    />
    <Route
      path="/admin/salones"
      element={
        <ProtectedRoute permission="GESTIONAR_SALONES">
          <Salones />
        </ProtectedRoute>
      }
    />
    <Route
      path="/admin/horarios"
      element={
        <ProtectedRoute permission="GESTIONAR_HORARIOS">
          <Horarios />
        </ProtectedRoute>
      }
    />
    <Route
      path="/admin/jornadas"
      element={
        <ProtectedRoute permission="GESTIONAR_JORNADAS">
          <Jornadas />
        </ProtectedRoute>
      }
    />
    <Route
      path="/admin/carreras"
      element={
        <ProtectedRoute permission="GESTIONAR_CARRERAS">
          <Carreras />
        </ProtectedRoute>
      }
    />
    <Route
      path="/admin/grados"
      element={
        <ProtectedRoute permission="GESTIONAR_GRADOS">
          <Grados />
        </ProtectedRoute>
      }
    />
    <Route
      path="/admin/inscripciones"
      element={
        <ProtectedRoute permission="GESTIONAR_INSCRIPCIONES">
          <InscripcionesAdmin />
        </ProtectedRoute>
      }
    />
    <Route
      path="/admin/pagos"
      element={
        <ProtectedRoute permission="GESTIONAR_PAGOS">
          <PagosAdmin />
        </ProtectedRoute>
      }
    />
    <Route
      path="/admin/reportes"
      element={
        <ProtectedRoute permission="VER_REPORTES">
          <Reportes />
        </ProtectedRoute>
      }
    />

    {/* Redirección por defecto si la ruta no existe */}
    <Route path="*" element={<Navigate to="/" />} />
  </Routes>
);

export default AppRoutes;
