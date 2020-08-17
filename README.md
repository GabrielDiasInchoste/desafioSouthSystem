# desafioSouthSystem
Projeto criado usando Java JDK 8 e SpringBoot, através do link https://start.spring.io/.
Documentação da api feita com Swagger .
Swagger - Link Local: http://localhost:3000/swagger-ui.html.

--- Inciar projeto ---

Necessario executar o Docker-Compose para baixar a imagem do Banco Oracle.

-- docker-compose up -d.


Apos baixar a imagem é necessario criar o Usuario Desafio para a aplicaçao utilizar.

-- alter session set "_ORACLE_SCRIPT"=true;

-- create user desafio identified by desafio;

-- GRANT ALL PRIVILEGES TO desafio;

Apos importar o projeto na IDE e subir a aplicaçao.

