package diploma.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(generator = "post-generator")
    @GenericGenerator(name = "post-generator"
            ,strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "post_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "30"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private long postId;

    @Column(name = "date")
    @CreationTimestamp
    private LocalDateTime time;

    @Column(name = "message", length = 1000)
    private String message;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_owner")
    private User owner;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tred_Id")
    private Tred tred;


    public long getPostId() {
        return postId;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getLocalDateTIme() {
        return time;
    }

    public User getUser() {
        return owner;
    }

    public Tred getTred() {
        return tred;

    }


    public void setTime(LocalDateTime time) {
        this.time = time;

    }

    public void setOwner(User user) {
        owner = user;
    }

    public void setMessage(String message) {
        this.message = message;

    }

    public void setTred(Tred tred) {
        this.tred = tred;


    }

    public void setTred(String tred_id) {

        Tred local = new Tred();
        local.setTred_id(Long.parseLong(tred_id));
        this.tred=local;

    }

    public void setPostId(int i) {
        postId = i;

    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", time=" + time +
                ", message='" + message + '\'' +
                ", owner=" + owner +
                ", tred=" + tred +
                '}';
    }
}
