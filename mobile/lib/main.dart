import 'package:flutter/material.dart';

void main() {
  runApp(new Login());
}


class Login extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        Image.asset("images/oole.jpg"
          fit: BoxFit.cover,
          height: 1000.0,
        ),
      ),
    );
  }

}
