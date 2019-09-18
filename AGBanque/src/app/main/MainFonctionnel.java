package app.main;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import app.composants.Client;
import app.composants.Compte;
import app.composants.CompteCourant;
import app.composants.CompteEpargne;
import app.composants.Credit;
import app.composants.Debit;
import app.composants.Flux;
import app.composants.Virement;

public class MainFonctionnel {

	public static void main(String[] args) {
		// 1.1.1 Création de la classe client
		ArrayList<Client> listeClients = new ArrayList<Client>();

		listeClients.add(new Client("Zidane", "Zinedine"));
		listeClients.add(new Client("Cesar", "Jules"));
		listeClients.add(new Client("De Gaulle", "Charles"));
		listeClients.add(new Client("Macron", "Emmanuel"));
		listeClients.add(new Client("Riner", "Teddy"));
		listeClients.add(new Client("Messi", "Lionel"));

		System.out.println("||||||||||||||LISTE CLIENTS||||||||||||||");
		System.out.println("_________________________________________");
		afficherClients(listeClients);
		System.out.println("_________________________________________");

		// 1.2.3 Création du tableau des comptes
		Compte compte1 = new CompteCourant("Compte courant Mr Jean Dujardin", new Client("Dujardin", "Jean"), 200.00);
		ArrayList<Compte> listeComptes = new ArrayList<Compte>();
		listeComptes.add(compte1);
		listeComptes.add(new CompteEpargne("Compte épargne Mr Victor Hugo", new Client("Hugo", "Victor"), 200.00));
		listeComptes.add(new CompteCourant("Compte courant Mr Emile Zola", new Client("Zola", "Emile"), 200.00));
		listeComptes
				.add(new CompteEpargne("Compte épargne Mr Albert Einstein", new Client("Einstein", "Albert"), 200.00));
		listeComptes.add(new CompteEpargne("Compte épargne Mr Super Man", new Client("Man", "Super"), 200.00));
		System.out.println("||||||||||||||LISTE COMPTES||||||||||||||");
		System.out.println("_________________________________________");
		afficherComptes(listeComptes);
		System.out.println("_________________________________________");

		// 1.3.1 Adaptation du tableau des comptes

		Hashtable<Integer, String> ht = new Hashtable<Integer, String>();

		for (int i = 0; i < listeComptes.size(); i++) {
			ht.put(listeComptes.get(i).getNumero_compte(), listeComptes.get(i).toString());
		}
		System.out.println("||||||||||||||HASHMAP COMPTES||||||||||||||");
		System.out.println("_________________________________________");
		afficherHashMapComptes(ht);
		System.out.println("_________________________________________");

		// 1.3.4 Création du tableau des flux
		System.out.println("********************************************************************");

		LocalDateTime currentTime = LocalDateTime.now();
		
		ArrayList<Flux> listeFlux = new ArrayList<Flux>();
		listeFlux.add(new Debit("débit de 50euros", "05kf69B", 50, 1, true,currentTime.plusDays(2)));
		listeFlux.add(new Credit("crédit de 100.50euros", "410md35N", 100.50, 1, true, currentTime.plusDays(2)));
		listeFlux.add(new Credit("crédit de 100.50euros", "100re89P", 100.50, 3, true, currentTime.plusDays(2)));
		listeFlux.add(new Credit("crédit de 1500euros", "125pp16Q", 1500, 2, true, currentTime.plusDays(2)));
		listeFlux.add(new Credit("crédit de 1500euros", "014kl01S", 1500, 4, true, currentTime.plusDays(2)));
		listeFlux.add(new Credit("crédit de 1500euros", "892fr31L", 1500, 5, true, currentTime.plusDays(2)));
		listeFlux.add(new Virement("virement de 50euros", "125pp16Q", 50, 2, true, currentTime.plusDays(2), compte1));

		System.out.println("|||||||||||||||||LISTE FLUX|||||||||||||||");
		System.out.println("_________________________________________");
		afficherFlux(listeFlux);
		System.out.println("_________________________________________");

		// ********************************1.3.5 Mise à jour des
		// comptes**********************

		for (int i = 0; i < listeComptes.size(); i++) {
			for (int j = 0; j < listeFlux.size(); j++) {
				if (listeComptes.get(i).getNumero_compte() == listeFlux.get(j).getNumero_compte_cible()) {
					listeComptes.get(i).setSolde(listeFlux.get(j));

				}
			}
		}
		System.out.println("|||||||||||||||||MISE A JOUR DES COMPTES SUITE AUX FLUX|||||||||||||||");
		System.out.println("_________________________________________________________________________");

		for (int i = 0; i < listeComptes.size(); i++) {
			System.out.println((i + 1) + " | Numéro compte :" + listeComptes.get(i).getNumero_compte() + " | solde :"
					+ listeComptes.get(i).getSolde());
		}
		
		//2.1 Fichier JSON des flux
		System.out.println("_________________________________________________________________________");

		System.out.println("|||||||||||||||||LIRE FLUX JSON|||||||||||||||");
		System.out.println("_________________________________________");
		lireJSON(listeFlux);
		afficherFlux(listeFlux);
		System.out.println("_________________________________________");
		//2.2 Fichier XML des comptes
		System.out.println("_________________________________________________________________________");

		System.out.println("|||||||||||||||||LIRE FLUX XML|||||||||||||||");
		System.out.println("_________________________________________");
		lireXML(listeComptes);
		afficherComptes(listeComptes);
		System.out.println("_________________________________________");
	}

	// *******************************************METHODES*********************************************************
	public static void afficherClients(ArrayList<Client> listeCli) {
		Stream<Client> sp = listeCli.stream();
		sp.forEach(System.out::println);
	}

	public static void afficherComptes(ArrayList<Compte> listeCpt) {
		Stream<Compte> sp = listeCpt.stream();
		sp.forEach(System.out::println);
	}

	public static void afficherHashMapComptes(Hashtable<Integer, String> hashCpt) {
		Enumeration<String> e = hashCpt.elements();

		while (e.hasMoreElements())
			System.out.println(e.nextElement());
	}

	public static void afficherFlux(ArrayList<Flux> listeFlx) {
		Stream<Flux> sp = listeFlx.stream();
		sp.forEach(System.out::println);
	}

	public static void lireJSON(ArrayList<Flux> listeFlx) {
		JSONParser parser = new JSONParser();
		String path = getPath().toString();
		try (Reader reader = new FileReader(path)) {
			JSONObject jsonObject = (JSONObject) parser.parse(reader);
			for (Integer i = 1; i <= jsonObject.size(); i++) {
				String elName = "el" + i.toString();
				JSONObject data = (JSONObject) jsonObject.get(elName);
				// String fluxType = (String) data.get("fluxType");
				String comm = (String) data.get("commentaire");
				String id = (String) data.get("identifiant");
				Long mount = (Long) data.get("montant");
				Long num_cible = (Long) data.get("numero_compte_cible");
				listeFlx.add(new Debit(comm, id, mount, num_cible.intValue(), true, null));
			}

		} catch (Exception el) {
			el.printStackTrace();
		}
	}

	public static Path getPath() {
		Path test = Paths.get("src/flux.json");
		System.out.println(test.toAbsolutePath());
		return test;
	}

	public static void lireXML(ArrayList<Compte> listeCpt) {
		try {
	         File inputFile = new File("src/comptes.xml");
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	         NodeList nList = doc.getElementsByTagName("compte");
	         System.out.println("----------------------------");
	         Compte compte;
	         
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	            Node nNode = nList.item(temp);
	            System.out.println("\nCurrent Element :" + nNode.getNodeName());
	            
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	               Element eElement = (Element) nNode;
	               
	               String name = eElement.getElementsByTagName("nom").item(0).getTextContent();
	               String id = eElement.getElementsByTagName("numero_compte").item(0).getTextContent();
	               if(eElement.getAttribute("type").equals("1"))
	            	   compte = new CompteCourant(name, Integer.parseInt(id));
	               else
	            	   compte = new CompteEpargne(name, Integer.parseInt(id));
	               compte.setLibelle(eElement.getElementsByTagName("libelle").item(0).getTextContent());
	               compte.setSolde(Double.parseDouble(eElement.getElementsByTagName("solde").item(0).getTextContent()));
	               listeCpt = updateComptArray(listeCpt, compte );

	            }
	         }
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      }
	}

	public static ArrayList<Compte> updateComptArray(ArrayList<Compte> comptes, Compte compte) {

		comptes.add(compte);

		return comptes;
	}
}
