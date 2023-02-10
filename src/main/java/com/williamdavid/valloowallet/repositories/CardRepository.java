package com.williamdavid.valloowallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.williamdavid.valloowallet.entities.Card;

//Start Card's repository
public interface CardRepository extends JpaRepository<Card, Long> {

}
