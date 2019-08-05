package igrand.com.vems.responses;

import retrofit2.http.GET;

@lombok.Data
public class HomeScreenCountResponse
{

    public Data data;

    public String message;

    public int status;
}
