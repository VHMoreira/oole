class Jogador {
  final int id;
	final String nome;
	final String dataNascimento;
	
	final String urlFotoPerfil;
	
	final String cpf;
	final String sexo;
	final String posicao;
	final String problemaSaude;
	
	final String login;
	
	final String email;
	
	final String telefone;
	
	final String nacionalidade;
	
	final String cep;
	
	final String bairro;
	
	final String cidade;
	
	final String estado;
	
	final String endereco;

  Jogador({this.id, this.nome, this.dataNascimento, 
           this.urlFotoPerfil, this.cpf, this.sexo, 
           this.posicao, this.problemaSaude, this.login, 
           this.email, this.telefone, this.nacionalidade, 
           this.cep, this.bairro, this.cidade, 
           this.estado, this.endereco});

  factory Jogador.fromJson(Map<String, dynamic> json){
    return Jogador(
      id: json['id'],
      nome: json['nome'],
      dataNascimento: json['dataNascimento'],
      urlFotoPerfil: json['urlFotoPerfil'],
      cpf: json['cpf'],
      sexo: json['sexo'],
      posicao: json['posicao'],
      problemaSaude: json['problemaSaude'],
      login: json['login'],
      email: json['email'],
      telefone: json['telefone'],
      nacionalidade: json['nacionalidade'],
      cep: json['cep'],
      bairro: json['bairro'],
      cidade: json['cidade'],
      estado: json['estado'],
      endereco: json['endereco']
    );
  }

  factory Jogador.toJson(Jogador jogador){
    return {
      'id': jogador.id,
      'nome': jogador.nome,
      'dataNascimento': jogador.dataNascimento,
      'urlFotoPerfil': jogador.urlFotoPerfil,
      'cpf': jogador.cpf,
      'sexo': jogador.sexo,
      'posicao': jogador.posicao,
      'problemaSaude': jogador.problemaSaude,
      'login': jogador.login,
      'email': jogador.email,
      'telefone': jogador.telefone,
      'nacionalidade': jogador.nacionalidade,
      'cep': jogador.cep,
      'bairro': jogador.bairro,
      'cidade': jogador.cidade,
      'estado': jogador.estado,
      'endereco': jogador.endereco
    };
  }


}