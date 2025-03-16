package automation.models.headers;


public enum Header {

    CONTENT_TYPE("content-type", "application/json");

    public String putHeader() {
        return header;
    }

    public String getValue() {
        return value;
    }

    private final String header;
    private final String value;

    private Header(String header, String value) {
        this.header = header;
        this.value = value;
    }
}