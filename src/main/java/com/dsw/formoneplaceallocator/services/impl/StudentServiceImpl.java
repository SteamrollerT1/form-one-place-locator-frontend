package com.dsw.formoneplaceallocator.services.impl;

import com.dsw.formoneplaceallocator.dtos.ResponseDTO;
import com.dsw.formoneplaceallocator.dtos.StudentDTO;
import com.dsw.formoneplaceallocator.models.Student;
import com.dsw.formoneplaceallocator.models.StudentNotification;
import com.dsw.formoneplaceallocator.services.iface.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${back.url}")
    private String backURL;

    @Override
    public ResponseDTO register(StudentDTO dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<StudentDTO> request = new HttpEntity<>(dto, headers);

        ResponseEntity<ResponseDTO> response = restTemplate.exchange(backURL + "/student/register",
                HttpMethod.POST, request, ResponseDTO.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }

        return null;
    }

    @Override
    public List<Student> getAll() {
        ResponseEntity<List<Student>> response = restTemplate.exchange(backURL + "/student/getAll",
                HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<Student>>() {
                });

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }

        return null;
    }

    @Override
    public List<Student> getAllBySchoolId(String schoolId) {

        ResponseEntity<List<Student>> response = restTemplate.exchange(backURL + "/student/getAllBySchoolId/" + schoolId,
                HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<Student>>() {
                });

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }

        return null;
    }

    @Override
    public List<StudentNotification> getStudentNotificationsByStudentId(String studentId) {
        ResponseEntity<List<StudentNotification>> response = restTemplate.exchange(backURL + "/student/getStudentNotificationsByStudentId/" + studentId,
                HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<StudentNotification>>() {
                });

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }

        return null;
    }

    @Override
    public ResponseDTO readNotification(String notificationId) {
        ResponseEntity<ResponseDTO> response = restTemplate.exchange(backURL + "/student/readNotification/" + notificationId,
                HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<ResponseDTO>() {
                });

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }
        return null;
    }

    @Override
    public ResponseDTO suspend(String studentId) {
        ResponseEntity<ResponseDTO> response = restTemplate.exchange(backURL + "/student/suspend/" + studentId,
                HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<ResponseDTO>() {
                });

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }
        return null;
    }
}
