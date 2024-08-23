package ru.javabegin.backend.todo.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.javabegin.backend.todo.entity.Category;
import ru.javabegin.backend.todo.repo.CategoryRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class CategoryService {
    // работает встроенный механизм DI из Spring, который при старте приложения подставит в эту переменную нужные класс-реализацию
    private final CategoryRepository repository; // сервис имеет право обращаться к репозиторию (БД)

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll(String email) {
        return repository.findByUserDataEmailOrderByTitleAsc(email);
    }

    public Category add(Category category) {
        return repository.save(category); // метод save обновляет или создает новый объект, если его не было
    }

    public Category update(Category category) {
        return repository.save(category); // метод save обновляет или создает новый объект, если его не было
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    // поиск категорий пользователя по названию
    public List<Category> findByTitle(String text, String email) {
        return repository.findByTitle(text, email);
    }

    public Category findById(Long id) {
        return repository.findById(id).get();
    }
}