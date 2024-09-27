import React from "react";
import './styles.css';
import { useNavigate } from "react-router-dom";
import { AppHelpers } from "../../utils/helpers";


export function CardAtividades(document) {

  const navigate = useNavigate();
  const { description, color } = AppHelpers.getStatusDetails(document.data.status);



  return (
    <div className="update-card">
      <div className="update-header" >
        <p className="document-type">{document.data.type}</p>
        {/* TODO: FAZER ESSA LÓGICA MELHOR */}
        
        <p className="document-status" style={{ backgroundColor: color }}>
          {description}
        </p>
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
          <button onClick={event => {
            navigate('document')
          }} className="history-button">Ver Histórico</button>
          <div className="last-update">
            <span>última atualização: {document.data.lastSubmission}</span>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CardAtividades;