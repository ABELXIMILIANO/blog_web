package com.example.web_proyect.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "publicaciones",uniqueConstraints = {@UniqueConstraint(columnNames = {"titulo"}) }) // Con la notacion @UniqueConstraint le estoy diciendo a la columna titulo que ningun titulo se debe de repetir.
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "titulo",nullable=false)
    private String titulo;
    @Column(name = "desripcion",nullable=false)
    private String description;
    @Column(name = "contenido",nullable=false)
    private String contenido;





}
