package org.example;

import java.util.List;

public interface ISite {
    List<String> obterDadosSite();
    String obterAcesso(Acesso acesso);
}
