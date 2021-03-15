package com.dsw.formoneplaceallocator.services.impl;

import com.dsw.formoneplaceallocator.dtos.AcceptStudentDTO;
import com.dsw.formoneplaceallocator.dtos.DeadlineDTO;
import com.dsw.formoneplaceallocator.dtos.ResponseDTO;
import com.dsw.formoneplaceallocator.dtos.SchoolDTO;
import com.dsw.formoneplaceallocator.models.School;
import com.dsw.formoneplaceallocator.services.iface.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${back.url}")
    private String backURL;


    @Override
    public ResponseDTO register(SchoolDTO dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SchoolDTO> request = new HttpEntity<>(dto, headers);

        ResponseEntity<ResponseDTO> response = restTemplate.exchange(backURL + "/school/register",
                HttpMethod.POST, request, ResponseDTO.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }

        return null;
    }

    @Override
    public List<School> getAll() {
        ResponseEntity<List<School>> response = restTemplate.exchange(backURL + "/school/getAll",
                HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<School>>() {
                });

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }

        return null;
    }

    @Override
    public School getById(String schoolId) {
        ResponseEntity<School> response = restTemplate.exchange(backURL + "/student/getById/" + schoolId,
                HttpMethod.GET, HttpEntity.EMPTY, School.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }

        return null;
    }

    @Override
    public ResponseDTO reject(String schoolId) {
        ResponseEntity<ResponseDTO> response = restTemplate.exchange(backURL + "/student/reject/" + schoolId,
                HttpMethod.GET, HttpEntity.EMPTY, ResponseDTO.class);

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

    @Override
    public ResponseDTO accept(AcceptStudentDTO dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AcceptStudentDTO> request = new HttpEntity<>(dto, headers);

        ResponseEntity<ResponseDTO> response = restTemplate.exchange(backURL + "/school/accept",
                HttpMethod.POST, request, ResponseDTO.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }

        return null;
    }

    @Override
    public ResponseDTO openRegistrationPeriod(DeadlineDTO dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<DeadlineDTO> request = new HttpEntity<>(dto, headers);

        ResponseEntity<ResponseDTO> response = restTemplate.exchange(backURL + "/school/openRegistrationPeriod",
                HttpMethod.POST, request, ResponseDTO.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }
        return null;
    }

    @Override
    public ResponseDTO closeRegistrationPeriod(DeadlineDTO dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<DeadlineDTO> request = new HttpEntity<>(dto, headers);

        ResponseEntity<ResponseDTO> response = restTemplate.exchange(backURL + "/school/closeRegistrationPeriod",
                HttpMethod.POST, request, ResponseDTO.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }
        return null;
    }
}
