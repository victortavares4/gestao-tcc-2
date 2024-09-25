import React, { createContext, useState, useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import api, { exceptionNotificationAPI } from '../services/api';

const AuthContext = createContext({});

export const AuthProvider = ({ children }) => {
    const history = useNavigate();
    const [data, setData] = useState(() => {
        const token = localStorage.getItem('@Tcc:token');
        const user = localStorage.getItem('@Tcc:user');
        const userRoles = localStorage.getItem('@Tcc:userRoles');
        if (token && user) {
            api.defaults.headers.authorization = `Bearer ${token}`;
            return { token, user: user, userRoles: userRoles };
        }
        return {};
    });

    const signIn = async ({ rec, nome, password, email }) => {
        try {
            const log = {
                recaptcha: rec,
                email: email,
                nome: nome,
                password: password
            }

            const result = await api.post('/signInNew', log);

            const { accessToken, user } = result.data.response;
            setSignInDataOnLocalStorage(result, false);
            localStorage.setItem('@Tcc:userName', nome);
            setData({ token: accessToken, user });
            return result;
        } catch (error) {
            console.error("Sign-in error:", error);
            exceptionNotificationAPI(error);
        }
    };

    const signOut = async (forceRedirect = false) => {
        sessionStorage.clear();
        localStorage.removeItem('@Tcc:token');
        localStorage.removeItem('@Tcc:user');
        localStorage.removeItem('@Tcc:userRoles');
        localStorage.removeItem('@Tcc:userName');
        localStorage.removeItem('@Tcc:userID');
        localStorage.removeItem('@Tcc:firstLogin');
        setData({});

        if (forceRedirect) {
            window.location.href = `${window.location.origin}/login`;
        }
    };

    const setSignInDataOnLocalStorage = (result) => {
        if (result.data.response) {
            const token = result.data.response.accessToken;
            const user = result.data.response.user;
            const userRoles = result.data.response.userRoles;
            const userID = result.data.response.userID;
            const firstLogin = result.data.response.primeiroLogin;

            sessionStorage.clear();
            localStorage.removeItem('@Tcc:token');
            localStorage.removeItem('@Tcc:user');
            localStorage.removeItem('@Tcc:showContrato');
            localStorage.removeItem('@Tcc:userRoles');
            localStorage.removeItem('@Tcc:userName');
            localStorage.removeItem('@Tcc:userID');
            localStorage.removeItem('@Tcc:firstLogin');

            localStorage.setItem('@Tcc:token', token);
            localStorage.setItem('@Tcc:user', user);
            localStorage.setItem('@Tcc:userID', userID);
            localStorage.setItem('@Tcc:userRoles', userRoles);
            localStorage.setItem('@Tcc:firstLogin', firstLogin);
            api.defaults.headers.authorization = `Bearer ${token}`;
            setData({ token, user, userRoles, userID });

        }
    };

    const [refresh, setRefresh] = useState(false);
    const triggerRefresh = () => setRefresh(prev => !prev);

    return (
        <AuthContext.Provider value={{ user: data.user, userRoles: data.userRoles, signIn, signOut, refresh, triggerRefresh }}>
            {children}
        </AuthContext.Provider>
    );
};

export function useAuth() {
    return useContext(AuthContext);
}
