package igrand.com.vems.samplemodelclasses;

import java.io.Serializable;

import lombok.Data;

@Data
public class PermissionModel implements Serializable {
    public String permissionDate;
    public String permissionTime;
    public String permissionStudentName;
    public String permissionStudentClass;
    public String permissionDuration;
    public String permissionStatus;
    public String permissionData;

    public PermissionModel(String permissionDate, String permissionTime, String permissionStudentName,
                           String permissionStudentClass, String permissionDuration, String permissionStatus, String permissionData) {
        this.permissionDate = permissionDate;
        this.permissionTime = permissionTime;
        this.permissionStudentName = permissionStudentName;
        this.permissionStudentClass = permissionStudentClass;
        this.permissionDuration = permissionDuration;
        this.permissionStatus = permissionStatus;
        this.permissionData = permissionData;
    }
}
