import React from 'react';
import { BrowserRouter } from 'react-router-dom';
import GlobalStyle from './styles/global';
import AppProvider from './hooks/index';
import AppRoutes from './routes'; // Renomeado para AppRoutes para evitar confusão
import 'bootstrap/dist/css/bootstrap.min.css';
import 'animate.css';

function App() {
    return (
        <BrowserRouter>
            <AppProvider>
                <AppRoutes />
            </AppProvider>
            <GlobalStyle />
        </BrowserRouter>
    );
}

export default App;
