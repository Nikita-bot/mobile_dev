import 'MainModel.dart';
import 'Weather.dart';

class WeatherModel {
  List<Weather>? weather;
  Main? main;
  String? name;


  WeatherModel(
      {
        this.weather,

        this.main,

        this.name,
        });

  WeatherModel.fromJson(Map<String, dynamic> json) {

    if (json['weather'] != null) {
      weather = <Weather>[];
      json['weather'].forEach((v) {
        weather!.add(new Weather.fromJson(v));
      });
    }
    main = json['main'] != null ? new Main.fromJson(json['main']) : null;
    name = json['name'];

  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this.weather != null) {
      data['weather'] = this.weather!.map((v) => v.toJson()).toList();
    }
    if (this.main != null) {
      data['main'] = this.main!.toJson();
    }
    data['name'] = this.name;

    return data;
  }
}
