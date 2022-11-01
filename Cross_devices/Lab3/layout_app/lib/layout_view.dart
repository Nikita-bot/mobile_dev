


import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:layout_app/Switcher.dart';

class LayoutView extends StatefulWidget {
  const LayoutView({Key? key}) : super(key: key);

  @override
  State<LayoutView> createState() => _LayoutViewState();
}

class _LayoutViewState extends State<LayoutView> {

  int showedDigit = 1;
  Switcher check = Switcher.firsContainer;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
          child: Column(
            children: [
              SizedBox(
                height: 80,
                child: Row(
                  children: [
                    Expanded(child: Text(check == Switcher.firsContainer ? showedDigit.toString():"",textAlign: TextAlign.center,)),
                    Expanded(child: Text(check == Switcher.secondContainer ? showedDigit.toString():"",textAlign: TextAlign.center)),
                    Expanded(child: Text(check == Switcher.thirdContainer ? showedDigit.toString():"",textAlign: TextAlign.center))
                  ],
                ),
              ),
              SizedBox(
                height: 80,
                width: double.infinity,
                child: Column(
                  children: [
                    Expanded(child: Text(check == Switcher.firsContainer ? showedDigit.toString():"",textAlign: TextAlign.center,)),
                    Expanded(child: Text(check == Switcher.secondContainer ? showedDigit.toString():"",textAlign: TextAlign.center)),
                    Expanded(child: Text(check == Switcher.thirdContainer ? showedDigit.toString():"",textAlign: TextAlign.center))
                  ],
                ),
              ),
              Expanded(child: Column(
                children:[
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      Text(this.check == Switcher.firsContainer ? showedDigit.toString():""),
                      Text(this.check == Switcher.secondContainer ? showedDigit.toString():""),
                    ],
                  ),
                  Text(this.check == Switcher.thirdContainer ? showedDigit.toString():"",textAlign: TextAlign.center,)
                ],
              )),
              SizedBox(
                width: double.infinity,
                child: ElevatedButton(onPressed: (){
                  setState(() {
                    switch(this.check){
                      case Switcher.firsContainer : this.check= Switcher.secondContainer; break;
                      case Switcher.secondContainer : this.check = Switcher.thirdContainer; break;
                      case Switcher.thirdContainer : this.check = Switcher.firsContainer; break;
                    }
                    this.showedDigit += 1;
                  });

                },child: Text("Roll"),),
              )
            ],
          ),
      ),
    );
  }
}
