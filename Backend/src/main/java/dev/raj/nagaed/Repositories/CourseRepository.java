package dev.raj.nagaed.Repositories;

import dev.raj.nagaed.Models.CourseModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseModels, Long>{

    CourseModels save(CourseModels courseModels);
    List<CourseModels> findAll();
    void deleteById(Long id);
    CourseModels findByCourseName(String courseName);

}
