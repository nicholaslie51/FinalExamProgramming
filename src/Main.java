import java.util.Scanner;
import java.util.Vector;

public class Main {
	Scanner scan = new Scanner(System.in);
	Vector<Eskrim> vEs = new Vector<>();
	String[] type = new String [6];
	int[] coneprice = new int[6];
	int[] sundaeprice = new int[6];
	String[] option = new String [3];
	String[] toping = new String[5];
	int[] topingprice = new int[5];
	
	public Main() {
		int choose = -1;
		do {
			System.out.println("BEE GELATO");
			System.out.println("=============================");
			System.out.println("1. Order");
			System.out.println("2. Order History");
			System.out.println("3. Exit");
			System.out.print(">> ");
			choose = valiInt();
			
			switch (choose) {
			case 1:
				MenuOrder();
				break;
			case 2:
				MenuOrderHistory();
				break;
			case 3:
				menu3();
				break;

			default:
				break;
			}
			
		} while (choose != 3);
		
	}
	
	public void MenuOrder() {
		
		int noor = -1;
		int rasa = -1;
		int tipe = -1;
		int top = -1;
		int qty = -1;
		int noorsama = -1;
		
		do {
			System.out.print("Input No Order [1-10000]: ");
			noor = valiInt();
			for (int j = 0; j < vEs.size(); j++) {
				if (noor == vEs.get(j).getNoor()) {
					System.out.println("No Order Tidak Boleh Sama");
					System.out.println("Harap Menginput No Order yang lain");
					noorsama = 1;
				}else if(noor != vEs.get(j).getNoor()){
					noorsama = 2;
				}
			}
		} while (noor < 1 || noor > 10000 || noorsama == 1);
		
		
		do {
			System.out.print("Type [1. Strawberry 2. Coklat 3. Vanilla 4. Durian 5. Blueberry]: ");
			rasa = valiInt();
		} while (rasa < 1 || rasa > 5);
		
		do {
			System.out.print("Cone/Sundae [1. Cone 2. Sundae]: ");
			tipe = valiInt();
		} while (tipe < 1 || tipe > 2);
		
		do {
			System.out.print("Topping [0. No Topping 1. Almond 2. Nut 3. Oreo 4. Messes]: ");
			top = valiInt();
		} while (top < 0 || top > 4);
		
		do {
			System.out.print("Quantity: ");
			qty = valiInt();
		} while (qty < 1);
		
		System.out.println();
		
		
		String rasaS = "";
		String tipeS = "";
		String topS = "";
		
		if (rasa == 1) {
			rasaS = "Strawberry";
		}else if (rasa == 2) {
			rasaS = "Coklat";
		}else if (rasa == 3) {
			rasaS = "Vanilla";
		}else if (rasa == 4) {
			rasaS = "Durian";
		}else if (rasa == 5) {
			rasaS = "Blueberry";
		}
		
		if (tipe == 1) {
			tipeS = "Cone";
		}else if(tipe == 2){
			tipeS = "Sundae";
		}
		
		if (top == 0) {
			topS = "No Topping";
		}else if(top == 1) {
			topS = "Almond";
		}else if(top == 2) {
			topS = "Nut";
		}else if(top == 3) {
			topS = "Oreo";
		}else if(top == 4) {
			topS = "Messes";
		}
		
		int harga = -1;
		if (rasa == 1 && tipe == 1) {
			harga = 10000;
		}else if (rasa == 2 && tipe == 1) {
			harga = 9000;
		}else if (rasa == 3 && tipe == 1) {
			harga = 8000;
		}else if (rasa == 4 && tipe == 1) {
			harga = 12000;
		}else if (rasa == 5 && tipe == 1) {
			harga = 11000;
		}
		
		if (rasa == 1 && tipe == 2) {
			harga = 12000;
		}else if (rasa == 2 && tipe == 2) {
			harga = 11000;
		}else if (rasa == 3 && tipe == 2) {
			harga = 10000;
		}else if (rasa == 4 && tipe == 2) {
			harga = 14000;
		}else if (rasa == 5 && tipe == 2) {
			harga = 13000;
		}
		
		
		int hargatop = -1;
		if (topS == "No Topping") {
			hargatop = 0;
		}else if (topS == "Almond") {
			hargatop = 3000;
		}else if (topS == "Nut") {
			hargatop = 2500;
		}else if (topS == "Oreo") {
			hargatop = 1500;
		}else if (topS == "Messes") {
			hargatop = 2000;
		}
		
		int price = harga + hargatop;
		
		int subtotal = price*qty;
		
		Eskrim newEs = new Eskrim();
		newEs.setNoor(noor);
		newEs.setRasa(rasaS);
		newEs.setTipe(tipeS);
		newEs.setTop(topS);
		newEs.setQty(qty);
		newEs.setPrice(price);
		newEs.setSubtotal(subtotal);
		vEs.add(newEs);
		
		
	}
	
	public void arr() {
		type[0] = "";
		type[1] = "Strawberry"; 
		type[2] = "Coklat"; 
		type[3] = "Vanilla"; 
		type[4] = "Durian"; 
		type[5] = "Blueberry"; 
		
		coneprice[0] = 0;
		coneprice[1] = 10000;
		coneprice[2] = 9000;
		coneprice[3] = 8000;
		coneprice[4] = 12000;
		coneprice[5] = 11000;
		
		sundaeprice[0] = 0;
		sundaeprice[1] = 12000;
		sundaeprice[2] = 11000;
		sundaeprice[3] = 10000;
		sundaeprice[4] = 14000;
		sundaeprice[5] = 13000;
		
		option[0] = "";
		option[1] = "Cone";
		option[2] = "Sundae";
		
		toping[0] = "No Topping";
		toping[1] = "Almond";
		toping[2] = "Nut";
		toping[3] = "Oreo";
		toping[4] = "Messes";
	}
	
	public void MenuOrderHistory() {
		if (vEs.isEmpty()) {
			System.out.println("Belum ada transaksi");
			System.out.println();
		}else {
			System.out.println();
			System.out.println("BEE GELATO - Order History");
			int grandtotal = 0;
			System.out.println("=========================================================================================================");
			System.out.printf("| %-3s | %-10s | %-10s | %-10s | %-10s |  %-10s | %-10s | %-10s | \n", "No", "No Order", "Ice Cream Type", "Topping", "Cone/Sundae", "Quantity", "Price", "Sub Total");
			System.out.println("=========================================================================================================");
			for (int i = 0; i < vEs.size(); i++) {
				System.out.printf("| %-3s | %-10s | %-14s | %-10s | %-11s |  %-10s | %-10s | %-10s | \n", (i+1), vEs.get(i).getNoor(), vEs.get(i).getRasa(), vEs.get(i).getTop(), vEs.get(i).getTipe(), vEs.get(i).getQty(), vEs.get(i).getPrice(), vEs.get(i).getSubtotal());
				System.out.println("----------------------------------------------------------------------------------------------------------");
				
				int subtotal = vEs.get(i).getSubtotal();
				grandtotal = grandtotal + subtotal;
			}
			
//			System.out.println("Grand Total: " + grandtotal);
			
			System.out.printf("| %-87s | %-10s | \n", "Grand Total" , grandtotal);
			
			System.out.println();
		}
	}
	
	public void menu3() {
		System.out.println("Thank you for using the application");
	}
	
	
	int valiInt() {
		int in;
		try {
			in = scan.nextInt();
		} catch (Exception e) {
			// TODO: handle exception
			in = Integer.MIN_VALUE;
		}
		scan.nextLine();
		return in;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
