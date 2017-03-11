package simple.action;

import Service.SessionService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class indexAction extends ActionSupport{
    String SimpleUsername;
    @Autowired
    SessionService sessionService;

    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    public String getSimpleUsername() {
        return SimpleUsername;
    }

    public void setSimpleUsername(String simpleUsername) {
        SimpleUsername = simpleUsername;
    }

    @Override
    public String execute() throws Exception {
        if(SimpleUsername != null){
            return ERROR;
        }
        else {
            if(sessionService.getSessionValue("account")!=null) return ERROR;
            return SUCCESS;
        }
    }
}
