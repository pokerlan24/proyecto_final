// /src/routes/ProtectedRoute.js
import { Navigate } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';

const ProtectedRoute = ({ children, permission }) => {
  const { user } = useAuth();

  if (!user) {
    return <Navigate to="/login" />;
  }

  if (!user.permisos?.includes(permission)) {
    console.warn(`Usuario autenticado, pero sin permiso "${permission}". Redirigiendo a la página principal.`);
    return <Navigate to="/" />;
  }

  return children;
};

export default ProtectedRoute;
