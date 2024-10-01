import React, { useState } from "react";
import './styles.css';
import { useNavigate } from "react-router-dom";
import { AppHelpers } from "../../utils/helpers";
import { Dialog, DialogActions, DialogContent, DialogTitle, Button, TextField } from '@mui/material';
import Api from "../../services/api";
import { error_message, success_message } from "../Toast";

const professoresData = [
  { id: 1, nome: 'Kurt Molz', tipo: 'Professor', photo: require('../../assets/images/kurt.jpg') },
  { id: 2, nome: 'Rejane Frozza', tipo: 'Professor', photo: require('../../assets/images/rejane.jpg') },
  { id: 3, nome: 'Rafael Peiter', tipo: 'Professor', photo: require('../../assets/images/rafael.png') },
  // outros professores...
];

export function CardAtividades({ data }) {
  const [openDialog, setOpenDialog] = useState(false);
  const [dialogType, setDialogType] = useState('');
  const [notaProposta, setNotaProposta] = useState(''); // Estado para a nota da proposta
  const [banca, setBanca] = useState([]);
  const [availableProfessores, setAvailableProfessores] = useState(professoresData);

  const navigate = useNavigate();
  const { description, color } = data ? AppHelpers.getStatusDetails(data.status) : { description: '', color: '' };

  const getProfessorPhotoById = (id) => {
    const professor = professoresData.find(p => p.id === id);
    return professor ? professor.photo : 'https://via.placeholder.com/60';
  };

  const alunoPhoto = getProfessorPhotoById(data?.id_aluno);
  const orientadorPhoto = getProfessorPhotoById(data?.id_orientador);

  const handleOpenDialog = (type) => {
    setDialogType(type);
    setOpenDialog(true);
  };

  const handleCloseDialog = () => {
    setOpenDialog(false);
    setDialogType('');
  };

  const handleAddProfessor = (professor) => {
    setBanca((prevBanca) => [...prevBanca, professor]);
    setAvailableProfessores((prevProfessores) => prevProfessores.filter((p) => p.id !== professor.id));
  };

  const handleRemoveProfessor = (professor) => {
    setBanca((prevBanca) => prevBanca.filter((p) => p.id !== professor.id));
    setAvailableProfessores((prevProfessores) => [...prevProfessores, professor]);
  };

  const handleConfirmBanca = () => {
    const selectedProfessors = banca.map(prof => prof.id);

    Api.post(`/criarBanca?id=${data.id}`, selectedProfessors).then(response => response.json())
      .then(result => {
        success_message('Banca criada com sucesso:', result);
        handleCloseDialog();
      })
      .catch(error => error_message('Erro ao criar banca:', error));
  };

  const handleSubmitNotaProposta = () => {
    Api.post(`/documento/avaliar/${data.id_documento}`, 
      JSON.stringify({
        idProjeto: data.id_documento,
        notaProposta: parseFloat(notaProposta)
      }),
      {
        headers: {
          'Content-Type': 'application/json'
        }
      })
      .then(response => {
        success_message('Proposta avaliada com sucesso');
        handleCloseDialog();
      })
      .catch(error => {
        error_message('Erro ao avaliar proposta:', error);
      });
  };

  const handleRejeitarProposta = () => {
    Api.post(`/documento/rejeitar/${data.id_documento}`)
      .then(response => {
        success_message('Proposta rejeitada. Reelaboração necessária.');
        handleCloseDialog();
      })
      .catch(error => {
        error_message('Erro ao rejeitar proposta:', error);
      });
  };

  return (
    <div className="update-card">
      <div className="update-header">
        <p className="document-type">{data?.tipo_documento == 3 ? 'Trabalho de Conclusao' : 'Proposta'}</p>
        <p className="document-status" style={{ backgroundColor: color }}>
          {data?.tipo_documento == 3 ? 'Em Andamento' : data?.tipo_documento == 4 ? 'Concluido' : 'Pendente'}
        </p>
      </div>
      <div className="update-content">
        <h3>{data?.nome || 'Título não disponível'}</h3>
        <p>Descrição: {data?.descricao || 'Descrição não disponível'}</p>
        <p style={{ color: 'red' }}>Prazo de envio dos documentos: {data?.submissionDeadline || '10/10/2024'}</p>
        <div className="divider"></div>
        <div className="person-info">
          <div>
            <img src={alunoPhoto} alt={data.alunoNome || 'Aluno'} className="person-photo" />
            <img src={orientadorPhoto} alt={data.orientadorNome || 'Professor'} className="person-photo" />
          </div>
          <div>
            <p>Aluno: {data.alunoNome || 'Aluno Desconhecido'}</p>
            <p>Professor: {data.orientadorNome || 'Professor Desconhecido'}</p>
          </div>
        </div>
        <div className="update-footer">
          <button onClick={() => navigate('/document')} className="history-button">Ver Histórico</button>
          <button onClick={() => handleOpenDialog('avaliar')} className="history-button">Avaliar</button>
          {data?.status === 'completed' && (
            <button onClick={() => handleOpenDialog('banca')} style={{ background: "#0076D7" }}>
              Montar Banca
            </button>
          )}
          <div className="last-update">
            <span>última atualização: {data?.lastSubmission || 'Não disponível'}</span>
          </div>
        </div>
      </div>
      {dialogType === 'avaliar' && (
        <Dialog open={openDialog} onClose={handleCloseDialog} aria-labelledby="avaliar-dialog">
          <DialogTitle id="avaliar-dialog" >AVALIAR TRABALHO DE CONCLUSÃO </DialogTitle>
        {/* ESSA DEVERÁ SER A NOTA DA BANCA */}

          <DialogContent>
          <p>Insira a nota dos professores:</p>
          {professoresData.map((e) => {
            return <TextField
            type="number"
            fullWidth
              style={{ marginTop: '1rem', marginBottom: '1rem', }}
              variant="outlined"
              placeholder={'Insira a nota do(a): ' + e.nome}

            />
          })}
          </DialogContent>
          <DialogActions>
            <Button onClick={handleCloseDialog} className="cancel-button">Cancelar</Button>
            <Button onClick={handleRejeitarProposta} className="reject-button" style={{ backgroundColor: 'red', color: 'white' }}>
              Rejeitar
            </Button>
            <Button onClick={handleSubmitNotaProposta} className="confirm-button">
              Aceitar e Avaliar
            </Button>
          </DialogActions>
        </Dialog>
      )}

      {dialogType === 'banca' && (
        <Dialog open={openDialog} onClose={handleCloseDialog} aria-labelledby="montar-banca-dialog">
          <DialogTitle id="montar-banca-dialog">Criação de Banca de Avaliação</DialogTitle>
          <DialogContent>
            <p><strong>Aluno:</strong> {data.alunoNome || 'Aluno Desconhecido'}</p>
            <p><strong>Orientador:</strong> {data.orientadorNome || 'Professor Desconhecido'}</p>
            <h3>{data?.title || 'Título não disponível'}</h3>
            <p>{data?.description || 'Descrição não disponível'}</p>
            <h4>Banca</h4>
            <div className="banca-list">
              {banca.length === 0 && <p>Nenhum professor selecionado</p>}
              {banca.map((prof) => (
                <div className="committee-member" key={prof.id}>
                  <img src={prof.photo} alt={prof.nome} className="person-photo" />
                  <p>{prof.nome}</p>
                  <button className="remove-button" onClick={() => handleRemoveProfessor(prof)}>Remover</button>
                </div>
              ))}
            </div>
            <div className="divider"></div>
            <h4>Adicionar Professores</h4>
            <div className="committee-list">
              {availableProfessores.length === 0 && <p>Todos os professores foram selecionados</p>}
              {availableProfessores.map((prof) => (
                <div className="committee-member" key={prof.id}>
                  <img src={prof.photo} alt={prof.nome} className="person-photo" />
                  <p>{prof.nome}</p>
                  <button className="add-button" onClick={() => handleAddProfessor(prof)}>Adicionar</button>
                </div>
              ))}
            </div>
          </DialogContent>
          <DialogActions>
            <Button onClick={handleCloseDialog} className="cancel-button">Cancelar</Button>
            <Button onClick={handleConfirmBanca} className="confirm-button">Confirmar</Button>
          </DialogActions>
        </Dialog>
      )}
    </div>
  );
}

export default CardAtividades;
