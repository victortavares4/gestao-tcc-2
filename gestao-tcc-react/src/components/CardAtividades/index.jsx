import React from "react";
import './styles.css';
export function CardAtividades(document){
  return (
    <div className="update-card">
      <div >
        {document.data.type}
      </div>
      <div className="update-content">
        <h3>{document.data.title}</h3>
        {/* <p>{props.description}</p> */}
        <div className="person-info">
          <img src={document.data.student.photo} alt={document.data.student.name} className="person-photo" />;
          <span>
            {/* <strong>Aluno:</strong> {props.student.name} <br />
            <strong>Orientador:</strong> {props.professor.name} */}
          </span>
        </div>
        <button className="history-button">Ver Histórico</button>
        <div className="last-update">
          {/* <span>última atualização: {props.lastUpdate}</span> */}
        </div>
      </div>
    </div>
  );
};

export default CardAtividades;