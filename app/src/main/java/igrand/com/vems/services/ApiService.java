package igrand.com.vems.services;

import igrand.com.vems.responses.CommonResponse;
import igrand.com.vems.responses.HomeScreenCountResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("teachers-view.php")
    Call<CommonResponse> getTeacheresList();

    @FormUrlEncoded
    @POST("teachers-add.php")
    Call<CommonResponse> addTeacher(@Field("name") String name,@Field("code") String code,
                                    @Field("designation") String designation,@Field("cat1") String cat1,
                                    @Field("cat2") String cat2 ,@Field("shift") String shift,
                                    @Field("contact_no") String contact_no,@Field("mobile1") String mobile1,
                                    @Field("mobile2") String mobile2,@Field("qualification") String qualification,
                                    @Field("qualification1") String qualification1,@Field("email") String email,
                                    @Field("gender") String gender, @Field("basic") String basic,
                                    @Field("address") String address,@Field("address1") String address1,
                                    @Field("join_date") String join_date ,@Field("photo") String photo,
                                    @Field("dob") String dob,@Field("bank_name") String bank_name,
                                    @Field("ac_no") String ac_no,@Field("aadhar_no") String aadhar_no,
                                    @Field("pan_no") String pan_no,@Field("bgroup") String bgroup);

    @GET("dashboard.php")
    Call<HomeScreenCountResponse> getHomeScreenCounts();
}
