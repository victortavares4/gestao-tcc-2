import { Group, Home, InsertChart, ShowChart } from '@mui/icons-material';
import Dashboard from '../pages/Dashboard';
import TelaLogin from './../pages/TelaLogin/index';
import Document from '../pages/Documento';
import Notas from '../pages/Notas';
const ROLE_ADMIN = "RoleAdmin";

const RoutesList = [
    {
        path: "/login",
        label: "LogIn",
        component: TelaLogin,
        isPrivate: false, 
        showInSidebar: false
    },
    {
        path: "/",
        label: "Dashboard",
        showInSidebar: true,
        component: Dashboard,
        isPrivate: false,
        allowedRoles: [ROLE_ADMIN],
        icon: InsertChart,
    },
    {
        path: "/notas",
        label: "Notas",
        showInSidebar: true,
        component: Notas,
        isPrivate: false,
        allowedRoles: [ROLE_ADMIN],
        icon: ShowChart,
    },
    {
        path: "/users",
        label: "Usuários",
        showInSidebar: true,
        component: Dashboard,
        isPrivate: false,
        allowedRoles: [ROLE_ADMIN],
        icon: Group,
    },
    

];

export default RoutesList;
