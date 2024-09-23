import React, { createContext, useContext, useState } from 'react';
import { v4 as uuidv4 } from 'uuid';  // Corrigido

import ToastContainer from '../components/ToastContainer';

const ToastContext = createContext();

const ToastProvider = ({ children }) => {
    const [messages, setMessages] = useState([]);

    const addToast = ({ type, title, description }) => {
        const id = uuidv4();  // Corrigido

        const toast = {
            id,
            type,
            title,
            description,
        };

        setMessages(oldMessages => [...oldMessages, toast]);
    }

    const removeToast = (id) => {
        setMessages(state => state.filter(message => message.id !== id));
    }

    return (
        <ToastContext.Provider value={{ addToast, removeToast }}>
            {children}
            <ToastContainer messages={messages} />
        </ToastContext.Provider>
    );
};

function useToast() {
    const context = useContext(ToastContext);

    if (!context) {
        throw new Error('useToast must be used within a ToastProvider');
    }

    return context;
}

export { ToastProvider, useToast };
