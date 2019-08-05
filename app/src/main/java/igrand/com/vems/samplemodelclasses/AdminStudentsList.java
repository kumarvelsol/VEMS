package igrand.com.vems.samplemodelclasses;

import java.io.Serializable;

import lombok.Data;

@Data
public class AdminStudentsList implements Serializable {
    public String studentId;
    public String studentSection;
    public String studentName;
    public String studentImage;
    public String studentGender;
    public String studentParent;
    public String studentParentMobile;
    public String studentClass;

    public AdminStudentsList(String studentId, String studentSection, String studentName, String studentImage, String studentGender, String studentParent, String studentParentMobile, String studentClass) {
        this.studentId = studentId;
        this.studentSection = studentSection;
        this.studentName = studentName;
        this.studentImage = studentImage;
        this.studentGender = studentGender;
        this.studentParent = studentParent;
        this.studentParentMobile = studentParentMobile;
        this.studentClass = studentClass;
    }
}
