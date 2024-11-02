import { useEffect, useState } from 'react';
import axios from '../api/axiosConfig';

const CentroEducativo = () => {
  const [datos, setDatos] = useState([]);
  const [form, setForm] = useState({ nombre: '', ubicacion: '', contacto: '', director: '' });
  const [cargando, setCargando] = useState(true);
  const [editando, setEditando] = useState(false);
  const [idSeleccionado, setIdSeleccionado] = useState(null);

  const obtenerDatos = async () => {
    try {
      const response = await axios.get('/centro-educativo');
      setDatos(response.data);
    } catch (error) {
      console.error('Error al obtener los datos:', error);
    } finally {
      setCargando(false);
    }
  };

  useEffect(() => {
    obtenerDatos();
  }, []);

  const manejarSubmit = async (e) => {
    e.preventDefault();
    try {
      if (editando) {
        await axios.put(`/centro-educativo/${idSeleccionado}`, form);
      } else {
        await axios.post('/centro-educativo', form);
      }
      obtenerDatos();
      setForm({ nombre: '', ubicacion: '', contacto: '', director: '' });
      setEditando(false);
    } catch (error) {
      console.error('Error al guardar los datos:', error);
    }
  };

  const cargarEdicion = (dato) => {
    setForm(dato);
    setIdSeleccionado(dato.id);
    setEditando(true);
  };

  const eliminar = async (id) => {
    try {
      await axios.delete(`/centro-educativo/${id}`);
      obtenerDatos();
    } catch (error) {
      console.error('Error al eliminar:', error);
    }
  };

  return (
    <div className="container mt-5">
      <h2>Gestión del Centro Educativo</h2>
      <form onSubmit={manejarSubmit} className="mb-4">
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
          <label>Ubicación</label>
          <input
            type="text"
            className="form-control"
            value={form.ubicacion}
            onChange={(e) => setForm({ ...form, ubicacion: e.target.value })}
            required
          />
        </div>
        <div className="mb-3">
          <label>Contacto</label>
          <input
            type="text"
            className="form-control"
            value={form.contacto}
            onChange={(e) => setForm({ ...form, contacto: e.target.value })}
            required
          />
        </div>
        <div className="mb-3">
          <label>Director</label>
          <input
            type="text"
            className="form-control"
            value={form.director}
            onChange={(e) => setForm({ ...form, director: e.target.value })}
            required
          />
        </div>
        <button type="submit" className="btn btn-primary">
          {editando ? 'Guardar Cambios' : 'Registrar'}
        </button>
      </form>

      {cargando ? (
        <p>Cargando...</p>
      ) : (
        <table className="table">
          <thead>
            <tr>
              <th>Nombre</th>
              <th>Ubicación</th>
              <th>Contacto</th>
              <th>Director</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {datos.map((dato) => (
              <tr key={dato.id}>
                <td>{dato.nombre}</td>
                <td>{dato.ubicacion}</td>
                <td>{dato.contacto}</td>
                <td>{dato.director}</td>
                <td>
                  <button onClick={() => cargarEdicion(dato)} className="btn btn-warning me-2">
                    Editar
                  </button>
                  <button onClick={() => eliminar(dato.id)} className="btn btn-danger">
                    Eliminar
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default CentroEducativo;
