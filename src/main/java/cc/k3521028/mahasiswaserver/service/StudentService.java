package cc.k3521028.mahasiswaserver.service;

import cc.k3521028.mahasiswaserver.dto.StudentDto;
import cc.k3521028.mahasiswaserver.dto.StudentRegisterDto;
import cc.k3521028.mahasiswaserver.entity.StudentEntity;
import cc.k3521028.mahasiswaserver.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentDto regiserNewStudent(StudentRegisterDto studentRegisterDto) {
       StudentEntity newStudentEntity = new StudentEntity();
       newStudentEntity.setNama(studentRegisterDto.getNama());
       newStudentEntity.setNim(studentRegisterDto.getNim());
       newStudentEntity.setAlamat(studentRegisterDto.getAlamat());
       newStudentEntity.setUsername(studentRegisterDto.getUsername());
       newStudentEntity.setEmail(studentRegisterDto.getEmail());
       newStudentEntity.setPassword(studentRegisterDto.getPassword());
       StudentEntity registeredStudent = studentRepository.save(newStudentEntity);
       StudentDto studentDto = new StudentDto();
       studentDto.setNama(registeredStudent.getNama());
       studentDto.setNim(registeredStudent.getNim());
       studentDto.setAlamat(registeredStudent.getAlamat());
       studentDto.setUsername(registeredStudent.getUsername());
       studentDto.setEmail(registeredStudent.getEmail());
       return studentDto;
    }

    public List<StudentDto> getAllStudents() {
        List<StudentEntity> studentEntities = studentRepository.findAll();
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (int i = 0; i < studentEntities.size(); i++) {
            StudentDto studentDto = new StudentDto();
            StudentEntity studentEntity = studentEntities.get(i);
            studentDto.setNama(studentEntity.getNama());
            studentDto.setNim(studentEntity.getNim());
            studentDto.setAlamat(studentEntity.getAlamat());
            studentDto.setUsername(studentEntity.getUsername());
            studentDto.setEmail(studentEntity.getEmail());
            studentDtoList.add(studentDto);
        }
        return studentDtoList;
    }

    public StudentDto getStudent(Long id) {
        StudentDto studentDto = new StudentDto();
        Optional<StudentEntity>studentCheck = studentRepository.findById(id);
        if (studentCheck.isPresent()) {
            StudentEntity studentEntity = studentCheck.get();
            studentDto.setNama(studentEntity.getNama());
            studentDto.setNim(studentEntity.getNim());
            studentDto.setAlamat(studentEntity.getAlamat());
            studentDto.setUsername(studentEntity.getUsername());
            studentDto.setEmail(studentEntity.getEmail());
            return studentDto;
        } else {
            return null;
        }
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(id);
        studentEntity.setNama(studentDto.getNama());
        studentEntity.setNim(studentDto.getNim());
        studentEntity.setAlamat(studentDto.getAlamat());
        studentEntity.setUsername(studentDto.getUsername());
        studentEntity.setEmail(studentDto.getEmail());
        StudentEntity updatedStudentEntity = studentRepository.save(studentEntity);
        studentDto.setNama(updatedStudentEntity.getNama());
        studentDto.setNim(updatedStudentEntity.getNim());
        studentDto.setAlamat(updatedStudentEntity.getAlamat());
        studentDto.setUsername(updatedStudentEntity.getUsername());
        studentDto.setEmail(updatedStudentEntity.getEmail());
        return studentDto;
    }
}
