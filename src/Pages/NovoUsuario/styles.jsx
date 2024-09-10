
import { makeStyles } from '@material-ui/styles';

export const useStyles = makeStyles({
  sidebar: {
    width: 200,
    height: "100%",
    position: "fixed",
    top: 0,
    left: 0,
    backgroundColor: "#111",
    paddingTop: 20,
    zIndex: 1000,
    transition: 'left 0.3s',
  },
  boxes:{
    pointerEvents: 'none', 
    backgroundColor: 'transparent'
  },
  box:{
    position: 'absolute', 
    top: 100, 
    left: '50%', 
    transform: 'translateX(-50%)', 
    zIndex: 1000, 
    color: 'white', 
    width: '90%', 
    pointerEvents: 'none'
  },
  title:{
    position: 'absolute', 
    top: 30, 
    left: '50%', 
    transform: 'translateX(-50%)', 
    color: 'white', 
    zIndex: 1000, 
    pointerEvents: 'none'
  },
  open: {
    left: 0,
  },
  closeBtn: {
    position: "absolute",
    top: 10,
    right: 10,
    background: "none",
    border: "none",
    color: "white",
    fontSize: 20,
  },
  ul: {
    listStyleType: "none",
    padding: 0,
  },
  fisrtLi: {
    padding: 8,
    textAlign: "center",
    borderBottom: "1px solid #444",
  },
  hamburgerBtn: {
    position: 'absolute',
    top: '10px',
    left: '10px',
    fontSize: '24px',
    color: 'white',
    background: 'transparent',
    border: 'none',
    cursor: 'pointer',
    zIndex: 2000
  },
  fullScreen: {
    width: '100%',
    height: '100vh',
    position: 'absolute',
    top: 0,
    left: 0,
    zIndex: -1
  },
  hide: {
    display: 'none'
  }
});
