import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Container, Box, TextField, Button, Typography, CircularProgress } from '@material-ui/core';
import Api, { exceptionNotificationAPI } from '../../Api';
import { useStyles } from './styles';
import Senha from './../../Components/Senha/index';

const NovoUsuario = () => {
  const styles = useStyles();
  const navigate = useNavigate();
  const [loading, setLoading] = useState(false);
  const [usuario, setUsuario] = useState('');
  const [senha, setSenha] = useState('');
  const [email, setEmail] = useState('');
  const [apiKey, setApiKey] = useState('');
  const [error, setError] = useState('');

  const handleInputChange = (field, value) => {
    switch (field) {
      case 'usuario':
        setUsuario(value);
        break;
      case 'senha':
        setSenha(value);
        break;
      case 'apiKey':
        setApiKey(value);
        break;
      default:
        break;
    }
    setError('');
  };

  const registrarUsuario = async () => {
    if (!usuario || !senha || apiKey.length !== 40) {
      setError('Todos os campos são obrigatórios e a chave da API deve ter 40 caracteres.');
      return;
    }

    setLoading(true);
    try {
        const data = {
            nome: usuario,
            login: usuario,
            senha: senha,
            chaveApi: apiKey
          };
      const response = await Api.post(`user/register`, data);
      console.log('Usuário registrado com sucesso:', response.data);
      navigate('/');
    } catch (error) {
      exceptionNotificationAPI(error);
    }
    setLoading(false);
  };

  return (
    <Container className={styles.container} maxWidth="xs">
      <Box style={{ padding: 20, color: "#000000" }}>
        <Typography variant="h4" gutterBottom>Registrar Novo Usuário</Typography>
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
        <TextField
          label="Chave da API"
          variant="outlined"
          fullWidth
          value={apiKey}
          onChange={(e) => handleInputChange('apiKey', e.target.value)}
          error={!!error}
          helperText={error}
          margin="normal"
        />
        <Button
          variant="contained"
          color="primary"
          onClick={registrarUsuario}
          disabled={loading}
          fullWidth
          style={{ marginTop: 16 }}
        >
          {loading ? <CircularProgress size={24} /> : 'Registrar'}
        </Button>
      </Box>
    </Container>
  );
};

export default NovoUsuario;