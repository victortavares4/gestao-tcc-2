import React, { useMemo } from 'react';
import logo from '../../assets/images/imageUnisc.png';
import logoUnisc from '../../assets//images/imageUnisc.png';
import { useNavigate } from 'react-router-dom';
import {
    Container,
    SidebarHeader,
    SidebarBody,
    SidebarFooter
} from './styles';
import { FiX } from 'react-icons/fi';
import { useAuth } from '../../hooks/auth';
import MenuItem from '../../components/Menu';
import RoutesList from '../../routes/routeList';

const Sidebar = ({ active, setActive }) => {
    const history = useNavigate();
        const { userRoles } = useAuth();

    const sidebarMenuItems = useMemo(() => {
        return RoutesList.filter(item => item.showInSidebar && item.isVisible
            && (item.allowedRoles == null || item.allowedRoles?.some(role => userRoles?.includes(role)) || item.children?.some(roleItem => userRoles?.includes(roleItem))));
    }, [userRoles]);

    return (
        <Container className={(active ? "show" : "hide")}>
            <SidebarHeader>
                <div>
                    <FiX onClick={() => { setActive(!active) }} alt="Close menu" size={20} />
                </div>
                <div>
                    <img src={logoUnisc} width="100" height="36" />
                </div>
            </SidebarHeader>
            <SidebarBody>
                <ul>
                    {sidebarMenuItems.map(item => {
                        return (
                            <MenuItem item={item} setActive={setActive} key={item.label} onClick={() => { setActive(false); history.push(item.path); }}></MenuItem>
                        );
                    })}
                </ul>
            </SidebarBody>
            <SidebarFooter>
                <img src={logo} alt="Logo BAT" width="86" height="36" />
            </SidebarFooter>
        </Container>
    );
}

export default Sidebar;

