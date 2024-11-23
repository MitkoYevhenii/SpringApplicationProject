package ua.goit.springapplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.goit.note.FakeNoteGenerator;
import ua.goit.note.Note;
import ua.goit.note.NoteRepository;
import ua.goit.note.NoteService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class NoteServiceTest {

    @Autowired
    private NoteService noteService;

    @Autowired
    private FakeNoteGenerator fakeNoteGenerator;

    @Autowired
    private NoteRepository noteRepository;

    @BeforeEach
    void setUp() {
        noteRepository.deleteAll(); // Очищаем базу данных перед каждым тестом
    }

    @Test
    void testAddNote() {
        Note fakeNote = fakeNoteGenerator.generateFakeNote();
        Note savedNote = noteService.add(fakeNote);

        assertNotNull(savedNote.getId());
        assertEquals(fakeNote.getTitle(), savedNote.getTitle());
        assertEquals(fakeNote.getContent(), savedNote.getContent());
    }

    @Test
    void testGetAllNotes() {
        Note note1 = noteService.add(fakeNoteGenerator.generateFakeNote());
        Note note2 = noteService.add(fakeNoteGenerator.generateFakeNote());

        List<Note> notes = noteService.getListAll();

        assertEquals(2, notes.size());
        assertTrue(notes.contains(note1));
        assertTrue(notes.contains(note2));
    }

    @Test
    void testGetNoteById() {
        Note fakeNote = noteService.add(fakeNoteGenerator.generateFakeNote());
        Note fetchedNote = noteService.getById(fakeNote.getId());

        assertEquals(fakeNote.getId(), fetchedNote.getId());
        assertEquals(fakeNote.getTitle(), fetchedNote.getTitle());
        assertEquals(fakeNote.getContent(), fetchedNote.getContent());
    }

    @Test
    void testUpdateNote() {
        Note fakeNote = noteService.add(fakeNoteGenerator.generateFakeNote());
        fakeNote.setTitle("Updated Title");
        fakeNote.setContent("Updated Content");

        noteService.update(fakeNote);
        Note updatedNote = noteService.getById(fakeNote.getId());

        assertEquals("Updated Title", updatedNote.getTitle());
        assertEquals("Updated Content", updatedNote.getContent());
    }

    @Test
    void testDeleteNote() {
        Note fakeNote = noteService.add(fakeNoteGenerator.generateFakeNote());
        long id = fakeNote.getId();

        noteService.deleteById(id);

        assertThrows(Exception.class, () -> noteService.getById(id));
    }

    @Test
    void testGetLastId() {
        Note note1 = noteService.add(fakeNoteGenerator.generateFakeNote());
        Note note2 = noteService.add(fakeNoteGenerator.generateFakeNote());

        Long lastId = noteService.getLastId();

        assertEquals(note2.getId(), lastId);
    }
}

