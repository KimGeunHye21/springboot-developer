package me.kimgeunhye.springbootdeveloper.repository;

import me.kimgeunhye.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
