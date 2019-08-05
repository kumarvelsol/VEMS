package igrand.com.vems.activities.admin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import igrand.com.vems.R;
import igrand.com.vems.activities.AdminDashboardActivity;
import igrand.com.vems.activities.PrincipalDashboardActivity;
import igrand.com.vems.apppreferences.ApplicationPreferences;
import igrand.com.vems.fragments.adminfragments.TeachersListFragment;
import igrand.com.vems.helpers.AppConstants;
import igrand.com.vems.samplemodelclasses.AdminTeachersList;
import params.com.stepview.StatusView;
import params.com.stepview.StatusViewScroller;

public class AddTeacherActivty extends AppCompatActivity {
    LinearLayout mLayoutFirstStep,mLayoutSecondStep;
    TextInputEditText mFistLayoutInputFullName,mFistLayoutInputDesignation,mFistLayoutInputAcademicQualification,
            mFistLayoutInputProfessionalQualification,mFistLayoutInputMobileNo,mFistLayoutInputAlternativeMobileNo,
            mFistLayoutInputLandLineNo,mFistLayoutInputEmailAddress;
    TextInputEditText mSecondLayoutInputDOB,mSecondLayoutInputPresentAddress,mSecondLayoutInputPermenantAddress,mSecondLayoutInputDOJ,
            mSecondLayoutInputBasicSalary,mSecondLayoutInputBanName,mSecondLayoutInputBankAccountNo,mSecondLayoutInputAadharNo;
    Spinner mFitstLayoutSpinnerTeacherCategory1, mFitstLayoutSpinnerTeacherCategory2,mFitstLayoutSpinnerTeacherGender,
            mFitstLayoutSpinnerBloodGroup;
    Button mBtnFirstLayoutNext,mBtnSecondLayoutSbmit;
    StatusViewScroller mStatusViewScroller;
    ApplicationPreferences preferences;
    AdminTeachersList teacherData;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher_activty);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.pink_back_btn);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(android.R.color.transparent));
        initViews();
        mLayoutFirstStep.setVisibility(View.VISIBLE);
        mLayoutSecondStep.setVisibility(View.GONE);
        StatusView statusView=new StatusView(this);
        statusView.setStepCount(1);
        mStatusViewScroller.setStatusView(statusView);

        if (getIntent().getExtras().getBoolean(AppConstants.TEACHER_DATA_PASSED_OR_NOT))
        {
            teacherData=(AdminTeachersList)getIntent().getSerializableExtra(AppConstants.TEACHER_DATA_INTENT_KEY);

            assignDataToComponents(teacherData);
            mBtnSecondLayoutSbmit.setText("Update Teacher Details");
        }
    }



    private void initViews(){
        preferences=new ApplicationPreferences(this);
        mStatusViewScroller=(StatusViewScroller)findViewById(R.id.add_teacher_step_count_status_view_controller);
        mLayoutFirstStep=(LinearLayout)findViewById(R.id.first_step_layout);
        mLayoutSecondStep=(LinearLayout)findViewById(R.id.second_step_layout);

        // First Step Components
        mFistLayoutInputFullName=(TextInputEditText)findViewById(R.id.add_teacher_first_layout_label_full_name);
        mFistLayoutInputDesignation=(TextInputEditText)findViewById(R.id.add_teacher_first_layout_label_designaton);
        mFistLayoutInputAcademicQualification=(TextInputEditText)findViewById(R.id.add_teacher_first_layout_label_academic_qly);
        mFistLayoutInputProfessionalQualification=(TextInputEditText)findViewById(R.id.add_teacher_first_layout_label_professional_qly);
        mFistLayoutInputMobileNo=(TextInputEditText)findViewById(R.id.add_teacher_first_layout_label_mobile);
        mFistLayoutInputAlternativeMobileNo=(TextInputEditText)findViewById(R.id.add_teacher_first_layout_label_alternative_mobile);
        mFistLayoutInputLandLineNo=(TextInputEditText)findViewById(R.id.add_teacher_first_layout_label_landline);
        mFistLayoutInputEmailAddress=(TextInputEditText)findViewById(R.id.add_teacher_first_layout_label_email);
        mFitstLayoutSpinnerTeacherCategory1=(Spinner)findViewById(R.id.add_teacher_first_layout_spinner_teacher_category1);
        mFitstLayoutSpinnerTeacherCategory2=(Spinner)findViewById(R.id.add_teacher_first_layout_spinner_teacher_category2);
        mFitstLayoutSpinnerTeacherGender=(Spinner)findViewById(R.id.dd_teacher_first_layout_spinner_teacher_gender);

        // Second Step Components

        mSecondLayoutInputDOB=(TextInputEditText)findViewById(R.id.add_teacher_second_layout_label_dob);
        mSecondLayoutInputPresentAddress=(TextInputEditText)findViewById(R.id.add_teacher_second_layout_label_present_address);
        mSecondLayoutInputPermenantAddress=(TextInputEditText)findViewById(R.id.add_teacher_second_layout_label_permenant_address);
        mSecondLayoutInputDOJ=(TextInputEditText)findViewById(R.id.add_teacher_second_layout_label_doj);
        mSecondLayoutInputBasicSalary=(TextInputEditText)findViewById(R.id.add_teacher_second_layout_label_basic_salary);
        mSecondLayoutInputBanName=(TextInputEditText)findViewById(R.id.add_teacher_second_layout_label_bank_name);
        mSecondLayoutInputBankAccountNo=(TextInputEditText)findViewById(R.id.add_teacher_second_layout_label_account_no);
        mSecondLayoutInputAadharNo=(TextInputEditText)findViewById(R.id.add_teacher_second_layout_label_aadhar);
        mFitstLayoutSpinnerBloodGroup=(Spinner)findViewById(R.id.add_teacher_second_layout_spinner_blood_group);

        // Button Components;

        mBtnFirstLayoutNext=(Button)findViewById(R.id.first_layout_next_btn);
        mBtnSecondLayoutSbmit=(Button)findViewById(R.id.second_layout_submit_btn);

        // Button Click Initializations
        mBtnFirstLayoutNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateFirstStep();

            }
        });
        mBtnSecondLayoutSbmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateSecondStep();
            }
        });

    }


    private boolean firstStepLayoutValidation(String fullName,String designation,String teachingCategory1,String teachingCategory2,
                                              String academicQly,String professionalQly,String mobile,String alternativeMobile,
                                              String landLine, String email,String gender)
    {
        if (fullName.isEmpty())
        {
            mFistLayoutInputFullName.setError("Please Enter Your Name");
            mFistLayoutInputFullName.requestFocus();
            return true;
        }
        if (designation.isEmpty())
        {
            mFistLayoutInputDesignation.setError("Please Enter Your Designation");
            mFistLayoutInputDesignation.requestFocus();
            return true;
        }
        if (teachingCategory1.equals("Select Techer Category"))
        {
            Toast.makeText(this, "Please Select Teaching Category1", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (teachingCategory2.equals("Select Techer Category"))
        {
            Toast.makeText(this, "Please Select Teaching Category2", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (academicQly.isEmpty())
        {
            mFistLayoutInputAcademicQualification.setError("Please Enter Your Academic Qualification");
            mFistLayoutInputAcademicQualification.requestFocus();
            return true;
        }
        if (professionalQly.isEmpty())
        {
            mFistLayoutInputProfessionalQualification.setError("Please Enter Your Professional Qualification");
            mFistLayoutInputProfessionalQualification.requestFocus();
            return true;
        }
        if (mobile.isEmpty())
        {
            mFistLayoutInputMobileNo.setError("Please Enter Your Mobile");
            mFistLayoutInputMobileNo.requestFocus();
            return true;
        }
        if (alternativeMobile.isEmpty())
        {
            mFistLayoutInputAlternativeMobileNo.setError("Please Enter Your Alternative Mobile");
            mFistLayoutInputAlternativeMobileNo.requestFocus();
            return true;
        }
        if (email.isEmpty())
        {
            mFistLayoutInputEmailAddress.setError("Please Enter Your Email Address");
            mFistLayoutInputEmailAddress.requestFocus();
            return true;
        }
        if (gender.equals("Select Gender"))
        {
            Toast.makeText(this, "Please Select Gender", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    private boolean validateSecondStepLayout(String dob,String presentAddress,String permenantAddress,String doj,String basicSalary,
                                             String bankName,String bankAccountNumber,String aadharNumebr,String bloodGroup)
    {
        if (dob.isEmpty())
        {
            mSecondLayoutInputDOB.setError("Please Enter");
            mSecondLayoutInputDOB.requestFocus();
            return true;
        }
        if (presentAddress.isEmpty())
        {
            mSecondLayoutInputPresentAddress.setError("Please Enter");
            mSecondLayoutInputPresentAddress.requestFocus();
            return true;
        }
        if (permenantAddress.isEmpty())
        {
            mSecondLayoutInputPermenantAddress.setError("Please Enter");
            mSecondLayoutInputPermenantAddress.requestFocus();
            return true;
        }
        if (doj.isEmpty())
        {
            mSecondLayoutInputDOJ.setError("Please Enter");
            mSecondLayoutInputDOJ.requestFocus();
            return true;
        }
        if (basicSalary.isEmpty())
        {
            mSecondLayoutInputBasicSalary.setError("Please Enter");
            mSecondLayoutInputBasicSalary.requestFocus();
            return true;
        }
        if (bankName.isEmpty())
        {
            mSecondLayoutInputBanName.setError("Please Enter");
            mSecondLayoutInputBanName.requestFocus();
            return true;
        }
        if (bankAccountNumber.isEmpty())
        {
            mSecondLayoutInputBankAccountNo.setError("Please Enter");
            mSecondLayoutInputBankAccountNo.requestFocus();
            return true;
        }
        if (aadharNumebr.isEmpty())
        {
            mSecondLayoutInputAadharNo.setError("Please Enter");
            mSecondLayoutInputAadharNo.requestFocus();
            return true;
        }
        if (bloodGroup.isEmpty())
        {
            Toast.makeText(this, "Please Select Blood Group", Toast.LENGTH_SHORT).show();
            return true;
        }

        return false;
    }
    private void validateFirstStep() {
        String fullName=mFistLayoutInputFullName.getText().toString().trim();
        String designation=mFistLayoutInputDesignation.getText().toString().trim();
        String teachingCategory1=mFitstLayoutSpinnerTeacherCategory1.getSelectedItem().toString().trim();
        String teacheCategory2=mFitstLayoutSpinnerTeacherCategory2.getSelectedItem().toString().trim();
        String academicQly=mFistLayoutInputAcademicQualification.getText().toString().trim();
        String profQly=mFistLayoutInputProfessionalQualification.getText().toString().trim();
        String moble=mFistLayoutInputMobileNo.getText().toString().trim();
        String alternativeMobile=mFistLayoutInputAlternativeMobileNo.getText().toString().trim();
        String landline =mFistLayoutInputLandLineNo.getText().toString().trim();
        String email= mFistLayoutInputEmailAddress.getText().toString().trim();
        String gender=mFitstLayoutSpinnerTeacherGender.getSelectedItem().toString();
        if (!firstStepLayoutValidation(fullName,designation,teachingCategory1,teacheCategory2,academicQly,profQly,moble,alternativeMobile,
                landline,email,gender))
        {
            mLayoutFirstStep.setVisibility(View.GONE);
            mLayoutSecondStep.setVisibility(View.VISIBLE);
            StatusView statusView=new StatusView(this);
            statusView.setStepCount(2);
            mStatusViewScroller.setStatusView(statusView);
        }
    }
    private void validateSecondStep()
    {
        String dob=mSecondLayoutInputDOB.getText().toString().trim();
        String presentAddress=mSecondLayoutInputPresentAddress.getText().toString().trim();
        String permenantAddress=mSecondLayoutInputPermenantAddress.getText().toString().trim();
        String doj=mSecondLayoutInputDOJ.getText().toString().trim();
        String basicSalary=mSecondLayoutInputBasicSalary.getText().toString().trim();
        String bankName=mSecondLayoutInputBanName.getText().toString().trim();
        String accountNo=mSecondLayoutInputBankAccountNo.getText().toString().trim();
        String aadharNo=mSecondLayoutInputAadharNo.getText().toString().trim();
        String bloodGroup=mFitstLayoutSpinnerBloodGroup.getSelectedItem().toString().trim();
        if (!validateSecondStepLayout(dob,presentAddress,permenantAddress,doj,basicSalary,bankName,accountNo,aadharNo,bloodGroup))
        {
            Toast.makeText(this, "Teacher Added Successfully", Toast.LENGTH_SHORT).show();
            emptyFirstLayoutFields();
            emptySecondLayoutFields();
            if (preferences.getLoginTYpe().equals(ApplicationPreferences.PRINCIPAL_LOGIN)) {
                finish();
                startActivity(new Intent(this, PrincipalDashboardActivity.class));
            }
            else if (preferences.getLoginTYpe().equals(ApplicationPreferences.ADMIN_LOGIN))
            {
                finish();
                startActivity(new Intent(this, AdminDashboardActivity.class));
            }
        }
    }
    private void emptyFirstLayoutFields()
    {
        mFistLayoutInputFullName.setText("");
        mFistLayoutInputDesignation.setText("");
        mFitstLayoutSpinnerTeacherCategory1.setSelection(0);
        mFitstLayoutSpinnerTeacherCategory2.setSelection(0);
        mFistLayoutInputAcademicQualification.setText("");
        mFistLayoutInputProfessionalQualification.setText("");
        mFistLayoutInputMobileNo.setText("");
        mFistLayoutInputAlternativeMobileNo.setText("");
        mFistLayoutInputLandLineNo.setText("");
        mFistLayoutInputEmailAddress.setText("");
        mFitstLayoutSpinnerTeacherGender.setSelection(0);
    }
    private void emptySecondLayoutFields()
    {
        mSecondLayoutInputDOB.setText("");
        mSecondLayoutInputPresentAddress.setText("");
        mSecondLayoutInputPermenantAddress.setText("");
        mSecondLayoutInputDOJ.setText("");
        mSecondLayoutInputBasicSalary.setText("");
        mSecondLayoutInputBanName.setText("");
        mSecondLayoutInputBankAccountNo.setText("");
        mSecondLayoutInputAadharNo.setText("");
        mFitstLayoutSpinnerBloodGroup.setSelection(0);
    }
    private void assignDataToComponents(AdminTeachersList teacherData)
    {
        mFistLayoutInputFullName.setText(teacherData.getTeacherName());
        mFistLayoutInputDesignation.setText("Head Of Department");
        mFitstLayoutSpinnerTeacherCategory1.setSelection(1);
        mFitstLayoutSpinnerTeacherCategory2.setSelection(1);
        mFistLayoutInputAcademicQualification.setText(teacherData.getTeacherQly());
        mFistLayoutInputProfessionalQualification.setText(teacherData.getTeacherQly());
        mFistLayoutInputMobileNo.setText(teacherData.getTeacherMobile());
        mFistLayoutInputAlternativeMobileNo.setText(teacherData.getTeacherMobile());
        mFistLayoutInputLandLineNo.setText("040-12345698");
        mFistLayoutInputEmailAddress.setText("No Email");
        mFitstLayoutSpinnerTeacherGender.setSelection(1);

        mSecondLayoutInputDOB.setText("01/06/1989");
        mSecondLayoutInputPresentAddress.setText("Address");
        mSecondLayoutInputPermenantAddress.setText("Address");
        mSecondLayoutInputDOJ.setText(teacherData.getTeacherJoiningDate());
        mSecondLayoutInputBasicSalary.setText("00.00");
        mSecondLayoutInputBanName.setText("My Bank Name");
        mSecondLayoutInputBankAccountNo.setText("111111111111111111");
        mSecondLayoutInputAadharNo.setText("321654897856");
        mFitstLayoutSpinnerBloodGroup.setSelection(1);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                super.onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
