package oclock.oclock.domain;

import java.util.Date;
import java.util.Optional;

public class Plan {
    private Long id;
    private String content;
    private boolean isCompleted = false;
    //private boolean pushAlarm = false;
    private Date beginTime;
    private Date endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

//    public boolean isPushAlarm() {
//        return pushAlarm;
//    }
//
//    public void setPushAlarm(boolean pushAlarm) {
//        this.pushAlarm = pushAlarm;
//    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


}
