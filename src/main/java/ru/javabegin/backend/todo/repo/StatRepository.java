package ru.javabegin.backend.todo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.javabegin.backend.todo.entity.Stat;

@Repository
public interface StatRepository extends CrudRepository<Stat, Long> {

    Stat findByUserDataEmail(String email); // всегда получаем только 1 объект, т.к. 1 пользователь содержит только 1 строку статистики (связь "один к одному")
}
