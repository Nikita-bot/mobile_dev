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
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title:const Text("Контакты"),
      ),
      body: Container(
        width: double.infinity,
        height: double.infinity,
        child: FutureBuilder<List<Contact>>(
          future: getContact(),
          builder: (BuildContext context, AsyncSnapshot<List<Contact>> snapshot){
            switch (snapshot.connectionState) {
              case ConnectionState.waiting: return CircularProgressIndicator();
              default:
                if (snapshot.hasError)
                  return Text('Error: ${snapshot.error}');
                else {
                  if(snapshot.data == null) return CircularProgressIndicator();
                  else {
                    print(snapshot.data?.length);

                    return ListView.builder(
                        itemCount: 4,
                        itemBuilder: (BuildContext context, int index) {
                          Contact contact = snapshot.data![index];
                          return ContactListTile(name: contact.displayName,
                              phone: contact.phones[index],
                              email: "");
                        }
                    );
                  }
                }
            }
          },
        ),
      ),
    );
  }

  Future<List<Contact>> getContact() async{
    print("getContact");
    return await FastContacts.allContacts;
  }
}
