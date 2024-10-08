package dev.raj.nagaed.Services;

import dev.raj.nagaed.Dtos.CourseDto;
import dev.raj.nagaed.Models.CourseModels;
import dev.raj.nagaed.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServices {

          @Autowired
          CourseRepository courseRepository;
        public List<CourseModels> getCourses(){
           List<CourseModels> allcourses= courseRepository.findAll();

            return allcourses;
        }

        public String addCourse(CourseDto courseDto){
            CourseModels courseModels = new CourseModels();
            courseModels.setCourseName(courseDto.getCourseName());
            courseModels.setCourseDescription(courseDto.getCourseDescription());
            courseModels.setCoursePrice(courseDto.getCoursePrice());
            courseRepository.save(courseModels);

            return "addCourse";
        }

        public String deleteCourse(Long id){
            courseRepository.deleteById(id);
            return "deleteCourse";
        }
        public  String updateCourse(CourseDto courseDto){
           CourseModels course= courseRepository.findByCourseName(courseDto.getCourseName());

            course.setCourseName(courseDto.getCourseName());

            course.setCourseDescription(courseDto.getCourseDescription());
            course.setCoursePrice(courseDto.getCoursePrice());
            courseRepository.save(course);
            return "updateCourse";
        }
}
