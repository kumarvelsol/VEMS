package igrand.com.vems.samplemodelclasses;

import java.io.Serializable;

import lombok.Data;

@Data
public class AdminTeachersList implements Serializable
{
    public String teacherName;
    public String teacherQly;
    public String techerImage;
    public String teacherId;
    public String teacherJoiningDate;
    public String teacherTimings;
    public String teacherMobile;

    public AdminTeachersList(String teacherName, String teacherQly,
                             String techerImage, String teacherId, String teacherJoiningDate, String teacherTimings,
                             String teacherMobile) {
        this.teacherName = teacherName;
        this.teacherQly = teacherQly;
        this.techerImage = techerImage;
        this.teacherId = teacherId;
        this.teacherJoiningDate = teacherJoiningDate;
        this.teacherTimings = teacherTimings;
        this.teacherMobile = teacherMobile;
    }
}
