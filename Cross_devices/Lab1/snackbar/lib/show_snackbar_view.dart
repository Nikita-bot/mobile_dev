
import 'package:flutter/material.dart';
import 'package:logger/logger.dart';

class SnackbarView extends StatelessWidget{

  final myController =  TextEditingController();

  @override
  void dispose(){
    myController.dispose();
  }

  void showSnackbar(BuildContext context){
    const snackBar =  SnackBar(
        content: Text('Кнопка ОК нажата')
    );
    ScaffoldMessenger.of(context).showSnackBar(snackBar);
  }

  void printDefaultLog(){

    debugPrint(myController.text);

  }

  void printLoggerLog(){
    var logger = Logger();
    logger.v(myController.text);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
            title: const Text("SnackBar App"),
        ),
        body: Column(
          children: [
            SizedBox(
                width: double.infinity,
                child: ElevatedButton(onPressed: (){ showSnackbar(context);}, child: const Text("Ok"))
            ),
            TextField(
              controller: myController,
            ),
            ElevatedButton(onPressed: (){printDefaultLog();}, child: const Text("Обычное логирование")),
            ElevatedButton(onPressed: (){printLoggerLog();}, child: const Text("Логирование Logger"))
          ],
        ),
      );
  }
  
}