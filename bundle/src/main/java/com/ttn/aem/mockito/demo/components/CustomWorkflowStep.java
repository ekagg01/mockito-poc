package com.ttn.aem.mockito.demo;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sample workflow process that Sends the email on content deletion
 *
 * @author Ekta Aggarwal
 */
@Component
@Service
public class CustomWorkflowStep implements WorkflowProcess {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(CustomWorkflowStep.class);

    @Property(value = "Send mail on node deletion")
    static final String DESCRIPTION = Constants.SERVICE_DESCRIPTION;

    @Property(value = "TTN")
    static final String VENDOR = Constants.SERVICE_VENDOR;

    @Property(value = "Email send on node deletion")
    static final String LABEL = "process.label";

    @Reference
    private MessageGatewayService messageGatewayService;

    public void execute(WorkItem item, WorkflowSession wfsession, MetaDataMap args) throws WorkflowException {

        try {
            //Declare a MessageGateway service
            MessageGateway<Email> messageGateway;

            //Set up the Email message
            Email email = new SimpleEmail();

            //Set the mail values
            String emailToRecipients = "ekta.aggarwal@tothenew.com";
            String emailCcRecipients = "ek.agg01@gmail.com";

            email.addTo(emailToRecipients);
            email.addCc(emailCcRecipients);
            email.setSubject("AEM Custom Step");
            email.setFrom("no-reply@tothenew.com");
            email.setMsg("This message is to inform you that the CQ content has been deleted");

            //Inject a MessageGateway Service and send the message
            messageGateway = messageGatewayService.getGateway(Email.class);

            // Check the logs to see that messageGateway is not null
            messageGateway.send((Email) email);
        } catch (Exception e) {
            LOGGER.error("Exception in custom email workflow", e);
        }
    }

}
