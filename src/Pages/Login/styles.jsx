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
  open: {
    left: 0,
  },
  title: {
    fontSize: 30,
    fontWeight:700
  },
  container: {
    display: 'flex',
    width:"75%",
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