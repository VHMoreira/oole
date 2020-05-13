import 'package:flutter/material.dart';
import 'package:mobile/screens/login.dart';

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
        child: Container(
          alignment: Alignment.center,
          width: MediaQuery.of(context).size.width,
          height: MediaQuery.of(context).size.height,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            children: <Widget>[
              Container(
                width: MediaQuery.of(context).size.width/3,
                height: MediaQuery.of(context).size.height/4,
                child: Image.asset(
                  "images/oole-logo.png",
                  fit: BoxFit.fitWidth,
                ),
              ),
              Container(
                width: MediaQuery.of(context).size.width/2,
                height: MediaQuery.of(context).size.height/4,
                child: Image.asset(
                  "images/inicio-app.png",
                  fit: BoxFit.fitWidth,
                ),
              ),
              Container(
                child: Text(
                  "Publique vídeos de suas melhores\n" +
                      "jogadas na melhor pataforma para\n" +
                      "jogadores de futebol.",
                  textAlign: TextAlign.center,
                  style: TextStyle(
                    color: Colors.white, 
                    fontSize: 16.0 
                  ),
                ),
              ),
              Container(
                height: (MediaQuery.of(context).size.height/100) * 8,
                width: (MediaQuery.of(context).size.width/100) * 85,
                child: RaisedButton(
                  child: Text("Começar a usar!",
                      style: TextStyle(
                        color: Color(0xFF01E271),
                        fontSize: 20.0,
                      )),
                  onPressed: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(builder: (context) => Login())
                    );
                  },
                ),
              ),
              Container(
                height: (MediaQuery.of(context).size.height/100) * 8,
                width: (MediaQuery.of(context).size.width/100) * 85,
                margin: EdgeInsets.only(bottom: (MediaQuery.of(context).size.width/100) * 5),
                child: RaisedButton(
                  child: Text(
                    "O que é?",
                    style: TextStyle(
                      color: Color(0xFF01E271), 
                      fontSize: 20.0
                    ),
                  ),
                  onPressed: () {},
                ),
              )
            ],
          ),
        ),
      ),
    );
  }
}
