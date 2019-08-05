package igrand.com.vems.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Counts
{
    @SerializedName("counta")
    @Expose
    public String countAttendance;

    @SerializedName("countp")
    @Expose
    public String counPermissions;

    @SerializedName("counts")
    @Expose
    public String countStudents ;

    @SerializedName("countc")
    @Expose
    public String countClasses;

    @SerializedName("countt")
    @Expose
    public String countTeachers;

    @SerializedName("countl")
    @Expose
    public String countLeaves;

}
