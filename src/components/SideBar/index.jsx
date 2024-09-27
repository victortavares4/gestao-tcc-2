import React, { useMemo } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import logo from '../../assets/icons/image 3 (Traced).svg';
import { Container, SidebarHeader, SidebarBody, SidebarFooter } from './styles';
import { useAuth } from '../../hooks/auth';
import RoutesList from '../../routes/routeList';
import { Logout } from '@mui/icons-material';
import { Box, Button } from '@material-ui/core';

const Sidebar = () => {
    const navigate = useNavigate();
    const location = useLocation();
    const { userRoles } = useAuth();

    const sidebarMenuItems = useMemo(() => {
        return RoutesList.filter(item => item.showInSidebar);
    }, [userRoles]);

    return (
        <Container>
            <SidebarHeader>
                <div>
                    <img src={logo} width="100" height="36" alt="Logo Unisc" />
                </div>
            </SidebarHeader>
            <SidebarBody>
                <ul>
                    {sidebarMenuItems.map((item) => {
                        const isActive = location.pathname === item.path;

                        return (
                            <li 
                                key={item.path} 
                                onClick={() => navigate(item.path)} 
                                style={{
                                    backgroundColor: isActive ? '#fff' : '#2B4266', 
                                    color: isActive ? '#2B4266' : '#fff',
                                    cursor: 'pointer'
                                }}
                            >
                                {item.icon && <item.icon style={{ marginLeft: 30 }} />}
                                <label style={{ marginLeft: 10 }}>{item.label}</label>
                            </li>
                        );
                    })}
                </ul>
            </SidebarBody>
            <SidebarFooter>
                <Box style={{ width: "75%", color: "#fff", background: "#2B4266", borderRadius: 12, display: "flex", justifyContent: "center", alignItems: "center" }}>
                    <Logout />
                    <Button style={{ color: "#fff" }}>Sair</Button>
                </Box>
            </SidebarFooter>
        </Container>
    );
};

export default Sidebar;
