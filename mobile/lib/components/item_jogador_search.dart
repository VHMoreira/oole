import 'package:flutter/material.dart';

class ItemJogadorSearch extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      padding: EdgeInsets.only(top: 10, bottom: 10),
      decoration: BoxDecoration(
        border: Border(bottom: BorderSide(width: 2, color: Colors.grey[400]))
      ),
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.center,
        mainAxisAlignment: MainAxisAlignment.start,
        children: <Widget>[
          Icon(Icons.accessibility, size: 45), 
          Column(
            mainAxisAlignment: MainAxisAlignment.start,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: <Widget>[
              Text(
                '\\visouza', 
                style: TextStyle(
                  color: Colors.green[400]
                ),
              ),
              Text(
                'Vitor Henrique Moreira de Souza', 
                style: TextStyle(
                  color: Colors.grey[400]
                ),
              )
            ],
          )
        ],
      ),
    );
  }
}