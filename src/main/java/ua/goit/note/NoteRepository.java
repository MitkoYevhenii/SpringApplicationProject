package ua.goit.note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    // Метод для поиска последней записи по ID
    Optional<Note> findTopByOrderByIdDesc();
}

