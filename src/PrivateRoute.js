import React from 'react';
import { Navigate, useLocation } from 'react-router-dom';

export const PrivateRoute = ({ children }) => {
  const token = localStorage.getItem('authToken');
  const location = useLocation();

  console.log('Verificação do token na rota privada:', token);

  if (!token) {
    return <Navigate to="/login" state={{ from: location }} replace />;
  }

  return children;
};