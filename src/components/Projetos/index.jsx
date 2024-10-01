import React, { useState, useEffect } from 'react';
import { Container, Card, CardContent, TextField, InputAdornment } from '@mui/material';
import SearchIcon from '@mui/icons-material/Search';
import { useStyles } from './styles';
import Api from '../../services/api';

const Projetos = () => {
  const classes = useStyles();
  const [projects, setProjects] = useState([]); 
  const [searchTerm, setSearchTerm] = useState('');

  useEffect(() => {
    Api.get('/projeto/todos')
      .then((data) => {
        setProjects(data.data);
      })
      .catch((error) => {
        console.error('Erro ao buscar projetos:', error);
      });
  }, []); 

  const filteredProjects = projects.filter(project =>
    project.nome.toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <Container className={classes.container} maxWidth={'300px'} style={{ width: 300 }}>
      <span className={classes.projeto}>Projetos</span>
      <TextField
        fullWidth
        style={{ marginTop: '1rem', marginBottom: '1rem', borderRadius: 12 }}
        variant="outlined"
        placeholder="Buscar..."
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
      {filteredProjects.map((project, index) => (
        <Card key={index} className={classes.projectCard}>
          <CardContent>
            <label className={classes.projectTitle}>
              {project.nome}
            </label>
          </CardContent>
        </Card>
      ))}
    </Container>
  );
};

export default Projetos;
