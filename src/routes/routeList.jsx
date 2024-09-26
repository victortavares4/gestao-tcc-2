import Dashboard from '../pages/Dashboard';
import TelaLogin from './../pages/TelaLogin/index';
import { Navigate } from 'react-router-dom';
import { useAuth } from '../hooks/auth';
const ROLE_ADMIN = "RoleAdmin";

const RoutesList = [
    {
        path: "/login",
        label: "LogIn",
        component: TelaLogin,
        isPrivate: false, 
    },
    {
        path: "/",
        label: "DashBoard",
        showInSidebar: true,
        component: Dashboard,
        isPrivate: false,
        allowedRoles: [ROLE_ADMIN]
    },
];

export const PrivateRoute = ({ children, allowedRoles }) => {
    const { userRoles, user } = useAuth(); 

    if (user) {
        return <Navigate to="/login" />;
    }

    if (allowedRoles && !allowedRoles.some(role => userRoles?.includes(role))) {
        return <Navigate to="/unauthorized" />;
    }

    return children;
};

export default RoutesList;