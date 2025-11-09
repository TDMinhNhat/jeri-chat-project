import 'package:flutter/material.dart';
import 'package:jeri_chat_project_mobile/model/entity/address.dart';
import 'package:jeri_chat_project_mobile/model/enum/user_gender.dart';

class RegisterPage extends StatefulWidget {
  const RegisterPage({super.key});

  @override
  State<RegisterPage> createState() => _RegisterPageState();
}

class _RegisterPageState extends State<RegisterPage> {
  final _formKey = GlobalKey<FormState>();

  // Personal Information
  final _firstNameController = TextEditingController();
  final _lastNameController = TextEditingController();
  final _phoneNumberController = TextEditingController();
  final _displayNameController = TextEditingController();
  final _emailController = TextEditingController();
  final _passwordController = TextEditingController();

  // Address Information
  final _addressController = TextEditingController();
  final _wardController = TextEditingController();
  final _cityController = TextEditingController();
  final _countryController = TextEditingController();
  final _zipCodeController = TextEditingController();

  String? _firstName;
  String? _lastName;
  UserGender? _userGender;
  String? _phoneNumber;
  DateTime? _birthDate;
  String? _address;
  String? _ward;
  String? _city;
  String? _country;
  String? _zipCode;
  String? _displayName;
  String? _email;
  String? _password;

  Future<void> _pickDate(BuildContext context) async {
    final DateTime? picked = await showDatePicker(
      context: context,
      initialDate: _birthDate ?? DateTime.now(),
      firstDate: DateTime(1900),
      lastDate: DateTime(2100),
    );

    if (picked != null && picked != _birthDate) {
      setState(() {
        _birthDate = picked;
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.blue,
        centerTitle: true,
        foregroundColor: Colors.white,
        title: Text("Sign Up", style: TextStyle(fontWeight: FontWeight.bold)),
      ),

      body: SingleChildScrollView(
        child: Padding(
          padding: EdgeInsets.symmetric(horizontal: 10, vertical: 20),
          child: Form(
            key: _formKey,
            autovalidateMode: AutovalidateMode.always,
            child: Expanded(child: Column(
              children: [
                Text("Create Account", style: TextStyle(fontWeight: FontWeight.bold, fontSize: 30),)
              ],
            ))
          ),
        ),
      ),
    );
  }
}