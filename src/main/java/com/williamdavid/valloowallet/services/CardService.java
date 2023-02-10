package com.williamdavid.valloowallet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.williamdavid.valloowallet.repositories.CardRepository;
import com.williamdavid.valloowallet.entities.Card;
import com.williamdavid.valloowallet.exceptions.CardNotFoundException;
import org.modelmapper.*;

// Card Service
@Service
public class CardService {

  // Crete card repository instance
  @Autowired
  private CardRepository cardRepository;

  @Autowired
  private ModelMapper modelMapper;

  // Add a new card
  public Card create(Card card) {
    return cardRepository.save(card);
  }

  // List all cards
  public List<Card> listAll() {
    return cardRepository.findAll();
  }

  // Get card by id
  /**
   * @param id
   * @return
   */
  public Optional<Card> getById(Long id) {
    return cardRepository.findById(id);
  }

  // Remove a specific card by id
  /**
   * @param id
   */
  public void remove(Long id) {
    getById(id);
    cardRepository.deleteById(id);
  }

  // Update a specific card by id
  public Card update(Long id, Card card) {
    this.getById(id)
        .map(cardBase -> {
          modelMapper.map(card, cardBase);
          return card;
        }).orElseThrow(() -> new CardNotFoundException("Cartão não encontrado"));
    return card;
  }
}
