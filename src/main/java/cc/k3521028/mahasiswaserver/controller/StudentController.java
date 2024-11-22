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

    @GetMapping("/find/{id}")
    public ResponseEntity<OutputDto<StudentDto>> findStudentById(@PathVariable("id") Long id) {
        StudentDto studentDto = studentService.getStudent(id);
        OutputDto<StudentDto> outputDto = new OutputDto<>();
        outputDto.setData(studentDto);
        if (studentDto == null) {
            outputDto.setMessage("Student Not Found");
        } else {
            outputDto.setMessage("Student Found");
        }

        return ResponseEntity.ok(outputDto);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<OutputDto<StudentDto>> deleteStudentById(@PathVariable("id") Long id) {
        StudentDto studentDto = new StudentDto();
        OutputDto<StudentDto> outputDto = new OutputDto<>();
        try {
            studentService.deleteStudent(id);
            studentDto = studentService.getStudent(id);
            outputDto.setData(studentDto);
            outputDto.setMessage("Student Deleted");
            return ResponseEntity.ok(outputDto);
        }catch (Exception e) {
            outputDto.setData(studentDto);
            outputDto.setMessage("Student Not Found");
            return ResponseEntity.ok(outputDto);
        }

    }

    @PostMapping("/update/{id}")
    public ResponseEntity<OutputDto<StudentDto>> updateStudentById(@PathVariable("id") Long id, @RequestBody StudentDto studentDto) {
        StudentDto updateById = studentService.updateStudent(id, studentDto);
        OutputDto<StudentDto> outputDto = new OutputDto<>();
        outputDto.setData(updateById);
        outputDto.setMessage("Student Update Successful");
        return ResponseEntity.ok(outputDto);

    }

}
