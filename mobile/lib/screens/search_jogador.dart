import 'package:flutter/material.dart';
import 'package:mobile/components/bottom_bar.dart';
import 'package:mobile/components/item_jogador_search.dart';

class SearchJogador extends StatefulWidget {
  @override
  _SearchJogadorState createState() => _SearchJogadorState();
}

class _SearchJogadorState extends State<SearchJogador> {
  bool procurando = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Color(0xFF008140),
        elevation: 1.0,
        title: 
          procurando? 
          TextFormField(
            autofocus: true,
            style: TextStyle(
              color: Colors.white,
              fontSize: 19.0
            ),
            decoration: const InputDecoration(
        
            ),
          ) 
          : 
          Text('Buscar Jogador'),
        actions: <Widget>[
          IconButton(
            icon: Icon(Icons.search), 
            onPressed: () {
              setState(() {
                procurando = !procurando;
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
      body: ListView(
          padding: EdgeInsets.all(10),
          children: <Widget>[
            ItemJogadorSearch(),
            ItemJogadorSearch(),
            ItemJogadorSearch(),
            ItemJogadorSearch(),
            ItemJogadorSearch(),
            ItemJogadorSearch(),
            ItemJogadorSearch(),
            ItemJogadorSearch(),
            ItemJogadorSearch(),
            ItemJogadorSearch(),
            ItemJogadorSearch(),
            ItemJogadorSearch(),
            ItemJogadorSearch(),
            ItemJogadorSearch(),
            ItemJogadorSearch(),
            ItemJogadorSearch(),
          ],
        ),
      bottomNavigationBar: BottomBar()
    );
  }
}