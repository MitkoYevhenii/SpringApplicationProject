package ua.goit.note;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Note {
    private long id;
    private String title;
    private String content;
}
