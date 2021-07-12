package diploma.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="section")
public class Section {
    @Id
    private long id;

    @OneToMany(mappedBy = "section")
    private List<Tred> treds;


    @Enumerated(EnumType.STRING)
    @Column(name="teg")
    private Tegs tegs;


    public long getId(){
        return id;

    }
    public List<Tred> getTreds(){
        return treds;
    }

    public void setId(int sectionId){
        this.id =sectionId;



    }

    public void set(Tegs teg ){
        tegs=teg;

    }

    public Tegs getTegs(){
        return tegs;
    }


    @Override
    public String toString() {
        return "Section{" +
                "sectionId=" + id +
                ", treds=" + treds +
                '}';
    }
}




