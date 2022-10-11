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
          title: const Text("Мое первое приложение"),
        ),
        body: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: const [
            Text(
              "Паздерин Никита ФИТ-194",
            ),
            Text(
              "Pazderin Nikita FIT-194",
            ),
          ],
        ),
      ),
    );
  }
}

