package models;

import java.util.List;

public class Materia {
    
    private String nameMateria;
    private List<Double> listNotes;
    private Double finalNote;

    public Materia() {
    }

    public Materia(String nameMateria, List<Double> listNotes, Double finalNote) {
        this.nameMateria = nameMateria;
        this.listNotes = listNotes;
        this.finalNote = finalNote;
    }

    public Double getFinalNote() {
        return finalNote;
    }

    public void setFinalNote(Double finalNote) {
        this.finalNote = finalNote;
    }

    public String getNameMateria() {
        return nameMateria;
    }

    public void setNameMateria(String nameMateria) {
        this.nameMateria = nameMateria;
    }

    public List<Double> getListNotes() {
        return listNotes;
    }

    public void setListNotes(List<Double> listNotes) {
        this.listNotes = listNotes;
    }

    
}
