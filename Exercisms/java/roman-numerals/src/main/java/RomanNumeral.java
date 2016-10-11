public class RomanNumeral {
	int input;
	String output = "";

	public RomanNumeral(int input){
		this.input = input;
	}

	public String getRomanNumeral(){
	/**
	 * not gross way
	 */
	int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	String[] numerals = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

	for (int i = 0; i < values.length; i++) {
		int quot = input / values[i];
		input = input % values[i];
		output += new String(new char[quot]).replace("\0", numerals[i]);
	}

	/**
	 * gross way
	 */
		// int quot = input / 1000;
		// for(int i = 0; i < quot; i++){
		// 	output += "M";
		// }
		// input = input % 1000;
		// quot = input / 900;
		// if (quot != 0){
		// 	output += "CM";
		// }
		// input = input % 900;
		// quot = input / 500;
		// if (quot != 0){
		// 	output += "D";
		// }
		// input = input % 500;
		// quot = input / 400;
		// if (quot != 0){
		// 	output += "CD";
		// }
		// input = input % 400;
		// quot = input / 100;
		// for(int i = 0; i < quot; i++){
		// 	output += "C";
		// }
		// input = input % 100;
		// quot = input / 90;
		// if (quot != 0){
		// 	output += "XC";
		// }
		// input = input % 90;
		// quot = input / 50;
		// if (quot != 0){
		// 	output += "L";
		// }
		// input = input % 50;
		// quot = input / 40;
		// if (quot != 0){
		// 	output += "XL";
		// }
		// input = input % 40;
		// quot = input / 10;
		// for(int i = 0; i < quot; i++){
		// 	output += "X";
		// }
		// input = input % 10;
		// quot = input / 9;
		// if (quot != 0){
		// 	output += "IX";
		// }
		// input = input % 9;
		// quot = input / 5;
		// if (quot != 0){
		// 	output += "V";
		// }
		// input = input % 5;
		// quot = input / 4;
		// if (quot != 0){
		// 	output += "IV";
		// }
		// input = input % 4;
		// quot = input / 1;
		// for(int i = 0; i < quot; i++){
		// 	output += "I";
		// }

		return output;
	}
}