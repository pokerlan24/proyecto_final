// /src/pages/EstudiantePagos.js
import { useState } from 'react';
import axios from '../api/axiosConfig';

const EstudiantePagos = () => {
  const [inscripcionId, setInscripcionId] = useState('');
  const [metodoPago, setMetodoPago] = useState('');
  const [monto, setMonto] = useState('');

  const realizarPago = async (e) => {
    e.preventDefault();
    try {
      await axios.post('/pagos/registrar', {
        inscripcionId,
        metodoPago,
        monto: parseFloat(monto),
        fechaPago: new Date().toISOString(),
      });
      alert('Pago realizado con éxito');
    } catch (error) {
      alert('Error al realizar el pago');
    }
  };

  return (
    <div className="container mt-5">
      <h2>Realizar Pago</h2>
      <form onSubmit={realizarPago}>
        <div className="mb-3">
          <label>ID de Inscripción</label>
          <input
            type="text"
            className="form-control"
            value={inscripcionId}
            onChange={(e) => setInscripcionId(e.target.value)}
            required
          />
        </div>
        <div className="mb-3">
          <label>Método de Pago</label>
          <input
            type="text"
            className="form-control"
            value={metodoPago}
            onChange={(e) => setMetodoPago(e.target.value)}
            required
          />
        </div>
        <div className="mb-3">
          <label>Monto</label>
          <input
            type="number"
            className="form-control"
            value={monto}
            onChange={(e) => setMonto(e.target.value)}
            required
          />
        </div>
        <button type="submit" className="btn btn-success">
          Realizar Pago
        </button>
      </form>
    </div>
  );
};

export default EstudiantePagos;
