package com.example.demo.service;

import com.example.demo.entity.TextEntity;
import com.example.demo.repository.TextRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TextService {
    private TextRepository textRepository;

    public TextService(TextRepository textRepository) {
        System.out.println("TextService 의 생성자 호출");

        this.textRepository = textRepository;
    }

    public List<TextEntity> list() {
        return textRepository.findAll();
    }

    public TextEntity get(int id) {

        Optional<TextEntity> result = textRepository.findById(id);
        TextEntity textEntity = null;
        if(result.isPresent()) {
            textEntity = result.get();
            System.out.println(textEntity.getText());
        }

        return textEntity;
    }

    public void write() {
        TextEntity textEntity = TextEntity.builder()
                .text("texttest")
                .build();

        textRepository.save(textEntity);
    }

    public void edit(int id) {
        Optional<TextEntity> result = textRepository.findById(id);

        if(result.isPresent()) {
            TextEntity textEntity = result.get();
            textEntity.setText("textchange");
            textRepository.save(textEntity);
        }
    }

    public void delete(int id) {
        textRepository.deleteById(id);
    }

}
