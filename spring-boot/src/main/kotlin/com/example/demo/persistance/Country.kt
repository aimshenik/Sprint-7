package com.example.demo.persistance

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "COUNTRIES")
data class Country(
    @Id
    @GeneratedValue
    @Column(nullable = false)
    val id: Long,

    @Column
    val name: String?
)