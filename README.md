# Oolé
O Oolé, é um aplicativo criado para ajudar no processo de descobrimento de talentos no futebol. Com ele é possível para jogadores e jogadoras compartilharem seus vídeos de lances e conquistas, seu histórico como jogador e suas informações para que olheiros de todos os lugares possam observa-los. 

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
# Arquitetura
![Alt](img\diagrams\arch_oole.png)
Os clientes, ao fazerem uma requisição interagirão, primeiramente, com a camada Rest que a partir de um objeto Model, encapsulará os dados e os enviará para as camadas Service. Na camada Service os models sofrerão alterações, validações e conversões, de acordo com a regra de negócios da aplicação para depois passar os dados para a Camada de DAO, que fará a interação com o Banco de Dados. 

- **Cliente**: É o aplicativo mobile, que fará as requisições à API.
- **Camada REST**: Ficará responsável por gerênciar as rotas e as requisições da aplicação.
- **Camada Service**: Ficará responsável pelas regras de negócio da aplicação.
- **Camada DAO(Data Access Object)**: Ficará responsável pela interação com o Banco de Dados.
- **Models**: São os modelos de dados que serão usados no Banco de Dados.

## Endpoints da Camada Rest

Metodo |Endpoint | Descrição | Parâmetros
-------|---------|-----------|-----------
GET|/jogadores| Fará uma busca por<br>todos os jogadores| None
GET|/jogadores/page| Fará uma busca por<br>todos os jogadores<br> de forma paginada| None
GET|/jogadores/{id}| Fará uma busca por<br>um jogador usando <br> a Id dele| Integer id
POST|/jogadores| Fará uma inserção de<br>um novo jogador<br> usando a Id dele| None
PUT|/jogadores/{id}| Fará uma atualização de<br>um jogador<br> usando a Id dele| Integer id
    
# Autores
- Alvaro Somensi Magnenti
- Felipe Rafael dos Santos Barbosa
- Victor Cassio Viana da Luz
- Vitor Henrique Moreira de Souza
