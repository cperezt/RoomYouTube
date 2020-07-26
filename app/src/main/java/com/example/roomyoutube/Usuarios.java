package com.example.roomyoutube;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Usuarios {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "nombreUsuario")
    public String nombreUsuario;
    @ColumnInfo (name = "usuario")
    public String usuario;
    @ColumnInfo(name = "password")
    public String password;

    public Usuarios(String nombreUsuario, String usuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.usuario = usuario;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
