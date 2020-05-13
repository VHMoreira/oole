import 'package:flutter/material.dart';
import 'package:mobile/components/item_jogador_search.dart';


class SearchJogador extends StatelessWidget {
  final List _lista;

  SearchJogador(this._lista);

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
        padding: EdgeInsets.all(10),
        itemCount: _lista.length,
        itemBuilder: (context,index) {
          return ItemJogadorSearch(_lista[index]['id'], _lista[index]['login'], _lista[index]['urlFotoPerfil'], _lista[index]['nome']);
        },
      );
  }
}