package es.senac.br.helpdesk_danieloaski.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

import androidx.annotation.NonNull;

public class FechadosChamados {


    @SerializedName("descricao")
    @Expose
    private String descricao;
    private String solucao;
    private String status;

    public FechadosChamados() {
    }

    public FechadosChamados(String descricao, String solucao, String status) {

        this.descricao = descricao;
        this.solucao = solucao;
        this.status = status;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @NonNull
    @Override
    public String toString() {
        return "Chamado{" + "status" + status +
                "solucao" + solucao +
                ", descricao='" + descricao +
                '}';
    }
}


