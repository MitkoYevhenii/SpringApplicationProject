package ua.goit.springapplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ua.goit.entity.FakeNoteGenerator;
import ua.goit.entity.Note;
import ua.goit.entity.NoteService;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationTests {

    private NoteService noteService;
    private FakeNoteGenerator fakeNoteGenerator;

    @BeforeEach
    void beforeEach() {
        noteService = new NoteService();
        fakeNoteGenerator = new FakeNoteGenerator();
    }

    @Test
    void testAddNote() {
        Note note = new Note();
        note.setTitle("Test Title");
        note.setContent("Test Content");

        Note addedNote = noteService.add(note);
        assertNotNull(addedNote.getId());
        assertEquals("Test Title", addedNote.getTitle());
    }

    @Test
    void testDeleteNote() {
        Note note = new Note();
        note.setTitle("Title to delete");
        note.setContent("Content to delete");

        Note addedNote = noteService.add(note);
        long id = addedNote.getId();

        noteService.deleteById(id);
        assertThrows(NoSuchElementException.class, () -> noteService.getById(id));
    }
}

