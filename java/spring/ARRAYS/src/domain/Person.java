package domain;

public class Person {
    
    private Long idPerson;
    private String name;
    private Double[] notes;

    public Person() {
    }

    public Person(Long idPerson, String name, Double[] notes) {
        this.idPerson = idPerson;
        this.name = name;
        this.notes = notes;
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double[] getNotes() {
        return notes;
    }

    public void setNotes(Double[] notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{");
        sb.append("idPerson=").append(idPerson);
        sb.append(", name=").append(name);
        sb.append(", notes=").append(notes);
        sb.append('}');
        return sb.toString();
    }
}
