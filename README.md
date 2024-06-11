Tic Tac Toe Applicatie
Deze applicatie is een eenvoudige Tic Tac Toe-game met een gebruikersregistratie- en inlogsysteem en een leaderboard om de top scores te bekijken.

Functies
Registratie en Inloggen:

Gebruikers kunnen zich registreren met een gebruikersnaam, wachtwoord en geboortedatum.
Gebruikers kunnen inloggen met hun gebruikersnaam en wachtwoord.
Spel:

Start een nieuw spel Tic Tac Toe.
De huidige speler (X of O) voert een celnummer (1-9) in om een zet te doen.
Het bord wordt bijgewerkt en de spelstatus wordt gecontroleerd (winnaar of gelijkspel).
De score van de gebruiker wordt opgeslagen in de database.
Leaderboard:

Bekijk de top 10 scores van alle gebruikers.
Elke gebruiker wordt slechts één keer weergegeven met hun hoogste score.
Gebruik
Registreren:

Voer optie 1 in om te registreren.
Geef een gebruikersnaam, wachtwoord en geboortedatum op.
Inloggen:

Voer optie 2 in om in te loggen.
Geef uw geregistreerde gebruikersnaam en wachtwoord op.
Start nieuw spel:

Na inloggen of registreren, voer optie 1 in om een nieuw spel te starten.
Voer een celnummer (1-9) in om een zet te doen.
Het spel eindigt wanneer een speler wint of wanneer het bord vol is (gelijkspel).
Bekijk top scores:

Voer optie 2 in om de top 10 scores te bekijken.
Afsluiten:

Voer optie 3 in om de applicatie af te sluiten.
Databaseconfiguratie
De applicatie maakt gebruik van een MySQL-database. Zorg ervoor dat de database correct is ingesteld met de volgende configuratie:

URL: jdbc:mysql://MSI:3306/tic_tac_toe
Gebruiker: root
Wachtwoord:
Database Tabellen
users:

user_id (INT, PRIMARY KEY, AUTO_INCREMENT)
username (VARCHAR)
password (VARCHAR)
birthdate (DATE)
scores:

score_id (INT, PRIMARY KEY, AUTO_INCREMENT)
user_id (INT, FOREIGN KEY verwijzend naar users.user_id)
score (INT)
Afhankelijkheden
Java
MySQL
Installatie
Clone of download de broncode.
Stel de MySQL-database in en zorg ervoor dat de configuratie in Database.java correct is.
Compileer en voer de applicatie uit.
Auteur
Gemaakt door Rushil Ganpat.
