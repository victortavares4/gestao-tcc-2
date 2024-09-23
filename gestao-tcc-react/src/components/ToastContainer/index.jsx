import React from 'react';
import { useTransition } from '@react-spring/web';
import Toast from './Toast';
import { Container } from './styles';

const ToastContainer = ({ messages }) => {
    const transitions = useTransition(messages, {
        from: { right: '-120%', opacity: 0 },
        enter: { right: '0%', opacity: 1 },
        leave: { right: '-120%', opacity: 0 },
        keys: message => message.id, // Definindo a chave para identificar cada item
    });

    return (
        <Container>
            {transitions((style, item) => (
                <Toast key={item.id} message={item} style={style} />
            ))}
        </Container>
    );
};

export default ToastContainer;
