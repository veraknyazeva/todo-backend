package ru.javabegin.backend.todo.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.javabegin.backend.todo.entity.Priority;
import ru.javabegin.backend.todo.repo.PriorityRepository;

import java.util.List;

@Service
@Transactional
public class PriorityService {

    private final PriorityRepository repository; // сервис имеет право обращаться к репозиторию (БД)

    public PriorityService(PriorityRepository repository) {
        this.repository = repository;
    }

    public List<Priority> findAll(String email) {
        return repository.findByUserDataEmailOrderByIdAsc(email);
    }

    public Priority add(Priority priority) {
        return repository.save(priority); // метод save обновляет или создает новый объект, если его не было
    }

    public Priority update(Priority priority) {
        return repository.save(priority);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Priority findById(Long id) {
        return repository.findById(id).get(); // т.к. возвращается Optional - можно получить объект методом get()
    }

    public List<Priority> find(String title, String email) {
        return repository.findByTitle(title, email);
    }
}
