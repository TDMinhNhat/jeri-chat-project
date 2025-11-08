import 'package:flutter/material.dart';
import 'package:jeri_chat_project_mobile/view/home_component/chat_component.dart';
import 'package:jeri_chat_project_mobile/view/home_component/contact_component.dart';
import 'package:jeri_chat_project_mobile/view/home_component/personal_component.dart';

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {

  int _currentIndex = 0;
  String _titleAppBar = "Chat";

  Widget getPageSelected() {
    switch(_currentIndex) {
      case 0: {
        setState(() {
          _titleAppBar = "Chat";
        });
        return ChatComponent();
      };
      case 1: {
        setState(() {
          _titleAppBar = "Contact";
        });
        return ContactComponent();
      };
      case 2: {
        setState(() {
          _titleAppBar = "Personal";
        });
        return PersonalComponent();
      };
      default: {
        setState(() {
          _titleAppBar = "Chat";
        });
        return ChatComponent();
      };
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          backgroundColor: Colors.blue,
          actions: [
            Text(_titleAppBar, style: TextStyle(color: Colors.white, fontWeight: FontWeight.bold),),
            
            IconButton(onPressed: () {
              Navigator.pushNamed(context, "/searching");
            }, icon: Icon(Icons.search)),
          ],
        ),

        body: getPageSelected(),

        bottomNavigationBar: BottomNavigationBar(
          items: [
            BottomNavigationBarItem(
                icon: Icon(Icons.chat), label: "Chat"),
            BottomNavigationBarItem(
                icon: Icon(Icons.contacts), label: "Contact"),
            BottomNavigationBarItem(
                icon: Icon(Icons.event), label: "Blog"),
            BottomNavigationBarItem(
                icon: Icon(Icons.person), label: "Personal"),
          ],
          currentIndex: _currentIndex,
          selectedItemColor: Colors.red,
          onTap: (index) {
            setState(() {
              _currentIndex = index;
            });
          },
        ),
    );
  }
}
