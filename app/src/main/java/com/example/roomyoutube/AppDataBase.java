package com.example.roomyoutube;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Usuarios.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
   public abstract UsuariosDao usuariosDao();
}
