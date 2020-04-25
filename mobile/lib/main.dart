import 'package:flutter/material.dart';
import 'package:mobile/intro.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp (
      title: 'Oolé app',
      theme: ThemeData(
        primaryColor: Color(0xFF008140),
      ),
      home: IntroWidget(),
    );
  } 
}
