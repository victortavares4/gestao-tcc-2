import { createGlobalStyle } from 'styled-components';

export default createGlobalStyle`
    /* Importando a fonte Poppins */
    @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap');

    .toast{
        opacity: 1!important;
        box-shadow: none!important;
    }

    ::-webkit-scrollbar {
        width: 8px;
        height: 8px;
    }

    /* Track */
    ::-webkit-scrollbar-track {
        background: #f1f1f120;
    }

    /* Handle */
    ::-webkit-scrollbar-thumb {
        background: #102A6330;
        border-radius: 10px;
    }

    /* Handle on hover */
    ::-webkit-scrollbar-thumb:hover {
        background: #102A6330;
    }

    /* Track */
    ::-webkit-scrollbar-track {
        background: #f1f1f120;
    }

    /* Handle */
    ::-webkit-scrollbar-thumb {
        background: #16274d;
    }

    /* Handle on hover */
    ::-webkit-scrollbar-thumb:hover {
        background: #16274d;
    }

    .toast-info{
        background-color: #B0B0BB;
        border-color: #B0B0BB;
        color: white;
    }

    .toast-warning{
        background-color: #FFDA7E;
        border-color: #FFDA7E;
        color: white;
    }

    .toast-success{
        background-color: #228B22;
        border-color: #228B22;
        color: white;
    }

    .toast-error{
        background-color: #FF0000;
        border-color: #FF0000;
        color: white;
    }

    .sticky-top{
        z-index: 998;
    }

    .react-datepicker-popper {
        z-index: 999 !important;
    }

    #react-select-3-listbox {
        z-index: 999;
    }

    .text-right {
        text-align: right !important;
    }

    body{
        margin-left: 0px !important;
        background-color: #F6F8FA;
    }

    h3{
        font-size: 16px;
        color: black;
        font-weight: bold;
        text-shadow: 0px 3px 20px #0000000D;
    }

    * {
        font-family: 'Poppins', sans-serif;
    }

    html {
        font-size: 14px;
        position: relative;
        min-height: 100%;
    }

    body .modal-password {
        padding-right: 0 !important;
    }

    .modal-password > div {
        float: right;
        top: 0;
        width: 25%;
        align-items: stretch;
        margin: 0;
    }

    .btn-close:focus{
        box-shadow: none;
    }

    .chat_modal .modal-content{
        align-items: center;
    }

    .closebtn.modal-header > button {
        margin: 0;
    }
`;
