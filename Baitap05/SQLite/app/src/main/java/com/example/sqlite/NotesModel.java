package com.example.sqlite;

import java.io.Serializable;

public class NotesModel implements Serializable {
    private int IdNote;
    private String NameNote;

    public int getIdNote() {
        return IdNote;
    }

    public void setIdNote(int idNote) {
        IdNote = idNote;
    }

    public String getNameNote() {
        return NameNote;
    }

    public void setNameNote(String nameNote) {
        NameNote = nameNote;
    }

    public NotesModel(int idNote, String nameNote) {
        IdNote = idNote;
        NameNote = nameNote;
    }
}
