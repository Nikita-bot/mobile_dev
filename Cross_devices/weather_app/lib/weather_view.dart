import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:weather_app/WeatherPage.dart';
import 'WeatherModel.dart';


class WeatherView extends StatefulWidget {
  const WeatherView({Key? key}) : super(key: key);

  @override
  State<WeatherView> createState() => _WeatherViewState();
}

class _WeatherViewState extends State<WeatherView> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: FutureBuilder<WeatherModel>(
          future: getWeather(),
          builder: (context, snapshot){
            if(snapshot.hasError) return Text("Error: ${snapshot.error}");
            else{
              if(snapshot.hasData){
                print(snapshot.data);
                  WeatherModel wm = snapshot.data as WeatherModel;
                  return WeatherPage(
                    city: wm.name.toString(),
                    icon: wm.weather![0].icon.toString(),
                    description: wm.weather![0].description.toString(),
                    pressure : wm.main!.pressure.toString(),
                    temp: wm.main!.temp.toString(),
                  );
              }
              else return Center(child: CircularProgressIndicator(),);
            }
          },
        ),
      ),
    );
  }

  Future<WeatherModel> getWeather() async{
    var url = Uri.https("api.openweathermap.org","/data/2.5/weather?lat=55.3333&lon=86.0833&appid=f4ecb913d35a18fee6ce37d714c9f85f&units=metric");
    print(url);
    var response = await http.get(url);
    print("now here");
    print(response.body);
    if (response.statusCode == 200) {

      var jsonResponse = jsonDecode(response.body) as List;
      WeatherModel wm= jsonResponse.map((e) => WeatherModel.fromJson(e)).toList()[0];

      return wm;
    }
    else {
      throw new Exception("Ошибка при получении погоды");
    }
  }
}
