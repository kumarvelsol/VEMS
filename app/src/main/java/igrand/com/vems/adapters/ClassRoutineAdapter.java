package igrand.com.vems.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import igrand.com.vems.R;
import igrand.com.vems.apppreferences.ApplicationPreferences;
import igrand.com.vems.samplemodelclasses.AdminClassRoutines;
import igrand.com.vems.samplemodelclasses.AdminTeachersList;

public class ClassRoutineAdapter extends RecyclerView.Adapter<ClassRoutineAdapter.ClassRoutineVewHolder> implements Filterable
{
    List<AdminClassRoutines> adminClassRoutinesList;
    List<AdminClassRoutines> adminClassRoutinesListFiltered;
    Context mCtx;
    TextView mLabelclassName,mLabelSubjectName,mLabelPeriodName,mLabelTimings;
    ImageButton mImgBtnEdit;
    String login_type;

    public ClassRoutineAdapter(List<AdminClassRoutines> adminClassRoutinesList, Context mCtx, String login_type) {
        this.adminClassRoutinesList = adminClassRoutinesList;
        this.mCtx = mCtx;
        this.adminClassRoutinesListFiltered=adminClassRoutinesList;
        this.login_type=login_type;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    adminClassRoutinesListFiltered = adminClassRoutinesList;
                } else {
                    List<AdminClassRoutines> filteredList = new ArrayList<>();
                    for (AdminClassRoutines row : adminClassRoutinesList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getClassName().toLowerCase().contains(charString.toLowerCase()) || row.getPeriod().contains(charSequence)) {
                            filteredList.add(row);
                        }
                    }

                    adminClassRoutinesListFiltered = adminClassRoutinesList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = adminClassRoutinesList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                adminClassRoutinesListFiltered = (ArrayList<AdminClassRoutines>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ClassRoutineVewHolder extends RecyclerView.ViewHolder
    {
        public ClassRoutineVewHolder(@NonNull View itemView) {
            super(itemView);
            mLabelclassName=(TextView)itemView.findViewById(R.id.class_rotines_recycle_item_label_class_name);
            mLabelSubjectName=(TextView)itemView.findViewById(R.id.class_rotines_recycle_item_label_subject_name);
            mLabelPeriodName=(TextView)itemView.findViewById(R.id.class_rotines_recycle_item_label_period_no);
            mLabelTimings=(TextView)itemView.findViewById(R.id.class_rotines_recycle_item_label_timings);
            mImgBtnEdit=(ImageButton)itemView.findViewById(R.id.class_rotines_recycle_item_image_edit);

            if (login_type.equals(ApplicationPreferences.ADMIN_LOGIN))
            {
                mImgBtnEdit.setVisibility(View.VISIBLE);
            }
            else{
                mImgBtnEdit.setVisibility(View.GONE);
            }
            mImgBtnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
    @NonNull
    @Override
    public ClassRoutineVewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ClassRoutineVewHolder(LayoutInflater.from(mCtx).inflate(R.layout.class_routines_list,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ClassRoutineVewHolder classRoutineVewHolder, int i) {
        mLabelclassName.setText(adminClassRoutinesList.get(i).getClassName());
        mLabelSubjectName.setText(adminClassRoutinesList.get(i).getSubjectName());
        mLabelPeriodName.setText(adminClassRoutinesList.get(i).getPeriod());
        mLabelTimings.setText(adminClassRoutinesList.get(i).getTimings());

    }

    @Override
    public int getItemCount() {
        return adminClassRoutinesList.size();
    }


}
