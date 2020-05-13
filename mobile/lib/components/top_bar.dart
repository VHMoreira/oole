// import 'package:flutter/material.dart';

// class TopBar extends StatefulWidget implements PreferredSizeWidget{
//   @override
//   _TopBarState createState() => _TopBarState();

//   @override
//   Size get preferredSize => null;
// }

// class _TopBarState extends State<TopBar> {
//   bool _procurando = false;

//   @override
//   Widget build(BuildContext context) {
//     return AppBar(
//       backgroundColor: Color(0xFF008140),
//       elevation: 1.0,
//       title: 
//         _procurando? 
//         TextFormField(
//           autofocus: true,
//           style: TextStyle(
//             color: Colors.white,
//             fontSize: 19.0
//           ),
//           decoration: const InputDecoration(
      
//           ),
//           onChanged: (String value) {
//             setState(() {
//               _login = value;
//             });
//             Timer(Duration(seconds: 1), () => searchJogador);
//           },
//         ) 
//         : 
//         Text('Buscar Jogador'),
//       actions: <Widget>[
//         IconButton(
//           icon: Icon(Icons.search), 
//           onPressed: () {
//             setState(() {
//               _procurando = !_procurando;
//             });
//           }
//         ),
//         IconButton(
//           icon: Icon(Icons.notifications), 
//           onPressed: () {},
//         ),
//         IconButton(
//           icon: Icon(Icons.more_vert), 
//           onPressed: () {},
//         ),
//       ],
//     );
//   }
// }