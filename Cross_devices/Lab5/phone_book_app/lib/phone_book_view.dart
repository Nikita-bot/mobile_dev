import 'package:fast_contacts/fast_contacts.dart';
import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';



import 'contact_list_tile.dart';



class PhoneBookView extends StatefulWidget {
  const PhoneBookView({Key? key}) : super(key: key);

  @override
  State<PhoneBookView> createState() => _PhoneBookViewState();
}

class _PhoneBookViewState extends State<PhoneBookView> {

  late List<Contact> contacts;
  late List<Contact> filteredContacts;
  late List<Contact> suggestions;
  TextEditingController controller = TextEditingController();
  @override
  void initState() {
    getContact();
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title:const Text("Контакты"),
      ),
      body: Column(
        children: [
          TextField(
            decoration: InputDecoration(labelText: "Поиск", icon: Icon(Icons.find_in_page)),
            controller: controller,
            onChanged: (value){
              searchContacts(value);
            },
          ),
          Expanded(
            child: ListView.builder(
                        itemCount: filteredContacts.length,
                        itemBuilder: (BuildContext context, int index) {
                          Contact contact = filteredContacts[index];
                          return ContactListTile(
                              name: contact.displayName.isEmpty ? "":contact.displayName,
                              phone: contact.phones.isEmpty ? "":contact.phones[0].toString(),
                              email: contact.emails.isEmpty ? "":contact.emails[0].toString());
                        }
                        )
          ),
        ],
      )
    );
  }

  void searchContacts(String query){
    if(controller.text == ""){
      setState(() {
        filteredContacts = contacts;
      });
    }
    else{
      print(controller.text);
      setState(() {
        suggestions = filteredContacts.where((el) => el.displayName.toLowerCase().contains(controller.text.toLowerCase())).toList();
        print(filteredContacts[0].displayName.toLowerCase());
        filteredContacts = suggestions;
      });
    }
  }

  void getContact(){
    print("getContact");
    FastContacts.allContacts.then((value) => {
      contacts = value,
      filteredContacts = contacts
    });

  }
}
