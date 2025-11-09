import 'package:flutter/material.dart';

class LoginPage extends StatefulWidget {
  const LoginPage({super.key});

  @override
  State createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  final _formKey = GlobalKey<FormState>();
  final _accountController = TextEditingController();
  final _passwordController = TextEditingController();

  String? _accountValue;
  String? _passwordValue;

  bool _isObscure = true;

  void _goToHomePage() {
    Navigator.pop(context, "/");
    Navigator.pushNamed(context, "/home");
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Padding(
          padding: EdgeInsets.symmetric(horizontal: 20, vertical: 20),
          child: Center(
            child: Form(
              key: _formKey,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  // Logo
                  Center(
                    child: Image.asset(
                      "assets/images/logo.png",
                      width: 200,
                      height: 200,
                    ),
                  ),

                  // Title
                  Text(
                    "Sign In",
                    style: TextStyle(fontSize: 30, fontWeight: FontWeight.bold),
                  ),

                  // Create height space
                  SizedBox(height: 30),

                  // Form
                  TextFormField(
                    controller: _accountController,
                    validator: (value) {
                      if (value == null || value.isEmpty) {
                        return "Please enter your account";
                      } else {
                        return null;
                      }
                    },
                    decoration: InputDecoration(
                      label: Text("Account"),
                      hintText: "Enter your account",
                      border: OutlineInputBorder(),
                      prefixIcon: Icon(Icons.account_circle),
                    ),
                    onSaved: (value) => _accountValue = value,
                  ),

                  // Create height space
                  SizedBox(height: 15),

                  TextFormField(
                    controller: _passwordController,
                    validator: (value) {
                      if (value == null || value.isEmpty) {
                        return "Please enter your password";
                      } else {
                        return null;
                      }
                    },
                    onSaved: (value) => _passwordValue = value,
                    decoration: InputDecoration(
                      label: Text("Password"),
                      hintText: "Enter your password",
                      border: OutlineInputBorder(),
                      prefixIcon: Icon(Icons.lock),
                      suffixIcon: IconButton(
                        onPressed: () {
                          setState(() {
                            _isObscure = !_isObscure;
                          });
                        },
                        icon: _isObscure
                            ? Icon(Icons.visibility_off)
                            : Icon(Icons.visibility),
                      ),
                    ),
                    obscureText: _isObscure,
                    obscuringCharacter: "*",
                  ),

                  // Create height space
                  SizedBox(height: 30),

                  // Forgot password & Sign up
                  Row(
                    children: [
                      TextButton(
                        onPressed: () {},
                        child: Text("Forgot password?"),
                      ),

                      const Spacer(),

                      TextButton(onPressed: () {
                        Navigator.pushNamed(context, "/register");
                      }, child: Text("Sign up")),
                    ],
                  ),

                  // Create height space
                  SizedBox(height: 10),

                  // Button
                  Row(
                    children: [
                      Expanded(
                        child: ElevatedButton(
                          onPressed: () {
                            if (_formKey.currentState!.validate()) {
                              _formKey.currentState!.save();

                              _goToHomePage();
                            }
                          },
                          style: ElevatedButton.styleFrom(
                            backgroundColor: Colors.red,
                            padding: EdgeInsets.symmetric(vertical: 20)
                          ),
                          child: const Text(
                            "Login",
                            style: TextStyle(color: Colors.white, fontSize: 15),
                          ),
                        ),
                      ),
                    ],
                  ),

                  // Create height space
                  SizedBox(height: 20),

                  // Text others sign in
                  Center(child: Text("Or")),

                  // Create height space
                  SizedBox(height: 20),

                  // Button others sign in
                  Row(
                    crossAxisAlignment: CrossAxisAlignment.center,
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      IconButton(
                        onPressed: () {},
                        icon: Icon(
                          Icons.facebook,
                          size: 40,
                          color: Colors.blue,
                        ),
                      ),
                      SizedBox(width: 30),
                      IconButton(
                        onPressed: () {},
                        icon: Icon(Icons.tiktok, size: 40, color: Colors.black),
                      ),
                      SizedBox(width: 30),
                      IconButton(
                        onPressed: () {},
                        icon: Icon(Icons.apple, size: 40, color: Colors.black),
                      ),
                    ],
                  ),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
