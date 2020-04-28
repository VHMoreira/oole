import 'package:flutter/material.dart';


class Login extends StatefulWidget {
  @override
  _LoginState createState() => _LoginState();
}

class _LoginState extends State<Login> {
  @override
  Widget build(BuildContext context) {
    return Scaffold (
      backgroundColor: Color(0xFF008140),
      body: SingleChildScrollView(
        child: Center (
          child: Column(
            children: <Widget>[
              Image.asset(
                "images/oole-logo.png",
                fit: BoxFit.fitWidth,
                width: 200,
                height: 200,
              ),
            ],
          ),
        ),
      ),
    );
  }
}