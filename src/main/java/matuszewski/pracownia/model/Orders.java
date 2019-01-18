package matuszewski.pracownia.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;


@XmlRootElement
@Entity
@Table(name = "libaryorders", schema = "public", catalog = "postgres")
public class Orders {
    private Long orderid;
    private String author;
    private String title;

    public Orders(Long orderid, String author, String title) {
        this.orderid = orderid;
        this.author = author;
        this.title = title;
    }

    public Orders() {
    }

    @Id
    @Column(name = "orderid")
    public Long getOrderid() {
        return orderid;
    }


    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
