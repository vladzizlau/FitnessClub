package by.pvt.core.repository;

import by.pvt.core.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DbClientRepository extends JpaRepository<Client, Long> {
}
