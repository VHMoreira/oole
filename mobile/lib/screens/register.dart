import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:mobile/modals/NewUsuario.dart';
import 'package:http/http.dart' as http;
import 'package:mobile/utils/urls.dart';

class Register extends StatefulWidget {
  final _posicoes = ['Centroavante','Atacante','Ponta Direita','Ponta Esquerda',
                    'Meia-Atacantes','Meia Direita','Meia Esquerda', 'Meia Central', 'Volante', 
                    'Lateral Direito','Lateral Esquerdo','Zagueiro Direito','Zagueiro Esquerdo','Zagueiro Central',
                    'Goleiro'];
  final _sexos = ['Masculino', 'Feminino'];
  final _tipos = [
    'Jogador',
    'Olheiro',
  ];

  @override
  _RegisterState createState() => _RegisterState();
}

class _RegisterState extends State<Register> {

  var _sexo = 'Selecione o sexo*';
  var _posicao = 'Selecione a posição*';
  var _tipo = [0,'Selecione o tipo*'];

  final NewUsuario usuario = NewUsuario();

  Future<http.Response> cadastrarJogador(NewUsuario jogador) async {
    final response = await http.post(
      URLS.BASE_JOGADOR,
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: jsonEncode(<String, String>{
      	"login":jogador.login,
      	"senha":jogador.senha,
      	"nome":jogador.nome,
      	"dataNascimento":jogador.dataNascimento,
      	"cpf":jogador.cpf,
      	"sexo":jogador.sexo,
      	"posicao":jogador.posicao,
      	"problemaSaude":jogador.problemaSaude,
      	"cep":jogador.cep,
      	"nacionalidade":jogador.nacionalidade,
      	"endereco":jogador.endereco,
      	"bairro":jogador.bairro,
      	"cidade":jogador.cidade,
      	"estado":jogador.estado,
      	"email":jogador.email,
      	"telefone":jogador.telefone,
        'urlFotoPerfil': jogador.urlFotoPerfil,
      }),
    );

    if (response.statusCode == 200) {
      print("Cadastro concluido com sucesso");
      Navigator.pop(context);
    } else {
      print(response.body);
      print(jogador.sexo);
    }
  }

  Future<http.Response> cadastrarOlheiro(NewUsuario olheiro) async {
    final response = await http.post(
      URLS.BASE_OLHEIRO,
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body:jsonEncode(<String, String>{
        'nome': olheiro.nome,
        'dataNascimento': olheiro.dataNascimento,
        'urlFotoPerfil': olheiro.urlFotoPerfil,
        'cpf': olheiro.cpf,
        'sexo': "Masculino",
        'login': olheiro.login,
        'email': olheiro.email,
        'telefone': olheiro.telefone,
        'nacionalidade': olheiro.nacionalidade,
        'cep': olheiro.cep,
        'bairro': olheiro.bairro,
        'cidade': olheiro.cidade,
        'estado': olheiro.estado,
        'endereco': olheiro.endereco,
        'senha': olheiro.senha,
      })
    );

    if (response.statusCode == 200) {
      print("Cadastro concluido com sucesso");
      Navigator.pop(context);
    } else {
      print(response.body);
    }
  }


  _posicaoJogador(){
    if (_tipo[0]==1){
      return Container (
        width: (MediaQuery.of(context).size.width/100) * 85,
        height: (MediaQuery.of(context).size.height/100) * 10,
        decoration: BoxDecoration(
          borderRadius: BorderRadius.all(Radius.circular(10)),
          color: Colors.green[400],
        ),
        alignment: Alignment.center,
        padding: EdgeInsets.all(10),
        margin: EdgeInsets.only(bottom: (MediaQuery.of(context).size.height/100) * 2),
        child: DropdownButton(

          items: widget._posicoes.map((String posicao) => DropdownMenuItem(value: posicao,child: Text(posicao))).toList(),
          onChanged: (String posicao) {
            setState(() {
              _posicao = posicao;
              usuario.posicao = posicao;
            });
          },
          hint: Text(
            _posicao,
            style: TextStyle(
              color: Colors.white,
              fontSize: 20
            ),
          ),
        )
      );
    }

    return Container();
  }


  _saudeJogador(){
    if (_tipo[0]==1){
      return Container (
        width: (MediaQuery.of(context).size.width/100) * 85,
        height: (MediaQuery.of(context).size.height/100) * 10,
        decoration: BoxDecoration(
          borderRadius: BorderRadius.all(Radius.circular(10)),
          color: Colors.green[400],
        ),
        alignment: Alignment.center,
        padding: EdgeInsets.all(10),
        margin: EdgeInsets.only(bottom: (MediaQuery.of(context).size.height/100) * 2),
        child: TextFormField(
          onChanged: (String value) {
            setState(() {
              usuario.problemaSaude = value;
            });
          },
          maxLines: 2,
          style: TextStyle(
            color: Colors.white,
            fontSize: 15,
          ),
          decoration: const InputDecoration(
            contentPadding: EdgeInsets.all(10),
            hintText: "Você tem algum problema de saúde?\n"
                     +"Se sim, Qual?",
            hintStyle: TextStyle(color: Colors.white),
            border: InputBorder.none,
          ),
        ),
      );
    }

    return Container();
  } 

  

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color(0xFF008140),
      body: SingleChildScrollView(
        child: Container(
          alignment: Alignment.center,
          width: MediaQuery.of(context).size.width,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            children: <Widget>[


              Container(
                width: MediaQuery.of(context).size.width/3,
                height: MediaQuery.of(context).size.height/4,
                child: Image.asset(
                  "images/oole-logo.png",
                  fit: BoxFit.fitWidth,
                ),
              ),


              Container (
                width: (MediaQuery.of(context).size.width/100) * 85,
                height: (MediaQuery.of(context).size.height/100) * 10,
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.all(Radius.circular(10)),
                  color: Colors.green[400],
                ),
                alignment: Alignment.center,
                padding: EdgeInsets.all(10),
                margin: EdgeInsets.only(bottom: (MediaQuery.of(context).size.height/100) * 2),
                child: TextFormField(
                  onChanged: (String value) {
                    setState(() {
                      usuario.login = value;
                    });
                  },
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 20,
                  ),
                  decoration: const InputDecoration(
                    icon: Icon(Icons.person),
                    contentPadding: EdgeInsets.all(10),
                    hintText: "Login*",
                    hintStyle: TextStyle(color: Colors.white),
                    border: InputBorder.none,
                  ),
                ),
              ),


              Container (
                width: (MediaQuery.of(context).size.width/100) * 85,
                height: (MediaQuery.of(context).size.height/100) * 10,
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.all(Radius.circular(10)),
                  color: Colors.green[400],
                ),
                alignment: Alignment.center,
                padding: EdgeInsets.all(10),
                margin: EdgeInsets.only(bottom: (MediaQuery.of(context).size.height/100) * 2),
                child: TextFormField(
                  keyboardType: TextInputType.visiblePassword,
                  
                  onChanged: (String value) {
                    setState(() {
                      usuario.senha = value;
                    });
                  },
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 20,
                  ),
                  decoration: const InputDecoration(
                    icon: Icon(Icons.lock),
                    contentPadding: EdgeInsets.all(10),
                    hintText: "Senha*",
                    hintStyle: TextStyle(color: Colors.white),
                    border: InputBorder.none,
                  ),
                ),
              ),


              Container (
                width: (MediaQuery.of(context).size.width/100) * 85,
                height: (MediaQuery.of(context).size.height/100) * 10,
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.all(Radius.circular(10)),
                  color: Colors.green[400],
                ),
                alignment: Alignment.center,
                padding: EdgeInsets.all(10),
                margin: EdgeInsets.only(bottom: (MediaQuery.of(context).size.height/100) * 2),
                child: TextFormField(
                  onChanged: (String value) {
                    setState(() {
                      usuario.nome = value;
                    });
                  },
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 20,
                  ),
                  decoration: const InputDecoration(
                    contentPadding: EdgeInsets.all(10),
                    hintText: "Nome Completo*",
                    hintStyle: TextStyle(color: Colors.white),
                    border: InputBorder.none,
                  ),
                ),
              ),


              Container (
                width: (MediaQuery.of(context).size.width/100) * 85,
                height: (MediaQuery.of(context).size.height/100) * 10,
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.all(Radius.circular(10)),
                  color: Colors.green[400],
                ),
                alignment: Alignment.center,
                padding: EdgeInsets.all(10),
                margin: EdgeInsets.only(bottom: (MediaQuery.of(context).size.height/100) * 2),
                child: TextFormField(
                  // keyboardType: TextInputType.numberWithOptions(),
                  inputFormatters: <TextInputFormatter> [
                    LengthLimitingTextInputFormatter(10),
                    BlacklistingTextInputFormatter.singleLineFormatter
                  ],
                  onChanged: (String value) {
                    setState(() {
                      usuario.dataNascimento = value;
                    });
                  },
                  //^([0-2][0-9]|(3)[0-1])(\/)(((0)[0-9])|((1)[0-2]))(\/)\d{4}$,
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 20,
                  ),
                  decoration: const InputDecoration(
                    contentPadding: EdgeInsets.all(10),
                    hintText: "Data de Nascimento*",
                    hintStyle: TextStyle(color: Colors.white),
                    border: InputBorder.none,
                  ),
                ),
              ),


              Container (
                width: (MediaQuery.of(context).size.width/100) * 85,
                height: (MediaQuery.of(context).size.height/100) * 10,
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.all(Radius.circular(10)),
                  color: Colors.green[400],
                ),
                alignment: Alignment.center,
                padding: EdgeInsets.all(10),
                margin: EdgeInsets.only(bottom: (MediaQuery.of(context).size.height/100) * 2),
                child: TextFormField(
                  keyboardType: TextInputType.number,
                  inputFormatters: <TextInputFormatter> [
                    LengthLimitingTextInputFormatter(11),
                    BlacklistingTextInputFormatter.singleLineFormatter
                  ],
                  onChanged: (String value) {
                    setState(() {
                      usuario.cpf = value;
                    });
                  },
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 20,
                  ),
                  decoration: const InputDecoration(
                    contentPadding: EdgeInsets.all(10),
                    hintText: "CPF*",
                    hintStyle: TextStyle(color: Colors.white),
                    border: InputBorder.none,
                  ),
                ),
              ),


              Container (
                width: (MediaQuery.of(context).size.width/100) * 85,
                height: (MediaQuery.of(context).size.height/100) * 10,
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.all(Radius.circular(10)),
                  color: Colors.green[400],
                ),
                alignment: Alignment.center,
                padding: EdgeInsets.all(10),
                margin: EdgeInsets.only(bottom: (MediaQuery.of(context).size.height/100) * 2),
                child: DropdownButton(
                  
                  items: widget._sexos.map((String sexo) => DropdownMenuItem(value: sexo,child: Text(sexo))).toList(),
                  onChanged: (String sexo) {
                    setState(() {
                      _sexo = sexo;
                      usuario.sexo = sexo;
                    });
                    print(_sexo);
                  },
                  hint: Text(
                    _sexo,
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 20
                    ),
                  ),
                )
              ),

              Container (
                width: (MediaQuery.of(context).size.width/100) * 85,
                height: (MediaQuery.of(context).size.height/100) * 10,
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.all(Radius.circular(10)),
                  color: Colors.green[400],
                ),
                alignment: Alignment.center,
                padding: EdgeInsets.all(10),
                margin: EdgeInsets.only(bottom: (MediaQuery.of(context).size.height/100) * 2),
                child: DropdownButton(
                  
                  items: widget._tipos.map((String tipo) => DropdownMenuItem(value: tipo,child: Text(tipo))).toList(),
                  onChanged: (String tipo) {
                    setState(() {
                      if(tipo=='Jogador'){
                        _tipo = [1,tipo];
                      }else if(tipo=='Olheiro'){
                        _tipo = [2,tipo];
                      }
                      usuario.tipo = _tipo[0];
                    });
                  },
                  hint: Text(
                    _tipo[1],
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 20
                    ),
                  ),
                )
              ),


              _posicaoJogador(),


              _saudeJogador(),


              Container (
                width: (MediaQuery.of(context).size.width/100) * 85,
                height: (MediaQuery.of(context).size.height/100) * 10,
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.all(Radius.circular(10)),
                  color: Colors.green[400],
                ),
                alignment: Alignment.center,
                padding: EdgeInsets.all(10),
                margin: EdgeInsets.only(bottom: (MediaQuery.of(context).size.height/100) * 2),
                child: TextFormField(
                  onChanged: (String value) {
                    setState(() {
                      usuario.nacionalidade = value;
                    });
                  },
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 20,
                  ),
                  decoration: const InputDecoration(
                    contentPadding: EdgeInsets.all(10),
                    hintText: "Nacionalidade*",
                    hintStyle: TextStyle(color: Colors.white),
                    border: InputBorder.none,
                  ),
                ),
              ),


              Container (
                width: (MediaQuery.of(context).size.width/100) * 85,
                height: (MediaQuery.of(context).size.height/100) * 10,
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.all(Radius.circular(10)),
                  color: Colors.green[400],
                ),
                alignment: Alignment.center,
                padding: EdgeInsets.all(10),
                margin: EdgeInsets.only(bottom: (MediaQuery.of(context).size.height/100) * 2),
                child: TextFormField(
                  keyboardType: TextInputType.number,
                  inputFormatters: <TextInputFormatter> [
                    LengthLimitingTextInputFormatter(8),
                    BlacklistingTextInputFormatter.singleLineFormatter
                  ],
                  onChanged: (String value) {
                    setState(() {
                      usuario.cep = value;
                    });
                  },
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 20,
                  ),
                  decoration: const InputDecoration(
                    contentPadding: EdgeInsets.all(10),
                    hintText: "CEP*",
                    hintStyle: TextStyle(color: Colors.white),
                    border: InputBorder.none,
                  ),
                ),
              ),


              Container (
                width: (MediaQuery.of(context).size.width/100) * 85,
                height: (MediaQuery.of(context).size.height/100) * 10,
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.all(Radius.circular(10)),
                  color: Colors.green[400],
                ),
                alignment: Alignment.center,
                padding: EdgeInsets.all(10),
                margin: EdgeInsets.only(bottom: (MediaQuery.of(context).size.height/100) * 2),
                child: TextFormField(
                  onChanged: (String value) {
                    setState(() {
                      usuario.endereco = value;
                    });
                  },
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 20,
                  ),
                  decoration: const InputDecoration(
                    contentPadding: EdgeInsets.all(10),
                    hintText: "Endereço*",
                    hintStyle: TextStyle(color: Colors.white),
                    border: InputBorder.none,
                  ),
                ),
              ),


              Container (
                width: (MediaQuery.of(context).size.width/100) * 85,
                height: (MediaQuery.of(context).size.height/100) * 10,
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.all(Radius.circular(10)),
                  color: Colors.green[400],
                ),
                alignment: Alignment.center,
                padding: EdgeInsets.all(10),
                margin: EdgeInsets.only(bottom: (MediaQuery.of(context).size.height/100) * 2),
                child: TextFormField(
                  onChanged: (String value) {
                    setState(() {
                      usuario.bairro = value;
                    });
                  },
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 20,
                  ),
                  decoration: const InputDecoration(
                    contentPadding: EdgeInsets.all(10),
                    hintText: "Bairro*",
                    hintStyle: TextStyle(color: Colors.white),
                    border: InputBorder.none,
                  ),
                ),
              ),


              Container (
                width: (MediaQuery.of(context).size.width/100) * 85,
                height: (MediaQuery.of(context).size.height/100) * 10,
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.all(Radius.circular(10)),
                  color: Colors.green[400],
                ),
                alignment: Alignment.center,
                padding: EdgeInsets.all(10),
                margin: EdgeInsets.only(bottom: (MediaQuery.of(context).size.height/100) * 2),
                child: TextFormField(
                  onChanged: (String value) {
                    setState(() {
                      usuario.cidade = value;
                    });
                  },
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 20,
                  ),
                  decoration: const InputDecoration(
                    contentPadding: EdgeInsets.all(10),
                    hintText: "Cidade*",
                    hintStyle: TextStyle(color: Colors.white),
                    border: InputBorder.none,
                  ),
                ),
              ),



              Container (
                width: (MediaQuery.of(context).size.width/100) * 85,
                height: (MediaQuery.of(context).size.height/100) * 10,
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.all(Radius.circular(10)),
                  color: Colors.green[400],
                ),
                alignment: Alignment.center,
                padding: EdgeInsets.all(10),
                margin: EdgeInsets.only(bottom: (MediaQuery.of(context).size.height/100) * 2),
                child: TextFormField(
                  onChanged: (String value) {
                    setState(() {
                      usuario.estado = value;
                    });
                  },
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 20,
                  ),
                  decoration: const InputDecoration(
                    contentPadding: EdgeInsets.all(10),
                    hintText: "Estado*",
                    hintStyle: TextStyle(color: Colors.white),
                    border: InputBorder.none,
                  ),
                ),
              ),


              Container (
                width: (MediaQuery.of(context).size.width/100) * 85,
                height: (MediaQuery.of(context).size.height/100) * 10,
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.all(Radius.circular(10)),
                  color: Colors.green[400],
                ),
                alignment: Alignment.center,
                padding: EdgeInsets.all(10),
                margin: EdgeInsets.only(bottom: (MediaQuery.of(context).size.height/100) * 2),
                child: TextFormField(
                  onChanged: (String value) {
                    setState(() {
                      usuario.email = value;
                    });
                  },
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 20,
                  ),
                  decoration: const InputDecoration(
                    contentPadding: EdgeInsets.all(10),
                    hintText: "Email*",
                    hintStyle: TextStyle(color: Colors.white),
                    border: InputBorder.none,
                  ),
                ),
              ),


              Container (
                width: (MediaQuery.of(context).size.width/100) * 85,
                height: (MediaQuery.of(context).size.height/100) * 10,
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.all(Radius.circular(10)),
                  color: Colors.green[400],
                ),
                alignment: Alignment.center,
                padding: EdgeInsets.all(10),
                margin: EdgeInsets.only(bottom: (MediaQuery.of(context).size.height/100) * 2),
                child: TextFormField(
                  onChanged: (String value) {
                    setState(() {
                      usuario.telefone = value;
                    });
                  },
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 20,
                  ),
                  decoration: const InputDecoration(
                    contentPadding: EdgeInsets.all(10),
                    hintText: "Telefone*",
                    hintStyle: TextStyle(color: Colors.white),
                    border: InputBorder.none,
                  ),
                ),
              ),


              Container(
                width: (MediaQuery.of(context).size.width/100) * 70,
                height: (MediaQuery.of(context).size.height/100) * 8,
                margin: EdgeInsets.only(bottom: (MediaQuery.of(context).size.height/100) * 7, top: (MediaQuery.of(context).size.height/100) * 2),
                child: RaisedButton (
                  child: Text('Finalizar', style: TextStyle(
                    fontSize: 20.0,
                    color: Color(0xFF01E271)
                    ),
                  ),
                  onPressed: () {
                    if(usuario.tipo == 1){
                      cadastrarJogador(usuario);
                    }else{
                      cadastrarOlheiro(usuario);
                    }
                  },
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}