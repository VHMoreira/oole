import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:mobile/modals/Usuario.dart';
import 'package:mobile/utils/urls.dart';

class Perfil extends StatefulWidget {
  final int _id;
  final bool tabOuPush;

  Perfil(this._id, this.tabOuPush);

  @override
  _PerfilState createState() => _PerfilState();
}

class _PerfilState extends State<Perfil> {
  Usuario _usuario = Usuario();

  get perfilJogador async {
    final response = await http.get(URLS.BASE_JOGADOR + "${widget._id}");

    if (response.statusCode == 200) {
      Map<String, dynamic> reqBody = jsonDecode(response.body);
      setState(() {
        _usuario = Usuario.fromJsonToPerfil(reqBody);
      });
    } else {
      print('Failed to load Jogador');
    }
  }


  get perfilOlheiro async {
    final response = await http.get(URLS.BASE_OLHEIRO + "${widget._id}");

    if (response.statusCode == 200) {
      Map<String, dynamic> reqBody = jsonDecode(response.body);
      setState(() {
        _usuario = Usuario.fromJsonToPerfil(reqBody);
      });
    } else {
      print('Failed to load Jogador');
    }
  }

  @override
  void initState() {
    super.initState();
    perfilJogador;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: widget.tabOuPush ? null : 
      AppBar(
        title: Text("Perfil"),
        backgroundColor: Color(0xFF008140),
        elevation: 1.0,
      ), 
      body:_usuario.login != null? 
      SingleChildScrollView(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          children: <Widget>[
            Container(
              margin: EdgeInsets.all(10),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceAround,
                children: <Widget>[
                  Container(
                    child: Icon(Icons.account_circle, size: 80,)
                  ), 
                  Container(
                    child: Column(
                      children: <Widget>[
                        Text( _usuario.observadores.length.toString()),
                        Text( 
                          "Observadores",
                          overflow: TextOverflow.ellipsis,
                        ),
                      ],
                    )
                  ),
                  Container(
                    child: Column(
                      children: <Widget>[
                        Text( _usuario.seguidores.length.toString()),
                        Text( 
                          "Seguidores",
                          overflow: TextOverflow.ellipsis,
                        ),
                      ],
                    )
                  ),
                  Container(
                    child: Column(
                      children: <Widget>[
                        Text( _usuario.seguindo.length.toString()),
                        Text( 
                          "Seguindo",
                          overflow: TextOverflow.ellipsis,
                        ),
                      ],
                    )
                  ),
                ],
              ),
            ),
            Container(
              padding: EdgeInsets.all(10),
              decoration: BoxDecoration(
                border: Border(bottom: BorderSide(width: 1, color: Colors.grey[400]))
              ),
              alignment: Alignment.centerLeft,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Text(
                    _usuario.login != null ? _usuario.nome : "",
                    style: TextStyle(
                      color: Colors.green[300],
                      fontSize: 20,
                      fontWeight: FontWeight.w700,
                    ),
                  ),
                  Text(
                    _usuario.login != null ? _usuario.posicao : "",
                    style: TextStyle(
                      color: Colors.yellow[600],
                      fontSize: 15,
                      fontWeight: FontWeight.w700,
                    ),
                  ),
                  Text(
                    "Nascido em: " + (_usuario.login != null ? _usuario.dataNascimento : ""),
                    style: TextStyle(
                      color: Colors.grey[500],
                      fontSize: 12,
                      fontWeight: FontWeight.w700,
                    ),
                  ),
                  Text(
                    "Cidede/Estado: " + (_usuario.login != null ? (_usuario.cidade+'/'+_usuario.estado) : ""),
                    style: TextStyle(
                      color: Colors.grey[500],
                      fontSize: 12,
                      fontWeight: FontWeight.w700,
                    ),
                  ),
                  Text(
                    "Estado de saúde: " + (_usuario.login != null ? _usuario.problemaSaude : ""),
                    style: TextStyle(
                      color: Colors.grey[500],
                      fontSize: 12,
                      fontWeight: FontWeight.w700,
                    ),
                  ),
                  Text(
                    "E-mail: " + (_usuario.login != null ? _usuario.email : ""),
                    style: TextStyle(
                      color: Colors.grey[500],
                      fontSize: 12,
                      fontWeight: FontWeight.w700,
                    ),
                  ),
                  Text(
                    "Telefone: " + (_usuario.login != null ? _usuario.telefone : ""),
                    style: TextStyle(
                      color: Colors.grey[500],
                      fontSize: 12,
                      fontWeight: FontWeight.w700,
                    ),
                  ),
                ],
              ),
            ),
            // Container(
            //   color: Colors.grey,
            //   height: double.infinity,
            //   child: videos.length > 0 ?
            
            //   //SE SIM
            //   GridView.builder(
            //     gridDelegate: null, 
            //     itemBuilder: null
            //   )
            //   ://SENÃO
            //   Center(
            //     child: Text("Nenhum video ainda"),
            //   )
            // )   
          ],
        ),
      )
      :
      Center(
        child: CircularProgressIndicator()
      ),
    );
  }
}