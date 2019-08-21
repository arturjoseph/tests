package contact.arturneto.courses.springboot.error;

import lombok.Getter;

@Getter
public class ValidationError extends StanderError {

    private String field;
    private String fieldMessage;


    public static final class Builder {
        private String field;
        private String title;
        private String fieldMessage;
        private int status;
        private String message;
        private long timestamp;
        private String classPath;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder field(String field) {
            this.field = field;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder fieldMessage(String fieldMessage) {
            this.fieldMessage = fieldMessage;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder classPath(String classPath) {
            this.classPath = classPath;
            return this;
        }

        public ValidationError build() {
            ValidationError validationError = new ValidationError();
            validationError.setTitle(title);
            validationError.setStatus(status);
            validationError.setMessage(message);
            validationError.setTimestamp(timestamp);
            validationError.setClassPath(classPath);
            validationError.field = this.field;
            validationError.fieldMessage = this.fieldMessage;
            return validationError;
        }
    }
}
