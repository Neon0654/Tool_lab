package com.example.ThanhHoai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.ThanhHoai.entity.SystemLog;
import com.example.ThanhHoai.repository.SystemLogRepository;

import java.util.List;

@RestController
@RequestMapping("/api/connection")
public class TestController {

    @Autowired
    SystemLogRepository repo;

    @GetMapping("/read-all")
    public List<SystemLog> readAll() {
        return repo.findAll();
    }

    @PostMapping("/write")
    public SystemLog write(@RequestParam String message) {
        SystemLog log = new SystemLog();
        log.setAction("CREATE");
        log.setDetails(message);
        log.setIpAddress("127.0.0.1");
        log.setUserAgent("TestTool");
        log.setTimestamp(java.time.LocalDateTime.now().toString());
        return repo.save(log);
    }

    @PutMapping("/update/{id}")
    public SystemLog update(@PathVariable Long id, @RequestParam String newMessage) {
        SystemLog log = repo.findById(id).orElseThrow();
        log.setAction("UPDATE");
        log.setDetails(newMessage);
        return repo.save(log);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
