package com.example.blbliodb;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Book {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    public long Id;

    @NonNull
    public String Titre;

    @NonNull
    public String Auteur;

    @NonNull
    public String Resume;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    @NonNull
    public String getTitre() {
        return Titre;
    }

    public void setTitre(@NonNull String titre) {
        Titre = titre;
    }

    @NonNull
    public String getAuteur() {
        return Auteur;
    }

    public void setAuteur(@NonNull String auteur) {
        Auteur = auteur;
    }

    @NonNull
    public String getResume() {
        return Resume;
    }

    public void setResume(@NonNull String resume) {
        Resume = resume;
    }
}
