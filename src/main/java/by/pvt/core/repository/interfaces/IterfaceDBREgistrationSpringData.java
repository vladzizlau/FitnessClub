package by.pvt.core.repository.interfaces;

import by.pvt.core.domain.Registration;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IterfaceDBREgistrationSpringData extends JpaRepository<Registration, Long> {
    @Override
    <S extends Registration> List<S> findAll(Example<S> example);

    @Override
    <S extends Registration> S save(S entity);

    @Override
    void deleteById(Long aLong);
}
