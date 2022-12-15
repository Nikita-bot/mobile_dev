import 'package:flutter/material.dart';
import 'package:shopping_app/crid_interface.dart';
import 'package:shopping_app/shopping_view.dart';



class NewElement extends StatelessWidget {
  NewElement({Key? key}) : super(key: key);

  var NameController = TextEditingController();
  var CostController = TextEditingController();
  @override
  Widget build(BuildContext context) {
    return SafeArea(child: Scaffold(
      body: Column(
        children: [
          TextField(
            controller: NameController,
            decoration: InputDecoration(labelText: "Название", icon: Icon(Icons.accessible_forward_rounded)),

          ),
          TextField(
            controller: CostController,
            decoration: InputDecoration(labelText: "Стоимость", icon: Icon(Icons.account_balance_wallet_rounded)),
          ),
          ElevatedButton(onPressed: (){
            if(NameController.text != null && CostController.text != null){
              CRUDInterface.createElement(NameController.text, double.parse(CostController.text));
              Navigator.of(context).push(
                  MaterialPageRoute(
                    builder: (context) => ShoppingView(),
                  ),
              );
            }

          }, child:const Text("Save"))
        ],
      ),
    ));
  }
}
