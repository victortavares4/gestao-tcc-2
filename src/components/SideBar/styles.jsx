import styled from 'styled-components';

export const Container = styled.div`
    width: 231px;
    height: 100vh;
    position: relative;
    z-index: 99;
    top: 0;
    left: 0;
    box-shadow: 3px 3px 10px rgba(0, 0, 0, 0.1);
    background-color: #0076D7;
    color: #FFFFFF;
    transition: margin-left 0.4s ease-in-out, background-color 0.3s ease-in-out;
`;

export const SidebarHeader = styled.div`
    border-bottom: 1px solid rgba(255, 255, 255, 0.5);
    height: 70px;
    display: flex;
    align-items: center;

    div:first-child {
        padding: 24px 32px 24px 30px;
        width: 81px;
        text-align: center;
        height: 70px;

        svg {
            opacity: 0.5;
            cursor: pointer;
            transition: opacity 0.3s ease;

            &:hover {
                opacity: 1;
            }
        }
    }

    div:last-child {
        padding: 14px 27px 14px 36px;
        width: 100%;
        height: 70px;
    }
`;

export const SidebarBody = styled.div`
    padding-left: 0;
    padding-top: 5px;
    overflow-y: auto;
    overflow-x: hidden;
    height: calc(100vh - 140px); 

    ul {
        list-style-type: none;
        padding: 0;
        margin: 0;

        li {
            width: 231px;
            height: 45px;
            cursor: pointer;
            padding: 9px 0;
            display: flex;
            align-items: center;
            transition: background-color 0.3s ease;

            label {
                cursor: pointer;
                display: flex;
                margin-left: 30px;
                text-decoration: none;
                text-align: left;
                font-size: 14px;
                width: 100%;
                transition: color 0.3s ease;
            }

            &:hover {
                background-color: #0c5f7a;

                label {
                    color: #5aa3bb;
                    font-weight: bold;
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
`;

export const SidebarFooter = styled.div`
    padding-left: 30px;
    height: 70px;
    display: flex;
    align-items: center;

    img {
        width: 86px;
        height: 36px;
    }
`;
