
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class JdkWebService {

    public String doSomething(@WebParam(name="value", targetNamespace = "http://demo/", mode = WebParam.Mode.IN)String value) {
        return "Just do it," + value + "!";
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/fcstest/tool/com/demo.JdkWebService", new JdkWebService());
    }
}  