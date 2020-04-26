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
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Image.asset(
              "images/oole-logo.png",
              fit: BoxFit.fitWidth,
              width: 150.0,
              height: 200.0,
            ),
            Image.asset(
              "images/inicio-app.png",
              fit: BoxFit.fitWidth,
              width: 250.0,
              height: 200.0,
            ),
            Text(
              "Publique vídeos de suas melhores\n" +
                  "jogadas na melhor pataforma para\n" +
                  "jogadores de futebol.",
              style: TextStyle(color: Colors.white, fontSize: 16.0),
            ),
            Padding(
              padding: EdgeInsets.only(
                  left: 20.0, top: 80.0, bottom: 30.0, right: 20.0),
              child: Container(
                height: 50.0,
                width: 600.0,
                child: RaisedButton(
                  child: Text("Começar a usar!",
                      style: TextStyle(
                        color: Color(0xFF01E271),
                        fontSize: 16.0,
                      )),
                  onPressed: () {},
                ),
              ),
            ),
            Padding(
              padding: EdgeInsets.only(left: 20.0, right: 20.0),
              child: Container(
                height: 50.0,
                width: 600.0,
                child: RaisedButton(
                  child: Text(
                    "O que é?",
                    style: TextStyle(color: Color(0xFF01E271), fontSize: 16.0),
                  ),
                  onPressed: () {},
                ),
              ),
            )
          ],
        ),
      ),
    );
  }
}
