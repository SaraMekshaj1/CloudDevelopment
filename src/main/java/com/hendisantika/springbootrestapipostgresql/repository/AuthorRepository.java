package com.hendisantika.springbootrestapipostgresql.repository;
import java.util.List;

import com.hendisantika.springbootrestapipostgresql.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByName(String name);
}
