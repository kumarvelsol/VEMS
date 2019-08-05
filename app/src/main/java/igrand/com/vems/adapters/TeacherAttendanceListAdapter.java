package igrand.com.vems.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import igrand.com.vems.R;
import igrand.com.vems.samplemodelclasses.TeacherAttendanceModel;

public class TeacherAttendanceListAdapter extends RecyclerView.Adapter<TeacherAttendanceListAdapter.TeacherAttendanceListViewHolder>
{
    Context mCtx;
    List<TeacherAttendanceModel> attendanceModels;
    TextView mLabelName,mLabelAttendance,mLabelInTime,mLabelOutTime,mLabelDuration;

    public TeacherAttendanceListAdapter(Context mCtx, List<TeacherAttendanceModel> attendanceModels) {
        this.mCtx = mCtx;
        this.attendanceModels = attendanceModels;
    }

    public class TeacherAttendanceListViewHolder extends RecyclerView.ViewHolder
    {

        public TeacherAttendanceListViewHolder(@NonNull View itemView) {
            super(itemView);
            mLabelName=(TextView)itemView.findViewById(R.id.student_teacher_attendance_list_label_name);
            mLabelInTime=(TextView)itemView.findViewById(R.id.student_teacher_attendance_list_label_in_time);
            mLabelOutTime=(TextView)itemView.findViewById(R.id.student_teacher_attendance_list_label_outime);
            mLabelDuration=(TextView)itemView.findViewById(R.id.student_teacher_attendance_list_label_duration);
            mLabelAttendance=(TextView)itemView.findViewById(R.id.student_teacher_attendance_list_label_attendance);
        }
    }
    @NonNull
    @Override
    public TeacherAttendanceListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new TeacherAttendanceListViewHolder(LayoutInflater.from(mCtx).inflate(R.layout.teachers_attendance_list_item,viewGroup,false));
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull TeacherAttendanceListViewHolder teacherAttendanceListViewHolder, int i) {

        mLabelName.setText(attendanceModels.get(i).getStudent_teacher_name());
        mLabelInTime.setText(attendanceModels.get(i).getStudent_teacher_in_time());
        mLabelOutTime.setText(attendanceModels.get(i).getStudent_teacher_out_time());
        mLabelDuration.setText(attendanceModels.get(i).getStudent_teacher_attendance_duration());
        if (attendanceModels.get(i).getStudent_teacher_attendance().equalsIgnoreCase("Absent"))
        {
            mLabelAttendance.setTextColor(mCtx.getColor(R.color.red));
            mLabelAttendance.setBackground(mCtx.getResources().getDrawable(R.drawable.light_orange_background));
            mLabelAttendance.setText(attendanceModels.get(i).getStudent_teacher_attendance());
        }
        else {
            mLabelAttendance.setText(attendanceModels.get(i).getStudent_teacher_attendance());
        }

    }

    @Override
    public int getItemCount() {
        return attendanceModels.size();
    }


}
