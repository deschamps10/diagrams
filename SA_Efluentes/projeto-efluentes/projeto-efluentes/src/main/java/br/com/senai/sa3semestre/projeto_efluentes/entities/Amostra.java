package br.com.senai.sa3semestre.projeto_efluentes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Amostra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAmostra;
    private LocalDate dataColeta;
    private String localColeta;
    private TipoEfluente tipoEfluente;
    private String parametroQuimico;

    public Amostra() {
    }

    public Amostra(Long idAmostra, LocalDate dataColeta, String localColeta, TipoEfluente tipoEfluente, String parametroQuimico) {
        this.idAmostra = idAmostra;
        this.dataColeta = dataColeta;
        this.localColeta = localColeta;
        this.tipoEfluente = tipoEfluente;
        this.parametroQuimico = parametroQuimico;
    }

    public Long getIdAmostra() {
        return idAmostra;
    }

    public void setIdAmostra(Long idAmostra) {
        this.idAmostra = idAmostra;
    }

    public LocalDate getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(LocalDate dataColeta) {
        this.dataColeta = dataColeta;
    }

    public String getLocalColeta() {
        return localColeta;
    }

    public void setLocalColeta(String localColeta) {
        this.localColeta = localColeta;
    }

    public TipoEfluente getTipoEfluente() {
        return tipoEfluente;
    }

    public void setTipoEfluente(TipoEfluente tipoEfluente) {
        this.tipoEfluente = tipoEfluente;
    }

    public String getParametroQuimico() {
        return parametroQuimico;
    }

    public void setParametroQuimico(String parametroQuimico) {
        this.parametroQuimico = parametroQuimico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amostra amostra = (Amostra) o;

        if (!idAmostra.equals(amostra.idAmostra)) return false;
        if (!Objects.equals(dataColeta, amostra.dataColeta)) return false;
        if (!Objects.equals(localColeta, amostra.localColeta)) return false;
        if (tipoEfluente != amostra.tipoEfluente) return false;
        return Objects.equals(parametroQuimico, amostra.parametroQuimico);
    }

    @Override
    public int hashCode() {
        int result = idAmostra.hashCode();
        result = 31 * result + (dataColeta != null ? dataColeta.hashCode() : 0);
        result = 31 * result + (localColeta != null ? localColeta.hashCode() : 0);
        result = 31 * result + (tipoEfluente != null ? tipoEfluente.hashCode() : 0);
        result = 31 * result + (parametroQuimico != null ? parametroQuimico.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Amostra{" +
                "idAmostra=" + idAmostra +
                ", dataColeta=" + dataColeta +
                ", localColeta='" + localColeta + '\'' +
                ", tipoEfluente=" + tipoEfluente +
                ", parametroQuimico='" + parametroQuimico + '\'' +
                '}';
    }
}
