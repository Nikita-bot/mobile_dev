import 'package:hive/hive.dart';
import 'package:shopping_app/shopping_model.dart';

import 'Boxes.dart';

class CRUDInterface{
  static void createElement(String name, double cost){
    ShoppingModel shoppingModel = ShoppingModel(name,cost,DateTime.now().toString());
    var myBox = Boxes.getTransactional();
    myBox.add(shoppingModel);
    myBox.close();
  }

  static List<ShoppingModel> readAllElement(){
    var myBox = Boxes.getTransactional();
    List<ShoppingModel> result = List.empty();
    for (var i=0;i<myBox.values.length;i++){
      result.add(myBox.getAt(i) as ShoppingModel);
    }
    return result;
  }

  static ShoppingModel readElement(String key){
    var myBox = Boxes.getTransactional();
    return myBox.get(key) as ShoppingModel;
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