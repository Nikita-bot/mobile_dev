
import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

class ContactListTile extends StatelessWidget {
  const ContactListTile({Key? key, required this.name,required this.phone,required this.email}) : super(key: key);
  final String? name;
  final String? phone;
  final String? email;

  @override
  Widget build(BuildContext context) {
    return ListTile(
      title:Text(name.toString()),
      subtitle: Row(
        children: [
          Text(phone.toString()),
          Text(email.toString()),
        ],
      )
    );
  }
}
