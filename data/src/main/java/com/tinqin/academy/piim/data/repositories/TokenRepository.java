package com.tinqin.academy.piim.data.repositories;

import com.tinqin.academy.piim.data.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {

    @Query(
            value =
                    """
      select t from Token t inner join User u\s
      on t.user.id = u.id\s
      where u.email like :email and (t.expired = false or t.revoked = false)\s
      """)
    List<Token> findAllValidTokenByUser(String email);

    Optional<Token> findByToken(String token);

    boolean existsByToken(String token);
}
