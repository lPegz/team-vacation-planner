package br.pegz.tvp.security.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.boot.actuate.audit.listener.AuditApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LoginAttemptLogger {



    @EventListener
    public void auditEventHappened(
            AuditApplicationEvent auditApplicationEvent) {
        AuditEvent auditEvent = auditApplicationEvent.getAuditEvent();
        WebAuthenticationDetails details = (WebAuthenticationDetails) auditEvent.getData().get("details");
        log.debug("Principal {} - {} \n  Remote IP address: {} \n  Session Id: {}\n  Request Url: {}",
                auditEvent.getPrincipal(), auditEvent.getType(), details.getRemoteAddress(),
                details.getSessionId(), auditEvent.getData().get("requestUrl"));

    }
}
