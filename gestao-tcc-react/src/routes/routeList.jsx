import Dashboard from '../pages/Dashboard';
import TelaLogin from './../pages/TelaLogin/index';
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
        component: Dashboard,
        isPrivate: true,
    },
];

export default RoutesList;