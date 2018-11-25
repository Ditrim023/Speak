package com.chat.speak.repository;

import com.chat.speak.model.Phrase;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Nikita Krutoguz
 */
public interface PhraseRepository extends JpaRepository<Phrase, Long>{
}
