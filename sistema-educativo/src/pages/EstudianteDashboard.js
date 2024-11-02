// /src/pages/EstudianteDashboard.js
import { useEffect, useState } from 'react';
import axios from '../api/axiosConfig';

const EstudianteDashboard = () => {
  const [cursos, setCursos] = useState([]);

  useEffect(() => {
    axios.get('/inscripciones/usuario/usuario_3')
      .then(response => setCursos(response.data))
      .catch(error => console.error(error));
  }, []);

  return (
    <div className="container">
      <h1>Mis Cursos</h1>
      <ul>
        {cursos.map(curso => (
          <li key={curso.id}>{curso.nombre}</li>
        ))}
      </ul>
    </div>
  );
};

export default EstudianteDashboard;
