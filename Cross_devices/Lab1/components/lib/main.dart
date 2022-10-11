import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text("Информация обо мне"),
        ),
        body: Center(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              TextFormField(
                initialValue: Strings.myInfo,
              ),
              const Image(image:NetworkImage("https://img1.akspic.ru/attachments/crops/2/2/4/0/50422/50422-senokosnoye_ugodye-pole-selskoe_hozyajstvo-zakat-risovoe_pole-2560x1440.jpg"),
                height: 120,
                width: 120,
              ),
              SizedBox(
                child: ElevatedButton(onPressed: (){}, child:const Text('Ok')),
                width: double.infinity,
              )
            ],
          ),
        ),
      ),
    );
  }
}

class Strings{
  static const String myInfo = "Паздерин Никита ФИТ-194";
}
