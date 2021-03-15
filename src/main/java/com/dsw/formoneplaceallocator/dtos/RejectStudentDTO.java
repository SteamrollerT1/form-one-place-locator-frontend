package com.dsw.formoneplaceallocator.dtos;

import lombok.Data;

@Data
public class RejectStudentDTO {
    private String narrative;
    private String studentId;
    private String schoolId;
}
