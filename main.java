package automate;
import java.util.*;

public class main {

public  static void  main(String [] args){
	
	Scanner clavier=new Scanner(System.in);
	afn exemple1= new afn();
	afntoafd exemple2= new afntoafd();
	afd resultatFinal= new afd();
	
	int choix;
	boolean test=true;
    exemple1.menuAlphabet();
    
    do{
    	System.out.print("Saisissez une option:   ");
        choix=clavier.nextInt();
        
	    switch(choix){
	    case 1: exemple1.ajouterSymbole();break;
	    case 2: test=false;break;
	    }
    }while(test== true);
    
    
    exemple1.menuEtat();
   test=true;
    do{
    	System.out.print("Saisissez une option:   ");
        choix=clavier.nextInt();
    switch(choix){
    case 1: exemple1.ajouterEtats();break;
    case 2: test=false;break;
    }
    }while(test== true);
    
    exemple1.saisirEtatFinaux();
    exemple1.affichageEtatsInitial();
    exemple1.fonctionTrans();
    exemple1.afficherFonctionTransition();
    exemple2.testEpsilonTransition(exemple1);
    exemple2.transfert(exemple1);
    exemple2.afficherFonctionTransition();
    exemple2.afficherInfoAFd(resultatFinal, exemple1);
    resultatFinal.affichageAlphabet();
    resultatFinal.affichageEtats();
    resultatFinal.affichageEtatsFinaux();
    resultatFinal.affichageEtatsInitial();
    resultatFinal.AfficherFonctionTrans();
    
}

}