import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class ProgressView extends StatefulWidget {
  const ProgressView({Key? key}) : super(key: key);

  @override
  State<ProgressView> createState() => _ProgressViewState();
}

class _ProgressViewState extends State<ProgressView> {

  final textController = TextEditingController();
  double process = 0;
  String text = "";
  bool check = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body:SafeArea(
        child: Column(
          children: [
            TextField(
              controller: textController,
            ),
            LinearProgressIndicator(
              value: process,
            ),
            Text(text == "" ? "Здесь будет отображаться введенный текст" : text),
            CheckboxListTile(
              value: check,
              onChanged: (b){
                setState(() {
                  changeToggleValue();
                });
              },
              title:const Text("Вы уверены?"),
               controlAffinity: ListTileControlAffinity.leading
            ),
            ElevatedButton(onPressed: (){setState(() {
              setProgress();
            });}, child:const Text("Process"))
          ],
        ),
      )

    );
  }

  void changeToggleValue(){
    this.check = !this.check;
  }

  void setProgress(){
    if(check && textController.text!=""){
      text = textController.text;
      process += 0.1;

      if(process>1) process = 0;
    }

  }


}
