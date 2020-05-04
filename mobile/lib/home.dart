import 'package:flutter/material.dart';

class Home extends StatefulWidget {
  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Color(0xFF008140),
        title: Text('Feed de Jogadores'),
      ),
      body: Column(
        children: <Widget>[

        ],
      ),
    );
  }
}