package ro.fithubhome.exception;

public class EntityNotFoundException extends Exception {
    public EntityNotFoundException(String entityType) {
        super(entityType + " not found");
    }
}
