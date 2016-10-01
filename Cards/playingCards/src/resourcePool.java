/**
 * Data types are defined here.
 */

/**
 * @author rakshith
 *
 */
public class resourcePool {
	public static enum cardType{
		SPADE (1),
		HEART (2),
		DIAMOND (3),
		CLUB (4)
		;
		
		private final int typeCode;
		
		private cardType(int typeCode){
			this.typeCode = typeCode;
		}
	}
	
	public static enum cardValue{
		ACES (1),
		TWO (2),
		THREE (3),
		FOUR (4),
		FIVE (5),
		SIX (6),
		SEVEN (7),
		EIGHT (8),
		NINE (9),
		TEN (10),
		JACK (11),
		QUEEN (12),
		KING (13)
		;
		
		private final int valueCode;
		
		private cardValue(int valueCode){
			this.valueCode = valueCode;
		}
	}
}
