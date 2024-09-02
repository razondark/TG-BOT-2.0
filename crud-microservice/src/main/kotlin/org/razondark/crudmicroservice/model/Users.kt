package org.razondark.crudmicroservice.model

import jakarta.annotation.Nullable
import jakarta.persistence.*
import org.jetbrains.annotations.NotNull

@Entity
@Table(name = "users")
data class Users(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?,

    @Column(name = "user_id", unique = true)
    @NotNull
    var userId: Long?,

    @Column(name = "username", unique = true)
    @NotNull
    var username: String?,

    @Column(name = "is_admin")
    @Nullable
    var isAdmin: Boolean?
)
