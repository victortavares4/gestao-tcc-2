import React, { useState, useEffect } from 'react';
import { Box, Button, Typography, Container, TextField, CircularProgress, MenuItem, Select, InputLabel, FormControl } from '@material-ui/core';
import { useNavigate } from 'react-router-dom';
import { useStyles } from './styles';
import Senha from '../../components/Senha';
import Api from '../../services/api';
import imgUnisc from '../../assets/images/imageUnisc.png';
import logo from '../../assets/icons/image 3 (Traced).svg';
import logoUnisc from '../../assets/icons/logoUnisc.svg';
import { useAuth } from '../../hooks/auth';
import { success_message } from '../../components/Toast';

const RegisterUser = () => {
  const styles = useStyles();
  const navigate = useNavigate();
  const [loading, setLoading] = useState(false);
  const [matricula, setMatricula] = useState('');
  const [nome, setNome] = useState('');
  const [senha, setSenha] = useState('');
  const [tipoUsuario, setTipoUsuario] = useState('');
  const [imagemBase64, setImagemBase64] = useState('');
  const [tiposUsuarios, setTiposUsuarios] = useState([]);
  const [error, setError] = useState('');

  useEffect(() => {
    const carregarTiposUsuarios = async () => {
      try {
        const response = await Api.get('/projeto/findallTiposUser');
        setTiposUsuarios(response.data);
      } catch (error) {
        console.error('Erro ao carregar os tipos de usuários', error);
      }
    };
    carregarTiposUsuarios();
  }, []);

  const handleInputChange = (field, value) => {
    switch (field) {
      case 'matricula':
        setMatricula(value);
        break;
      case 'nome':
        setNome(value);
        break;
      case 'senha':
        setSenha(value);
        break;
      case 'tipoUsuario':
        setTipoUsuario(value);
        break;
      default:
        break;
    }
    setError('');
  };

  const handleImageChange = (e) => {
    const file = e.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onloadend = () => {
        setImagemBase64(reader.result); // Armazena a string completa com o prefixo
      };
      reader.readAsDataURL(file);
    }
  };

  const fazerLogin = async () => {
    setLoading(true);
    try {
      const payload = {
        nome: nome,
        matricula: matricula,
        senha: senha,
        tipo: tipoUsuario,
        imagem: imagemBase64 ? imagemBase64.split(',')[1] : '', // Remove o prefixo
      };
  
      const result = await Api.post('/user/register', payload, {
        headers: {
          'Content-Type': 'application/json',
        },
      });
  
      if (result.data) {
        success_message('Usuário registrado com sucesso!');
        navigate('/login');
      }
    } catch (error) {
      console.error('Erro ao registrar usuário', error);
      setError('Falha no registro. Por favor, tente novamente.');
    }
    setLoading(false);
  };

  return (
    <Box className={styles.fullScreen}>
      <Box className={styles.imageSection}>
        <img src={imgUnisc} alt="Imagem Unisc" className={styles.image} />
      </Box>
      <Box className={styles.loginSection}>
        <Container maxWidth="xs">
          <Box style={{ padding: 20, color: '#000000' }}>
            <Box className={styles.boxIcon}>
              <img src={logo} style={{ height: 60 }} alt="Logo" />
            </Box>
            <TextField
              placeholder="Matrícula"
              variant="outlined"
              fullWidth
              InputLabelProps={{
                shrink: true,
              }}
              className={styles.field}
              value={matricula}
              onChange={(e) => handleInputChange('matricula', e.target.value)}
              margin="normal"
            />
            <TextField
              placeholder="Nome"
              variant="outlined"
              fullWidth
              InputLabelProps={{
                shrink: true,
              }}
              className={styles.field}
              value={nome}
              onChange={(e) => handleInputChange('nome', e.target.value)}
              margin="normal"
            />
            <Senha
              value={senha}
              onChange={(e) => handleInputChange('senha', e.target.value)}
            />
            <FormControl fullWidth margin="normal">
              <InputLabel id="tipo-usuario-label">Tipo de Usuário</InputLabel>
              <Select
                labelId="tipo-usuario-label"
                value={tipoUsuario}
                onChange={(e) => handleInputChange('tipoUsuario', e.target.value)}
              >
                {tiposUsuarios.map((tipo) => (
                  <MenuItem key={tipo.id} value={tipo.id}>
                    {tipo.descricao}
                  </MenuItem>
                ))}
              </Select>
            </FormControl>
            
            {/* Bloco para inserção de imagem */}
            <Box display="flex" flexDirection="column" alignItems="center" margin="16px 0">
              <Box
                component="div"
                style={{
                  width: 100,
                  height: 100,
                  borderRadius: '50%',
                  overflow: 'hidden', // Garante que a imagem não ultrapasse os limites
                  backgroundColor: '#ddd',
                  display: 'flex',
                  alignItems: 'center',
                  justifyContent: 'center',
                }}
              >
                {imagemBase64 ? (
                  <img
                    src={imagemBase64}
                    alt="Pré-visualização"
                    style={{ width: '100%', height: '100%', objectFit: 'cover' }}
                  />
                ) : (
                  <Typography variant="caption">Sem imagem</Typography>
                )}
              </Box>
              <Button
                variant="contained"
                component="label"
                style={{ marginTop: 16, background: '#0076D7', color: '#fff' }}
              >
                Escolher foto
                <input
                  type="file"
                  accept="image/*"
                  hidden
                  onChange={handleImageChange}
                />
              </Button>
            </Box>

            <Button
              variant="contained"
              onClick={fazerLogin}
              disabled={loading}
              fullWidth
              style={{ marginTop: 16, background: '#0076D7', height: 50, fontWeight: 800, color: '#fff' }}
            >
              {loading ? <CircularProgress size={24} /> : 'Registrar Usuário'}
            </Button>
            {error && <Typography color="error" variant="body2">{error}</Typography>}
            <Box className={styles.boxIcon} style={{ marginTop: '3rem' }}>
              <img src={logoUnisc} style={{ height: 40 }} alt="Logo Unisc" />
            </Box>
          </Box>
        </Container>
      </Box>
    </Box>
  );
};

export default RegisterUser;
