package igrand.com.vems.responses;

import java.io.Serializable;
import java.util.List;

@lombok.Data
public class CommonResponse implements Serializable
{
    private List<Data> data;

    private String message;

    private int status;
}
