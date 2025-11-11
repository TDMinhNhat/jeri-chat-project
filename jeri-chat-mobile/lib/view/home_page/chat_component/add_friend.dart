import 'package:flutter/material.dart';

class AddFriend extends StatefulWidget {
  const AddFriend({super.key});

  @override
  State<AddFriend> createState() => _AddFriendState();
}

class _AddFriendState extends State<AddFriend> {

  final _contentController = TextEditingController();

  String? _contentSearching;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(
          "Add Friend",
          style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
        ),
        centerTitle: true,
        backgroundColor: Colors.blue,
        foregroundColor: Colors.white,
      ),

      body: Padding(
        padding: EdgeInsets.symmetric(horizontal: 10),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            SizedBox(height: 20),

            Row(
              children: [
                SearchBar(
                  controller: _contentController,
                ),

                SizedBox(width: 20,),

                DropdownButton(items: ["Display Name", "Phone", "Email"].map((item) {
                  return DropdownMenuItem(value: item,child: Text(item));
                }).toList(), onChanged: (value){

                }, icon: Icon(Icons.filter_list_alt),),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
