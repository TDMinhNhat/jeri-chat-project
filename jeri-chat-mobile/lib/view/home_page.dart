import 'package:flutter/material.dart';
import 'package:jeri_chat_project_mobile/view/home_component/blog_component.dart';
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
  Widget _currentPage = ChatComponent();
  String _titleAppBar = "Chat";

  List<Widget> _getListWidgets() {
    switch (_currentPage) {
      case ChatComponent():
        return <Widget>[
          IconButton(onPressed: () {

          }, icon: Icon(Icons.person_add, color: Colors.white,)),

          IconButton(onPressed: () {

          }, icon: Icon(Icons.group_add, color: Colors.white,))
        ];
      case ContactComponent():
        return <Widget>[
          IconButton(onPressed: (){
            Navigator.pushNamed(context, "/searching");
          }, icon: Icon(Icons.search, color: Colors.white,))
        ];
      default: return <Widget>[];
    };
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.blue,
        centerTitle: true,
        title: Text(_titleAppBar,
          style: TextStyle(color: Colors.white, fontWeight: FontWeight.bold),),
        actions: _getListWidgets(),
      ),

      body: _currentPage,

      bottomNavigationBar: BottomNavigationBar(
        items: [
          BottomNavigationBarItem(
              icon: Icon(Icons.chat),
              label: "Chat",
              tooltip: "List of private and group chat rooms that you had been joined"),
          BottomNavigationBarItem(
              icon: Icon(Icons.contacts),
              label: "Contact",
              tooltip: "List of your contacts"),
          BottomNavigationBarItem(
              icon: Icon(Icons.event),
              label: "Blog",
              tooltip: "To view blog posts from you and others"),
          BottomNavigationBarItem(
              icon: Icon(Icons.person),
              label: "Personal",
              tooltip: "Your personal profile and settings"),
        ],
        currentIndex: _currentIndex,
        backgroundColor: Colors.blue,
        selectedItemColor: Colors.red,
        selectedLabelStyle: TextStyle(
          fontWeight: FontWeight.bold,
        ),
        unselectedItemColor: Colors.white,
        type: BottomNavigationBarType.fixed,
        onTap: (index) {
          setState(() {
            _currentIndex = index;

            switch (_currentIndex) {
              case 0:
                {
                  _titleAppBar = "Chat";
                  _currentPage = ChatComponent();
                };
              case 1:
                {
                  _titleAppBar = "Contact";
                  _currentPage = ContactComponent();
                };
              case 2:
                {
                  _titleAppBar = "Blog";
                  _currentPage = BlogComponent();
                };
              case 3:
                {
                  _titleAppBar = "Personal";
                  _currentPage = PersonalComponent();
                };
            }
          });
        },
      ),
    );
  }
}
