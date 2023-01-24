package Loggers;

import models.Note;
import models.Repository;

import java.util.ArrayList;
import java.util.List;

public class LogRepository implements Repository {

    Repository rep;
    Logable logable;

    public LogRepository(Repository rep, Logable logable) {
        this.rep = rep;
        this.logable = logable;
    }

    @Override
    public List<Note> getAllNotes() {
        logable.showLog(String.format("Получаем все записки."));
        return rep.getAllNotes();
    }

    @Override
    public String CreateNote(Note note) {
        logable.showLog(String.format("Добавляем новую заметку %s", note));

        return rep.CreateNote(note);
    }

    @Override
    public void updateNote(Note note) {
        logable.showLog(String.format("Обновляем существующую заметку %s", note));
        rep.updateNote(note);
    }

    @Override
    public void deleteNote(String note) {
    logable.showLog(String.format("Удаляем существующую заметку %s", note));
    rep.deleteNote(note);
    }
}
