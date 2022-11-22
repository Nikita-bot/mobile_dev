import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:http/http.dart' as http;
import 'dart:convert' as convert;

import 'character_model.dart';
import 'character_tile.dart';

class CharactersView extends StatefulWidget {
  const CharactersView({Key? key}) : super(key: key);

  @override
  State<CharactersView> createState() => _CharactersViewState();
}

class _CharactersViewState extends State<CharactersView> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Персонажи"),
      ),
      body: FutureBuilder<List<CharacterModel>>(
        future: getCharacter(),
        builder: (BuildContext context, AsyncSnapshot<List<CharacterModel>> snapshot) {
          if(snapshot.hasError){
            return Text("Error ${snapshot.error}");
          }
          else{
            if (snapshot.hasData) {
              print("Snapshot has data");
              List<CharacterModel> charactersList = snapshot.data!.toList();
              return ListView.builder(
                  itemCount: charactersList.length,
                  itemBuilder: (BuildContext context, int index) {
                    CharacterModel cm = charactersList[index];
                    return CharacterTile(imageURL: cm.img.toString(),
                        nickName: cm.nickname.toString());
                  }
              );
            }
            else{
              return Center(child: CircularProgressIndicator(),);
            }
          }

        },
      ),
    );
  }

  Future<List<CharacterModel>> getCharacter() async {
    var url = Uri.https("www.breakingbadapi.com","/api/characters/");
    print(url);
    var response = await http.get(url);
    print("now here");
    print(response.body);
    if (response.statusCode == 200) {

      var jsonResponse = convert.jsonDecode(response.body) as List;

      List<CharacterModel> list = jsonResponse.map((e) =>
          CharacterModel.fromJson(e)).toList();
      print(list[0].nickname);
      return list;
    }
    else {
      throw new Exception("Ошибка при получении персонажей");
    }
  }
}
