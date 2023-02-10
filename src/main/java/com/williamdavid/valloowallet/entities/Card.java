package com.williamdavid.valloowallet.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

// Create Card entity
public class Card {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "nomeUsuario", nullable = false)
  private String nomeUsuario;

  @Column(name = "numero", nullable = false)
  private String numero;

  @Column(name = "codigoSeguranca", nullable = false)
  private String codigoSeguranca;

  @Column(name = "dataValidade", nullable = false)
  private String dataValidade;
}