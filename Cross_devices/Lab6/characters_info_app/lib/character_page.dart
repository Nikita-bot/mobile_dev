
import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'character_model.dart';


class CharacterPage extends StatefulWidget {
  CharacterPage({Key? key,required this.characterId}) : super(key: key);

  dynamic characterId;

  @override
  State<CharacterPage> createState() => _CharacterPageState();
}

class _CharacterPageState extends State<CharacterPage> {


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Данные о персонаже"),
      ),
      body: FutureBuilder<CharacterModel>(
        future: getCharacterData(),
        builder: (BuildContext context, AsyncSnapshot<CharacterModel> snapshot){
          if(snapshot.hasError){
            return Text("Error: ${snapshot.error}");
          }
          else{
            if(snapshot.hasData){
              CharacterModel cm = snapshot.data as CharacterModel;
              return Column(
                children: [
                  Image(image: NetworkImage(cm.img.toString())),
                  Text(cm.name.toString())
                ],
              );
            }
            else return Center(child: CircularProgressIndicator(),);
          }
        },
      ),
    );
  }

  Future<CharacterModel> getCharacterData() async{
    var url = Uri.https("www.breakingbadapi.com","/api/characters/${widget.characterId}");
    var response = await http.get(url);
    if (response.statusCode == 200) {
      var jsonResponse = jsonDecode(response.body) as List;
      CharacterModel cm = jsonResponse.map((e) =>
          CharacterModel.fromJson(e)).toList()[0];
      return cm;
    }
    else {
      throw new Exception("Ошибка при получении персонажей");
    }
  }


}
