package ru.javabegin.backend.todo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.javabegin.backend.todo.entity.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByUserDataEmailOrderByTitleAsc(String email);

    // поиск значений по названию для конкретного пользователя
    @Query("SELECT c FROM Category c where " +
            "(:title is null or :title='' " + // если передадим параметр title пустым, то выберутся все записи (сработает именно это условие)
            " or lower(c.title) like lower(concat('%', :title,'%'))) " + // если параметр title не пустой, то выполнится уже это условие
            " and c.userData.email=:email  " + // фильтрация для конкретного пользователя
            " order by c.title asc") // сортировка по названию
    List<Category> findByTitle(@Param("title") String title, @Param("email") String email);
}
