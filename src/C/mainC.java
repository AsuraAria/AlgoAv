package C;

import resources.CoinList;

public class mainC {
    public static void main(String[] args) {
        AlgoGlouton AG1 = new AlgoGlouton(new CoinList(new float[]{.01f, 1, 0.50f, .20f, .10f, .05f, .02f, 2}), 0);
        AlgoGlouton AG2 = new AlgoGlouton(new CoinList(new float[]{.13f, 5, 0.50f, .22f, .1f, .05f, .02f, 2}), 45.86f);
        AlgoGlouton AG3 = new AlgoGlouton(new CoinList(new float[]{2, 1, 0.50f, .20f, .10f, .05f, .02f, .01f}), 54.54f);

        AG1.resolve();
        AG2.resolve();
        AG3.resolve();

        //C = {c1, c2, c3}
        //d1 = 6
        //d2 = 4
        //d3 = 1
        //N = 8
        //La solution optimale tient en 2 pièces {4,4}
        //L'algorithme glouton renvoie la solution {6,1,1}

        //le fait que chaque pièce est une combinaison de chaque pièce plus petite d'au plus coeff 1 sauf la premire donne la puce à l'oreille

        // Pour montrer qu'un systeme comme l'euro est optimal il nous faut montrer que tout les valeurs
        // entre 0 et deux fois la valeur de la pièce de plus haute valeur sont optimales
        // si P la pièce de valeur max et la solution est optimale pour [a,b] alors c'est optimal pour [a+P,b+P]
        // donc ici entre 0€ et 4€
        // les multiples de 5 et 10 sont évident
        // or pour toutes valeurs s, n=q+r,
        // avec q une valeur multiple de 5 ou 10 dont la solution optimal est obtenable par glouton
        // r est un reste entre 0 et 0.04 que l'on peut décomposer en zero, une, ou deux pièce
    }
}