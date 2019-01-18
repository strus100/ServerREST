package matuszewski.pracownia.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
@Table(name = "libaryborrows", schema = "public", catalog = "postgres")
public class Borrows {
    private Long borrowid;
    private boolean isborrow;

    public Borrows(Long borrowid, boolean isborrow) {
        this.borrowid = borrowid;
        this.isborrow = isborrow;
    }

    public Borrows() {
    }

    @Id
    @Column(name = "borrowid")
    public Long getBorrowid() {
        return borrowid;
    }

    public void setBorrowid(Long borrowid) {
        this.borrowid = borrowid;
    }

    @Basic
    @Column(name = "isborrow")
    public boolean isIsborrow() {
        return isborrow;
    }

    public void setIsborrow(boolean isborrow) {
        this.isborrow = isborrow;
    }
}
