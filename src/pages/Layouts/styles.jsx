import styled from 'styled-components';

export const Container = styled.div`
  header.main-header{
    ul{
      list-style-type: none;
      padding: 0;
      margin: 0;
      height: 70px;
      display: flex;

      li{
        padding: 0;
        height: 70px;
      }

      .li-menu{
        padding: 24px 32px 24px 30px;
        border-right: 1px solid rgba(255, 255, 255, 0.5);
        width: 81px;

        
        svg{
          cursor: pointer;
          color: #FFFFFF;
          opacity: 0.5;
          text-align: center;

          &:hover{
            opacity: 1;
          }
        }
      }

      .li-logo{
        padding: 14px 27px 14px 36px;
        width: 150px;
      }

      .logo-bat{
     
      }

      .li-crop-year{
        align-items: center;
        display: flex;
        color: #FFFFFF;
        border-right: 1px solid rgba(255, 255, 255, 0.5);
        padding-right: 15px;
        text-align: right;

        p{
          margin: 0;
        }
      }

      .li-crop-year-customer{
        align-items: center;
        display: flex;
        color: #FFFFFF;
        border-right: 1px solid rgba(255, 255, 255, 0.5);
        padding-right: 15px;
        text-align: right;

        p{
          margin: 0;
        }
      }

      .li-notification{
        color: #FFFFFF;
        text-align: center;
        padding: 24px 30px 24px 30px;
        width: 80px;

        svg{
          cursor: pointer;
          color: #FFFFFF;
          opacity: 1;
          text-align: center;

          &:hover{
            opacity: 0.5;
          }
        }
      }

      .li-profile{
        font-size: 14px;
        right: 0;
        /* padding: 24px 50px 24px 0; */
        color: #FFFFFF;
        display: flex;
        flex-direction: row;
        align-items: center;
        margin-right: 58px;

        .user-name{
          width: 100%;

          &.has-company{
            padding-top: 12px;
          }

          button{
            background-color: transparent;
            border: transparent;
            padding: 0;

            span{
              padding-right: 10px;
            }

            &:after{
              color: transparent;
            }
            
            &:hover{
              opacity: 0.5;
            }

            &:focus{
              box-shadow: 0 0 0 0 transparent;
            }

            &:active{
              box-shadow: 0 0 0 0 transparent;
            }
          }
          
          .dropdown-menu{
            box-shadow: 0px 3px 20px #00000026;
            border: 1px solid #ECECF3;
            border-radius: 4px;
            font-size: 13px;
  
            .dropdown-item{              
              color: #00B1EB;
              margin: 0.5rem 0;
              padding: 0.2rem 0;
  
              &:active{
                  background-color: #102A63;
              }

              &:hover{
                background-color: transparent;
                text-decoration: underline;
                text-decoration-color: #00B1EB;
              }
            }
          }
        }

        

        .user-infos{
          font-size: 11px;
          font-weight: bold;
          text-align: left;
        }
      }
    }
  }

  .main-header .user-name.show.dropdown > div {
    width: 300px;
    position: absolute;
    right: -50px !important;
    top: 10px !important;
    padding: 1rem 2rem;
  }

  .main-header .user-name.show.dropdown > div > .label-line {
    margin: 0 0.5rem;
  }

  .main-header .user-name.show.dropdown > div > .label-line span {
    color: rgba(0,0,0,.85);
    font-weight: 600;
    font-size: 15px;
    left: 1rem;
  }  

  .main-header .user-name.show.dropdown > div > .label-name {
    margin: 1rem 0;
    font-size: 13px;
    line-height: 1.5715;
  }

  .hrdivider {
    position: relative;
    margin: 2rem 0 1.5rem;
    width: 100%;
    text-align: center;
    background-color: #DDDDDD;
  }
  
  .hrdivider.options {
    margin: 2.5rem 0 1.5rem;
  }

  .hrdivider span {
    position: absolute;
    top: -11px;
    background: #fff;
    padding: 0 20px;
    font-weight: bold;
    font-size: 16px;    
  }

  .dropdown-crop button{
    background-color: transparent;
    border-color: transparent;
    text-align: right;
  }
  
  .dropdown-crop .btn-check:active+.btn-primary, .btn-check:checked+.btn-primary, .btn-primary.active, .btn-primary:active, .show>.btn-primary.dropdown-toggle{
    background-color: transparent;
    border-color: transparent;
    text-align: right;
    box-shadow: none;
  }

  .dropdown-crop button{
    background-color: transparent;
    border-color: transparent;
    text-align: right;
  }

  .profile-info p {
    color: #CCCCCC;
    margin-right: 0.5rem;
    margin-bottom: 0.5rem;
    line-height: 30px;
  }

  .profile-info span {
    color: #000;
    margin-right: 0.5rem;    
  }

  .main-header hr {
    background-color: #FFFFFF;
  }

  .main-body{
    margin-bottom: 90px;
  }

  footer{
    position: absolute;
    bottom: 0;
    width: 100%;
    white-space: nowrap;
    text-align: center;
    color: #7F7F8A;
    font-size: 13px;

    div{
      height: 15px;
    }

    p{
      margin: 0;
    }

    img{
      padding: 0;
      width: 100%;
    }
  }
`;
