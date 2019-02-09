import iut.algo.Console;
import iut.algo.CouleurConsole;

public class IHMCUI {
    private Metier metier;

    public IHMCUI(Metier metier) {
        this.metier = metier;
    }

    public int menu() {
        int choix;

        Console.println(" 1. Listes des Départements ");
        Console.println(" 2. Listes des Regions ");
        Console.println(" 3. Listes des Départements par Region ");
        Console.println(" 4. Quitter ");

        Console.println();
        Console.print("     votre choix : ");
        Console.couleurFont(CouleurConsole.ROUGE);

        choix = Console.lireInt();

        Console.normal();
        Console.println();

        if (choix < 1 || choix > 4)
            choix = 4;

        return choix;
    }

    public void afficherDept() {
        Departement dept;
        int nbDept = metier.getNbDept();

        String chaine = "+----+-------------------------------+----------+----------+--------+\n"
                + "|num |nom                            |population|superficie|densite |\n"
                + "+----+-------------------------------+----------+----------+--------+\n";

        for (int cpt = 0; cpt < nbDept; cpt++) {
            dept = metier.getDept(cpt);
            chaine += String.format("|%4s|%31s|%10s|%10s|%8s|", dept.getNumero(), dept.getNom(), dept.getPopulation(),
                    dept.getSuperficie(), dept.densite()) + "\n";

        }

        chaine += "+----+-------------------------------+----------+----------+--------+\n";

        Console.println(chaine);
    }

    public void afficherRegion() {
        Region region;
        int nbRegion = metier.getNbRegion();
        String chaine = "+----+-----------------------------------+----------+----------+--------+\n"
                + "|num |nom                                |population|superficie|densite |\n"
                + "+----+-----------------------------------+----------+----------+--------+\n";

        for (int cpt = 0; cpt < nbRegion; cpt++) {
            region = metier.getRegion(cpt);
            chaine += String.format("|%4s|%35s|%10s|%10s|%8s|", region.getNumero(), region.getNom(),
                    region.getPopulation(), region.getSuperficie(), region.densite()) + "\n";

        }

        chaine += "+----+-----------------------------------+----------+----------+--------+\n";

        Console.println(chaine);

    }

    public void afficherRegionAvecDept() {
        Region region;
        int nbRegion = metier.getNbRegion();
        String chaine = "";

        for (int cpt = 0; cpt < nbRegion; cpt++) {
            region = metier.getRegion(cpt);
            chaine += region.toString() + "\n";
        }

        Console.println(chaine);
    }

}