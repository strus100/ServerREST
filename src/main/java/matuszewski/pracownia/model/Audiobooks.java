package matuszewski.pracownia.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Audiobooks {

    @Id
    private Long bookid;
    private String author;
    private String title;

    public Audiobooks() {
    }

    public Audiobooks(Long bookid, String author, String title) {
        this.bookid = bookid;
        this.author = author;
        this.title = title;
    }

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}