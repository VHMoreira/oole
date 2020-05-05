import 'package:flutter/material.dart';

import 'oole_list.dart';

class OoleBody extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.start,
      children: <Widget>[
        Flexible(child: OoleList()),
      ],
    );
  }
}