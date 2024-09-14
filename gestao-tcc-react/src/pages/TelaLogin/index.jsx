import React, { useState } from 'react';
import { Box, Button, Typography, Container, TextField, CircularProgress } from '@material-ui/core';
import { useNavigate } from 'react-router-dom';
import { useStyles } from './styles';
import Senha from '../../components/Senha';
import Api from '../../services/api';
import imgUnisc from '../../assets/images/imageUnisc.png';
import logo from '../../assets/icons/image 3 (Traced).svg'
import logoUnisc from '../../assets/icons/logoUnisc.svg'

const TelaLogin = () => {
  const styles = useStyles();
  const navigate = useNavigate();
  const [loading, setLoading] = useState(false);
  const [usuario, setUsuario] = useState('');
  const [senha, setSenha] = useState('');
  const [error, setError] = useState('');

  const handleInputChange = (field, value) => {
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
      const response = await Api.post('user/login', data, {
        headers: { 'Content-Type': 'application/json' }
      });
      const token = response.data.token;
      if (token) {
        localStorage.setItem('authToken', token);
        navigate('/');
      } else {
        setError('Token não encontrado na resposta.');
      }
    } catch (error) {
      setError('Login falhou. Por favor, verifique suas credenciais.');
    }
    setLoading(false);
  };

  const registrarUsuario = () => {
    navigate('/registro');
  };

  return (
    <Box className={styles.fullScreen}>
      <Box className={styles.imageSection}>
        <img src={imgUnisc} alt="Imagem Unisc" className={styles.image} />
      </Box>
      <Box className={styles.loginSection}>
        <Container maxWidth="xs">
          <Box style={{ padding: 20, color: "#000000" }}>
            <Box className={styles.boxIcon}>
              <img src={logo} style={{height: 60}}/>
            </Box>
            <TextField
              placeholder='E-mail'
              variant="outlined"
              fullWidth
              InputLabelProps={{
                shrink: true,
              }}
              className={styles.field}
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
              onClick={fazerLogin}
              disabled={loading}
              fullWidth
              style={{ marginTop: 16, background: "#0076D7",height:50, fontWeight: 800, color: "#fff" }}
            >
              {loading ? <CircularProgress size={24} /> : 'Entrar'}
            </Button>
            {error && <Typography color="error" variant="body2">{error}</Typography>}
            <Box className={styles.boxIcon} style={{marginTop:"3rem"}}>
              <img src={logoUnisc} style={{height: 40}}/>
            </Box>
          </Box>
        </Container>
      </Box>
    </Box>
  );
};

export default TelaLogin;
