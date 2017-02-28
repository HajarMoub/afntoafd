package automate;

import java.util.*;

public class afntoafd {
	private char a;
	private int ligneTest;
	private int colTest;
	private  String fn[];
	private int varVide;
	private String fon[][];
	private String fin[][];
	private int ligneGlobale;
	private int ligne;
	private int col;

	public void testEpsilonTransition(afn schema){
		if (schema.testEpsilon()==true)
			a='o';
		
		else
			a='f';
	}

	public void afficherInfoAFd(afd oo,afn ii){
		for(int k=0;k<ii.tailleAlphabet();k++){
	      oo.alphabet.add(ii.alphabet.get(k));
	                                          }
			int kk=1;
			do{
		    oo.etats.add(fin[kk][0]);
		    kk++;
			}while(kk<fin.length) ;  
			
		oo.etatInitial=fin[2][0];
		
		for(int k=0;k<ii.tailleEtatsFinaux();k++){
		    String et=ii.etatsFinaux.get(k);
		    for(int kl=2;kl<fin.length;kl++){
			  if(fin[kl][0].contains(et)==true){
				  if(oo.etatsFinaux.size()==0) oo.etatsFinaux.add(fin[kl][0]);
				  else{
					  
					  boolean te=true;
					  for(int i=0;i<oo.etatsFinaux.size();i++){
						  if(fin[kl][0]==oo.etatsFinaux.get(i))te=false;
					  }
					  if(te==true) oo.etatsFinaux.add(fin[kl][0]);
					  }
 
			  }
				
		     }
		}
		oo.fonctionTransition=new String[oo.tailleEtats()][oo.tailleAlphabet()];
	int po=0;int pi;
		for(int mp=1;mp<fin.length;mp++){
			pi=0;
			for(int mo=1;mo<fin[mp].length;mo++){
				oo.fonctionTransition[po][pi]=fin[mp][mo] ;
				pi++;
			}
	po++;
			} 
			
		
		}
	
	public void afficherFonctionTransition(){

		for(int i=0;i<fin.length;i++){
		for(int j=0;j<fin[0].length;j++){
			System.out.print(fin[i][j]+"\t \t ");
		}
		System.out.println("");	
		}
	}
	
	public void transfert(afn schema){
		varVide=0;
		ArrayList <String> temp;
		for(int mp=0;mp<schema.etats.size();mp++){
		for(int mo=0;mo<schema.alphabet.size();mo++){
           if (schema.fonctionTransition[mp][mo]=="vide")
        	   varVide=1;mo=schema.alphabet.size();
		}
		mp=schema.etats.size();
		}
	
	if(a=='o'){ 
		fon=new String[100][schema.alphabet.size()+1];
		
		for(int i=0;i<100;i++){
			for(int j=0;j<schema.alphabet.size()+1;j++){
			fon[i][j]="fin";}
			}
			fon[0][0]=" ";
			for(int i=1;i<=schema.alphabet.size();i++)
				fon[0][i]=schema.alphabet.get(i-1).toString();
			for(int i=0;i<schema.alphabet.size()+1;i++)
				fon[1][i]="vide";
			fon[2][0]="{q0}";
	        ligneTest=2;
			colTest=1;
			ligne=2;
			col=1;
			for(int j=0;j<schema.alphabet.size();j++){ 
				fon[ligne][col]=schema.fonctionTransition[0][j];
				col++;
				}
			ligne++;col=0;
			ligneGlobale=3;
			remplirligne(schema.alphabet.size(), schema);
			while(fon[ligneGlobale][0]!="fin"){
				temp = new ArrayList<String> ();
				for(int l=0;l<schema.etats.size();l++){
					String c=schema.etats.get(l);
					if(fon[ligneGlobale][0].contains(c)==true){
						temp.add(c);
					}
				}
				
				remplircolonne(temp,schema);
				remplirligne(schema.alphabet.size(), schema);
			}

			fin= new String[ligneGlobale][schema.alphabet.size()+1];
			for (int j=0;j<ligneGlobale;j++){
				for(int k=0;k<schema.alphabet.size()+1;k++){
					fin[j][k]=fon[j][k];
				}
			}
		
		}
	else{ 
		fn =new String[schema.etats.size()];
		for(int i=0;i<schema.etats.size();i++){
			String e=schema.etats.get(i);
			fn[i]=e;
				if(schema.fonctionTransition[i][schema.alphabet.size()]!="vide"){
					String z=schema.fonctionTransition[i][schema.alphabet.size()];
		      	fn[i]+=z;
				                                                               }
				                               }
				
				for(int j=0;j<schema.etats.size();j++){
					for (int l=0;l<schema.etats.size();l++){
						if ( l!=j){
							if(fn[l].contains(schema.etats.get(j))){
								fn[l]+=fn[j];
							       }
								
						            }
					}
				}
				
				
					for(int et=0;et<schema.etats.size();et++){
				ArrayList <String> t=new ArrayList <String> ();
				for(int l=0;l<schema.etats.size();l++){
					String c=schema.etats.get(l);
					if(fn[et].contains(c)==true){
						t.add(c);
					}
				}
				String chaine="{";
				for(int l=0;l<t.size();l++){
					chaine=chaine+t.get(l);
					if(l!=t.size()-1)
					chaine=chaine+",";
					else
						chaine=chaine+"}";	
				}	
				
				fn[et]=chaine;
				et++;
				}
						
					
		fon=new String[100][schema.alphabet.size()+1];
		for(int i=0;i<100;i++){
			
			fon[i][0]="fin";}
			
		
		fon[0][0]=" ";
		for (int z=1;z<=schema.alphabet.size();z++)
			fon[0][z]=schema.alphabet.get(z-1).toString();
		if(varVide==1 || varVide==0 ){for (int i=0;i<=schema.alphabet.size();i++)
			fon[1][i]="vide";}
		fon[2][0]=fn[0];
		ligneTest=2;
		colTest=1;
		ligne=2;
		col=1;
		ligneGlobale=2;
		
	while(fon[ligneGlobale][0]!="fin"){
		
		temp=new ArrayList <String> ();
	
		for (int l=0;l<schema.etats.size();l++){
			String c=schema.etats.get(l);
			
			if(fon[ligneGlobale][0].contains(c)==true){
				temp.add(c);
			}
		}
		

		remplircolonne(temp,schema);
		if(ligneGlobale==3)ligne++;
	    remplirligne(schema.alphabet.size(), schema);
	   
		}
		fin= new String[ligneGlobale][schema.alphabet.size()+1];
		for (int j=0;j<ligneGlobale;j++){
			for(int k=0;k<schema.alphabet.size()+1;k++){
				fin[j][k]=fon[j][k];
			}
		}
		
		
	}
		
	}
	
	public void remplircolonne(ArrayList <String> tem,afn sc){
 
		
		ArrayList <String> tp;col=1;
		if(tem.size()==1 && a=='o'){
			for(int j=0;j<sc.alphabet.size();j++){
				String  a= tem.get(0).substring(1,2);
				int z= Integer.parseInt(a);
			
				
				fon[ligneGlobale][col]=sc.fonctionTransition[z][j];
				col++;
			}
			ligneGlobale++;col=0;
		}
		else{
	
	for(int j=0;j<sc.alphabet.size();j++){
	for(int i=0;i<tem.size();i++){
		String  a= tem.get(i).substring(1,2);
		int z= Integer.parseInt(a);
		
		if(i==0){
			fon[ligneGlobale][col]=sc.fonctionTransition[z][j];
		}
		else{
			fon[ligneGlobale][col]+=sc.fonctionTransition[z][j];
			}
	}
	
	boolean testVide=true;
	for(int l=0;l<sc.etats.size();l++){
		String c=sc.etats.get(l);
		if(fon[ligneGlobale][col].contains(c)==true){
			             testVide=false;l=sc.etats.size();
		}
	}
	if(testVide==true) fon[ligneGlobale][col] ="vide";
	if(fon[ligneGlobale][col] != "vide"){
	if(a =='f'){
		for(int l=0;l<sc.etats.size();l++){
			String c=sc.etats.get(l);
			if(fon[ligneGlobale][col].contains(c)==true){
				              fon[ligneGlobale][col]+=fn[l];

			}
		}
	}

	tp=new ArrayList <String> ();
	for(int l=0;l<sc.etats.size();l++){
		String c=sc.etats.get(l);
		if(fon[ligneGlobale][col].contains(c)==true){
			tp.add(c);
		}
	}
	String chaine="{";
	for(int l=0;l<tp.size();l++){
		chaine=chaine+tp.get(l);
		if(l!=tp.size()-1)
		chaine=chaine+",";
		else
			chaine=chaine+"}";	
	}
	fon[ligneGlobale][col]=chaine;}
	col++;

	}
	
	ligneGlobale++;col=0;
		}
		
		}
		

		

	public void remplirligne(int taille,afn sc){
		int tailleGlobaleParcours=1;boolean test;
		do{	
			test=true;
			
				for(int m=1;m<ligne;m++){
			 
			        
			        	String a=fon[ligneTest][colTest];
			        	String b=fon[m][0];
					if(a.equals(b)==true && a.length()==b.length()){
			      
					test=false;m=ligne;}


				}
				
				
		
			if(test==true){
				
					fon[ligne][0]=fon[ligneTest][colTest];ligne++;
					
			}
					if(colTest==taille){
					ligneTest++;colTest=1;	
				                       }
					else {
						colTest++   ;                              
				         }
				tailleGlobaleParcours++;
		
	
		}while(tailleGlobaleParcours<=taille);
	
	
	

	}
}
