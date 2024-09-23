import React from 'react';
import { Routes, Route } from 'react-router-dom';
import RoutesList from './routeList';

const AppRoutes = () => (
    <Routes>
        {RoutesList.map((route) => (
            <Route
                key={route.path}
                path={route.path}
                exact={route.exact}
                element={
                    <route.component
                        isPrivate={route.isPrivate}
                        allowedRoles={route.allowedRoles}
                    />
                }
            />
        ))}
    </Routes>
);

export default AppRoutes;
