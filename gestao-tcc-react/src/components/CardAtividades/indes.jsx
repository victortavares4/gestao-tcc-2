import React from "react";

const CardAtividades = ({ type, title, description, student, supervisor, lastUpdate, status }) => {
  return (
    <div className="update-card">
      <div >
        {type}
      </div>
      <div className="update-content">
        <h3>{title}</h3>
        <p>{description}</p>
        <div className="person-info">
          {/* <img src={student.photo} alt={student.name} className="person-photo" /> */}
          <span>
            <strong>Aluno:</strong> meu nome <br />
            <strong>Orientador:</strong> {supervisor}
          </span>
        </div>
        <button className="history-button">Ver Histórico</button>
        <div className="last-update">
          <span>última atualização: {lastUpdate}</span>
        </div>
      </div>
    </div>
  );
};

export default CardAtividades;
