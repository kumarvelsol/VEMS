package igrand.com.vems.samplemodelclasses;

import java.io.Serializable;

import lombok.Data;

@Data
public class AdminLeavesList implements Serializable {
public String studentName;
public String studentImage;
public String date;
public String days;
public String studentClass;
public String leaveStatus;

    public AdminLeavesList(String studentName, String studentImage, String date, String days, String studentClass, String leaveStatus) {
        this.studentName = studentName;
        this.studentImage = studentImage;
        this.date = date;
        this.days = days;
        this.studentClass = studentClass;
        this.leaveStatus = leaveStatus;
    }
}

