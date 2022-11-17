package preguntasTest.clases;

public class Pregunta {
    private Integer id;
    private static int idTemp = 0;
    private boolean acertada;
    private String texto;
    private Integer idUsuario;

    public Pregunta(String texto, Integer idUsuario) {
        this.texto = texto;
        this.acertada = false;
        this.id = this.idTemp;
        this.idTemp++;
        this.idUsuario = idUsuario;
    }
    
    public Pregunta() {
        
    }

    public boolean isAcertada() {
            return acertada;
    }

    public void setAcertada(boolean acertada) {
            this.acertada = acertada;
    }

    public String getPregunta() {
            return texto;
    }

    public void setPregunta(String pregunta) {
            this.texto = pregunta;
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
        return "Pregunta:" + "id=" + id + ", acertada=" + acertada + ", pregunta=" + texto;
    }
}
