// /src/pages/Usuarios.js
import { useEffect, useState } from 'react';
import axios from '../api/axiosConfig';

const Usuarios = () => {
  const [usuarios, setUsuarios] = useState([]);
  const [roles, setRoles] = useState([]); // Nuevo estado para los roles
  const [form, setForm] = useState({ nombre: '', email: '', rol_id: '', contraseña: '' });
  const [error, setError] = useState(null);
  const [cargando, setCargando] = useState(true);
  const [editando, setEditando] = useState(false);
  const [usuarioId, setUsuarioId] = useState(null);

  // Obtener usuarios
  const obtenerUsuarios = async () => {
    try {
      const response = await axios.get('/usuarios');
      setUsuarios(response.data);
    } catch (err) {
      setError('Error al obtener usuarios. Verifica la conexión.');
    } finally {
      setCargando(false);
    }
  };

  // Obtener roles
  const obtenerRoles = async () => {
    try {
      const response = await axios.get('/roles');
      setRoles(response.data);
    } catch (err) {
      setError('Error al obtener roles. Verifica la conexión.');
    }
  };

  useEffect(() => {
    obtenerUsuarios();
    obtenerRoles(); // Cargar roles al inicio
  }, []);

  // Crear o actualizar usuario
  const manejarSubmit = async (e) => {
    e.preventDefault();
    try {
      if (editando) {
        await axios.put(`/usuarios/${usuarioId}`, form);
      } else {
        await axios.post('/usuarios/registrar', form);
      }
      obtenerUsuarios();
      reiniciarFormulario();
    } catch (err) {
      setError('Error al guardar usuario.');
    }
  };

  // Eliminar usuario
  const eliminarUsuario = async (id) => {
    try {
      await axios.delete(`/usuarios/${id}`);
      setUsuarios(usuarios.filter((usuario) => usuario.id !== id));
    } catch (err) {
      setError('Error al eliminar usuario.');
    }
  };

  // Cargar datos en el formulario para edición
  const cargarUsuario = (usuario) => {
    setForm(usuario);
    setUsuarioId(usuario.id);
    setEditando(true);
  };

  // Reiniciar formulario después de crear o editar
  const reiniciarFormulario = () => {
    setForm({ nombre: '', email: '', rol_id: '', contraseña: '' });
    setEditando(false);
    setUsuarioId(null);
  };

  if (cargando) return <div>Cargando usuarios...</div>;
  if (error) return <div className="alert alert-danger">{error}</div>;

  return (
    <div className="container mt-5">
      <h2>{editando ? 'Editar Usuario' : 'Crear Usuario'}</h2>
      <form onSubmit={manejarSubmit}>
        <div className="mb-3">
          <label>Nombre</label>
          <input
            type="text"
            className="form-control"
            value={form.nombre}
            onChange={(e) => setForm({ ...form, nombre: e.target.value })}
            required
          />
        </div>
        <div className="mb-3">
          <label>Email</label>
          <input
            type="email"
            className="form-control"
            value={form.email}
            onChange={(e) => setForm({ ...form, email: e.target.value })}
            required
          />
        </div>
        <div className="mb-3">
          <label>Rol</label>
          <select
            className="form-control"
            value={form.rol_id}
            onChange={(e) => setForm({ ...form, rol_id: e.target.value })}
            required
          >
            <option value="">Selecciona un rol</option>
            {roles.map((rol) => (
              <option key={rol.id} value={rol.id}>{rol.nombre}</option>
            ))}
          </select>
        </div>
        <div className="mb-3">
          <label>Contraseña</label>
          <input
            type="password"
            className="form-control"
            value={form.contraseña}
            onChange={(e) => setForm({ ...form, contraseña: e.target.value })}
            required
          />
        </div>
        <button type="submit" className="btn btn-primary">
          {editando ? 'Guardar Cambios' : 'Crear Usuario'}
        </button>
        {editando && (
          <button type="button" className="btn btn-secondary ms-2" onClick={reiniciarFormulario}>
            Cancelar
          </button>
        )}
      </form>

      <h2 className="mt-5">Lista de Usuarios</h2>
      <table className="table table-striped">
        <thead>
          <tr>
            <th>Nombre</th>
            <th>Email</th>
            <th>Rol</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          {usuarios.length === 0 ? (
            <tr>
              <td colSpan="4">No hay usuarios registrados.</td>
            </tr>
          ) : (
            usuarios.map((usuario) => (
              <tr key={usuario.id}>
                <td>{usuario.nombre}</td>
                <td>{usuario.email}</td>
                <td>{roles.find((rol) => rol.id === usuario.rol_id)?.nombre || 'Desconocido'}</td>
                <td>
                  <button
                    className="btn btn-warning me-2"
                    onClick={() => cargarUsuario(usuario)}
                  >
                    Editar
                  </button>
                  <button
                    className="btn btn-danger"
                    onClick={() => eliminarUsuario(usuario.id)}
                  >
                    Eliminar
                  </button>
                </td>
              </tr>
            ))
          )}
        </tbody>
      </table>
    </div>
  );
};

export default Usuarios;
