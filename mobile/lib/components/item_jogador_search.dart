import 'package:flutter/material.dart';
import 'package:mobile/screens/perfil.dart';

class ItemJogadorSearch extends StatelessWidget {
  final String _login;
  final String _urlFotoPerfil;
  final String _nome;
  final int id;

  ItemJogadorSearch(this.id, this._login, this._urlFotoPerfil, this._nome);

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: (){
        Navigator.push(context,
          MaterialPageRoute(builder: (context) => Perfil(id,false))
        ); 
      },
      child: Container(
        padding: EdgeInsets.only(top: 10, bottom: 10),
        decoration: BoxDecoration(
          border: Border(bottom: BorderSide(width: 1, color: Colors.grey[400]))
        ),
        child: Row(
          crossAxisAlignment: CrossAxisAlignment.center,
          mainAxisAlignment: MainAxisAlignment.start,
          children: <Widget>[
            Container(
              child: Icon(Icons.accessibility, size: 45,)
            ), 
            Column(
              mainAxisAlignment: MainAxisAlignment.start,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: <Widget>[
                Text(
                  _login, 
                  style: TextStyle(
                    color: Colors.green[400]
                  ),
                ),
                Text(
                  _nome, 
                  style: TextStyle(
                    color: Colors.grey[400]
                  ),
                )
              ],
            )
          ],
        ),
      ),
    );
  }
}