import React from 'react';
import { Route as ReactDOMRoute, Navigate } from 'react-router-dom';
import { useAuth } from '../hooks/auth';
import Authorized from '../pages/Layouts';

const Route = ({ isPrivate = false, component: Component, allowedRoles, ...rest }) => {
    const { user, userRoles } = useAuth();

    if (isPrivate && user) {
        return <Navigate to="/login" />;
    }

    if (isPrivate && allowedRoles && !allowedRoles.some(role => userRoles?.includes(role))) {
        return <Navigate to="/unauthorized" />;
    }

    const Layout = Authorized;

    return (
        <ReactDOMRoute
            {...rest}
            element={
                <Layout>
                    <Component />
                </Layout>
            }
        />
    );
};

export default Route;
