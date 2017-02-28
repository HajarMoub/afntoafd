package automate;

import java.util.*;

public class afd{
	
	public String etatInitial;
	public ArrayList <Character> alphabet;
	public ArrayList <String> etats;
	public ArrayList <String> etatsFinaux;
	public String [][] fonctionTransition;


Scanner clavier=new Scanner(System.in);
public afd(){

	alphabet= new ArrayList <Character> ();
	etats= new ArrayList <String> () ;
	etatsFinaux= new ArrayList <String>() ;
}
public void ajouterSymbole(){
	char a;int z;
	System.out.print("Insérer un nouveau symbole (Char) :   ");
	a=clavier.next().charAt(0);
	if(tailleAlphabet()!=0){
		z=alphabet.indexOf(a);
		if(z !=-1){
		 System.out.println("Oups!charactère refusé");
	}
		
		else{
			alphabet.add(new Character(a));
		System.out.println("Ajout du symbole :   "+a);}
			}
		else{
	alphabet.add(new Character(a));
	System.out.println("Ajout du symbole :   "+a);}
	
}



public int tailleAlphabet(){
	return alphabet.size();
}

public void affichageAlphabet(){
	 int taille=tailleAlphabet();
	 for(int i=0;i<taille;i++){
		 System.out.print(alphabet.get(i)+"\t");
	 }
}

public void menuAlphabet(){
	System.out.println("Option 1: Nouvel symbole");
	System.out.println("Option 2: Teminer!");
}
//////////////////////////Etats
public void menuEtat(){
	System.out.println("Option 1: Ajouter un état:    ");
	System.out.println("Option 2: Terminé!");
}

public void ajouterEtats(){
	int  a;String e;
   
	System.out.print("Quel est le nombre des états dans votre automate? \n Notez bien que les états de votre automate sont  q0,q1,q2,q3,...:    ");
	a=clavier.nextInt();

	for(int i=0;i<a;i++){
	e="q"+i;	
	etats.add(e);
	}
	
}


public int tailleEtats(){
	return etats.size();
}

 public void affichageEtats(){
	 int taille=tailleEtats();
	 for(int i=0;i<taille;i++){
		 System.out.print(etats.get(i)+"\t");
	 }
	 System.out.println();
 }

public void fonctionTrans(){
	int i,j;String etatTest;char c;String f;boolean test;
	fonctionTransition = new String[tailleEtats()][tailleAlphabet()];
	for(i=0;i<tailleEtats();i++){
		etatTest=etats.get(i);
		for (j=0;j<tailleAlphabet();j++){
			c=alphabet.get(j);
			System.out.print("f("+etatTest+","+c+")=");
			do{
			f=clavier.nextLine();
			test=verifierEtat(f);
			}while(test==false);
			fonctionTransition[i][j]=f;
		}
	}	
}
public void AfficherFonctionTrans(){
	System.out.print("\t");
	affichageAlphabet();
	System.out.print("\n");
	
	for(int i=0;i<tailleEtats();i++){
		System.out.print(etats.get(i)+"\t");
		for(int j=0;j<tailleAlphabet();j++){
			System.out.print(fonctionTransition[i][j]+"\t");
		}
		System.out.print("\n");
	}
}

private boolean verifierEtat(String f) { 
	int position=etats.indexOf(f);
	if(position==-1)return false;
	else 
	return true;
}

public void saisirEtatFinaux(){
	String f;boolean test;int nombreEtatFinaux;
	do{
	System.out.println("Le nombre des états finaux: ");
	nombreEtatFinaux=clavier.nextInt();
	}while(nombreEtatFinaux<=0);
	
	for(int i=0;i<nombreEtatFinaux;i++){
		System.out.print("L'état final numéro "+(1+i)+" : ");
	do{
		f=clavier.nextLine();
		test=verifierEtat(f);
		}while(test==false);
	etatsFinaux.add(f);
}
	System.out.print("\n");
}

public void affichageEtatsFinaux(){
	 int taille=tailleEtatsFinaux();
	 
	 for(int i=0;i<taille;i++){
		 System.out.print(etatsFinaux.get(i)+"\t");
	 }
	 System.out.print("\n");
}

public int tailleEtatsFinaux(){
	return etatsFinaux.size();
}

public String getEtatInitial(){

	return etatInitial;
}

public void affichageEtatsInitial(){
  System.out.println("L'état initial de votre AFD est : "+getEtatInitial());
}

}
