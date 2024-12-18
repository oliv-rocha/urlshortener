<h1 align="center">Projeto URL Shortener</h1>

Este projeto consiste em um encurtador de URL desenvolvido durante a **Imersão Java com AWS** da <a href="https://www.rocketseat.com.br/">Rocketseat</a>. Utilizamos as ferramentas da **AWS Lambda**, **S3** e **API Gateway** para construir uma aplicação serverless que permite encurtar URLs e redirecionar usuários para os links encurtados, podendo configurar um tempo para expiração do link.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada para desenvolver as funções Lambda.
- **AWS Lambda**: Para criação das funções serverless que processam o encurtamento e redirecionamento de URLs.
- **Amazon S3**: Para armazenar as URLs encurtadas e outros dados necessários.
- **API Gateway**: Para gerenciar as requisições HTTP e fazer o redirecionamento para as URLs encurtadas.

## Estrutura do Projeto

O projeto foi dividido em 3 aulas principais:

#### Aula 1: Criando Funções Serverless e Configurando URL Encurtada
- Criamos as funções Lambda para gerar URLs encurtadas.
- Configuramos a lógica inicial para encurtar e armazenar as URLs.

#### Aula 2: Integração com S3
- Integramos o S3 para armazenar as URLs encurtadas.
- Configuramos permissões e gerenciamento de dados no S3.

#### Aula 3: Redirecionamento de URLs e Configuração do API Gateway
- Configuramos o API Gateway para receber as requisições HTTP.
- Implementamos o redirecionamento para as URLs encurtadas.

## Como Rodar o Projeto

#### Pré-requisitos

- Conta na AWS com permissões para utilizar o Lambda, S3 e API Gateway.
- JDK 17.
- Maven (para gerenciar dependências e construir o projeto).

#### Passos para Execução

1. Clone o repositório:

```bash
   git clone https://github.com/oliv-rocha/url-shortener
   cd url-shortener

```
2. Compile o projeto:

```bash
   mvn clean install
```
3 Implemente as funções Lambda na AWS.

4 Configure o S3 para armazenar as URLs encurtadas.

5 Configure o API Gateway para lidar com as requisições HTTP e o redirecionamento.

6 Teste a funcionalidade de encurtamento de URLs através da API Gateway.

### Como Usar

1 Envie uma requisição HTTP POST para a URL do API Gateway com a URL original que você deseja encurtar.

2 A resposta será a URL encurtada, que pode ser acessada diretamente ou compartilhada.


### Contribuindo
Sinta-se à vontade para contribuir com o projeto, enviando issues ou pull requests.

### Licença
Este projeto está licenciado sob a <a href="#memo-licença">MIT License</a>.
