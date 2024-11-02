// /src/pages/Reportes.js
import { useEffect, useState } from 'react';
import axios from '../api/axiosConfig';

const Reportes = () => {
  const [reportes, setReportes] = useState([]);

  useEffect(() => {
    axios.get('/reportes').then((response) => setReportes(response.data));
  }, []);

  return (
    <div className="container mt-5">
      <h2>Reportes Administrativos</h2>
      <ul className="list-group">
        {reportes.map((reporte, index) => (
          <li key={index} className="list-group-item">
            {reporte.descripcion}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Reportes;
