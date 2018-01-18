import java.util.Scanner;

/**
 * Created by ibada1731710 on 2018-01-15.
 */
public class main {
    public static void main(String[] args) {

        //déclaration variables
        Scanner sc =new Scanner(System.in);
        String j1;
        String j2;
        int nbAllu=0;
        int stock[]=new int[100];
        int i=0;
        int mode=0;
        char rep='o';
        int choix=0;
        boolean ok=false;

        while (!ok){
            System.out.println("Bonjour !");
            System.out.println("  1- Je veux affronter l'intelligence artificielle");
            System.out.println("  2- Je veux veux jouer à 2 joueurs");
            mode=sc.nextInt();
            if (mode==1 || mode==2){
                ok=true;
            }
            else {
                System.out.println("Entrez une réponse valide SVP");
            }
        }
        ok=false;

        //nommer les joueures
        System.out.println("Bienvenue dans le jeu des allumettes !");
        System.out.println("   Joueur 1, veuillez entrer votre nom: ");
        j1=sc.next();
        if (mode==2) {
            System.out.println("   Joueur 2, veuillez entrer votre nom: ");
            j2=sc.next();
        }
        else {
            j2="Curtis";
            System.out.println("Bonne chance contre "+j2+"! L'intelligence artificielle!");
        }

        //boucle pour rejouer
        while (rep=='o'){
            nbAllu=(int)((Math.random()*(100-20+1))+20);

            //boucle principale (chaque tour)
            while (nbAllu>0){
                if (nbAllu==1){
                    System.out.println("Il reste "+nbAllu+" allumette");
                }
                else {
                    System.out.println("Il reste "+nbAllu+" allumettes");
                }
                while (!ok){
                    if (i%2==0){
                        System.out.println(j1+" combien d'allumettes (entre 1 et 3) voulez-vous retirer?");
                        choix=sc.nextInt();
                    }
                    else if (mode==2){
                        System.out.println(j2+" combien d'allumettes (entre 1 et 3) voulez-vous retirer?");
                        choix=sc.nextInt();
                    }
                    else {
                        choix=(nbAllu-1)%4;
                        if (choix==0){
                            choix=(int)(Math.random()*3+1);
                        }
                        System.out.println(j2+" retire "+choix+" allumette(s)");
                    }

                    if (choix<4&&choix>0){
                        ok=true;
                    }
                    else{
                        System.out.println("Entrez une réponse valide SVP");
                    }
                }
                ok=false;
                stock[i]=choix;
                nbAllu-=choix;
                if (nbAllu<1){
                    System.out.println("Il ne reste plus d'allumettes");
                    if (i%2==0){
                        System.out.print(j2);
                    }
                    else {
                        System.out.print(j1);
                    }
                    System.out.println(" remporte la partie !");
                }
                i++;
            }
            System.out.print("Décision prises par "+j1+" : ");
            for (int j=0; j<100; j++){
                if (j%2==0){
                    if (stock[j]==0){
                        j=100;
                    }
                    else if (j==0){
                        System.out.print(stock[j]);
                    }
                    else {
                        System.out.print(","+stock[j]);
                    }
                }

            }
            System.out.println();
            System.out.print("Décision prises par "+j2+" : ");
            for (int j=0; j<100; j++){
                if (j%2==1){
                    if (stock[j]==0){
                        j=100;
                    }
                    else if (j==1){
                        System.out.print(stock[j]);
                    }
                    else {
                        System.out.print(","+stock[j]);
                    }
                }
            }
            System.out.println();
            while (!ok){
                System.out.println("Voulez-vous jouer de nouveau (o/n)?");
                rep=sc.next().toLowerCase().charAt(0);
                if (rep=='o'||rep=='n'){
                    ok=true;
                }
                else {
                    System.out.println("Entrez une réponse valide SVP");
                }
            }
            ok=false;
            for (int j=0; j<100; j++){
                stock[j]=0;
            }
            i=0;
        }
        System.out.println("Merci d'avoir joué au jeu des allumettes, bonne journée !");





    }
}
