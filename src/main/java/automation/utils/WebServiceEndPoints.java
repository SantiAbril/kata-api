package automation.utils;

public enum WebServiceEndPoints {

    URI(Endpoint.CARTS_SUCCESS, Endpoint.CARTS_FAILED, Endpoint.CARTS_SUCCESS_PUT_DELETE);

    private final String url1;
    private final String url2;
    private final String url3;


    WebServiceEndPoints(String url1, String url2, String url3) {
        this.url1 = url1;
        this.url2 = url2;
        this.url3 = url3;

    }

    public String getUrl() {
        return url1;
    }
    public String postUrl() {
        return url2;
    }
    public String putUrl() {
        return url3;
    }

}
