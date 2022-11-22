import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:url_launcher/url_launcher.dart';



class PhoneAlert extends StatelessWidget {
   PhoneAlert({Key? key, required this.phoneNumber}) : super(key: key);

  String phoneNumber;

  @override
  Widget build(BuildContext context) {
    return AlertDialog(
      title: Text("Выберите действие"),
      content: Row(
        children: [
          ElevatedButton(onPressed: (){
            Uri launch = Uri(
                scheme: "tel",
                path: phoneNumber
            );
            launchUrl(launch);
            },
            child: Text("Позвонить"),

          ),
          ElevatedButton(onPressed: (){
            Uri launch = Uri.parse("https://yandex.ru/search/?text=$phoneNumber");
            launchUrl(launch);
          }, child: Text("Кто это?")
          ),

        ],
      ),
    );
  }
}
