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
      body: Center(
        child: Column(
          children: [
            Text(city),
            Image(image: NetworkImage( "http://openweathermap.org/img/wn/${Uri.parse(icon)}.png"),
            width: 100,
            height: 100,),
            Text(description),
            Text(temp),
            Text(pressure),

          ],
        ),
      ),
    );
  }
}
