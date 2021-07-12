package diploma.model;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="tred")
public class Tred {


    @Id
    private long tred_id;


    @Column(name="name",length=10000)
    String name;

    @Column(name="info",length=10000)
    String info;

    @OneToMany(mappedBy = "tred")
    private List<Post> treds;


    @ManyToOne
    @JoinColumn(name="section_id")
    private Section section;

    public long getTred_id() {
        return tred_id;
    }

    public void setTred_id(long tred_id) {
        this.tred_id = tred_id;
    }



    public List<Post> getTreds(){
        return treds;
    }
    public Section getSection(){

        return section;
    }


    public void setTreds( List<Post>  treds ){
        this.treds=treds;
    }

    public void setSection(Section section){
        this.section = section;

    }

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public String getInfo(){
        return info;

    }

    public void setInfo(String info){
        this.info=info;
    }

    @Override
    public String toString() {
        return "Tred{" +
                "tredId=" + tred_id +
                ", treds=" + treds +
                ", section=" + section +
                '}';
    }
}
