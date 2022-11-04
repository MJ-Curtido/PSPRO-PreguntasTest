/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package preguntasTest.clases;

/**
 *
 * @author Dam
 */
public class Opcion {
    private Integer id;
    private Integer idPregunta;
    private String respuesta;
    private Boolean correcta;

    public Opcion(Integer idPregunta, Boolean correcta, String respuesta) {
        this.idPregunta = idPregunta;
        this.respuesta = respuesta;
        this.correcta = correcta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public Boolean getCorrecta() {
        return correcta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
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
}