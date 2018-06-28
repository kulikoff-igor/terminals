package by.diplom.model;

import javax.persistence.*;

/**
 * Created by admin on 05.04.2018.
 */
@Entity
@Table(name = "terminals")
public class Terminals {
    private int idTerminals;
    private TModel tModel;
    private MerchTab merchTab;
    private TermsDesc termsDesc;
    private String termName;
    private String addr1;
    private String addr2;
    private int zipcode;


    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_TERMINALS", nullable = false)
    public int getIdTerminals() {
        return idTerminals;
    }

    public void setIdTerminals(int idTerminals) {
        this.idTerminals = idTerminals;
    }

    @OneToOne()
    @JoinColumn(name = "ID_T_MODEL", nullable = false)
    public TModel getTModel() {
        return tModel;
    }

    public void setTModel(TModel tModel) {
        this.tModel = tModel;
    }
    @OneToOne()
    @JoinColumn(name = "ID_MERCH_TAB", nullable = false)
    public MerchTab getMerchTab() {
        return merchTab;
    }

    public void setMerchTab(MerchTab merchTab) {
        this.merchTab = merchTab;
    }
    @OneToOne()
    @JoinColumn(name = "ID_TERM_DESC", nullable = false)
    public TermsDesc getTermsDesc() {
        return termsDesc;
    }

    public void setTermsDesc(TermsDesc termsDesc) {
        this.termsDesc = termsDesc;
    }

    @Column(name = "TERM_NAME", nullable = false, length = 22)
    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    @Column(name = "ADDR_1", nullable = false, length = 40)
    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    @Column(name = "ADDR_2", nullable = false, length = 15)
    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    @Column(name = "ZIPCODE", nullable = false, precision = 0)
    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }



}
