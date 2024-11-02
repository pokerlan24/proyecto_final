// /src/pages/Personal.js
import { useEffect, useState } from 'react';
import axios from '../api/axiosConfig';

const Personal = () => {
  const [personal, setPersonal] = useState([]);
  const [form, setForm] = useState({ nombre: '', puesto: '', especializacion: '', horario: '' });
  const [error, setError] = useState(null);
  const [cargando, setCargando] = useState(true);
  const [editando, setEditando] = useState(false);
  const [personalId, setPersonalId] = useState(null);

  // Obtener todo el personal
  const obtenerPersonal = async () => {
    try {
      const response = await axios.get('/personal');
      setPersonal(response.data);
    } catch (err) {
      setError('Error al obtener el personal. Verifica la conexión.');
    } finally {
      setCargando(false);
    }
  };

  // Crear o actualizar personal
  const manejarSubmit = async (e) => {
    e.preventDefault();
    try {
      if (editando) {
        await axios.put(`/personal/${personalId}`, form);
      } else {
        await axios.post('/personal', form);
      }
      obtenerPersonal();
      reiniciarFormulario();
    } catch (err) {
      setError('Error al guardar la información del personal.');
    }
  };

  // Eliminar personal
  const eliminarPersonal = async (id) => {
    try {
      await axios.delete(`/personal/${id}`);
      setPersonal(personal.filter((p) => p.id !== id));
    } catch (err) {
      setError('Error al eliminar el personal.');
    }
  };

  // Cargar datos en el formulario para edición
  const cargarPersonal = (p) => {
    setForm(p);
    setPersonalId(p.id);
    setEditando(true);
  };

  // Reiniciar formulario después de crear o editar
  const reiniciarFormulario = () => {
    setForm({ nombre: '', puesto: '', especializacion: '', horario: '' });
    setEditando(false);
    setPersonalId(null);
  };

  useEffect(() => {
    obtenerPersonal();
  }, []);

  if (cargando) return <div>Cargando personal...</div>;
  if (error) return <div className="alert alert-danger">{error}</div>;

  return (
    <div className="container mt-5">
      <h2>{editando ? 'Editar Personal' : 'Registrar Personal'}</h2>
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
          <label>Puesto</label>
          <input
            type="text"
            className="form-control"
            value={form.puesto}
            onChange={(e) => setForm({ ...form, puesto: e.target.value })}
            required
          />
        </div>
        <div className="mb-3">
          <label>Especialización</label>
          <input
            type="text"
            className="form-control"
            value={form.especializacion}
            onChange={(e) => setForm({ ...form, especializacion: e.target.value })}
            required
          />
        </div>
        <div className="mb-3">
          <label>Horario</label>
          <input
            type="text"
            className="form-control"
            value={form.horario}
            onChange={(e) => setForm({ ...form, horario: e.target.value })}
            required
          />
        </div>
        <button type="submit" className="btn btn-primary">
          {editando ? 'Guardar Cambios' : 'Registrar'}
        </button>
        {editando && (
          <button type="button" className="btn btn-secondary ms-2" onClick={reiniciarFormulario}>
            Cancelar
          </button>
        )}
      </form>

      <h2 className="mt-5">Lista de Personal</h2>
      <table className="table table-striped">
        <thead>
          <tr>
            <th>Nombre</th>
            <th>Puesto</th>
            <th>Especialización</th>
            <th>Horario</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          {personal.length === 0 ? (
            <tr>
              <td colSpan="5">No hay personal registrado.</td>
            </tr>
          ) : (
            personal.map((p) => (
              <tr key={p.id}>
                <td>{p.nombre}</td>
                <td>{p.puesto}</td>
                <td>{p.especializacion}</td>
                <td>{p.horario}</td>
                <td>
                  <button
                    className="btn btn-warning me-2"
                    onClick={() => cargarPersonal(p)}
                  >
                    Editar
                  </button>
                  <button
                    className="btn btn-danger"
                    onClick={() => eliminarPersonal(p.id)}
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

export default Personal;
