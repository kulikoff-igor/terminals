package by.diplom.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by admin on 05.04.2018.
 */
@Entity
@Table(name = "pid_group")
public class PidGroup {
    private int idPidGroup;
    private int numberPidGroup;
    private Terminals terminals;
    private List<TransScheme> transSchemeList;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_PID_GROUP", nullable = false)
    public int getIdPidGroup() {
        return idPidGroup;
    }

    public void setIdPidGroup(int idPidGroup) {
        this.idPidGroup = idPidGroup;
    }

    @OneToOne()
    @JoinColumn(name = "ID_TERMINALS", nullable = false)
    public Terminals getTerminals() {
        return terminals;
    }

    public void setTerminals(Terminals terminals) {
        this.terminals = terminals;
    }

    @Basic
    @Column(name = "Number_PID_GROUP", nullable = false)
    public int getNumberPidGroup() {
        return numberPidGroup;
    }

    public void setNumberPidGroup(int numberPidGroup) {
        this.numberPidGroup = numberPidGroup;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "trans_pid_group",
            joinColumns = @JoinColumn(name = "id_pid_group"),
            inverseJoinColumns = @JoinColumn(name = "id_trans_scheme")
    )
    public List<TransScheme> getTransSchemeList() {
        return transSchemeList;
    }

    public void setTransSchemeList(List<TransScheme> transSchemeList) {
        this.transSchemeList = transSchemeList;
    }


}
