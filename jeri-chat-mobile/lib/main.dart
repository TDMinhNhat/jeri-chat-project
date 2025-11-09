import 'package:flutter/material.dart';
import 'package:jeri_chat_project_mobile/view/register_page.dart';
import 'package:jeri_chat_project_mobile/view/searching_page.dart';
import 'package:jeri_chat_project_mobile/view/home_page.dart';
import 'package:jeri_chat_project_mobile/view/login_page.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
      ),
      initialRoute: "/home",
      routes: {
        "/": (context) => LoginPage(),
        "/home": (context) => HomePage(),
        "/register": (context) => RegisterPage(),
        "/searching": (context) => SearchingPage()
      },
    );
  }
}