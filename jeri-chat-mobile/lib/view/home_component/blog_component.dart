import 'package:flutter/material.dart';

class BlogComponent extends StatefulWidget {
  const BlogComponent({super.key});

  @override
  State<BlogComponent> createState() => _BlogComponentState();
}

class _BlogComponentState extends State<BlogComponent> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(
        padding: EdgeInsets.symmetric(horizontal: 10),
        child: Column(),
      ),
    );
  }
}
