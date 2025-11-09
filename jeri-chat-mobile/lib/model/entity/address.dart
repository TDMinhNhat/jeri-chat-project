
class Address {
  String _address;
  String _ward;
  String _city;
  String _country;
  String _zipCode;

  Address(this._address, this._ward, this._city, this._country, this._zipCode);

  String get zipCode => _zipCode;

  set zipCode(String value) {
    _zipCode = value;
  }

  String get country => _country;

  set country(String value) {
    _country = value;
  }

  String get city => _city;

  set city(String value) {
    _city = value;
  }

  String get ward => _ward;

  set ward(String value) {
    _ward = value;
  }

  String get address => _address;

  set address(String value) {
    _address = value;
  }
}