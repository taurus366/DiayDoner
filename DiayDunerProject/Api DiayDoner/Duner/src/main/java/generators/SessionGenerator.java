package generators;

public class SessionGenerator {

	
	public String sessionGenerator() {

		long seed = System.currentTimeMillis();

		char[] entropy = toString().toCharArray();
		for (int i = 0; i < entropy.length; i++) {

			long update = ((byte) entropy[i]) << ((i % 8) * 8);
			seed ^= update;
		}

		String session_id = Integer.toString((int) seed);
		return session_id;
	}
}
