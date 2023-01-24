package views;

import Loggers.LogRepository;
import Loggers.Logable;
import Loggers.Logger;
import controllers.NotesController;
import models.*;




public class Main {

    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationMain("Notes.txt");
        Repository repository = new LogRepository(new RepositoryFile(fileOperation), new Logger());
        NotesController controller = new NotesController(repository);
        NotesViewer view = new NotesViewer(controller);
        view.run();
    }
}