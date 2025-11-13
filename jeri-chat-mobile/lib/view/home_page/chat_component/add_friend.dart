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

            SearchBar(
              controller: _contentController,
              onChanged: (value) {
                setState(() {
                  _contentSearching = value;
                });
              },
              hintText: "Search by Display Name, Phone or Email",
              autoFocus: true,
              leading: Icon(Icons.search),

            ),
          ],
        ),
      ),
    );
  }
}
