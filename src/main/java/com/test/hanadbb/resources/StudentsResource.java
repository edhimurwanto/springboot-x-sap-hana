package com.test.hanadbb.resources;

import com.test.hanadbb.entities.Students;
import com.test.hanadbb.services.StudentsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentsResource {

//    @Inject
    @Autowired
    StudentsService studentsService;

    @GetMapping("/students")
    @Operation(summary = "Fetch all Students")
    @ApiResponses({
            @ApiResponse(responseCode="200", description="Success")
    })
    public List<Students> getAll(){
        return studentsService.getAll();
    }

    @PostMapping("/students")
    @Operation(summary = "Create Students")
    @ApiResponses({
            @ApiResponse(responseCode="200", description="Success")
    })
    public void create(@RequestBody Students students){
        studentsService.create(students);
    }

    @PutMapping("/students/{id}")
    @Operation(summary = "Update Students")
    @ApiResponses({
            @ApiResponse(responseCode="200", description="Success")
    })
    public void update(@PathVariable int id, @RequestBody Students students){

        Students studentsToUpdate = studentsService.findById(id);

        studentsToUpdate.setName(students.getName());
        studentsToUpdate.setEmail(students.getEmail());

        studentsService.update(studentsToUpdate);

    }

    @DeleteMapping("/students/{id}")
    @Operation(summary = "Delete Students")
    @ApiResponses({
            @ApiResponse(responseCode="200", description="Success")
    })
    public void delete(@PathVariable int id){
        Students students = studentsService.findById(id);

        studentsService.delete(students);

    }

}
