package com.chat.speak.repository;

import com.chat.speak.model.Phrase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nikita Krutoguz
 */
@Repository
public interface PhraseRepository extends JpaRepository<Phrase,Long> {
}
