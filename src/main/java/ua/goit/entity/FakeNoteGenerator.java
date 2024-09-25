package ua.goit.entity;

import net.datafaker.Faker;

public class FakeNoteGenerator {

    public Note fakeNote(long id) {
        Faker faker = new Faker();
        Note note = new Note();

        // Встановлюємо ID
        note.setId(id);

        // Генеруємо випадковий заголовок (наприклад, з 5 слів)
        note.setTitle(faker.lorem().sentence(5));

        // Генеруємо випадковий контент (наприклад, з 3 абзаців)
        note.setContent(faker.lorem().paragraph(3));

        return note;
    }
}
