package igrand.com.vems.samplemodelclasses;

import java.io.Serializable;

import lombok.Data;

@Data
public class TeacherAttendanceModel implements Serializable {
    public String student_teacher_name;
    public String student_teacher_attendance;
    public String student_teacher_in_time;
    public String student_teacher_out_time;
    public String student_teacher_attendance_duration;

    public TeacherAttendanceModel(String student_teacher_name, String student_teacher_attendance,
                                  String student_teacher_in_time, String student_teacher_out_time,
                                  String student_teacher_attendance_duration) {
        this.student_teacher_name = student_teacher_name;
        this.student_teacher_attendance = student_teacher_attendance;
        this.student_teacher_in_time = student_teacher_in_time;
        this.student_teacher_out_time = student_teacher_out_time;
        this.student_teacher_attendance_duration = student_teacher_attendance_duration;
    }
}
