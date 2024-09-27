import { useNavigate } from "react-router-dom";
import { AppHelpers } from "../../utils/helpers";
import { useLocation } from 'react-router-dom';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import { useState } from "react";
import './styles.css';


const Document = () => {
    const navigate = useNavigate();
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
                "id": 1,
                "user": "John Doe",
                "description": "Initial submission of the document."
            },
            {
                "id": 1,
                "user": "John Doe",
                "description": "Initial submission of the document."
            },
            {
                "id": 1,
                "user": "John Doe",
                "description": "Initial submission of the document."
            },
            {
                "id": 1,
                "user": "John Doe",
                "description": "Initial submission of the document."
            },
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



    const { description, color } = AppHelpers.getStatusDetails(document.status);
    const [message, setMessage] = useState('');
    const [selectedDate, setSelectedDate] = useState(null);

    const handleDateChange = (date) => {
        setSelectedDate(date);
    };
    const handleSendMessage = () => {
        if (message.trim()) {
            console.log('Mensagem enviada:', message);
            setMessage(''); // Limpa o campo após o envio
        }
    };
    return (
        <><div className="document">
            <button onClick={event => {
                navigate('/');
            }}>voltar</button>
            <div className="first-container">
                <div className="document-card">
                    <div className="document-header">
                        <p className="document-type">{document.type}</p>
                        <p className="document-status" style={{ backgroundColor: color }}>
                            {description}
                        </p>
                    </div>
                    <div className="document-content">
                        <h3>{document.title}</h3>
                        <p>Descrição: {document.description}</p>
                        <div className="divider"></div>
                        <div className="document-person-info">
                            <div className="first-container-person-info">
                                <div>
                                    <img src={document.student.photo} alt={document.student.name} className="person-photo" />
                                    <img src={document.professor.photo} alt={document.professor.name} className="person-photo" />
                                </div>
                                <div>
                                    <p>Aluno: {document.student.name}</p>
                                    <p>Professor: {document.professor.name}</p>
                                </div>
                            </div>
                            <div className="file-button-container">
                                <button>Arquivo.pdf</button>
                                <div className="last-update">
                                    <span>última atualização: {document.lastSubmission}</span>
                                </div>
                            </div>
                        </div>
                        <div className="divider"></div>
                        <div className="comments-and-meetings-container">
                            <div className="comments-container">
                                <div>
                                    <h3>Comentários</h3>
                                    <div className="group-comments">
                                        <div class='comment'>
                                            {document.comments.map((comment) => (
                                                <div key={comment.id} className="comment-item">
                                                    <p><strong>{comment.user}</strong>: {comment.description}</p>
                                                </div>
                                            ))}
                                        </div>

                                    </div>
                                </div>
                                <div className="chat-container">
                                    <div className="chat-input-wrapper">
                                        <input
                                            type="text"
                                            className="chat-input"
                                            placeholder="Digite sua mensagem..."
                                            value={message}
                                            onChange={(e) => setMessage(e.target.value)} />
                                        <button className="chat-send-button" onClick={handleSendMessage}>
                                            Enviar
                                        </button>
                                    </div>
                                </div>
                            </div>
                            <div className="meetings-container">
                                <div>
                                    <h3>Histórico de Reuniões</h3>
                                    <div className="group-meetings">
                                        <div class='meeting'>
                                            {document.meetings.map((meeting) => (
                                                <div key={meeting} className="meeting-item">
                                                    <p><strong>{meeting.dateTime}</strong>: {meeting.description}</p>
                                                </div>
                                            ))}
                                        </div>

                                    </div>
                                </div>
                                <div className="chat-container">
                                    <div className="chat-input-wrapper">
                                        <input
                                            type="text"
                                            className="date-input"
                                            value={selectedDate ? selectedDate.toLocaleString() : ''}
                                            placeholder="Selecione data e horário"
                                            readOnly
                                        />
                                        <DatePicker
                                            selected={selectedDate}
                                            onChange={handleDateChange}
                                            showTimeSelect
                                            dateFormat="Pp"
                                            placeholderText="Clique para escolher a data"
                                            customInput={<button className="open-calendar-button">Calendário</button>} />
                                    </div>
                                    <button className="chat-send-button" onClick={handleSendMessage}>
                                            Confirmar
                                        </button>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div><div className="second-container">
            </div></>

    );
};

export default Document;
