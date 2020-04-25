import 'package:flutter/material.dart';

class Intro extends StatefulWidget {
  @override
  _IntroState createState() => _IntroState();
}

class _IntroState extends State<Intro> {
  @override
  Widget build(BuildContext context) {
    return Scaffold (
      appBar: AppBar(
        title: Text("Oolé app"),
      ),

      backgroundColor: Colors.green,

      body: Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        //mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          Container (
            child: Image.asset(
              "images/inicio-app.png",
              alignment: Alignment.center,
              fit: BoxFit.fill,
              height: 150.0,
            ), 
          ),

          Text("Ainda não possui uma conta cadastre-se é de graça!")

        ],
      ),
    );
  }
}