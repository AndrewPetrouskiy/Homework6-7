package models;

import java.util.List;

public interface Repository {
    List<Note> getAllNotes();
    String CreateNote(Note note);

    void updateNote(Note note);

    void deleteNote(String note);
}
