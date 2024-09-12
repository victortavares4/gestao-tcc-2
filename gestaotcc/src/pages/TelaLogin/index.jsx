import React, { useState } from 'react';
import { Box, Button, Typography, Container, TextField, CircularProgress } from '@material-ui/core';
import { useNavigate } from 'react-router-dom';
import { useStyles } from './styles';
import Senha from '../../components/Senha';
import Api from '../../services/api';

const TelaLogin = () => {
  const styles = useStyles();
  const navigate = useNavigate();
  const [loading, setLoading] = useState(false);
  const [usuario, setUsuario] = useState('');
  const [senha, setSenha] = useState('');
  const [error, setError] = useState('');

  const handleInputChange = (field, value) => {
    console.log(`Updating ${field} to ${value}`);
    switch (field) {
      case 'usuario':
        setUsuario(value);
        break;
      case 'senha':
        setSenha(value);
        break;
      default:
        break;
    }
    setError('');
  };

  const fazerLogin = async () => {
    setLoading(true);
    try {
      const data = { login: usuario, senha: senha };
      console.log('Sending login request with data:', data);
      const response = await Api.post('user/login', data, {
        headers: { 'Content-Type': 'application/json' }
      });
      console.log('Response from server:', response);
      const token = response.data.token;
      if (token) {
        localStorage.setItem('authToken', token);
        navigate('/');
      } else {
        setError('Token não encontrado na resposta.');
      }
    } catch (error) {
      console.error('Login failed:', error);
      setError('Login falhou. Por favor, verifique suas credenciais.');
    }
    setLoading(false);
  };

  const registrarUsuario = () => {
    navigate('/registro');
  };

  return (
    <Container className={styles.container} maxWidth="xs">
      <Box style={{ padding: 20, color: "#000000" }}>
        <Typography variant="h4" gutterBottom>Login</Typography>
        <TextField
          label="Nome de Usuário"
          variant="outlined"
          fullWidth
          value={usuario}
          onChange={(e) => handleInputChange('usuario', e.target.value)}
          margin="normal"
        />
        <Senha
          value={senha}
          onChange={(e) => handleInputChange('senha', e.target.value)}
        />
        <Button
          variant="contained"
          color="primary"
          onClick={fazerLogin}
          disabled={loading}
          fullWidth
          style={{ marginTop: 16 }}
        >
          {loading ? <CircularProgress size={24} /> : 'Entrar'}
        </Button>
        {error && <Typography color="error" variant="body2">{error}</Typography>}
        <Button
          variant="text"
          onClick={registrarUsuario}
          fullWidth
          style={{ marginTop: 8 }}
        >
          Não possui uma conta? Registre-se aqui
        </Button>
      </Box>
    </Container>
  );
};

export default TelaLogin;