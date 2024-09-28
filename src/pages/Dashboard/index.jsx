import React from "react";
import CardAtividades from "../../components/CardAtividades";
import { Diversity1Outlined } from "@mui/icons-material";
import './styles.css';
const Dashboard = () => {
  const document = {
    'id': 1,
    'type': 'Trabalho de Conclusão',
    'student': {
      'id': 1, 'name': 'John Doe', 'registration': '12345', 'photo': 'https://www.designi.com.br/images/preview/12161376.jpg'
    },
    'grades': [10, 9.5],
    'professor': {
      'id': 1, 'name': 'Dr. Smith', 'type': 'Advisor', 'registration': '67890', 'photo': 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROYIxfO0el9_f17_msy47K6rpofzEQfA8Dvg&s', 'students': []
    },
    'comments': [
      {
        "id": 1,
        "user": "John Doe",
        "description": "Initial submission of the document."
      },
      {
        "id": 2,
        "user": "Dr. Smith",
        "description": "Reviewed and approved with minor corrections."
      }

    ],
    "meetings": [
      {
        "id": 1,
        "dateTime": "2024-09-15T10:00:00",
        "description": "Initial review meeting."
      },
      {
        "id": 2,
        "dateTime": "2024-09-22T14:30:00",
        "description": "Follow-up meeting with corrections."
      }
    ],
    'lastSubmission': '2024-09-24',
    'deadline': '2024-10-10',
    'description': 'Implementar um sistema que sugira produtos aos usuários com base em suas interações anteriores, utilizando técnicas de aprendizado de máquina e processamento de dados.',
    'title': 'Desenvolvimento de um Sistema de Recomendação Baseado em Machine Learning para E-commerce',
    'status': 'pending',
    'committee': {
      'id': 1,
      'student': {
        'id': 1, 'name': 'John Doe', 'registration': '12345', 'photo': 'https://www.designi.com.br/images/preview/12161378.jpg'
      },
      'professors': {
        'id': 1, 'name': 'Dr. Smith', 'type': 'Advisor', 'registration': '67890', 'photo': 'https://www.designi.com.br/images/preview/12161376.jpg', 'students': [],
      },
      'coordinator': {
        'id': 1, 'name': 'Dr. Abravanel', 'type': 'Advisor', 'registration': '67890', 'students': [],
      },
    },
  };
  return (
    <div className="dashboard">
      <div className="header-container">
      <h2>Últimas atualizações</h2>
      <div className="advisor-container">
      <img src={document.professor.photo} alt={document.professor.name} className="person-photo" />
      <span>{document.professor.name}</span>
      </div>
      </div>
      <div className="divider"></div>
      <div className="first-container">
        <CardAtividades data={document} />
        <CardAtividades data={document} />
        <CardAtividades data={document} />
      </div>
      <div className="second-container">
      </div>
    </div>
  );
};

export default Dashboard;
