package igrand.com.vems.adapters;

import android.content.Context;
import android.content.Intent;
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

import de.hdodenhof.circleimageview.CircleImageView;
import igrand.com.vems.R;
import igrand.com.vems.activities.admin.AddStudentActivity;
import igrand.com.vems.apppreferences.ApplicationPreferences;
import igrand.com.vems.helpers.AppConstants;
import igrand.com.vems.samplemodelclasses.AdminStudentsList;

public class AdminStudentsListAdapter extends RecyclerView.Adapter<AdminStudentsListAdapter.AdminStudentsListViewHolder> implements Filterable
{
    List<AdminStudentsList> adminStudentsLists;
    AdminStudentsList studentData;
    Context mCtx;
    List<AdminStudentsList> adminStudentsListsFiltered;
    TextView mLabelStudentId,mLabelStudentSection,mLabelStudentStudentName,mLabelStudentParentName,mLabelStudentGender,mLabelStudentMobile,
            mLabelStudentClass;
    CircleImageView mImageStudentImaage;
    ImageButton mImgBtnStudentEdit;
    String login_type;


    public AdminStudentsListAdapter(List<AdminStudentsList> adminStudentsLists, Context mCtx,String login_type) {
        this.adminStudentsLists = adminStudentsLists;
        this.mCtx = mCtx;
        this.adminStudentsListsFiltered=adminStudentsLists;
        this.login_type=login_type;
    }

    @Override
    public Filter getFilter()
    {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    adminStudentsListsFiltered = adminStudentsLists;
                } else {
                    List<AdminStudentsList> filteredList = new ArrayList<>();
                    for (AdminStudentsList row : adminStudentsLists) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getStudentName().toLowerCase().contains(charString.toLowerCase()) || row.getStudentId().contains(charSequence)) {
                            filteredList.add(row);
                        }
                    }

                    adminStudentsListsFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = adminStudentsLists;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                adminStudentsListsFiltered = (ArrayList<AdminStudentsList>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class AdminStudentsListViewHolder extends RecyclerView.ViewHolder{

        public AdminStudentsListViewHolder(@NonNull View itemView) {
            super(itemView);
            mLabelStudentStudentName=(TextView)itemView.findViewById(R.id.student_list_recycle_item_label_student_name);
            mLabelStudentId=(TextView)itemView.findViewById(R.id.student_list_recycle_item_label_student_id);
            mLabelStudentSection=(TextView)itemView.findViewById(R.id.student_list_recycle_item_label_student_section);
            mLabelStudentParentName=(TextView)itemView.findViewById(R.id.student_list_recycle_item_label_student_parent_name);
            mLabelStudentMobile=(TextView)itemView.findViewById(R.id.student_list_recycle_item_label_student_parent_mobile);
            mLabelStudentGender=(TextView)itemView.findViewById(R.id.student_list_recycle_item_label_student_gender);
            mLabelStudentClass=(TextView)itemView.findViewById(R.id.student_list_recycle_item_label_student_class);
            mImgBtnStudentEdit=(ImageButton) itemView.findViewById(R.id.student_list_recycle_item_image_button_edit);
            if (login_type.equals(ApplicationPreferences.ADMIN_LOGIN))
            {
                mImgBtnStudentEdit.setVisibility(View.VISIBLE);
            }
            else
            {
                mImgBtnStudentEdit.setVisibility(View.GONE);
            }
            mImgBtnStudentEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });


        }
    }
    @NonNull
    @Override
    public AdminStudentsListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new AdminStudentsListViewHolder(LayoutInflater.from(mCtx).inflate(R.layout.admin_students_list,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdminStudentsListViewHolder adminStudentsListViewHolder, final int i) {
        mLabelStudentStudentName.setText(adminStudentsLists.get(i).getStudentName());
        mLabelStudentClass.setText(adminStudentsLists.get(i).getStudentClass());
        mLabelStudentId.setText(adminStudentsLists.get(i).getStudentId());
        mLabelStudentSection.setText(adminStudentsLists.get(i).getStudentSection());
        mLabelStudentParentName.setText(adminStudentsLists.get(i).getStudentParent());
        mLabelStudentMobile.setText(adminStudentsLists.get(i).getStudentParentMobile());
        mLabelStudentGender.setText(adminStudentsLists.get(i).getStudentGender());
        mImgBtnStudentEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent studentDataIntent=new Intent(mCtx, AddStudentActivity.class);
                studentDataIntent.putExtra(AppConstants.stdentDataIntentKey,adminStudentsLists.get(i));
                studentDataIntent.putExtra(AppConstants.studentDataPassedOrNot,true);
                mCtx.startActivity(studentDataIntent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return adminStudentsListsFiltered.size();
    }


}
