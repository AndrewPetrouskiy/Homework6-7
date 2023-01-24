package models;

import java.util.ArrayList;
import java.util.List;

public class RepositoryFile implements Repository {
    private UserMapper mapper = new UserMapper();
    private FileOperation fileOperation;

    public RepositoryFile(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    @Override
    public List<Note> getAllNotes() {
        List<String> lines = fileOperation.readAllLines();
        List<Note> notes = new ArrayList<>();
        for (String line : lines) {
            notes.add(mapper.map(line));
        }
        return notes;
    }

    @Override
    public String CreateNote(Note note) {
        List<Note> notes = getAllNotes();
        int max = 0;
        for (Note item : notes) {
            int id = Integer.parseInt(item.getId());
            if (max < id){
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        note.setId(id);
        notes.add(note);
        saveNotes(notes);
        return id;
    }

    @Override
    public void updateNote(Note note) {
        List<Note> notes = getAllNotes();
        Note toIdheaders = notes.stream().filter(i -> i.getId().equals(note.getId())).findFirst().get();
        toIdheaders.setHeader(note.getHeader());
        toIdheaders.setContent(note.getContent());
        toIdheaders.setAdditional(note.getAdditional());
        toIdheaders.setTime(note.getDateTime());
        saveNotes(notes);
    }

    @Override
    public void deleteNote(String numID) {
        List<Note> notes = getAllNotes();
        for (Note dn : notes) {
            if (dn.getId().equals(numID)) {
                notes.remove(dn);
            }
        }
        saveNotes(notes);
    }

    private void saveNotes (List<Note> notes){
        List<String> lines = new ArrayList<>();
        for (Note item: notes) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
    }

}
