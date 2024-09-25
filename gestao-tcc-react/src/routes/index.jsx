import React from 'react';
import { Routes, Route } from 'react-router-dom';
import RoutesList from './routeList';
import TelaLogin from '../pages/TelaLogin';
import Layout from '../pages/Layout';

const AppRoutes = () => (
    <Routes>
        {/* As rotas que usam o Layout (com Sidebar fixo) */}
        <Route element={<Layout />}> 
            {RoutesList.map(route => (
                <Route
                    key={route.path}
                    path={route.path}
                    element={<route.component />} // Renderizando o componente correto
                />
            ))}
        </Route>

        {/* Outras rotas que não precisam do Layout podem ir aqui */}
        <Route path="/login" element={<TelaLogin />} />
    </Routes>
);

export default AppRoutes;
