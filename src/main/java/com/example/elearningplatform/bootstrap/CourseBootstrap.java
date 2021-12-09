package com.example.elearningplatform.bootstrap;

import com.example.elearningplatform.domain.Category;
import com.example.elearningplatform.domain.Course;
import com.example.elearningplatform.domain.Source;
import com.example.elearningplatform.domain.SourceType;
import com.example.elearningplatform.repositories.CategoryRepository;
import com.example.elearningplatform.repositories.CourseRepository;
import com.example.elearningplatform.repositories.SourceRepository;
import com.example.elearningplatform.repositories.SubcategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class CourseBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CourseRepository courseRepository;
    private final SourceRepository sourceRepository;
    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subcategoryRepository;

    public CourseBootstrap(CourseRepository courseRepository, SourceRepository sourceRepository, CategoryRepository categoryRepository, SubcategoryRepository subcategoryRepository) {
        this.courseRepository = courseRepository;
        this.sourceRepository = sourceRepository;
        this.categoryRepository = categoryRepository;
        this.subcategoryRepository = subcategoryRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        courseRepository.saveAll(getCourse());
        log.debug("Loading Bootstrap Data");
    }

    private List<Course> getCourse() {

        List<Course> courses = new ArrayList<>(2);

        //get sources
        Optional<Source> udemySourceOptional = sourceRepository.findBySource("Udemy");

        if (!udemySourceOptional.isPresent()) {
            throw new RuntimeException("Expected Source Not Found");
        }

        Optional<Source> pluralsightSourceOptional = sourceRepository.findBySource("Pluralsight");

        if (!pluralsightSourceOptional.isPresent()) {
            throw new RuntimeException("Expected Source Not Found");
        }

        Optional<Source> yakssSourceOptional = sourceRepository.findBySource("YAKSS");

        if (!yakssSourceOptional.isPresent()) {
            throw new RuntimeException("Expected Source Not Found");
        }

        Optional<Source> lightingtalksSourceOptional = sourceRepository.findBySource("lighting Talks");

        if (!lightingtalksSourceOptional.isPresent()) {
            throw new RuntimeException("Expected Source Not Found");
        }

        Source udemySource = udemySourceOptional.get();
        Source pluralsightSource = pluralsightSourceOptional.get();
        Source yakssSource = yakssSourceOptional.get();
        Source lightingtalksSource = lightingtalksSourceOptional.get();

        //get category
        Optional<Category> frontendCategoryOptional = categoryRepository.findByDescription("Frontend");

        if (!frontendCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional<Category> backendCategoryOptional = categoryRepository.findByDescription("Backend");

        if (!backendCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional<Category> ux_uiCategoryOptional = categoryRepository.findByDescription("UX/UI");

        if (!ux_uiCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional<Category> ml_blCategoryOptional = categoryRepository.findByDescription("ML/BI");

        if (!ml_blCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category Not Found");
        }
        Optional<Category> devopsCategoryOptional = categoryRepository.findByDescription("DevOps");

        if (!devopsCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category Not Found");
        }
        Optional<Category> qaCategoryOptional = categoryRepository.findByDescription("QA");

        if (!qaCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional<Category> non_tech_coursesCategoryOptional = categoryRepository.findByDescription("Non-tech courses");

        if (!non_tech_coursesCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category Not Found");
        }

        Category frontendCategory = frontendCategoryOptional.get();
        Category backendCategory = backendCategoryOptional.get();
        Category ux_uiCategory = ux_uiCategoryOptional.get();
        Category ml_blCategory = ml_blCategoryOptional.get();
        Category devopsCategory = devopsCategoryOptional.get();
        Category qaCategory = qaCategoryOptional.get();
        Category non_tech_coursesCategory = non_tech_coursesCategoryOptional.get();

        //first course
        Course javaCourse = new Course();
        javaCourse.setCourse("Java For Beginners");
        javaCourse.setDescription("Java is one of the most popular programming languages out there. Released in 1995 and still widely used today, Java has many applications, including software development, mobile applications, and large systems development. Knowing Java opens a lot of possibilities for you as a developer.");
        javaCourse.setLectures(526);
        javaCourse.setSkill_level("All levels");
        javaCourse.setTeacher("John Thompson");
        javaCourse.setTime(58);
        javaCourse.setSourceType(SourceType.EXTERNAL);
        javaCourse.getCategories().add(backendCategory);
        javaCourse.getSources().add(udemySource);
        courses.add(javaCourse);

        //second course
        Course angularCourse = new Course();
        angularCourse.setCourse("Angular For Beginners");
        angularCourse.setDescription("In this course, you will learn how simple it is to use Angular to create maintainable and testable single page applications. You will learn how to:Bootstrap your Angular application, Use AngularJS markup and expressions, Create and use controllers, Use built-in services and create custom services, Turn your application into a SPA using routing, Create your own custom elements and handle events using directives");
        angularCourse.setLectures(463);
        angularCourse.setSkill_level("All levels");
        angularCourse.setTeacher("Maximilian Schwarzmüller");
        angularCourse.setTime(34);
        angularCourse.setSourceType(SourceType.EXTERNAL);
        angularCourse.getCategories().add(frontendCategory);
        angularCourse.getSources().add(udemySource);
        courses.add(javaCourse);

        // don't forget to add other courses!
        return courses;
    }
}
