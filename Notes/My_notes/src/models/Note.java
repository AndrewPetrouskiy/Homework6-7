package models;

import java.time.LocalDateTime;

public class Note {
    private String id = "";
    private String header;
    private String content;
    private String additional;
    private String time;


    public Note(String header, String content, String additional) {
        this.header = header;
        this.content = content;
        this.additional = additional;

    }


    public Note(String id,String header, String content, String additional,String time) {
        this(header, content, additional);
        this.id = id;
        this.time = time;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getDateTime() {
        LocalDateTime time = LocalDateTime.now();
        return time.toString();
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Header: %s, Content: %s, Additional: %s, Time: %s%n"
                , id, header, content,additional, time);
    }


}
