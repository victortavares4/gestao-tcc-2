import React, { useState, useMemo } from "react";
import { useNavigate } from 'react-router-dom';
import { useAuth } from '../../hooks/auth';

//Icon
import HomeOutlinedIcon from '@material-ui/icons/HomeOutlined';

const MenuItem = ({ item, setActive }) => {
    const history = useNavigate();
    const [isSubMenuShow, setIsSubMenuShow] = useState(false);

    return (
        <div>
            <div onClick={() => setIsSubMenuShow(!isSubMenuShow)}>
                <li key={item.label} onClick={() => { history.push(item.path) }}>
                    {item.icon === 'HomeOutlinedIcon' ? (<HomeOutlinedIcon style={{ "marginLeft": "25px", "color": "white[500]" }} />) : ""}

                    <label>
                        {item.label}
                    </label>
                </li>
            </div>
            {item.children && isSubMenuShow && <SubMenu dropDownItem={item.children} setActive={setActive} />}
        </div>
    );
};

const SubMenu = ({ dropDownItem, setActive }) => {
    const historyItem = useNavigate();
    const { userRoles } = useAuth();

    const sidebarMenuItems = useMemo(() => {
        return dropDownItem.filter(item => item.showInSidebar
            && (item.allowedRoles == null || item.allowedRoles?.some(role => userRoles?.includes(role))));
    }, [userRoles]);

    return (
        <div>
            {sidebarMenuItems.map((item) => {
                return <li key={item.label} onClick={() => { setActive(false); historyItem.push(item.path) }}>
                    <label>
                        {item.label}
                    </label>
                </li>;
            })}
        </div>
    );
};

export default MenuItem;