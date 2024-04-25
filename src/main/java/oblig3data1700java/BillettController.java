package oblig3data1700java;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class BillettController {

    @Autowired
    BillettRepository rep;


    @PostMapping("/lagre")
    public void lagreBillett(Billett billetter) {
        System.out.println("Vi er på backend /lage");
        System.out.println(billetter.getAntall());
        System.out.println(billetter.getFornavn());
        System.out.println(billetter.getFilm());
        System.out.println(billetter.getEtternavn());
        System.out.println(billetter.getEpost());
        System.out.println(billetter.getTelefon());




        rep.lagreBillett(billetter);
    }

    @GetMapping("/hentAlle")
    public List<Billett> hentAlle() {
        return rep.hentAlle();
    }

    @GetMapping("/slettAlle")
    public void slettAlle() {
        rep.slettAlle();
    }
}

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class BillettController {

    @Autowired
    BillettRepository rep;

    @PostMapping("/lagre")
    public void lagreBillett(Billett billetter, HttpServletResponse res) throws IOException {
        boolean ok = rep.lagreBillett(billetter);
        if (!ok) {
            res.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "En feil har oppstått, forsøk igjen senere");
        }
    }

    @GetMapping("/hentAlle")
    public List<Billett> hentAlle(HttpServletResponse res) throws IOException {
        List<Billett> billettene = rep.hentAlle();
        if (billettene == null) {
            res.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "En feil har oppstått, forsøk igjen senere");
        }
        return billettene;
    }
    @GetMapping("/slettAlle")
    public void slettAlle(HttpServletResponse res) throws IOException {
        boolean ok = rep.slettAlle();
        if (!ok){
            res.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Database-feil, forsøk igjen senere");
        }
    }
}

*/

