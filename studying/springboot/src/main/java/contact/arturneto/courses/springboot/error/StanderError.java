package contact.arturneto.courses.springboot.error;

import lombok.*;

@Getter@Setter
public class StanderError {
    private String title;
    private int status;
    private String message;
    private long timestamp;
    private String classPath;


    public static final class Builder {
        private String title;
        private int status;
        private String message;
        private long timestamp;
        private String classPath;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
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

        public StanderError build() {
            StanderError standerError = new StanderError();
            standerError.setTitle(title);
            standerError.setStatus(status);
            standerError.setMessage(message);
            standerError.setTimestamp(timestamp);
            standerError.setClassPath(classPath);
            return standerError;
        }
    }
}
