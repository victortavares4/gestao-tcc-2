import React, { useState } from "react";
import CardAtividades from "../../components/CardAtividades";
import './styles.css';
import { Dialog, DialogActions, DialogContent, DialogTitle, Button, TextField } from '@mui/material';

const documents = [
  {
    'id': 1,
    'type': 'Trabalho de Conclusão',
    'student': {
      'id': 1, 'name': 'John Doe', 'registration': '12345', 'photo': 'https://www.designi.com.br/images/preview/12161376.jpg'
    },
    'grades': [10, 9.5],
    'professor': {
      'id': 1, 'name': 'Dr. Smith', 'type': 'Advisor', 'registration': '67890', 'photo': 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROYIxfO0el9_f17_msy47K6rpofzEQfA8Dvg&s', 'students': []
    },
    'status': 'pending',
    'lastSubmission': '2024-09-24',
    'title': 'Desenvolvimento de um Sistema de Recomendação Baseado em Machine Learning para E-commerce',
  },
  {
    'id': 2,
    'type': 'Trabalho de Conclusão',
    'student': {
      'id': 2, 'name': 'Victor Hugo Tavares Brum', 'registration': '54321', 'photo': 'https://www.designi.com.br/images/preview/12161379.jpg'
    },
    'grades': [10, 9.5],
    'professor': {
      'id': 2, 'name': 'Kurt Molz', 'type': 'Advisor', 'registration': '98765', 'photo': 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROYIxfO0el9_f17_msy47K6rpofzEQfA8Dvg&s', 'students': []
    },
    'status': 'pending',
    'lastSubmission': '2024-08-26',
    'title': 'Desenvolvimento de um Sistema de Recomendação Baseado em Machine Learning para E-commerce',
  },
  {
    'id': 3,
    'type': 'Trabalho de Conclusão',
    'student': {
      'id': 3, 'name': 'Carlos Silva', 'registration': '67890', 'photo': 'https://www.designi.com.br/images/preview/12161380.jpg'
    },
    'grades': [10, 9.5],
    'professor': {
      'id': 3, 'name': 'Dr. Maria', 'type': 'Advisor', 'registration': '54321', 'photo': 'https://www.designi.com.br/images/preview/12161381.jpg', 'students': []
    },
    'status': 'completed',
    'lastSubmission': '2024-09-15',
    'title': 'Desenvolvimento de um Sistema de Recomendação Personalizado para E-commerce',
  }
];

const Dashboard = ({ role }) => {
  const [openDialog, setOpenDialog] = useState(false);
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [selectedFile, setSelectedFile] = useState(null);
  const [fileError, setFileError] = useState(''); 

  const firstProfessor = documents.length > 0 ? documents[0].professor : null;

  const handleOpenDialog = () => setOpenDialog(true);
  const handleCloseDialog = () => {
    setOpenDialog(false);
    setSelectedFile(null);
    setFileError('');
  };

  const handleSubmit = () => {
    if (selectedFile && selectedFile.type === 'application/pdf') {
      console.log("Submitting proposal with title:", title, "description:", description, "and file:", selectedFile.name);
      setOpenDialog(false);
    } else {
      setFileError('Por favor, insira um arquivo PDF válido.');
    }
  };

  const handleFileChange = (e) => {
    const file = e.target.files[0];
    if (file && file.type === 'application/pdf') {
      setSelectedFile(file);
      setFileError('');
    } else {
      setSelectedFile(null);
      setFileError('Apenas arquivos PDF são permitidos.');
    }
  };

  return (
    <div className="dashboard">
      <div className="header-container">
        <h2>Últimas atualizações</h2>
        <div className="advisor-container">
          {firstProfessor && (
            <>
              <img src={firstProfessor.photo} alt={firstProfessor.name} className="person-photo" />
              <span>{firstProfessor.name}</span>
            </>
          )}
        </div>
      </div>
      <div className="divider"></div>
      <div className="first-container">
        {documents.length > 0 ? (
          documents.map((doc) => (
            <CardAtividades  key={doc.id} data={doc} />
          ))
        ) : role === "Aluno" ? (
          <div className="no-documents">
            <p>Não há documentos vinculados a este usuário.</p>
            <Button variant="contained" color="primary" onClick={handleOpenDialog}>
              Submeter Proposta
            </Button>
          </div>
        ) : (
          <div className="no-documents">
            <p>Não há documentos vinculados a este usuário.</p>
            <Button variant="contained" color="primary" onClick={handleOpenDialog}>
              Submeter Proposta
            </Button>
          </div>
        )}
      </div>

      <Dialog open={openDialog} onClose={handleCloseDialog}>
        <DialogTitle>SUBMISSÃO DE PROPOSTA</DialogTitle>
        <DialogContent>
          <p>Preencha os campos para enviar sua Proposta do Trabalho de Conclusão</p>
          <TextField
            label="Título da Proposta"
            fullWidth
            margin="normal"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
          />
          <TextField
            label="Descrição"
            fullWidth
            margin="normal"
            multiline
            rows={4}
            value={description}
            onChange={(e) => setDescription(e.target.value)}
          />
          <div className="file-upload">
            <Button variant="contained" component="label">
              Inserir Seu Documento
              <input
                type="file"
                hidden
                accept=".pdf"
                onChange={handleFileChange}
              />
            </Button>
            {selectedFile && (
              <p className="file-name">Arquivo: {selectedFile.name}</p>
            )}
            {fileError && <p className="file-error">{fileError}</p>}
          </div>
        </DialogContent>
        <DialogActions>
          <Button onClick={handleCloseDialog} className="cancel-button">Cancelar</Button>
          <Button onClick={handleSubmit} className="confirm-button">Confirmar</Button>
        </DialogActions>
      </Dialog>
    </div>
  );
};

export default Dashboard;
