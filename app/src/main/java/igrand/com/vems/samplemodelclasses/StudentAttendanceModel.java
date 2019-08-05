package igrand.com.vems.samplemodelclasses;

import java.io.Serializable;

import lombok.Data;

@Data
public class StudentAttendanceModel implements Serializable {
    String studentName;
    String studentAttendance;

    public StudentAttendanceModel(String studentName, String studentAttendance) {
        this.studentName = studentName;
        this.studentAttendance = studentAttendance;
    }
}
