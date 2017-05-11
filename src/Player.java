import java.util.ArrayList;

/**
 * Player class for VirtualPets
 * @author Ollie Chick
 * @author Samuel Pell
 *
 */
public class Player implements Comparable<Player>{
	
	String name;
	int balance; // in dollars ($)
	ArrayList<Pet> petList;
	ArrayList<Food> foodStock;
	ArrayList<Toy> toyList;
	double score;

	public Player() {
		balance = 100;
		petList = new ArrayList<Pet>();
		foodStock = new ArrayList<Food>();
		toyList = new ArrayList<Toy>();
	}

	//Getters
	public String getName(){return name;}
	public int getBalance(){return balance;}
	public ArrayList<Pet> getPetList(){return petList;}
	public ArrayList<Food> getFoodStock(){return foodStock;}
	public ArrayList<Toy> getToyList(){return toyList;}
	public double getScore(){return score;}
	
	/**
	 * Sets the name of an player.
	 * @param name the name of the player
	 * @throws IllegalArgumentException if the name is null
	 */
	public void setName(String name){
		if(name == null){
			throw new IllegalArgumentException("Null name.");
		}else{this.name=name;}
	}
	
	/**
	 * Takes away the amount spent from the balance.
	 * @param amountSpent amount the user spends
	 * @throws IllegalArgumentException if you try to spend a negative amount
	 * @throws IllegalArgumentException if you try to spend more than you have
	 */
	public void spend(int amountSpent){
		if (amountSpent < 0){
			throw new IllegalArgumentException("Can't spend a negative amount.");
		}
		if (balance < amountSpent){
			throw new IllegalArgumentException("Can't spend more than you have.");
		}else{			
			balance -= amountSpent;
		}
	}
	
	/**
	 * Adds the amount earnt to the player's balance.
	 * @param amountEarnt amount the user earns
	 * @throws IllegalArgumentException if you try to earn a negative amount
	 */
	public void earn(int amountEarnt){
		if (amountEarnt < 0){
			throw new IllegalArgumentException("Can't earn a negative amount.");
		}
		balance += amountEarnt;
	}
	
	/**
	 * Calculate's the player's score
	 */
	public void calculateScore(){
		int score = 0;
		int petScore;
		
		int happiness;
		int fatigue;
		int health;
		int mischeviousness;
		int hunger;
		int percentBladderFull;
		double weightDifferential;
		boolean misbehaving;
		boolean sick;
		boolean dead;
		
		for(Pet currentPet: petList){
			petScore = 0;
			
			happiness = currentPet.getHappiness();
			fatigue = currentPet.getFatigue();
			health = currentPet.getHealth();
			mischeviousness = currentPet.getMischievousness();
			hunger = currentPet.getHunger();
			percentBladderFull = currentPet.getPercentBladderFull();
			weightDifferential = Math.abs(currentPet.getWeight() - currentPet.getDefaultWeight());
			misbehaving = currentPet.getIsMisbehaving();
			sick = currentPet.getIsSick();
			dead = currentPet.getIsDead();
			
			//make bad attributes the inverse of what they were
			fatigue = 100 - fatigue;
			mischeviousness = 100 - mischeviousness;
			percentBladderFull = 100 - percentBladderFull;
			hunger = 100 - hunger;
			weightDifferential = 100 - weightDifferential; //penalise for fat and skinny animals
			
			petScore += (happiness + fatigue + mischeviousness + hunger + percentBladderFull + weightDifferential + health) ;
			
			if (sick){
				petScore -= 150; 
			}
			
			if (misbehaving){
				petScore -= 50;
			}
			
			if(dead){ //if the pet is dead player doesn't get any points for it.
				petScore = 0;
			}
			
			score += petScore;
		}
		
		this.score += score / petList.size();
	}
	
	/**
	 * Adds a toy to the player's inventory
	 * @param toy Toy to be added.
	 */
	public void addToy(Toy toy){
		toyList.add(toy);
	}
	
	/**
	 * Adds a food to the player's inventory
	 * @param food Food to be added.
	 */
	public void addFood(Food food){
		foodStock.add(food);
	}
	
	/**
	 * Compares this player with another to determine which of them has the higher score
	 * Returns 1 if the other player has a higher score
	 * Returns 0 if the other player has the same score
	 * Returns -1 if the other player has a lower score
	 * @param otherPlayer player to compare to this player
	 * @return whether the player has a higher or lower score
	 */
	public int compareTo(Player otherPlayer){
		if (score < otherPlayer.getScore())
			return 1;
		else if (score > otherPlayer.getScore())
			return -1;
		else
			return 0;
	}

}
