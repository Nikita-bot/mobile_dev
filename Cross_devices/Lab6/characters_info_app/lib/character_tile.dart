
import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

import 'character_page.dart';


class CharacterTile  extends StatelessWidget {
  CharacterTile ({Key? key,required this.imageURL,required this.nickName, required this.characterId}) : super(key: key);

  String imageURL;
  String nickName;
  dynamic characterId;

  @override
  Widget build(BuildContext context) {
    return InkWell(
      child: ListTile(
        leading:Image(
          image: NetworkImage(imageURL),
          height: 50,
          width: 50,
          fit: BoxFit.fill,
        ),
        title: Text(nickName),
      ),
      onTap: (){
        Navigator.of(context).push(
          MaterialPageRoute(builder: (context)=>CharacterPage(characterId: characterId))
        );
      },
    );
  }
}
