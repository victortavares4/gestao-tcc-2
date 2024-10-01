import React, { createContext, useState, useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import api, { exceptionNotificationAPI } from '../services/api';
import { success_message } from '../components/Toast';

const AuthContext = createContext({});

export const AuthProvider = ({ children }) => {
    const navigate = useNavigate();
    const [data, setData] = useState(() => {
        const token = localStorage.getItem('token');
        const user = localStorage.getItem('user');
        const userRoles = localStorage.getItem('userRoles');
        if (token && user) {
            api.defaults.headers.authorization = `Bearer ${token}`;
            return { token, user: user, userRoles: userRoles };
        }
        return {};
    });

    const signIn = async ({ login, senha }) => {
        try {
            const log = {
                matricula: login,
                senha: senha,
            }

            const result = await api.post('/user/login', log, {
                headers: {
                    'Content-Type': 'application/json'
                }
            });
            console.log(result.data);
            const { accessToken, user } = result.data.token;
            setSignInDataOnLocalStorage(result);
            localStorage.setItem('@Tcc:userName', login);            
            setData({ token: accessToken, user });
            success_message("Seja Bem Vindo!");
            navigate("/");
            return result;
        } catch (error) {
            console.error("Sign-in error:", error);
            exceptionNotificationAPI(error);
        }
    };

    const signOut = async (forceRedirect = false) => {
        sessionStorage.clear();
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        localStorage.removeItem('userRoles');
        localStorage.removeItem('userName');
        localStorage.removeItem('userID');
        setData({});

        if (forceRedirect) {
            window.location.href = `${window.location.origin}/login`;
        }
    };

    const setSignInDataOnLocalStorage = (result) => {
        if (result.data) {
            const token = result.data.token;
            const user = result.data.nome;
            const userRoles = result.data.userType;
            const userID = result.data.userID;

            sessionStorage.clear();
            localStorage.removeItem('token');
            localStorage.removeItem('user');
            localStorage.removeItem('showContrato');
            localStorage.removeItem('userRoles');
            localStorage.removeItem('userName');
            localStorage.removeItem(':userID');

            localStorage.setItem('token', token);
            localStorage.setItem('user', user);
            localStorage.setItem('userID', userID);
            localStorage.setItem('userRoles', userRoles);
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
