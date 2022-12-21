package ma.bankconnect.error.exception.agent;

import ma.bankconnect.error.exception.NotFoundException;

public class AgentNotFoundException extends NotFoundException {

    public AgentNotFoundException() {
    }

    public AgentNotFoundException(String message) {
        super(message);
    }

    public AgentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AgentNotFoundException(Throwable cause) {
        super(cause);
    }

    public AgentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
