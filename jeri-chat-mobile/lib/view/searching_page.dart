import 'package:flutter/material.dart';

class SearchingPage extends StatefulWidget {
  const SearchingPage({super.key});

  @override
  State<SearchingPage> createState() => _SearchingPageState();
}

class _SearchingPageState extends State<SearchingPage> {

  String? _textSearch = "";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        centerTitle: true,
        actions: [
          TextField(
            autofocus: true,
            decoration: InputDecoration(
              hintText: "Type here to search",
              border: OutlineInputBorder(),
              suffixIcon: Icon(Icons.search),
            ),
            onChanged: (value){
              setState(() {
                _textSearch = value;
              });
            },
          ),
        ],
      ),

      body: Padding(
        padding: EdgeInsets.symmetric(horizontal: 10),
        child: Column(children: []),
      ),
    );
  }
}
