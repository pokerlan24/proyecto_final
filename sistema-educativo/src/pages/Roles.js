// /src/pages/Roles.js
import { useEffect, useState } from 'react';
import axios from '../api/axiosConfig';

const Roles = () => {
  const [roles, setRoles] = useState([]);
  const [nuevoRol, setNuevoRol] = useState({ nombre: '', permisos: [] });
  const [permisos, setPermisos] = useState('');
  const [error, setError] = useState(null);

  // Función para obtener la lista de roles desde el backend
  const obtenerRoles = async () => {
    try {
      const response = await axios.get('/roles');
      setRoles(response.data);
    } catch (err) {
      setError('Error al obtener roles. Verifica la conexión.');
      console.error(err);
    }
  };

  // Función para manejar el envío del formulario y crear un nuevo rol
  const manejarSubmit = async (e) => {
    e.preventDefault();
    try {
      const permisosArray = permisos.split(',').map((permiso) => permiso.trim());
      const rolCreado = await axios.post('/roles/crear', { ...nuevoRol, permisos: permisosArray });
      setRoles([...roles, rolCreado.data]);
      setNuevoRol({ nombre: '', permisos: [] });
      setPermisos('');
    } catch (err) {
      setError('Error al crear rol.');
      console.error(err);
    }
  };

  // Función para eliminar un rol
  const eliminarRol = async (id) => {
    try {
      await axios.delete(`/roles/${id}`);
      setRoles(roles.filter((rol) => rol.id !== id));
    } catch (err) {
      setError('Error al eliminar rol.');
      console.error(err);
    }
  };

  useEffect(() => {
    obtenerRoles();
  }, []);

  return (
    <div className="container mt-5">
      <h2>Gestión de Roles y Permisos</h2>
      <form onSubmit={manejarSubmit} className="mb-4">
        <div className="mb-3">
          <label>Nombre del Rol</label>
          <input
            type="text"
            className="form-control"
            value={nuevoRol.nombre}
            onChange={(e) => setNuevoRol({ ...nuevoRol, nombre: e.target.value })}
            required
          />
        </div>
        <div className="mb-3">
          <label>Permisos (separados por coma)</label>
          <input
            type="text"
            className="form-control"
            value={permisos}
            onChange={(e) => setPermisos(e.target.value)}
            placeholder="ej. gestionar_usuarios, ver_reportes"
          />
        </div>
        <button type="submit" className="btn btn-primary">Crear Rol</button>
      </form>

      {error && <div className="alert alert-danger">{error}</div>}

      <h3>Lista de Roles</h3>
      <ul className="list-group">
        {roles.map((rol) => (
          <li key={rol.id} className="list-group-item d-flex justify-content-between align-items-center">
            <div>
              <strong>{rol.nombre}</strong>
              <p>Permisos: {rol.permisos.join(', ')}</p>
            </div>
            <button className="btn btn-danger" onClick={() => eliminarRol(rol.id)}>
              Eliminar
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Roles;
