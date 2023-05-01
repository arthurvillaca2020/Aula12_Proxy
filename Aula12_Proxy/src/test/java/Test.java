import org.example.Acesso;
import org.example.BD;
import org.example.Site;
import org.example.SiteProxy;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class Test {
    @BeforeEach
    void setUp() {
        BD.addSite(new Site("https://www.youtube.com", "Youtube"));
        BD.addSite(new Site("https://store.steampowered.com/?l=portuguese", "Loja Steam"));
    }

    @org.junit.jupiter.api.Test
    void deveRetornarDadosDoSite() {
        SiteProxy site = new SiteProxy("https://www.youtube.com");

        assertEquals(Arrays.asList("Youtube"), site.obterDadosSite());
    }

    @org.junit.jupiter.api.Test
    void devePermitirAcesso() {
        Acesso acesso = new Acesso("Marco Antonio", true);
        SiteProxy site = new SiteProxy("https://store.steampowered.com/?l=portuguese");

        assertEquals("Acesso concedido!", site.obterAcesso(acesso));
    }

    @org.junit.jupiter.api.Test
    void deveNegarAcesso() {
        try {
            Acesso acesso = new Acesso("Arthur", false);
            SiteProxy site = new SiteProxy("https://store.steampowered.com/?l=portuguese");

            site.obterAcesso(acesso);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Acesso não autorizado!", e.getMessage());
        }

    }
}
