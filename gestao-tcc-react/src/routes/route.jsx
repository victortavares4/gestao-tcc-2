import React from 'react';
import { Route as ReactDOMRoute, Navigate } from 'react-router-dom';
import { useAuth } from '../hooks/auth';
import Authorized from '../pages/Layouts';

const Route = ({ isPrivate = false, component: Component, allowedRoles, ...rest }) => {
    const { user, userRoles } = useAuth();

    if (isPrivate && !user) {
        return <Navigate to="/login" />;
    }

    let roles = [];
    if (userRoles) {
        roles = Array.isArray(userRoles) ? userRoles : [userRoles];
    }

    const Layout = user && roles.length > 0 ? Authorized : Authorized;

    return (
        <ReactDOMRoute
            {...rest}
            render={({ location }) => (
                <Layout>
                    <Component />
                </Layout>
            )}
        />
    );
};

export default Route;
