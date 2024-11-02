// /src/pages/EstudianteCursos.js
import { useEffect, useState } from 'react';
import axios from '../api/axiosConfig';

const EstudianteCursos = () => {
  const [cursos, setCursos] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    axios
      .get('/cursos/listar')
      .then((response) => setCursos(response.data))
      .catch((error) => setError('No se pudieron cargar los cursos.'));
  }, []);

  const inscribirCurso = async (cursoId) => {
    try {
      const usuarioId = localStorage.getItem('usuarioId'); // Recuperamos el ID del usuario autenticado
      await axios.post('/inscripciones/inscribir', {
        usuarioId,
        cursoId,
      });
      alert('Inscripción exitosa');
    } catch (error) {
      alert('Error al inscribirse en el curso');
    }
  };

  return (
    <div className="container mt-5">
      <h2>Cursos Disponibles</h2>
      {error && <p className="text-danger">{error}</p>}
      <ul className="list-group">
        {cursos.map((curso) => (
          <li key={curso.id} className="list-group-item d-flex justify-content-between align-items-center">
            {curso.nombre}
            <button className="btn btn-primary" onClick={() => inscribirCurso(curso.id)}>
              Inscribirse
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default EstudianteCursos;
