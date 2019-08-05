package igrand.com.vems.fragments;


import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import igrand.com.vems.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForgotPasswordFragment extends BottomSheetDialogFragment {
    TextInputEditText mInputUserMobileNumber;
    Button mBtnForgotPasswordNext;


    public ForgotPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_forgot_password, container, false);
        initviews(v);
        return v;
    }
    private void initviews(View v)
    {
        mInputUserMobileNumber=(TextInputEditText)v.findViewById(R.id.forgot_password_mobile_number_input);
        mBtnForgotPasswordNext=(Button) v.findViewById(R.id.forgot_password_fragment_login_btn);
        mBtnForgotPasswordNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mInputUserMobileNumber.getText().toString().trim().isEmpty())
                {
                    if (mInputUserMobileNumber.getText().toString().trim().length()==10)
                    {

                        ForgotPAsswordOTPConfirmationFragment dialog=new ForgotPAsswordOTPConfirmationFragment();
                        dialog.show(getFragmentManager(),dialog.getTag());
                        onDestroyView();
                    }
                    else {
                        mInputUserMobileNumber.setError("Mobile Must be 10 digits");
                        mInputUserMobileNumber.requestFocus();
                    }
                }
                else {
                    mInputUserMobileNumber.setError("Mobile is Empty");
                    mInputUserMobileNumber.requestFocus();
                }
            }
        });
    }


}
