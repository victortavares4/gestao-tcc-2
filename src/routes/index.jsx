import React from 'react';
import { Routes, Route } from 'react-router-dom';
import CustomRoute from './customRoute';
import Dashboard from './../pages/Dashboard/index';
import TelaLogin from '../pages/TelaLogin';

const AppRoutes = () => (
    <Routes>
        <Route path="/login" element={<TelaLogin />} />
        
        <Route path="/" element={<CustomRoute isPrivate={true}  />}>
            <Route index element={<Dashboard />} />  {/* Renderiza o Dashboard como rota padrão */}
        </Route>
        
        {/* Outras rotas podem ser adicionadas aqui */}
    </Routes>
);

export default AppRoutes;
