package by.diplom.model;

import javax.persistence.*;

/**
 * Created by admin on 05.04.2018.
 */
@Entity
@Table(name = "trans_type_desc")
public class TransTypeDesc {
    private int idTransTypeDesc;
    private String description;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_TRANS_TYPE_DESC", nullable = false)
    public int getIdTransTypeDesc() {
        return idTransTypeDesc;
    }

    public void setIdTransTypeDesc(int idTransTypeDesc) {
        this.idTransTypeDesc = idTransTypeDesc;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = false, length = 20)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransTypeDesc that = (TransTypeDesc) o;

        if (idTransTypeDesc != that.idTransTypeDesc) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTransTypeDesc;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
