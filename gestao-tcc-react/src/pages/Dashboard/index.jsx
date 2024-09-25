import React from "react";
import CardAtividades from "../../components/CardAtividades";
import { Container } from "@material-ui/core";

const Dashboard = () => {
  const document = {
    'id': 1,
    'type': 'TCC',
    'student': {
      'id': 1, 'name': 'John Doe', 'registration': '12345','photo': 'https://www.designi.com.br/images/preview/12161376.jpg'
    },
    'grades': [10, 9.5],
    'professor': {
      'id': 1, 'name': 'Dr. Smith', 'type': 'Advisor', 'registration': '67890', 'photo': 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROYIxfO0el9_f17_msy47K6rpofzEQfA8Dvg&s', 'students': []
    },
    'historic': [
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
    'description': 'This is a thesis about AI',
    'title': 'Artificial Intelligence in Healthcare',
    'status': 'approved',
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
      <h1>Dashboard</h1>
      <CardAtividades data={document} />
    </div>
  );
};

export default Dashboard;
