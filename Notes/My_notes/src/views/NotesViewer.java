package views;

import controllers.NotesController;
import models.Note;

import java.util.List;
import java.util.Scanner;

public class NotesViewer {

    private NotesController notescontroller;

    public NotesViewer(NotesController controller) {
        this.notescontroller = controller;
    }


    public void run() {
        System.out.println("Hello. I welcome you to my notes application");
        try {
            while (true) {
                int command = number("Please enter that do you want to do. \n" +
                        "enter 1: to add a new note,\nenter 2: to read one one,\n" +
                        "enter 3: to read all notes that you have,\nenter 4: to update an existing note,\n" +
                        "enter 5: to delete an existing note,\nenter 6: to exit the application\n");

                if (command == 6) {
                    System.out.println("Thank you that you use my little application. Bye - Bye");
                    break;
                }


                if (command == 1) {
                    String header = prompt("Header: ");
                    String content = prompt("Content: ");
                    String additional = prompt("Additional: ");
                    notescontroller.saveNote(new Note(header, content, additional));
                }
                if (command == 2) {
                    String id = prompt("Enter the ID: ");
                    Note note = notescontroller.readNote(id);
                    System.out.println(note);
                }
                if (command == 3) {
                    List<Note> lst = notescontroller.readNotes();
                    lst.forEach(i -> System.out.println(i + "\n"));
                }
                if (command == 4) {
                    List<Note> updateLst = notescontroller.readNotes();
                    updateLst.forEach(i -> System.out.println(i + "\n"));
                    String numID = prompt("Which contact do you want to update? Enter the ID" +
                            " of contact which you want to update: ");
                    notescontroller.presenceId(numID);
                    notescontroller.updateNote(numID, updateUs());
                }
                if (command == 2) {
                    List<Note> delUs = notescontroller.readNotes();
                    delUs.forEach(i -> System.out.println(i + "\n"));
                    String numDelID = prompt("Which contact do you want to delete? Enter the ID" +
                            " of contact which you want to delete: ");
                    notescontroller.deleteUser(numDelID);
                }
                if (command > 6 || command < 1) {
                    System.out.println("You entered incorrect number, try again");
                    continue;
                }
            }
        } catch (Exception e) {
            System.out.println("AAAAA It's a trap " + e.getMessage());
        }
    }


    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private int number(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextInt();
    }

    private Note updateUs() {
        String header = prompt("Header: ");
        String content = prompt("Content: ");
        String additional = prompt("Additional: ");
        Note newNote = new Note(header, content, additional);
        return newNote;
    }

}


//public class NotesViewer {
//
//private NotesController notescontroller;
//
//    public NotesViewer(NotesController controller) {this.notescontroller = controller;}
//
//    public void run() {
//        System.out.println("Hello. I welcome you to my notes application");
//        Commands com = Commands.NONE;
//        while (true) {
//            String command = prompt("Please enter that do you want to do. \n" +
//                    "1: enter CREATE to add a new note,\n2: enter READONE to read one one,\n" +
//                    "3: enter READALL to read all notes that you have,\n4: enter UPDATE to update an existing note,\n" +
//                    "5: enter DELETE to delete an existing note,\n6: enter EXIT to exit the application\n");
//            com = Commands.valueOf(command.toUpperCase());
//            if (com == Commands.EXIT){
//                System.out.println("Thank you that you use my little application. Bye - Bye");
//                return;
//            }
//            try {
//                switch (com) {
//                    case CREATE:
//                        String header = prompt("Header: ");
//                        String content = prompt("Content: ");
//                        String additional = prompt("Additional: ");
//                        notescontroller.saveNote(new Note(header, content, additional));
//                        break;
//                    case READONE:
//                        String id = prompt("Enter the ID: ");
//                        Note note = notescontroller.readNote(id);
//                        System.out.println(note);
//                        break;
//                    case READALL:
//                        List<Note> lst = notescontroller.readNotes();
//                        lst.forEach(i -> System.out.println(i + "\n"));
//                        break;
//                    case UPDATE:
//                        List<Note> updateLst = notescontroller.readNotes();
//                        updateLst.forEach(i -> System.out.println(i + "\n"));
//                        String numID = prompt("Which contact do you want to update? Enter the ID" +
//                                " of contact which you want to update: ");
//                        notescontroller.presenceId(numID);
//                        notescontroller.updateNote(numID, updateUs());
//                        break;
//                    case DELETE:
//                        List<Note> delUs = notescontroller.readNotes();
//                        delUs.forEach(i -> System.out.println(i + "\n"));
//                        String numDelID = prompt("Which contact do you want to delete? Enter the ID" +
//                                " of contact which you want to delete: ");
//                        notescontroller.deleteUser(numDelID);
//                        break;
//                }
//            } catch (Exception e) {
//                System.out.println("AAAAA It's a trap " + e.getMessage());
//            }
//        }
//    }
//
//    private String prompt(String message) {
//        Scanner in = new Scanner(System.in);
//        System.out.print(message);
//        return in.nextLine();
//    }
//
//    private Note updateUs() {
//        String header = prompt("Header: ");
//        String content = prompt("Content: ");
//        String additional = prompt("Additional: ");
//        Note newNote = new Note(header, content, additional);
//        return newNote;
//    }
//
//}
