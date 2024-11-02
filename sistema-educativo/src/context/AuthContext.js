// /src/context/AuthContext.js
import { createContext, useContext, useState, useEffect } from 'react';
import axios from '../api/axiosConfig';

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);

  useEffect(() => {
    const storedUser = localStorage.getItem('usuario');
    if (storedUser) {
      const userData = JSON.parse(storedUser);
      setUser(userData);
      cargarPermisos(userData.id); // Cargar permisos si el usuario está almacenado
    }
  }, []);

  const cargarPermisos = async (userId) => {
    try {
      const response = await axios.get(`/usuarios/${userId}/permisos`);
      console.log('Permisos cargados:', response.data);
      setUser((prevUser) => ({
        ...prevUser,
        permisos: response.data,
      }));
    } catch (err) {
      console.error('Error al cargar permisos:', err);
    }
  };

  const login = (userData) => {
    console.log('Usuario autenticado:', userData);
    setUser(userData);
    cargarPermisos(userData.id);
    localStorage.setItem('usuario', JSON.stringify(userData));
  };

  const logout = () => {
    console.log('Cerrando sesión');
    setUser(null);
    localStorage.removeItem('usuario');
  };

  return (
    <AuthContext.Provider value={{ user, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => useContext(AuthContext);
