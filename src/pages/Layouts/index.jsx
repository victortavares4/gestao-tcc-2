import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { FiBell } from 'react-icons/fi';
import { useAuth } from '../../hooks/auth';
import { useNavigate } from 'react-router-dom';
import { Container } from './styles';
import logo from '../../assets/images/imageUnisc.png';
import Sidebar from '../../components/SideBar';
import Projetos from '../../components/Projetos';

const Authorized = ({ children }) => {
    const { signOut, user } = useAuth();
    const [userObject, setUserObject] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        setUserObject(typeof user === "string" ? JSON.parse(user) : user);
    }, [user]);

    return (
        <Container>

            <div style={{ display: 'flex' }}>
                <Sidebar /> 

                <div className="main-body" style={{ flex: 1, padding: '20px' }}>
                    <main role="main">
                        {children}
                    </main>
                </div>
                <Projetos />
            </div>
        </Container>
    );
};

export default Authorized;
