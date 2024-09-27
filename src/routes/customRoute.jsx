import React from 'react';
import { Navigate, Outlet } from 'react-router-dom';
import { useAuth } from '../hooks/auth';
import Authorized from '../pages/Layouts';

const CustomRoute = ({ isPrivate = false, allowedRoles, ...rest }) => {
    const { user, userRoles } = useAuth();

    if (isPrivate && user) {
        return <Navigate to="/login" />;
    }

    if (isPrivate && allowedRoles && !allowedRoles.some(role => userRoles?.includes(role))) {
        return <Navigate to="/unauthorized" />;
    }

    // Renderiza o layout autorizado com o Outlet para exibir o conteúdo da rota
    return (
        <Authorized>
            <Outlet />  
        </Authorized>
    );
};

export default CustomRoute;
