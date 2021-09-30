package singleton_claves;

import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Map<String,String> cache = Cache_usuario.getInstance();
		cache.put("Gonzalowc", "1234");
		System.out.println(Cache_usuario.getInstance());
	}
}
