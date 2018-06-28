package by.diplom.model;

import javax.persistence.*;

/**
 * Created by admin on 05.04.2018.
 */
@Entity
@Table(name = "term_currency")
public class TermCurrency {
    private int idTermCurrency;
    private Terminals terminals;
    private String curr1;
    private String curr2;
    private String curr3;
    private String curr4;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_TERM_CURRENCY", nullable = false)
    public int getIdTermCurrency() {
        return idTermCurrency;
    }

    public void setIdTermCurrency(int idTermCurrency) {
        this.idTermCurrency = idTermCurrency;
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
    @Column(name = "CURR_1", nullable = false, length = 11)
    public String getCurr1() {
        return curr1;
    }

    public void setCurr1(String curr1) {
        this.curr1 = curr1;
    }

    @Basic
    @Column(name = "CURR_2", nullable = true, length = 11)
    public String getCurr2() {
        return curr2;
    }

    public void setCurr2(String curr2) {
        this.curr2 = curr2;
    }

    @Basic
    @Column(name = "CURR_3", nullable = true, length = 11)
    public String getCurr3() {
        return curr3;
    }

    public void setCurr3(String curr3) {
        this.curr3 = curr3;
    }

    @Basic
    @Column(name = "CURR_4", nullable = true, length = 11)
    public String getCurr4() {
        return curr4;
    }

    public void setCurr4(String curr4) {
        this.curr4 = curr4;
    }


}
