package com.williamdavid.valloowallet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.williamdavid.valloowallet.entities.Card;
import com.williamdavid.valloowallet.services.CardService;

@RestController
@RequestMapping("/wallet")
public class CardController {

  @Autowired
  private CardService cardService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Card add(@RequestBody Card card) {
    System.out.print(card);
    try {
      return cardService.create(card);
    } catch (Exception error) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao adicionar cartão.", error);
    }
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Card> cardList() {
    try {
      return cardService.listAll();
    } catch (Exception error) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao carregar lista de cartões.", error);
    }
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Optional<Card> getCardById(@PathVariable("id") Long id) {
    try {
      return cardService.getById(id);
    } catch (Exception error) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro na requisição", error);
    }
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCard(@PathVariable("id") Long id) {
    try {
      cardService.remove(id);
    } catch (Exception error) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro na requisição", error);
    }
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateCard(@PathVariable("id") Long id, @RequestBody Card card) {
    try {
      cardService.update(id, card);
    } catch (Exception error) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro na requisição", error);
    }
  }
}
