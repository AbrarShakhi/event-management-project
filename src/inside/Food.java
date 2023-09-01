package inside;

import java.util.HashMap;

public class Food {
	private HashMap<Boolean, Integer> rice;
	private HashMap<Boolean, Integer> beef;
	private HashMap<Boolean, Integer> chickenLegPies;
	private HashMap<Boolean, Integer> coke;
	private HashMap<Boolean, Integer> soup;
	private HashMap<Boolean, Integer> hilshaFish;
	private HashMap<Boolean, Integer> dirthCake;
	private HashMap<Boolean, Integer> basicDinner;
	private HashMap<Boolean, Integer> basicLunch;
	private HashMap<Boolean, Integer> basicBreakfast;
	private HashMap<Boolean, Integer> biriani;
	private HashMap<Boolean, Integer> kacchi;
	private HashMap<Boolean, Integer> chingriMalaiCurry;
	private HashMap<Boolean, Integer> daal;
	private HashMap<Boolean, Integer> mutton;

	public Food() {
		this.rice = new HashMap<>();
		this.beef = new HashMap<>();
		this.chickenLegPies = new HashMap<>();
		this.coke = new HashMap<>();
		this.soup = new HashMap<>();
		this.hilshaFish = new HashMap<>();
		this.dirthCake = new HashMap<>();
		this.basicDinner = new HashMap<>();
		this.basicLunch = new HashMap<>();
		this.basicBreakfast = new HashMap<>();
		this.biriani = new HashMap<>();
		this.kacchi = new HashMap<>();
		this.chingriMalaiCurry = new HashMap<>();
		this.daal = new HashMap<>();
		this.mutton = new HashMap<>();
	}

	public HashMap<Boolean, Integer> getRice() {
		return rice;
	}

	public void setRice(HashMap<Boolean, Integer> rice) {
		this.rice = rice;
	}

	public HashMap<Boolean, Integer> getBeef() {
		return beef;
	}

	public void setBeef(HashMap<Boolean, Integer> beef) {
		this.beef = beef;
	}

	public HashMap<Boolean, Integer> getChickenLegPies() {
		return chickenLegPies;
	}

	public void setChickenLegPies(HashMap<Boolean, Integer> chickenLegPies) {
		this.chickenLegPies = chickenLegPies;
	}

	public HashMap<Boolean, Integer> getCoke() {
		return coke;
	}

	public void setCoke(HashMap<Boolean, Integer> coke) {
		this.coke = coke;
	}

	public HashMap<Boolean, Integer> getSoup() {
		return soup;
	}

	public void setSoup(HashMap<Boolean, Integer> soup) {
		this.soup = soup;
	}

	public HashMap<Boolean, Integer> getHilshaFish() {
		return hilshaFish;
	}

	public void setHilshaFish(HashMap<Boolean, Integer> hilshaFish) {
		this.hilshaFish = hilshaFish;
	}

	public HashMap<Boolean, Integer> getDirthCake() {
		return dirthCake;
	}

	public void setDirthCake(HashMap<Boolean, Integer> dirthCake) {
		this.dirthCake = dirthCake;
	}

	public HashMap<Boolean, Integer> getBasicDinner() {
		return basicDinner;
	}

	public void setBasicDinner(HashMap<Boolean, Integer> basicDinner) {
		this.basicDinner = basicDinner;
	}

	public HashMap<Boolean, Integer> getBasicLunch() {
		return basicLunch;
	}

	public void setBasicLunch(HashMap<Boolean, Integer> basicLunch) {
		this.basicLunch = basicLunch;
	}

	public HashMap<Boolean, Integer> getBasicBreakfast() {
		return basicBreakfast;
	}

	public void setBasicBreakfast(HashMap<Boolean, Integer> basicBreakfast) {
		this.basicBreakfast = basicBreakfast;
	}

	public HashMap<Boolean, Integer> getBiriani() {
		return biriani;
	}

	public void setBiriani(HashMap<Boolean, Integer> biriani) {
		this.biriani = biriani;
	}

	public HashMap<Boolean, Integer> getKacchi() {
		return kacchi;
	}

	public void setKacchi(HashMap<Boolean, Integer> kacchi) {
		this.kacchi = kacchi;
	}

	public HashMap<Boolean, Integer> getChingriMalaiCurry() {
		return chingriMalaiCurry;
	}

	public void setChingriMalaiCurry(HashMap<Boolean, Integer> chingriMalaiCurry) {
		this.chingriMalaiCurry = chingriMalaiCurry;
	}

	public HashMap<Boolean, Integer> getDaal() {
		return daal;
	}

	public void setDaal(HashMap<Boolean, Integer> daal) {
		this.daal = daal;
	}

	public HashMap<Boolean, Integer> getMutton() {
		return mutton;
	}

	public void setMutton(HashMap<Boolean, Integer> mutton) {
		this.mutton = mutton;
	}
}
