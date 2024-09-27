import React from 'react';
import { Navigate, Outlet } from 'react-router-dom';
import { useAuth } from '../hooks/auth';
import Authorized from '../pages/Layouts';

const Route = ({ isPrivate = false, allowedRoles, ...rest }) => {
    const { user, userRoles } = useAuth();

    if (isPrivate && !user) {
        return <Navigate to="/login" />;
    }

    if (isPrivate && allowedRoles && !allowedRoles.some(role => userRoles?.includes(role))) {
        return <Navigate to="/unauthorized" />;
    }

    // Renderiza o layout autorizado e utiliza o Outlet para carregar rotas aninhadas
    return (
        <Authorized>
            <Outlet />  {/* Isso garante que o conteúdo da rota seja renderizado */}
        </Authorized>
    );
};

export default Route;
