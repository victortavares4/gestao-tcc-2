import React, { useState, useEffect } from "react";
import CardAtividades from "../../components/CardAtividades";
import './styles.css';
import { Dialog, DialogActions, DialogContent, DialogTitle, Button, TextField } from '@mui/material';
import Api from "../../services/api";

const Dashboard = ({ role }) => {
  const [openDialog, setOpenDialog] = useState(false);
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [selectedFile, setSelectedFile] = useState(null);
  const [fileError, setFileError] = useState(''); 
  const storedUserRole = localStorage.getItem('userRoles');
  const IDUser = localStorage.getItem('userID');

  const [documents, setDocuments] = useState([]);

  useEffect(() => {
    if (storedUserRole === "Aluno") {
      Api.get(`/projeto/aluno/${IDUser}`)
        .then((response) => {
          setDocuments(response.data);
        })
        .catch((error) => {
          console.error('Erro ao buscar projetos:', error);
        });
    } else {
      Api.get('/projeto/todos')
        .then((response) => {
          setDocuments(response.data);
        })
        .catch((error) => {
          console.error('Erro ao buscar projetos:', error);
        });
    }
  }, []);

  const handleOpenDialog = () => setOpenDialog(true);
  const handleCloseDialog = () => {
    setOpenDialog(false);
    setSelectedFile(null);
    setFileError('');
  };

  const handleSubmit = () => {
    if (selectedFile && selectedFile.type === 'application/pdf') {
      const formData = new FormData();
      
      formData.append('id_aluno', 3);
      formData.append('id_orientador', 6);
      formData.append('nome', title); 
      formData.append('descricao', description);
      formData.append('arquivo', selectedFile);
  
      Api.post('/projeto/criar', formData)
        .then(response => {
          console.log("Proposta submetida com sucesso:", response.data);
          setOpenDialog(false);
          setTitle('');
          setDescription('');
          setSelectedFile(null);
        })
        .catch(error => {
          console.error("Erro ao submeter proposta:", error);
          setFileError('Erro ao submeter a proposta. Por favor, tente novamente.');
        });
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
          {/* {firstProfessor && storedUserRole === "aluno" && (
            <>
              <img src={firstProfessor.photo} alt={firstProfessor.name} className="person-photo" />
              <span>{firstProfessor.name}</span>
            </>
          )} */}
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
