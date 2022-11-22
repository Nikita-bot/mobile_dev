
import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:phone_book_app/phone_alert.dart';

class ContactListTile extends StatelessWidget {
  const ContactListTile({Key? key, required this.name,required this.phone,required this.email}) : super(key: key);
  final String? name;
  final String? phone;
  final String? email;

  @override
  Widget build(BuildContext context) {
    return InkWell(
      child: ListTile(
          title:Text(name.toString()),
          subtitle: Row(
            children: [
              Text(phone.toString()),
              Text(email.toString()),
            ],
          )
      ),
      onTap: (){showDialog(
          context: context,
          builder:(BuildContext context){
            return PhoneAlert(phoneNumber: phone.toString());
          });
      },
    );
  }
}
