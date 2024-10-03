# Gestao TCC

## Configuração do Banco de Dados
1. Baixe o MySQL e o [MySQL Workbench](https://dev.mysql.com/downloads/workbench/) Caso preferir pode baixar o [XAMP](https://www.apachefriends.org/pt_br/index.html) para subir o MySQL
2. Crie um banco de dados MySQL:
    ```sql
    CREATE DATABASE tcc;
3. Utilize o script `docs/dump.sql` para criar as tabelas necessárias:

## Instalação Apache Tomcat

### Passos para Instalação no Windows

#### Baixar e Extrair o Tomcat:

1. Baixe o arquivo ZIP do Tomcat em [Apache Tomcat Downloads](https://tomcat.apache.org/download-90.cgi).
2. Extraia o arquivo ZIP no local de sua preferencia.

### Passos para Instalação no Linux

#### Baixar e Extrair o Tomcat:

1. Baixe o arquivo TAR.GZ do Tomcat em [Apache Tomcat Downloads](https://tomcat.apache.org/download-90.cgi).
2. Extraia o arquivo TAR.GZ no local de sua preferencia.

## Como Executar o Back-End
1. Clone o repositório:
   ```bash
   git clone https://github.com/nicolaslopess/AstroMonitor.git](https://github.com/victortavares4/gestao-tcc-2.git
2. Baixe o [JDK](https://www.oracle.com/br/java/technologies/downloads/#java17).
2. Importe o projeto para a sua IDE Java de preferência (NetBeans, IntelliJ, etc.) nesse projeto foi utilizado [NetBeans](https://netbeans.apache.org/front/main/index.html).
3. Configure a conexão com o banco de dados MySQL no arquivo `ConnectionDB.java`.
4. Compile o projeto com as dependencias (assim o NetBeans vai baixar todas as dependencias do projeto).
- Faça os passos a seguir de configuração do Tomcat no NetBeans e execute o projeto.
- Vai abrir uma paginal Web `http://localhost:8080/` com a escrita `API java Iniciada`.

### Deploy de Aplicações no Tomcat com NetBeans

#### Adicionar o Tomcat ao NetBeans:

- Vá para `Services` > `Servers` > `Add Server`.
- Selecione `Apache Tomcat or TomEE` e configure o caminho do Tomcat e as credenciais de administrador.

#### Executar Projeto no NetBeans:

- Clique com o botão direito no projeto e selecione `Properties`.
- Configure o servidor Tomcat na aba `Run`.
- Selecione o Tomcat e clique em `ok`.

## Como executar Front-End

1. Baixe e instale o [Node.js](https://nodejs.org/en/) `v16.4.0`.
- Caso já tenha o Node.js instalado deve mudar a versão para `v16.4.0` pode ser usado o [nvm](https://github.com/coreybutler/nvm-windows/releases) para mudar a versão.
- Para mudar a versão utilize esse comando:
   ```bash
   nvm install 16.4.0
   nvm use 16.20.0
3. Baixe [npm](https://www.npmjs.com/) ou [Yarn](https://yarnpkg.com/).

### Adicionando dependencias do Node.js

1. Execute o comando abaixo no diretorio do `gestao-tcc-react/` para baixar as dependencias:
   ```bash
   npm install --force
2. Para iniciar o projeto:
   ```bash
   npm start
- Vai abrir uma paginal Web `http://localhost:3000/login`.

## Bibliotecas usadas no Front-end

- **@material-ui/core**: Usado para componentes UI como `Box`, `Button`, `Typography`, `Table`, e mais. Este pacote fornece os componentes React baseados no design do Material Design.
- **@material-ui/icons**: Fornece ícones do Material Design que são usados em vários lugares do UI, como botões e menus.
- **axios**: Utilizado para fazer requisições HTTP para comunicar-se com APIs externas, como a API NASA no projeto.
- **@react-three/fiber**: Uma biblioteca React renderer para três.js que permite a construção de cenas 3D de maneira declarativa.
- **@react-three/drei**: Uma coleção de abstrações reutilizáveis e prontas para uso que complementam @react-three/fiber, como `OrbitControls`, `Stars`, e `useTexture`.
- **lodash**: Uma biblioteca JavaScript moderna que fornece utilitários modulares para melhorar a eficiência do código, como a função `random` para gerar números aleatórios.

## Dependências adicionais

- **react-router-dom**: (Se você estiver usando roteamento) Utilizado para gerenciar as rotas na aplicação React.
- **react-redux** e **redux**: (Se você estiver usando gerenciamento de estado global) Usados para gerenciar o estado em toda a aplicação de forma mais eficiente.

## Como instalar as dependências

Para instalar todas as dependências listadas, você pode executar o seguinte comando no terminal na pasta raiz do seu projeto:

    npm install @material-ui/core @material-ui/icons axios @react-three/fiber @react-three/drei lodash

