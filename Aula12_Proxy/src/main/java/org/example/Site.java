package org.example;

import java.util.Arrays;
import java.util.List;

public class Site implements ISite{

    private String link;
    private String nome;
    public Site(String link){
        this.link = link;
        Site objeto = BD.getSite(link);
        this.nome = objeto.nome;
    }

    public Site(String link, String nome) {
        this.link = link;
        this.nome = nome;
    }

    public String getLink() {
        return link;
    }

    @Override
    public List<String> obterDadosSite() {
        return Arrays.asList(this.nome);
    }

    @Override
    public String obterAcesso(Acesso acesso) {
        return "Acesso concedido!";
    }
}
