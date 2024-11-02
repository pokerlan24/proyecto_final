// /src/pages/EstudianteInscripciones.js
import { useEffect, useState } from 'react';
import axios from '../api/axiosConfig';

const EstudianteInscripciones = () => {
  const [inscripciones, setInscripciones] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    const usuarioId = localStorage.getItem('usuarioId'); // ID del usuario autenticado
    axios
      .get(`/inscripciones/usuario/${usuarioId}`)
      .then((response) => setInscripciones(response.data))
      .catch(() => setError('No se pudieron cargar las inscripciones.'));
  }, []);

  return (
    <div className="container mt-5">
      <h2>Mis Inscripciones</h2>
      {error && <p className="text-danger">{error}</p>}
      <ul className="list-group">
        {inscripciones.map((inscripcion) => (
          <li key={inscripcion.id} className="list-group-item">
            {`Curso: ${inscripcion.cursoId} - Estado: ${inscripcion.estado}`}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default EstudianteInscripciones;
