package ch.axa.punchclock.models;
 
import java.time.LocalDateTime;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
 
@Entity
@Table(name = "entry")
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    @Column(name= "check_in", nullable = false)
    private LocalDateTime  check_in;
 
    @Column(name = "duration")
    private int duration;
 
    @Column(name = "description",length = 5000)
    private String descripiton;
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public LocalDateTime getCheck_in() {
        return check_in;
    }
 
    public void setCheck_in(LocalDateTime check_in) {
        this.check_in = check_in;
    }
 
    public int getDuration() {
        return duration;
    }
 
    public void setDuration(int duration) {
        this.duration = duration;
    }
 
    public String getDescripiton() {
        return descripiton;
    }
 
    public void setDescripiton(String descripiton) {
        this.descripiton = descripiton;
    }
 
}
 