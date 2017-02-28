package automate;
import java.util.*;
public class afn{
	
	public ArrayList <String> etats;
	public ArrayList <Character> alphabet;
	public ArrayList <String> etatsFinaux;
	public String [][] fonctionTransition;
	public String etatInitial;

	Scanner Clavier=new Scanner(System.in);
	
	public afn(){

		alphabet = new ArrayList <Character> ();
		etats = new ArrayList <String> () ;
		etatsFinaux = new ArrayList <String>() ;
	}
	
	public void ajouterSymbole(){
		int z;
		char a;
		System.out.print("Insérez un nouveau symbole :   ");
		a=Clavier.next().charAt(0);
		if(tailleAlphabet()!=0){
			z=alphabet.indexOf(a);
			if(z !=-1){
			 System.out.println("Oops ! caractère refusé");}
			
			else{alphabet.add(new Character(a));
			System.out.println("Continuez ! votre symbole ajouté est :   "+a);}
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
		System.out.println("Option 1: Insérez un symbole");
		System.out.println("OPtion 2: Terminez cette opération");
	}

	public void menuEtat(){
		System.out.println("Option 1: Ajoutez un état:    ");
		System.out.println("Opiton 2: Terminez cette opération ");
	}

	public void ajouterEtats(){
		int  a;
		String e;
	   
		System.out.print("Quel est le nombre des états dans votre automate? \n Notez bien que les états de votre automate sont  q0,q1,q2,q3,...:");
		a=Clavier.nextInt();


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

	public void saisirEtatFinaux(){
		String f;boolean test;int nombreEtatFinaux;
		do{
		System.out.println("Quel est le nombre des états finaux: ");
	 nombreEtatFinaux=Clavier.nextInt();
	      }while(nombreEtatFinaux<=0);
		for(int i=0;i<nombreEtatFinaux;i++){
			System.out.print("Veuillez saisir l'état final numéro "+(1+i)+" : ");
		do{
			f=Clavier.nextLine();
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
		etatInitial="q0";
		return etatInitial;
	}

	public void affichageEtatsInitial(){
	  System.out.println("L'état initial de votre AFD est : "+getEtatInitial());
	}

   public void fonctionTrans(){
fonctionTransition= new String[etats.size()][alphabet.size()+1];
	String var;ArrayList <String> tab;int r;int y;
	for(int i=0;i<etats.size();i++){
		String q=etats.get(i);
		for(int j=0;j<alphabet.size()+1;j++){
			if(j==alphabet.size()){
				System.out.println("Transition ("+q+",'epsilon')");
				System.out.println("Choisissez 'aucune' ou 'un ou plusieurs états' ");
			}
			else{
			char a=alphabet.get(j);
			System.out.println("Transition("+q+","+a+")");
			System.out.println("Aucune transition=1 ou 'un ou plusieurs états=2: ");
			}
			int re=Clavier.nextInt();
			if(re == 1){
			fonctionTransition[i][j]="vide";
			}
if(re == 2){
	tab=new ArrayList <String> ();
	System.out.println("Quel est le nombre des états?");
	r=Clavier.nextInt();
	System.out.println("Remplir les transitions état par état :   ");
	for(int l=1;l<=r;l++){
		System.out.print("Donnez l'état numéro "+l+"  :   ");
		do{
			var=Clavier.nextLine();
			y =etats.indexOf(var);
		}while(y==-1);
		tab.add(var);
	}
	String chaine="{";
	for(int l=0;l<tab.size();l++){
		if(l <tab.size()-1)
			chaine=chaine+tab.get(l)+",";
		else
			chaine=chaine+tab.get(l)+"}";	
	}
	fonctionTransition[i][j]=chaine;
	}
}
}
}
public boolean testEpsilon(){
	boolean test=true;
	int j=alphabet.size();
	for(int i=0;i<etats.size();i++){
		if(fonctionTransition[i][j]!= "vide"){
			test=false;i=etats.size();	}
	}
	return test;
}

private boolean verifierEtat(String f) {
	int position=etats.indexOf(f);
	if(position==-1)return false;
	else 
	return true;
}
	

public void afficherFonctionTransition(){
	affichageAlphabet();
	System.out.print("\n");
	for(int i=0;i<etats.size();i++){
		System.out.print(etats.get(i)+"\t");
	for(int j=0;j<alphabet.size()+1;j++){
	
	System.out.print(fonctionTransition[i][j]);
	System.out.print("\t");
	}
	System.out.println("");	
	}
}




}
