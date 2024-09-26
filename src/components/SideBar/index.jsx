import React, { useMemo } from 'react';
import logo from '../../assets/images/imageUnisc.png';
import logoUnisc from '../../assets/icons/image 3 (Traced).svg';
import { useNavigate } from 'react-router-dom';
import {
    Container,
    SidebarHeader,
    SidebarBody,
    SidebarFooter
} from './styles';
import { useAuth } from '../../hooks/auth';
import MenuItem from '../../components/Menu';
import RoutesList from '../../routes/routeList';
import { Button } from '@material-ui/core';
import { Logout } from '@mui/icons-material';

const Sidebar = () => {
    const navigate = useNavigate();
    const { userRoles } = useAuth();

    const sidebarMenuItems = useMemo(() => {
        return RoutesList.filter(item => item.showInSidebar
            && (item.allowedRoles?.some(role => userRoles?.includes(role)) || item.children?.some(roleItem => userRoles?.includes(roleItem))));
    }, [userRoles]);

    return (
        <Container>
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
                            onClick={() => navigate(item.path)}
                        />
                    ))}
                </ul>
            </SidebarBody>
            <SidebarFooter>
                <Logout ></Logout>
                <Button>Sair</Button>
            </SidebarFooter>
        </Container>
    );
}

export default Sidebar;
