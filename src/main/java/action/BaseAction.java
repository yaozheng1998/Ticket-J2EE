package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author YZ
 * @Date 2018/2/26
 */
public class BaseAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware,ServletContextAware{
    public HttpServletRequest request;
    public HttpServletResponse response;
    public ServletContext context;
    public Map sessionMap;

    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request=httpServletRequest;
    }

    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response=httpServletResponse;
    }

    public void setSession(Map<String, Object> map) {
        this.sessionMap=map;
    }

    public void setServletContext(ServletContext servletContext) {
        this.context=servletContext;
    }
}
