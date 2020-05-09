import 'dart:async';
import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:mobile/components/bottom_bar.dart';
import 'package:mobile/components/item_jogador_search.dart';
import 'package:http/http.dart' as http;


class SearchJogador extends StatefulWidget {

  @override
  _SearchJogadorState createState() => _SearchJogadorState();
}

class _SearchJogadorState extends State<SearchJogador> {
  bool _procurando;
  String _login;
  List _lista;

  @override
  void initState(){
    super.initState();
    _lista = [];
    _login = '';
    _procurando = false;
    searchJogador;
  }

  Future<http.Response> get searchJogador async {
    final response = await http.get('https://oole.herokuapp.com/olheiros/search?login=$_login');

    if (response.statusCode == 200) {
      setState(() {
        Map<String, dynamic> reqBody = jsonDecode(response.body);
        setState(() {
          _lista = reqBody['content'];
          _procurando = true;
        });
      });
    } else {
      print('Failed to load Jogador');
    }
  }
  

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Color(0xFF008140),
        elevation: 1.0,
        title: 
          _procurando? 
          TextFormField(
            autofocus: true,
            style: TextStyle(
              color: Colors.white,
              fontSize: 19.0
            ),
            decoration: const InputDecoration(
        
            ),
            onChanged: (String value) {
              setState(() {
                _login = value;
              });
              Timer(Duration(seconds: 1), () => searchJogador);
            },          
          ) 
          : 
          Text('Buscar Jogador',style: TextStyle(fontSize: 18),),
        actions: <Widget>[
          IconButton(
            icon: Icon(Icons.search), 
            onPressed: () {
              setState(() {
                _procurando = !_procurando;
              });
            }
          ),
          IconButton(
            icon: Icon(Icons.notifications), 
            onPressed: () {},
          ),
          IconButton(
            icon: Icon(Icons.more_vert), 
            onPressed: () {},
          ),
        ],
      ),
      body: ListView.builder(
          padding: EdgeInsets.all(10),
          itemCount: _lista.length,
          itemBuilder: (context,index) {
            return ItemJogadorSearch(_lista[index]['login'], _lista[index]['urlFotoPerfil'], _lista[index]['nome']);
          },
        ),
      bottomNavigationBar: BottomBar()
    );
  }
}