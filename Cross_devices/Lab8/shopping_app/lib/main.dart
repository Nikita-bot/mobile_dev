import 'package:flutter/material.dart';

import 'package:hive/hive.dart';


import 'package:hive_flutter/hive_flutter.dart';
import 'package:shopping_app/shopping_model.dart';
import 'package:shopping_app/shopping_view.dart';

Future main() async {
  await Hive.initFlutter();
  Hive.registerAdapter<ShoppingModel>(ShoppingModelAdapter());
  await Hive.openBox<ShoppingModel>('shopping');
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: ShoppingView()
    );
  }
}


