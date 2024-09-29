import React, { useState } from "react";
import './styles.css';
import { useNavigate } from "react-router-dom";
import { AppHelpers } from "../../utils/helpers";
import { Dialog, DialogActions, DialogContent, DialogTitle, Button, TextField } from '@mui/material';

const professoresData = [
  { id: 1, nome: 'Kurt Molz', tipo: 'Professor', photo: require('../../assets/images/kurt.jpg') },
  { id: 2, nome: 'Rejane Frozza', tipo: 'Professor', photo: require('../../assets/images/rejane.jpg') },
  { id: 3, nome: 'Rafael Peiter', tipo: 'Professor', photo: require('../../assets/images/rafael.png') }
];

export function CardAtividades({ data }) {
  const [openDialog, setOpenDialog] = useState(false);
  const [dialogType, setDialogType] = useState('');
  const [banca, setBanca] = useState([]);
  const [availableProfessores, setAvailableProfessores] = useState(professoresData);

  const navigate = useNavigate();
  const { description, color } = data ? AppHelpers.getStatusDetails(data.status) : { description: '', color: '' };

  const student = data?.student || {};
  const professor = data?.professor || {};

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

  return (
    <div className="update-card">
      <div className="update-header">
        <p className="document-type">{data?.type || 'Documento Desconhecido'}</p>
        <p className="document-status" style={{ backgroundColor: color }}>
          {description}
        </p>
      </div>
      <div className="update-content">
        <h3>{data?.title || 'Título não disponível'}</h3>
        <p>Descrição: {data?.description || 'Descrição não disponível'}</p>
        <div className="divider"></div>
        <div className="person-info">
          <div>
            <img src={student.photo || 'https://via.placeholder.com/60'} alt={student.name || 'Aluno'} className="person-photo" />
            <img src={professor.photo || 'https://via.placeholder.com/60'} alt={professor.name || 'Professor'} className="person-photo" />
          </div>
          <div>
            <p>Aluno: {student.name || 'Aluno Desconhecido'}</p>
            <p>Professor: {professor.name || 'Professor Desconhecido'}</p>
          </div>
        </div>
        <div className="update-footer">
          <button onClick={() => navigate('/document')} className="history-button">Ver Histórico</button>
          <button onClick={() => handleOpenDialog('avaliar')} className="history-button">Avaliar</button>
          <div className="last-update">
            <span>última atualização: {data?.lastSubmission || 'Não disponível'}</span>
          </div>
        </div>
      </div>

      {data?.status === 'completed' && (
        <button onClick={() => handleOpenDialog('banca')} className="montar-banca-button">
          Montar Banca
        </button>
      )}

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
            <Button onClick={handleCloseDialog} className="confirm-button">Confirmar</Button>
          </DialogActions>
        </Dialog>
      )}

      {/* Montar Banca Dialog */}
      {dialogType === 'banca' && (
        <Dialog open={openDialog} onClose={handleCloseDialog} aria-labelledby="montar-banca-dialog">
          <DialogTitle id="montar-banca-dialog">Criação de Banca de Avaliação</DialogTitle>
          <DialogContent>
            <p><strong>Aluno:</strong> {student.name || 'Aluno Desconhecido'}</p>
            <p><strong>Orientador:</strong> {professor.name || 'Professor Desconhecido'}</p>
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
            <Button onClick={handleCloseDialog} className="confirm-button">Confirmar</Button>
          </DialogActions>
        </Dialog>
      )}
    </div>
  );
}

export default CardAtividades;
