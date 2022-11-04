package oclock.oclock.domain;

import java.util.Date;
import java.util.Optional;

public class Plan {
    private String content;
    private boolean isCompleted = false;
    private boolean pushAlarm = false;
    private Optional<Date> time = null;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public boolean isPushAlarm() {
        return pushAlarm;
    }

    public void setPushAlarm(boolean pushAlarm) {
        this.pushAlarm = pushAlarm;
    }

    public Optional<Date> getTime() {
        return time;
    }

    public void setTime(Optional<Date> time) {
        this.time = time;
    }
}
