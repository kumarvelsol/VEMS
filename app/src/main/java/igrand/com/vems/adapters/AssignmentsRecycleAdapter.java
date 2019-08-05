package igrand.com.vems.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import igrand.com.vems.R;
import igrand.com.vems.samplemodelclasses.AdminStudentsList;
import igrand.com.vems.samplemodelclasses.AssignmentsModel;

public class AssignmentsRecycleAdapter extends RecyclerView.Adapter<AssignmentsRecycleAdapter.AssignmentsViewHolder> implements Filterable
{
    Context mCtx;
    List<AssignmentsModel> assignmentsModels;
    List<AssignmentsModel> adminStudentsListsFiltered;

    public AssignmentsRecycleAdapter(Context mCtx, List<AssignmentsModel> assignmentsModels) {
        this.mCtx = mCtx;
        this.assignmentsModels = assignmentsModels;
        this.adminStudentsListsFiltered=assignmentsModels;
    }

    TextView mLabelAssignmentTitle,mLabelAssignmentSubject,mLabelAssignmentClass,mLabelAssignmentTeacherName;

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    adminStudentsListsFiltered = assignmentsModels;
                } else {
                    List<AssignmentsModel> filteredList = new ArrayList<>();
                    for (AssignmentsModel row : assignmentsModels) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getAssignmentclassName().toLowerCase().contains(charString.toLowerCase()) || row.getAssignmentTitle().contains(charSequence)) {
                            filteredList.add(row);
                        }
                    }

                    adminStudentsListsFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = assignmentsModels;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                adminStudentsListsFiltered = (ArrayList<AssignmentsModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class AssignmentsViewHolder extends RecyclerView.ViewHolder
    {

        public AssignmentsViewHolder(@NonNull View itemView) {
            super(itemView);
            mLabelAssignmentTitle=(TextView)itemView.findViewById(R.id.assignments_recycle_list_label_teacher_assignment_title);
            mLabelAssignmentSubject=(TextView)itemView.findViewById(R.id.assignments_recycle_list_label_teacher_subject_name);
            mLabelAssignmentClass=(TextView)itemView.findViewById(R.id.assignments_recycle_list_label_teacher_class_name);
            mLabelAssignmentTeacherName=(TextView)itemView.findViewById(R.id.assignments_recycle_list_label_teacher_name);
        }
    }
    @NonNull
    @Override
    public AssignmentsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new AssignmentsViewHolder(LayoutInflater.from(mCtx).inflate(R.layout.assignments_list_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AssignmentsViewHolder assignmentsViewHolder, int i) {
        mLabelAssignmentTitle.setText("Assignment: "+assignmentsModels.get(i).getAssignmentTitle());
        mLabelAssignmentSubject.setText(assignmentsModels.get(i).getAssignmentSubject());
        mLabelAssignmentClass.setText(assignmentsModels.get(i).getAssignmentclassName());
        mLabelAssignmentTeacherName.setText(assignmentsModels.get(i).getAssignmentTeacher());

    }

    @Override
    public int getItemCount() {
        return assignmentsModels.size();
    }


}
