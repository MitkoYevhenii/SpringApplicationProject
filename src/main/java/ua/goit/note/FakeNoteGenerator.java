package ua.goit.note;

import net.datafaker.Faker;
import org.springframework.stereotype.Component;

@Component
public class FakeNoteGenerator {

    private final Faker faker = new Faker();

    public Note generateFakeNote() {
        Note note = new Note();
        note.setTitle(faker.lorem().sentence(5)); // Случайный заголовок из 5 слов
        note.setContent(faker.lorem().paragraph(3)); // Случайный контент из 3 абзацев
        return note;
    }
}

