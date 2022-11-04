package preguntasTest.clases;

public class Pregunta {
    private Integer id;
    private boolean acertada;
    private String pregunta;

    public Pregunta(String pregunta) {
        this.pregunta = pregunta;
        this.acertada = false;
    }

    public boolean isAcertada() {
            return acertada;
    }

    public void setAcertada(boolean acertada) {
            this.acertada = acertada;
    }

    public String getPregunta() {
            return pregunta;
    }

    public void setPregunta(String pregunta) {
            this.pregunta = pregunta;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pregunta other = (Pregunta) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Pregunta:" + "id=" + id + ", acertada=" + acertada + ", pregunta=" + pregunta;
    }
}
