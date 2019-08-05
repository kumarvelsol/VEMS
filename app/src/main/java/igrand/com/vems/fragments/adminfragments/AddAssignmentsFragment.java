package igrand.com.vems.fragments.adminfragments;


import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import igrand.com.vems.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddAssignmentsFragment extends Fragment {
    Spinner mSpinAddAssignmentsClassNames,mSpinAddAssignmentsClassTeachers;
    TextInputEditText mInputAddAssignmentsSubjectName;
    Button mBtnAddAssignments;


    public AddAssignmentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_add_assignments, container, false);
        initViews(v);
        return v;
    }

    private void initViews(View v) {
        mSpinAddAssignmentsClassNames=(Spinner)v.findViewById(R.id.add_student_spinner_class_names);
        mSpinAddAssignmentsClassTeachers=(Spinner)v.findViewById(R.id.add_assignment_spinner_class_teachers);
        mInputAddAssignmentsSubjectName=(TextInputEditText)v.findViewById(R.id.add_assignment_input_subject_name);
        mBtnAddAssignments=(Button)v.findViewById(R.id.add_assignment_btn);
        mBtnAddAssignments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performAddAssignmentsOperation();
            }
        });

    }
    private boolean validateAddAssignments(String className,String classTeachers,String subjectName)
    {
        if (className.equals(""))
        {
            Toast.makeText(getContext(), "Please Select Class", Toast.LENGTH_SHORT).show();
            return true;

        }
        if (classTeachers.equals(""))
        {
            Toast.makeText(getContext(), "Please Select Class Teacher", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (subjectName.isEmpty())
        {
            mInputAddAssignmentsSubjectName.setError("Please Enter");
            mInputAddAssignmentsSubjectName.requestFocus();
            return true;
        }
        return false;
    }
    private void performAddAssignmentsOperation() {
        if (!validateAddAssignments(mSpinAddAssignmentsClassNames.getSelectedItem().toString().trim(),
                mSpinAddAssignmentsClassTeachers.getSelectedItem().toString().trim(),
                mInputAddAssignmentsSubjectName.getText().toString().trim()))
        {
            Toast.makeText(getContext(), "Assignment Added Successfully", Toast.LENGTH_SHORT).show();
        }
    }
}
