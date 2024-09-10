
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import TelaLogin from "./Pages/Login";
import NovoUsuario from "./Pages/NovoUsuario";
import { PrivateRoute } from './PrivateRoute';

const AppRouter = () => {
    return (
      <Router>
        <Routes>
          <Route path="/login" element={<TelaLogin />} />
          <Route path="/registro" element={<NovoUsuario />} />
          {/* <Route path="/" element={<PrivateRoute><Dashboard /></PrivateRoute>} /> */}
          {/* <Route path="/dados" element={<PrivateRoute><Results /></PrivateRoute>} />
          <Route path="/sobre" element={<PrivateRoute><Time /></PrivateRoute>} /> */}
        </Routes>
      </Router>
    );
  };
  
  export default AppRouter;