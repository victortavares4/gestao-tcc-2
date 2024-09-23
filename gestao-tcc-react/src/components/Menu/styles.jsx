import styled from 'styled-components';

export const Container = styled.div`
    width: 231px;
    height: 100vh;
    position: fixed;
    z-index: 99;
    top: 0;
    left: 0;
    box-shadow: 3px 3px 10px rgba(0, 0, 0, 0.1);
    transition: all 0.4s;
    background-color: #234285;
    color: #FFFFFF;
    
    &.show, &.hide{
        transition: margin-left .2s ease-in;
        -webkit-transition: margin-left .2s ease-in;
    }

    &.hide{
        margin-left: -231px;
    }

    &.show{
        margin-left: 0;
    }
`;

export const SidebarHeader = styled.div`
    border-bottom: 1px solid rgba(255, 255, 255, 0.5);
    height: 70px;
    display: flex;

    div:first-child{
        padding: 24px 32px 24px 30px;
        width: 81px;
        border-right: 1px solid rgba(255, 255, 255, 0.5);
        text-align: center;
        height: 70px;

        svg{
            opacity: 0.5;
            cursor: pointer;

            &:hover{
                opacity: 1;
            }
        }
    }

    div:last-child{
        padding: 14px 27px 14px 36px;
        width: 150px;
        height: 70px;
    }
`

export const SidebarBody = styled.div`
    padding-left: 0;
    padding-top: 5px;
    overflow-y: auto;
    overflow-x: hidden;
    height: 86%;

    ul{
        list-style-type: none;
        padding: 0;

        li{
            width: 231px;
            height: 45px;
            cursor: pointer;
            padding: 9px 0 9px 0;
            display: flex;
            flex-direction: row;
            align-items: center;
            
            label{
                cursor: pointer;
                display: flex;
                margin: 0 0 0 30px;
                text-decoration: none;
                text-align: left;
                font-size: 14px/20px;
                letter-spacing: 0px;
                color: #BDC7DA;
                opacity: 1;
                width: 100%;
            }

            &:hover{
                background-color: #00B1EB;
    
                label{
                    color: #FFFFFF!important;
                    font-weight: bold!important;
                }
            }
        }
    }

    &::-webkit-scrollbar {
        width: 5px;
    }

    &::-webkit-scrollbar-track {
        border-radius: 10px;
        box-shadow: inset 0 0 6px rgba(255,255,255,0.3);
    }

    &::-webkit-scrollbar-thumb {
        border-radius: 10px;
        background-color: #ececf3;
        box-shadow: inset 0 0 6px rgba(255,255,255,0.5);
    }
`

export const SidebarFooter = styled.div`
    padding-left: 30px;
    float: left;
`