
import 'package:hive/hive.dart';
part 'shopping_model.g.dart';


@HiveType(typeId: 0)
class ShoppingModel extends HiveObject{
  @HiveField(0)
  late String name;
  @HiveField(1)
  late String createDate;
  @HiveField(2)
  late double cost;

  ShoppingModel(String name, double cost, String createDate){
    this.name = name;
    this.cost = cost;
    this.createDate = createDate;
  }

}
