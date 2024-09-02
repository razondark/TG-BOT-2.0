package org.razondark.crudmicroservice.model

import jakarta.persistence.*
import org.jetbrains.annotations.NotNull

@Entity
@Table(name = "base_command")
data class BaseCommand(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,

    @Column(name = "command", unique = true)
    @NotNull
    var command: String,

    @Column(name = "message")
    @NotNull
    var message: String
)
