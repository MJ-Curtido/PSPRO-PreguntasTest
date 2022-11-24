/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package preguntasTest.clases;

import java.util.Objects;

/**
 *
 * @author Dam
 */
public class Opcion {
    private Integer id;
    private static int idTemp = 0;
    private Integer idPregunta;
    private String texto;
    private Boolean correcta;

    public Opcion(Integer idPregunta, Boolean correcta, String texto) {
        this.idPregunta = idPregunta;
        this.texto = texto;
        this.correcta = correcta;
        this.id = this.idTemp;
        this.idTemp++;
    }
    
    public Opcion(Integer id, Integer idPregunta, Boolean correcta, String texto) {
        this.idPregunta = idPregunta;
        this.texto = texto;
        this.correcta = correcta;
        this.id = id;
    }
    
    public Opcion() {
        
    }

    public String getRespuesta() {
        return texto;
    }

    public Boolean getCorrecta() {
        return correcta;
    }

    public void setRespuesta(String respuesta) {
        this.texto = respuesta;
    }

    public void setCorrecta(Boolean correcta) {
        this.correcta = correcta;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getIdPregunta() {
        return this.idPregunta;
    }

    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Opcion other = (Opcion) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Opcion:" + "id=" + id + ", idPregunta=" + idPregunta + ", respuesta=" + texto + ", correcta=" + correcta;
    }
}