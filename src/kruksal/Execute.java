package kruksal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Execute {

	public static void main(String[] args) {
		ArrayList<Ensemble> Ensembles = new ArrayList<>();
		int Menu,Somme=0;
		Scanner scanner=new Scanner(System.in);
		do {
			System.out.println("Menu : ");
			System.out.println("Pour ajouter un Ensemble Clique sur 1 : ");
			System.out.println("Pour Sortir 2 : ");
			Menu=scanner.nextInt();
			if (Menu==1) {
				String S1,S2;
				int P;
				System.out.println("Entrer le premier sommet : ");
				S1 = scanner.next();
				System.out.println("Entrer le deuxième sommet : ");
				S2 = scanner.next();
				System.out.println("Entrer la distance entre eux : ");
				P = scanner.nextInt();
				Ensembles.add(new Ensemble(S1,S2,P));
			}
		}while(Menu!=2);
		
	for ( Ensemble e : Ensembles) {
        System.out.println("(" + e.Sommet1 + "," + e.Sommet2 + ")" +" : " + e.poid);
	}

	Collections.sort(Ensembles,new Comparator<Ensemble>(){//Trier La liste d'ensembles en utilisant la méthode sort de la classe collect
		public int compare(Ensemble E1,Ensemble E2) { //la méthode compare prend deux paramétre pour les comparer.
			return Integer.valueOf(E1.poid).compareTo(E2.poid);//on a fait une comparaison d'après leur poids.
		}	
		
	});
	
	System.out.println("");
	for ( Ensemble e : Ensembles) {
        System.out.println("(" + e.Sommet1 + "," + e.Sommet2 + ")" +" : " + e.poid);
	}
	System.out.println("");
	// Appliquer l'algorithme de Kruskal
    Set<String> sommetsSelectionnes = new HashSet<>();//tableau va contenir les sommets TRAITES
    Set<String> Tab = new HashSet<>();//tableau va contenir les sommets des ensembles non connexe 
    ArrayList<Ensemble> arbreCouvrant = new ArrayList<>();//tableau va contenir l'arbre couvrant 
    for (Ensemble e : Ensembles) {//parcourir la liste Ensembles
        String S1 = e.Sommet1;	
        String S2 = e.Sommet2;
        
        	if(!sommetsSelectionnes.contains(S1) && !sommetsSelectionnes.contains(S2)) {
        		Tab.add(S1);
        		Tab.add(S2);
        	}
        	System.out.println("");

        
        if ((!sommetsSelectionnes.contains(S1) || !sommetsSelectionnes.contains(S2) )) {
        	
            // Ajouter l'ensemble à l'arbre couvrant si un sommet au minimum n'appartient à la liste des sommets
            arbreCouvrant.add(e);     
            sommetsSelectionnes.add(S1);
            sommetsSelectionnes.add(S2);
        }
        
        else if((sommetsSelectionnes.contains(S1) &&Tab.contains(S1) &&sommetsSelectionnes.contains(S2)&&Tab.contains(S2))){
            arbreCouvrant.add(e);     
            Tab.clear();
        }

    }
	System.out.println();

	for ( Ensemble e : arbreCouvrant) {
        System.out.println("(" + e.Sommet1 + "," + e.Sommet2 + ")" +" : " + e.poid);
        Somme+=e.poid;
	}
	System.out.println();
    System.out.println("Le poid total est : "+Somme);
    scanner.close();
	}

}
