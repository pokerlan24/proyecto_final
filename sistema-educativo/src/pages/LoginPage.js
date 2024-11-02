// /src/pages/LoginPage.js
import { useState } from 'react';
import { useAuth } from '../context/AuthContext';
import { useNavigate } from 'react-router-dom';
import axios from '../api/axiosConfig';

const LoginPage = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState(null);
  const { login } = useAuth();
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('/usuarios/autenticar', {
        email: email,
        contraseña: password,
      });

      if (response.data === 'Autenticación exitosa') {
        const usuarioResponse = await axios.get(`/usuarios/${email}`);
        const userData = usuarioResponse.data;
        login(userData); // Guardamos el usuario en el contexto
        localStorage.setItem('usuario', JSON.stringify(userData)); // Guardamos en localStorage

        // Redirigimos según el rol del usuario
        switch (userData.rol_id) {
          case 'rol_1':
            navigate('/admin');
            break;
          case 'rol_2':
            navigate('/catedratico');
            break;
          case 'rol_3':
            navigate('/estudiante/cursos');
            break;
          case 'rol_4':
            navigate('/admin/inscripciones');
            break;
          default:
            navigate('/');
        }
      } else {
        setError('Credenciales inválidas. Inténtalo de nuevo.');
      }
    } catch (err) {
      console.error('Error de autenticación:', err);
      setError('Hubo un problema al iniciar sesión.');
    }
  };

  return (
    <div className="container mt-5">
      <h2>Inicio de Sesión</h2>
      <form onSubmit={handleLogin}>
        <div className="mb-3">
          <label>Email</label>
          <input
            type="email"
            className="form-control"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>
        <div className="mb-3">
          <label>Contraseña</label>
          <input
            type="password"
            className="form-control"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        {error && <div className="alert alert-danger">{error}</div>}
        <button type="submit" className="btn btn-primary">
          Iniciar Sesión
        </button>
      </form>
    </div>
  );
};

export default LoginPage;
