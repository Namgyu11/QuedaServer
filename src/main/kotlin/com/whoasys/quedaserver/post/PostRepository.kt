package com.whoasys.quedaserver.post

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional

@Transactional
interface PostRepository : CrudRepository<Post, Int> {

    fun findAllByAuthorIdOrderByAddedMillisDesc(author: String): List<Post>?

    fun findAllByOrderByAddedMillisDesc(): List<Post>?

    fun findPostById(id: Int): Post?

    fun findAllByIdIn(ids: List<Int>?): List<Post>?

    @Modifying
    @Query(value = "update post set attached:num=:key where id=:id", nativeQuery = true)
    fun attach(num: Int, id: Int, key: String)

    @Modifying
    @Query(value = "update Post p set p.title = :title, p.content = :content, p.isPromo = :isPromo, p.promoStart = :promoStart, p.promoEnd = :promoEnd, p.attached0 = :attached0, p.attached1 = :attached1, p.attached2 = :attached2 where p.id = :id")
    fun updatePost(
        id: Int,
        title: String,
        content: String,
        isPromo: Boolean,
        promoStart: String?,
        promoEnd: String?,
        attached0: String?,
        attached1: String?,
        attached2: String?
    )

}