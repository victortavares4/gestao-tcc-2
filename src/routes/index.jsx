import React from 'react';
import { Routes, Route } from 'react-router-dom';
import CustomRoute from './customRoute';
import Dashboard from './../pages/Dashboard/index';
import TelaLogin from '../pages/TelaLogin';
import Usuarios from './../pages/Usuarios/index';
import Document from '../pages/Document';
import Notas from '../pages/Notas';

const AppRoutes = () => (
    <Routes>
        <Route path="/login" element={<TelaLogin />} />
        
        <Route path="/" element={<CustomRoute isPrivate={true}  />}>
            <Route index element={<Dashboard />} />
        </Route>
        <Route path="/users" element={<CustomRoute isPrivate={true}  />}>
            <Route index element={<Usuarios />} />
        </Route>
        <Route path="/document" element={<Document />} />
        <Route path="/notas" element={<Notas />} />
        
    </Routes>
);

export default AppRoutes;
