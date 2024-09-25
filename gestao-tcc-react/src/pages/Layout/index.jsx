import React from 'react';
import { Container, SidebarContainer, MainContent } from './styles';
import Sidebar from '../../components/SideBar';
import { Outlet } from 'react-router-dom';

const Layout = () => {
    return (
        <Container>
            <SidebarContainer>
                <Sidebar />
            </SidebarContainer>
            <MainContent>
                <Outlet />
            </MainContent>
        </Container>
    );
};

export default Layout;
