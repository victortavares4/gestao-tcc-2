import React from 'react';
import { Navigate } from 'react-router-dom';
import { useAuth } from '../hooks/auth'; // Para obter o estado de autenticação do usuário

const CustomRoute = ({ isPrivate = false, component: Component, allowedRoles = [], ...rest }) => {
    const { user, userRoles } = useAuth(); // Pegue o usuário e seus papéis (roles)

    // Se a rota for privada e o usuário não estiver logado, redireciona para a página de login
    if (isPrivate && !user) {
        return <Navigate to="/login" />;
    }

    // Se a rota for privada e os papéis do usuário não estão nos papéis permitidos, redireciona para "Não Autorizado"
    if (isPrivate && allowedRoles.length > 0 && !allowedRoles.some(role => userRoles.includes(role))) {
        return <Navigate to="/unauthorized" />;
    }

    // Se tudo estiver OK, renderiza o componente passado
    return <Component {...rest} />;
};

export default CustomRoute;
