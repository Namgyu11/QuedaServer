package com.whoasys.quedaserver.post

import com.whoasys.quedaserver.user.User
import jakarta.persistence.*

@Entity
class Post (
    var title: String,
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    var author: User,
    var content: String,
    var isPromo: Boolean,
    var promoStart: String?,
    var promoEnd: String?,
    var attached0: String? = null,
    var attached1: String? = null,
    var attached2: String? = null,
    @Id @GeneratedValue var id: Int? = null,
    var addedMillis: Long = System.currentTimeMillis()
)