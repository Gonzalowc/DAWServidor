package singleton_claves;

import java.util.HashMap;
import java.util.Map;

public class Cache_usuario {
	private static Map<String, String> cache = null;

	private Cache_usuario() {
	}

	private static void createInstance() {
		cache = new HashMap<String, String>();
	}

	public static Map<String, String> getInstance() {
		if (cache == null) {
			createInstance();
		}
		return cache;
	}
}
