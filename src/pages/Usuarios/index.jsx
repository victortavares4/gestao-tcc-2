import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { Container, Card, CardContent, TextField, InputAdornment, Avatar, Typography, Button, Dialog, DialogActions, DialogContent, DialogContentText, DialogTitle } from '@mui/material';
import SearchIcon from '@mui/icons-material/Search';
import { useStyles } from './styles';
import Api from '../../services/api';
import { error_message, success_message } from '../../components/Toast';

const Usuarios = () => {
  const classes = useStyles();
  const navigate = useNavigate();
  const [searchTerm, setSearchTerm] = useState('');
  const [users, setUsers] = useState([]);
  const [selectedProfessor, setSelectedProfessor] = useState(null);
  const [confirmedProfessor, setConfirmedProfessor] = useState(null);
  const [open, setOpen] = useState(false);
  const [userRole, setUserRole] = useState('');

  useEffect(() => {
    Api.get('/user/findall')
      .then((response) => {
        setUsers(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.error('Erro ao buscar usuários:', error);
      });

    const storedProfessor = localStorage.getItem('userOrientador');
    const storedUserRole = localStorage.getItem('userRoles');

    if (storedProfessor) {
      setConfirmedProfessor(storedProfessor);
    }

    if (storedUserRole) {
      setUserRole(storedUserRole);
    }
  }, []);

  const handleOpenDialog = (professor) => {
    setSelectedProfessor(professor);
    setOpen(true);
  };

  const handleCloseDialog = () => {
    setOpen(false);
  };

  const handleConfirmSelection = async () => {
    const userID = localStorage.getItem('userID');

    if (!selectedProfessor) {
      error_message("Selecione um orientador antes de inserir sua proposta");
      return;
    }

    const vinculoData = {
      idAluno: parseInt(userID, 10),
      matriculaOrientador: selectedProfessor.matricula
    };

    try {
      const response = await Api.post('/user/vincular', vinculoData, {
        headers: {
          'Content-Type': 'application/json',
        }
      });

      if (response.status === 200 || response.status === 201) {
        localStorage.setItem('userOrientador', selectedProfessor.nome);
        success_message("Orientador vinculado com sucesso!");
        navigate("/");
      } else {
        error_message("Erro ao vincular o orientador. Por favor, tente novamente.");
      }
    } catch (error) {
      console.error('Erro ao vincular o orientador:', error);
      error_message("Erro ao vincular o orientador. Por favor, tente novamente.");
    } finally {
      handleCloseDialog();
    }
  };

  const filteredUsers = userRole === 'Professor'
    ? users
    : users.filter(user => user.nome.toLowerCase().includes(searchTerm.toLowerCase()) && user.tipo_descricao === 'Professor');

  return (
    <Container className={classes.container} maxWidth="lg">
      <div style={{ display: "flex", justifyContent: "space-between", padding: "0px" }}>
        <h2>Usuários</h2>
        <div className={classes.noProfessorContainer}>
          {confirmedProfessor ? (
            <div className={classes.confirmedProfessor}>
              <Avatar
                src={`data:image/png;base64,${confirmedProfessor.imagem}`}
                className={classes.avatar}
              />
              <Typography className={classes.confirmedProfessorName}>{confirmedProfessor.nome}</Typography>
            </div>
          ) : (
            <div className={classes.noProfessor}>
              <Avatar className={classes.noProfessorAvatar} />
              <Typography className={classes.noProfessorText}>Sem Orientador</Typography>
            </div>
          )}
        </div>
      </div>
      <div className="divider"></div>
      <TextField
        fullWidth
        variant="outlined"
        placeholder="Buscar..."
        style={{ marginTop: '1rem', marginBottom: '1rem', borderRadius: 12 }}
        className={classes.searchBar}
        value={searchTerm}
        onChange={(e) => setSearchTerm(e.target.value)}
        InputProps={{
          startAdornment: (
            <InputAdornment position="start">
              <SearchIcon />
            </InputAdornment>
          ),
        }}
      />

      {filteredUsers.map((user, index) => (
        <Card key={index} className={classes.professorCard}>
          <Avatar
            src={`data:image/png;base64,${user.imagem}`} // Use the base64 image string from the backend
            className={classes.avatar}
          />
          <CardContent className={classes.professorInfo}>
            <span className={classes.professorName}>{user.nome}</span>
            <Typography className={classes.professorType}>{user.tipo_descricao}</Typography>
          </CardContent>
          {confirmedProfessor && confirmedProfessor.matricula === user.matricula ? (
            <Button variant="contained" className={classes.confirmButton}>
              Orientador Confirmado
            </Button>
          ) : confirmedProfessor ? (
            null
          ) : (
            <Button variant="contained" className={classes.actionButton} onClick={() => handleOpenDialog(user)}>
              Solicitar Orientação
            </Button>
          )}
        </Card>
      ))}

      <Dialog open={open} onClose={handleCloseDialog} aria-labelledby="form-dialog-title">
        <DialogTitle id="form-dialog-title">Solicitação de Orientação</DialogTitle>
        <DialogContent>
          <DialogContentText>
            Enviar solicitação de orientação de proposta para este professor?
          </DialogContentText>
          {selectedProfessor && (
            <div className={classes.selectedProfessor}>
              <Avatar src={`data:image/png;base64,${selectedProfessor.imagem}`} className={classes.modalAvatar} />
              <Typography className={classes.selectedProfessorName}>{selectedProfessor.nome}</Typography>
            </div>
          )}
        </DialogContent>
        <DialogActions>
          <Button onClick={handleCloseDialog} className={classes.cancelButton}>
            Cancelar
          </Button>
          <Button onClick={handleConfirmSelection} className={classes.confirmButton} variant="contained">
            Confirmar
          </Button>
        </DialogActions>
      </Dialog>
    </Container>
  );
};

export default Usuarios;
