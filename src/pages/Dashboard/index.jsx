import React from "react";
import CardAtividades from "../../components/CardAtividades";
import './styles.css';

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


const Dashboard = () => {
  const firstProfessor = documents.length > 0 ? documents[0].professor : null;

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
        {documents.map((doc) => (
          <CardAtividades key={doc.id} data={doc} />
        ))}
      </div>
      <div className="second-container"></div>
    </div>
  );
};

export default Dashboard;
