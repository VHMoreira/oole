import 'package:flutter/material.dart';
import 'package:mobile/components/bottom_bar.dart';
import 'package:mobile/oole_body.dart';
import 'package:mobile/screens/search_jogador.dart';

class Home extends StatelessWidget {
  final topBar = new AppBar(
    backgroundColor: Color(0xFF008140),
    elevation: 1.0,
    titleSpacing: -35.0,
    leading: new Icon(null),
    title: SizedBox(
      height: 35.0, 
      child: Text('Feed de Jogadores'),
    ),
    actions: <Widget>[
      Padding(
        padding: const EdgeInsets.only(right: 12.0),
        child: Icon(Icons.access_alarm),
      ),
    ],
  );
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Color(0xFF008140),
        elevation: 1.0,
        title: Text('Home'),
        actions: <Widget>[
          IconButton(
            icon: Icon(Icons.search), 
            onPressed: () {
              Navigator.push(context,
                MaterialPageRoute(builder: (context) => SearchJogador()
              )); 
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
      body: OoleBody(),
      bottomNavigationBar: BottomBar()
    );
  }
}