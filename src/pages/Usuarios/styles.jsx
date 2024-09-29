import { makeStyles } from '@material-ui/styles';

export const useStyles = makeStyles({
  container: {
    padding: '30px 10px',
    background: '#f5f5f5',
  },
  header: {
    color: '#2B4266',
    fontWeight: 700,
    fontSize: 24,
    marginBottom: '20px',
  },
  searchBar: {
    marginBottom: '20px',
    borderRadius: 12,
  },
  professorCard: {
    display: 'flex',
    alignItems: 'center',
    marginBottom: '15px',
    padding: '10px',
    backgroundColor: '#fff',
    borderRadius: '15px',
    boxShadow: '0px 4px 12px rgba(0, 0, 0, 0.1)',
  },
  avatar: {
    width: 60,
    height: 60,
    marginRight: '15px',
  },
  professorInfo: {
    flexGrow: 1,
  },
  professorName: {
    fontWeight: 700,
    fontSize: 16,
    color: '#2B4266',
  },
  professorType: {
    fontWeight: 500,
    fontSize: 14,
    color: '#888',
  },
  actionButton: {
    backgroundColor: '#2B4266',
    color: '#fff',
    fontWeight: 600,
    borderRadius: '10px',
    padding: '10px 20px',
  },
  noProfessor: {
    display: 'flex',
    alignItems: 'center',
    marginTop: '20px',
  },
  noProfessorAvatar: {
    width: 60,
    height: 60,
    backgroundColor: '#e0e0e0',
  },
  confirmedProfessor:{
    display:"flex",
    justifyContent:"center",
    alignItems:"center"
  },
  noProfessorText: {
    marginLeft: '15px',
    fontSize: 16,
    color: '#888',
  },
  modalAvatar: {
    width: 60,
    height: 60,
    marginRight: '15px',
  },
  selectedProfessor: {
    display: 'flex',
    alignItems: 'center',
    marginTop: '10px',
  },
  selectedProfessorName: {
    fontWeight: 700,
    fontSize: 18,
    color: '#2B4266',
  },
  cancelButton: {
    color: '#2B4266',
    fontWeight: 600,
  },
  confirmButton: {
    backgroundColor: '#2B4266',
    color: '#fff',
    fontWeight: 600,
  },
});
