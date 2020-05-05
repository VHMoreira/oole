import 'package:flutter/material.dart';
import 'package:mobile/oole_body.dart';

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
      appBar: topBar,
      body: OoleBody(),
      bottomNavigationBar: Container(
        color: Colors.white,
        height: 50.0,
        child: BottomAppBar(
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            children: <Widget>[
              IconButton(icon: Icon(Icons.home), onPressed: null, iconSize: 30.0),
              IconButton(icon: Icon(Icons.add_a_photo), onPressed: null, iconSize: 30.0),
              IconButton(icon: Icon(Icons.accessibility), onPressed: null, iconSize: 30.0),
              IconButton(icon: Icon(Icons.adjust), onPressed: null, iconSize: 30.0)
            ],
          ),
        ),
      ),
    );
  }
}