import React from 'react';
import { Container, SidebarContainer, MainContent } from './styles';
import Sidebar from '../../components/SideBar';

const Layout = () => {
    return (
        <Container>
            <SidebarContainer>
                <Sidebar />
            </SidebarContainer>
            <MainContent>
                <Outlet />  // Este componente renderizará os componentes das rotas filhas
            </MainContent>
        </Container>
    );
};

export default Layout;
