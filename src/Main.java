import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	Scanner sc = new Scanner(System.in);
	
	public void clear() {
		for (int i = 0; i < 30; i++) {
			System.out.println();
		}
	}
	
	public void headsetPrice() {
		System.out.println("Type               Headset Price");
		System.out.println("Headphone                20000");
		System.out.println("IEM		                 25000");
		System.out.println("OnEar	                 30000");
	}
	
	public void mainMenu() {
		System.out.println("1. Add Headset");
		System.out.println("2. Update Headset");
		System.out.println("3. Buy Headset");
		System.out.println("4. View Collection");
		System.out.println("5. Exit");
		System.out.println(">> ");
	}
	
	// add
	public Headset newHeadset() {
		String headsetName = "";
		String headsetType = "";
		do {
			System.out.println("Input headset name [5..15 | Unique]: ");
			headsetName = sc.nextLine();
		} while (headsetName.length() < 5 || headsetName.length() > 15);
		
		
		do {
			System.out.println("Input headset type [Headphone | IEM | OnEar]: ");
			headsetType = sc.nextLine();
		} while (!headsetType.equals("Headphone")&& !headsetType.equals("IEM" ) && !headsetType.equals("OnEar"));
		return new Headset(headsetName, headsetType);
		
	}
	
	// view
	public void viewCollection(Vector<Headset> hset) {
		if(hset.isEmpty()) {
			System.out.println("Your collection(s) are empty.");
			
		} else {
			for (int i = 0; i < hset.size(); i++) {
				System.out.println((i + 1) + " | " + hset.get(i).getHeadsetName() + " | " + hset.get(i).getHeadsetType());
			}
		}
		System.out.println();
	}
	
	
	// update
	public void updateHeadset(Vector<Headset> hset) {
		
		
		if(hset.isEmpty()) {
			System.out.println("No headset added yet");
		} else {
			String headsetName = "";
			String headsetType = "";
			int input = -1;
			
			do {
				System.out.println("Select headset [1-3]: ");
				try {
					input = sc.nextInt();
				} catch (Exception e) {
					// TODO: handle exception
					input = -1;
				}
				sc.nextLine();
			} while (input < 1 || input > hset.size());
			
			do {
				System.out.println("Input headset name [5..15 | Unique]: ");
				headsetName = sc.nextLine();
			} while (headsetName.length() < 5 || headsetName.length() > 15);
			
			
			do {
				System.out.println("Input headset type [Headphone | IEM | OnEar]: ");
				headsetType = sc.nextLine();
			} while (!headsetType.equals("Headphone")&& !headsetType.equals("IEM" ) && !headsetType.equals("OnEar"));
			
			input -= 1;
			
			hset.get(input).setHeadsetName(headsetName);
			hset.get(input).setHeadsetType(headsetType);
			
			System.out.println("Headset successfully updated!");
		}
	}
	
	
	// buy
	public void buyHeadset(Vector<Headset> hset) {
		if(hset.isEmpty()) {
			System.out.println("No headset added yet!");
		} else {
			String headsetName = "";
			String headsetType = "";
			int input = -1;
			int qty = 0;
			int disc = 0;
		
			
			do {
				System.out.println("Select headset [1-3]: ");
				try {
					input = sc.nextInt();
				} catch (Exception e) {
					// TODO: handle exception
					input = -1;
				}
				sc.nextLine();
			} while (input < 1 || input > hset.size());
			
			if(qty >= 1) {
				System.out.println("Input Quantity [1-3]: ");
			}
		}
	}
	
	public Main() {
		Vector<Headset> hset = new Vector<>();
		boolean isRun = true;
		int input = -1;
		do {
			
			do {
				mainMenu();
				try {
					input = sc.nextInt();
				} catch (Exception e) {
					// TODO: handle exception
					input = -1;
				}
				sc.nextLine();
			} while (input < 1 || input > 5);
			
			switch(input) {
			case 1:
				clear();
				hset.add(newHeadset());
				break;
			case 2:
				clear();
				updateHeadset(hset);
				break;
			case 3:
				clear();
				buyHeadset(hset);
				break;
			case 4:
				clear();
				viewCollection(hset);
				break;
			case 5:
				isRun = !isRun;
				break;
			default:
				break;
			}
			
			
		} while (isRun);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();

	}

}
