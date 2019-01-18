package matuszewski.pracownia.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;


@XmlRootElement
@Entity
@Table(schema = "public", catalog = "postgres")
public class Users {

    private Long libarycardnumber;
    private String firstname;
    private String lastname;

    public Users(Long libarycardnumber, String firstname, String lastname) {
        this.libarycardnumber = libarycardnumber;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Users() {
    }

    @Id
    @Column(name = "libarycardnumber")
    public Long getLibarycardnumber() {
        return libarycardnumber;
    }

    public void setLibarycardnumber(Long libarycardnumber) {
        this.libarycardnumber = libarycardnumber;
    }

    @Basic
    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
