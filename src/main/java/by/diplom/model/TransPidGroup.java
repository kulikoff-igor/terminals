package by.diplom.model;

import javax.persistence.*;

/**
 * Created by admin on 05.04.2018.
 */
@Entity
@Table(name = "trans_pid_group")
public class TransPidGroup {
    private int idTransPidGroup;
    private Integer idPidGroup;
    private Integer idTransScheme;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_TRANS_PID_GROUP", nullable = false)
    public int getIdTransPidGroup() {
        return idTransPidGroup;
    }

    public void setIdTransPidGroup(int idTransPidGroup) {
        this.idTransPidGroup = idTransPidGroup;
    }

    @Basic
    @Column(name = "ID_PID_GROUP", nullable = true)
    public Integer getIdPidGroup() {
        return idPidGroup;
    }

    public void setIdPidGroup(Integer idPidGroup) {
        this.idPidGroup = idPidGroup;
    }

    @Basic
    @Column(name = "ID_TRANS_SCHEME", nullable = true)
    public Integer getIdTransScheme() {
        return idTransScheme;
    }

    public void setIdTransScheme(Integer idTransScheme) {
        this.idTransScheme = idTransScheme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransPidGroup that = (TransPidGroup) o;

        if (idTransPidGroup != that.idTransPidGroup) return false;
        if (idPidGroup != null ? !idPidGroup.equals(that.idPidGroup) : that.idPidGroup != null) return false;
        if (idTransScheme != null ? !idTransScheme.equals(that.idTransScheme) : that.idTransScheme != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTransPidGroup;
        result = 31 * result + (idPidGroup != null ? idPidGroup.hashCode() : 0);
        result = 31 * result + (idTransScheme != null ? idTransScheme.hashCode() : 0);
        return result;
    }
}
