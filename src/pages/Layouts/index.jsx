import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { FiBell } from 'react-icons/fi';
import { useAuth } from '../../hooks/auth';
import { useNavigate } from 'react-router-dom';
import { Container } from './styles';
import logo from '../../assets/images/imageUnisc.png';
import Sidebar from '../../components/SideBar';

const Authorized = ({ children }) => {
    const { signOut, user } = useAuth();
    const [userObject, setUserObject] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        setUserObject(typeof user === "string" ? JSON.parse(user) : user);
    }, [user]);

    return (
        <Container>            
            <header className="main-header">
                <ul>
                    <li className="li-logo">
                        <Link to="/" title="Home">
                            <img src={logo} width="100" height="36" alt="Logo" />
                        </Link>
                    </li>
                    <li className="li-notification">
                        <FiBell size={20} />
                    </li>                    
                </ul>
            </header>

            <div style={{ display: 'flex' }}>
                {/* Sidebar ocupa uma coluna à esquerda */}
                <Sidebar /> 

                {/* Conteúdo principal do layout */}
                <div className="main-body" style={{ flex: 1, padding: '20px' }}>
                    <main role="main">
                        {children} {/* Aqui é onde o Dashboard ou qualquer componente será renderizado */}
                    </main>
                </div>
            </div>
        </Container>
    );
};

export default Authorized;
