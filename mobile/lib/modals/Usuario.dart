class Usuario {
  int id;
	
  String nome;
	String dataNascimento;
	String urlFotoPerfil;
	String cpf;
	
  String sexo;
	String posicao;
	String problemaSaude;
	
  String tipoPerfil;
  String login;
	String email;
	String telefone;
	
  String nacionalidade;
	String cep;
	String bairro;
	String cidade;
	String estado;
	String endereco;

  List seguindo;
  List seguidores;
  List observadores;
  List videos;

  Usuario({this.id, this.nome, this.dataNascimento, 
           this.urlFotoPerfil, this.cpf, this.sexo, 
           this.posicao, this.problemaSaude, this.login, 
           this.email, this.telefone, this.nacionalidade, 
           this.cep, this.bairro, this.cidade, 
           this.estado, this.endereco,this.seguindo,
           this.seguidores, this.observadores, this.videos,
           this.tipoPerfil});

  factory Usuario.fromJsonToBuscar(Map<String, dynamic> json){
    return Usuario(
      id: json['id'],
      nome: json['nome'],
      urlFotoPerfil: json['urlFotoPerfil'],
      login: json['login'],
    );
  }

  factory Usuario.fromJsonToPerfil(Map<String, dynamic> json){
    return Usuario(
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
      endereco: json['endereco'],
      seguindo: json['seguindo'],
      seguidores: json['seguidores'],
      observadores: json['observadores'],
      videos: json['videos'],
      tipoPerfil: json['perfil']
    );
  }

}