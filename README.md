INF3135 : TP1
AZIZ SALAH
1. Objectifs pédagogiques du travail
— Maitriser la manipulation des pointeurs et leur arithmétique ;
— La saisie des données à partir d’un fichier ;
— Découpage fonctionnel et composition ;
— Gestion des erreurs.
2. Description du problème
Étant donné un fichier d’entiers représentant un tableau 2D, nous voulons dupliquer certaines lignes ou
colonnes du tableau et afficher le résultat à l’écran.
3. Page man de la commande dup
Nom
---
dup -- duplique des lignes ou des colonnes dans un fichier de données
et affiche le résultat
SYNOPSIS
--------
dup <fichier> <commande>
DESCRIPTION
-----------
«dup» considère le fichier <fichier> comme un tableau d’entiers 2D et permet son extension en dupliquant
des lignes ou bien des colonnes dictées par la <commande> fournie. La duplication d’une ligne donne
lieu à une nouvelle ligne insérée après la dernière ligne. De même la duplication d’une colonne donne lieu
à une nouvelle colonne après la dernière la colonne.
<fichier> : le nom d’un fichier de données qui va représenter le tableau 2D. Nous supposons que le
tableau 2D d’entiers est représenté par un fichier texte. Les lignes du fichiers contiennent un nombre
variable d’entiers. Le fichier de données représente un tableau 2D n×m où n est le nombre de lignes
du fichier qui contiennent au moins un entier alors que m est le nombre d’entiers de la ligne qui en
contient le plus. Le fichier de données peut comporter des lignes vides d’entiers celles-ci sont ignorées
et ne représentent aucune ligne dans le tableau 2D. Toute ligne du fichier qui comporte moins que m
entiers est complétée par des zéros pour former une ligne du tableau 2D.
Date: A14.
1
INF3135 : TP1 AZIZ SALAH
Vous pouvez supposer que les fichiers de données utilisés ne comportent que des entiers séparés
par des blancs.
<commande> : a l’une des deux formes suivantes :
-C <liste> : où <liste> indique la liste des colonnes à dupliquer.
-L <liste> : où <liste> indique la liste des lignes à dupliquer .
<liste> : peut être vide ou composée d’un ou plusieurs domaines séparés par un ou plusieurs espaces.
Un élément dans <liste> représente un domaine qui fait référence aux lignes ou au colonnes du
tableau 2D provenant du fichier <fichier>. Les lignes ou les colonnes qui sont dans l’un des
domaines seront dupliqués dans l’ordre de leurs apparitions et ajoutés à la fin du tableau 2D final
qui sera affiché. Les numéros de lignes ou de colonnes qui sont inexistants dans le tableau 2D
provenant du fichier <fichier> sont ignorés et cela ne constitue pas une erreur à signaler.
En supposant que <num>, <num1> et <num2> sont des entiers positifs, les formats permis des
domaines dans <list> sont :
<num> : num représente le domaine singleton contenant num c’est à dire l’ensemble {<num>} ;
<num1>-<num2> : représente le domaine des entiers de <num1> à <num2> inclus représentant ainsi
l’ensemble {<num1>,<num1>+1,...,<num2>}. Un domaine <num1>-<num2> tel que <num1> est
strictement supérieur à <num2> est considéré vide et donc ignoré sans mention d’erreur.
<num>- : représente le domaine des entiers supérieurs ou égals à <num> qui est équivalent à
l’ensemble {<num>, <num>, .., MAX} avec MAX est le numéro de colonne si "-C" est utilisé ou de
ligne le plus élevé dans <fichier> si "-L" est utilisé.
-<num> : représente le domaine 0-<num>.
On suppose aussi que les numérotations des colonnes et des lignes commencent de zéro.
La syntaxe acceptée par le programme dup peut être résumée selon la forme BNF
(voir http://en.wikipedia.org/wiki/Backus-Naur_Form) :
Syntaxe d’une exécution du programme dup où <fichier> représente le nom d’un fichier:
"./dup"(<blanc>+)<fichier>(<blanc>+)<commande>
<commande> ::= ("-L"|"-C") ((<blanc>+) <domaine>)*
<blanc>::=" "
<domaine> ::= <num> | ("-"<num>) | (<num>"-") | (<num>"-"<num>)
<num> ::= <chiffre>+
<chiffre> ::= "0"|"1"|"2"|"3"|"4"|"5"|"6"|"7"|"8"|"9"
2
INF3135 : TP1 AZIZ SALAH
4. Exemple d’exécution
Voici le fichier test01.txt comme exemple de fichiers de données à fournir au programme dup
7 8 4 -2 3
1
6
2 5 1 8
Un ligne du fichier est supposée vide si elle ne comporte aucun entier. Ansi, ce fichier comporte 4 lignes
non vides. La ligne «16 8 4 -2 3» comporte 5 entiers et représente la ligne avec le plus d’entiers. Ainsi le
tableau 2D que ce fichier représente est le tableau 4 x 5 suivant :
7 8 4 -2 3
1 0 0 0 0
6 0 0 0 0
2 5 1 8 0
Voici une session d’essaie exécutée sur le serveur malt :
(1) Inspection du contenu du fichier test01.txt
malt > cat test01.txt
7 8 4 -2 3
1
2 5 1 8
malt > gcc -Wall -std=c99 dup.c util.c -o dup
Il faudrait faire attention et ne pas utiliser des fichiers édités sous Windows mais plutôt des fichiers
édités sous Unix car dans ce cas la fin d’une ligne est repérée par le caractère ’\n’. Faites attention
à la dernière ligne. Celle-ci devrait aussi se terminer avec ’\n’
(2) Appel à dup sans commande
malt > ./dup test01.txt
7 8 4 -2 3
1 0 0 0 0
6 0 0 0 0
2 5 1 8 0
Le programme dup n’a reçu aucune commande et donc il affiche le tableau 2D construit à partir du
fichier test01.txt
(3) Duplication des colonnes 0, 1 et 2
malt > ./dup test01.txt -C 0-2
7 8 4 -2 3 7 8 4
1 0 0 0 0 1 0 0
6 0 0 0 0 6 0 0
2 5 1 8 0 2 5 1
La commande -C 0-2 a permis la duplication des colonnes 0, 1 et 2
(4) Duplication des lignes 1, 2 et 3
3
INF3135 : TP1 AZIZ SALAH
malt > ./dup test01.txt -L 1-
7 8 4 -2 3
1 0 0 0 0
6 0 0 0 0
2 5 1 8 0
1 0 0 0 0
6 0 0 0 0
2 5 1 8 0
Le domaine 1- dans cet exemple fait référence aux lignes 1, 2 et 3
(5) Exemple montrant le respect de l’ordre d’une commande
malt > ./dup test01.txt -L 3 1 2 1
7 8 4 -2 3
1 0 0 0 0
6 0 0 0 0
2 5 1 8 0
2 5 1 8 0
1 0 0 0 0
6 0 0 0 0
1 0 0 0 0
On voit bien que l’ordre des références a été respecté. De plus dans cette exemple on peut aussi voir
que la ligne 1 a été insérée deux fois car elle a été référencée deux fois.
(6) Cet exemple a pour but de vous rappeler que les numéros de ligne ou de colonne font référence aux
lignes et aux colonnes du tableau 2D provenant du fichier et non pas celui dans lequel des insertion
ont été effectuées.
malt > ./dup test01.txt -L 3 4
7 8 4 -2 3
1 0 0 0 0
6 0 0 0 0
2 5 1 8 0
2 5 1 8 0
La ligne 4 étant inexistante dans la tableau 2D du fichier, la référence 4 a été ignorée. On voit aussi
qu’il n’y a pas de message d’erreur.
(7) Un exemple de cas d’erreur
malt > ./dup test01.txt -L -1-2
Erreur de syntaxe dans un domaine.
5. Exigences non fonctionnelles
5.1. Gestion de l’allocation dynamique. Le programme doit s’adapter dynamiquement avec la taille
des données en utilisant l’allocation dynamique. Tout espace alloué dynamiquement doit être libéré dès
qu’il n’est plus requis.
4
INF3135 : TP1 AZIZ SALAH
5.2. Gestion des erreurs. Tous les messages d’erreurs doivent être écrits sur le canal d’erreurs stderr
seulement en utilisant la fonction signaler_erreur fournie. Seules les erreurs considérées par la fonction
signaler_erreur sont à traiter dans votre programme. Le déclenchement de n’importe laquelle de ces
erreurs entraine l’arrêt du programme. Le programme suppose que les données du fichier sont valides par
contre un fichier peut être vide d’entier : c’est le cas par exemple d’un fichier de taille 0 ou encore un fichier
qui ne comporte que des caractères blancs.
5.3. Affichage des résultats. L’affiche des résultats doit se faire avec la fonction affiche_Tab2D fournie
seulement. (Voir les commentaires donnés dans le «util.h»). En pratique le fichier «dup.c» ne devrait
contenir aucun appel direct à la fonction printf par exemple.
5.4. Composition du programme.
— «util.h» : fichier fourni définissant les prototypes des fonctions d’affichage et de gestion des erreurs.
— «util.c» : code source des fonctions d’affichage et de gestion des erreurs.
— «dup.c» : comporte la fonction main et toutes les autres fonctions que vous avez définies pour votre
programme.
— La compilation de votre programme «dup.c» est assurée par la commande :
gcc -Wall -std=c99 dup.c util.c -o dup
Les fichiers «util.c» et «util.h» ne devraient pas être modifiés.
— La compilation de votre programme ne devrait donner aucun warnning.
— Votre fichier «dup.c» doit contenir les nom des auteurs et leurs codes permanents en commentaire.
5.5. Portabilité du programme. Votre programme devrait être compilé et testé sur le serveur malt
6. Ce que vous devez remettre
Un membre de l’équipe seulement remettra votre fichier «dup.c» dans Moodle en suivant le lien approprié.
Pas de remise en double svp.
7. Pondération
— Tests de fonctionnement : 60% (cette partie sera corrigée en votre programme soumettant à une
batterie de tests)
— Exigences non fonctionnelles : 20%
— Structure du programme, commentaires, indentation ... : 20%
Remarques importantes pour ne pas perdre des points inutilement :
— Des pénalités sont à prévoir si le programme ne respecte pas l’affichage exigé.
— 5% de pénalité pour un programme remis sans les noms des auteurs en commentaire.
— 5% de pénalité si le programme remis ne s’appelle pas «dup.c».
— Aucun programme reçu par courriel ne sera accepté. En cas de panne du système un délai supplémentaire
sera décidé en consequence.
— Les règlements sur le plagiat seront strictement appliqués.
— 10% comme pénalité de retard par journée entamée. Après cinq jours, le travail ne sera pas accepté.
— La remise d’un fichier "zippé" donne lieu à 10% de pénalité.
5
