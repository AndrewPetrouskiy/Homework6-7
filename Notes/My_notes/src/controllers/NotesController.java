package controllers;


import models.Note;
import models.Repository;

import java.util.List;

public class NotesController {
    private final Repository repository;

    public NotesController(Repository repository) {
        this.repository = repository;
    }

    public void saveNote(Note note) throws Exception {
        validateNote(note);
        repository.CreateNote(note);
    }

    public Note readNote(String noteId) throws Exception {
        List<Note> notes = repository.getAllNotes();
        for (Note note : notes) {
            if (note.getId().equals(noteId)) {
                return note;
            }
        }
        throw new Exception("User not found");
    }

    public List<Note> readNotes() {
        List<Note> notes = repository.getAllNotes();
        return notes;
    }
    public void updateNote(String noteId, Note notes) throws Exception {
        presenceId(noteId);
        notes.setId(noteId);
        validateUserID(notes);
        repository.updateNote(notes);
    }
    public void deleteUser(String noteId){
        repository.deleteNote(noteId);
    }

    private void validateNote(Note note) throws Exception {
        if (note.getHeader().isEmpty()){
            throw new Exception("Note has an empty header");
        }
        if (note.getContent().isEmpty()){
            throw new Exception("Note has an empty content");
        }
    }
    private void validateUserID(Note note) throws Exception {
        if (note.getId().isEmpty()) {
            throw new Exception("Note hasn't ID");
        }
        validateNote(note);
    }
    public void presenceId(String idNum){
        List<Note> notes = repository.getAllNotes();
        for (Note item: notes) {
            if (item.getId().equals(idNum)){
                return;
            }
        }
    }
}
