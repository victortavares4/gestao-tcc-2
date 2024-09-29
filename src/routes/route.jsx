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

    return (
        <Authorized>
            <Outlet />
        </Authorized>
    );
};

export default Route;
