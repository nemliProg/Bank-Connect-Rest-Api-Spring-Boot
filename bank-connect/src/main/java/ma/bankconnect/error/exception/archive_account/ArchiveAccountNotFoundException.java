package ma.bankconnect.error.exception.archive_account;

import ma.bankconnect.error.exception.NotFoundException;

public class ArchiveAccountNotFoundException extends NotFoundException {

    public ArchiveAccountNotFoundException() {
    }

    public ArchiveAccountNotFoundException(String message) {
        super(message);
    }

    public ArchiveAccountNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArchiveAccountNotFoundException(Throwable cause) {
        super(cause);
    }

    public ArchiveAccountNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
