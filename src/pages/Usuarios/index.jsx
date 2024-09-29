import React, { useState, useEffect } from 'react';
import { Container, Card, CardContent, TextField, InputAdornment, Avatar, Typography, Button, Dialog, DialogActions, DialogContent, DialogContentText, DialogTitle } from '@mui/material';
import SearchIcon from '@mui/icons-material/Search';
import { useStyles } from './styles';

const getProfessorImage = (id) => {
  const imageMap = {
    1: require('../../assets/images/kurt.jpg'),
    2: require('../../assets/images/rejane.jpg'),
    3: require('../../assets/images/rafael.png'),
  };
  return imageMap[id] || require('../../assets/images/imageUnisc.png');
};

const Usuarios = () => {
  const classes = useStyles();

  const professores = [
    { id: 1, nome: 'Kurt Molz', tipo: 'Professor' },
    { id: 2, nome: 'Rejane Frozza', tipo: 'Professor' },
    { id: 3, nome: 'Rafael Peiter', tipo: 'Professor' }
  ];

  const [searchTerm, setSearchTerm] = useState('');
  const [selectedProfessor, setSelectedProfessor] = useState(null);
  const [confirmedProfessor, setConfirmedProfessor] = useState(null); 
  const [open, setOpen] = useState(false);
  const [userRole, setUserRole] = useState('');

  useEffect(() => {
    const storedProfessor = localStorage.getItem('professorOrientador');
    const storedUserRole = localStorage.getItem('userRole');

    if (storedProfessor) {
      setConfirmedProfessor(JSON.parse(storedProfessor));
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

  const handleConfirmSelection = () => {
    setConfirmedProfessor(selectedProfessor);
    localStorage.setItem('professorOrientador', JSON.stringify(selectedProfessor));
    handleCloseDialog();
  };

  const filteredProfessores = userRole === 'roleOrientador' 
    ? professores 
    : professores.filter(prof => prof.nome.toLowerCase().includes(searchTerm.toLowerCase()));

  return (
    <Container className={classes.container} maxWidth="lg">
      <div style={{ display: "flex", justifyContent: "space-between" }}>
        <span className={classes.header}>Usuários</span>
        <div className={classes.noProfessorContainer}>
          {confirmedProfessor ? (
            <div className={classes.confirmedProfessor}>
              <Avatar 
                src={getProfessorImage(confirmedProfessor.id)} 
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

      {filteredProfessores.map((prof, index) => (
        <Card key={index} className={classes.professorCard}>
          <Avatar 
            src={getProfessorImage(prof.id)} 
            className={classes.avatar} 
          />
          <CardContent className={classes.professorInfo}>
            <span className={classes.professorName}>{prof.nome}</span>
            <Typography className={classes.professorType}>{prof.tipo}</Typography>
          </CardContent>
          {confirmedProfessor && confirmedProfessor.id === prof.id ? (
            <Button variant="contained" className={classes.confirmButton}>
              Orientador Confirmado
            </Button>
          ) : confirmedProfessor ? (
            null
          ) : (
            <Button variant="contained" className={classes.actionButton} onClick={() => handleOpenDialog(prof)}>
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
              <Avatar src={getProfessorImage(selectedProfessor.id)} className={classes.modalAvatar} />
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
