class CharacterModel {
  int? charId;
  String? name;
  String? birthday;
  List<String>? occupation;
  String? img;
  String? status;
  String? nickname;
  List<int>? appearance;
  String? portrayed;
  String? category;

  CharacterModel({required this.charId,
    required this.name,
    required this.birthday,
    required this.occupation,
    required this.img,
    required this.status,
    required this.nickname,
    required this.appearance,
    required this.portrayed,
    required this.category,
  });

  factory CharacterModel.fromJson(Map<String, dynamic> json)=>CharacterModel(
    charId : json['char_id'],
    name : json['name'],
    birthday : json['birthday'],
    occupation : json['occupation'].cast<String>(),
    img : json['img'],
    status : json['status'],
    nickname : json['nickname'],
    appearance : json['appearance'].cast<int>(),
    portrayed : json['portrayed'],
    category : json['category'],
  );

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['char_id'] = this.charId;
    data['name'] = this.name;
    data['birthday'] = this.birthday;
    data['occupation'] = this.occupation;
    data['img'] = this.img;
    data['status'] = this.status;
    data['nickname'] = this.nickname;
    data['appearance'] = this.appearance;
    data['portrayed'] = this.portrayed;
    data['category'] = this.category;

    return data;
  }
}
