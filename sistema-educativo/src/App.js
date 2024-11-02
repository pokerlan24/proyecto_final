// /src/App.js
import { BrowserRouter as Router } from 'react-router-dom';
import AppRoutes from './routes/AppRoutes';
import { AuthProvider } from './context/AuthContext';
import Navbar from './components/Navbar';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js'; // Asegúrate de que esté este archivo, ya que incluye Popper.js


function App() {
  return (
    <AuthProvider>
      <Router>
        <Navbar /> {/* Navbar disponible en todas las pantallas */}
        <AppRoutes />
      </Router>
    </AuthProvider>
  );
}

export default App;
