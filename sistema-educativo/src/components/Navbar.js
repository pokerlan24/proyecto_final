// /src/components/Navbar.js
import { Link, useNavigate } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';
import './Navbar.css'; // Archivo de estilos para mejorar la apariencia

const Navbar = () => {
  const { user, logout } = useAuth();
  const navigate = useNavigate();

  const handleLogout = () => {
    logout();
    navigate('/login');
  };

  const tienePermiso = (permiso) => {
    return user?.permisos?.includes(permiso);
  };

  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
      <div className="container-fluid">
        <Link className="navbar-brand" to="/">
          Sistema Educativo
        </Link>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav me-auto mb-2 mb-lg-0">
            {tienePermiso('VER_PANEL_ADMIN') && (
              <li className="nav-item">
                <Link className="nav-link" to="/admin">
                  Panel Admin
                </Link>
              </li>
            )}
            {tienePermiso('VER_USUARIOS') && (
              <li className="nav-item">
                <Link className="nav-link" to="/admin/usuarios">
                  Gestión de Usuarios
                </Link>
              </li>
            )}
            {tienePermiso('GESTIONAR_ROLES') && (
              <li className="nav-item">
                <Link className="nav-link" to="/admin/roles">
                  Gestión de Roles y Permisos
                </Link>
              </li>
            )}
            {/* Dropdown para más opciones */}
            {(tienePermiso('GESTIONAR_CENTRO_EDUCATIVO') ||
              tienePermiso('GESTIONAR_PERSONAL') ||
              tienePermiso('GESTIONAR_ESTUDIANTES') ||
              tienePermiso('GESTIONAR_CURSOS') ||
              tienePermiso('GESTIONAR_SALONES') ||
              tienePermiso('GESTIONAR_HORARIOS') ||
              tienePermiso('GESTIONAR_JORNADAS') ||
              tienePermiso('GESTIONAR_CARRERAS') ||
              tienePermiso('GESTIONAR_GRADOS') ||
              tienePermiso('GESTIONAR_INSCRIPCIONES') ||
              tienePermiso('GESTIONAR_PAGOS') ||
              tienePermiso('VER_REPORTES')) && (
              <li className="nav-item dropdown">
                <Link
                  className="nav-link dropdown-toggle"
                  to="#"
                  id="navbarDropdown"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                >
                  Más opciones
                </Link>
                <ul className="dropdown-menu" aria-labelledby="navbarDropdown">
                  {tienePermiso('GESTIONAR_CENTRO_EDUCATIVO') && (
                    <li>
                      <Link className="dropdown-item" to="/admin/centro-educativo">
                        Centro Educativo
                      </Link>
                    </li>
                  )}
                  {tienePermiso('GESTIONAR_PERSONAL') && (
                    <li>
                      <Link className="dropdown-item" to="/admin/personal">
                        Gestión de Personal
                      </Link>
                    </li>
                  )}
                  {tienePermiso('GESTIONAR_ESTUDIANTES') && (
                    <li>
                      <Link className="dropdown-item" to="/admin/estudiantes">
                        Gestión de Estudiantes
                      </Link>
                    </li>
                  )}
                  {tienePermiso('GESTIONAR_CURSOS') && (
                    <li>
                      <Link className="dropdown-item" to="/admin/cursos">
                        Gestión de Cursos
                      </Link>
                    </li>
                  )}
                  {tienePermiso('GESTIONAR_SALONES') && (
                    <li>
                      <Link className="dropdown-item" to="/admin/salones">
                        Gestión de Salones
                      </Link>
                    </li>
                  )}
                  {tienePermiso('GESTIONAR_HORARIOS') && (
                    <li>
                      <Link className="dropdown-item" to="/admin/horarios">
                        Gestión de Horarios
                      </Link>
                    </li>
                  )}
                  {tienePermiso('GESTIONAR_JORNADAS') && (
                    <li>
                      <Link className="dropdown-item" to="/admin/jornadas">
                        Gestión de Jornadas
                      </Link>
                    </li>
                  )}
                  {tienePermiso('GESTIONAR_CARRERAS') && (
                    <li>
                      <Link className="dropdown-item" to="/admin/carreras">
                        Gestión de Carreras
                      </Link>
                    </li>
                  )}
                  {tienePermiso('GESTIONAR_GRADOS') && (
                    <li>
                      <Link className="dropdown-item" to="/admin/grados">
                        Gestión de Grados
                      </Link>
                    </li>
                  )}
                  {tienePermiso('GESTIONAR_INSCRIPCIONES') && (
                    <li>
                      <Link className="dropdown-item" to="/admin/inscripciones">
                        Gestión de Inscripciones
                      </Link>
                    </li>
                  )}
                  {tienePermiso('GESTIONAR_PAGOS') && (
                    <li>
                      <Link className="dropdown-item" to="/admin/pagos">
                        Gestión de Pagos
                      </Link>
                    </li>
                  )}
                  {tienePermiso('VER_REPORTES') && (
                    <li>
                      <Link className="dropdown-item" to="/admin/reportes">
                        Reportes Administrativos
                      </Link>
                    </li>
                  )}
                </ul>
              </li>
            )}
          </ul>
          <div className="d-flex">
            {user ? (
              <button className="btn btn-outline-light me-2" onClick={handleLogout}>
                Logout
              </button>
            ) : (
              <Link className="btn btn-primary" to="/login">
                Login
              </Link>
            )}
          </div>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
