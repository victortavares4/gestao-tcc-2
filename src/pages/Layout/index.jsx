import React from 'react';
import { Outlet } from 'react-router-dom'; 

const Layout = () => (
    <main>
        <Outlet /> {/* Renderiza os componentes das rotas filhas */}
    </main>
);

export default Layout;
