import java.util.*;

public class Robot {
	private String robotName;

	public Robot() {
		reset();
	}

	public String getName() {
		return this.robotName;
	}

	public void reset(){
		final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		final String num = "0123456789";
		Set<String> usedNames = new HashSet<>();
		Random rnd = new Random();
		Boolean unoriginalName = false;
		StringBuilder sb = new StringBuilder(5);

		do {
			for (int i = 0; i < 2; i++){
				sb.append(AB.charAt(rnd.nextInt(AB.length())));
			}
			for (int i = 0; i < 3; i++){
				sb.append(num.charAt(rnd.nextInt(num.length())));
			}

			robotName = sb.toString();

			if(usedNames.contains(robotName)){
				unoriginalName = true;
			} else {
				unoriginalName = false;
			}
		} while (unoriginalName);

		usedNames.add(robotName);
		this.robotName = robotName;
	}
}