package ua.goit.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getListAll() {
        return noteRepository.findAll();
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(long id) {
        if (!noteRepository.existsById(id)) {
            throw new NoSuchElementException("Note with id " + id + " not found");
        }
        noteRepository.deleteById(id);
    }

    public void update(Note note) {
        if (!noteRepository.existsById(note.getId())) {
            throw new NoSuchElementException("Note with id " + note.getId() + " not found");
        }
        noteRepository.save(note);
    }

    public Note getById(long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Note with id " + id + " not found"));
    }

    // Новый метод для получения последнего ID
    public Long getLastId() {
        return noteRepository.findTopByOrderByIdDesc()
                .map(Note::getId)
                .orElseThrow(() -> new NoSuchElementException("No notes found in the database"));
    }
}




