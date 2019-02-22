# DnD_Cyber

Seguendo la falsariga del metodo CRUD, la mappatura per ciascuna sevlet / operazione è indicata come qui di seguito:

    - L'url è strutturato come {host}/{nome entità}-{nome operazione};
    
    - Le entità che è possibile gestire sono : adventure (per le entità Adventure), player (per le entità Player),
    dm (per le entità Dm), char_class (per le entità CharacterClass), character (per le entità Character);
    
    - Le operazioni che è possibile eseguire sono : create (GET visualizza il form per l'inserimento di una nuova entità, POST
    consente di inviare i dati inseriti per poterli processare nel servlet), index (GET visualizza tutti gli elementi di una
    particolare entità, POST ne visualizza nel dettaglio solo uno nel particolare), update (GET visualizza il form per la 
    modifica di una data entità, POST processa i dati al servlet), delete (GET cancella l'entità indicata e tutte le sue
    occorrenze);
    
Le relazioni tra le varie Entità è indicata qui di seguito:

    - Un DM può gestire una o più ADVENTURE (Avventura o Campagna) [relazione 1 - N];
    
    - Un PLAYER (Giocatore) può possedere uno o più CHARACTER (Personaggi) [relazione 1 - N];
    
    - Un CHARACTERCLASS (Classe) può essere usata da uno o più CHARACTER (Personaggi) [relazione 1 - N];
    
    - Una RACE (Razza) può essere usata da uno o più CHARACTER (Personaggi) [relazione 1 - N];
    
    - Un ADVENTURE può essere giocata con uno o più CHARACTER. Allo stesso tempo, un CHARACTER può giocare, allo stesso tempo
    , una o più ADVENTURE [relazione N - N, gestita nel DB dalla tabella "party").
