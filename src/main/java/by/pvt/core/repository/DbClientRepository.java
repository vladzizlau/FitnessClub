package by.pvt.core.repository;

import by.pvt.core.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DbClientRepository extends JpaRepository<Client, Long> {
    @Query(value = "select a from Client a where a.login = :clogin")
    Client getCleintByUser(@Param("clogin") String userlogin);
}
