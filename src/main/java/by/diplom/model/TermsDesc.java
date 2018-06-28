package by.diplom.model;

import javax.persistence.*;

/**
 * Created by admin on 05.04.2018.
 */
@Entity
@Table(name = "terms_desc")
public class TermsDesc {
    private int idTermDesc;
    private String description;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_TERM_DESC", nullable = false)
    public int getIdTermDesc() {
        return idTermDesc;
    }

    public void setIdTermDesc(int idTermDesc) {
        this.idTermDesc = idTermDesc;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = false, length = 10)
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

        TermsDesc termsDesc = (TermsDesc) o;

        if (idTermDesc != termsDesc.idTermDesc) return false;
        if (description != null ? !description.equals(termsDesc.description) : termsDesc.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTermDesc;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
