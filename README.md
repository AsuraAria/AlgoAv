
# Projet Algorithmique avancée 2020/2021  
  
Le présent projet, c'est déroulé dans le cadre de la formation d'ingénieur informatique de deuxième année dispensée par l'ENSSAT.  
  
Le sujet de ce projet est l’algorithmique avancée. Il s'agit d'un travail en collaboration par [Lilian Savona](https://github.com/LilianSav) et [Marc Vacquant](https://github.com/AsuraAria).  
  
# Sujet  
  
Le problème ici étudié est celui du rendu de monnaie. Le but est d'étudier la résolution de celui-ci à travers les algorithmes d'essais successifs, dynamiques, et gloutons.  
Le sujet du projet peut être trouvé sous format pdf dans le dossier **Doc** sous la dénomination **Mini-projet_Algo-av_20-21.pdf**  
## Introduction  
  
Le projet est fait sous Java 15, et est décomposé en trois packages : A, B, C chacun correspondant à une partie du sujet respectivement l'algorithme d'essais successifs, dynamiques, et gloutons. Il existe également un dossier **resources** comprenant la classe d'objet **CoinList** commune aux trois implémentations.  
  
  
## La ressources CoinList  
  
Dans un premier temps avant de passer à la réflexion des différents algorithmes nous avons définie une classe objet **CoinList** servant à manipuler le problème. Celle-ci est composée de deux tableaux de flot nommée **valueList** et **coinList** ainsi que d'un float **totalValue**, les deux tableaux correspondent respectivement à la liste des différentes pièces disponibles et le second à une liste de pièces, le float correspond à la valeur totale de cette liste de pièces.  
  
## Package A, B, et C  
  
Chacun de ces packages est indépendant des autres et ne nécessite que la classe CoinList pour fonctionner. Dans chaque package, se trouve un fichier main.java (mainA.java, mainB.java, mainC.java) qui peut être exécutée comme un simple fichier Java. Chaque package contient également un autre fichier Java qui implémente l'algorithme voulu.  
  
## Conclusion  
  
Un compte-rendu du projet est disponible dans le dossier **resources**.  
Il est très important de noter que l'implémentation n'a pas été étudiée pour vérifier qu'elle soit optimale, ni même développer à base d'algorithmes ayant été prouver comme optimaux. Ainsi, en cas de réutilisation de ce code, il est vivement conseillé d'adapter le code au besoin, d'autant plus s'il est prévu de changer de langage de programmation ou si la version de Java utilisée est devenue obsolète.
