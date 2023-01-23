package models;

public class UserMapper {
    public String map(Note note) {
        return String.format("%s;%s;%s;%s;%s", note.getId(),
                note.getHeader(), note.getContent(), note.getAdditional(), note.getDateTime());
    }

    public Note map(String line) {
        String[] lines = line.split(";");
        return new Note(lines[0], lines[1], lines[2], lines[3],lines[4]);
    }


}
