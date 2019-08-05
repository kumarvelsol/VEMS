package igrand.com.vems.samplemodelclasses;

import java.io.Serializable;

import lombok.Data;

@Data
public class AssignmentsModel implements Serializable
{
    public String assignmentTitle;
    public String assignmentSubject;
    public String assignmentclassName;
    public String assignmentTeacher;

    public AssignmentsModel(String assignmentTitle, String assignmentSubject, String assignmentclassName, String assignmentTeacher)
    {
        this.assignmentTitle = assignmentTitle;
        this.assignmentSubject = assignmentSubject;
        this.assignmentclassName = assignmentclassName;
        this.assignmentTeacher = assignmentTeacher;
    }
}
