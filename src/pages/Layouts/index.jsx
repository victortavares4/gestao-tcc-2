import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { FiBell, FiChevronDown } from 'react-icons/fi';
import { BiLogOut } from 'react-icons/bi';
import { useAuth } from '../../hooks/auth';
import { useNavigate } from 'react-router-dom';
import { Container } from './styles';
import Dropdown from 'react-bootstrap/Dropdown';
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

                    <li className="li-profile">
                        <Dropdown className="col-md-12 user-name">
                            <Dropdown.Toggle>
                                <span>Olá, {userObject ? userObject.firstName : ""}</span>
                                <FiChevronDown size={20} />
                            </Dropdown.Toggle>
                            <Dropdown.Menu>
                                <div className="label-line">
                                    <div className="hrdivider">
                                        <hr />
                                        <span className="profile-label">Perfil</span>
                                    </div>
                                </div>
                                <div className="label-name">
                                    <div className="profile-info">
                                        <p>Nome: <span>{userObject ? userObject.firstName : ""}</span></p>
                                        <p>E-mail: <span>{userObject ? userObject.email : ""}</span></p>
                                    </div>
                                </div>
                                <div className="label-line">
                                    <div className="hrdivider options">
                                        <hr />
                                        <span className="profile-label">Opções</span>
                                    </div>
                                </div>
                                <div className="label-name">
                                    <Dropdown.Item onClick={() => signOut()} ><BiLogOut /> Sair</Dropdown.Item>
                                </div>
                            </Dropdown.Menu>
                        </Dropdown>
                    </li>
                </ul>
            </header>

            <Sidebar /> {/* Sidebar sempre fixo à esquerda */}

            <div className="main-body">
                <main role="main">
                    {children} {/* Conteúdo principal renderizado aqui */}
                </main>
            </div>
        </Container>
    );
};

export default Authorized;
