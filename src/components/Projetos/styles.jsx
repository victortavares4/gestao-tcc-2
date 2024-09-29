import { makeStyles } from '@material-ui/styles';

export const useStyles = makeStyles({
    container: {
        padding: '30px 10px',
        width: 300,
        background: '#fff',
        boxShadow: '0px 4px 12px rgba(0, 0, 0, 0.1)',
    },
    searchBar: {
        marginBottom: '20px',
        borderRadius: 12,
        marginTop: 16
    },
    projectCard: {
        display: 'flex',
        alignItems: 'center',
        marginBottom: '15px',
        padding: '10px',
        borderRadius: '15px',
        boxShadow: '0px 4px 12px rgba(0, 0, 0, 0.1)',
    },
    projectTitle: {
        fontWeight: 700,
        fontSize:14,
        color: '#0076D7',
        marginBottom: '3px',
    },
    avatarStack: {
        marginLeft: 'auto',
        display: 'flex',
        gap: '5px',
    },
    avatar: {
        width: 30,
        height: 30,
    },
    projeto: {
        color: "#2B4266",
        fontWeight: 700,
        fontSize: 24
    },
});