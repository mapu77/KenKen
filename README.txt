KenKen - grup 12
Oriol Capo
Eduard Maura
Jordi Pont
Jan Teruel
------------------------------------------------------------------------

0. OBSERVACIONS
Cal mantenir un ordre en les execucions dels drivers, sinó, els 
resultats del driverRanking seràn diferents als que nosaltres hem 
generat i comprovat en els jocs de prova (Joc_Ranking_Input.txt i 
Joc_Ranking_Output.txt respectivament)

Per això és indispensable que durant el testeig executi primer el 
driverRanking.

Si el que vol veure es com canvia el ranking a mesura que jugui partides
i generi nous kenkens, llavos si que el pot executar després, però
llavors el nostre joc de proves quedarà inutilitzat

------------------------------------------------------------------------
1. ORGANITZACIO
Despres d'haver descomprimit l'arxiu KenKen_g21.zip trobarà 3 drivers
.jar, diferents arxius de jocs de prova i un directori data.

És crucial que el directori data es trobi al mateix directori que la 
resta de drivers.

També trobarà l'arxiu KenKen.pdf on s'explica la composició de cada
driver, el joc de proves adient per provar-lo i el que es pot provar
amb la seva execució.

------------------------------------------------------------------------
2. EXECUCIO
Per executar un driver, només cal que es situi al directori on es troben
els drivers i executi
	$> java -jar <nom_driver>.jar
	
Si el que desitja es redirigir l'entrada i la sortida, cal fer:
	$> java -jar <nom_driver>.jar < arxiu_entrada.txt > arxiu_sortida.txt
