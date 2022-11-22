
import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';


class CharacterTile  extends StatelessWidget {
  CharacterTile ({Key? key,required this.imageURL,required this.nickName}) : super(key: key);

  String imageURL;
  String nickName;

  @override
  Widget build(BuildContext context) {
    return ListTile(
      leading:Image(
        image: NetworkImage(imageURL),
        height: 50,
        width: 50,
        fit: BoxFit.fill,
      ),
      title: Text(nickName),
    );
  }
}
