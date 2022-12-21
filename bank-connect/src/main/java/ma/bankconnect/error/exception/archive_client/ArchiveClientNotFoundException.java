package ma.bankconnect.error.exception.archive_client;

import ma.bankconnect.error.exception.NotFoundException;

public class ArchiveClientNotFoundException extends NotFoundException {
    public ArchiveClientNotFoundException() {
        super();
    }

    public ArchiveClientNotFoundException(String message) {
        super(message);
    }

    public ArchiveClientNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArchiveClientNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ArchiveClientNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
