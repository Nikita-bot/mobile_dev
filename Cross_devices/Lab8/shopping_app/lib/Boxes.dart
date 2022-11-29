import 'package:hive/hive.dart';
import 'package:shopping_app/shopping_model.dart';

class Boxes{
  static Box<ShoppingModel> getTransactional(){
    return Hive.box<ShoppingModel>("shopping");
  }
}