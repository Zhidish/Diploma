package diploma.model;


import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity

public class Answer {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name="answer_to")
    long answer_to;




    @ManyToOne
    @JoinColumn(name="answer_id")
    Post replier_id;

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answer_to=" + answer_to +
                ", replier_id=" + replier_id +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAnswer_to() {
        return answer_to;
    }

    public void setAnswer_to(long answer_to) {
        this.answer_to = answer_to;
    }

    public Post getReplier_id() {
        return replier_id;
    }

    public void setReplier_id(Post replier_id) {
        this.replier_id = replier_id;
    }
}
