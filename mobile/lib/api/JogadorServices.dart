// import 'dart:convert';
// import 'package:http/http.dart' as http;
// import 'package:mobile/modals/Jogador.dart';

// Object searchJogador(String login, List lista, bool procurando) async {
//   final response = await http.get('https://oole.herokuapp.com/olheiros/search?login=$login');
//   if (response.statusCode == 200) {
//       Map<String, dynamic> reqBody = jsonDecode(response.body);
//       return Jogador.fromJson(reqBody)
//   }else {
//     print('Failed to load Jogador');
//   }
// }