// /src/pages/AdminDashboard.js
import { Link } from 'react-router-dom';

const AdminDashboard = () => {
  return (
    <div className="container mt-5">
      <h2>Panel de Administración</h2>
      <div className="list-group">
        <Link className="list-group-item list-group-item-action" to="/admin/usuarios">
          Gestión de Usuarios
        </Link>
        <Link className="list-group-item list-group-item-action" to="/admin/roles">
          Gestión de Roles y Permisos
        </Link>
        <Link className="list-group-item list-group-item-action" to="/admin/inscripciones">
          Gestión de Inscripciones
        </Link>
        <Link className="list-group-item list-group-item-action" to="/admin/pagos">
          Gestión de Pagos
        </Link>
        <Link className="list-group-item list-group-item-action" to="/admin/reportes">
          Reportes Administrativos
        </Link>
      </div>
    </div>
  );
};

export default AdminDashboard;
