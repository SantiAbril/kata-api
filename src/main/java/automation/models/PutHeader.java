package automation.models;

import java.util.HashMap;
import java.util.Map;
import automation.models.headers.Header;


public class PutHeader {

    private PutHeader(){}

    public static final Map<String,String> headers = new HashMap<>();

    public static Map <String,String> basicHeaders (){

        headers.put(Header.CONTENT_TYPE.putHeader(), Header.CONTENT_TYPE.getValue());

        return headers;
    }
}
