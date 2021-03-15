package com.dsw.formoneplaceallocator.services.iface;

import com.dsw.formoneplaceallocator.dtos.ResponseDTO;
import com.dsw.formoneplaceallocator.dtos.StudentDTO;
import com.dsw.formoneplaceallocator.models.Student;
import com.dsw.formoneplaceallocator.models.StudentNotification;

import java.util.List;

public interface StudentService {
    ResponseDTO register(StudentDTO dto);

    List<Student> getAll();

    List<Student> getAllBySchoolId(String schoolId);

    List<StudentNotification> getStudentNotificationsByStudentId(String studentId);

    ResponseDTO readNotification(String studentId);

    ResponseDTO suspend(String studentId);
}
