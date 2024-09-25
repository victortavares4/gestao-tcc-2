import React, { useMemo } from 'react';
import logo from '../../assets/images/imageUnisc.png';
import logoUnisc from '../../assets/images/imageUnisc.png';
import { useNavigate } from 'react-router-dom';
import {
    Container,
    SidebarHeader,
    SidebarBody,
    SidebarFooter
} from './styles';
import { useAuth } from '../../hooks/auth';
import MenuItem from '../../components/Menu'; // Certifique-se que este componente funciona corretamente
import RoutesList from '../../routes/routeList';

const Sidebar = () => {
    const navigate = useNavigate();
    const { userRoles } = useAuth();

    const sidebarMenuItems = useMemo(() => {
        return RoutesList.filter(item => item.showInSidebar
            && (item.allowedRoles?.some(role => userRoles?.includes(role)) || item.children?.some(roleItem => userRoles?.includes(roleItem))));
    }, [userRoles]);

    return (
        <Container> {/* Certifique-se de que o CSS do Container ajusta a posição fixa */}
            <SidebarHeader>
                <div>
                    <img src={logoUnisc} width="100" height="36" alt="Logo Unisc" />
                </div>
            </SidebarHeader>
            <SidebarBody>
                <ul>
                    {sidebarMenuItems.map(item => (
                        <MenuItem 
                            item={item} 
                            key={item.label}
                            onClick={() => navigate(item.path)} // Navegação para a rota correspondente
                        />
                    ))}
                </ul>
            </SidebarBody>
            <SidebarFooter>
                <img src={logo} alt="Logo BAT" width="86" height="36" />
            </SidebarFooter>
        </Container>
    );
}

export default Sidebar;
