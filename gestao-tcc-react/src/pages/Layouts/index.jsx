import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { FiMenu, FiBell, FiChevronDown } from 'react-icons/fi';
import { BiLogOut, BiUser } from 'react-icons/bi';
import { useAuth } from '../../hooks/auth';
import { useNavigate } from 'react-router-dom'

import { Container } from './styles';
import Dropdown from 'react-bootstrap/Dropdown';
import logo from '../../assets/images/imageUnisc.png'
import Sidebar from "../../components/SideBar";

const Authorized = ({ children }) => {
    const [active, setActive] = useState(false);
    const { signOut, user, changePassword, userRoles } = useAuth();
    const [crops, setCrops] = useState([]);
    const [userObject, setUserObject] = useState(null);
    const history = useNavigate()

    useEffect(() => {
        setUserObject(typeof (user) == "string" ? JSON.parse(user) : user);
    }, []);


    return (
        <Container>            
            <header className="main-header">
                <ul>
                    <li className="li-menu">
                        <FiMenu onClick={() => { setActive(!active) }} size={23} />
                    </li>

                    <li className="li-logo">
                        <Link to="/" title="Home">
                            <img src={logo} width="100" height="36" />
                        </Link>
                    </li>

                    <li className="li-logo">
                        <img src={logo} width="86" height="36" />
                    </li>

                    <li className="li-notification">
                        <FiBell size={20} />
                    </li>

                    <li className="li-profile">
                        <div className="col-md-12">
                            <Dropdown className={`col-md-12 user-name ${userObject && userObject.companyID ? "has-company" : ""}`}>
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
                                            <p>E-mail: <span>{userObject ? userObject.email : ""}</span></p></div>
                                    </div>
                                    <div className="label-line">
                                        <div className="hrdivider options">
                                            <hr />
                                            <span className="profile-label">Opções</span>
                                        </div>
                                    </div>
                                    <div className="label-name">
                                        <div className="profile-info">
                                            <Dropdown.Item onClick={() => signOut()} ><BiLogOut /> Sair</Dropdown.Item>
                                        </div>
                                    </div>
                                </Dropdown.Menu>
                            </Dropdown>
                            <div className="user-infos">
                                {userObject && userObject.companyID ? <span className="col-md-12">{`${userObject.company.name} / ${userObject.company.currencyType.description}`}</span> : <></>}
                            </div>
                        </div>
                    </li>
                </ul>
            </header>

            <Sidebar active={active} setActive={setActive} />

            <div className="main-body">
                <main role="main">
                    {children}
                </main>
            </div>
        </Container >
    );
}

export default Authorized;
