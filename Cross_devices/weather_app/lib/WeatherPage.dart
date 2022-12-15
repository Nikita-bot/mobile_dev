import 'package:flutter/material.dart';

class WeatherPage extends StatelessWidget {
  WeatherPage({Key? key, required this.city, required this.icon, required this.description, required this.temp, required this.pressure}) : super(key: key);

  String city;
  String icon;
  String description;
  String temp;
  String pressure;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.blue,
      body:Center(child:Column(
        mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(city, style: TextStyle(color: Colors.white, fontSize: 40)),
            Image(image: NetworkImage( "http://openweathermap.org/img/wn/${Uri.parse(icon)}@4x.png"),
            width: 100,
            height: 100,),
            Text(description,style: TextStyle(color: Colors.white, fontSize: 30)),
            Text("${double.parse(temp).round()} °C",style: TextStyle(color: Colors.white, fontSize: 40,fontWeight: FontWeight.bold)),
            Text("${(int.parse(pressure)*0.75).round().toString()} мм рт. ст.",style: TextStyle(color: Colors.white, fontSize: 30)),

          ],
      ),
    ));
  }
}
