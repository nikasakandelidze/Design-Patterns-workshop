package MyConnectionObjectPool;

public class CustomConnection {
    private String url;
    private String status;

    public CustomConnection(String url, String status) {
        this.url = url;
        this.status = status;
    }

    public CustomConnection() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
