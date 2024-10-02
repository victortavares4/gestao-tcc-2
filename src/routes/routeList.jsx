import { Group, Home, InsertChart, ShowChart } from '@mui/icons-material';
import Dashboard from '../pages/Dashboard';
import TelaLogin from './../pages/TelaLogin/index';
import Document from '../pages/Documento';
import Notas from '../pages/Notas';
import Usuarios from '../pages/Usuarios';
import RegisterUser from '../pages/RegisterUser';

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
        isPrivate: true,
        allowedRoles: [ROLE_ADMIN],
        icon: InsertChart,
    },
    {
        path: "/notas",
        label: "Notas",
        showInSidebar: true,
        component: Notas,
        isPrivate: true,
        allowedRoles: [ROLE_ADMIN],
        icon: ShowChart,
    },
    {
        path: "/users",
        label: "Usuários",
        showInSidebar: true,
        component: Usuarios,
        isPrivate: true,
        allowedRoles: [ROLE_ADMIN],
        icon: Group,
    },
    {
        path: "/document",
        label: "Documentos",
        showInSidebar: false,
        component: Document,
        isPrivate: true,
        allowedRoles: [ROLE_ADMIN],
        icon: Group,
    },
    {
        path: "/novoUser",
        label: "Novo Usuario",
        showInSidebar: false,
        component: RegisterUser,
        isPrivate: true,
        allowedRoles: [ROLE_ADMIN],
        icon: Group,
    },

];

export default RoutesList;
