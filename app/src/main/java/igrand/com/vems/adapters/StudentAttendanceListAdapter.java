package igrand.com.vems.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import igrand.com.vems.R;
import igrand.com.vems.samplemodelclasses.StudentAttendanceModel;

public class StudentAttendanceListAdapter extends RecyclerView.Adapter<StudentAttendanceListAdapter.StudentAttendanceViewHolder> {
    Context mCtx;
    List<StudentAttendanceModel> attendanceModelList;
    TextView mLabelStdentName,mLabelStudentAttendance;

    public StudentAttendanceListAdapter(Context mCtx, List<StudentAttendanceModel> attendanceModelList) {
        this.mCtx = mCtx;
        this.attendanceModelList = attendanceModelList;
    }

    public class StudentAttendanceViewHolder extends RecyclerView.ViewHolder{

        public StudentAttendanceViewHolder(@NonNull View itemView) {
            super(itemView);
            mLabelStdentName=(TextView)itemView.findViewById(R.id.student_attendance_list_student_name);
            mLabelStudentAttendance=(TextView)itemView.findViewById(R.id.student_attendance_list_student_attendance_status);
        }
    }
    @NonNull
    @Override
    public StudentAttendanceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new StudentAttendanceViewHolder(LayoutInflater.from(mCtx).inflate(R.layout.student_attendance_list_item,viewGroup,false));

    }

    @Override
    public void onBindViewHolder(@NonNull StudentAttendanceViewHolder studentAttendanceViewHolder, int i) {
        mLabelStdentName.setText(attendanceModelList.get(i).getStudentName());
        mLabelStudentAttendance.setText(attendanceModelList.get(i).getStudentAttendance());
    }

    @Override
    public int getItemCount() {
        return attendanceModelList.size();
    }


}
