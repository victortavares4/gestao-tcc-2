import React, { useState } from 'react';
import { Container, Card, CardContent, TextField, InputAdornment } from '@mui/material';
import SearchIcon from '@mui/icons-material/Search';
import { useStyles } from './styles';

const Projetos = () => {
  const classes = useStyles();

  const projects = [
    { title: 'Desenvolvimento de um Sistema de Recomendação Baseado em Machine Learning para E-commerce' },
    { title: 'Aplicação de Algoritmos de Visão Computacional para Diagnóstico Médico Automatizado'},
  ];

  const [searchTerm, setSearchTerm] = useState('');

  const filteredProjects = projects.filter(project =>
    project.title.toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <Container className={classes.container} maxWidth={'300px'} style={{width:300}}>
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
              {project.title}
            </label>
          </CardContent>          
        </Card>
      ))}
    </Container>
  );
};

export default Projetos;
