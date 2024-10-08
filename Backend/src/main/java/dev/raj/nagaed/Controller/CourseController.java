package dev.raj.nagaed.Controller;

import dev.raj.nagaed.Dtos.CourseDto;
import dev.raj.nagaed.Models.CourseModels;
import dev.raj.nagaed.Services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseServices courseServices;

    @GetMapping("/courses")
    public List<CourseModels> getCourses(){
        List<CourseModels> allCourses= courseServices.getCourses();
        return allCourses;
    }

    @PostMapping("/addcourse")
    public String addCourse(@RequestBody CourseDto courseDto){


        courseServices.addCourse(courseDto);
        return "addCourse";
    }

    @DeleteMapping("/deletecourse/{id}")
    public String deleteCourse(@PathVariable("id") Long id){
        courseServices.deleteCourse(id);
        return "deleteCourse";
    }
    @PutMapping("/updatecourse")
    public String updateCourse(@RequestBody CourseDto courseDto){
        courseServices.updateCourse(courseDto);
        return "updateCourse";
    }

}

