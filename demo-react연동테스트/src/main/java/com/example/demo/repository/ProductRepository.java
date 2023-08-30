package com.example.demo.repository;

import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    // 추가적인 메서드나 쿼리를 정의할 수 있음
    public Optional<ProductEntity> findById(int id);
}

