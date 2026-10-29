package com.zhunisov.studentapi;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentInfoTest {

    @Test
    void infoContainsStudentName() {
        StudentController controller = new StudentController(null);
        assertEquals("Zhunisov Gabit", controller.info().get("student"));
    }
}
