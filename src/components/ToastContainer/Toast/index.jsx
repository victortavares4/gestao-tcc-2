import React, { useEffect } from 'react';
import { FiXCircle } from 'react-icons/fi';
import { useTransition } from '@react-spring/web';
import { useToast } from '../../../hooks/toast';
import { Container } from './styles';

const Toast = ({ message, style }) => {
    const { removeToast } = useToast();

    useEffect(() => {
        const timer = setTimeout(() => {
            removeToast(message.id);
        }, 3000);

        return () => {
            clearTimeout(timer);
        };
    }, [removeToast, message.id]);

    return (
        <Container
            type={message.type}
            hasDescription={Number(!!message.description)}
            style={style}
        >
            <div>
                <strong>{message.title}</strong>
                {/* Ajuste: Exibindo a descrição real da mensagem */}
                {message.description && (
                    <p>{message.description}</p>
                )}
            </div>

            <button type="button" onClick={() => removeToast(message.id)}>
                <FiXCircle size={18} />
            </button>
        </Container>
    );
};

export default Toast;
