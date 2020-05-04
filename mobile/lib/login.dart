import 'package:flutter/material.dart';
import 'package:mobile/home.dart';
import 'package:mobile/register.dart';


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
              Padding(
                padding: EdgeInsets.only(top: 60),
                child: Image.asset(
                  "images/oole-logo.png",
                  fit: BoxFit.fitWidth,
                  width: 180,
                  height: 180,
                ),
              ),
              
              Padding(
                padding: EdgeInsets.only(left: 30.0, right: 30.0,  bottom: 20.0),
                child: Container (
                  child: TextFormField(
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 24.0
                    ),
                    decoration: const InputDecoration(
                      labelText: 'Login: ',
                      labelStyle: TextStyle(
                        color: Colors.white,
                      ),
                    ),
                  ),
                ), 
              ),
              Padding(
                padding: EdgeInsets.only(left: 30.0, right: 30.0, bottom: 40.0),
                child: Container(
                  child: TextFormField(
                    autofocus: true,
                    obscureText: true,
                    keyboardType: TextInputType.text,
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 24.0
                    ),
                    decoration: InputDecoration(
                      labelText: 'Senha:',
                      labelStyle: TextStyle(
                        color: Colors.white,
                      ),
                    ),
                  ),
                ),
              ),

              Padding (padding: EdgeInsets.only(bottom: 20),
                child: Container(
                  height: 50.0,
                  width: 300.0,
                  child: RaisedButton (
                    child: Text('Entrar', style: TextStyle(
                      fontSize: 24.0,
                      color: Color(0xFF01E271)
                      ),
                    ),
                    onPressed: () {
                      Navigator.push(context,
                        MaterialPageRoute(builder: (context) => 
                        Home()),
                      );
                    },
                  ),
                ),
              ),
            Text('Ainda não tem um Oolé?\n'
            'Inscreva-se, é de graça.', style: TextStyle(color: Colors.white, fontSize: 16.0),),
              Padding(
                padding: EdgeInsets.only(top: 20.0),
                child: Container(
                  height: 50.0,
                  width: 300.0,
                  child: RaisedButton (
                    child: Text('Cadastrar', style: TextStyle(
                      fontSize: 24.0,
                      color: Color(0xFF01E271)
                      ),
                    ),
                    onPressed: () {
                      Navigator.push(context,
                      MaterialPageRoute(builder: (context) => Register()
                      )); 
                    },
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}