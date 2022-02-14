package com.example.authserver.Repos;

import com.example.authserver.Models.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AccountRespository extends MongoRepository<Account,String> {
    @Query(value = "{'email' : ?0 }",exists = true)
    boolean existsByEmail(String email);
    @Query(value = "{'email' : ?0 }")
    List<Account> findByEmail(String email);
    @Query(value="{'email' : $0}", delete = true)
     boolean deleteByEmail (String email);
}
