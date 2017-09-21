package com.ttn.aem.mockito.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * Sample workflow process that sets an <code>approve</code> property to the
 * payload based on the process argument value.
 */

/**
 * @author priyanka.a.biswal
 */
@SuppressWarnings("deprecation")
@Component
@Service
public class CustomWorkflowStep implements WorkflowProcess {
    /**
     * The logger.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(CustomWorkflowStep.class);

    /**
     * The Constant DESCRIPTION.
     */
    @Property(value = "Modifies the activationTime in jcr:content")
    static final String DESCRIPTION = Constants.SERVICE_DESCRIPTION;

    /**
     * The Constant VENDOR.
     */
    @Property(value = "dtranzTwo")
    static final String VENDOR = Constants.SERVICE_VENDOR;

    /**
     * The Constant LABEL.
     */
    @Property(value = "Pre Activation Timestamp Update")
    static final String LABEL = "process.label";

    /**
     * The Constant TYPE_JCR_PATH.
     */
    private static final String TYPE_JCR_PATH = "JCR_PATH";

    /**
     * The Constant ACTIVATION_TIME.
     */
    private static final String ACTIVATION_TIME = "activationTime";

    /**
     * The Constant DATE_FORMAT.
     */
    private static final String DATE_FORMAT = "yyyy.MM.dd.HH.mm.ss";

    /*
     * (non-Javadoc)
     *
     * @see
     * com.adobe.granite.workflow.exec.WorkflowProcess#execute(com.adobe.granite
     * .workflow.exec.WorkItem, com.adobe.granite.workflow.WorkflowSession,
     * com.adobe.granite.workflow.metadata.MetaDataMap)
     */
    @Override
    public void execute(WorkItem item, WorkflowSession session, MetaDataMap args)
            throws WorkflowException {
        WorkflowData workflowData = item.getWorkflowData();
        if (null != workflowData.getPayloadType()
                && workflowData.getPayloadType().equals(TYPE_JCR_PATH)) {
            String path = workflowData.getPayload().toString() + "/jcr:content";
            try {
                Session jcrSession = adaptTo(session);
                Node node = getItem(path, jcrSession);
                if (null != node) {
                    String currTimeStamp = new SimpleDateFormat(DATE_FORMAT)
                            .format(new Date());
                    node.setProperty(ACTIVATION_TIME, currTimeStamp);
                    jcrSession.save();
                }
            } catch (PathNotFoundException e) {
                LOGGER.error("Path not Found Exception for TimestampUpdateProcessStep"
                        + e);

            } catch (RepositoryException e) {
                LOGGER.error("PRepositoryException for TimestampUpdateProcessStep"
                        + e);

            }

        }
    }

    /**
     * Adapt to gets the JCR session.
     *
     * @param session the session
     * @return the session
     */
    public Session adaptTo(WorkflowSession session) {
        Session jcrSession = session.adaptTo(Session.class);
        return jcrSession;

    }

    /**
     * Gets the item.
     *
     * @param path       the path
     * @param jcrSession the jcr session
     * @return the item
     * @throws PathNotFoundException the path not found exception
     * @throws RepositoryException   the repository exception
     */
    public Node getItem(String path, Session jcrSession)
            throws RepositoryException {
        return (Node) jcrSession.getItem(path);

    }

}