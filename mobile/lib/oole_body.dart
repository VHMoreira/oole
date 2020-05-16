import 'package:flutter/material.dart';


class OoleBody extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.start,
      children: <Widget>[
        Flexible(child: Center(child: Text("HOME"))),
      ],
    );
  }
}