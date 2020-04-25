import 'package:flutter/material.dart';

class Intro extends StatefulWidget {
  @override
  _IntroState createState() => _IntroState();
}

class _IntroState extends State<Intro> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color(0xFF008140),

      body: SingleChildScrollView(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          //mainAxisAlignment: MainAxisAlignment.center,
          
          children: <Widget>[
            Container(
              child: Image.asset(
                "images/inicio-app.png",
                alignment: Alignment.center,
                fit: BoxFit.fill,
                height: 150.0,
              ),
            ),

            Text(
              "Publique vídeos de suas melhores\n" +
                  "jogadas na melhor pataforma para\n" +
                  "jogadores de futebol.",
              style: TextStyle(color: Colors.white, fontSize: 16.0),
            ),

            RaisedButton(
              child: Text("Começar a usar!", style: TextStyle(color: Color(0xFF01E271), fontSize: 16.0),),
              onPressed: () {},
            ),

            RaisedButton(
              child: Text("O que é?", style: TextStyle(color: Color(0xFF01E271), fontSize: 16.0),),
              onPressed: () {},
            ),

          ],
        ),
      ),
    );
  }
}
