package diploma.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "client")
public class User implements UserDetails {

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(name = "sequence-generator"
            ,strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "8"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name = "client_id")
    private long idOwner;

    @Column(name = "ip")
    private String ip;


    @Column(name = "ban")
    boolean banned = false;


    @OneToMany(mappedBy = "owner")
    private List<Post> posts;


    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public void setIdOwner(long idOwner) {
        this.idOwner = idOwner;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public long getIdOwner() {
        return idOwner;

    }

    public boolean isBanned() {
        return banned;
    }

    public List<Post> getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "idOwner=" + idOwner +
                ", ip='" + ip + '\'' +
                ", banned=" + banned +
                ", posts=" + posts +
                ", role=" + role +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(role);


    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
