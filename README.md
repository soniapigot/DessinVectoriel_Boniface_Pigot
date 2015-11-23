# Dessin Vectoriel

## mode d'emploi ##

Ce projet vous permet de créer un dessin vectoriel. Pour cela, vous allez devoir suivre quelques règles d'utilisation.

Vous allez écrire un script pour créer votre dessin. Ce script, va être écrit dans le package main, dans la classe Buider dans le constructeur, c'est-à-dire la méthode qui se nomme: public Builder().

Enfin, vous allez choisir l'interprétation que vous souhaitez avoir: création d'un fichier SVG ou sous Graphics2D. Pour cela, dans le package main ouvrez la classe Main, vous verez alors une méthode main dans laquelle vous allez pouvoir choisir l'interprétation. Une variable 'interpretation' est déclaré dans la méthode main. Une valeur lui ai assigné, soit "svg" pour avoir une interprétation en SVG soit "graphics2D". Ainsi il vous suffit de commenter l'interprétation que vous ne voulez pas à l'aide de deux slash, comme ceci: //. Vous pouvez maintenant lancer le projet: clique droit sur la classe main puis Run As -> Java Application.

Si vous avez choisi une interprétation en SVG, faites clique droit sur le projet et choissisez Refresh. Dans votre projet, un dossier fichierSVG existe. Si vous l'ouvrez, vos dessins avec le nom que vous leurs avez donnés apparaîtront. Pour les ouvrir double cliqué dessus et il souvrira avec votre navigateur par défaut.

Si vous avez choisi une interprétation avec Graphics2D, alors vos fichier s'ouvriront au lancement de l'application. Si vous souhaitez modifier vos dessins, n'oubliez pas de les fermer avant.

## Règles de base ##

- Ne jamais supprimer dessinVide.svg dans le dossier fichierSVG.
- Choississez bien l'ordre dans lequel vous dessinez vos formes dans votre dessins. Si vous dessinez un carré, puis un rond rempli plus gros que le carré et au même endroit que le carré, alors le carré ne sera plus visible sur votre dessin.