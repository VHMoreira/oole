import 'dart:async';
import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:mobile/modals/Usuario.dart';
import 'package:mobile/screens/home.dart';
import 'package:mobile/screens/perfil.dart';
import 'package:mobile/screens/search_jogador.dart';
import 'package:mobile/utils/urls.dart';
import 'package:http/http.dart' as http;

class Tabs extends StatefulWidget {
  @override
  _TabsState createState() => _TabsState();
}

class _TabsState extends State<Tabs> {
  int _selectedScreenIndex = 0;
  bool _procurando;
  String _login;

  List<Map<String, Object>> _screens;

  @override
  void initState() {
    super.initState();
    _screens = [
      {
        'title': 'Home',
        'screen': Home(),
      },
      {
        'title': 'Buscar',
        'screen': SearchJogador([]),
      },
      {
        'title': 'Adicionar Videos',
        'screen': ()=>{},//AdicionarVideo(),
      },
      {
        'title': 'Perfil',
        'screen': Perfil(1,true),
      },
      {
        'title': 'Menu',
        'screen': ()=>{},
      },
    ];
    _login = '';
    _procurando = false;
    searchJogador;
  }

  _selecionarScreen(int index){
    setState(() {
      _procurando = index != 1 ? false:true;
      _selectedScreenIndex = index;
    });
  }

  get searchJogador async {
    final response = await http.get(URLS.SEARCH_JOGADOR_BY_LOGIN +_login);


    if (response.statusCode == 200) {
      Map<String, dynamic> reqBody = jsonDecode(response.body);
      setState(() {
        _screens[1]['screen'] = SearchJogador(reqBody['content']);
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
              border: InputBorder.none,
            ),
            onChanged: (String value) {
              setState(() {
                _login = value;
              });
              Timer(Duration(seconds: 1), () => searchJogador);
            },          
          ) 
          : 
          Text(_screens[_selectedScreenIndex]['title'],style: TextStyle(fontSize: 18),),
        
        actions: <Widget>[
          IconButton(
            icon: Icon(Icons.search), 
            onPressed: _selectedScreenIndex == 1? 
            () {
              setState(() {
                _procurando = !_procurando;
              });
            }
            :
            () {
              _selecionarScreen(1);
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
      body: _screens[_selectedScreenIndex]['screen'],
      bottomNavigationBar: BottomNavigationBar(
        onTap: _selecionarScreen,
        backgroundColor: Colors.white,
        unselectedItemColor: Colors.grey[400],
        selectedItemColor: Colors.green[400],
        currentIndex: _selectedScreenIndex,
        items: [
          BottomNavigationBarItem(
            icon: Icon(Icons.home), title: Text('Home')
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.search), title: Text('Buscar')
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.add_to_queue), title: Text('Adicionar Video')
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.person), title: Text('Perfil')
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.menu), title: Text('Menu')
          )
        ],
      ),
    );
  }
}