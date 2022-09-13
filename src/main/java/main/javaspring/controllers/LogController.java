package main.javaspring.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import main.javaspring.exceptions.ModelNotFoundException;
import main.javaspring.models.Log;
import main.javaspring.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LogController {
    private final LogRepository logRepository;

    @Autowired
    public LogController(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @GetMapping("/logs")
    @JsonFormat
    public List<Log> index() {
        return this.logRepository.findAll();
    }

    @PostMapping("/logs")
    @JsonFormat
    public Log store(@RequestBody Log log) {
        return this.logRepository.save(log);
    }

    @GetMapping("/logs/{id}")
    @JsonFormat
    public Log show(@PathVariable Long id) throws ModelNotFoundException {
        return this.logRepository.findById(id)
                .orElseThrow((() -> new ModelNotFoundException("Log not found! ID: ", id)));
    }

    @PutMapping("/logs/{id}")
    @JsonFormat
    public Log update(@RequestBody Log newLog, @PathVariable Long id) {
        return this.logRepository.findById(id).map(log -> {
            log.setLevel(newLog.getLevel());
            log.setMessage(newLog.getMessage());
            log.setContext(newLog.getContext());
            return this.logRepository.save(log);
        }).orElseGet(() -> {
            newLog.setId(id);
            return this.logRepository.save(newLog);
        });
    }

    @DeleteMapping("/logs/{id}")
    @JsonFormat
    public void destroy(@PathVariable Long id) throws ModelNotFoundException {
        this.logRepository.findById(id).orElseThrow(() -> new ModelNotFoundException("Log not found! ID: ", id));
        this.logRepository.deleteById(id);
    }
}
