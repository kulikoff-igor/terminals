package by.diplom.model;

import javax.persistence.*;

/**
 * Created by admin on 05.04.2018.
 */
@Entity
@Table(name = "merch_tab")
public class MerchTab {
    private int idMerchTab;
    private String merchName;
    private String addr1;
    private String addr2;
    private int zipcode;
    private String phone;
    private String eMail;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_MERCH_TAB", nullable = false)
    public int getIdMerchTab() {
        return idMerchTab;
    }

    public void setIdMerchTab(int idMerchTab) {
        this.idMerchTab = idMerchTab;
    }

    @Column(name = "MERCH_NAME", nullable = false, length = 25)
    public String getMerchName() {
        return merchName;
    }

    public void setMerchName(String merchName) {
        this.merchName = merchName;
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

    @Column(name = "PHONE", nullable = false, length = 13)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "E_MAIL", nullable = false, length = 30)
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }


}
