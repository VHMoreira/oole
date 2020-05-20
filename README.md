<h1 align="center">
<br>
  <img src="https://user-images.githubusercontent.com/32422863/79405121-f102af00-7f69-11ea-8d34-8bab4eaed2b4.png" alt="Oolé app" width="120">
<br>
<br>
Oolé app
</h1>

<p align="center">O Oolé, é um aplicativo criado para ajudar no processo de decobertas de talentos no futebol. Com ele é possível jogadores compartilharem seus vídeos de lances e conquistas, seu histórico como jogador e suas informações para que olheiros de todos os lugares possam observa-los. </p>

<p align="center">
  <a href="https://opensource.org/licenses/MIT">
    <img src="https://img.shields.io/badge/License-MIT-blue.svg" alt="License MIT">
  </a>
</p>

<hr />

# Funcionalidades
As funcionalidades que cada perfil do sistema deve ter.
## Olheiros
- Realizar cadastro
- Feed com diversos jogadores
- Seguir jogadores que chamaram atenção
- Feed com com atividades recentes dos jogadores e olheiros que segue 
- Criar conexões com outros olheiros
- Visualizar perfil de jogadores
- Visualizar informações para contato de jogadores
- Visualizar vídeos de jogadores
- Realizar atualizações cadastrais
- Realizar pagamento de mensalidade via cartão de crédito
## Jogadores
- Realizar cadastro
- Seguir outros jogadores
- Curtir vídeos de outros jogadores
- Compartilhar vídeos dos seus lances
- Realizar atualizações cadastrais
- Feed com com atividades recentes dos jogadores que segue
# Arquitetura da API
![Diagrama da Arquitetura da Aplicação](https://github.com/VHMoreira/oole/blob/master/img/diagrams/arch_oole.png)
Os clientes, ao fazerem uma requisição interagirão, primeiramente, com a camada Rest que a partir de um objeto Model, encapsulará os dados e os enviará para as camadas Service. Na camada Service os models sofrerão alterações, validações e conversões, de acordo com a regra de negócios da aplicação para depois passar os dados para a Camada de DAO, que fará a interação com o Banco de Dados. 

- **Cliente**: É o aplicativo mobile, que fará as requisições à API.
- **Camada REST**: Ficará responsável por gerênciar as rotas e as requisições da aplicação.
- **Camada Service**: Ficará responsável pelas regras de negócio da aplicação.
- **Camada DAO (Data Access Object)**: Ficará responsável pela interação com o Banco de Dados.
- **Models**: São os modelos de dados que serão usados no Banco de Dados.

## Endpoints da Camada Rest

> URL da API: https://oole.herokuapp.com/

### Jogador

Metodo |Endpoint | Descrição | Parâmetros
-------|---------|-----------|-----------
GET|/jogadores| Listar todos os jogadores| None | 
GET|/jogadores/page| Paginação da lista de jogadores| None
GET|/jogadores/search?login={login}| Busca por login| String login
GET|/jogadores/{id}| Busca por id| Integer id
PUT|/jogadores/{id}| Atualizar jogador| Integer id
PUT|/jogadores/{id}/fotoperfil| Atualizar foto de perfil do jogador| Integer id
PUT|/jogadores/{id}/videos| Adicionar video| Integer id
PUT|/jogadores/follow?userid={userid}&seguidoid={seguidoid}| Seguir jogador| Integer userid <br/> Integer seguidoid 
PUT|/jogadores/unfollow?userid={userid}&seguidoid={seguidoid}| Desseguir jogador| Integer userid <br/> Integer seguidoid 
POST|/jogadores| Cadastrar novo jogador| None

### Olheiro

Metodo |Endpoint | Descrição | Parâmetros
-------|---------|-----------|-----------
GET|/olheiros| Listar todos os olheiros| None | 
GET|/olheiros/page| Paginação da lista de olheiros| None
GET|/olheiros/search?login={login}| Busca por login| String login
GET|/olheiros/{id}| Busca por id| Integer id
PUT|/olheiros/{id}| Atualizar olheiro| Integer id
PUT|/olheiros/{id}/fotoperfil| Atualizar foto de perfil do olheiro| Integer id
PUT|/olheiros/follow?userid={userid}&seguidoid={seguidoid}| Seguir olheiro| Integer userid <br/> Integer seguidoid 
PUT|/olheiros/unfollow?userid={userid}&seguidoid={seguidoid}| Desseguir olheiro| Integer userid <br/> Integer seguidoid 
PUT|/olheiros/observar?userid={userid}&seguidoid={seguidoid}| Observar jogador| Integer userid <br/> Integer seguidoid 
PUT|/olheiros/desobservar?userid={userid}&seguidoid={seguidoid}| Desobservar jogador| Integer userid <br/> Integer seguidoid 
POST|/olheiros| Cadastrar novo olheiro| None

## Modelagem do Banco de Dados
![Diagrama de Entidade e Relacionamento do Banco de Dados](https://github.com/VHMoreira/oole/blob/master/img/diagrams/oole-er.png)

  Para o sistema de gerenciamento de banco de dados, a escolha foi o **MySQL**, devido o fato de ser open source e também devido a familiaridade da equipe com ele.

- **Jogador**: É a tabela responsável por guardar os dados dos usuários que tem o perfil JOGADOR.
- **Olheiro**: É a tabela responsável por guardar os dados dos usuários que tem o perfil OLHEIRO. 
- **Video**: É a tabela responsável por guardar os dados dos videos inseridos pelo usuário JOGADOR, o relacionamento dela com a tabela jogador vai ser de **muitos para um**.
- **Jogador_Seguidor**: É a tabela responsável por guardar os dados relativos aos seguidores de cada jogador. Tendo em vista que um jogador só pode seguir outros jogadores, ela é gerada devido uma espécie de autoreferência de **muitos para muitos** da tabela Jogador com ela mesma.
- **Olheiro_Seguidor**: É a tabela responsável por guardar os dados relativos aos seguidores de cada olheiro. Tendo em vista que um jogador só pode seguir outros olheiro, ela é gerada devido uma espécie de autoreferência de **muitos para muitos** da tabela Olheiro com ela mesma.
- **Observacos**: É a tabela responsável por guardar os dados relativos à aos jogadores que cada olheiro está observando. Ela é gerada devido ao relacionamento de **muitos para muitos** entre as tabelas Jogador e Olheiro.
    
# Autores
Participantes | E-mail
--------------|-------
Alvaro Somensi Magnenti | alvarosomensi@gmail.com
Felipe Rafael dos Santos Barbosa | rafaelt.ibarbosa@gmail.com
Victor Cassio Viana da Luz | victorcassiov@gmail.com
Vitor Henrique Moreira de Souza | vhsouzaeng@gmail.com
