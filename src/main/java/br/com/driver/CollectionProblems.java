package br.com.driver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionProblems {
	
	public static void main(String[] args) {
		//Collections not are threadSafe
		//Map<String, String> strMap = new HashMap<>();
		
		//ConcurrentCollections is are threadSafe, avoid ConcurrentModificationException
		Map<String, String> strMap = new ConcurrentHashMap<>();
		
		strMap.put("Porsche", "911");
		strMap.put("Ferrari", "California");
		
		for(String k : strMap.keySet()) {
			System.out.println(k + " is a model of " + strMap.get(k));
			strMap.remove(k);
		}
	}

}
