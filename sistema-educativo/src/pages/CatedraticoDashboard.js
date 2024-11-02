// /src/pages/CatedraticoDashboard.js
import { useEffect, useState } from 'react';
import axios from '../api/axiosConfig';

const CatedraticoDashboard = () => {
  const [cursos, setCursos] = useState([]);

  useEffect(() => {
    axios.get('/cursos/catedratico').then((response) => setCursos(response.data));
  }, []);

  return (
    <div className="container mt-5">
      <h2>Panel del Catedrático</h2>
      <ul className="list-group">
        {cursos.map((curso) => (
          <li key={curso.id} className="list-group-item">
            {curso.nombre}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default CatedraticoDashboard;
