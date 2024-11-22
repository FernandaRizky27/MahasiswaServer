package cc.k3521028.mahasiswaserver.controller;


import cc.k3521028.mahasiswaserver.dto.OutputDto;
import cc.k3521028.mahasiswaserver.dto.StudentDto;
import cc.k3521028.mahasiswaserver.dto.StudentRegisterDto;
import cc.k3521028.mahasiswaserver.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    public StudentService studentService;

    @PostMapping("/registration")
    public ResponseEntity<OutputDto<StudentDto>> registration(@RequestBody StudentRegisterDto studentRegisterDto) {
        StudentDto studentDto = studentService.regiserNewStudent(studentRegisterDto);
        OutputDto<StudentDto> outputDto = new OutputDto<>();
        outputDto.setData(studentDto);
        outputDto.setMessage("Registration Successful");
        return ResponseEntity.ok(outputDto);
    }

    @GetMapping("/show-all")
    public ResponseEntity<OutputDto<List<StudentDto>>> showAllStudents() {
        List<StudentDto> studentDtoList = studentService.getAllStudents();
        OutputDto<List<StudentDto>> outputDto = new OutputDto<>();
        outputDto.setMessage("All Students Found");
        outputDto.setData(studentDtoList);
        return ResponseEntity.ok(outputDto);


    }
}
