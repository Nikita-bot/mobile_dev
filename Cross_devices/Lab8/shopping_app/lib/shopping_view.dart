import 'package:flutter/material.dart';
import 'package:hive/hive.dart';
import 'package:hive_flutter/adapters.dart';
import 'package:shopping_app/shopping_model.dart';
import 'Boxes.dart';
import 'crid_interface.dart';

class ShoppingView extends StatefulWidget {
  const ShoppingView({Key? key}) : super(key: key);

  @override
  State<ShoppingView> createState() => _ShoppingViewState();
}

class _ShoppingViewState extends State<ShoppingView> {

  @override
  void dispose() {
    Hive.close();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: ValueListenableBuilder<Box<ShoppingModel>>(
        valueListenable: Boxes.getTransactional().listenable() ,
        builder: (context, Box sm, _){
          List<ShoppingModel> shoppingList = CRUDInterface.readAllElement();
          return ListView.builder(
            itemCount: shoppingList.length,
              itemBuilder: (context, index){
                ShoppingModel sm = shoppingList[index];
                return ListTile(
                  title: Text(sm.name),
                  subtitle: Column(
                    children: [
                      Text(sm.cost.toString(),style: TextStyle(fontSize: 20,color: Colors.blue),),
                      Text(sm.createDate,style: TextStyle(fontSize: 20,color: Colors.blue),)
                    ],
                  ),
                );;
              }
          );
        },
      ) ,
      floatingActionButton: FloatingActionButton.extended(onPressed: (){

      },
      label: Text("+",style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),),),
    );
  }
}
