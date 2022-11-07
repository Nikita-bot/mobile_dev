



import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

class ElementsListView extends StatelessWidget {
  const ElementsListView({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: SafeArea(
            child: ListView(
              children: const [
                Element(text: "Red", boxColor: Colors.red),
                Element(text: "Green", boxColor: Colors.green),
                Element(text: "Blue", boxColor: Colors.blue)
              ],
            )),
      );
  }
}

class Element extends StatelessWidget {
  const Element({Key? key, required this.text, required this.boxColor}) : super(key: key);

  final String text;
  final Color boxColor;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: InkWell( //InkWell - жмякающаяся область
          child:Row(
            children: [
              Container(
                color: boxColor,
                height: 50,
                width: 50,
              ),
              const SizedBox(
                width: 20,
              ),
              Text(text)
            ],
          ),
        onTap: (){onTapElement(context,text);},
      )
      );
  }

  void onTapElement(context,String? text){
    var snackBar = SnackBar(
      content: Text("It's $text"),
    );

    ScaffoldMessenger.of(context).showSnackBar(snackBar);
  }
}

