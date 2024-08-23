package ru.javabegin.backend.todo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.javabegin.backend.todo.entity.Stat;
import ru.javabegin.backend.todo.service.StatService;


@RestController
// базовый URI не нужен, т.к. метод только один
public class StatController {

    private final StatService statService; // сервис для доступа к данным (напрямую к репозиториям не обращаемся)

    public StatController(StatService statService) {
        this.statService = statService;
    }


    // для статистика всегда получаем только одну строку с id=1 (согласно таблице БД)
    @PostMapping("/stat")
    public ResponseEntity<Stat> findByEmail(@RequestBody String email) {
        return ResponseEntity.ok(statService.findStat(email));
    }
}
