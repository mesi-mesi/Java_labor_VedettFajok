package org.example.demo.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)     // 404-es válasz, ha nincs ilyen ID-jű faj
class AllatNotFoundException extends RuntimeException {
    AllatNotFoundException(int id) {
        super("A faj nem található: " + id);
    }
}
