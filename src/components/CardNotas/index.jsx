import { AppHelpers } from "../../utils/helpers";
import './styles.css';

export function CardNotas(document) {
    const { description, color } = AppHelpers.getStatusDetails(document.data.status);
    return (
        <div className="activity-card-container">
            <div className="activity-card-header">
                <h3>{document.data.title}</h3>
                <p className="activity-card-status" style={{ backgroundColor: color }}>
                    {description}
                </p>
            </div>
            <div className="activity-card-content">
                <p>{document.data.description}</p>
            </div>
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
                <h1 className="activity-card-grades" style= {{backgroundColor: color}}>Nota: {document.data.grades[0]}</h1>
        </div>
    );
}

export default CardNotas;