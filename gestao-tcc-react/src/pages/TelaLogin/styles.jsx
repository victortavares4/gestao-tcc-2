import { makeStyles } from '@material-ui/styles';

export const useStyles = makeStyles({
  fullScreen: {
    display: 'flex',
    width: '100%',
    height: '100vh',
  },
  imageSection: {
    flex: 6,
    background: 'linear-gradient(to bottom, #915620, #2b4266, #611758)',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
  },
  boxIcon:{
    padding: '16px', 
    borderRadius: '8px', 
    textAlign: 'center', 
    marginBottom:"1rem"
  },
  image: {
    maxWidth: '80%',
    height: 'auto',
  },
  field:{
    background:"#fff",
    color:"#000",
    borderRadius:4
  },
  loginSection: {
    flex: 4,
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#2b4266',
  },
});
