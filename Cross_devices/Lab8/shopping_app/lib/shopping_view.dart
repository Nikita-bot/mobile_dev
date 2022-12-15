import 'package:flutter/material.dart';
import 'package:hive/hive.dart';
import 'package:hive_flutter/adapters.dart';
import 'package:shopping_app/shopping_model.dart';

import 'crid_interface.dart';
import 'new_element_view.dart';

class ShoppingView extends StatefulWidget {
  const ShoppingView({Key? key}) : super(key: key);
  Box<ShoppingModel> myBox = Hive.box("shopping");

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
        valueListenable: myBox.listenable() ,
        builder: (context, Box sm, _){
          List<ShoppingModel> shoppingList = CRUDInterface.readAllElement();
          return ListView.builder(
            itemCount: shoppingList.length,
              itemBuilder: (context, index){
                ShoppingModel sm = shoppingList[index];
                return Row(
                  children: [
                    Text("${sm.cost.toString()} ₽",style: TextStyle(color: Colors.green,fontWeight: FontWeight.bold),),
                    Expanded(
                        child: ListTile(
                            title: Text(sm.name,style: TextStyle(fontSize: 20),),
                            subtitle: Text(sm.createDate)
                        )
                    )
                  ],
                );
              }
          );
        },
      ) ,
      floatingActionButton: FloatingActionButton.extended(onPressed: (){
          Navigator.of(context).push(
            MaterialPageRoute(
              builder: (context) => NewElement(),
            ),
          );
      },
      label:const Text("+",style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),),),

    );
  }


}
