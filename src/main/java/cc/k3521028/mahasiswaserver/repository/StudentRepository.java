package cc.k3521028.mahasiswaserver.repository;

import cc.k3521028.mahasiswaserver.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
