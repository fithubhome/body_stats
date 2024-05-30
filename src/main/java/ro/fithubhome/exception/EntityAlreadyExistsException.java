package ro.fithubhome.exception;

public class EntityAlreadyExistsException extends Exception {
    public EntityAlreadyExistsException(String entityType) {
        super(entityType + " already exists");
    }
}
