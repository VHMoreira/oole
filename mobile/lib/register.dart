import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class Register extends StatefulWidget {
  @override
  _RegisterState createState() => _RegisterState();
}

class _RegisterState extends State<Register> {
  final _posicoes = ['Centroavante','Atacante','Ponta Direita','Ponta Esquerda',
                    'Meia-Atacantes','Meia Direita','Meia Esquerda', 'Meia Central', 'Volante', 
                    'Lateral Direito','Lateral Esquerdo','Zagueiro Direito','Zagueiro Esquerdo','Zagueiro Central',
                    'Goleiro'];

  final _sexos = ['Masculino', 'Feminino'];

  final List _tipos = [
    {'id':1,'desc':'Jogador'},
    {'id':2,'desc':'Olheiro'},
  ];

  var _sexo = 'Selecione o sexo';
  var _posicao = 'Selecione a posição';
  var _tipo = {'id':0,'desc':'Selecione o tipo'};

  Widget _form(String tipo) {
    if (tipo=='1'){
      return Column(children: <Widget>[
        Padding(
              padding: EdgeInsets.only(left: 30.0, right: 30.0,  bottom: 20.0),
              child: Row(
                children: <Widget>[
                  DropdownButton(
                      items: _posicoes.map((String pos) => DropdownMenuItem(value: pos,child: Text(pos))).toList(),
                      onChanged: (String pos){
                        setState(() {
                          _posicao = pos;
                        });
                        print(_posicao);
                      },
                      
                      hint: Text(
                        _posicao,
                        style: TextStyle(
                          color: Colors.white,
                          fontSize: 19.0,
                        ),
                      ),
                    ),
                ],
              ),
            ), 


            Padding(
              padding: EdgeInsets.only(left: 30.0, right: 30.0,  bottom: 20.0),
              child: Container (
                child: TextFormField(
                  maxLines: 2,
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 19.0
                  ),
                  decoration: const InputDecoration(
                    labelText: 'Você tem algum problema de Saúde? Se sim, Qual? ',
                    labelStyle: TextStyle(
                      color: Colors.white,
                    ),
                  ),
                ),
              ),  
            ),
        ],
      );
    }else if(tipo=='2'){
      return null;
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color(0xFF008140),

      body: Container(
        height: double.infinity,
        width: MediaQuery.of(context).size.width,
        child: ListView(
          children: <Widget>[



            Padding(
              padding: EdgeInsets.only(top: 10),
              child: Image.asset(
                "images/oole-logo.png",
                width: 100,
                height: 100,
              ),
            ),



            Padding(
              padding: EdgeInsets.only(left: 30.0, right: 30.0,  bottom: 20.0),
              child: Container (
                child: TextFormField(
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 19.0
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
              padding: EdgeInsets.only(left: 30.0, right: 30.0,  bottom: 20.0),
              child: Container (
                child: TextFormField(
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 19.0
                  ),
                  decoration: const InputDecoration(
                    labelText: 'Senha: ',
                    labelStyle: TextStyle(
                      color: Colors.white,
                    ),
                  ),
                ),
              ), 
            ),


            Padding(
              padding: EdgeInsets.only(left: 30.0, right: 30.0,  bottom: 20.0),
              child: Container (
                child: TextFormField(
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 19.0
                  ),
                  decoration: const InputDecoration(
                    labelText: 'Nome: ',
                    labelStyle: TextStyle(
                      color: Colors.white,
                    ),
                  ),
                ),
              ), 
            ),


            Padding(
              padding: EdgeInsets.only(left: 30.0, right: 30.0,  bottom: 20.0),
              child: Row(
                children: <Widget>[
                  SizedBox(
                    width: 30,
                    child: TextFormField(
                      textAlign: TextAlign.center,
                      style: TextStyle(
                        color: Colors.white,
                        fontSize: 19.0,

                      ),
                      decoration: InputDecoration(
                        labelStyle: TextStyle(
                          color: Colors.white,
                        ),
                      ),
                      keyboardType: TextInputType.number,
                      inputFormatters: <TextInputFormatter> [
                        WhitelistingTextInputFormatter.digitsOnly,
                      ],
                    ),
                  ),
                  Text(
                    '/',
                    style: TextStyle(
                        color: Colors.white,
                        fontSize: 19.0
                    ),
                  ),
                  SizedBox(
                    width: 30,
                    child: TextFormField(
                      textAlign: TextAlign.center,
                      style: TextStyle(
                        color: Colors.white,
                        fontSize: 19.0,
                      ),
                      decoration: InputDecoration(
                        labelStyle: TextStyle(
                          color: Colors.white,
                        ),
                      ),

                      keyboardType: TextInputType.number,
                      inputFormatters: <TextInputFormatter> [
                        WhitelistingTextInputFormatter.digitsOnly,
                      ],
                    ),
                  ),
                  Text(
                    '/',
                    style: TextStyle(
                        color: Colors.white,
                        fontSize: 19.0
                    ),
                  ),
                  SizedBox(
                    width: 60,
                    child: TextFormField(
                      textAlign: TextAlign.center,
                      style: TextStyle(
                        color: Colors.white,
                        fontSize: 19.0,
                      ),
                      decoration: InputDecoration(
                        labelStyle: TextStyle(
                          color: Colors.white,
                        ),
                      ),
                      keyboardType: TextInputType.number,
                      inputFormatters: <TextInputFormatter> [
                        WhitelistingTextInputFormatter.digitsOnly,
                      ],
                    ),
                  ),
                ],
              )
            ),

            
            Padding(
              padding: EdgeInsets.only(left: 30.0, right: 30.0,  bottom: 20.0),
              child: Container (
                child: TextFormField(
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 19.0
                  ),
                  decoration: const InputDecoration(
                    labelText: 'CPF: ',
                    labelStyle: TextStyle(
                      color: Colors.white,
                    ),
                  ),
                  keyboardType: TextInputType.number,
                  inputFormatters: <TextInputFormatter> [
                    WhitelistingTextInputFormatter.digitsOnly,
                  ],
                ),
              ), 
            ),


            Padding(
              padding: EdgeInsets.only(left: 30.0, right: 30.0,  bottom: 20.0),
              child: Row(
                children: <Widget>[
                  DropdownButton(
                      items: _sexos.map((String sexo) => DropdownMenuItem(value: sexo,child: Text(sexo))).toList(),
                      onChanged: (String sexo){
                        setState(() {
                          _sexo = sexo;
                        });
                      },                      
                      hint: Text(
                        _sexo,
                        style: TextStyle(
                          color: Colors.white,
                          fontSize: 19.0,
                        ),
                      ),
                    ),
                ],
              ),
            ), 



            // Padding(
            //   padding: EdgeInsets.only(left: 30.0, right: 30.0,  bottom: 20.0),
            //   child: Row(
            //     children: <Widget>[
            //       DropdownButton(
            //           items: () {
            //             var list = [];
            //             for (var tipo in _tipos) {
            //               list.add(DropdownMenuItem(value: tipo['id'],child: Text(tipo['desc'])));
            //             }
            //             return list;
            //           },
            //           onChanged: (tipo){
            //             setState(() {
            //               _tipo = tipo;
            //             });
            //           },
                      
            //           hint: Text(
            //             _tipo[1],
            //             style: TextStyle(
            //               color: Colors.white,
            //               fontSize: 19.0,
            //             ),
            //           ),
            //         ),
            //     ],
            //   ),
            // ), 



            // // _form(_tipo),


            // _tipo['id'] == 1? 
            // Padding(
            //   padding: EdgeInsets.only(left: 30.0, right: 30.0,  bottom: 20.0),
            //   child: Container (
            //     child: TextFormField(
            //       style: TextStyle(
            //         color: Colors.white,
            //         fontSize: 19.0
            //       ),
            //       decoration: const InputDecoration(
            //         labelText: 'CEP: ',
            //         labelStyle: TextStyle(
            //           color: Colors.white,
            //         ),
            //       ),
            //       keyboardType: TextInputType.number,
            //       inputFormatters: <TextInputFormatter> [
            //         WhitelistingTextInputFormatter.digitsOnly,
            //       ],
            //     ),
            //   ), 
            // )
            // :
            // null
            // ,




            // Padding(
            //   padding: EdgeInsets.only(left: 30.0, right: 30.0,  bottom: 20.0),
            //   child: Container (
            //     child: TextFormField(
            //       style: TextStyle(
            //         color: Colors.white,
            //         fontSize: 19.0
            //       ),
            //       decoration: const InputDecoration(
            //         labelText: 'Nacionalidade: ',
            //         labelStyle: TextStyle(
            //           color: Colors.white,
            //         ),
            //       ),
            //     ),
            //   ), 
            // ),




            Padding(
              padding: EdgeInsets.only(left: 30.0, right: 30.0,  bottom: 20.0),
              child: Container (
                child: TextFormField(
                  maxLines: 3,
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 19.0
                  ),
                  decoration: const InputDecoration(
                    labelText: 'Endereco: ',
                    labelStyle: TextStyle(
                      color: Colors.white,
                    ),
                  ),
                ),
              ), 
            ),



            Padding(
              padding: EdgeInsets.only(left: 30.0, right: 30.0,  bottom: 20.0),
              child: Container (
                child: TextFormField(
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 19.0
                  ),
                  decoration: const InputDecoration(
                    labelText: 'Bairro: ',
                    labelStyle: TextStyle(
                      color: Colors.white,
                    ),
                  ),
                ),
              ), 
            ),



            Padding(
              padding: EdgeInsets.only(left: 30.0, right: 30.0,  bottom: 20.0),
              child: Container (
                child: TextFormField(
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 19.0
                  ),
                  decoration: const InputDecoration(
                    labelText: 'Cidade: ',
                    labelStyle: TextStyle(
                      color: Colors.white,
                    ),
                  ),
                  keyboardType: TextInputType.emailAddress,
                ),
              ), 
            ),


            Padding(
              padding: EdgeInsets.only(left: 30.0, right: 30.0,  bottom: 20.0),
              child: Container (
                child: TextFormField(
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 19.0
                  ),
                  decoration: const InputDecoration(
                    labelText: 'Estado: ',
                    labelStyle: TextStyle(
                      color: Colors.white,
                    ),
                  ),
                ),
              ), 
            ),


            Padding(
              padding: EdgeInsets.only(left: 30.0, right: 30.0,  bottom: 20.0),
              child: Container (
                child: TextFormField(
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 19.0
                  ),
                  decoration: const InputDecoration(
                    labelText: 'Email: ',
                    labelStyle: TextStyle(
                      color: Colors.white,
                    ),
                  ),
                ),
              ), 
            ),



            Padding(
              padding: EdgeInsets.only(left: 30.0, right: 30.0,  bottom: 20.0),
              child: Container (
                child: TextFormField(
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 19.0
                  ),
                  decoration: const InputDecoration(
                    labelText: 'Telefone: ',
                    labelStyle: TextStyle(
                      color: Colors.white,
                    ),
                  ),
                  keyboardType: TextInputType.phone,
                ),
              ), 
            ),





            Padding(
              padding: EdgeInsets.only(left: 30.0, right: 30.0,  bottom: 20.0),
              child: Container(
                height: 50.0,
                width: 300.0,
                child: RaisedButton (
                  child: Text('Finalizar', style: TextStyle(
                    fontSize: 24.0,
                    color: Color(0xFF01E271)
                    ),
                  ),
                  onPressed: () {
                     
                  },
                ),
              ),
            ),

          ],
        ),
      ),
    );
  }
}