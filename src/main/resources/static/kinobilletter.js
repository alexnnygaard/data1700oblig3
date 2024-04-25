


function formSubmit() {
    console.log("Vi er inne i formSubmit")
    const billetter = {
        film: $("#film").val(),
        antall: $("#antall").val(),
        fornavn: $("#fornavn").val(),
        etternavn: $("#etternavn").val(),
        telefon: $("#telefon").val(),
        epost: $("#epost").val()
    };

    console.log(billetter)

    const telefonRegex = /^[0-9]{3} [0-9]{2} [0-9]{3}|[0-9]{8}$/;
    if (!telefonRegex.test(billetter.telefon)) {
        alert("Vennligst skriv et gyldig telefonnummer (8 siffer)");
        return;
    }

    const epostRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!epostRegex.test(billetter.epost)) {
        alert("Vennligst skriv en gyldig epostadresse");
        return;
    }

    console.log(billetter)
    $.post("/lagre",billetter, function() {
        hentAlle()
        console.log("Vi er inne i post /lagre")

    });




}

function hentAlle() {
    $.get("/hentAlle", function (billettene) {
        formatBilletter(billettene);
    });
}

function formatBilletter(billetten) {
    let output = "<table><tr><th>Film</th><th>Antall</th><th>Fornavn</th>" +
        "<th>Etternavn</th><th>Telefonnummer</th><th>Epost</th></tr>";
    for (const billetter of billetten) {
        output += "<tr><td>" + billetter.film + "</td><td>" + billetter.antall + "</td><td>" + billetter.fornavn + "</td>" +
            "<td>" + billetter.etternavn + "</td><td>" + billetter.telefon + "</td><td>" + billetter.epost + "</td></tr>";
    }
    output += "</table>";
    $("#billettContainer").html(output);
    console.log("formatBilletter function called");
}

function slettAlle() {
    $.get("/slettAlle", function () {
        hentAlle();
    });
}