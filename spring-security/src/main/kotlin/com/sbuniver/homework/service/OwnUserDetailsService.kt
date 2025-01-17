package com.sbuniver.homework.service

import com.sbuniver.homework.repository.AuthorityReposirory
import com.sbuniver.homework.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class  OwnUserDetailsService : UserDetailsService{

    @Autowired
    lateinit var userRepo : UserRepository

    @Autowired
    lateinit var authorityReposirory : AuthorityReposirory

    override fun loadUserByUsername(username: String?): UserDetails {
        val count = userRepo.count()
        val user = userRepo.findByUsername(username).get()
        val authorities = authorityReposirory.findByUsername(username)
        return User
            .withUsername(user.username)
            .password(user.password)
            .authorities(*authorities.map { it.authority }.toTypedArray())
            .build()
    }
}