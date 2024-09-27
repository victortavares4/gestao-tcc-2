import { useNavigate } from "react-router-dom";
import { AppHelpers } from "../../utils/helpers";

const Document = () => {
    const navigate = useNavigate();
    const { description, color } = AppHelpers.getStatusDetails(document.status);

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
        'description': 'Implementar um sistema que sugira produtos aos usuários com base em suas interações anteriores, utilizando técnicas de aprendizado de máquina e processamento de dados.',
        'title': 'Desenvolvimento de um Sistema de Recomendação Baseado em Machine Learning para E-commerce',
        'status': 'inProgress',
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
        <div className="document">
            <button>voltar</button>
            <div className="first-container">
                <div className="update-card">
                    <div className="update-header" >
                        <p className="document-type">{document.type}</p>
                        {/* TODO: FAZER ESSA LÓGICA MELHOR */}
                        <p className="document-status" style={{ backgroundColor: color }}>
                        {description}
                        </p>
                    </div>
                    <div className="update-content">
                        <h3>{document.title}</h3>
                        <p>Descrição: {document.description}</p>
                        <div className="divider"></div>
                        <div className="person-info">
                            <div>
                                <img src={document.student.photo} alt={document.student.name} className="person-photo" />
                                <img src={document.professor.photo} alt={document.professor.name} className="person-photo" />
                            </div>
                            <div>
                                <p>Aluno: {document.student.name}</p>
                                <p>Professor: {document.professor.name}</p>
                            </div>
                        </div>
                        <div className="update-footer">
                            <button onClick={event => {
                                navigate('document')
                            }} className="history-button">Ver Histórico</button>
                            <div className="last-update">
                                <span>última atualização: {document.lastSubmission}</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div className="second-container">
                <p>segundo container</p>
            </div>
        </div>
    );
};

export default Document;
