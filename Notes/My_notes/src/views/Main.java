package views;

import controllers.NotesController;
import models.*;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationMain("Notes.txt");
        Repository repository = new RepositoryFile(fileOperation);
        NotesController controller = new NotesController(repository);
        NotesViewer view = new NotesViewer(controller);
        view.run();
    }
}