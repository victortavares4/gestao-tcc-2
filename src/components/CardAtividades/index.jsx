import React from "react";
import './styles.css';
export function CardAtividades(document){
  return (
    <div className="update-card">
      <div className="update-header" >
        <p className="document-type">{document.data.type}</p>
        {/* TODO: FAZER ESSA LÓGICA MELHOR */}
        <p className="document-status">{document.data.status== 'pending'? 'Pendente':'Aprovado'}</p>
      </div>
      <div className="update-content">
        <h3>{document.data.title}</h3>
        <p>Descrição: {document.data.description}</p>
        <div className="divider"></div>
        <div className="person-info">
          <div>
          <img src={document.data.student.photo} alt={document.data.student.name} className="person-photo" />
          <img src={document.data.professor.photo} alt={document.data.professor.name} className="person-photo" />
          </div>
          <div>
            <p>Aluno: {document.data.student.name}</p>
            <p>Professor: {document.data.professor.name}</p>
          </div>
        </div>
        <div className="update-footer">
        <button className="history-button">Ver Histórico</button>
        <div className="last-update">
          <span>última atualização: {document.data.lastSubmission}</span>
        </div>
        </div>
      </div>
    </div>
  );
};

export default CardAtividades;