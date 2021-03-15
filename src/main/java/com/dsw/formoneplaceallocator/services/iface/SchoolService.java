package com.dsw.formoneplaceallocator.services.iface;

import com.dsw.formoneplaceallocator.dtos.AcceptStudentDTO;
import com.dsw.formoneplaceallocator.dtos.DeadlineDTO;
import com.dsw.formoneplaceallocator.dtos.ResponseDTO;
import com.dsw.formoneplaceallocator.dtos.SchoolDTO;
import com.dsw.formoneplaceallocator.models.School;

import java.util.List;

public interface SchoolService {
    ResponseDTO register(SchoolDTO dto);

    List<School> getAll();

    School getById(String schoolId);

    ResponseDTO reject(String schoolId);

    ResponseDTO suspend(String schoolId);

    ResponseDTO accept(AcceptStudentDTO dto);

    ResponseDTO openRegistrationPeriod(DeadlineDTO dto);

    ResponseDTO closeRegistrationPeriod(DeadlineDTO dto);

}
