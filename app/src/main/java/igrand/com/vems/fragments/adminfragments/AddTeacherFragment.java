package igrand.com.vems.fragments.adminfragments;


import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import org.w3c.dom.Text;

import igrand.com.vems.R;
import igrand.com.vems.apppreferences.ApplicationPreferences;
import igrand.com.vems.responses.CommonResponse;
import igrand.com.vems.services.ApiService;
import igrand.com.vems.services.ServiceClient;
import params.com.stepview.StatusView;
import params.com.stepview.StatusViewScroller;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddTeacherFragment extends Fragment {
    LinearLayout mLayoutFirstStep,mLayoutSecondStep;
    TextInputEditText mFistLayoutInputFullName,mFistLayoutInputDesignation,mFistLayoutInputAcademicQualification,
            mFistLayoutInputProfessionalQualification,mFistLayoutInputMobileNo,mFistLayoutInputAlternativeMobileNo,
            mFistLayoutInputLandLineNo,mFistLayoutInputEmailAddress,mInputDateOfJoining;
    TextInputEditText mSecondLayoutInputDOB,mSecondLayoutInputPresentAddress,mSecondLayoutInputPermenantAddress,mSecondLayoutInputDOJ,
            mSecondLayoutInputBasicSalary,mSecondLayoutInputBanName,mSecondLayoutInputBankAccountNo,mSecondLayoutInputAadharNo;
    Spinner mFitstLayoutSpinnerTeacherCategory1, mFitstLayoutSpinnerTeacherCategory2,mFitstLayoutSpinnerTeacherGender,
            mFitstLayoutSpinnerBloodGroup;
    Button mBtnFirstLayoutNext,mBtnSecondLayoutSbmit;
    StatusViewScroller mStatusViewScroller;
    ApplicationPreferences preferences;
    String fullName,designation, teachingCategory1, teacheCategory2,academicQly,profQly,moble,alternativeMobile,landline,
            email, gender,joiningDate;
    String dob,presentAddress,permenantAddress, doj,basicSalary,bankName,accountNo, aadharNo, bloodGroup;
    ProgressDialog pd;
    public AddTeacherFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_add_teacher, container, false);
        initViews(v);
        mLayoutFirstStep.setVisibility(View.VISIBLE);
        mLayoutSecondStep.setVisibility(View.GONE);
        StatusView statusView=new StatusView(getActivity());
        statusView.setStepCount(1);
        mStatusViewScroller.setStatusView(statusView);
        return v;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initViews(View v){
        pd=new ProgressDialog(getActivity());
        pd.setTitle("Teacher Adding");
        pd.setMessage("Please Waiting.........!");
        pd.create();
        preferences=new ApplicationPreferences(getActivity());
        mStatusViewScroller=(StatusViewScroller)v.findViewById(R.id.add_teacher_step_count_status_view_controller);
        mLayoutFirstStep=(LinearLayout)v.findViewById(R.id.first_step_layout);
        mLayoutSecondStep=(LinearLayout)v.findViewById(R.id.second_step_layout);

        // First Step Components
        mFistLayoutInputFullName=(TextInputEditText)v.findViewById(R.id.add_teacher_first_layout_label_full_name);
        mFistLayoutInputDesignation=(TextInputEditText)v.findViewById(R.id.add_teacher_first_layout_label_designaton);
        mFistLayoutInputAcademicQualification=(TextInputEditText)v.findViewById(R.id.add_teacher_first_layout_label_academic_qly);
        mFistLayoutInputProfessionalQualification=(TextInputEditText)v.findViewById(R.id.add_teacher_first_layout_label_professional_qly);
        mFistLayoutInputMobileNo=(TextInputEditText)v.findViewById(R.id.add_teacher_first_layout_label_mobile);
        mFistLayoutInputAlternativeMobileNo=(TextInputEditText)v.findViewById(R.id.add_teacher_first_layout_label_alternative_mobile);
        mFistLayoutInputLandLineNo=(TextInputEditText)v.findViewById(R.id.add_teacher_first_layout_label_landline);
        mFistLayoutInputEmailAddress=(TextInputEditText)v.findViewById(R.id.add_teacher_first_layout_label_email);
        mFitstLayoutSpinnerTeacherCategory1=(Spinner)v.findViewById(R.id.add_teacher_first_layout_spinner_teacher_category1);
        mFitstLayoutSpinnerTeacherCategory2=(Spinner)v.findViewById(R.id.add_teacher_first_layout_spinner_teacher_category2);
        mFitstLayoutSpinnerTeacherGender=(Spinner)v.findViewById(R.id.dd_teacher_first_layout_spinner_teacher_gender);

        // Second Step Components

        mSecondLayoutInputDOB=(TextInputEditText)v.findViewById(R.id.add_teacher_second_layout_label_dob);
        mSecondLayoutInputPresentAddress=(TextInputEditText)v.findViewById(R.id.add_teacher_second_layout_label_present_address);
        mSecondLayoutInputPermenantAddress=(TextInputEditText)v.findViewById(R.id.add_teacher_second_layout_label_permenant_address);
        mSecondLayoutInputDOJ=(TextInputEditText)v.findViewById(R.id.add_teacher_second_layout_label_doj);
        mSecondLayoutInputBasicSalary=(TextInputEditText)v.findViewById(R.id.add_teacher_second_layout_label_basic_salary);
        mSecondLayoutInputBanName=(TextInputEditText)v.findViewById(R.id.add_teacher_second_layout_label_bank_name);
        mSecondLayoutInputBankAccountNo=(TextInputEditText)v.findViewById(R.id.add_teacher_second_layout_label_account_no);
        mSecondLayoutInputAadharNo=(TextInputEditText)v.findViewById(R.id.add_teacher_second_layout_label_aadhar);
        mFitstLayoutSpinnerBloodGroup=(Spinner)v.findViewById(R.id.add_teacher_second_layout_spinner_blood_group);
        
        // Button Components;
        
        mBtnFirstLayoutNext=(Button)v.findViewById(R.id.first_layout_next_btn);
        mBtnSecondLayoutSbmit=(Button)v.findViewById(R.id.second_layout_submit_btn);

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
                                              String landLine, String email,String gender,String dateOfJoining)
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
            Toast.makeText(getActivity(), "Please Select Teaching Category1", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (teachingCategory2.equals("Select Techer Category"))
        {
            Toast.makeText(getActivity(), "Please Select Teaching Category2", Toast.LENGTH_SHORT).show();
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
            Toast.makeText(getActivity(), "Please Select Gender", Toast.LENGTH_SHORT).show();
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
            Toast.makeText(getActivity(), "Please Select Blood Group", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
    private void validateFirstStep() {
         fullName=mFistLayoutInputFullName.getText().toString().trim();
         designation=mFistLayoutInputDesignation.getText().toString().trim();
         teachingCategory1=mFitstLayoutSpinnerTeacherCategory1.getSelectedItem().toString().trim();
         teacheCategory2=mFitstLayoutSpinnerTeacherCategory2.getSelectedItem().toString().trim();
         academicQly=mFistLayoutInputAcademicQualification.getText().toString().trim();
         profQly=mFistLayoutInputProfessionalQualification.getText().toString().trim();
         moble=mFistLayoutInputMobileNo.getText().toString().trim();
         alternativeMobile=mFistLayoutInputAlternativeMobileNo.getText().toString().trim();
        landline =mFistLayoutInputLandLineNo.getText().toString().trim();
        email= mFistLayoutInputEmailAddress.getText().toString().trim();
         gender=mFitstLayoutSpinnerTeacherGender.getSelectedItem().toString();
        if (!firstStepLayoutValidation(fullName,designation,teachingCategory1,teacheCategory2,academicQly,profQly,moble,alternativeMobile,
                landline,email,gender,joiningDate))
        {
            mLayoutFirstStep.setVisibility(View.GONE);
            mLayoutSecondStep.setVisibility(View.VISIBLE);
            StatusView statusView=new StatusView(getActivity());
            statusView.setStepCount(2);
            mStatusViewScroller.setStatusView(statusView);
        }
    }
    private void validateSecondStep()
    {
        dob=mSecondLayoutInputDOB.getText().toString().trim();
         presentAddress=mSecondLayoutInputPresentAddress.getText().toString().trim();
         permenantAddress=mSecondLayoutInputPermenantAddress.getText().toString().trim();
         doj=mSecondLayoutInputDOJ.getText().toString().trim();
         basicSalary=mSecondLayoutInputBasicSalary.getText().toString().trim();
         bankName=mSecondLayoutInputBanName.getText().toString().trim();
         accountNo=mSecondLayoutInputBankAccountNo.getText().toString().trim();
         aadharNo=mSecondLayoutInputAadharNo.getText().toString().trim();
         bloodGroup=mFitstLayoutSpinnerBloodGroup.getSelectedItem().toString().trim();
        if (!validateSecondStepLayout(dob,presentAddress,permenantAddress,doj,basicSalary,bankName,accountNo,aadharNo,bloodGroup))
        {
            addTeacherDataToServer(fullName,"125",designation,teachingCategory1,teacheCategory2,"777",landline,moble,alternativeMobile,academicQly,
                    profQly,email,gender,basicSalary,presentAddress,permenantAddress,doj,"sssdddd",dob,bankName,accountNo,aadharNo,
                    "ppp896322",bloodGroup);
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
    private void loadTeachersListFragment(Fragment fragment, int frameId){
        FragmentTransaction fm=getFragmentManager().beginTransaction();
        fm.replace(frameId,fragment);
        fm.commit();
    }
    private void addTeacherDataToServer(String name,String code,String designation,String cate1,String cat2,String shift, String contact_no,
                                        String mobile,String mobile1,String qly, String qly2, String email,String gender,String basic,
                                        String address,String address1,String joinDate,String photo,String dob,String bankame,
                                        String acNo,String aadharNo, String panNo,String bGroup){
        pd.show();


      Call<CommonResponse> addTecaherCall= ServiceClient.getApiClient().create(ApiService.class).addTeacher(name,code,designation,cate1,cat2,shift,contact_no,
                mobile,mobile1,qly,qly2,email,gender,basic,address,address1,joinDate,photo,dob,bankame,acNo,aadharNo,panNo,bGroup);


      String data=name+"----"+"111"+"----"+designation+"----"+cate1+"----"+cat2+"----"+shift+"----"+contact_no+"----"+mobile+"----"+
              mobile1+"----"+qly+"----"+qly2+"----"+email+"----"+gender+"----"+basic+"----"+address+"----"+address1+"----"+
              joinDate+"----"+photo+"----"+dob+"----"+bankame+"----"+acNo+"----"+aadharNo+"----"+bGroup;


        Log.e("passingData",data);
      addTecaherCall.enqueue(new Callback<CommonResponse>() {
          @Override
          public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
              if (response.isSuccessful()){
                  if (response.body().getStatus()==1)
                  {
                      Toast.makeText(getActivity(), "Teacher Added Successfully", Toast.LENGTH_SHORT).show();
                      emptyFirstLayoutFields();
                      emptySecondLayoutFields();
                      if (preferences.getLoginTYpe().equals(ApplicationPreferences.PRINCIPAL_LOGIN)) {
                          loadTeachersListFragment(new TeachersListFragment(), R.id.principal_home_frame_layout);
                      }
                      else if (preferences.getLoginTYpe().equals(ApplicationPreferences.ADMIN_LOGIN))
                      {
                          loadTeachersListFragment(new TeachersListFragment(),R.id.admin_home_frame_layout);
                      }
                      pd.dismiss();
                  }
                  else {
                      Toast.makeText(getActivity(), "Teacher Adding Falied", Toast.LENGTH_SHORT).show();
                      pd.dismiss();
                  }
              }
              else {
                  Toast.makeText(getActivity(), "Something Went Wrong Failure", Toast.LENGTH_SHORT).show();
                  pd.dismiss();
              }
          }

          @Override
          public void onFailure(Call<CommonResponse> call, Throwable t) {
              Toast.makeText(getActivity(), "Somethig Went Wrong", Toast.LENGTH_SHORT).show();
          }
      });

    }

}
