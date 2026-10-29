package com.zhunisov.studentapi;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/info")
    public Map<String, String> info() {
        return Map.of(
            "application", "zhunisov-gabit-student-api",
            "student", "Zhunisov Gabit",
            "version", "1.0"
        );
    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@Valid @RequestBody Student student) {
        return repository.save(student);
    }

    @GetMapping("/students")
    public List<Student> getAll() {
        return repository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getOne(@PathVariable("id") Long id) {
        return findStudent(id);
    }

    @PutMapping("/students/{id}")
    public Student update(
            @PathVariable("id") Long id,
            @Valid @RequestBody Student updated) {

        Student student = findStudent(id);
        student.setName(updated.getName());
        student.setEmail(updated.getEmail());
        student.setAge(updated.getAge());

        return repository.save(student);
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        Student student = findStudent(id);
        repository.delete(student);
    }

    private Student findStudent(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Student not found"
            ));
    }
}
