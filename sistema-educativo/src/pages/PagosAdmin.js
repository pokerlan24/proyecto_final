// /src/pages/PagosAdmin.js
import { useEffect, useState } from 'react';
import axios from '../api/axiosConfig';

const PagosAdmin = () => {
  const [pagos, setPagos] = useState([]);

  useEffect(() => {
    axios.get('/pagos').then((response) => setPagos(response.data));
  }, []);

  return (
    <div className="container mt-5">
      <h2>Gestión de Pagos</h2>
      <ul className="list-group">
        {pagos.map((pago) => (
          <li key={pago.id} className="list-group-item">
            Inscripción: {pago.inscripcionId}, Monto: {pago.monto} Q
          </li>
        ))}
      </ul>
    </div>
  );
};

export default PagosAdmin;
