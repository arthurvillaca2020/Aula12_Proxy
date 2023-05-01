package org.example;

import javax.swing.*;
import java.util.List;

public class SiteProxy implements ISite{
    private Site site;
    private String link;
    public SiteProxy(String link) {
        this.link = link;
    }

    @Override
    public List<String> obterDadosSite() {
        if (this.site == null) {
            this.site = new Site(this.link);
        }
        return this.site.obterDadosSite();
    }

    @Override
    public String obterAcesso(Acesso acesso) {
        if (!acesso.isAdministrador()) {
            throw new IllegalArgumentException("Acesso não autorizado!");
        }
        if (this.site == null) {
            this.site = new Site(this.link);
        }
        return this.site.obterAcesso(acesso);
    }
}
