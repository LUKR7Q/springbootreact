package com.example.demo.controller;

import com.example.demo.entity.TextEntity;
import com.example.demo.repository.TextRepository;
import com.example.demo.service.TextService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/text")
public class TextController {

    private TextService textService;

    public TextController(TextService textService) {
        System.out.println("TextController 의 생성자 호출");
        this.textService = textService;
    }

    @GetMapping("/selectAll")
    public ResponseEntity<Object> GetTexts() {
        List<TextEntity> textEntityList = textService.list();

        for (TextEntity textEntity:textEntityList) {
            System.out.println(textEntity.getText());
        }

        return ResponseEntity.ok().body(textEntityList);
    }

    @GetMapping("/select")
    public ResponseEntity<Object> GetText(int id) {

        TextEntity textEntity = textService.get(id);

        return ResponseEntity.ok().body(textEntity);
    }


    @GetMapping("/insert")
    public ResponseEntity<Object> insertText() {
        textService.write();

        return ResponseEntity.ok().body("success");
    }

    @GetMapping("/update")
    public ResponseEntity<Object> updateText(int id) {
        textService.edit(id);

        return ResponseEntity.ok().body("success");
    }

    @GetMapping("/delete")
    public ResponseEntity<Object> deleteText(int id) {
        textService.delete(id);

        return ResponseEntity.ok().body("success");
    }

}
