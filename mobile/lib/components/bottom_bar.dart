import 'package:flutter/material.dart';

class BottomBar extends StatefulWidget {
  @override
  _BottomBarState createState() => _BottomBarState();
}

class _BottomBarState extends State<BottomBar> {
  @override
  Widget build(BuildContext context) {
    return Container(
        color: Colors.white,
        height: 50.0,
        child: BottomAppBar(
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            children: <Widget>[
              IconButton(icon: Icon(Icons.home), onPressed: null, iconSize: 30.0),
              IconButton(icon: Icon(Icons.search), onPressed: null, iconSize: 30.0),
              IconButton(icon: Icon(Icons.add_to_queue), onPressed: null, iconSize: 30.0),
              IconButton(icon: Icon(Icons.person), onPressed: null, iconSize: 30.0),
              IconButton(icon: Icon(Icons.menu), onPressed: null, iconSize: 30.0)
            ],
          ),
        ),
      );
  }
}