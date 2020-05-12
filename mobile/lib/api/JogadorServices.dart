import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:mobile/utils/urls.dart';

class JogadorServices {

  static Future<List<dynamic>> searchJogador(String login) async {
    final response = await http.get(URLS.SEARCH_JOGADOR_BY_LOGIN +login);


    if (response.statusCode == 200) {
      return jsonDecode(response.body)['content'];  
    } else {
      print('Failed to load Jogador');
      return null;
    }
  }

}