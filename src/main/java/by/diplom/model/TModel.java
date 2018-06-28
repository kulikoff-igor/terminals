package by.diplom.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by admin on 05.04.2018.
 */
@Entity
@Table(name = "t_model")
public class TModel {
    private int idTModel;
    private String description;


    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_T_MODEL", nullable = false)
    public int getIdTModel() {
        return idTModel;
    }

    public void setIdTModel(int idTModel) {
        this.idTModel = idTModel;
    }


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

        TModel tModel = (TModel) o;

        if (idTModel != tModel.idTModel) return false;
        if (description != null ? !description.equals(tModel.description) : tModel.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTModel;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
