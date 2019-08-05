package igrand.com.vems.samplemodelclasses;

import lombok.Data;

@Data
public class AdminClassRoutines
{
    public String className;
    public String subjectName;
    public String period;
    public String timings;

    public AdminClassRoutines(String className, String subjectName, String period, String timings) {
        this.className = className;
        this.subjectName = subjectName;
        this.period = period;
        this.timings = timings;
    }
}
