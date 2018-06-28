package by.diplom.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by admin on 05.04.2018.
 */
@Entity
@Table(name = "trans_scheme")
public class TransScheme {
    private int idTransScheme;
    private int numberTransScheme;
    private TransTypeDesc transTypeDesc;
    private String description;
  /*  private List<PidGroup> pidGroupList;

    @ManyToMany(mappedBy = "transSchemeList")
    public List<PidGroup> getPidGroupList() {
        return pidGroupList;
    }

    public void setPidGroupList(List<PidGroup> pidGroupList) {
        this.pidGroupList = pidGroupList;
    }

*/


    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_TRANS_SCHEME", nullable = false)
    public int getIdTransScheme() {
        return idTransScheme;
    }

    public void setIdTransScheme(int idTransScheme) {
        this.idTransScheme = idTransScheme;
    }

    @OneToOne()
    @JoinColumn(name = "ID_TRANS_TYPE_DESC", nullable = false)
    public TransTypeDesc getTransTypeDesc() {
        return transTypeDesc;
    }

    public void setTransTypeDesc(TransTypeDesc transTypeDesc) {
        this.transTypeDesc = transTypeDesc;
    }

    @Basic
    @Column(name = "NUMBER_TRANS_SCHEME", nullable = false)
    public int getNumberTransScheme() {
        return numberTransScheme;
    }

    public void setNumberTransScheme(int numberTransScheme) {
        this.numberTransScheme = numberTransScheme;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
