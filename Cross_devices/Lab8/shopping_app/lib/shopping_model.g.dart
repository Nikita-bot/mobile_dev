// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'shopping_model.dart';

// **************************************************************************
// TypeAdapterGenerator
// **************************************************************************

class ShoppingModelAdapter extends TypeAdapter<ShoppingModel> {
  @override
  final int typeId = 0;

  @override
  ShoppingModel read(BinaryReader reader) {
    final numOfFields = reader.readByte();
    final fields = <int, dynamic>{
      for (int i = 0; i < numOfFields; i++) reader.readByte(): reader.read(),
    };
    return ShoppingModel(
      fields[0] as String,
      fields[2] as double,
      fields[1] as String,
    );
  }

  @override
  void write(BinaryWriter writer, ShoppingModel obj) {
    writer
      ..writeByte(3)
      ..writeByte(0)
      ..write(obj.name)
      ..writeByte(1)
      ..write(obj.createDate)
      ..writeByte(2)
      ..write(obj.cost);
  }

  @override
  int get hashCode => typeId.hashCode;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is ShoppingModelAdapter &&
          runtimeType == other.runtimeType &&
          typeId == other.typeId;
}
