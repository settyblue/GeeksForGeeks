
/**
 * Card class
 */

/**
 * @author rakshith
 *
 */

public class Card {
	public resourcePool.cardType faceType;
	public resourcePool.cardValue faceValue;
	
	
	public Card(resourcePool.cardType type, resourcePool.cardValue value) {
		this.faceType = type;
		this.faceValue = value;
	}


	/**
	 * @return the faceType
	 */
	public resourcePool.cardType getFaceType() {
		return faceType;
	}
	
	
	/**
	 * @param faceType the faceType to set
	 */
	public void setFaceType(resourcePool.cardType faceType) {
		this.faceType = faceType;
	}
	
	
	/**
	 * @return the faceValue
	 */
	public resourcePool.cardValue getFaceValue() {
		return faceValue;
	}
	
	
	/**
	 * @param faceValue the faceValue to set
	 */
	public void setFaceValue(resourcePool.cardValue faceValue) {
		this.faceValue = faceValue;
	}
	
	public String toString(){
		return this.faceValue+" of "+this.faceType;
	}
}
