public class FactsJSON {
    private String createdAt;

    private Boolean deleted;

    private Integer __v;

    @Override
    public String toString() {
        return "Fact{" +
                "createdAt='" + createdAt + '\'' +
                ", deleted=" + deleted +
                ", __v=" + __v +
                ", _id='" + _id + '\'' +
                ", text='" + text + '\'' +
                ", source='" + source + '\'' +
                ", used=" + used +
                ", type='" + type + '\'' +
                ", user='" + user + '\'' +
                ", status=" + status +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }

    private String _id;

    private String text;

    private String source;

    private Boolean used;

    private String type;

    private String user;

    private Status status;

    private String updatedAt;

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer get__v() {
        return this.__v;
    }

    public void set__v(Integer __v) {
        this.__v = __v;
    }

    public String get_id() {
        return this._id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Boolean getUsed() {
        return this.used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static class Status {
        private Boolean verified;

        private Integer sentCount;

        public Boolean getVerified() {
            return this.verified;
        }

        public void setVerified(Boolean verified) {
            this.verified = verified;
        }

        public Integer getSentCount() {
            return this.sentCount;
        }

        public void setSentCount(Integer sentCount) {
            this.sentCount = sentCount;
        }
    }
}