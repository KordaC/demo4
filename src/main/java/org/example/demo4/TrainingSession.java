package org.example.demo4;

import java.time.LocalDateTime;

public class TrainingSession {
    private String subtitle;
    private String coach;
    private LocalDateTime time;


    public TrainingSession(String subtitle, String coach, LocalDateTime time) {
        this.subtitle = subtitle;
        this.coach = coach;
        this.time = time;


    }


    public String getSubtitle() { return subtitle; }
    public String getCoach() { return coach; }
    public LocalDateTime getTime() { return time; }

    @Override
    public String toString() {
        return subtitle + " с тренером " + coach + " в " + time.toLocalDate() + " " + time.toLocalTime();
    }
}
