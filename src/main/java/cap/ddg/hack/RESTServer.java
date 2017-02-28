package cap.ddg.hack;

public class RESTServer
{
    private String port;
    private String host;


    public RESTServer(String port, String host)
    {
        this.port = port;
        this.host = host;
    }

    public String getPort()
    {
        return port;
    }

    public String getHost()
    {
        return host;
    }
}