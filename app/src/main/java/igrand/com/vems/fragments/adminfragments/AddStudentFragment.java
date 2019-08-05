package igrand.com.vems.fragments.adminfragments;


import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import igrand.com.vems.R;
import igrand.com.vems.apppreferences.ApplicationPreferences;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddStudentFragment extends Fragment {
    LinearLayout mLayoutFirstStep,mLayoutSecondStep,mLayoutThirdStep;
    TextInputEditText mInputFirstLayoutAddStudentFullName,mInputFirstLayoutAddStudentDateofJoining,mInputFirstLayoutAddStudentAdmissionNo,
            mInputFirstLayoutAddStudentRollNo,mInputFirstLayoutAddStudentFatherName,mInputFirstLayoutAddStudentFatherAadhar,
            mInputFirstLayoutAddStudentFatherContactNo,mInputFirstLayoutAddStudentFatherQualification,mInputFirstLayoutAddStudentFatherIncome;
    TextInputEditText mInputSecondLayoutMotherName,mInputSecondLayoutAddStudentMothetAadhar,mInputSecondLayoutAddStudentMotherContact,
            mInputSecondLayoutAddStudentMotherQualification,mInputSecondLayoutAddStudentMotherIncome,
            mInputSecondLayoutAddStudentGuardianName,
            mInputSecondLayoutAddStudentGuardianAadhar,rmInputSecondLayoutAddStudentGuardianContactNo,
            mInputSecondLayoutAddStudentGuardianQualification,
            mInputSecondLayoutAddStudentGuardianIncome,mInputSecondLayoutAddStudentDOB,
            mInputSecondLayoutAddStudentEmailAddress, mInputSecondLayoutAddStudentContact;

    TextInputEditText mInputThirdLayoutAddStudentPresentAddress,mInputThirdLayoutAddStudentAadharNo,mInputThirdLayoutAddStudentMotherTongue,
            mInputThirdLayoutAddStudentRemarks;
    Spinner mSpinnerFirstLayoutStream,mSpinnerFirstLayoutSession,mSpinnerFirstLayoutClassName,mSpinnerFirstLayoutClassTimings;
    Spinner mSpinnerThirdLayoutGender,mSpinnerThirdLayoutAdmissionCategory,mSpinnerThirdLayoutFeeCategory,mSpinnerThirdLayoutBloodGroup,
            mSpinnerThirdLayoutReligion,mSpinnerThirdLayoutCaste;
    Button mBtnFirstLAyoutNext,mBtnSecondLayoutNext,mBtnThirdLayotSubmit;
    ApplicationPreferences preferences;


    public AddStudentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_add_student, container, false);
        initViews(v);
        return v;
    }

    private void initViews(View v)
    {
        preferences=new ApplicationPreferences(getActivity());
        mLayoutFirstStep=(LinearLayout)v.findViewById(R.id.add_student_first_step_layout);
        mLayoutSecondStep=(LinearLayout)v.findViewById(R.id.add_student_second_step_layout);
        mLayoutThirdStep=(LinearLayout)v.findViewById(R.id.add_student_third_step_layout);

        // First Step Layout Components Initalizing
        mInputFirstLayoutAddStudentFullName=(TextInputEditText)v.findViewById(R.id.add_student_input_full_name);
        mInputFirstLayoutAddStudentDateofJoining=(TextInputEditText)v.findViewById(R.id.add_student_input_doj);
        mInputFirstLayoutAddStudentAdmissionNo=(TextInputEditText)v.findViewById(R.id.add_student_input_admission_no);
        mInputFirstLayoutAddStudentRollNo=(TextInputEditText)v.findViewById(R.id.add_student_input_roll_no);
        mInputFirstLayoutAddStudentFatherName=(TextInputEditText)v.findViewById(R.id.add_student_input_father_name);
        mInputFirstLayoutAddStudentFatherAadhar=(TextInputEditText)v.findViewById(R.id.add_student_input_father_aadhar);
        mInputFirstLayoutAddStudentFatherContactNo=(TextInputEditText)v.findViewById(R.id.add_student_input_father_mobile);
        mInputFirstLayoutAddStudentFatherQualification=(TextInputEditText)v.findViewById(R.id.add_student_input_father_qly);
        mInputFirstLayoutAddStudentFatherIncome=(TextInputEditText)v.findViewById(R.id.add_student_input_father_income);

        mSpinnerFirstLayoutStream=(Spinner)v.findViewById(R.id.add_student_spinner_streams);
        mSpinnerFirstLayoutSession=(Spinner)v.findViewById(R.id.add_student_spinner_sessions);
        mSpinnerFirstLayoutClassName=(Spinner)v.findViewById(R.id.add_student_spinner_class_names);
        mSpinnerFirstLayoutClassTimings=(Spinner)v.findViewById(R.id.add_student_spinner_class_timings);

        // Second Step Layout Components Initializing
        mInputSecondLayoutMotherName=(TextInputEditText)v.findViewById(R.id.add_student_input_mother_name);
        mInputSecondLayoutAddStudentMothetAadhar=(TextInputEditText)v.findViewById(R.id.add_student_input_mother_aadhar);
        mInputSecondLayoutAddStudentMotherContact=(TextInputEditText)v.findViewById(R.id.add_student_input_mother_contact_no);
        mInputSecondLayoutAddStudentMotherQualification=(TextInputEditText)v.findViewById(R.id.add_student_input_mother_qly);
        mInputSecondLayoutAddStudentMotherIncome=(TextInputEditText)v.findViewById(R.id.add_student_input_mother_income);
        mInputSecondLayoutAddStudentGuardianName=(TextInputEditText)v.findViewById(R.id.add_student_input_guadian_name);
        mInputSecondLayoutAddStudentGuardianAadhar=(TextInputEditText)v.findViewById(R.id.add_student_input_guardian_aadhar);
        rmInputSecondLayoutAddStudentGuardianContactNo=(TextInputEditText)v.findViewById(R.id.add_student_input_guardian_contact);
        mInputSecondLayoutAddStudentGuardianQualification=(TextInputEditText)v.findViewById(R.id.add_student_input_guardian_qly);
        mInputSecondLayoutAddStudentGuardianIncome=(TextInputEditText)v.findViewById(R.id.add_student_input_guardian_income);
        mInputSecondLayoutAddStudentEmailAddress=(TextInputEditText)v.findViewById(R.id.add_student_input_email);
        mInputSecondLayoutAddStudentDOB=(TextInputEditText)v.findViewById(R.id.add_student_input_dob);
        mInputSecondLayoutAddStudentContact=(TextInputEditText)v.findViewById(R.id.add_student_input_contact_no);

        //Third Step Layout Components Initialization

        mInputThirdLayoutAddStudentPresentAddress=(TextInputEditText)v.findViewById(R.id.add_teacher_second_layout_label_present_address);
        mInputThirdLayoutAddStudentAadharNo=(TextInputEditText)v.findViewById(R.id.add_teacher_second_layout_label_present_address);
        mInputThirdLayoutAddStudentMotherTongue=(TextInputEditText)v.findViewById(R.id.add_teacher_second_layout_label_present_address);
        mInputThirdLayoutAddStudentRemarks=(TextInputEditText)v.findViewById(R.id.add_teacher_second_layout_label_present_address);

        mSpinnerThirdLayoutGender=(Spinner)v.findViewById(R.id.add_student_spinner_gender);
        mSpinnerThirdLayoutAdmissionCategory=(Spinner)v.findViewById(R.id.add_student_spinner_admission_category);
        mSpinnerThirdLayoutFeeCategory=(Spinner)v.findViewById(R.id.add_student_spinner_fee_category);

        mSpinnerThirdLayoutBloodGroup=(Spinner)v.findViewById(R.id.add_student_spinner_blood_group);
        mSpinnerThirdLayoutReligion=(Spinner)v.findViewById(R.id.add_student_spinner_religion);
        mSpinnerThirdLayoutCaste=(Spinner)v.findViewById(R.id.add_student_spinner_caste);

        //Buttons Initialization
        mBtnFirstLAyoutNext=(Button)v.findViewById(R.id.first_layout_next_btn);
        mBtnSecondLayoutNext=(Button)v.findViewById(R.id.second_layout_next_btn);
        mBtnThirdLayotSubmit=(Button)v.findViewById(R.id.third_layout_submit_btn);
        mBtnFirstLAyoutNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstStepOperations();
            }
        });
        mBtnSecondLayoutNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondStepOperations();

            }
        });
        mBtnThirdLayotSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thirdStepOperations();

            }
        });



    }
    private void  firstStepOperations()
    {
        String fullName=mInputFirstLayoutAddStudentFullName.getText().toString().trim();
       String dateOfJoin= mInputFirstLayoutAddStudentDateofJoining.getText().toString().trim();
       String stream= mSpinnerFirstLayoutStream.getSelectedItem().toString().trim();
       String sessiom= mSpinnerFirstLayoutSession.getSelectedItem().toString().trim();
       String admissionNo= mInputFirstLayoutAddStudentAdmissionNo.getText().toString().trim();
       String rollNo= mInputFirstLayoutAddStudentRollNo.getText().toString().trim();
       String className= mSpinnerFirstLayoutClassName.getSelectedItem().toString().trim();
       String classTimings= mSpinnerFirstLayoutClassTimings.getSelectedItem().toString().trim();
       String fatherName= mInputFirstLayoutAddStudentFatherName.getText().toString().trim();
       String fatherAadhar= mInputFirstLayoutAddStudentFatherAadhar.getText().toString().trim();
       String fatherContact= mInputFirstLayoutAddStudentFatherContactNo.getText().toString().trim();
       String fatherQly= mInputFirstLayoutAddStudentFatherQualification.getText().toString().trim();
       String fatherIncome= mInputFirstLayoutAddStudentFatherIncome.getText().toString().trim();

       if (!validateFirstStep(fullName,dateOfJoin,stream,sessiom,admissionNo,rollNo,className,classTimings,fatherName,fatherAadhar,
               fatherContact,fatherQly,fatherIncome))
       {
           mLayoutFirstStep.setVisibility(View.GONE);
           mLayoutSecondStep.setVisibility(View.VISIBLE);
       }
    }
    private void  secondStepOperations()
    {
       String motherName= mInputSecondLayoutMotherName.getText().toString().trim();
       String mothetAadhar= mInputSecondLayoutAddStudentMothetAadhar.getText().toString().trim();
       String motherContact= mInputSecondLayoutAddStudentMotherContact.getText().toString().trim();
       String motherQly= mInputSecondLayoutAddStudentMotherQualification.getText().toString().trim();
       String motherIncome= mInputSecondLayoutAddStudentMotherQualification.getText().toString().trim();
       String guardianName= mInputSecondLayoutAddStudentGuardianName.getText().toString().trim();
       String guardianAadhar= mInputSecondLayoutAddStudentGuardianAadhar.getText().toString().trim();
       String guardianContact= rmInputSecondLayoutAddStudentGuardianContactNo.getText().toString().trim();
       String guardianQly= mInputSecondLayoutAddStudentGuardianQualification.getText().toString().trim();
       String guardianIncome= mInputSecondLayoutAddStudentGuardianIncome.getText().toString().trim();
       String dob= mInputSecondLayoutAddStudentDOB.getText().toString().trim();
       String contactNo= mInputSecondLayoutAddStudentContact.getText().toString().trim();
       String email= mInputSecondLayoutAddStudentEmailAddress.getText().toString().trim();
       if (!validateSecondStep(motherName,mothetAadhar,motherContact,motherQly,motherIncome,guardianName,guardianAadhar,guardianContact,
               guardianQly,guardianIncome,dob,contactNo,email))
       {
            mLayoutSecondStep.setVisibility(View.GONE);
            mLayoutFirstStep.setVisibility(View.GONE);
            mLayoutThirdStep.setVisibility(View.VISIBLE);
       }
    }
    private void  thirdStepOperations()
    {
       String presentAddress= mInputThirdLayoutAddStudentPresentAddress.getText().toString().trim();
       String gender= mSpinnerThirdLayoutGender.getSelectedItem().toString().trim();
       String aadhar= mInputThirdLayoutAddStudentAadharNo.getText().toString().trim();
       String bloodGroup= mSpinnerThirdLayoutBloodGroup.getSelectedItem().toString().trim();
       String religion= mSpinnerThirdLayoutReligion.getSelectedItem().toString().trim();
       String caste= mSpinnerThirdLayoutCaste.getSelectedItem().toString().trim();
       String motherTongue= mInputThirdLayoutAddStudentMotherTongue.getText().toString().trim();
       String admissionCategory= mSpinnerThirdLayoutAdmissionCategory.getSelectedItem().toString().trim();
       String feeCategory= mSpinnerThirdLayoutFeeCategory.getSelectedItem().toString().trim();
       String remarks= mInputThirdLayoutAddStudentRemarks.getText().toString().trim();
       if (!validateThirdStep(presentAddress,gender,aadhar,bloodGroup,religion,caste,motherTongue,admissionCategory,feeCategory,remarks))
       {
           Toast.makeText(getActivity(), "Student Added Successfully", Toast.LENGTH_SHORT).show();
           if (preferences.getLoginTYpe().equals(ApplicationPreferences.PRINCIPAL_LOGIN)) {
               loadTeachersListFragment(new TeachersListFragment(), R.id.principal_home_frame_layout);
           }
           else if (preferences.getLoginTYpe().equals(ApplicationPreferences.ADMIN_LOGIN))
           {
               loadTeachersListFragment(new TeachersListFragment(),R.id.admin_home_frame_layout);
           }
       }
    }
    private boolean validateFirstStep(String fullName,String doj,String stream,String session,String admissionNumber,String rllNo,
                                   String className,String classTiming,String fatherName,String fatherAadhar,String fatherContactNo,
                                   String fatherQly,String fatherIncome)
    {
        if (fullName.isEmpty())
        {
            mInputFirstLayoutAddStudentFullName.setError("Please Enter");
            mInputFirstLayoutAddStudentFullName.requestFocus();
            return true;
        }
         if (doj.isEmpty())
        {
            mInputFirstLayoutAddStudentDateofJoining.setError("Please Enter");
            mInputFirstLayoutAddStudentDateofJoining.requestFocus();
            return true;
        }
        if (admissionNumber.isEmpty())
        {
            mInputFirstLayoutAddStudentAdmissionNo.setError("Please Enter");
            mInputFirstLayoutAddStudentAdmissionNo.requestFocus();
            return true;
        }
        if (rllNo.isEmpty())
        {
            mInputFirstLayoutAddStudentRollNo.setError("Please Enter");
            mInputFirstLayoutAddStudentRollNo.requestFocus();
            return true;
        }
        if (fatherName.isEmpty())
        {
            mInputFirstLayoutAddStudentFatherName.setError("Please Enter");
            mInputFirstLayoutAddStudentFatherName.requestFocus();
            return true;
        }
        if (fatherAadhar.isEmpty())
        {
            mInputThirdLayoutAddStudentAadharNo.setError("Please Enter");
            mInputThirdLayoutAddStudentAadharNo.requestFocus();
            return true;
        }
        if (fatherContactNo.isEmpty())
        {
            mInputFirstLayoutAddStudentFatherContactNo.setError("Please Enter");
            mInputFirstLayoutAddStudentFatherContactNo.requestFocus();
            return true;
        }
        if (fatherQly.isEmpty())
        {
            mInputFirstLayoutAddStudentFatherQualification.setError("Please Enter");
            mInputFirstLayoutAddStudentFatherQualification.requestFocus();
            return true;
        }
        if (fatherIncome.isEmpty())
        {
            mInputFirstLayoutAddStudentFatherIncome.setError("Please Enter");
            mInputFirstLayoutAddStudentFatherIncome.requestFocus();
            return true;
        }
        if (stream.equals(""))
        {
            Toast.makeText(getActivity(), "Please Select Stream", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (session.equals(""))
        {
            Toast.makeText(getActivity(), "Please Select Session", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (className.isEmpty())
        {
            Toast.makeText(getActivity(), "Please Select Class Name", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (classTiming.isEmpty())
        {
            Toast.makeText(getActivity(), "Please Select Class Timings", Toast.LENGTH_SHORT).show();

            return true;
        }
        return false;

    }


    private boolean validateSecondStep(String motherName,String motherAadhar,String motherContact,String motherQly,String motherIncome,
                                       String guardianName,String guardianAadhar,String guardianContactNo,String guardianQly,
                                       String guardianIncome,String dob,String contactNo,String emailAddress)
    {
        if (motherName.isEmpty())
        {
            mInputSecondLayoutMotherName.setError("Please Enter");
            mInputSecondLayoutMotherName.requestFocus();
            return true;
        }
        if (motherAadhar.isEmpty())
        {
            mInputSecondLayoutAddStudentMothetAadhar.setError("Please Enter");
            mInputSecondLayoutAddStudentMothetAadhar.requestFocus();
            return true;
        }
        if (motherContact.isEmpty())
        {
            mInputSecondLayoutAddStudentMotherContact.setError("Please Enter");
            mInputSecondLayoutAddStudentMotherContact.requestFocus();
            return true;
        }
        if (motherQly.isEmpty())
        {
            mInputSecondLayoutAddStudentMotherQualification.setError("Please Enter");
            mInputSecondLayoutAddStudentMotherQualification.requestFocus();
            return true;
        }
        if (motherIncome.isEmpty())
        {
            mInputSecondLayoutAddStudentMotherIncome.setError("Please Enter");
            mInputSecondLayoutAddStudentMotherIncome.requestFocus();
            return true;
        }
        if (guardianName.isEmpty())
        {
            mInputSecondLayoutAddStudentGuardianName.setError("Please Enter");
            mInputSecondLayoutAddStudentGuardianName.requestFocus();
            return true;
        }
        if (guardianAadhar.isEmpty())
        {
            mInputSecondLayoutAddStudentGuardianAadhar.setError("Please Enter");
            mInputSecondLayoutAddStudentGuardianAadhar.requestFocus();
            return true;
        }
        if (guardianContactNo.isEmpty())
        {
            rmInputSecondLayoutAddStudentGuardianContactNo.setError("Please Enter");
            rmInputSecondLayoutAddStudentGuardianContactNo.requestFocus();
            return true;
        }
        if (guardianQly.isEmpty())
        {
            mInputSecondLayoutAddStudentGuardianQualification.setError("Please Enter");
            mInputSecondLayoutAddStudentGuardianQualification.requestFocus();
            return true;
        }
        if (guardianIncome.isEmpty())
        {
            mInputSecondLayoutAddStudentGuardianIncome.setError("Please Enter");
            mInputSecondLayoutAddStudentGuardianIncome.requestFocus();
            return true;
        }
        if (dob.isEmpty())
        {
            mInputSecondLayoutAddStudentDOB.setError("Please Enter");
            mInputSecondLayoutAddStudentDOB.requestFocus();
            return true;
        }
        if (contactNo.isEmpty())
        {
            mInputSecondLayoutAddStudentContact.setError("Please Enter");
            mInputSecondLayoutAddStudentContact.requestFocus();
            return true;
        }
        if (emailAddress.isEmpty())
        {
            mInputSecondLayoutAddStudentEmailAddress.setError("Please Enter");
            mInputSecondLayoutAddStudentEmailAddress.requestFocus();
            return true;
        }
        return false;
    }
    private boolean validateThirdStep(String presentAddress,String gender,String aadharNo,String bloodGroup,
                                      String religion,String caste,String motherTongue,String admissionCategory,String feeCategory,
                                      String remarks)
    {
        if (presentAddress.isEmpty())
        {
            mInputThirdLayoutAddStudentPresentAddress.setError("Please Enter");
            mInputThirdLayoutAddStudentPresentAddress.requestFocus();
            return true;
        }
        if (gender.equals(""))
        {
            Toast.makeText(getActivity(), "Please Select Gender", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (aadharNo.isEmpty())
        {
            mInputThirdLayoutAddStudentAadharNo.setError("Please Enter");
            mInputThirdLayoutAddStudentAadharNo.requestFocus();
            return true;
        }
        if (bloodGroup.isEmpty())
        {
            Toast.makeText(getActivity(), "Please Select Blood Group", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (religion.isEmpty())
        {
            Toast.makeText(getActivity(), "Please Select Religion", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (caste.isEmpty())
        {
            Toast.makeText(getActivity(), "Please Select Caste", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (motherTongue.isEmpty())
        {
            mInputThirdLayoutAddStudentMotherTongue.setError("Please Enter");
            mInputThirdLayoutAddStudentMotherTongue.requestFocus();
            return true;
        }
        if (remarks.isEmpty())
        {
            mInputThirdLayoutAddStudentRemarks.setError("Please Enter");
            mInputThirdLayoutAddStudentRemarks.requestFocus();
            return true;
        }
        if (religion.equals(""))
        {
            Toast.makeText(getActivity(), "Please Religion Gender", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (caste.equals(""))
        {
            Toast.makeText(getActivity(), "Please Caste Gender", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
    private void emptyAllFields()
    {

    }
    private void loadTeachersListFragment(Fragment fragment, int frameId){
        FragmentTransaction fm=getFragmentManager().beginTransaction();
        fm.replace(frameId,fragment);
        fm.commit();
    }


}
