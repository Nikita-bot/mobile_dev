import 'package:hive/hive.dart';
import 'package:intl/intl.dart';
import 'package:shopping_app/shopping_model.dart';



class CRUDInterface{
  static void createElement(String name, double cost){
    final DateTime now = DateTime.now();
    final DateFormat formatter = DateFormat('dd-MM-yyyy - HH:mm');
    final String formatted = formatter.format(now);
    ShoppingModel shoppingModel = ShoppingModel(name,cost,formatted);
    var myBox = Hive.box<ShoppingModel>("shopping");
    myBox.add(shoppingModel);
    myBox.close();
  }

  static List<ShoppingModel> readAllElement(){
    var myBox = Hive.box<ShoppingModel>("shopping");
    List<ShoppingModel> result = [];
    for (var i=0;i<myBox.values.length;i++){
      result.add(myBox.getAt(i) as ShoppingModel);
    }
    return result;
  }

  static ShoppingModel readElement(int key){
    var myBox = Hive.box<ShoppingModel>("shopping");
    return myBox.getAt(key) as ShoppingModel;
  }

  static void updateElement(ShoppingModel element, String name, double cost){
    element.cost = cost;
    element.name = name;
    element.save();
  }

  static void deleteElement(ShoppingModel element){
    element.delete();
  }

}