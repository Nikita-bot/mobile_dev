import 'MainModel.dart';
import 'Weather.dart';

class WeatherModel {

  List<Weather>? weather;
  String? base;
  Main? main;
  num? visibility;
  num? dt;
  num? timezone;
  num? id;
  String? name;
  num? cod;

  WeatherModel(
      { this.weather,
        this.base,
        this.main,
        this.visibility,
        this.dt,
        this.timezone,
        this.id,
        this.name,
        this.cod});

  WeatherModel.fromJson(Map<String, dynamic> json) {
    if (json['weather'] != null) {
      weather = <Weather>[];
      json['weather'].forEach((v) {
        weather?.add(new Weather.fromJson(v));
      });
    }
    base = json['base'];
    main = json['main'] != null ? new Main.fromJson(json['main']) : null;
    visibility = json['visibility'];
    dt = json['dt'];
    timezone = json['timezone'];
    id = json['id'];
    name = json['name'];
    cod = json['cod'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();

    if (this.weather != null) {
      data['weather'] = this.weather?.map((v) => v.toJson()).toList();
    }
    data['base'] = this.base;
    if (this.main != null) {
      data['main'] = this.main?.toJson();
    }
    data['visibility'] = this.visibility;
    data['dt'] = this.dt;
    data['timezone'] = this.timezone;
    data['id'] = this.id;
    data['name'] = this.name;
    data['cod'] = this.cod;
    return data;
  }
}