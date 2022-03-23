For å fullføre laben, ber vi deg om å svare på følgende spørsmål. Svar på spørsmålene ved å fylle ut denne filen.

## Hva syntes du om denne semesteroppgaven? Har du forslag til hvordan den kan gjøres bedre eller enklere?

Gøy oppgave, eg skulle komt i gang litt tidligere. Likte ikke at det var forelesning på kodekveld, det ødela arbeidsflyten helt. Noe forklaring var forvirrende, men eg klarer ikke å finne noe spesifikt. 

## Hvor i koden din benytter du deg av gjenbruk av kode? Er det noen steder du føler du ikke klarte å gjenbruke kode på en god måte?

Bra:
    Føler at det er mange korte metoder, som bruker hjelpemetoder. Har litt gjenbruk, for eksempel la eg inn at nye klosser blir generert i gluePiece, i stedet for å skapes etterpå. 


Dårlig:
    Kunne godt ha skrevet en sjekkOmLedigPlassUnder metode, siden det var flere metoder som hadde hatt nytte av den. Eller bare en sjekkOmLovligFlytt funksjon, som ligner på legalMove metoden, men som tar deltaX og deltaY som argumenter, i stedet for en PieceShape. 

## Hvilke grep gjør vi for å øke modulariteten i koden? Gi noen eksempeler.

I TetrisView tar metoden drawBoardWithPad (forenklet navn på drawBoardWithBottomRightPadding) en iterable som argument. Dette gjør at man kan bruke samme metoden til å tegne både brettet som ligger under, og den nye brikken som blir styrt, ved å gi to forskjellige iterabler. 

Grid brukes kun som TetrisBoard, så det er strengt talt ikke nødvendig å ha både Grid og TetrisBoard. Men Grid kan brukes til andre formål også, for eksempel kan man lage et lite Grid til høyre for spillbrettet for å vise neste brikke. 

Metodene i TetrisBoard for å fjerne fulle rekker er bra strukturert, og oversiktlige. Eg vil si de er bra lagt opp til å skrive flere lignende metoder, slik som hvis man skal lage et tospiller spill der den ene spillerens rader blir flyttet til den andre spillerens brett, så kan de lett endres til at killRow kan flytte rader oppover i stedet. 