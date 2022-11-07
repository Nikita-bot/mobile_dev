
import 'package:flutter/material.dart';
import 'package:logger/logger.dart' as logger;
import 'package:http/http.dart' as http;
import 'package:dio/dio.dart' as dio;


class WebView extends StatelessWidget {
  const WebView({Key? key}) : super(key: key);

   Future<void> getViaHttp() async {
     logger.Logger log = logger.Logger();
     final response = await http.get(Uri.parse("http://jsonplaceholder.typicode.com/users"));
     if(response.statusCode == 200){

       log.v(response.body);
     }
     else{
       log.e(new Exception("Невозможно получить посты"));
     }
   }

   Future<void> getViaDio() async{
     logger.Logger log = logger.Logger();
     final response = await dio.Dio().get("http://jsonplaceholder.typicode.com/users");
     if(response.statusCode == 200){

       log.v(response.data);
     }
     else{
       log.e(new Exception("Невозможно получить посты"));
     }
   }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
          child: Column(
            children: [
              ElevatedButton(onPressed: (){getViaHttp();}, child: const Text("Network get via http")),
              ElevatedButton(onPressed: (){getViaDio();}, child:const Text("Network get via dio"))
            ],
          ),
      ),
    );
  }
}
