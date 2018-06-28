package by.diplom.model;

import javax.persistence.*;

/**
 * Created by admin on 05.04.2018.
 */
@Entity
@Table(name = "key_tab")
public class KeyTab {
    private int idKeyTab;
    private Terminals terminals;
    private int keyAuthorization;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_KEY_TAB", nullable = false)
    public int getIdKeyTab() {
        return idKeyTab;
    }

    public void setIdKeyTab(int idKeyTab) {
        this.idKeyTab = idKeyTab;
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
    @Column(name = "KEY_AUTHORIZATION", nullable = false, precision = 0)
    public int getKeyAuthorization() {
        return keyAuthorization;
    }

    public void setKeyAuthorization(int keyAuthorization) {
        this.keyAuthorization = keyAuthorization;
    }


}
