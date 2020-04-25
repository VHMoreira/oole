import 'package:flutter/material.dart';

class IntroWidget extends StatefulWidget {
  @override
  _IntroWidgetState createState() => _IntroWidgetState();
}

class _IntroWidgetState extends State<IntroWidget> {
  @override
  Widget build(BuildContext context) {
    return Column (
      children: <Widget>[
        Expanded (
          child: FittedBox (
            fit: BoxFit.contain,
            child: const Image(
              image: AssetImage('/images/inicio-app.png'),
              )
          ),  
        ),
      ]
    );
  }
}