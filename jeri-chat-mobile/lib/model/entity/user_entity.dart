import 'package:jeri_chat_project_mobile/model/entity/address.dart';
import 'package:jeri_chat_project_mobile/model/enum/user_gender.dart';

class UserEntity {
  String _firstName;
  String _lastName;
  UserGender _userGender;
  DateTime _birthDate;
  String _phoneNumber;
  Address _address;
  String _displayName;
  String _email;
  String _password;

  UserEntity(
    this._firstName,
    this._lastName,
    this._userGender,
    this._birthDate,
    this._phoneNumber,
    this._address,
    this._displayName,
    this._email,
    this._password,
  );

  String get password => _password;

  set password(String value) {
    _password = value;
  }

  String get email => _email;

  set email(String value) {
    _email = value;
  }

  String get displayName => _displayName;

  set displayName(String value) {
    _displayName = value;
  }

  Address get address => _address;

  set address(Address value) {
    _address = value;
  }

  String get phoneNumber => _phoneNumber;

  set phoneNumber(String value) {
    _phoneNumber = value;
  }

  DateTime get birthDate => _birthDate;

  set birthDate(DateTime value) {
    _birthDate = value;
  }

  UserGender get userGender => _userGender;

  set userGender(UserGender value) {
    _userGender = value;
  }

  String get lastName => _lastName;

  set lastName(String value) {
    _lastName = value;
  }

  String get firstName => _firstName;

  set firstName(String value) {
    _firstName = value;
  }
}
