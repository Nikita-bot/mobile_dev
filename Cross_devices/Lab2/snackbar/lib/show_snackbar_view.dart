
import 'package:flutter/material.dart';
import 'package:logger/logger.dart';


class _SnackbarView extends State<SnackbarView>{

  final myController =  TextEditingController();
  bool isExpanded = false;

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

  void changeExpandedState(){
    this.isExpanded = this.isExpanded ? false:true;

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
            ElevatedButton(onPressed: (){printLoggerLog();}, child: const Text("Логирование Logger")),
            Text(
              "Паздерин Никита Игоревич",
              style: !isExpanded ? TextStyle(
                color: Colors.red,
                fontSize: 14
              ) :
                  TextStyle(
                      color: Colors.green,
                      fontSize: 25
                  )
            ),
            ElevatedButton(onPressed: (){setState(() {
              changeExpandedState();
            });}, child: Text( !isExpanded ?  "Увеличить" : "Уменьшить"))
            
          ],
        ),
      );
  }
  
}

class SnackbarView extends StatefulWidget{

  SnackbarView({ Key? key}) : super(key: key);

  @override
  _SnackbarView createState() => _SnackbarView();

}