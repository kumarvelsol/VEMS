package igrand.com.vems.fragments;


import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import igrand.com.vems.R;
import in.aabhasjindal.otptextview.OTPListener;
import in.aabhasjindal.otptextview.OtpTextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForgotPAsswordOTPConfirmationFragment extends BottomSheetDialogFragment {

    private OtpTextView otpTextView;
    private Button mBtnConfirmOTP;
    String optText;
    public ForgotPAsswordOTPConfirmationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_forgot_password_otpconfirmation, container, false);
        otpTextView = v.findViewById(R.id.otp_view);
        mBtnConfirmOTP=(Button)v.findViewById(R.id.submit_btn_forgot_password_confirm_screen);
        otpTextView.setOtpListener(new OTPListener() {
            @Override
            public void onInteractionListener() {
                // fired when user types something in the Otpbox
            }
            @Override
            public void onOTPComplete(String otp) {
                // fired when user has entered the OTP fully.
                optText=otp;
                if (otp.equals("123456"))
                {
//                    NewPasswordCreationFragmaent fragment=new NewPasswordCreationFragment();
//                    fragment.show(getFragmentManager(),fragment.getTag());
//                    onDestroyView();
                }
                //Toast.makeText(getActivity(), "The OTP is " + otp,  Toast.LENGTH_SHORT).show();
            }
        });
        mBtnConfirmOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Perform the Operation OTP
                if (optText.equals("123456"))
                {
                    NewPasswordCreationFragment fragment=new NewPasswordCreationFragment();
                    fragment.show(getFragmentManager(),fragment.getTag());
                    onDestroyView();
                }
                else {
                    Toast.makeText(getActivity(), "Inavlid OTP", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }

}
